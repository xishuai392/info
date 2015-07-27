package com.ztesoft.core.common;

public class TreeQueryPO {
	private String valueField; 				//节点id字段
	private String displayField;			    //节点显示内容字段
	private String parentField;             //
	private String rootId = "-1";             //
	private String rootText = "根节点";             //
	private String icon;                       //图标 
	private String iconStr;                  //图标 
	private String[] icons;                 //图标 
	private String tableName;
	private String queryConditions;          //不改变值的参数 
    private String orderByClause;
    private String groupByClause;
    public String getValueField() {
        return valueField;
    }
    public void setValueField(String valueField) {
        this.valueField = valueField;
    }
    public String getDisplayField() {
        return displayField;
    }
    public void setDisplayField(String displayField) {
        this.displayField = displayField;
    }
    public String getParentField() {
        return parentField;
    }
    public void setParentField(String parentField) {
        this.parentField = parentField;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getIconStr() {
        return iconStr;
    }
    public void setIconStr(String iconStr) {
        this.iconStr = iconStr;
    }
    public String[] getIcons() {
        return icons;
    }
    public void setIcons(String[] icons) {
        this.icons = icons;
    }
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getQueryConditions() {
        return queryConditions;
    }
    public void setQueryConditions(String queryConditions) {
        this.queryConditions = queryConditions;
    }
    public String getRootId() {
        return rootId;
    }
    public void setRootId(String rootId) {
        this.rootId = rootId;
    }
    public String getRootText() {
        return rootText;
    }
    public void setRootText(String rootText) {
        this.rootText = rootText;
    }
    public String getOrderByClause() {
        return orderByClause;
    }
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    public String getGroupByClause() {
        return groupByClause;
    }
    public void setGroupByClause(String groupByClause) {
        this.groupByClause = groupByClause;
    }
    
}
