package org.ybiao.springcloud.provider2.mapper;

import org.apache.ibatis.annotations.*;
import org.ybiao.springcloud.provider2.bean.Patient;
import org.ybiao.springcloud.provider2.bean.PatientExample;
import org.ybiao.springcloud.provider2.bean.PatientKey;

import java.util.List;

@Mapper
public interface PatientMapper {
    int countByExample(PatientExample example);

    int deleteByExample(PatientExample example);

    @Delete({
        "delete from patient",
        "where id = #{id,jdbcType=INTEGER}",
          "and ID_number = #{idNumber,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(PatientKey key);

    @Insert({
        "insert into patient (id, ID_number, ",
        "name, sex, date_birth, ",
        "age, address, isDeleted)",
        "values (#{id,jdbcType=INTEGER}, #{idNumber,jdbcType=CHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{sex,jdbcType=INTEGER}, #{dateBirth,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER}, #{address,jdbcType=VARCHAR}, #{isdeleted,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Patient record);

    int insertSelective(Patient record);

    List<Patient> selectByExample(PatientExample example);

    @Select({
        "select",
        "id, ID_number, name, sex, date_birth, age, address, isDeleted",
        "from patient",
        "where id = #{id,jdbcType=INTEGER}",
          "and ID_number = #{idNumber,jdbcType=CHAR}"
    })
    @ResultMap("BaseResultMap")
    Patient selectByPrimaryKey(PatientKey key);

    int updateByExampleSelective(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByExample(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByPrimaryKeySelective(Patient record);

    @Update({
        "update patient",
        "set name = #{name,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=INTEGER},",
          "date_birth = #{dateBirth,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "address = #{address,jdbcType=VARCHAR},",
          "isDeleted = #{isdeleted,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}",
          "and ID_number = #{idNumber,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Patient record);
}