package com.ztesoft.web.common.db.po;

import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class DbTablePO extends AbstractDto{
	private Integer  id;
	private String  tableName;
	private String  remarks;
	private Integer  dbId;
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return StringUtils.isBlank(tableName) ? tableName : tableName.trim();
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return StringUtils.isBlank(remarks) ? remarks : remarks.trim();
    }
    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }
    public Integer getDbId() {
        return dbId;
    }
}