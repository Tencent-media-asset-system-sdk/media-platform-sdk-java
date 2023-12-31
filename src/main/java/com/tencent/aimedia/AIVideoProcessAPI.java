package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcContext;
import com.tencent.trpc.core.rpc.anno.TRpcMethod;
import com.tencent.trpc.core.rpc.anno.TRpcService;

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
public interface AIVideoProcessAPI {

    /**
     * CreateAIVideoProcessTask
     *
     * @param context context
     * @param request request
     * @return {@link CreateAIVideoProcessResponse}
     */
    @TRpcMethod(name = "CreateAIVideoProcessTask")
    CreateAIVideoProcessResponse createAIVideoProcessTask(RpcContext context, CreateAIVideoProcessTaskRequest request);

    /**
     * DescribeAIVideoProcessDetail
     *
     * @param context context
     * @param request request
     * @return {@link DescribeAIVideoProcessDetailResponse}
     */
    @TRpcMethod(name = "DescribeAIVideoProcessDetail")
    DescribeAIVideoProcessDetailResponse describeAIVideoProcessDetail(RpcContext context, DescribeAIVideoProcessDetailRequest request);

    /**
     * DescribeAIVideoProcessTasks
     *
     * @param context context
     * @param request request
     * @return {@link DescribeAIVideoProcessTasksResponse}
     */
    @TRpcMethod(name = "DescribeAIVideoProcessTasks")
    DescribeAIVideoProcessTasksResponse describeAIVideoProcessTasks(RpcContext context, DescribeAIVideoProcessTasksRequest request);

    /**
     * UpdateAIVideoProcessTask
     *
     * @param context context
     * @param request request
     * @return {@link UpdateAIVideoProcessResponse}
     */
    @TRpcMethod(name = "UpdateAIVideoProcessTask")
    UpdateAIVideoProcessResponse updateAIVideoProcessTask(RpcContext context, UpdateAIVideoProcessTaskRequest request);

    /**
     * DescribeAIVideoProcessConfig
     *
     * @param context context
     * @param request request
     * @return {@link DescribeAIVideoProcessConfigResponse}
     */
    @TRpcMethod(name = "DescribeAIVideoProcessConfig")
    DescribeAIVideoProcessConfigResponse describeAIVideoProcessConfig(RpcContext context, DescribeAIVideoProcessConfigRequest request);

    /**
     * CreateVideoCropTask
     *
     * @param context context
     * @param request request
     * @return {@link CreateAIVideoProcessResponse}
     */
    @TRpcMethod(name = "CreateVideoCropTask")
    CreateAIVideoProcessResponse createVideoCropTask(RpcContext context, CreateAIVideoProcessTaskRequest request);

    /**
     * UpdateVideoCropTask
     *
     * @param context context
     * @param request request
     * @return {@link UpdateAIVideoProcessResponse}
     */
    @TRpcMethod(name = "UpdateVideoCropTask")
    UpdateAIVideoProcessResponse updateVideoCropTask(RpcContext context, UpdateAIVideoProcessTaskRequest request);

    /**
     * CreateM3UIndexTask
     *
     * @param context context
     * @param request request
     * @return {@link CreateM3UIndexTaskResponse}
     */
    @TRpcMethod(name = "CreateM3UIndexTask")
    CreateM3UIndexTaskResponse createM3UIndexTask(RpcContext context, CreateM3UIndexTaskRequest request);

    /**
     * DescribeM3UIndexDetail
     *
     * @param context context
     * @param request request
     * @return {@link DescribeM3UIndexDetailResponse}
     */
    @TRpcMethod(name = "DescribeM3UIndexDetail")
    DescribeM3UIndexDetailResponse describeM3UIndexDetail(RpcContext context, DescribeM3UIndexDetailRequest request);

    /**
     * StopAIVideoProcessTask
     *
     * @param context context
     * @param request request
     * @return {@link StopAIVideoProcessTaskRsp}
     */
    @TRpcMethod(name = "StopAIVideoProcessTask")
    StopAIVideoProcessTaskRsp stopAIVideoProcessTask(RpcContext context, StopAIVideoProcessTaskReq request);

    /**
     * RemoveAIVideoProcessTask
     *
     * @param context context
     * @param request request
     * @return {@link RemoveAIVideoProcessTaskRsp}
     */
    @TRpcMethod(name = "RemoveAIVideoProcessTask")
    RemoveAIVideoProcessTaskRsp removeAIVideoProcessTask(RpcContext context, RemoveAIVideoProcessTaskReq request);
}