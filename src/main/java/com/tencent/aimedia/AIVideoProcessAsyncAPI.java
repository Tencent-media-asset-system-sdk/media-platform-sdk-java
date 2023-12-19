package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcContext;
import com.tencent.trpc.core.rpc.anno.TRpcMethod;
import com.tencent.trpc.core.rpc.anno.TRpcService;
import java.util.concurrent.CompletionStage;

import com.tencent.aimedia.AIVideoProcessProtocol.CreateAIVideoProcessTaskRequest;
import com.tencent.aimedia.AIVideoProcessProtocol.CreateAIVideoProcessResponse;
import com.tencent.aimedia.AIVideoProcessProtocol.DescribeAIVideoProcessDetailRequest;
import com.tencent.aimedia.AIVideoProcessProtocol.DescribeAIVideoProcessDetailResponse;
import com.tencent.aimedia.AIVideoProcessProtocol.DescribeAIVideoProcessTasksRequest;
import com.tencent.aimedia.AIVideoProcessProtocol.DescribeAIVideoProcessTasksResponse;
import com.tencent.aimedia.AIVideoProcessProtocol.UpdateAIVideoProcessTaskRequest;
import com.tencent.aimedia.AIVideoProcessProtocol.UpdateAIVideoProcessResponse;
import com.tencent.aimedia.AIVideoProcessProtocol.DescribeAIVideoProcessConfigRequest;
import com.tencent.aimedia.AIVideoProcessProtocol.DescribeAIVideoProcessConfigResponse;
import com.tencent.aimedia.AIVideoProcessProtocol.CreateM3UIndexTaskRequest;
import com.tencent.aimedia.AIVideoProcessProtocol.CreateM3UIndexTaskResponse;
import com.tencent.aimedia.AIVideoProcessProtocol.DescribeM3UIndexDetailRequest;
import com.tencent.aimedia.AIVideoProcessProtocol.DescribeM3UIndexDetailResponse;
import com.tencent.aimedia.AIVideoProcessProtocol.StopAIVideoProcessTaskReq;
import com.tencent.aimedia.AIVideoProcessProtocol.StopAIVideoProcessTaskRsp;
import com.tencent.aimedia.AIVideoProcessProtocol.RemoveAIVideoProcessTaskReq;
import com.tencent.aimedia.AIVideoProcessProtocol.RemoveAIVideoProcessTaskRsp;

/**
 * Generated by trpc-java-codegen
 */
@TRpcService(name = "trpc.media.aivideoprocess.AIVideoProcess")
public interface AIVideoProcessAsyncAPI {

    /**
     * CreateAIVideoProcessTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CreateAIVideoProcessResponse}
     */
    @TRpcMethod(name = "CreateAIVideoProcessTask")
    CompletionStage<CreateAIVideoProcessResponse> createAIVideoProcessTask(RpcContext context, CreateAIVideoProcessTaskRequest request);

    /**
     * DescribeAIVideoProcessDetail
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeAIVideoProcessDetailResponse}
     */
    @TRpcMethod(name = "DescribeAIVideoProcessDetail")
    CompletionStage<DescribeAIVideoProcessDetailResponse> describeAIVideoProcessDetail(RpcContext context, DescribeAIVideoProcessDetailRequest request);

    /**
     * DescribeAIVideoProcessTasks
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeAIVideoProcessTasksResponse}
     */
    @TRpcMethod(name = "DescribeAIVideoProcessTasks")
    CompletionStage<DescribeAIVideoProcessTasksResponse> describeAIVideoProcessTasks(RpcContext context, DescribeAIVideoProcessTasksRequest request);

    /**
     * UpdateAIVideoProcessTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link UpdateAIVideoProcessResponse}
     */
    @TRpcMethod(name = "UpdateAIVideoProcessTask")
    CompletionStage<UpdateAIVideoProcessResponse> updateAIVideoProcessTask(RpcContext context, UpdateAIVideoProcessTaskRequest request);

    /**
     * DescribeAIVideoProcessConfig
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeAIVideoProcessConfigResponse}
     */
    @TRpcMethod(name = "DescribeAIVideoProcessConfig")
    CompletionStage<DescribeAIVideoProcessConfigResponse> describeAIVideoProcessConfig(RpcContext context, DescribeAIVideoProcessConfigRequest request);

    /**
     * CreateVideoCropTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CreateAIVideoProcessResponse}
     */
    @TRpcMethod(name = "CreateVideoCropTask")
    CompletionStage<CreateAIVideoProcessResponse> createVideoCropTask(RpcContext context, CreateAIVideoProcessTaskRequest request);

    /**
     * UpdateVideoCropTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link UpdateAIVideoProcessResponse}
     */
    @TRpcMethod(name = "UpdateVideoCropTask")
    CompletionStage<UpdateAIVideoProcessResponse> updateVideoCropTask(RpcContext context, UpdateAIVideoProcessTaskRequest request);

    /**
     * CreateM3UIndexTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CreateM3UIndexTaskResponse}
     */
    @TRpcMethod(name = "CreateM3UIndexTask")
    CompletionStage<CreateM3UIndexTaskResponse> createM3UIndexTask(RpcContext context, CreateM3UIndexTaskRequest request);

    /**
     * DescribeM3UIndexDetail
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeM3UIndexDetailResponse}
     */
    @TRpcMethod(name = "DescribeM3UIndexDetail")
    CompletionStage<DescribeM3UIndexDetailResponse> describeM3UIndexDetail(RpcContext context, DescribeM3UIndexDetailRequest request);

    /**
     * StopAIVideoProcessTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link StopAIVideoProcessTaskRsp}
     */
    @TRpcMethod(name = "StopAIVideoProcessTask")
    CompletionStage<StopAIVideoProcessTaskRsp> stopAIVideoProcessTask(RpcContext context, StopAIVideoProcessTaskReq request);

    /**
     * RemoveAIVideoProcessTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RemoveAIVideoProcessTaskRsp}
     */
    @TRpcMethod(name = "RemoveAIVideoProcessTask")
    CompletionStage<RemoveAIVideoProcessTaskRsp> removeAIVideoProcessTask(RpcContext context, RemoveAIVideoProcessTaskReq request);
}