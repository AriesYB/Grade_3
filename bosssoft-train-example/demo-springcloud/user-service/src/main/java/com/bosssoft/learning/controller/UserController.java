package com.bosssoft.learning.controller;

import com.bosssoft.learning.api.UserServiceApi;
import com.bosssoft.learning.data.convention.CommonResponse;
import com.bosssoft.learning.data.convention.CommonResponseCode;
import com.bosssoft.learning.exception.ExceptionHandle;
import com.bosssoft.learning.pojo.dto.UserDTO;
import com.bosssoft.learning.pojo.query.UserQuery;
import com.bosssoft.learning.pojo.vo.UserVO;
import com.bosssoft.learning.service.UserService;
import com.bosssoft.learning.util.PojoConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 用户控制器 异常处理注解用于切面处理异常 CrossOrigin解决跨域问题
 * @Date 2020/6/22 14:58
 * @Author HetFrame
 */
@ExceptionHandle(true)
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController implements UserServiceApi {

    private UserService<UserDTO, UserVO, UserQuery> userService;

    @Autowired
    public void setUserService(UserService<UserDTO, UserVO, UserQuery> userService) {
        this.userService = userService;
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String test() {
        return port;
    }

    @PostMapping("/login")
    @Override
    public CommonResponse<UserVO> login(UserVO userVO) {
        userVO = userService.checkAccount(userVO);
        //验证成功返回user对象并设置响应对象
        return userVO == null ? new CommonResponse<>(null, CommonResponseCode.LOGIN_FAILED) : new CommonResponse<>(userVO, CommonResponseCode.LOGIN_SUCCESS);
    }

    @PostMapping("/queryById")
    @Override
    public CommonResponse<UserVO> queryUserById(UserQuery userQuery) {
        return new CommonResponse<>(userService.queryById(userQuery));
    }

    @PostMapping("/query")
    @Override
    public CommonResponse<List<UserVO>> queryUserByCondition(UserQuery userQuery) {
        return new CommonResponse<>(userService.queryByCondition(userQuery));
    }

    @PostMapping("/save")
    @Override
    public CommonResponse<Boolean> saveUser(UserVO userVO) {
        return new CommonResponse<>(userService.save(PojoConvert.getInstance().convertToDto(userVO)) != null);
    }

    @PostMapping("/update")
    @Override
    public CommonResponse<Boolean> updateUser(UserVO userVO) {
        return new CommonResponse<>(userService.update(PojoConvert.getInstance().convertToDto(userVO)) != null);
    }

    @PostMapping("/remove")
    @Override
    public CommonResponse<Boolean> removeUser(UserVO userVO) {
        return new CommonResponse<>(userService.remove(userVO));
    }
}
