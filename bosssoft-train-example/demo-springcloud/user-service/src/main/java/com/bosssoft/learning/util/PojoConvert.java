package com.bosssoft.learning.util;

import com.bosssoft.learning.pojo.dto.UserDTO;
import com.bosssoft.learning.pojo.entity.Role;
import com.bosssoft.learning.pojo.entity.User;
import com.bosssoft.learning.pojo.entity.UserRole;
import com.bosssoft.learning.pojo.vo.UserVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description pojo类的互相转换的工具类
 * @Date 2020/6/23 11:11
 * @Author HetFrame
 */
public class PojoConvert {
    private static final PojoConvert CONVERT = new PojoConvert();

    private PojoConvert() {
    }

    public static PojoConvert getInstance() {
        return CONVERT;
    }

    /**
     * @param dto
     * @Description dto转化成vo
     * @date 2020/6/23 11:40
     * @return: com.bosssoft.learning.pojo.vo.UserVO
     */
    public UserVO convertToVo(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        return new UserVO(dto.getId(), dto.getPassword(), dto.getName(), dto.getAge(), dto.getSex(), dto.getPhone(), dto.getAddress(), dto.getCompany(), dto.getRoles());
    }

    /**
     * @param vo
     * @Description vo转换成dto
     * @date 2020/6/23 11:40
     * @return: com.bosssoft.learning.pojo.dto.UserDTO
     */
    public UserDTO convertToDto(UserVO vo) {
        if (vo == null) {
            return null;
        }
        return new UserDTO(vo.getId(), vo.getPassword(), vo.getName(), vo.getAge(), vo.getSex(), vo.getPhone(), vo.getAddress(), vo.getCompany(), vo.getRoles());
    }

    /**
     * @param vo
     * @Description vo转成两个实体
     * @date 2020/6/23 11:40
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    public Map<String, Object> convertToEntity(UserVO vo) {
        Map<String, Object> map = new HashMap<>();
        List<UserRole> list = new ArrayList<>();
        for (Role role : vo.getRoles()) {
            list.add(new UserRole(vo.getId(), role.getId()));
        }
        map.put("user", new User(vo.getId(), vo.getPassword(), vo.getName(), vo.getAge(), vo.getSex(), vo.getPhone(), vo.getAddress(), vo.getCompany().getId()));
        map.put("userRoles", list);
        return map;
    }

    /**
     * @param dto
     * @Description dto转成两个实体
     * @date 2020/6/23 11:40
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    public Map<String, Object> convertToEntity(UserDTO dto) {
        return convertToEntity(convertToVo(dto));
    }

}
