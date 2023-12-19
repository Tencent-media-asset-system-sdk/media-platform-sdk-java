package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcContext;
import com.tencent.trpc.core.rpc.anno.TRpcMethod;
import com.tencent.trpc.core.rpc.anno.TRpcService;
import java.util.concurrent.CompletionStage;

import com.tencent.aimedia.TaskProtocol.DescribeSupportedMediaTypesRequest;
import com.tencent.aimedia.TaskProtocol.DescribeSupportedMediaTypesResponse;
import com.tencent.aimedia.TaskProtocol.CreateTaskRequest;
import com.tencent.aimedia.TaskProtocol.CreateTaskResponse;
import com.tencent.aimedia.TaskProtocol.DescribeTaskRequest;
import com.tencent.aimedia.TaskProtocol.DescribeTaskResponse;
import com.tencent.aimedia.TaskProtocol.DescribeTasksRequest;
import com.tencent.aimedia.TaskProtocol.DescribeTasksResponse;
import com.tencent.aimedia.TaskProtocol.StartTaskRequest;
import com.tencent.aimedia.TaskProtocol.StartTaskResponse;
import com.tencent.aimedia.TaskProtocol.StartTasksRequest;
import com.tencent.aimedia.TaskProtocol.StartTasksResponse;
import com.tencent.aimedia.TaskProtocol.StopTaskRequest;
import com.tencent.aimedia.TaskProtocol.StopTaskResponse;
import com.tencent.aimedia.TaskProtocol.StopTasksRequest;
import com.tencent.aimedia.TaskProtocol.StopTasksResponse;
import com.tencent.aimedia.TaskProtocol.DeleteTaskRequest;
import com.tencent.aimedia.TaskProtocol.DeleteTaskResponse;
import com.tencent.aimedia.TaskProtocol.TopTaskRequest;
import com.tencent.aimedia.TaskProtocol.TopTaskResponse;
import com.tencent.aimedia.TaskProtocol.DescribeTaskDetailRequest;
import com.tencent.aimedia.TaskProtocol.DescribeTaskDetailResponse;
import com.tencent.aimedia.TaskProtocol.ModifyTaskDataRequest;
import com.tencent.aimedia.TaskProtocol.ModifyTaskDataResponse;
import com.tencent.aimedia.TaskProtocol.DescribeTaskListFileRequest;
import com.tencent.aimedia.TaskProtocol.DescribeTaskListFileResponse;
import com.tencent.aimedia.TaskProtocol.DescribeStatisticsRequest;
import com.tencent.aimedia.TaskProtocol.DescribeStatisticsResponse;
import com.tencent.aimedia.TaskProtocol.DescribeWorkflowProgressRequest;
import com.tencent.aimedia.TaskProtocol.DescribeWorkflowProgressResponse;
import com.tencent.aimedia.TaskProtocol.CheckWorkflowTemplateRequest;
import com.tencent.aimedia.TaskProtocol.CheckWorkflowTemplateResponse;
import com.tencent.aimedia.TaskProtocol.DescribeTagAnalyseInputRequest;
import com.tencent.aimedia.TaskProtocol.DescribeTagAnalyseInputResponse;

/**
 * Generated by trpc-java-codegen
 */
@TRpcService(name = "trpc.media.task.Task")
public interface TaskAsyncAPI {

    /**
     * DescribeSupportedMediaTypes
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeSupportedMediaTypesResponse}
     */
    @TRpcMethod(name = "DescribeSupportedMediaTypes")
    CompletionStage<DescribeSupportedMediaTypesResponse> describeSupportedMediaTypes(RpcContext context, DescribeSupportedMediaTypesRequest request);

    /**
     * CreateTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CreateTaskResponse}
     */
    @TRpcMethod(name = "CreateTask")
    CompletionStage<CreateTaskResponse> createTask(RpcContext context, CreateTaskRequest request);

    /**
     * DescribeTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeTaskResponse}
     */
    @TRpcMethod(name = "DescribeTask")
    CompletionStage<DescribeTaskResponse> describeTask(RpcContext context, DescribeTaskRequest request);

    /**
     * DescribeTasks
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeTasksResponse}
     */
    @TRpcMethod(name = "DescribeTasks")
    CompletionStage<DescribeTasksResponse> describeTasks(RpcContext context, DescribeTasksRequest request);

    /**
     * StartTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link StartTaskResponse}
     */
    @TRpcMethod(name = "StartTask")
    CompletionStage<StartTaskResponse> startTask(RpcContext context, StartTaskRequest request);

    /**
     * StartTasks
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link StartTasksResponse}
     */
    @TRpcMethod(name = "StartTasks")
    CompletionStage<StartTasksResponse> startTasks(RpcContext context, StartTasksRequest request);

    /**
     * StopTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link StopTaskResponse}
     */
    @TRpcMethod(name = "StopTask")
    CompletionStage<StopTaskResponse> stopTask(RpcContext context, StopTaskRequest request);

    /**
     * StopTasks
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link StopTasksResponse}
     */
    @TRpcMethod(name = "StopTasks")
    CompletionStage<StopTasksResponse> stopTasks(RpcContext context, StopTasksRequest request);

    /**
     * DeleteTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DeleteTaskResponse}
     */
    @TRpcMethod(name = "DeleteTask")
    CompletionStage<DeleteTaskResponse> deleteTask(RpcContext context, DeleteTaskRequest request);

    /**
     * TopTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link TopTaskResponse}
     */
    @TRpcMethod(name = "TopTask")
    CompletionStage<TopTaskResponse> topTask(RpcContext context, TopTaskRequest request);

    /**
     * DescribeTaskDetail
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeTaskDetailResponse}
     */
    @TRpcMethod(name = "DescribeTaskDetail")
    CompletionStage<DescribeTaskDetailResponse> describeTaskDetail(RpcContext context, DescribeTaskDetailRequest request);

    /**
     * ModifyTaskData
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link ModifyTaskDataResponse}
     */
    @TRpcMethod(name = "ModifyTaskData")
    CompletionStage<ModifyTaskDataResponse> modifyTaskData(RpcContext context, ModifyTaskDataRequest request);

    /**
     * DescribeTaskListFile
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeTaskListFileResponse}
     */
    @TRpcMethod(name = "DescribeTaskListFile")
    CompletionStage<DescribeTaskListFileResponse> describeTaskListFile(RpcContext context, DescribeTaskListFileRequest request);

    /**
     * DescribeStatistics
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeStatisticsResponse}
     */
    @TRpcMethod(name = "DescribeStatistics")
    CompletionStage<DescribeStatisticsResponse> describeStatistics(RpcContext context, DescribeStatisticsRequest request);

    /**
     * DescribeWorkflowProgress
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeWorkflowProgressResponse}
     */
    @TRpcMethod(name = "DescribeWorkflowProgress")
    CompletionStage<DescribeWorkflowProgressResponse> describeWorkflowProgress(RpcContext context, DescribeWorkflowProgressRequest request);

    /**
     * StopTasksInner
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link StopTasksResponse}
     */
    @TRpcMethod(name = "StopTasksInner")
    CompletionStage<StopTasksResponse> stopTasksInner(RpcContext context, StopTasksRequest request);

    /**
     * CheckWorkflowTemplate
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CheckWorkflowTemplateResponse}
     */
    @TRpcMethod(name = "CheckWorkflowTemplate")
    CompletionStage<CheckWorkflowTemplateResponse> checkWorkflowTemplate(RpcContext context, CheckWorkflowTemplateRequest request);

    /**
     * DescribeTagAnalyseInput
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeTagAnalyseInputResponse}
     */
    @TRpcMethod(name = "DescribeTagAnalyseInput")
    CompletionStage<DescribeTagAnalyseInputResponse> describeTagAnalyseInput(RpcContext context, DescribeTagAnalyseInputRequest request);
}