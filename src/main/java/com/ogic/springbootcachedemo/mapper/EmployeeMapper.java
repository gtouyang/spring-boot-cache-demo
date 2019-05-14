package com.ogic.springbootcachedemo.mapper;

import com.ogic.springbootcachedemo.bean.Department;
import com.ogic.springbootcachedemo.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    public Employee getEmpById(Integer id);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    public Integer deleteEmpById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO department(lastName,email,gender,dId) VALUES(#{lastName},#{email},#{gender},#{dId})")
    public Integer insertEmp(Employee employee);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},dId=#{dId} WHERE id = #{id}")
    public Integer updateEmp(Employee employee);

    @Select("SELECT * FROM employee WHERE lastName = #{lastName}")
    public Employee getEmpByLastName(String lastName);
}
