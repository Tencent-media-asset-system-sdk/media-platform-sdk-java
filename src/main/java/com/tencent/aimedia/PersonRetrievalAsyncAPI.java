package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcContext;
import com.tencent.trpc.core.rpc.anno.TRpcMethod;
import com.tencent.trpc.core.rpc.anno.TRpcService;
import java.util.concurrent.CompletionStage;

import com.tencent.aimedia.PersonretrievalProtocol.CreatePersonRetrievalTaskRequest;
import com.tencent.aimedia.PersonretrievalProtocol.CreatePersonRetrievalTaskResponse;
import com.tencent.aimedia.PersonretrievalProtocol.DescribePersonRetrievalTaskDataRequest;
import com.tencent.aimedia.PersonretrievalProtocol.DescribePersonRetrievalTaskDataResponse;
import com.tencent.aimedia.PersonretrievalProtocol.RetrievalImageRequest;
import com.tencent.aimedia.PersonretrievalProtocol.RetrievalImageResponse;

/**
 * Generated by trpc-java-codegen
 */
@TRpcService(name = "trpc.media.personretrieval.PersonRetrieval")
public interface PersonRetrievalAsyncAPI {

    /**
     * CreatePersonRetrievalTask
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CreatePersonRetrievalTaskResponse}
     */
    @TRpcMethod(name = "CreatePersonRetrievalTask")
    CompletionStage<CreatePersonRetrievalTaskResponse> createPersonRetrievalTask(RpcContext context, CreatePersonRetrievalTaskRequest request);

    /**
     * DescribePersonRetrievalTaskData
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribePersonRetrievalTaskDataResponse}
     */
    @TRpcMethod(name = "DescribePersonRetrievalTaskData")
    CompletionStage<DescribePersonRetrievalTaskDataResponse> describePersonRetrievalTaskData(RpcContext context, DescribePersonRetrievalTaskDataRequest request);

    /**
     * RetrievalImage
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RetrievalImageResponse}
     */
    @TRpcMethod(name = "RetrievalImage")
    CompletionStage<RetrievalImageResponse> retrievalImage(RpcContext context, RetrievalImageRequest request);
}