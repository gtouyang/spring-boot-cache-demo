package com.ogic.springbootcachedemo.service;

import com.ogic.springbootcachedemo.bean.Employee;
import com.ogic.springbootcachedemo.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    Logger logger;

    public EmployeeService(){
        logger= LoggerFactory.getLogger(EmployeeService.class);
    }

    @Cacheable(cacheNames = "employee", condition = "#id>0", unless = "#result == null")
    public Employee getEmpById(Integer id){
        logger.info("query the employee whose id equal to " + id);
        return employeeMapper.getEmpById(id);
    }

    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmp(Employee employee){
        logger.info("update the employee's info of :"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(cacheNames = "emp")
    public void deleteEmp(Integer id){
        logger.info("delete the employee whose id equal to " + id);
        employeeMapper.deleteEmpById(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value="emp",key = "#lastName")
            },
            put = {
                    @CachePut(value="emp",key = "#result.id"),
                    @CachePut(value="emp",key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }

}
