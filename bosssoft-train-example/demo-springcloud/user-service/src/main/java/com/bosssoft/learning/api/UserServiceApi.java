package com.bosssoft.learning.api;

import com.bosssoft.learning.data.convention.CommonResponse;
import com.bosssoft.learning.pojo.query.UserQuery;
import com.bosssoft.learning.pojo.vo.UserVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description 服务对外的接口保持稳定，调用者可以是API网关也可以其他的系统
 * @Date 2020/6/23 14:42
 * @Author HetFrame
 */
public interface UserServiceApi {
    /**
     * @param userVO
     * @Description 登录。注销在前端清除token就行了
     * @date 2020/6/23 14:52
     * @return: com.bosssoft.learning.data.convention.CommonResponse<java.lang.Boolean>
     */
    CommonResponse<UserVO> login(@RequestBody UserVO userVO);

    /**
     * @param userQuery
     * @Description 通过id查询
     * @date 2020/6/23 18:44
     * @return: com.bosssoft.learning.data.convention.CommonResponse<com.bosssoft.learning.pojo.vo.UserVO>
     */
    CommonResponse<UserVO> queryUserById(@RequestBody UserQuery userQuery);

    /**
     * @param userQuery
     * @Description 按多条件查询user
     * @date 2020/6/23 14:56
     * @return: com.bosssoft.learning.data.convention.CommonResponse<com.bosssoft.learning.pojo.vo.UserVO>
     */
    CommonResponse<List<UserVO>> queryUserByCondition(@RequestBody UserQuery userQuery);

    /**
     * @param userVO
     * @Description 保存用户
     * @date 2020/6/23 14:57
     * @return: com.bosssoft.learning.data.convention.CommonResponse<java.lang.Boolean>
     */
    CommonResponse<Boolean> saveUser(@RequestBody UserVO userVO);

    /**
     * @param userVO
     * @Description 更新用户
     * @date 2020/6/23 14:57
     * @return: com.bosssoft.learning.data.convention.CommonResponse<java.lang.Boolean>
     */
    CommonResponse<Boolean> updateUser(@RequestBody UserVO userVO);

    /**
     * @param userVO
     * @Description 删除用户
     * @date 2020/6/23 14:57
     * @return: com.bosssoft.learning.data.convention.CommonResponse<java.lang.Boolean>
     */
    CommonResponse<Boolean> removeUser(@RequestBody UserVO userVO);

}
