package org.ybiao.springcloud.provider1.mapper;

import org.apache.ibatis.annotations.*;
import org.ybiao.springcloud.provider1.bean.Drugs;
import org.ybiao.springcloud.provider1.bean.DrugsExample;

import java.util.List;

@Mapper
public interface DrugsMapper {
    int countByExample(DrugsExample example);

    int deleteByExample(DrugsExample example);

    @Delete({
        "delete from drugs",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into drugs (id, DrugsCode, ",
        "DrugsName, DrugsFormat, ",
        "DrugsUnit, Manufacturer, ",
        "DrugsDosageID, DrugsTypeID, ",
        "DrugsPrice, MnemonicCode, ",
        "CreationDate, isDeleted)",
        "values (#{id,jdbcType=INTEGER}, #{drugscode,jdbcType=VARCHAR}, ",
        "#{drugsname,jdbcType=VARCHAR}, #{drugsformat,jdbcType=VARCHAR}, ",
        "#{drugsunit,jdbcType=VARCHAR}, #{manufacturer,jdbcType=VARCHAR}, ",
        "#{drugsdosageid,jdbcType=INTEGER}, #{drugstypeid,jdbcType=INTEGER}, ",
        "#{drugsprice,jdbcType=DOUBLE}, #{mnemoniccode,jdbcType=VARCHAR}, ",
        "#{creationdate,jdbcType=DATE}, #{isdeleted,jdbcType=INTEGER})"
    })
    int insert(Drugs record);

    int insertSelective(Drugs record);

    List<Drugs> selectByExample(DrugsExample example);

    @Select({
        "select",
        "id, DrugsCode, DrugsName, DrugsFormat, DrugsUnit, Manufacturer, DrugsDosageID, ",
        "DrugsTypeID, DrugsPrice, MnemonicCode, CreationDate, isDeleted",
        "from drugs",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Drugs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Drugs record, @Param("example") DrugsExample example);

    int updateByExample(@Param("record") Drugs record, @Param("example") DrugsExample example);

    int updateByPrimaryKeySelective(Drugs record);

    @Update({
        "update drugs",
        "set DrugsCode = #{drugscode,jdbcType=VARCHAR},",
          "DrugsName = #{drugsname,jdbcType=VARCHAR},",
          "DrugsFormat = #{drugsformat,jdbcType=VARCHAR},",
          "DrugsUnit = #{drugsunit,jdbcType=VARCHAR},",
          "Manufacturer = #{manufacturer,jdbcType=VARCHAR},",
          "DrugsDosageID = #{drugsdosageid,jdbcType=INTEGER},",
          "DrugsTypeID = #{drugstypeid,jdbcType=INTEGER},",
          "DrugsPrice = #{drugsprice,jdbcType=DOUBLE},",
          "MnemonicCode = #{mnemoniccode,jdbcType=VARCHAR},",
          "CreationDate = #{creationdate,jdbcType=DATE},",
          "isDeleted = #{isdeleted,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Drugs record);
}