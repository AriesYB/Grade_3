package com.bosssoft.learning.mapper;

import com.bosssoft.learning.model.CompanyTest;
import com.bosssoft.learning.model.CompanyExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CompanyMapper {
    int countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    @Delete({
        "delete from t_company",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_company (id, name)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=String.class)
    int insert(CompanyTest record);

    int insertSelective(CompanyTest record);

    List<CompanyTest> selectByExample(CompanyExample example);

    @Select({
        "select",
        "id, name",
        "from t_company",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    CompanyTest selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CompanyTest record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") CompanyTest record, @Param("example") CompanyExample example);

    int updateByPrimaryKeySelective(CompanyTest record);

    @Update({
        "update t_company",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CompanyTest record);
}