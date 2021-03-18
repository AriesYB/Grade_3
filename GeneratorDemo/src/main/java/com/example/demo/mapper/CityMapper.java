package com.example.demo.mapper;

import com.example.demo.bean.City;
import com.example.demo.bean.CityExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface CityMapper {
    int countByExample(CityExample example);

    int deleteByExample(CityExample example);

    @Delete({
        "delete from city",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into city (ID, Name, CountryCode, ",
        "District, Population)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=CHAR}, #{countrycode,jdbcType=CHAR}, ",
        "#{district,jdbcType=CHAR}, #{population,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(City record);

    int insertSelective(City record);

    List<City> selectByExample(CityExample example);

    @Select({
        "select",
        "ID, Name, CountryCode, District, Population",
        "from city",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    City selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    int updateByExample(@Param("record") City record, @Param("example") CityExample example);

    int updateByPrimaryKeySelective(City record);

    @Update({
        "update city",
        "set Name = #{name,jdbcType=CHAR},",
          "CountryCode = #{countrycode,jdbcType=CHAR},",
          "District = #{district,jdbcType=CHAR},",
          "Population = #{population,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(City record);
}