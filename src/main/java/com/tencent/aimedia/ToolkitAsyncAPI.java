package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcContext;
import com.tencent.trpc.core.rpc.anno.TRpcMethod;
import com.tencent.trpc.core.rpc.anno.TRpcService;
import java.util.concurrent.CompletionStage;

import com.tencent.aimedia.ToolkitProtocol.DescribeToolkitsRequest;
import com.tencent.aimedia.ToolkitProtocol.DescribeToolkitsResponse;

/**
 * Generated by trpc-java-codegen
 */
@TRpcService(name = "trpc.media.toolkit.Toolkit")
public interface ToolkitAsyncAPI {

    /**
     * DescribeToolkits
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeToolkitsResponse}
     */
    @TRpcMethod(name = "DescribeToolkits")
    CompletionStage<DescribeToolkitsResponse> describeToolkits(RpcContext context, DescribeToolkitsRequest request);
}