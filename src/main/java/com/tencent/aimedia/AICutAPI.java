package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcContext;
import com.tencent.trpc.core.rpc.anno.TRpcMethod;
import com.tencent.trpc.core.rpc.anno.TRpcService;

import com.tencent.aimedia.VideoStructureProtocol.CreateVideoStructureTaskRequest;
import com.tencent.aimedia.VideoStructureProtocol.CreateVideoStructureTaskResponse;
import com.tencent.aimedia.VideoStructureProtocol.DescribeAICutTaskDataRequest;
import com.tencent.aimedia.VideoStructureProtocol.DescribeAICutTaskDataResponse;

/**
 * Generated by trpc-java-codegen
 */
@TRpcService(name = "trpc.media.videostructure.AICut")
public interface AICutAPI {

    /**
     * CreateAICutTask
     *
     * @param context context
     * @param request request
     * @return {@link CreateVideoStructureTaskResponse}
     */
    @TRpcMethod(name = "CreateAICutTask")
    CreateVideoStructureTaskResponse createAICutTask(RpcContext context, CreateVideoStructureTaskRequest request);

    /**
     * DescribeAICutTaskData
     *
     * @param context context
     * @param request request
     * @return {@link DescribeAICutTaskDataResponse}
     */
    @TRpcMethod(name = "DescribeAICutTaskData")
    DescribeAICutTaskDataResponse describeAICutTaskData(RpcContext context, DescribeAICutTaskDataRequest request);
}