package com.ztesoft.web.permission.db.po;

import java.math.*;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class AuditMenuPO extends AbstractDto{
	private Integer  menuId;
	private String  menuTitle;
	private String  menuIconPath;
	private String  urlString;
	private Integer  displayIndex;
	private BigDecimal  height;
	private BigDecimal  width;
	private Integer  parentMenuId;
    public Integer getMenuId() {
        return menuId;
    }
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    
    public String getMenuTitle() {
        return StringUtils.isBlank(menuTitle) ? menuTitle : menuTitle.trim();
    }
    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    
    public String getMenuIconPath() {
        return StringUtils.isBlank(menuIconPath) ? menuIconPath : menuIconPath.trim();
    }
    public void setMenuIconPath(String menuIconPath) {
        this.menuIconPath = menuIconPath;
    }
    
    
    public String getUrlString() {
        return StringUtils.isBlank(urlString) ? urlString : urlString.trim();
    }
    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }
    
    
    public Integer getDisplayIndex() {
        return displayIndex;
    }
    public void setDisplayIndex(Integer displayIndex) {
        this.displayIndex = displayIndex;
    }

    
    public BigDecimal getHeight() {
        return height;
    }
    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    
    public BigDecimal getWidth() {
        return width;
    }
    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    
    public Integer getParentMenuId() {
        return parentMenuId;
    }
    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    
}