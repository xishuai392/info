package com.ztesoft.web.permission.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class AuditOrganizationArg {
    private String pk_name = "ORG_ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<AuditOrganizationCriteria> oredCriteria;

    public AuditOrganizationArg() {
        oredCriteria = new ArrayList<AuditOrganizationCriteria>();
    }

    public void setPk_name(String pk_name) {
        this.pk_name = StringEscapeUtils.escapeSql(pk_name);
    }

    public String getPk_name() {
        return pk_name;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = StringEscapeUtils.escapeSql(orderByClause);
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setGroupByClause(String groupByClause) {
        this.groupByClause = StringEscapeUtils.escapeSql(groupByClause);
    }

    public String geGroupByClause() {
        return groupByClause;
    }

    public void setColumns(String columns) {
        this.columns = StringEscapeUtils.escapeSql(columns);
    }

    public String geColumns() {
        return columns;
    }

    public void setCountsql1(String countsql1) {
        this.countsql1 = StringEscapeUtils.escapeSql(countsql1);
    }

    public String geCountsql1() {
        return countsql1;
    }

    public void setCountsql2(String countsql2) {
        this.countsql2 = StringEscapeUtils.escapeSql(countsql2);
    }

    public String geCountsql2() {
        return countsql2;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setRowStart(int rowStart) {
        this.rowStart = rowStart;
    }

    public void setRowEnd(int rowEnd) {
        this.rowEnd = rowEnd;
    }

    public int getRowStart() {
        return rowStart;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public List<AuditOrganizationCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(AuditOrganizationCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public AuditOrganizationCriteria or() {
    	AuditOrganizationCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AuditOrganizationCriteria createCriteria() {
    	AuditOrganizationCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AuditOrganizationCriteria createCriteriaInternal() {
    	AuditOrganizationCriteria criteria = new AuditOrganizationCriteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        groupByClause = null;
        columns = null;
        countsql1 = null;
        countsql2 = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<AuditOrganizationCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<AuditOrganizationCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<AuditOrganizationCriterion> getAllCriteria() {
            return criteria;
        }

        public List<AuditOrganizationCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new AuditOrganizationCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditOrganizationCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditOrganizationCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditOrganizationCriterion(condition, value1, value2));
        }

        public AuditOrganizationCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (AuditOrganizationCriteria) this;
        }
        public AuditOrganizationCriteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdEqualTo(Long value) {
            addCriterion("ORG_ID =", value, "ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdNotEqualTo(Long value) {
            addCriterion("ORG_ID <>", value, "ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdGreaterThan(Long value) {
            addCriterion("ORG_ID >", value, "ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORG_ID >=", value, "ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdLessThan(Long value) {
            addCriterion("ORG_ID <", value, "ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("ORG_ID <=", value, "ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdLike(Long value) {
            addCriterion("ORG_ID like ", value, "ORG_ID", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdNotLike(Long value) {
            addCriterion("ORG_ID  not like ", value, "ORG_ID", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdLeftLike(Long value) {
            addCriterion("ORG_ID like ", value, "ORG_ID", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdNotLeftLike(Long value) {
            addCriterion("ORG_ID  not like ", value, "ORG_ID", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdRightLike(Long value) {
            addCriterion("ORG_ID like ", value, "ORG_ID", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdNotRightLike(Long value) {
            addCriterion("ORG_ID  not like ", value, "ORG_ID", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdIn(List<Long> values) {
            addCriterion("ORG_ID  in ", values, "ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdNotIn(List<Long> values) {
            addCriterion("ORG_ID not in ", values, "ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdBetween(Long value1, Long value2) {
            addCriterion("ORG_ID between ", value1, value2, "ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("ORG_ID not between ", value1, value2, "ORG_ID");
            return (AuditOrganizationCriteria) this;
        }
        public AuditOrganizationCriteria andParentOrgIdIsNull() {
            addCriterion("PARENT_ORG_ID is null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdIsNotNull() {
            addCriterion("PARENT_ORG_ID is not null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdEqualTo(Long value) {
            addCriterion("PARENT_ORG_ID =", value, "PARENT_ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdNotEqualTo(Long value) {
            addCriterion("PARENT_ORG_ID <>", value, "PARENT_ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdGreaterThan(Long value) {
            addCriterion("PARENT_ORG_ID >", value, "PARENT_ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PARENT_ORG_ID >=", value, "PARENT_ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdLessThan(Long value) {
            addCriterion("PARENT_ORG_ID <", value, "PARENT_ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("PARENT_ORG_ID <=", value, "PARENT_ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdLike(Long value) {
            addCriterion("PARENT_ORG_ID like ", value, "PARENT_ORG_ID", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdNotLike(Long value) {
            addCriterion("PARENT_ORG_ID  not like ", value, "PARENT_ORG_ID", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdLeftLike(Long value) {
            addCriterion("PARENT_ORG_ID like ", value, "PARENT_ORG_ID", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdNotLeftLike(Long value) {
            addCriterion("PARENT_ORG_ID  not like ", value, "PARENT_ORG_ID", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdRightLike(Long value) {
            addCriterion("PARENT_ORG_ID like ", value, "PARENT_ORG_ID", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdNotRightLike(Long value) {
            addCriterion("PARENT_ORG_ID  not like ", value, "PARENT_ORG_ID", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdIn(List<Long> values) {
            addCriterion("PARENT_ORG_ID  in ", values, "PARENT_ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdNotIn(List<Long> values) {
            addCriterion("PARENT_ORG_ID not in ", values, "PARENT_ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdBetween(Long value1, Long value2) {
            addCriterion("PARENT_ORG_ID between ", value1, value2, "PARENT_ORG_ID");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andParentOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("PARENT_ORG_ID not between ", value1, value2, "PARENT_ORG_ID");
            return (AuditOrganizationCriteria) this;
        }
        public AuditOrganizationCriteria andOrgCodeIsNull() {
            addCriterion("ORG_CODE is null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeIsNotNull() {
            addCriterion("ORG_CODE is not null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeEqualTo(String value) {
            addCriterion("ORG_CODE =", value, "ORG_CODE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeNotEqualTo(String value) {
            addCriterion("ORG_CODE <>", value, "ORG_CODE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeGreaterThan(String value) {
            addCriterion("ORG_CODE >", value, "ORG_CODE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_CODE >=", value, "ORG_CODE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeLessThan(String value) {
            addCriterion("ORG_CODE <", value, "ORG_CODE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("ORG_CODE <=", value, "ORG_CODE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeLike(String value) {
            addCriterion("ORG_CODE like ", value, "ORG_CODE", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeNotLike(String value) {
            addCriterion("ORG_CODE  not like ", value, "ORG_CODE", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeLeftLike(String value) {
            addCriterion("ORG_CODE like ", value, "ORG_CODE", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeNotLeftLike(String value) {
            addCriterion("ORG_CODE  not like ", value, "ORG_CODE", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeRightLike(String value) {
            addCriterion("ORG_CODE like ", value, "ORG_CODE", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeNotRightLike(String value) {
            addCriterion("ORG_CODE  not like ", value, "ORG_CODE", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeIn(List<String> values) {
            addCriterion("ORG_CODE  in ", values, "ORG_CODE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeNotIn(List<String> values) {
            addCriterion("ORG_CODE not in ", values, "ORG_CODE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("ORG_CODE between ", value1, value2, "ORG_CODE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("ORG_CODE not between ", value1, value2, "ORG_CODE");
            return (AuditOrganizationCriteria) this;
        }
        public AuditOrganizationCriteria andOrgNameIsNull() {
            addCriterion("ORG_NAME is null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameIsNotNull() {
            addCriterion("ORG_NAME is not null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameEqualTo(String value) {
            addCriterion("ORG_NAME =", value, "ORG_NAME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameNotEqualTo(String value) {
            addCriterion("ORG_NAME <>", value, "ORG_NAME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameGreaterThan(String value) {
            addCriterion("ORG_NAME >", value, "ORG_NAME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_NAME >=", value, "ORG_NAME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameLessThan(String value) {
            addCriterion("ORG_NAME <", value, "ORG_NAME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("ORG_NAME <=", value, "ORG_NAME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameLike(String value) {
            addCriterion("ORG_NAME like ", value, "ORG_NAME", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameNotLike(String value) {
            addCriterion("ORG_NAME  not like ", value, "ORG_NAME", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameLeftLike(String value) {
            addCriterion("ORG_NAME like ", value, "ORG_NAME", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameNotLeftLike(String value) {
            addCriterion("ORG_NAME  not like ", value, "ORG_NAME", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameRightLike(String value) {
            addCriterion("ORG_NAME like ", value, "ORG_NAME", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameNotRightLike(String value) {
            addCriterion("ORG_NAME  not like ", value, "ORG_NAME", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameIn(List<String> values) {
            addCriterion("ORG_NAME  in ", values, "ORG_NAME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameNotIn(List<String> values) {
            addCriterion("ORG_NAME not in ", values, "ORG_NAME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameBetween(String value1, String value2) {
            addCriterion("ORG_NAME between ", value1, value2, "ORG_NAME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("ORG_NAME not between ", value1, value2, "ORG_NAME");
            return (AuditOrganizationCriteria) this;
        }
        public AuditOrganizationCriteria andOrgLevelIsNull() {
            addCriterion("ORG_LEVEL is null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelIsNotNull() {
            addCriterion("ORG_LEVEL is not null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelEqualTo(Long value) {
            addCriterion("ORG_LEVEL =", value, "ORG_LEVEL");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelNotEqualTo(Long value) {
            addCriterion("ORG_LEVEL <>", value, "ORG_LEVEL");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelGreaterThan(Long value) {
            addCriterion("ORG_LEVEL >", value, "ORG_LEVEL");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelGreaterThanOrEqualTo(Long value) {
            addCriterion("ORG_LEVEL >=", value, "ORG_LEVEL");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelLessThan(Long value) {
            addCriterion("ORG_LEVEL <", value, "ORG_LEVEL");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelLessThanOrEqualTo(Long value) {
            addCriterion("ORG_LEVEL <=", value, "ORG_LEVEL");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelLike(Long value) {
            addCriterion("ORG_LEVEL like ", value, "ORG_LEVEL", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelNotLike(Long value) {
            addCriterion("ORG_LEVEL  not like ", value, "ORG_LEVEL", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelLeftLike(Long value) {
            addCriterion("ORG_LEVEL like ", value, "ORG_LEVEL", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelNotLeftLike(Long value) {
            addCriterion("ORG_LEVEL  not like ", value, "ORG_LEVEL", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelRightLike(Long value) {
            addCriterion("ORG_LEVEL like ", value, "ORG_LEVEL", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelNotRightLike(Long value) {
            addCriterion("ORG_LEVEL  not like ", value, "ORG_LEVEL", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelIn(List<Long> values) {
            addCriterion("ORG_LEVEL  in ", values, "ORG_LEVEL");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelNotIn(List<Long> values) {
            addCriterion("ORG_LEVEL not in ", values, "ORG_LEVEL");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelBetween(Long value1, Long value2) {
            addCriterion("ORG_LEVEL between ", value1, value2, "ORG_LEVEL");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgLevelNotBetween(Long value1, Long value2) {
            addCriterion("ORG_LEVEL not between ", value1, value2, "ORG_LEVEL");
            return (AuditOrganizationCriteria) this;
        }
        public AuditOrganizationCriteria andCreatedTimeIsNull() {
            addCriterion("CREATED_TIME is null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeIsNotNull() {
            addCriterion("CREATED_TIME is not null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeEqualTo(Date value) {
            addCriterion("CREATED_TIME =", value, "CREATED_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("CREATED_TIME <>", value, "CREATED_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("CREATED_TIME >", value, "CREATED_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_TIME >=", value, "CREATED_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeLessThan(Date value) {
            addCriterion("CREATED_TIME <", value, "CREATED_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_TIME <=", value, "CREATED_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeLike(Date value) {
            addCriterion("CREATED_TIME like ", value, "CREATED_TIME", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeNotLike(Date value) {
            addCriterion("CREATED_TIME  not like ", value, "CREATED_TIME", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeLeftLike(Date value) {
            addCriterion("CREATED_TIME like ", value, "CREATED_TIME", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeNotLeftLike(Date value) {
            addCriterion("CREATED_TIME  not like ", value, "CREATED_TIME", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeRightLike(Date value) {
            addCriterion("CREATED_TIME like ", value, "CREATED_TIME", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeNotRightLike(Date value) {
            addCriterion("CREATED_TIME  not like ", value, "CREATED_TIME", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeIn(List<Date> values) {
            addCriterion("CREATED_TIME  in ", values, "CREATED_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("CREATED_TIME not in ", values, "CREATED_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("CREATED_TIME between ", value1, value2, "CREATED_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_TIME not between ", value1, value2, "CREATED_TIME");
            return (AuditOrganizationCriteria) this;
        }
        public AuditOrganizationCriteria andOrgDescIsNull() {
            addCriterion("ORG_DESC is null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescIsNotNull() {
            addCriterion("ORG_DESC is not null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescEqualTo(String value) {
            addCriterion("ORG_DESC =", value, "ORG_DESC");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescNotEqualTo(String value) {
            addCriterion("ORG_DESC <>", value, "ORG_DESC");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescGreaterThan(String value) {
            addCriterion("ORG_DESC >", value, "ORG_DESC");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_DESC >=", value, "ORG_DESC");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescLessThan(String value) {
            addCriterion("ORG_DESC <", value, "ORG_DESC");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescLessThanOrEqualTo(String value) {
            addCriterion("ORG_DESC <=", value, "ORG_DESC");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescLike(String value) {
            addCriterion("ORG_DESC like ", value, "ORG_DESC", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescNotLike(String value) {
            addCriterion("ORG_DESC  not like ", value, "ORG_DESC", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescLeftLike(String value) {
            addCriterion("ORG_DESC like ", value, "ORG_DESC", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescNotLeftLike(String value) {
            addCriterion("ORG_DESC  not like ", value, "ORG_DESC", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescRightLike(String value) {
            addCriterion("ORG_DESC like ", value, "ORG_DESC", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescNotRightLike(String value) {
            addCriterion("ORG_DESC  not like ", value, "ORG_DESC", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescIn(List<String> values) {
            addCriterion("ORG_DESC  in ", values, "ORG_DESC");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescNotIn(List<String> values) {
            addCriterion("ORG_DESC not in ", values, "ORG_DESC");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescBetween(String value1, String value2) {
            addCriterion("ORG_DESC between ", value1, value2, "ORG_DESC");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andOrgDescNotBetween(String value1, String value2) {
            addCriterion("ORG_DESC not between ", value1, value2, "ORG_DESC");
            return (AuditOrganizationCriteria) this;
        }
        public AuditOrganizationCriteria andStateIsNull() {
            addCriterion("STATE is null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "STATE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "STATE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "STATE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "STATE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "STATE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "STATE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateLike(String value) {
            addCriterion("STATE like ", value, "STATE", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateNotLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateLeftLike(String value) {
            addCriterion("STATE like ", value, "STATE", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateNotLeftLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateRightLike(String value) {
            addCriterion("STATE like ", value, "STATE", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateNotRightLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateIn(List<String> values) {
            addCriterion("STATE  in ", values, "STATE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in ", values, "STATE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between ", value1, value2, "STATE");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between ", value1, value2, "STATE");
            return (AuditOrganizationCriteria) this;
        }
        public AuditOrganizationCriteria andStateTimeIsNull() {
            addCriterion("STATE_TIME is null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeIsNotNull() {
            addCriterion("STATE_TIME is not null");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeEqualTo(Date value) {
            addCriterion("STATE_TIME =", value, "STATE_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeNotEqualTo(Date value) {
            addCriterion("STATE_TIME <>", value, "STATE_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeGreaterThan(Date value) {
            addCriterion("STATE_TIME >", value, "STATE_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STATE_TIME >=", value, "STATE_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeLessThan(Date value) {
            addCriterion("STATE_TIME <", value, "STATE_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeLessThanOrEqualTo(Date value) {
            addCriterion("STATE_TIME <=", value, "STATE_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeLike(Date value) {
            addCriterion("STATE_TIME like ", value, "STATE_TIME", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeNotLike(Date value) {
            addCriterion("STATE_TIME  not like ", value, "STATE_TIME", 1);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeLeftLike(Date value) {
            addCriterion("STATE_TIME like ", value, "STATE_TIME", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeNotLeftLike(Date value) {
            addCriterion("STATE_TIME  not like ", value, "STATE_TIME", 0);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeRightLike(Date value) {
            addCriterion("STATE_TIME like ", value, "STATE_TIME", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeNotRightLike(Date value) {
            addCriterion("STATE_TIME  not like ", value, "STATE_TIME", 2);
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeIn(List<Date> values) {
            addCriterion("STATE_TIME  in ", values, "STATE_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeNotIn(List<Date> values) {
            addCriterion("STATE_TIME not in ", values, "STATE_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeBetween(Date value1, Date value2) {
            addCriterion("STATE_TIME between ", value1, value2, "STATE_TIME");
            return (AuditOrganizationCriteria) this;
        }

        public AuditOrganizationCriteria andStateTimeNotBetween(Date value1, Date value2) {
            addCriterion("STATE_TIME not between ", value1, value2, "STATE_TIME");
            return (AuditOrganizationCriteria) this;
        }

    }

    public static class AuditOrganizationCriteria extends GeneratedCriteria {

        protected AuditOrganizationCriteria() {
            super();
        }
    }

    public static class AuditOrganizationCriterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected AuditOrganizationCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected AuditOrganizationCriterion(String condition, Object value, int likeType) {
            this.condition = condition;
            if (likeType == 0) {
                this.value = "%" + value;
            }
            else if (likeType == 1) {
                this.value = "%" + value + "%";
            }
            else {
                this.value = value + "%";
            }
            this.typeHandler = null;
            this.singleValue = true;

        }

        protected AuditOrganizationCriterion(String condition, Object value,
                String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            }
            else {
                this.singleValue = true;
            }
        }

        protected AuditOrganizationCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected AuditOrganizationCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected AuditOrganizationCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}