package com.boss.xtrain.util.bean;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 测试
 * @Date 2020/7/2 9:56
 * @Author HetFrame
 */

public class BeanUtilTest {
    private static final Logger log = LoggerFactory.getLogger(BeanUtilTest.class);

    class UserDTO {
        int code;
        String name;
        String sex;

        public UserDTO() {
        }

        public UserDTO(int code, String name, String sex) {
            this.code = code;
            this.name = name;
            this.sex = sex;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "UserDTO{" +
                    "code=" + code +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }

    class UserVO {
        String name;
        String sex;

        public UserVO() {
        }

        public UserVO(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "UserVO{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }

    @Test
    public void copyProperties() {
        UserDTO userDTO = new UserDTO(123, "测试", "男");
        UserVO userVO = new UserVO();
        BeanUtil.getInstance().copyProperties(userDTO,userVO);
        log.info(userDTO+" 复制到vo "+userVO);

        UserDTO userDTO1 = new UserDTO();
        UserVO userVO1 = new UserVO( "测试", "男");
        BeanUtil.getInstance().copyProperties(userVO1,userDTO1);
        log.info(userVO1+" 复制到dto "+userDTO1);
    }
}