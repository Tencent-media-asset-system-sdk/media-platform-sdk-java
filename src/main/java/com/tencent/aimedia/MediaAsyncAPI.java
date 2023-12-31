package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcContext;
import com.tencent.trpc.core.rpc.anno.TRpcMethod;
import com.tencent.trpc.core.rpc.anno.TRpcService;
import java.util.concurrent.CompletionStage;

import com.tencent.aimedia.MediaProtocol.CreateMediasRequest;
import com.tencent.aimedia.MediaProtocol.CreateMediasResponse;
import com.tencent.aimedia.MediaProtocol.CommitMediasRequest;
import com.tencent.aimedia.MediaProtocol.CommitMediasResponse;
import com.tencent.aimedia.MediaProtocol.DescribeMediasRequest;
import com.tencent.aimedia.MediaProtocol.DescribeMediasResponse;
import com.tencent.aimedia.MediaProtocol.DescribeMediaDetailsRequest;
import com.tencent.aimedia.MediaProtocol.DescribeMediaDetailsResponse;
import com.tencent.aimedia.MediaProtocol.DeleteMediasRequest;
import com.tencent.aimedia.MediaProtocol.DeleteMediasResponse;
import com.tencent.aimedia.MediaProtocol.RestoreDeletedMediasRequest;
import com.tencent.aimedia.MediaProtocol.RestoreDeletedMediasResponse;
import com.tencent.aimedia.MediaProtocol.EmptyTrashRequest;
import com.tencent.aimedia.MediaProtocol.EmptyTrashResponse;
import com.tencent.aimedia.MediaProtocol.DescribeCategoriesRequest;
import com.tencent.aimedia.MediaProtocol.DescribeCategoriesResponse;
import com.tencent.aimedia.MediaProtocol.ModifyMediaRequest;
import com.tencent.aimedia.MediaProtocol.ModifyMediaResponse;
import com.tencent.aimedia.MediaProtocol.RetrieveRelevantTagsRequest;
import com.tencent.aimedia.MediaProtocol.RetrieveRelevantTagsResponse;
import com.tencent.aimedia.MediaProtocol.RetrieveLexicalEntryRequest;
import com.tencent.aimedia.MediaProtocol.RetrieveLexicalEntryResponse;
import com.tencent.aimedia.MediaProtocol.RetrieveMediasRequest;
import com.tencent.aimedia.MediaProtocol.RetrieveMediasResponse;
import com.tencent.aimedia.MediaProtocol.RetrieveFacesResponse;
import com.tencent.aimedia.MediaProtocol.RetrieveConsistentMediasRequest;
import com.tencent.aimedia.MediaProtocol.RetrieveConsistentMediasResponse;
import com.tencent.aimedia.MediaProtocol.AssociateWordsRequest;
import com.tencent.aimedia.MediaProtocol.AssociateWordsResponse;
import com.tencent.aimedia.MediaProtocol.ExtractImagesRequest;
import com.tencent.aimedia.MediaProtocol.ExtractImagesResponse;
import com.tencent.aimedia.MediaProtocol.CreateResourcePackageRequest;
import com.tencent.aimedia.MediaProtocol.CreateResourcePackageResponse;
import com.tencent.aimedia.MediaProtocol.DeleteResourcePackageRequest;
import com.tencent.aimedia.MediaProtocol.ResourcePackageOperateResponse;
import com.tencent.aimedia.MediaProtocol.UpdateResourcePackageRequest;
import com.tencent.aimedia.MediaProtocol.DescribeResourcePackageRequest;
import com.tencent.aimedia.MediaProtocol.DescribePackageResponse;
import com.tencent.aimedia.MediaProtocol.AddResourceToPackageRequest;
import com.tencent.aimedia.MediaProtocol.AddResourceToPackageResponse;
import com.tencent.aimedia.MediaProtocol.DeleteResourceFromPackageRequest;
import com.tencent.aimedia.MediaProtocol.UndeleteResourceFromPackageRequest;
import com.tencent.aimedia.MediaProtocol.BindMediasRequest;
import com.tencent.aimedia.MediaProtocol.BindMediasResponse;
import com.tencent.aimedia.MediaProtocol.DescribeMediaDetailsInnerRequest;
import com.tencent.aimedia.MediaProtocol.DescribeMediaDetailsInnerResponse;

/**
 * Generated by trpc-java-codegen
 */
@TRpcService(name = "trpc.media.media.Media")
public interface MediaAsyncAPI {

    /**
     * CreateMedias
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CreateMediasResponse}
     */
    @TRpcMethod(name = "CreateMedias")
    CompletionStage<CreateMediasResponse> createMedias(RpcContext context, CreateMediasRequest request);

    /**
     * CommitMedias
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CommitMediasResponse}
     */
    @TRpcMethod(name = "CommitMedias")
    CompletionStage<CommitMediasResponse> commitMedias(RpcContext context, CommitMediasRequest request);

    /**
     * DescribeMedias
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeMediasResponse}
     */
    @TRpcMethod(name = "DescribeMedias")
    CompletionStage<DescribeMediasResponse> describeMedias(RpcContext context, DescribeMediasRequest request);

    /**
     * DescribeMediaDetails
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeMediaDetailsResponse}
     */
    @TRpcMethod(name = "DescribeMediaDetails")
    CompletionStage<DescribeMediaDetailsResponse> describeMediaDetails(RpcContext context, DescribeMediaDetailsRequest request);

    /**
     * DeleteMedias
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DeleteMediasResponse}
     */
    @TRpcMethod(name = "DeleteMedias")
    CompletionStage<DeleteMediasResponse> deleteMedias(RpcContext context, DeleteMediasRequest request);

    /**
     * RestoreDeletedMedias
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RestoreDeletedMediasResponse}
     */
    @TRpcMethod(name = "RestoreDeletedMedias")
    CompletionStage<RestoreDeletedMediasResponse> restoreDeletedMedias(RpcContext context, RestoreDeletedMediasRequest request);

    /**
     * EmptyTrash
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link EmptyTrashResponse}
     */
    @TRpcMethod(name = "EmptyTrash")
    CompletionStage<EmptyTrashResponse> emptyTrash(RpcContext context, EmptyTrashRequest request);

    /**
     * DescribeCategories
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeCategoriesResponse}
     */
    @TRpcMethod(name = "DescribeCategories")
    CompletionStage<DescribeCategoriesResponse> describeCategories(RpcContext context, DescribeCategoriesRequest request);

    /**
     * ModifyMedia
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link ModifyMediaResponse}
     */
    @TRpcMethod(name = "ModifyMedia")
    CompletionStage<ModifyMediaResponse> modifyMedia(RpcContext context, ModifyMediaRequest request);

    /**
     * RetrieveRelevantTags
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RetrieveRelevantTagsResponse}
     */
    @TRpcMethod(name = "RetrieveRelevantTags")
    CompletionStage<RetrieveRelevantTagsResponse> retrieveRelevantTags(RpcContext context, RetrieveRelevantTagsRequest request);

    /**
     * RetrieveLexicalEntry
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RetrieveLexicalEntryResponse}
     */
    @TRpcMethod(name = "RetrieveLexicalEntry")
    CompletionStage<RetrieveLexicalEntryResponse> retrieveLexicalEntry(RpcContext context, RetrieveLexicalEntryRequest request);

    /**
     * RetrieveTitleMedias
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RetrieveMediasResponse}
     */
    @TRpcMethod(name = "RetrieveTitleMedias")
    CompletionStage<RetrieveMediasResponse> retrieveTitleMedias(RpcContext context, RetrieveMediasRequest request);

    /**
     * RetrieveContentMedias
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RetrieveMediasResponse}
     */
    @TRpcMethod(name = "RetrieveContentMedias")
    CompletionStage<RetrieveMediasResponse> retrieveContentMedias(RpcContext context, RetrieveMediasRequest request);

    /**
     * RetrieveTextMultiModalMedias
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RetrieveMediasResponse}
     */
    @TRpcMethod(name = "RetrieveTextMultiModalMedias")
    CompletionStage<RetrieveMediasResponse> retrieveTextMultiModalMedias(RpcContext context, RetrieveMediasRequest request);

    /**
     * RetrieveTextCrossModalMedias
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RetrieveMediasResponse}
     */
    @TRpcMethod(name = "RetrieveTextCrossModalMedias")
    CompletionStage<RetrieveMediasResponse> retrieveTextCrossModalMedias(RpcContext context, RetrieveMediasRequest request);

    /**
     * RetrieveSimilarMedias
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RetrieveMediasResponse}
     */
    @TRpcMethod(name = "RetrieveSimilarMedias")
    CompletionStage<RetrieveMediasResponse> retrieveSimilarMedias(RpcContext context, RetrieveMediasRequest request);

    /**
     * RetrieveFaces
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RetrieveFacesResponse}
     */
    @TRpcMethod(name = "RetrieveFaces")
    CompletionStage<RetrieveFacesResponse> retrieveFaces(RpcContext context, RetrieveMediasRequest request);

    /**
     * RetrieveConsistentMedias
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RetrieveConsistentMediasResponse}
     */
    @TRpcMethod(name = "RetrieveConsistentMedias")
    CompletionStage<RetrieveConsistentMediasResponse> retrieveConsistentMedias(RpcContext context, RetrieveConsistentMediasRequest request);

    /**
     * AssociateWords
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link AssociateWordsResponse}
     */
    @TRpcMethod(name = "AssociateWords")
    CompletionStage<AssociateWordsResponse> associateWords(RpcContext context, AssociateWordsRequest request);

    /**
     * ExtractImages
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link ExtractImagesResponse}
     */
    @TRpcMethod(name = "ExtractImages")
    CompletionStage<ExtractImagesResponse> extractImages(RpcContext context, ExtractImagesRequest request);

    /**
     * CreateResourcePackage
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CreateResourcePackageResponse}
     */
    @TRpcMethod(name = "CreateResourcePackage")
    CompletionStage<CreateResourcePackageResponse> createResourcePackage(RpcContext context, CreateResourcePackageRequest request);

    /**
     * DeleteResourcePackage
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link ResourcePackageOperateResponse}
     */
    @TRpcMethod(name = "DeleteResourcePackage")
    CompletionStage<ResourcePackageOperateResponse> deleteResourcePackage(RpcContext context, DeleteResourcePackageRequest request);

    /**
     * UpdateResourcePackage
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link ResourcePackageOperateResponse}
     */
    @TRpcMethod(name = "UpdateResourcePackage")
    CompletionStage<ResourcePackageOperateResponse> updateResourcePackage(RpcContext context, UpdateResourcePackageRequest request);

    /**
     * DescribeResourcePackage
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribePackageResponse}
     */
    @TRpcMethod(name = "DescribeResourcePackage")
    CompletionStage<DescribePackageResponse> describeResourcePackage(RpcContext context, DescribeResourcePackageRequest request);

    /**
     * AddResourceToPackage
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link AddResourceToPackageResponse}
     */
    @TRpcMethod(name = "AddResourceToPackage")
    CompletionStage<AddResourceToPackageResponse> addResourceToPackage(RpcContext context, AddResourceToPackageRequest request);

    /**
     * DeleteResourceFromPackage
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link ResourcePackageOperateResponse}
     */
    @TRpcMethod(name = "DeleteResourceFromPackage")
    CompletionStage<ResourcePackageOperateResponse> deleteResourceFromPackage(RpcContext context, DeleteResourceFromPackageRequest request);

    /**
     * UndeleteResourceFromPackage
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link ResourcePackageOperateResponse}
     */
    @TRpcMethod(name = "UndeleteResourceFromPackage")
    CompletionStage<ResourcePackageOperateResponse> undeleteResourceFromPackage(RpcContext context, UndeleteResourceFromPackageRequest request);

    /**
     * BindMedias
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link BindMediasResponse}
     */
    @TRpcMethod(name = "BindMedias")
    CompletionStage<BindMediasResponse> bindMedias(RpcContext context, BindMediasRequest request);

    /**
     * DescribeMediaDetailsInner
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeMediaDetailsInnerResponse}
     */
    @TRpcMethod(name = "DescribeMediaDetailsInner")
    CompletionStage<DescribeMediaDetailsInnerResponse> describeMediaDetailsInner(RpcContext context, DescribeMediaDetailsInnerRequest request);
}