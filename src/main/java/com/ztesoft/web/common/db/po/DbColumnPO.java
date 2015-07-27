package com.ztesoft.web.common.db.po;

import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class DbColumnPO extends AbstractDto{
	private Integer  id;
	private Integer  tableId;
	private String  keyType;
	private String  name;
	private String  type;
	private Integer  size;
	private String  nullAble;
	private String  defaultValue;
	private String  remarks;
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }
    public Integer getTableId() {
        return tableId;
    }
    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getKeyType() {
        return StringUtils.isBlank(keyType) ? keyType : keyType.trim();
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return StringUtils.isBlank(name) ? name : name.trim();
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return StringUtils.isBlank(type) ? type : type.trim();
    }
    public void setSize(Integer size) {
        this.size = size;
    }
    public Integer getSize() {
        return size;
    }
    public void setNullAble(String nullAble) {
        this.nullAble = nullAble;
    }

    public String getNullAble() {
        return StringUtils.isBlank(nullAble) ? nullAble : nullAble.trim();
    }
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return StringUtils.isBlank(defaultValue) ? defaultValue : defaultValue.trim();
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return StringUtils.isBlank(remarks) ? remarks : remarks.trim();
    }
}