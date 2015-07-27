package com.ztesoft.web.demo.db.po;

import java.math.*;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class EhcachePO extends AbstractDto{
	private Integer  empId;
	private String  empName;
	private Integer  empAge;
	private String  empSex;
	private Date  empBirthday;
    public Integer getEmpId() {
        return empId;
    }
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    
    public String getEmpName() {
        return StringUtils.isBlank(empName) ? empName : empName.trim();
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
    
    public Integer getEmpAge() {
        return empAge;
    }
    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    
    public String getEmpSex() {
        return StringUtils.isBlank(empSex) ? empSex : empSex.trim();
    }
    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }
    
    
    public Date getEmpBirthday() {
        return empBirthday;
    }
    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
    }

    
}