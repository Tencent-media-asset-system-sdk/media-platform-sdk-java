package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcContext;
import com.tencent.trpc.core.rpc.anno.TRpcMethod;
import com.tencent.trpc.core.rpc.anno.TRpcService;
import java.util.concurrent.CompletionStage;

import com.tencent.aimedia.DomainGroupProtocol.CreateDomainGroupRequest;
import com.tencent.aimedia.DomainGroupProtocol.CreateDomainGroupResponse;
import com.tencent.aimedia.DomainGroupProtocol.DescribeDomainGroupsRequest;
import com.tencent.aimedia.DomainGroupProtocol.DescribeDomainGroupsResponse;
import com.tencent.aimedia.DomainGroupProtocol.DescribeDomainGroupDetailsRequest;
import com.tencent.aimedia.DomainGroupProtocol.DescribeDomainGroupDetailsResponse;
import com.tencent.aimedia.DomainGroupProtocol.AddMediasToDomainGroupsRequest;
import com.tencent.aimedia.DomainGroupProtocol.AddMediasToDomainGroupsResponse;
import com.tencent.aimedia.DomainGroupProtocol.RemoveMediasFromDomainGroupsRequest;
import com.tencent.aimedia.DomainGroupProtocol.RemoveMediasFromDomainGroupsResponse;
import com.tencent.aimedia.DomainGroupProtocol.DeleteDomainGroupsRequest;
import com.tencent.aimedia.DomainGroupProtocol.DeleteDomainGroupsResponse;
import com.tencent.aimedia.DomainGroupProtocol.ModifyDomainGroupRequest;
import com.tencent.aimedia.DomainGroupProtocol.ModifyDomainGroupResponse;

/**
 * Generated by trpc-java-codegen
 */
@TRpcService(name = "trpc.media.domaingroup.DomainGroup")
public interface DomainGroupAsyncAPI {

    /**
     * CreateDomainGroup
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CreateDomainGroupResponse}
     */
    @TRpcMethod(name = "CreateDomainGroup")
    CompletionStage<CreateDomainGroupResponse> createDomainGroup(RpcContext context, CreateDomainGroupRequest request);

    /**
     * DescribeDomainGroups
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeDomainGroupsResponse}
     */
    @TRpcMethod(name = "DescribeDomainGroups")
    CompletionStage<DescribeDomainGroupsResponse> describeDomainGroups(RpcContext context, DescribeDomainGroupsRequest request);

    /**
     * DescribeDomainGroupDetails
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeDomainGroupDetailsResponse}
     */
    @TRpcMethod(name = "DescribeDomainGroupDetails")
    CompletionStage<DescribeDomainGroupDetailsResponse> describeDomainGroupDetails(RpcContext context, DescribeDomainGroupDetailsRequest request);

    /**
     * AddMediasToDomainGroups
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link AddMediasToDomainGroupsResponse}
     */
    @TRpcMethod(name = "AddMediasToDomainGroups")
    CompletionStage<AddMediasToDomainGroupsResponse> addMediasToDomainGroups(RpcContext context, AddMediasToDomainGroupsRequest request);

    /**
     * RemoveMediasFromDomainGroups
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RemoveMediasFromDomainGroupsResponse}
     */
    @TRpcMethod(name = "RemoveMediasFromDomainGroups")
    CompletionStage<RemoveMediasFromDomainGroupsResponse> removeMediasFromDomainGroups(RpcContext context, RemoveMediasFromDomainGroupsRequest request);

    /**
     * DeleteDomainGroups
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DeleteDomainGroupsResponse}
     */
    @TRpcMethod(name = "DeleteDomainGroups")
    CompletionStage<DeleteDomainGroupsResponse> deleteDomainGroups(RpcContext context, DeleteDomainGroupsRequest request);

    /**
     * ModifyDomainGroup
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link ModifyDomainGroupResponse}
     */
    @TRpcMethod(name = "ModifyDomainGroup")
    CompletionStage<ModifyDomainGroupResponse> modifyDomainGroup(RpcContext context, ModifyDomainGroupRequest request);
}