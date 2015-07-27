package com.ztesoft.web.common.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class DbTableArg {
    private String pk_name = "id";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<DbTableCriteria> oredCriteria;

    public DbTableArg() {
        oredCriteria = new ArrayList<DbTableCriteria>();
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

    public List<DbTableCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(DbTableCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public DbTableCriteria or() {
    	DbTableCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public DbTableCriteria createCriteria() {
    	DbTableCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected DbTableCriteria createCriteriaInternal() {
    	DbTableCriteria criteria = new DbTableCriteria();
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
        protected List<DbTableCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<DbTableCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<DbTableCriterion> getAllCriteria() {
            return criteria;
        }

        public List<DbTableCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new DbTableCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new DbTableCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new DbTableCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new DbTableCriterion(condition, value1, value2));
        }

        public DbTableCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (DbTableCriteria) this;
        }
        public DbTableCriteria andIdIsNull() {
            addCriterion("id is null");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdLike(Integer value) {
            addCriterion("id like ", value, "id", 1);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdNotLike(Integer value) {
            addCriterion("id  not like ", value, "id", 1);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdLeftLike(Integer value) {
            addCriterion("id like ", value, "id", 0);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdNotLeftLike(Integer value) {
            addCriterion("id  not like ", value, "id", 0);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdRightLike(Integer value) {
            addCriterion("id like ", value, "id", 2);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdNotRightLike(Integer value) {
            addCriterion("id  not like ", value, "id", 2);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdIn(List<Integer> values) {
            addCriterion("id  in ", values, "id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in ", values, "id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between ", value1, value2, "id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between ", value1, value2, "id");
            return (DbTableCriteria) this;
        }
        public DbTableCriteria andTableNameIsNull() {
            addCriterion("table_name is null");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameIsNotNull() {
            addCriterion("table_name is not null");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameEqualTo(String value) {
            addCriterion("table_name =", value, "table_name");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameNotEqualTo(String value) {
            addCriterion("table_name <>", value, "table_name");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameGreaterThan(String value) {
            addCriterion("table_name >", value, "table_name");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_name >=", value, "table_name");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameLessThan(String value) {
            addCriterion("table_name <", value, "table_name");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("table_name <=", value, "table_name");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameLike(String value) {
            addCriterion("table_name like ", value, "table_name", 1);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameNotLike(String value) {
            addCriterion("table_name  not like ", value, "table_name", 1);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameLeftLike(String value) {
            addCriterion("table_name like ", value, "table_name", 0);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameNotLeftLike(String value) {
            addCriterion("table_name  not like ", value, "table_name", 0);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameRightLike(String value) {
            addCriterion("table_name like ", value, "table_name", 2);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameNotRightLike(String value) {
            addCriterion("table_name  not like ", value, "table_name", 2);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameIn(List<String> values) {
            addCriterion("table_name  in ", values, "table_name");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameNotIn(List<String> values) {
            addCriterion("table_name not in ", values, "table_name");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameBetween(String value1, String value2) {
            addCriterion("table_name between ", value1, value2, "table_name");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("table_name not between ", value1, value2, "table_name");
            return (DbTableCriteria) this;
        }
        public DbTableCriteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksLike(String value) {
            addCriterion("remarks like ", value, "remarks", 1);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksNotLike(String value) {
            addCriterion("remarks  not like ", value, "remarks", 1);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksLeftLike(String value) {
            addCriterion("remarks like ", value, "remarks", 0);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksNotLeftLike(String value) {
            addCriterion("remarks  not like ", value, "remarks", 0);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksRightLike(String value) {
            addCriterion("remarks like ", value, "remarks", 2);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksNotRightLike(String value) {
            addCriterion("remarks  not like ", value, "remarks", 2);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksIn(List<String> values) {
            addCriterion("remarks  in ", values, "remarks");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in ", values, "remarks");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between ", value1, value2, "remarks");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between ", value1, value2, "remarks");
            return (DbTableCriteria) this;
        }
        public DbTableCriteria andDbIdIsNull() {
            addCriterion("db_id is null");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdIsNotNull() {
            addCriterion("db_id is not null");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdEqualTo(Integer value) {
            addCriterion("db_id =", value, "db_id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdNotEqualTo(Integer value) {
            addCriterion("db_id <>", value, "db_id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdGreaterThan(Integer value) {
            addCriterion("db_id >", value, "db_id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("db_id >=", value, "db_id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdLessThan(Integer value) {
            addCriterion("db_id <", value, "db_id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdLessThanOrEqualTo(Integer value) {
            addCriterion("db_id <=", value, "db_id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdLike(Integer value) {
            addCriterion("db_id like ", value, "db_id", 1);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdNotLike(Integer value) {
            addCriterion("db_id  not like ", value, "db_id", 1);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdLeftLike(Integer value) {
            addCriterion("db_id like ", value, "db_id", 0);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdNotLeftLike(Integer value) {
            addCriterion("db_id  not like ", value, "db_id", 0);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdRightLike(Integer value) {
            addCriterion("db_id like ", value, "db_id", 2);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdNotRightLike(Integer value) {
            addCriterion("db_id  not like ", value, "db_id", 2);
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdIn(List<Integer> values) {
            addCriterion("db_id  in ", values, "db_id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdNotIn(List<Integer> values) {
            addCriterion("db_id not in ", values, "db_id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdBetween(Integer value1, Integer value2) {
            addCriterion("db_id between ", value1, value2, "db_id");
            return (DbTableCriteria) this;
        }

        public DbTableCriteria andDbIdNotBetween(Integer value1, Integer value2) {
            addCriterion("db_id not between ", value1, value2, "db_id");
            return (DbTableCriteria) this;
        }

    }

    public static class DbTableCriteria extends GeneratedCriteria {

        protected DbTableCriteria() {
            super();
        }
    }

    public static class DbTableCriterion {
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

        protected DbTableCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected DbTableCriterion(String condition, Object value, int likeType) {
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

        protected DbTableCriterion(String condition, Object value,
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

        protected DbTableCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected DbTableCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected DbTableCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}