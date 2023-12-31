package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcContext;
import com.tencent.trpc.core.rpc.anno.TRpcMethod;
import com.tencent.trpc.core.rpc.anno.TRpcService;
import java.util.concurrent.CompletionStage;

import com.tencent.aimedia.PersonUserDefineProtocol.CreateUserDefineGroupRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.CreateUserDefineGroupResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.DescribeUserDefineGroupRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.DescribeUserDefineGroupResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.RemoveUserDefineGroupRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.RemoveUserDefineGroupResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.UpdateUserDefineGroupRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.UpdateUserDefineGroupResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.CreateUserDefinePersonRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.CreateUserDefinePersonResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.RemoveUserDefinePersonRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.RemoveUserDefinePersonResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.UpdateUserDefinePersonRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.UpdateUserDefinePersonResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.DescribeUserDefinePersonRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.DescribeUserDefinePersonResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.DescribeUserDefinePersonDetailRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.DescribeUserDefinePersonDetailResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.DescribeUserDefinePersonWithFeatureRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.DescribeUserDefinePersonWithFeatureResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.CreatePersonCategoryRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.CreatePersonCategoryResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.RemovePersonCategoryRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.RemovePersonCategoryResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.DescribePersonCategoryRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.DescribePersonCategoryResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.PersonRevertRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.PersonRevertResponse;
import com.tencent.aimedia.PersonUserDefineProtocol.DescribeRevertTasksRequest;
import com.tencent.aimedia.PersonUserDefineProtocol.DescribeRevertTasksResponse;

/**
 * Generated by trpc-java-codegen
 */
@TRpcService(name = "trpc.media.personuserdefine.UserDefinePerson")
public interface UserDefinePersonAsyncAPI {

    /**
     * CreateUserDefineGroup
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CreateUserDefineGroupResponse}
     */
    @TRpcMethod(name = "CreateUserDefineGroup")
    CompletionStage<CreateUserDefineGroupResponse> createUserDefineGroup(RpcContext context, CreateUserDefineGroupRequest request);

    /**
     * DescribeUserDefineGroup
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeUserDefineGroupResponse}
     */
    @TRpcMethod(name = "DescribeUserDefineGroup")
    CompletionStage<DescribeUserDefineGroupResponse> describeUserDefineGroup(RpcContext context, DescribeUserDefineGroupRequest request);

    /**
     * RemoveUserDefineGroup
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RemoveUserDefineGroupResponse}
     */
    @TRpcMethod(name = "RemoveUserDefineGroup")
    CompletionStage<RemoveUserDefineGroupResponse> removeUserDefineGroup(RpcContext context, RemoveUserDefineGroupRequest request);

    /**
     * UpdateUserDefineGroup
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link UpdateUserDefineGroupResponse}
     */
    @TRpcMethod(name = "UpdateUserDefineGroup")
    CompletionStage<UpdateUserDefineGroupResponse> updateUserDefineGroup(RpcContext context, UpdateUserDefineGroupRequest request);

    /**
     * CreateUserDefinePerson
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CreateUserDefinePersonResponse}
     */
    @TRpcMethod(name = "CreateUserDefinePerson")
    CompletionStage<CreateUserDefinePersonResponse> createUserDefinePerson(RpcContext context, CreateUserDefinePersonRequest request);

    /**
     * RemoveUserDefinePerson
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RemoveUserDefinePersonResponse}
     */
    @TRpcMethod(name = "RemoveUserDefinePerson")
    CompletionStage<RemoveUserDefinePersonResponse> removeUserDefinePerson(RpcContext context, RemoveUserDefinePersonRequest request);

    /**
     * UpdateUserDefinePerson
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link UpdateUserDefinePersonResponse}
     */
    @TRpcMethod(name = "UpdateUserDefinePerson")
    CompletionStage<UpdateUserDefinePersonResponse> updateUserDefinePerson(RpcContext context, UpdateUserDefinePersonRequest request);

    /**
     * DescribeUserDefinePerson
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeUserDefinePersonResponse}
     */
    @TRpcMethod(name = "DescribeUserDefinePerson")
    CompletionStage<DescribeUserDefinePersonResponse> describeUserDefinePerson(RpcContext context, DescribeUserDefinePersonRequest request);

    /**
     * DescribeUserDefinePersonDetail
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeUserDefinePersonDetailResponse}
     */
    @TRpcMethod(name = "DescribeUserDefinePersonDetail")
    CompletionStage<DescribeUserDefinePersonDetailResponse> describeUserDefinePersonDetail(RpcContext context, DescribeUserDefinePersonDetailRequest request);

    /**
     * DescribeUserDefinePersonWithFeature
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeUserDefinePersonWithFeatureResponse}
     */
    @TRpcMethod(name = "DescribeUserDefinePersonWithFeature")
    CompletionStage<DescribeUserDefinePersonWithFeatureResponse> describeUserDefinePersonWithFeature(RpcContext context, DescribeUserDefinePersonWithFeatureRequest request);

    /**
     * CreatePersonCategory
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link CreatePersonCategoryResponse}
     */
    @TRpcMethod(name = "CreatePersonCategory")
    CompletionStage<CreatePersonCategoryResponse> createPersonCategory(RpcContext context, CreatePersonCategoryRequest request);

    /**
     * RemovePersonCategory
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link RemovePersonCategoryResponse}
     */
    @TRpcMethod(name = "RemovePersonCategory")
    CompletionStage<RemovePersonCategoryResponse> removePersonCategory(RpcContext context, RemovePersonCategoryRequest request);

    /**
     * DescribePersonCategory
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribePersonCategoryResponse}
     */
    @TRpcMethod(name = "DescribePersonCategory")
    CompletionStage<DescribePersonCategoryResponse> describePersonCategory(RpcContext context, DescribePersonCategoryRequest request);

    /**
     * RevertPerson
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link PersonRevertResponse}
     */
    @TRpcMethod(name = "RevertPerson")
    CompletionStage<PersonRevertResponse> revertPerson(RpcContext context, PersonRevertRequest request);

    /**
     * DescribeRevertTasks
     *
     * @param context context
     * @param request request
     * @return {@link CompletionStage} of {@link DescribeRevertTasksResponse}
     */
    @TRpcMethod(name = "DescribeRevertTasks")
    CompletionStage<DescribeRevertTasksResponse> describeRevertTasks(RpcContext context, DescribeRevertTasksRequest request);
}