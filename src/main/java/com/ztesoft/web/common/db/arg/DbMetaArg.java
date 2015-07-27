package com.ztesoft.web.common.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class DbMetaArg {
    private String pk_name = "id";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<DbMetaCriteria> oredCriteria;

    public DbMetaArg() {
        oredCriteria = new ArrayList<DbMetaCriteria>();
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

    public List<DbMetaCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(DbMetaCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public DbMetaCriteria or() {
    	DbMetaCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public DbMetaCriteria createCriteria() {
    	DbMetaCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected DbMetaCriteria createCriteriaInternal() {
    	DbMetaCriteria criteria = new DbMetaCriteria();
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
        protected List<DbMetaCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<DbMetaCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<DbMetaCriterion> getAllCriteria() {
            return criteria;
        }

        public List<DbMetaCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new DbMetaCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new DbMetaCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new DbMetaCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new DbMetaCriterion(condition, value1, value2));
        }

        public DbMetaCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (DbMetaCriteria) this;
        }
        public DbMetaCriteria andIdIsNull() {
            addCriterion("id is null");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdLike(Integer value) {
            addCriterion("id like ", value, "id", 1);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdNotLike(Integer value) {
            addCriterion("id  not like ", value, "id", 1);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdLeftLike(Integer value) {
            addCriterion("id like ", value, "id", 0);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdNotLeftLike(Integer value) {
            addCriterion("id  not like ", value, "id", 0);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdRightLike(Integer value) {
            addCriterion("id like ", value, "id", 2);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdNotRightLike(Integer value) {
            addCriterion("id  not like ", value, "id", 2);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdIn(List<Integer> values) {
            addCriterion("id  in ", values, "id");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in ", values, "id");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between ", value1, value2, "id");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between ", value1, value2, "id");
            return (DbMetaCriteria) this;
        }
        public DbMetaCriteria andDbNameIsNull() {
            addCriterion("db_name is null");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameIsNotNull() {
            addCriterion("db_name is not null");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameEqualTo(String value) {
            addCriterion("db_name =", value, "db_name");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameNotEqualTo(String value) {
            addCriterion("db_name <>", value, "db_name");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameGreaterThan(String value) {
            addCriterion("db_name >", value, "db_name");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameGreaterThanOrEqualTo(String value) {
            addCriterion("db_name >=", value, "db_name");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameLessThan(String value) {
            addCriterion("db_name <", value, "db_name");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameLessThanOrEqualTo(String value) {
            addCriterion("db_name <=", value, "db_name");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameLike(String value) {
            addCriterion("db_name like ", value, "db_name", 1);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameNotLike(String value) {
            addCriterion("db_name  not like ", value, "db_name", 1);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameLeftLike(String value) {
            addCriterion("db_name like ", value, "db_name", 0);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameNotLeftLike(String value) {
            addCriterion("db_name  not like ", value, "db_name", 0);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameRightLike(String value) {
            addCriterion("db_name like ", value, "db_name", 2);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameNotRightLike(String value) {
            addCriterion("db_name  not like ", value, "db_name", 2);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameIn(List<String> values) {
            addCriterion("db_name  in ", values, "db_name");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameNotIn(List<String> values) {
            addCriterion("db_name not in ", values, "db_name");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameBetween(String value1, String value2) {
            addCriterion("db_name between ", value1, value2, "db_name");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andDbNameNotBetween(String value1, String value2) {
            addCriterion("db_name not between ", value1, value2, "db_name");
            return (DbMetaCriteria) this;
        }
        public DbMetaCriteria andTypeIsNull() {
            addCriterion("type is null");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeLike(String value) {
            addCriterion("type like ", value, "type", 1);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeNotLike(String value) {
            addCriterion("type  not like ", value, "type", 1);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeLeftLike(String value) {
            addCriterion("type like ", value, "type", 0);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeNotLeftLike(String value) {
            addCriterion("type  not like ", value, "type", 0);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeRightLike(String value) {
            addCriterion("type like ", value, "type", 2);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeNotRightLike(String value) {
            addCriterion("type  not like ", value, "type", 2);
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeIn(List<String> values) {
            addCriterion("type  in ", values, "type");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeNotIn(List<String> values) {
            addCriterion("type not in ", values, "type");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeBetween(String value1, String value2) {
            addCriterion("type between ", value1, value2, "type");
            return (DbMetaCriteria) this;
        }

        public DbMetaCriteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between ", value1, value2, "type");
            return (DbMetaCriteria) this;
        }

    }

    public static class DbMetaCriteria extends GeneratedCriteria {

        protected DbMetaCriteria() {
            super();
        }
    }

    public static class DbMetaCriterion {
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

        protected DbMetaCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected DbMetaCriterion(String condition, Object value, int likeType) {
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

        protected DbMetaCriterion(String condition, Object value,
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

        protected DbMetaCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected DbMetaCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected DbMetaCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}