package com.example.demo.mapper;

import com.example.demo.bean.Country;
import com.example.demo.bean.CountryExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface CountryMapper {
    int countByExample(CountryExample example);

    int deleteByExample(CountryExample example);

    @Delete({
        "delete from country",
        "where Code = #{code,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String code);

    @Insert({
        "insert into country (Code, Name, Continent, ",
        "Region, SurfaceArea, IndepYear, ",
        "Population, LifeExpectancy, ",
        "GNP, GNPOld, LocalName, ",
        "GovernmentForm, HeadOfState, ",
        "Capital, Code2)",
        "values (#{code,jdbcType=CHAR}, #{name,jdbcType=CHAR}, #{continent,jdbcType=CHAR}, ",
        "#{region,jdbcType=CHAR}, #{surfacearea,jdbcType=REAL}, #{indepyear,jdbcType=SMALLINT}, ",
        "#{population,jdbcType=INTEGER}, #{lifeexpectancy,jdbcType=REAL}, ",
        "#{gnp,jdbcType=REAL}, #{gnpold,jdbcType=REAL}, #{localname,jdbcType=CHAR}, ",
        "#{governmentform,jdbcType=CHAR}, #{headofstate,jdbcType=CHAR}, ",
        "#{capital,jdbcType=INTEGER}, #{code2,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="code", before=true, resultType=String.class)
    int insert(Country record);

    int insertSelective(Country record);

    List<Country> selectByExample(CountryExample example);

    @Select({
        "select",
        "Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, ",
        "GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2",
        "from country",
        "where Code = #{code,jdbcType=CHAR}"
    })
    @ResultMap("BaseResultMap")
    Country selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") Country record, @Param("example") CountryExample example);

    int updateByExample(@Param("record") Country record, @Param("example") CountryExample example);

    int updateByPrimaryKeySelective(Country record);

    @Update({
        "update country",
        "set Name = #{name,jdbcType=CHAR},",
          "Continent = #{continent,jdbcType=CHAR},",
          "Region = #{region,jdbcType=CHAR},",
          "SurfaceArea = #{surfacearea,jdbcType=REAL},",
          "IndepYear = #{indepyear,jdbcType=SMALLINT},",
          "Population = #{population,jdbcType=INTEGER},",
          "LifeExpectancy = #{lifeexpectancy,jdbcType=REAL},",
          "GNP = #{gnp,jdbcType=REAL},",
          "GNPOld = #{gnpold,jdbcType=REAL},",
          "LocalName = #{localname,jdbcType=CHAR},",
          "GovernmentForm = #{governmentform,jdbcType=CHAR},",
          "HeadOfState = #{headofstate,jdbcType=CHAR},",
          "Capital = #{capital,jdbcType=INTEGER},",
          "Code2 = #{code2,jdbcType=CHAR}",
        "where Code = #{code,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Country record);
}