package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcContext;
import com.tencent.trpc.core.rpc.anno.TRpcMethod;
import com.tencent.trpc.core.rpc.anno.TRpcService;

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
public interface UserDefinePersonAPI {

    /**
     * CreateUserDefineGroup
     *
     * @param context context
     * @param request request
     * @return {@link CreateUserDefineGroupResponse}
     */
    @TRpcMethod(name = "CreateUserDefineGroup")
    CreateUserDefineGroupResponse createUserDefineGroup(RpcContext context, CreateUserDefineGroupRequest request);

    /**
     * DescribeUserDefineGroup
     *
     * @param context context
     * @param request request
     * @return {@link DescribeUserDefineGroupResponse}
     */
    @TRpcMethod(name = "DescribeUserDefineGroup")
    DescribeUserDefineGroupResponse describeUserDefineGroup(RpcContext context, DescribeUserDefineGroupRequest request);

    /**
     * RemoveUserDefineGroup
     *
     * @param context context
     * @param request request
     * @return {@link RemoveUserDefineGroupResponse}
     */
    @TRpcMethod(name = "RemoveUserDefineGroup")
    RemoveUserDefineGroupResponse removeUserDefineGroup(RpcContext context, RemoveUserDefineGroupRequest request);

    /**
     * UpdateUserDefineGroup
     *
     * @param context context
     * @param request request
     * @return {@link UpdateUserDefineGroupResponse}
     */
    @TRpcMethod(name = "UpdateUserDefineGroup")
    UpdateUserDefineGroupResponse updateUserDefineGroup(RpcContext context, UpdateUserDefineGroupRequest request);

    /**
     * CreateUserDefinePerson
     *
     * @param context context
     * @param request request
     * @return {@link CreateUserDefinePersonResponse}
     */
    @TRpcMethod(name = "CreateUserDefinePerson")
    CreateUserDefinePersonResponse createUserDefinePerson(RpcContext context, CreateUserDefinePersonRequest request);

    /**
     * RemoveUserDefinePerson
     *
     * @param context context
     * @param request request
     * @return {@link RemoveUserDefinePersonResponse}
     */
    @TRpcMethod(name = "RemoveUserDefinePerson")
    RemoveUserDefinePersonResponse removeUserDefinePerson(RpcContext context, RemoveUserDefinePersonRequest request);

    /**
     * UpdateUserDefinePerson
     *
     * @param context context
     * @param request request
     * @return {@link UpdateUserDefinePersonResponse}
     */
    @TRpcMethod(name = "UpdateUserDefinePerson")
    UpdateUserDefinePersonResponse updateUserDefinePerson(RpcContext context, UpdateUserDefinePersonRequest request);

    /**
     * DescribeUserDefinePerson
     *
     * @param context context
     * @param request request
     * @return {@link DescribeUserDefinePersonResponse}
     */
    @TRpcMethod(name = "DescribeUserDefinePerson")
    DescribeUserDefinePersonResponse describeUserDefinePerson(RpcContext context, DescribeUserDefinePersonRequest request);

    /**
     * DescribeUserDefinePersonDetail
     *
     * @param context context
     * @param request request
     * @return {@link DescribeUserDefinePersonDetailResponse}
     */
    @TRpcMethod(name = "DescribeUserDefinePersonDetail")
    DescribeUserDefinePersonDetailResponse describeUserDefinePersonDetail(RpcContext context, DescribeUserDefinePersonDetailRequest request);

    /**
     * DescribeUserDefinePersonWithFeature
     *
     * @param context context
     * @param request request
     * @return {@link DescribeUserDefinePersonWithFeatureResponse}
     */
    @TRpcMethod(name = "DescribeUserDefinePersonWithFeature")
    DescribeUserDefinePersonWithFeatureResponse describeUserDefinePersonWithFeature(RpcContext context, DescribeUserDefinePersonWithFeatureRequest request);

    /**
     * CreatePersonCategory
     *
     * @param context context
     * @param request request
     * @return {@link CreatePersonCategoryResponse}
     */
    @TRpcMethod(name = "CreatePersonCategory")
    CreatePersonCategoryResponse createPersonCategory(RpcContext context, CreatePersonCategoryRequest request);

    /**
     * RemovePersonCategory
     *
     * @param context context
     * @param request request
     * @return {@link RemovePersonCategoryResponse}
     */
    @TRpcMethod(name = "RemovePersonCategory")
    RemovePersonCategoryResponse removePersonCategory(RpcContext context, RemovePersonCategoryRequest request);

    /**
     * DescribePersonCategory
     *
     * @param context context
     * @param request request
     * @return {@link DescribePersonCategoryResponse}
     */
    @TRpcMethod(name = "DescribePersonCategory")
    DescribePersonCategoryResponse describePersonCategory(RpcContext context, DescribePersonCategoryRequest request);

    /**
     * RevertPerson
     *
     * @param context context
     * @param request request
     * @return {@link PersonRevertResponse}
     */
    @TRpcMethod(name = "RevertPerson")
    PersonRevertResponse revertPerson(RpcContext context, PersonRevertRequest request);

    /**
     * DescribeRevertTasks
     *
     * @param context context
     * @param request request
     * @return {@link DescribeRevertTasksResponse}
     */
    @TRpcMethod(name = "DescribeRevertTasks")
    DescribeRevertTasksResponse describeRevertTasks(RpcContext context, DescribeRevertTasksRequest request);
}