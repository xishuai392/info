package com.ztesoft.web.demo.db.arg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

public class AmUserRoleArg {
    private String pk_name = "USER_ROLE_ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<AmUserRoleCriteria> oredCriteria;

    public AmUserRoleArg() {
        oredCriteria = new ArrayList<AmUserRoleCriteria>();
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

    public List<AmUserRoleCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(AmUserRoleCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public AmUserRoleCriteria or() {
        AmUserRoleCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AmUserRoleCriteria createCriteria() {
        AmUserRoleCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AmUserRoleCriteria createCriteriaInternal() {
        AmUserRoleCriteria criteria = new AmUserRoleCriteria();
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
        protected List<AmUserRoleCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<AmUserRoleCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<AmUserRoleCriterion> getAllCriteria() {
            return criteria;
        }

        public List<AmUserRoleCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new AmUserRoleCriterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new AmUserRoleCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value, String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new AmUserRoleCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new AmUserRoleCriterion(condition, value1, value2));
        }

        public AmUserRoleCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdIsNull() {
            addCriterion("USER_ROLE_ID is null");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdIsNotNull() {
            addCriterion("USER_ROLE_ID is not null");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdEqualTo(Integer value) {
            addCriterion("USER_ROLE_ID =", value, "USER_ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdNotEqualTo(Integer value) {
            addCriterion("USER_ROLE_ID <>", value, "USER_ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdGreaterThan(Integer value) {
            addCriterion("USER_ROLE_ID >", value, "USER_ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ROLE_ID >=", value, "USER_ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdLessThan(Integer value) {
            addCriterion("USER_ROLE_ID <", value, "USER_ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ROLE_ID <=", value, "USER_ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdLike(Integer value) {
            addCriterion("USER_ROLE_ID like ", value, "USER_ROLE_ID", 1);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdNotLike(Integer value) {
            addCriterion("USER_ROLE_ID  not like ", value, "USER_ROLE_ID", 1);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdLeftLike(Integer value) {
            addCriterion("USER_ROLE_ID like ", value, "USER_ROLE_ID", 0);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdNotLeftLike(Integer value) {
            addCriterion("USER_ROLE_ID  not like ", value, "USER_ROLE_ID", 0);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdRightLike(Integer value) {
            addCriterion("USER_ROLE_ID like ", value, "USER_ROLE_ID", 2);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdNotRightLike(Integer value) {
            addCriterion("USER_ROLE_ID  not like ", value, "USER_ROLE_ID", 2);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdIn(List<Integer> values) {
            addCriterion("USER_ROLE_ID  in ", values, "USER_ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdNotIn(List<Integer> values) {
            addCriterion("USER_ROLE_ID not in ", values, "USER_ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ROLE_ID between ", value1, value2, "USER_ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ROLE_ID not between ", value1, value2, "USER_ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdEqualTo(Integer value) {
            addCriterion("ROLE_ID =", value, "ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("ROLE_ID <>", value, "ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdGreaterThan(Integer value) {
            addCriterion("ROLE_ID >", value, "ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID >=", value, "ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdLessThan(Integer value) {
            addCriterion("ROLE_ID <", value, "ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID <=", value, "ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdLike(Integer value) {
            addCriterion("ROLE_ID like ", value, "ROLE_ID", 1);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdNotLike(Integer value) {
            addCriterion("ROLE_ID  not like ", value, "ROLE_ID", 1);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdLeftLike(Integer value) {
            addCriterion("ROLE_ID like ", value, "ROLE_ID", 0);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdNotLeftLike(Integer value) {
            addCriterion("ROLE_ID  not like ", value, "ROLE_ID", 0);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdRightLike(Integer value) {
            addCriterion("ROLE_ID like ", value, "ROLE_ID", 2);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdNotRightLike(Integer value) {
            addCriterion("ROLE_ID  not like ", value, "ROLE_ID", 2);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdIn(List<Integer> values) {
            addCriterion("ROLE_ID  in ", values, "ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("ROLE_ID not in ", values, "ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID between ", value1, value2, "ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID not between ", value1, value2, "ROLE_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "USER_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "USER_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "USER_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "USER_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "USER_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "USER_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 1);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdNotLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 1);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdLeftLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 0);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdNotLeftLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 0);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdRightLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 2);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdNotRightLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 2);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID  in ", values, "USER_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in ", values, "USER_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between ", value1, value2, "USER_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between ", value1, value2, "USER_ID");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateIsNull() {
            addCriterion("CREATED_DATE is null");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateIsNotNull() {
            addCriterion("CREATED_DATE is not null");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateEqualTo(Date value) {
            addCriterion("CREATED_DATE =", value, "CREATED_DATE");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("CREATED_DATE <>", value, "CREATED_DATE");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateGreaterThan(Date value) {
            addCriterion("CREATED_DATE >", value, "CREATED_DATE");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE >=", value, "CREATED_DATE");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateLessThan(Date value) {
            addCriterion("CREATED_DATE <", value, "CREATED_DATE");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE <=", value, "CREATED_DATE");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 1);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateNotLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 1);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateLeftLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 0);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateNotLeftLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 0);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateRightLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 2);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateNotRightLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 2);
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateIn(List<Date> values) {
            addCriterion("CREATED_DATE  in ", values, "CREATED_DATE");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("CREATED_DATE not in ", values, "CREATED_DATE");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE between ", value1, value2, "CREATED_DATE");
            return (AmUserRoleCriteria) this;
        }

        public AmUserRoleCriteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE not between ", value1, value2, "CREATED_DATE");
            return (AmUserRoleCriteria) this;
        }

    }

    public static class AmUserRoleCriteria extends GeneratedCriteria {

        protected AmUserRoleCriteria() {
            super();
        }
    }

    public static class AmUserRoleCriterion {
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

        protected AmUserRoleCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected AmUserRoleCriterion(String condition, Object value, int likeType) {
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

        protected AmUserRoleCriterion(String condition, Object value, String typeHandler) {
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

        protected AmUserRoleCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected AmUserRoleCriterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected AmUserRoleCriterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}