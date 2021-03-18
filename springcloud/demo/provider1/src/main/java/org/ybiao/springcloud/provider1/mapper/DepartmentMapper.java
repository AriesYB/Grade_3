package org.ybiao.springcloud.provider1.mapper;

import org.apache.ibatis.annotations.*;
import org.ybiao.springcloud.provider1.bean.Department;
import org.ybiao.springcloud.provider1.bean.DepartmentExample;
import org.ybiao.springcloud.provider1.bean.DepartmentKey;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    @Delete({
        "delete from department",
        "where id = #{id,jdbcType=INTEGER}",
          "and DeptCode = #{deptcode,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(DepartmentKey key);

    @Insert({
        "insert into department (id, DeptCode, ",
        "DeptName, DeptCategoryID, ",
        "DeptType, isDeleted)",
        "values (#{id,jdbcType=INTEGER}, #{deptcode,jdbcType=VARCHAR}, ",
        "#{deptname,jdbcType=VARCHAR}, #{deptcategoryid,jdbcType=INTEGER}, ",
        "#{depttype,jdbcType=INTEGER}, #{isdeleted,jdbcType=INTEGER})"
    })
    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    @Select({
        "select",
        "id, DeptCode, DeptName, DeptCategoryID, DeptType, isDeleted",
        "from department",
        "where id = #{id,jdbcType=INTEGER}",
          "and DeptCode = #{deptcode,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Department selectByPrimaryKey(DepartmentKey key);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    @Update({
        "update department",
        "set DeptName = #{deptname,jdbcType=VARCHAR},",
          "DeptCategoryID = #{deptcategoryid,jdbcType=INTEGER},",
          "DeptType = #{depttype,jdbcType=INTEGER},",
          "isDeleted = #{isdeleted,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}",
          "and DeptCode = #{deptcode,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Department record);
}