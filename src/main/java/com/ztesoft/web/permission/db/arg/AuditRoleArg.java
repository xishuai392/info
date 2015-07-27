package com.ztesoft.web.permission.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class AuditRoleArg {
    private String pk_name = "ROLE_ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<AuditRoleCriteria> oredCriteria;

    public AuditRoleArg() {
        oredCriteria = new ArrayList<AuditRoleCriteria>();
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

    public List<AuditRoleCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(AuditRoleCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public AuditRoleCriteria or() {
    	AuditRoleCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AuditRoleCriteria createCriteria() {
    	AuditRoleCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AuditRoleCriteria createCriteriaInternal() {
    	AuditRoleCriteria criteria = new AuditRoleCriteria();
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
        protected List<AuditRoleCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<AuditRoleCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<AuditRoleCriterion> getAllCriteria() {
            return criteria;
        }

        public List<AuditRoleCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new AuditRoleCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditRoleCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditRoleCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditRoleCriterion(condition, value1, value2));
        }

        public AuditRoleCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (AuditRoleCriteria) this;
        }
        public AuditRoleCriteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdEqualTo(Integer value) {
            addCriterion("ROLE_ID =", value, "ROLE_ID");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("ROLE_ID <>", value, "ROLE_ID");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdGreaterThan(Integer value) {
            addCriterion("ROLE_ID >", value, "ROLE_ID");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID >=", value, "ROLE_ID");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdLessThan(Integer value) {
            addCriterion("ROLE_ID <", value, "ROLE_ID");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID <=", value, "ROLE_ID");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdLike(Integer value) {
            addCriterion("ROLE_ID like ", value, "ROLE_ID", 1);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdNotLike(Integer value) {
            addCriterion("ROLE_ID  not like ", value, "ROLE_ID", 1);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdLeftLike(Integer value) {
            addCriterion("ROLE_ID like ", value, "ROLE_ID", 0);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdNotLeftLike(Integer value) {
            addCriterion("ROLE_ID  not like ", value, "ROLE_ID", 0);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdRightLike(Integer value) {
            addCriterion("ROLE_ID like ", value, "ROLE_ID", 2);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdNotRightLike(Integer value) {
            addCriterion("ROLE_ID  not like ", value, "ROLE_ID", 2);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdIn(List<Integer> values) {
            addCriterion("ROLE_ID  in ", values, "ROLE_ID");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("ROLE_ID not in ", values, "ROLE_ID");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID between ", value1, value2, "ROLE_ID");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID not between ", value1, value2, "ROLE_ID");
            return (AuditRoleCriteria) this;
        }
        public AuditRoleCriteria andRoleNameIsNull() {
            addCriterion("ROLE_NAME is null");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameIsNotNull() {
            addCriterion("ROLE_NAME is not null");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameEqualTo(String value) {
            addCriterion("ROLE_NAME =", value, "ROLE_NAME");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameNotEqualTo(String value) {
            addCriterion("ROLE_NAME <>", value, "ROLE_NAME");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameGreaterThan(String value) {
            addCriterion("ROLE_NAME >", value, "ROLE_NAME");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_NAME >=", value, "ROLE_NAME");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameLessThan(String value) {
            addCriterion("ROLE_NAME <", value, "ROLE_NAME");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("ROLE_NAME <=", value, "ROLE_NAME");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameLike(String value) {
            addCriterion("ROLE_NAME like ", value, "ROLE_NAME", 1);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameNotLike(String value) {
            addCriterion("ROLE_NAME  not like ", value, "ROLE_NAME", 1);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameLeftLike(String value) {
            addCriterion("ROLE_NAME like ", value, "ROLE_NAME", 0);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameNotLeftLike(String value) {
            addCriterion("ROLE_NAME  not like ", value, "ROLE_NAME", 0);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameRightLike(String value) {
            addCriterion("ROLE_NAME like ", value, "ROLE_NAME", 2);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameNotRightLike(String value) {
            addCriterion("ROLE_NAME  not like ", value, "ROLE_NAME", 2);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameIn(List<String> values) {
            addCriterion("ROLE_NAME  in ", values, "ROLE_NAME");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameNotIn(List<String> values) {
            addCriterion("ROLE_NAME not in ", values, "ROLE_NAME");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameBetween(String value1, String value2) {
            addCriterion("ROLE_NAME between ", value1, value2, "ROLE_NAME");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("ROLE_NAME not between ", value1, value2, "ROLE_NAME");
            return (AuditRoleCriteria) this;
        }
        public AuditRoleCriteria andCommentsIsNull() {
            addCriterion("COMMENTS is null");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsIsNotNull() {
            addCriterion("COMMENTS is not null");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsEqualTo(String value) {
            addCriterion("COMMENTS =", value, "COMMENTS");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsNotEqualTo(String value) {
            addCriterion("COMMENTS <>", value, "COMMENTS");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsGreaterThan(String value) {
            addCriterion("COMMENTS >", value, "COMMENTS");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENTS >=", value, "COMMENTS");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsLessThan(String value) {
            addCriterion("COMMENTS <", value, "COMMENTS");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("COMMENTS <=", value, "COMMENTS");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsLike(String value) {
            addCriterion("COMMENTS like ", value, "COMMENTS", 1);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsNotLike(String value) {
            addCriterion("COMMENTS  not like ", value, "COMMENTS", 1);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsLeftLike(String value) {
            addCriterion("COMMENTS like ", value, "COMMENTS", 0);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsNotLeftLike(String value) {
            addCriterion("COMMENTS  not like ", value, "COMMENTS", 0);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsRightLike(String value) {
            addCriterion("COMMENTS like ", value, "COMMENTS", 2);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsNotRightLike(String value) {
            addCriterion("COMMENTS  not like ", value, "COMMENTS", 2);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsIn(List<String> values) {
            addCriterion("COMMENTS  in ", values, "COMMENTS");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsNotIn(List<String> values) {
            addCriterion("COMMENTS not in ", values, "COMMENTS");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsBetween(String value1, String value2) {
            addCriterion("COMMENTS between ", value1, value2, "COMMENTS");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("COMMENTS not between ", value1, value2, "COMMENTS");
            return (AuditRoleCriteria) this;
        }
        public AuditRoleCriteria andStateDateIsNull() {
            addCriterion("STATE_DATE is null");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateIsNotNull() {
            addCriterion("STATE_DATE is not null");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateEqualTo(Date value) {
            addCriterion("STATE_DATE =", value, "STATE_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateNotEqualTo(Date value) {
            addCriterion("STATE_DATE <>", value, "STATE_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateGreaterThan(Date value) {
            addCriterion("STATE_DATE >", value, "STATE_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("STATE_DATE >=", value, "STATE_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateLessThan(Date value) {
            addCriterion("STATE_DATE <", value, "STATE_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateLessThanOrEqualTo(Date value) {
            addCriterion("STATE_DATE <=", value, "STATE_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateLike(Date value) {
            addCriterion("STATE_DATE like ", value, "STATE_DATE", 1);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateNotLike(Date value) {
            addCriterion("STATE_DATE  not like ", value, "STATE_DATE", 1);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateLeftLike(Date value) {
            addCriterion("STATE_DATE like ", value, "STATE_DATE", 0);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateNotLeftLike(Date value) {
            addCriterion("STATE_DATE  not like ", value, "STATE_DATE", 0);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateRightLike(Date value) {
            addCriterion("STATE_DATE like ", value, "STATE_DATE", 2);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateNotRightLike(Date value) {
            addCriterion("STATE_DATE  not like ", value, "STATE_DATE", 2);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateIn(List<Date> values) {
            addCriterion("STATE_DATE  in ", values, "STATE_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateNotIn(List<Date> values) {
            addCriterion("STATE_DATE not in ", values, "STATE_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateBetween(Date value1, Date value2) {
            addCriterion("STATE_DATE between ", value1, value2, "STATE_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateDateNotBetween(Date value1, Date value2) {
            addCriterion("STATE_DATE not between ", value1, value2, "STATE_DATE");
            return (AuditRoleCriteria) this;
        }
        public AuditRoleCriteria andStateIsNull() {
            addCriterion("STATE is null");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "STATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "STATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "STATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "STATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "STATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "STATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateLike(String value) {
            addCriterion("STATE like ", value, "STATE", 1);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateNotLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 1);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateLeftLike(String value) {
            addCriterion("STATE like ", value, "STATE", 0);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateNotLeftLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 0);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateRightLike(String value) {
            addCriterion("STATE like ", value, "STATE", 2);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateNotRightLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 2);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateIn(List<String> values) {
            addCriterion("STATE  in ", values, "STATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in ", values, "STATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between ", value1, value2, "STATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between ", value1, value2, "STATE");
            return (AuditRoleCriteria) this;
        }
        public AuditRoleCriteria andCreatedDateIsNull() {
            addCriterion("CREATED_DATE is null");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateIsNotNull() {
            addCriterion("CREATED_DATE is not null");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateEqualTo(Date value) {
            addCriterion("CREATED_DATE =", value, "CREATED_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("CREATED_DATE <>", value, "CREATED_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateGreaterThan(Date value) {
            addCriterion("CREATED_DATE >", value, "CREATED_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE >=", value, "CREATED_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateLessThan(Date value) {
            addCriterion("CREATED_DATE <", value, "CREATED_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE <=", value, "CREATED_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 1);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateNotLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 1);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateLeftLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 0);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateNotLeftLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 0);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateRightLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 2);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateNotRightLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 2);
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateIn(List<Date> values) {
            addCriterion("CREATED_DATE  in ", values, "CREATED_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("CREATED_DATE not in ", values, "CREATED_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE between ", value1, value2, "CREATED_DATE");
            return (AuditRoleCriteria) this;
        }

        public AuditRoleCriteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE not between ", value1, value2, "CREATED_DATE");
            return (AuditRoleCriteria) this;
        }

    }

    public static class AuditRoleCriteria extends GeneratedCriteria {

        protected AuditRoleCriteria() {
            super();
        }
    }

    public static class AuditRoleCriterion {
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

        protected AuditRoleCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected AuditRoleCriterion(String condition, Object value, int likeType) {
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

        protected AuditRoleCriterion(String condition, Object value,
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

        protected AuditRoleCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected AuditRoleCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected AuditRoleCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}