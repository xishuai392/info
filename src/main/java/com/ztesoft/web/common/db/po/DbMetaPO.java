package com.ztesoft.web.common.db.po;

import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class DbMetaPO extends AbstractDto{
	private Integer  id;
	private String  dbName;
	private String  type;
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbName() {
        return StringUtils.isBlank(dbName) ? dbName : dbName.trim();
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return StringUtils.isBlank(type) ? type : type.trim();
    }
}