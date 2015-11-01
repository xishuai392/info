/**
 * 带清除按钮的文本框组件
 */
Ext.define('ZTEsoft.form.field.OrgTreeField', {
	extend : 'ZTEsoft.form.field.GeneralTreeField',
	alias: ['widget.zteorgtree', 'widget.orgTreeField'],
	valueField : 'orgId',
    displayField : 'orgName',
    displayName : '组织名称',
    sqlKey : StrConstants.ORGANIZATION_TREE,
    parentField : 'parentOrgId',
    orderByClause : 'ORG_ID',
    tableName: 'audit_organization',
    title : "组织列表",
    rootId : -1,	
    rootText : "顶级组织",
    rootVisible : false,
    icon : '/common/images/icons/chart_organisation.png',
	constructor : function(config) {
		this.config = config;
		this.callParent([config]);
	}
});