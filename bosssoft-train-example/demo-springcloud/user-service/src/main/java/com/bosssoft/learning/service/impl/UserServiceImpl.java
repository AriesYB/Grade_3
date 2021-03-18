package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.dao.UserDao;
import com.bosssoft.learning.dao.UserRoleDao;
import com.bosssoft.learning.exception.BusinessErrorInfo;
import com.bosssoft.learning.exception.ExceptionHandle;
import com.bosssoft.learning.pojo.dto.UserDTO;
import com.bosssoft.learning.pojo.entity.User;
import com.bosssoft.learning.pojo.entity.UserRole;
import com.bosssoft.learning.pojo.query.UserQuery;
import com.bosssoft.learning.pojo.vo.UserVO;
import com.bosssoft.learning.service.UserService;
import com.bosssoft.learning.util.PojoConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description user业务实现类
 * @Date 2020/6/21 23:12
 * @Author HetFrame
 */
@Service
public class UserServiceImpl implements UserService<UserDTO, UserVO, UserQuery> {

    private UserDao<UserQuery, User> userDao;

    private UserRoleDao<UserRole> userRoleDao;

    @Autowired
    public void setUserDao(UserDao<UserQuery, User> userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setUserRoleDao(UserRoleDao<UserRole> userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @ExceptionHandle(info = BusinessErrorInfo.FAIL_TO_VALIDATE_USER)
    @Cacheable(value = "userCache", key = "#userVO")
    @Override
    public UserVO checkAccount(UserVO userVO) {
        UserDTO userDTO = userDao.selectById(userVO.getId());
        if (userDTO == null) {
            return null;
        }
        return userVO.getPassword().equals(userDTO.getPassword()) ? PojoConvert.getInstance().convertToVo(userDTO) : null;
    }

    @ExceptionHandle(info = BusinessErrorInfo.FAIL_TO_QUERY_USER)
    @Cacheable(value = "userCache", key = "#query.id")
    @Override
    public UserVO queryById(UserQuery query) {
        return PojoConvert.getInstance().convertToVo(userDao.selectById(query.getId()));
    }

    @ExceptionHandle(info = BusinessErrorInfo.FAIL_TO_QUERY_USER)
    @Override
    public List<UserVO> queryByCondition(UserQuery query) {
        List<UserDTO> dtoList = userDao.selectByCondition(query);
        List<UserVO> voList = new ArrayList<>();
        for (UserDTO userDTO : dtoList) {
            voList.add(PojoConvert.getInstance().convertToVo(userDTO));
        }
        return voList;
    }

    @ExceptionHandle(info = BusinessErrorInfo.FAIL_TO_SAVE_USER)
    @CachePut(value = "userCache", key = "#result.id")
    @Override
    public UserDTO save(UserDTO userDTO) {
        //将dto转成entity 再分别操作数据库
        Map<String, Object> map = PojoConvert.getInstance().convertToEntity(userDTO);
        User user = (User) map.get("user");
        List<UserRole> list = (List<UserRole>) map.get("userRoles");
        int saveUserResult = userDao.insert(user);
        int saveUserRoleResult = 0;
        if (!list.isEmpty()) {
            //当user插入后才有id
            for (UserRole ur : list) {
                ur.setUserId(user.getId());
            }
            saveUserRoleResult = userRoleDao.insertList(list);
        }
        return saveUserResult == 1 && saveUserRoleResult == list.size() ? userDTO : null;
    }

    @ExceptionHandle(info = BusinessErrorInfo.FAIL_TO_UPDATE_USER)
    @CachePut(value = "userCache", key = "#userDTO.id")
    @Override
    public UserDTO update(UserDTO userDTO) {
        Map<String, Object> map = PojoConvert.getInstance().convertToEntity(userDTO);
        User user = (User) map.get("user");
        List<UserRole> list = (List<UserRole>) map.get("userRoles");
        //更新user
        int updateUserResult = userDao.update(user);
        int removeUserRoleResult = 0;
        //更新role办法：删除role，再添加role
        List<UserRole> roleList = userRoleDao.selectByUserId(user.getId());
        if (!roleList.isEmpty()) {
            removeUserRoleResult = userRoleDao.deleteAllRole(user.getId());
        }
        int saveUserRoleResult = userRoleDao.insertList(list);
        return updateUserResult == 1 && saveUserRoleResult == list.size() && removeUserRoleResult == roleList.size() ? userDTO : null;
    }

    @ExceptionHandle(info = BusinessErrorInfo.FAIL_TO_DELETE_USER)
    @CacheEvict(value = "userCache", key = "#userVO.id")
    @Override
    public boolean remove(UserVO userVO) {
        List<UserRole> list = userRoleDao.selectByUserId(userVO.getId());
        return userDao.deleteById(userVO.getId()) == 1 && userRoleDao.deleteAllRole(userVO.getId()) == list.size();
    }
}
