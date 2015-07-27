package com.ztesoft.web.permission.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class AuditMenuRoleArg {
    private String pk_name = "MENU_ROLE_ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<AuditMenuRoleCriteria> oredCriteria;

    public AuditMenuRoleArg() {
        oredCriteria = new ArrayList<AuditMenuRoleCriteria>();
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

    public List<AuditMenuRoleCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(AuditMenuRoleCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public AuditMenuRoleCriteria or() {
    	AuditMenuRoleCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AuditMenuRoleCriteria createCriteria() {
    	AuditMenuRoleCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AuditMenuRoleCriteria createCriteriaInternal() {
    	AuditMenuRoleCriteria criteria = new AuditMenuRoleCriteria();
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
        protected List<AuditMenuRoleCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<AuditMenuRoleCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<AuditMenuRoleCriterion> getAllCriteria() {
            return criteria;
        }

        public List<AuditMenuRoleCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new AuditMenuRoleCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditMenuRoleCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditMenuRoleCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditMenuRoleCriterion(condition, value1, value2));
        }

        public AuditMenuRoleCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (AuditMenuRoleCriteria) this;
        }
        public AuditMenuRoleCriteria andMenuRoleIdIsNull() {
            addCriterion("MENU_ROLE_ID is null");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdIsNotNull() {
            addCriterion("MENU_ROLE_ID is not null");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdEqualTo(Integer value) {
            addCriterion("MENU_ROLE_ID =", value, "MENU_ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdNotEqualTo(Integer value) {
            addCriterion("MENU_ROLE_ID <>", value, "MENU_ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdGreaterThan(Integer value) {
            addCriterion("MENU_ROLE_ID >", value, "MENU_ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MENU_ROLE_ID >=", value, "MENU_ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdLessThan(Integer value) {
            addCriterion("MENU_ROLE_ID <", value, "MENU_ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("MENU_ROLE_ID <=", value, "MENU_ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdLike(Integer value) {
            addCriterion("MENU_ROLE_ID like ", value, "MENU_ROLE_ID", 1);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdNotLike(Integer value) {
            addCriterion("MENU_ROLE_ID  not like ", value, "MENU_ROLE_ID", 1);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdLeftLike(Integer value) {
            addCriterion("MENU_ROLE_ID like ", value, "MENU_ROLE_ID", 0);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdNotLeftLike(Integer value) {
            addCriterion("MENU_ROLE_ID  not like ", value, "MENU_ROLE_ID", 0);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdRightLike(Integer value) {
            addCriterion("MENU_ROLE_ID like ", value, "MENU_ROLE_ID", 2);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdNotRightLike(Integer value) {
            addCriterion("MENU_ROLE_ID  not like ", value, "MENU_ROLE_ID", 2);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdIn(List<Integer> values) {
            addCriterion("MENU_ROLE_ID  in ", values, "MENU_ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdNotIn(List<Integer> values) {
            addCriterion("MENU_ROLE_ID not in ", values, "MENU_ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("MENU_ROLE_ID between ", value1, value2, "MENU_ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MENU_ROLE_ID not between ", value1, value2, "MENU_ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }
        public AuditMenuRoleCriteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdEqualTo(Integer value) {
            addCriterion("ROLE_ID =", value, "ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("ROLE_ID <>", value, "ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdGreaterThan(Integer value) {
            addCriterion("ROLE_ID >", value, "ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID >=", value, "ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdLessThan(Integer value) {
            addCriterion("ROLE_ID <", value, "ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID <=", value, "ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdLike(Integer value) {
            addCriterion("ROLE_ID like ", value, "ROLE_ID", 1);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdNotLike(Integer value) {
            addCriterion("ROLE_ID  not like ", value, "ROLE_ID", 1);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdLeftLike(Integer value) {
            addCriterion("ROLE_ID like ", value, "ROLE_ID", 0);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdNotLeftLike(Integer value) {
            addCriterion("ROLE_ID  not like ", value, "ROLE_ID", 0);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdRightLike(Integer value) {
            addCriterion("ROLE_ID like ", value, "ROLE_ID", 2);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdNotRightLike(Integer value) {
            addCriterion("ROLE_ID  not like ", value, "ROLE_ID", 2);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdIn(List<Integer> values) {
            addCriterion("ROLE_ID  in ", values, "ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("ROLE_ID not in ", values, "ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID between ", value1, value2, "ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID not between ", value1, value2, "ROLE_ID");
            return (AuditMenuRoleCriteria) this;
        }
        public AuditMenuRoleCriteria andMenuIdIsNull() {
            addCriterion("MENU_ID is null");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdIsNotNull() {
            addCriterion("MENU_ID is not null");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdEqualTo(Integer value) {
            addCriterion("MENU_ID =", value, "MENU_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("MENU_ID <>", value, "MENU_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdGreaterThan(Integer value) {
            addCriterion("MENU_ID >", value, "MENU_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MENU_ID >=", value, "MENU_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdLessThan(Integer value) {
            addCriterion("MENU_ID <", value, "MENU_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("MENU_ID <=", value, "MENU_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdLike(Integer value) {
            addCriterion("MENU_ID like ", value, "MENU_ID", 1);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdNotLike(Integer value) {
            addCriterion("MENU_ID  not like ", value, "MENU_ID", 1);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdLeftLike(Integer value) {
            addCriterion("MENU_ID like ", value, "MENU_ID", 0);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdNotLeftLike(Integer value) {
            addCriterion("MENU_ID  not like ", value, "MENU_ID", 0);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdRightLike(Integer value) {
            addCriterion("MENU_ID like ", value, "MENU_ID", 2);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdNotRightLike(Integer value) {
            addCriterion("MENU_ID  not like ", value, "MENU_ID", 2);
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdIn(List<Integer> values) {
            addCriterion("MENU_ID  in ", values, "MENU_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("MENU_ID not in ", values, "MENU_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("MENU_ID between ", value1, value2, "MENU_ID");
            return (AuditMenuRoleCriteria) this;
        }

        public AuditMenuRoleCriteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MENU_ID not between ", value1, value2, "MENU_ID");
            return (AuditMenuRoleCriteria) this;
        }

    }

    public static class AuditMenuRoleCriteria extends GeneratedCriteria {

        protected AuditMenuRoleCriteria() {
            super();
        }
    }

    public static class AuditMenuRoleCriterion {
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

        protected AuditMenuRoleCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected AuditMenuRoleCriterion(String condition, Object value, int likeType) {
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

        protected AuditMenuRoleCriterion(String condition, Object value,
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

        protected AuditMenuRoleCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected AuditMenuRoleCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected AuditMenuRoleCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}