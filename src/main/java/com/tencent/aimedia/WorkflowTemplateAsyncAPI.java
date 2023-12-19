package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcContext;
import com.tencent.trpc.core.rpc.anno.TRpcMethod;
import com.tencent.trpc.core.rpc.anno.TRpcService;
import java.util.concurrent.CompletionStage;

import com.tencent.aimedia.WorkflowTemplateProtocol.CreateWorkflowTemplatesRequest;
import com.tencent.aimedia.WorkflowTemplateProtocol.CreateWorkflowTemplatesResponse;
import com.tencent.aimedia.WorkflowTemplateProtocol.DescribeWorkflowTemplatesRequest;
import com.tencent.aimedia.WorkflowTemplateProtocol.DescribeWorkflowTemplatesResponse;
import com.tencent.aimedia.WorkflowTemplateProtocol.DescribeWorkflowTemplateDetailsRequest;
import com.tencent.aimedia.WorkflowTemplateProtocol.DescribeWorkflowTemplateDetailsResponse;
import com.tencent.aimedia.WorkflowTemplateProtocol.DeleteWorkflowTemplatesRequest;
import com.tencent.aimedia.WorkflowTemplateProtocol.DeleteWorkflowTemplatesResponse;
import com.tencent.aimedia.WorkflowTemplateProtocol.ModifyWorkflowTemplateRequest;
import com.tencent.aimedia.WorkflowTemplateProtocol.ModifyWorkflowTemplateResponse;
import com.tencent.aimedia.WorkflowTemplateProtocol.DescribeAvailableWorkflowTemplateComponentsRequest;
import com.tencent.aimedia.WorkflowTemplateProtocol.DescribeAvailableWorkflowTemplateComponentsResponse;

/**
 * Generated by trpc-java-codegen
 */
@TRpcService(name = "trpc.media.workflowtemplate.WorkflowTemplate")
public interface WorkflowTemplateAsyncAPI {

    /**
     * CreateWorkflowTemplates
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CreateWorkflowTemplatesResponse}
     */
    @TRpcMethod(name = "CreateWorkflowTemplates")
    CompletionStage<CreateWorkflowTemplatesResponse> createWorkflowTemplates(RpcContext context, CreateWorkflowTemplatesRequest request);

    /**
     * DescribeWorkflowTemplates
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeWorkflowTemplatesResponse}
     */
    @TRpcMethod(name = "DescribeWorkflowTemplates")
    CompletionStage<DescribeWorkflowTemplatesResponse> describeWorkflowTemplates(RpcContext context, DescribeWorkflowTemplatesRequest request);

    /**
     * DescribeWorkflowTemplateDetails
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeWorkflowTemplateDetailsResponse}
     */
    @TRpcMethod(name = "DescribeWorkflowTemplateDetails")
    CompletionStage<DescribeWorkflowTemplateDetailsResponse> describeWorkflowTemplateDetails(RpcContext context, DescribeWorkflowTemplateDetailsRequest request);

    /**
     * DeleteWorkflowTemplates
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DeleteWorkflowTemplatesResponse}
     */
    @TRpcMethod(name = "DeleteWorkflowTemplates")
    CompletionStage<DeleteWorkflowTemplatesResponse> deleteWorkflowTemplates(RpcContext context, DeleteWorkflowTemplatesRequest request);

    /**
     * ModifyWorkflowTemplate
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link ModifyWorkflowTemplateResponse}
     */
    @TRpcMethod(name = "ModifyWorkflowTemplate")
    CompletionStage<ModifyWorkflowTemplateResponse> modifyWorkflowTemplate(RpcContext context, ModifyWorkflowTemplateRequest request);

    /**
     * DescribeAvailableWorkflowTemplateComponents
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeAvailableWorkflowTemplateComponentsResponse}
     */
    @TRpcMethod(name = "DescribeAvailableWorkflowTemplateComponents")
    CompletionStage<DescribeAvailableWorkflowTemplateComponentsResponse> describeAvailableWorkflowTemplateComponents(RpcContext context, DescribeAvailableWorkflowTemplateComponentsRequest request);
}