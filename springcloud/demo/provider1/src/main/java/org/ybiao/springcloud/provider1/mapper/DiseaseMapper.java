package org.ybiao.springcloud.provider1.mapper;

import org.apache.ibatis.annotations.*;
import org.ybiao.springcloud.provider1.bean.Disease;
import org.ybiao.springcloud.provider1.bean.DiseaseExample;
import org.ybiao.springcloud.provider1.bean.DiseaseKey;

import java.util.List;

@Mapper
public interface DiseaseMapper {
    int countByExample(DiseaseExample example);

    int deleteByExample(DiseaseExample example);

    @Delete({
        "delete from disease",
        "where id = #{id,jdbcType=INTEGER}",
          "and DiseaseICD = #{diseaseicd,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(DiseaseKey key);

    @Insert({
        "insert into disease (id, DiseaseICD, ",
        "DiseaseCode, DiseaseName, ",
        "DiseCategoryID)",
        "values (#{id,jdbcType=INTEGER}, #{diseaseicd,jdbcType=VARCHAR}, ",
        "#{diseasecode,jdbcType=VARCHAR}, #{diseasename,jdbcType=VARCHAR}, ",
        "#{disecategoryid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Disease record);

    int insertSelective(Disease record);

    List<Disease> selectByExample(DiseaseExample example);

    @Select({
        "select",
        "id, DiseaseICD, DiseaseCode, DiseaseName, DiseCategoryID",
        "from disease",
        "where id = #{id,jdbcType=INTEGER}",
          "and DiseaseICD = #{diseaseicd,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Disease selectByPrimaryKey(DiseaseKey key);

    int updateByExampleSelective(@Param("record") Disease record, @Param("example") DiseaseExample example);

    int updateByExample(@Param("record") Disease record, @Param("example") DiseaseExample example);

    int updateByPrimaryKeySelective(Disease record);

    @Update({
        "update disease",
        "set DiseaseCode = #{diseasecode,jdbcType=VARCHAR},",
          "DiseaseName = #{diseasename,jdbcType=VARCHAR},",
          "DiseCategoryID = #{disecategoryid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}",
          "and DiseaseICD = #{diseaseicd,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Disease record);
}