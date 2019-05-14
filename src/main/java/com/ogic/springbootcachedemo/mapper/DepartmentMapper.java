package com.ogic.springbootcachedemo.mapper;

import com.ogic.springbootcachedemo.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("DELETE FROM department WHERE id = #{id}")
    public Integer deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO department(departmentName) VALUES(#{departmentName})")
    public Integer insertDept(Department department);

    @Update("UPDATE department SET departmentName=#{departmentName} WHERE id = #{id}")
    public Integer updateDept(Department department);
}
