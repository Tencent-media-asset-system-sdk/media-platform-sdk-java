package com.tencent.aimedia;

import java.util.Map;

import org.eclipse.jetty.util.ajax.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.baidu.bjf.remoting.protobuf.command.Main;
import com.tencent.trpc.container.config.ApplicationConfigParser;
import com.tencent.trpc.container.config.YamlUtils;
import com.tencent.trpc.container.config.system.Environment;
import com.tencent.trpc.container.config.system.parser.PropertySourceParser;
import com.tencent.trpc.container.config.yaml.BackendConfigParser;
import com.tencent.trpc.container.config.yaml.ClientConfigParser;
import com.tencent.trpc.container.config.yaml.GlobalConfigParser;
import com.tencent.trpc.container.config.yaml.PluginConfigParser;
import com.tencent.trpc.container.config.yaml.ServerConfigParser;
import com.tencent.trpc.core.common.ConfigManager;
import com.tencent.trpc.core.common.Constants;
import com.tencent.trpc.core.common.TRpcSystemProperties;
import com.tencent.trpc.core.common.config.PluginConfig;
import com.tencent.trpc.core.common.config.constant.ConfigConstants;
import com.tencent.trpc.core.extension.ExtensionLoader;
import com.tencent.trpc.core.rpc.TRpcProxy;
import com.tencent.trpc.core.rpc.spi.RpcClientFactory;
import com.tencent.trpc.server.container.TRPC;

public class AIMediaProxyClient {

	private static ConfigManager doParse(Map<String, Object> yamlMapConfig) {
        ConfigManager configManager = ConfigManager.getInstance();
        YamlUtils yamlUtils = new YamlUtils("Label[]");
        // parse global config
        configManager.setGlobalConfig(GlobalConfigParser.parseGlobalConfig(yamlUtils.getMap(yamlMapConfig,
                ConfigConstants.GLOBAL)));
        // parse plugins config
        Map<Class<?>, Map<String, PluginConfig>> pluginConfigs = PluginConfigParser.parsePlugins(
                yamlUtils.getMap(yamlMapConfig, ConfigConstants.PLUGINS));
        configManager.getPluginConfigMap().putAll(pluginConfigs);
        // parse server config
        configManager.setServerConfig(ServerConfigParser.parseServerConfig(yamlUtils.getMap(yamlMapConfig,
                ConfigConstants.SERVER), pluginConfigs));
        // parse client config
        configManager.setClientConfig(ClientConfigParser.parseClientConfig(yamlUtils.getMap(yamlMapConfig,
                ConfigConstants.CLIENT)));
        return configManager;
	}
	
	public static <T> T newProxyClient(Class<T> clazz) {
//		TRpcSystemProperties.setProperties(TRpcSystemProperties.CONFIG_PATH,
//				"config.yaml");
		Map<String, Object> yaml = new HashMap<String, Object>();
		Map<String, Object> server = new HashMap<String, Object>();
		Map<String, Object> client = new HashMap<String, Object>();
		Map<String, Object> service = new HashMap<String, Object>();
		
		
		server.put("app", "TestApp");
		server.put("server", "TestServer");
		server.put("local_ip", "127.0.0.1");
		
		service.put("name", "com.tencent.aimedia");
		service.put("naming_url", "ip://127.0.0.1:80");
		service.put("network", "tcp");
		service.put("protocol", "http");
		service.put("transport", "jetty");
		
		List<Map<String, Object>> services = new ArrayList<Map<String, Object>> ();
		services.add(service);

		client.put("service", services);
		
		yaml.put("server", server);
		yaml.put("client", client);
		
//		System.out.println(JSON.toString(yaml));
	
		ConfigManager configManager = doParse(yaml);
        configManager.start();
        
		ExtensionLoader<RpcClientFactory>  loader = ExtensionLoader.getExtensionLoader(RpcClientFactory.class);
		loader.addExtension("http", TIHttpClientFactory.class);
        T proxy = TRpcProxy.getProxy("com.tencent.aimedia", clazz);
        
        return proxy;
	}
}
