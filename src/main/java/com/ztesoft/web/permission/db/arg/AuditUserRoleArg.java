package com.ztesoft.web.permission.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class AuditUserRoleArg {
    private String pk_name = "USER_ROLE_ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<AuditUserRoleCriteria> oredCriteria;

    public AuditUserRoleArg() {
        oredCriteria = new ArrayList<AuditUserRoleCriteria>();
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

    public List<AuditUserRoleCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(AuditUserRoleCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public AuditUserRoleCriteria or() {
    	AuditUserRoleCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AuditUserRoleCriteria createCriteria() {
    	AuditUserRoleCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AuditUserRoleCriteria createCriteriaInternal() {
    	AuditUserRoleCriteria criteria = new AuditUserRoleCriteria();
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
        protected List<AuditUserRoleCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<AuditUserRoleCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<AuditUserRoleCriterion> getAllCriteria() {
            return criteria;
        }

        public List<AuditUserRoleCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new AuditUserRoleCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditUserRoleCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditUserRoleCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditUserRoleCriterion(condition, value1, value2));
        }

        public AuditUserRoleCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (AuditUserRoleCriteria) this;
        }
        public AuditUserRoleCriteria andUserRoleIdIsNull() {
            addCriterion("USER_ROLE_ID is null");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdIsNotNull() {
            addCriterion("USER_ROLE_ID is not null");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdEqualTo(Integer value) {
            addCriterion("USER_ROLE_ID =", value, "USER_ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdNotEqualTo(Integer value) {
            addCriterion("USER_ROLE_ID <>", value, "USER_ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdGreaterThan(Integer value) {
            addCriterion("USER_ROLE_ID >", value, "USER_ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ROLE_ID >=", value, "USER_ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdLessThan(Integer value) {
            addCriterion("USER_ROLE_ID <", value, "USER_ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ROLE_ID <=", value, "USER_ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdLike(Integer value) {
            addCriterion("USER_ROLE_ID like ", value, "USER_ROLE_ID", 1);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdNotLike(Integer value) {
            addCriterion("USER_ROLE_ID  not like ", value, "USER_ROLE_ID", 1);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdLeftLike(Integer value) {
            addCriterion("USER_ROLE_ID like ", value, "USER_ROLE_ID", 0);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdNotLeftLike(Integer value) {
            addCriterion("USER_ROLE_ID  not like ", value, "USER_ROLE_ID", 0);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdRightLike(Integer value) {
            addCriterion("USER_ROLE_ID like ", value, "USER_ROLE_ID", 2);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdNotRightLike(Integer value) {
            addCriterion("USER_ROLE_ID  not like ", value, "USER_ROLE_ID", 2);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdIn(List<Integer> values) {
            addCriterion("USER_ROLE_ID  in ", values, "USER_ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdNotIn(List<Integer> values) {
            addCriterion("USER_ROLE_ID not in ", values, "USER_ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ROLE_ID between ", value1, value2, "USER_ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ROLE_ID not between ", value1, value2, "USER_ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }
        public AuditUserRoleCriteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdEqualTo(Integer value) {
            addCriterion("ROLE_ID =", value, "ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("ROLE_ID <>", value, "ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdGreaterThan(Integer value) {
            addCriterion("ROLE_ID >", value, "ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID >=", value, "ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdLessThan(Integer value) {
            addCriterion("ROLE_ID <", value, "ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID <=", value, "ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdLike(Integer value) {
            addCriterion("ROLE_ID like ", value, "ROLE_ID", 1);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdNotLike(Integer value) {
            addCriterion("ROLE_ID  not like ", value, "ROLE_ID", 1);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdLeftLike(Integer value) {
            addCriterion("ROLE_ID like ", value, "ROLE_ID", 0);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdNotLeftLike(Integer value) {
            addCriterion("ROLE_ID  not like ", value, "ROLE_ID", 0);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdRightLike(Integer value) {
            addCriterion("ROLE_ID like ", value, "ROLE_ID", 2);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdNotRightLike(Integer value) {
            addCriterion("ROLE_ID  not like ", value, "ROLE_ID", 2);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdIn(List<Integer> values) {
            addCriterion("ROLE_ID  in ", values, "ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("ROLE_ID not in ", values, "ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID between ", value1, value2, "ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID not between ", value1, value2, "ROLE_ID");
            return (AuditUserRoleCriteria) this;
        }
        public AuditUserRoleCriteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "USER_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "USER_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "USER_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "USER_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "USER_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "USER_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 1);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdNotLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 1);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdLeftLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 0);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdNotLeftLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 0);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdRightLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 2);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdNotRightLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 2);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID  in ", values, "USER_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in ", values, "USER_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between ", value1, value2, "USER_ID");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between ", value1, value2, "USER_ID");
            return (AuditUserRoleCriteria) this;
        }
        public AuditUserRoleCriteria andStateIsNull() {
            addCriterion("STATE is null");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "STATE");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "STATE");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "STATE");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "STATE");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "STATE");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "STATE");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateLike(String value) {
            addCriterion("STATE like ", value, "STATE", 1);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateNotLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 1);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateLeftLike(String value) {
            addCriterion("STATE like ", value, "STATE", 0);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateNotLeftLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 0);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateRightLike(String value) {
            addCriterion("STATE like ", value, "STATE", 2);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateNotRightLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 2);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateIn(List<String> values) {
            addCriterion("STATE  in ", values, "STATE");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in ", values, "STATE");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between ", value1, value2, "STATE");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between ", value1, value2, "STATE");
            return (AuditUserRoleCriteria) this;
        }
        public AuditUserRoleCriteria andIsNormalIsNull() {
            addCriterion("IS_NORMAL is null");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalIsNotNull() {
            addCriterion("IS_NORMAL is not null");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalEqualTo(String value) {
            addCriterion("IS_NORMAL =", value, "IS_NORMAL");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalNotEqualTo(String value) {
            addCriterion("IS_NORMAL <>", value, "IS_NORMAL");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalGreaterThan(String value) {
            addCriterion("IS_NORMAL >", value, "IS_NORMAL");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalGreaterThanOrEqualTo(String value) {
            addCriterion("IS_NORMAL >=", value, "IS_NORMAL");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalLessThan(String value) {
            addCriterion("IS_NORMAL <", value, "IS_NORMAL");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalLessThanOrEqualTo(String value) {
            addCriterion("IS_NORMAL <=", value, "IS_NORMAL");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalLike(String value) {
            addCriterion("IS_NORMAL like ", value, "IS_NORMAL", 1);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalNotLike(String value) {
            addCriterion("IS_NORMAL  not like ", value, "IS_NORMAL", 1);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalLeftLike(String value) {
            addCriterion("IS_NORMAL like ", value, "IS_NORMAL", 0);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalNotLeftLike(String value) {
            addCriterion("IS_NORMAL  not like ", value, "IS_NORMAL", 0);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalRightLike(String value) {
            addCriterion("IS_NORMAL like ", value, "IS_NORMAL", 2);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalNotRightLike(String value) {
            addCriterion("IS_NORMAL  not like ", value, "IS_NORMAL", 2);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalIn(List<String> values) {
            addCriterion("IS_NORMAL  in ", values, "IS_NORMAL");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalNotIn(List<String> values) {
            addCriterion("IS_NORMAL not in ", values, "IS_NORMAL");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalBetween(String value1, String value2) {
            addCriterion("IS_NORMAL between ", value1, value2, "IS_NORMAL");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsNormalNotBetween(String value1, String value2) {
            addCriterion("IS_NORMAL not between ", value1, value2, "IS_NORMAL");
            return (AuditUserRoleCriteria) this;
        }
        public AuditUserRoleCriteria andIsBasicIsNull() {
            addCriterion("IS_BASIC is null");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicIsNotNull() {
            addCriterion("IS_BASIC is not null");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicEqualTo(String value) {
            addCriterion("IS_BASIC =", value, "IS_BASIC");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicNotEqualTo(String value) {
            addCriterion("IS_BASIC <>", value, "IS_BASIC");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicGreaterThan(String value) {
            addCriterion("IS_BASIC >", value, "IS_BASIC");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicGreaterThanOrEqualTo(String value) {
            addCriterion("IS_BASIC >=", value, "IS_BASIC");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicLessThan(String value) {
            addCriterion("IS_BASIC <", value, "IS_BASIC");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicLessThanOrEqualTo(String value) {
            addCriterion("IS_BASIC <=", value, "IS_BASIC");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicLike(String value) {
            addCriterion("IS_BASIC like ", value, "IS_BASIC", 1);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicNotLike(String value) {
            addCriterion("IS_BASIC  not like ", value, "IS_BASIC", 1);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicLeftLike(String value) {
            addCriterion("IS_BASIC like ", value, "IS_BASIC", 0);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicNotLeftLike(String value) {
            addCriterion("IS_BASIC  not like ", value, "IS_BASIC", 0);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicRightLike(String value) {
            addCriterion("IS_BASIC like ", value, "IS_BASIC", 2);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicNotRightLike(String value) {
            addCriterion("IS_BASIC  not like ", value, "IS_BASIC", 2);
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicIn(List<String> values) {
            addCriterion("IS_BASIC  in ", values, "IS_BASIC");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicNotIn(List<String> values) {
            addCriterion("IS_BASIC not in ", values, "IS_BASIC");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicBetween(String value1, String value2) {
            addCriterion("IS_BASIC between ", value1, value2, "IS_BASIC");
            return (AuditUserRoleCriteria) this;
        }

        public AuditUserRoleCriteria andIsBasicNotBetween(String value1, String value2) {
            addCriterion("IS_BASIC not between ", value1, value2, "IS_BASIC");
            return (AuditUserRoleCriteria) this;
        }

    }

    public static class AuditUserRoleCriteria extends GeneratedCriteria {

        protected AuditUserRoleCriteria() {
            super();
        }
    }

    public static class AuditUserRoleCriterion {
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

        protected AuditUserRoleCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected AuditUserRoleCriterion(String condition, Object value, int likeType) {
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

        protected AuditUserRoleCriterion(String condition, Object value,
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

        protected AuditUserRoleCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected AuditUserRoleCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected AuditUserRoleCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}