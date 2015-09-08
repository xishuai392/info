package com.ztesoft.web.information.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class TSqrxxfjArg {
    private String pk_name = "ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<TSqrxxfjCriteria> oredCriteria;

    public TSqrxxfjArg() {
        oredCriteria = new ArrayList<TSqrxxfjCriteria>();
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

    public List<TSqrxxfjCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(TSqrxxfjCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public TSqrxxfjCriteria or() {
    	TSqrxxfjCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public TSqrxxfjCriteria createCriteria() {
    	TSqrxxfjCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected TSqrxxfjCriteria createCriteriaInternal() {
    	TSqrxxfjCriteria criteria = new TSqrxxfjCriteria();
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
        protected List<TSqrxxfjCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<TSqrxxfjCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<TSqrxxfjCriterion> getAllCriteria() {
            return criteria;
        }

        public List<TSqrxxfjCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new TSqrxxfjCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new TSqrxxfjCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new TSqrxxfjCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new TSqrxxfjCriterion(condition, value1, value2));
        }

        public TSqrxxfjCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (TSqrxxfjCriteria) this;
        }
        public TSqrxxfjCriteria andIdIsNull() {
            addCriterion("ID is null");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdLessThan(String value) {
            addCriterion("ID <", value, "ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdLike(String value) {
            addCriterion("ID like ", value, "ID", 1);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdNotLike(String value) {
            addCriterion("ID  not like ", value, "ID", 1);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdLeftLike(String value) {
            addCriterion("ID like ", value, "ID", 0);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdNotLeftLike(String value) {
            addCriterion("ID  not like ", value, "ID", 0);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdRightLike(String value) {
            addCriterion("ID like ", value, "ID", 2);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdNotRightLike(String value) {
            addCriterion("ID  not like ", value, "ID", 2);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdIn(List<String> values) {
            addCriterion("ID  in ", values, "ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdNotIn(List<String> values) {
            addCriterion("ID not in ", values, "ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdBetween(String value1, String value2) {
            addCriterion("ID between ", value1, value2, "ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between ", value1, value2, "ID");
            return (TSqrxxfjCriteria) this;
        }
        public TSqrxxfjCriteria andSqrIdIsNull() {
            addCriterion("SQR_ID is null");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdIsNotNull() {
            addCriterion("SQR_ID is not null");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdEqualTo(String value) {
            addCriterion("SQR_ID =", value, "SQR_ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdNotEqualTo(String value) {
            addCriterion("SQR_ID <>", value, "SQR_ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdGreaterThan(String value) {
            addCriterion("SQR_ID >", value, "SQR_ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdGreaterThanOrEqualTo(String value) {
            addCriterion("SQR_ID >=", value, "SQR_ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdLessThan(String value) {
            addCriterion("SQR_ID <", value, "SQR_ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdLessThanOrEqualTo(String value) {
            addCriterion("SQR_ID <=", value, "SQR_ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdLike(String value) {
            addCriterion("SQR_ID like ", value, "SQR_ID", 1);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdNotLike(String value) {
            addCriterion("SQR_ID  not like ", value, "SQR_ID", 1);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdLeftLike(String value) {
            addCriterion("SQR_ID like ", value, "SQR_ID", 0);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdNotLeftLike(String value) {
            addCriterion("SQR_ID  not like ", value, "SQR_ID", 0);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdRightLike(String value) {
            addCriterion("SQR_ID like ", value, "SQR_ID", 2);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdNotRightLike(String value) {
            addCriterion("SQR_ID  not like ", value, "SQR_ID", 2);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdIn(List<String> values) {
            addCriterion("SQR_ID  in ", values, "SQR_ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdNotIn(List<String> values) {
            addCriterion("SQR_ID not in ", values, "SQR_ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdBetween(String value1, String value2) {
            addCriterion("SQR_ID between ", value1, value2, "SQR_ID");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andSqrIdNotBetween(String value1, String value2) {
            addCriterion("SQR_ID not between ", value1, value2, "SQR_ID");
            return (TSqrxxfjCriteria) this;
        }
        public TSqrxxfjCriteria andMcIsNull() {
            addCriterion("MC is null");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcIsNotNull() {
            addCriterion("MC is not null");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcEqualTo(String value) {
            addCriterion("MC =", value, "MC");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcNotEqualTo(String value) {
            addCriterion("MC <>", value, "MC");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcGreaterThan(String value) {
            addCriterion("MC >", value, "MC");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcGreaterThanOrEqualTo(String value) {
            addCriterion("MC >=", value, "MC");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcLessThan(String value) {
            addCriterion("MC <", value, "MC");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcLessThanOrEqualTo(String value) {
            addCriterion("MC <=", value, "MC");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcLike(String value) {
            addCriterion("MC like ", value, "MC", 1);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcNotLike(String value) {
            addCriterion("MC  not like ", value, "MC", 1);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcLeftLike(String value) {
            addCriterion("MC like ", value, "MC", 0);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcNotLeftLike(String value) {
            addCriterion("MC  not like ", value, "MC", 0);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcRightLike(String value) {
            addCriterion("MC like ", value, "MC", 2);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcNotRightLike(String value) {
            addCriterion("MC  not like ", value, "MC", 2);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcIn(List<String> values) {
            addCriterion("MC  in ", values, "MC");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcNotIn(List<String> values) {
            addCriterion("MC not in ", values, "MC");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcBetween(String value1, String value2) {
            addCriterion("MC between ", value1, value2, "MC");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andMcNotBetween(String value1, String value2) {
            addCriterion("MC not between ", value1, value2, "MC");
            return (TSqrxxfjCriteria) this;
        }
        public TSqrxxfjCriteria andDzIsNull() {
            addCriterion("DZ is null");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzIsNotNull() {
            addCriterion("DZ is not null");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzEqualTo(String value) {
            addCriterion("DZ =", value, "DZ");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzNotEqualTo(String value) {
            addCriterion("DZ <>", value, "DZ");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzGreaterThan(String value) {
            addCriterion("DZ >", value, "DZ");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzGreaterThanOrEqualTo(String value) {
            addCriterion("DZ >=", value, "DZ");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzLessThan(String value) {
            addCriterion("DZ <", value, "DZ");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzLessThanOrEqualTo(String value) {
            addCriterion("DZ <=", value, "DZ");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzLike(String value) {
            addCriterion("DZ like ", value, "DZ", 1);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzNotLike(String value) {
            addCriterion("DZ  not like ", value, "DZ", 1);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzLeftLike(String value) {
            addCriterion("DZ like ", value, "DZ", 0);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzNotLeftLike(String value) {
            addCriterion("DZ  not like ", value, "DZ", 0);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzRightLike(String value) {
            addCriterion("DZ like ", value, "DZ", 2);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzNotRightLike(String value) {
            addCriterion("DZ  not like ", value, "DZ", 2);
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzIn(List<String> values) {
            addCriterion("DZ  in ", values, "DZ");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzNotIn(List<String> values) {
            addCriterion("DZ not in ", values, "DZ");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzBetween(String value1, String value2) {
            addCriterion("DZ between ", value1, value2, "DZ");
            return (TSqrxxfjCriteria) this;
        }

        public TSqrxxfjCriteria andDzNotBetween(String value1, String value2) {
            addCriterion("DZ not between ", value1, value2, "DZ");
            return (TSqrxxfjCriteria) this;
        }

    }

    public static class TSqrxxfjCriteria extends GeneratedCriteria {

        protected TSqrxxfjCriteria() {
            super();
        }
    }

    public static class TSqrxxfjCriterion {
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

        protected TSqrxxfjCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected TSqrxxfjCriterion(String condition, Object value, int likeType) {
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

        protected TSqrxxfjCriterion(String condition, Object value,
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

        protected TSqrxxfjCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected TSqrxxfjCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected TSqrxxfjCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}