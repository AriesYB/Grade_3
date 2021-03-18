package org.ybiao.springcloud.customer.mapper;

import org.apache.ibatis.annotations.*;
import org.ybiao.springcloud.customer.bean.Customer;
import org.ybiao.springcloud.customer.bean.CustomerExample;

import java.util.List;

@Mapper
public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    @Delete({
        "delete from customer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into customer (id, name, ",
        "age, sex, address, ",
        "phone, isDeleted)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER}, #{sex,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{isdeleted,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    @Select({
        "select",
        "id, name, age, sex, address, phone, isDeleted",
        "from customer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Customer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    @Update({
        "update customer",
        "set name = #{name,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "isDeleted = #{isdeleted,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Customer record);
}