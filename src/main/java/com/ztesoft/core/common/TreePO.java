package com.ztesoft.core.common;

import java.util.Arrays;
import java.util.Map;

public class TreePO {
    private String sqlKey;
    private String sqlKeyOther;              //第二个sql语句
	private String valueField; 				//节点id字段
	private String displayField;			    //节点显示内容字段
	private String checkField;               //节点显示内容字段
	private String checked;                //显示复选框的层级 
	private Integer deep;                   //递归查询深度 
	private String icon;                       //图标 
	private String iconStr;                  //图标 
	private String[] icons;                 //图标 
	private String unChangeParamStr;          //不改变值的参数 
	private Map<String,Object> paramData;
	
	public String getSqlKeyOther() {
		return sqlKeyOther;
	}
	public void setSqlKeyOther(String sqlKeyOther) {
		this.sqlKeyOther = sqlKeyOther;
	}
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
    public String getCheckField() {
        return checkField;
    }
    public void setCheckField(String checkField) {
        this.checkField = checkField;
    }
    public String getChecked() {
        return checked;
    }
    public void setChecked(String checked) {
        this.checked = checked;
    }
    public Integer getDeep() {
        return deep;
    }
    public void setDeep(Integer deep) {
        this.deep = deep;
    }
    public String[] getIcons() {
        return icons;
    }
    public void setIcons(String[] icons) {
        this.icons = icons;
    }
    public String getSqlKey() {
        return sqlKey;
    }
    public void setSqlKey(String sqlKey) {
        this.sqlKey = sqlKey;
    }
    public String getIconStr() {
        return iconStr;
    }
    public void setIconStr(String iconStr) {
        this.iconStr = iconStr;
    }
    public String getUnChangeParamStr() {
        return unChangeParamStr;
    }
    public void setUnChangeParamStr(String unChangeParamStr) {
        this.unChangeParamStr = unChangeParamStr;
    }
    public Map<String, Object> getParamData() {
        return paramData;
    }
    public void setParamData(Map<String, Object> paramData) {
        this.paramData = paramData;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TreePO [sqlKey=" + sqlKey + ", sqlKeyOther=" + sqlKeyOther + ", valueField=" + valueField
				+ ", displayField=" + displayField + ", checkField=" + checkField + ", checked=" + checked + ", deep="
				+ deep + ", icon=" + icon + ", iconStr=" + iconStr + ", icons=" + Arrays.toString(icons)
				+ ", unChangeParamStr=" + unChangeParamStr + ", paramData=" + paramData + "]";
	}
    
}
