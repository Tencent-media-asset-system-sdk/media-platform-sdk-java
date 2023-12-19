package com.tencent.aimedia;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.lang.reflect.Type;
import java.lang.reflect.Method;
import com.google.protobuf.Message;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.WildcardType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tencent.trpc.core.utils.JsonUtils;
import com.tencent.trpc.core.utils.ProtoJsonConverter;



import org.apache.commons.httpclient.HttpException;

import com.tencent.trpc.core.common.config.ConsumerConfig;
import com.tencent.trpc.core.common.config.ProtocolConfig;
import com.tencent.trpc.core.rpc.ConsumerInvoker;
import com.tencent.trpc.core.rpc.Request;
import com.tencent.trpc.core.rpc.Response;
import com.tencent.trpc.core.rpc.RpcInvocation;
import com.tencent.trpc.core.utils.RpcUtils;

/**
 * HTTP protocol client invoker.
 */
public class TIConsumerInvoker<T> implements ConsumerInvoker<T>  {
	private static final String defaultversion = "2022-03-02";
	private static final String defaultservice = "fusion-media-service";
	private static final String defaultgateway = "gateway";
	private static final Map<String, String> versionMap = new HashMap<String, String>();
	private static final Map<String, String> serviceMap = new HashMap<String, String>();
	private static final Map<String, String> gatewayMap = new HashMap<String, String>();
	
    protected final ConsumerConfig<T> config;
    /**
     * Protocol configuration
     */
    protected final ProtocolConfig protocolConfig;

    
    public TIConsumerInvoker(ConsumerConfig<T> config, ProtocolConfig protocolConfig) {
        this.config = config;
        this.protocolConfig = protocolConfig;
    }
    
    protected Object decodeFromJson(Type returnType, String jsonStr) throws Exception, ResponseErrorException {
        // generic deserialization
        boolean isGeneric = returnType instanceof ParameterizedType || returnType instanceof TypeVariable
                || returnType instanceof GenericArrayType
                || returnType instanceof WildcardType;

        if (isGeneric) {
            return JsonUtils.fromBytes(jsonStr, new TypeReference<Object>() {
                @Override
                public Type getType() {
                    return returnType;
                }
            });
        }
        byte[] utf8Bytes = jsonStr.getBytes("ISO-8859-1");
        jsonStr = new String(utf8Bytes, "UTF-8");
        Class<?> type = (Class<?>) returnType;
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonStr);
        String content = rootNode.get("Response").toString();
        if (rootNode.get("Response").has("Error")) {
        	JsonNode err = rootNode.get("Response").get("Error");
        	throw new ResponseErrorException(err.get("Code").asText(), err.get("Message").asText(),
        			rootNode.get("Response").get("RequestId").asText());
        }
        if (Message.class.isAssignableFrom(type)) {
            Method getDefaultInstance = type.getDeclaredMethod("getDefaultInstance");
            Message pbMsg = (Message) getDefaultInstance.invoke(null);
            return ProtoJsonConverter.jsonToMessage(content, pbMsg);
        } else {
            return JsonUtils.fromJson(content, type);
        }
    }

    protected String encodeToJson(Request request, int businessId, int projectId) {
        RpcInvocation invocation = request.getInvocation();
        Object[] arguments = invocation.getArguments();
        if (arguments == null || arguments.length <= 0) {
            return null;
        }
        Object param = arguments[0];

        Type[] paramsTypes = invocation.getRpcMethodInfo().getParamsTypes();
        if (paramsTypes.length <= 1) {
            return null;
        }
        Class<?> reqType = (Class<?>) paramsTypes[1];

        if (Message.class.isAssignableFrom(reqType)) {
            Map<String, Object> jsonData = ProtoJsonConverter.messageToMap((Message) param);
            jsonData.put("TiBusinessId", businessId);
            jsonData.put("TIProjectId", projectId);
            return JsonUtils.toJson(jsonData);
        } else {
            return JsonUtils.toJson(param);
        }
    }
    
    @Override
    public CompletionStage<Response> invoke(Request request) {
    	String action = request.getInvocation().getRpcMethodName();
		String service = defaultservice;
		String version = defaultversion;
		String gateway = defaultgateway;
		if (serviceMap.containsKey(action)) {
			service = serviceMap.get(action);
		}
		if (versionMap.containsKey(action)) {
			version = versionMap.get(action);
		}
		if (gatewayMap.containsKey(action)) {
			gateway = gatewayMap.get(action);
		}
		String contentType = "application/json";
		String httpMethod = "POST";
		TICertificate cert = (TICertificate) (request.getContext());
		String host = cert.getHost();
		String secretId = cert.getSecretId();
		String secretKey = cert.getSecretKey();
		String body = encodeToJson(request, cert.getTIBusinessId(), cert.getTIProjectId());
		System.out.println(body);
		TiSign ts = new TiSign(host, action, version, service, contentType, httpMethod, secretId, secretKey);
		HashMap<String, String> httpHeaderMap = new HashMap<String, String>();
		try {
			ts.CreateHeaderWithSignature(httpHeaderMap);
		} catch (Exception e) {
		}
		try {
			String response = HttpClientUtil.doPost(httpHeaderMap, "http://" + host + "/" + gateway, body);
			Object value = decodeFromJson(request.getInvocation().getRpcMethodInfo().getActualReturnType(), response);
			return CompletableFuture.completedFuture(RpcUtils.newResponse(request, value, null));
		} catch (HttpException e) {
			return CompletableFuture.completedFuture(RpcUtils.newResponse(request, null, e));
		} catch (IOException e) {
			return CompletableFuture.completedFuture(RpcUtils.newResponse(request, null, e));
		} catch (Exception e) {
			return CompletableFuture.completedFuture(RpcUtils.newResponse(request, null, e));
		}
		
    }

	@Override
	public Class<T> getInterface() {
		// TODO Auto-generated method stub
		return config.getServiceInterface();
	}

	@Override
	public ConsumerConfig<T> getConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public ProtocolConfig getProtocolConfig() {
		// TODO Auto-generated method stub
		return protocolConfig;
	}
}