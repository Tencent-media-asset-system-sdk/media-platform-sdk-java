package com.tencent.aimedia;

import com.tencent.trpc.core.common.config.ProtocolConfig;
import com.tencent.trpc.core.exception.TRpcException;
import com.tencent.trpc.core.extension.Extension;
import com.tencent.trpc.core.extension.Extensible;
import com.tencent.trpc.core.rpc.RpcClient;
import com.tencent.trpc.core.rpc.spi.RpcClientFactory;

@Extensible("http")
@Extension("http")
public class TIHttpClientFactory implements RpcClientFactory {

    @Override
    public RpcClient createRpcClient(ProtocolConfig config) throws TRpcException {
    	return new TIHttpClient(config);
    }
}