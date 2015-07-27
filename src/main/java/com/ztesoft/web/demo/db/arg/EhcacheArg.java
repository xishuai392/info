package com.ztesoft.web.demo.db.arg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import com.ztesoft.framework.dto.AbstractDto;

public class EhcacheArg {
    private String pk_name = "emp_id";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<EhcacheCriteria> oredCriteria;

    public EhcacheArg() {
        oredCriteria = new ArrayList<EhcacheCriteria>();
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

    public List<EhcacheCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(EhcacheCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public EhcacheCriteria or() {
    	EhcacheCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public EhcacheCriteria createCriteria() {
    	EhcacheCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected EhcacheCriteria createCriteriaInternal() {
    	EhcacheCriteria criteria = new EhcacheCriteria();
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
        protected List<EhcacheCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<EhcacheCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<EhcacheCriterion> getAllCriteria() {
            return criteria;
        }

        public List<EhcacheCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new EhcacheCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new EhcacheCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new EhcacheCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new EhcacheCriterion(condition, value1, value2));
        }

        public EhcacheCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (EhcacheCriteria) this;
        }
        public EhcacheCriteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdEqualTo(Integer value) {
            addCriterion("emp_id =", value, "emp_id");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdNotEqualTo(Integer value) {
            addCriterion("emp_id <>", value, "emp_id");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdGreaterThan(Integer value) {
            addCriterion("emp_id >", value, "emp_id");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_id >=", value, "emp_id");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdLessThan(Integer value) {
            addCriterion("emp_id <", value, "emp_id");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("emp_id <=", value, "emp_id");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdLike(Integer value) {
            addCriterion("emp_id like ", value, "emp_id", 1);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdNotLike(Integer value) {
            addCriterion("emp_id  not like ", value, "emp_id", 1);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdLeftLike(Integer value) {
            addCriterion("emp_id like ", value, "emp_id", 0);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdNotLeftLike(Integer value) {
            addCriterion("emp_id  not like ", value, "emp_id", 0);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdRightLike(Integer value) {
            addCriterion("emp_id like ", value, "emp_id", 2);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdNotRightLike(Integer value) {
            addCriterion("emp_id  not like ", value, "emp_id", 2);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdIn(List<Integer> values) {
            addCriterion("emp_id  in ", values, "emp_id");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdNotIn(List<Integer> values) {
            addCriterion("emp_id not in ", values, "emp_id");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("emp_id between ", value1, value2, "emp_id");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_id not between ", value1, value2, "emp_id");
            return (EhcacheCriteria) this;
        }
        public EhcacheCriteria andEmpNameIsNull() {
            addCriterion("emp_name is null");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameIsNotNull() {
            addCriterion("emp_name is not null");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameEqualTo(String value) {
            addCriterion("emp_name =", value, "emp_name");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameNotEqualTo(String value) {
            addCriterion("emp_name <>", value, "emp_name");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameGreaterThan(String value) {
            addCriterion("emp_name >", value, "emp_name");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("emp_name >=", value, "emp_name");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameLessThan(String value) {
            addCriterion("emp_name <", value, "emp_name");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameLessThanOrEqualTo(String value) {
            addCriterion("emp_name <=", value, "emp_name");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameLike(String value) {
            addCriterion("emp_name like ", value, "emp_name", 1);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameNotLike(String value) {
            addCriterion("emp_name  not like ", value, "emp_name", 1);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameLeftLike(String value) {
            addCriterion("emp_name like ", value, "emp_name", 0);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameNotLeftLike(String value) {
            addCriterion("emp_name  not like ", value, "emp_name", 0);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameRightLike(String value) {
            addCriterion("emp_name like ", value, "emp_name", 2);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameNotRightLike(String value) {
            addCriterion("emp_name  not like ", value, "emp_name", 2);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameIn(List<String> values) {
            addCriterion("emp_name  in ", values, "emp_name");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameNotIn(List<String> values) {
            addCriterion("emp_name not in ", values, "emp_name");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameBetween(String value1, String value2) {
            addCriterion("emp_name between ", value1, value2, "emp_name");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpNameNotBetween(String value1, String value2) {
            addCriterion("emp_name not between ", value1, value2, "emp_name");
            return (EhcacheCriteria) this;
        }
        public EhcacheCriteria andEmpAgeIsNull() {
            addCriterion("emp_age is null");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeIsNotNull() {
            addCriterion("emp_age is not null");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeEqualTo(Integer value) {
            addCriterion("emp_age =", value, "emp_age");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeNotEqualTo(Integer value) {
            addCriterion("emp_age <>", value, "emp_age");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeGreaterThan(Integer value) {
            addCriterion("emp_age >", value, "emp_age");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_age >=", value, "emp_age");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeLessThan(Integer value) {
            addCriterion("emp_age <", value, "emp_age");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeLessThanOrEqualTo(Integer value) {
            addCriterion("emp_age <=", value, "emp_age");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeLike(Integer value) {
            addCriterion("emp_age like ", value, "emp_age", 1);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeNotLike(Integer value) {
            addCriterion("emp_age  not like ", value, "emp_age", 1);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeLeftLike(Integer value) {
            addCriterion("emp_age like ", value, "emp_age", 0);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeNotLeftLike(Integer value) {
            addCriterion("emp_age  not like ", value, "emp_age", 0);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeRightLike(Integer value) {
            addCriterion("emp_age like ", value, "emp_age", 2);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeNotRightLike(Integer value) {
            addCriterion("emp_age  not like ", value, "emp_age", 2);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeIn(List<Integer> values) {
            addCriterion("emp_age  in ", values, "emp_age");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeNotIn(List<Integer> values) {
            addCriterion("emp_age not in ", values, "emp_age");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeBetween(Integer value1, Integer value2) {
            addCriterion("emp_age between ", value1, value2, "emp_age");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_age not between ", value1, value2, "emp_age");
            return (EhcacheCriteria) this;
        }
        public EhcacheCriteria andEmpSexIsNull() {
            addCriterion("emp_sex is null");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexIsNotNull() {
            addCriterion("emp_sex is not null");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexEqualTo(String value) {
            addCriterion("emp_sex =", value, "emp_sex");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexNotEqualTo(String value) {
            addCriterion("emp_sex <>", value, "emp_sex");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexGreaterThan(String value) {
            addCriterion("emp_sex >", value, "emp_sex");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexGreaterThanOrEqualTo(String value) {
            addCriterion("emp_sex >=", value, "emp_sex");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexLessThan(String value) {
            addCriterion("emp_sex <", value, "emp_sex");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexLessThanOrEqualTo(String value) {
            addCriterion("emp_sex <=", value, "emp_sex");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexLike(String value) {
            addCriterion("emp_sex like ", value, "emp_sex", 1);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexNotLike(String value) {
            addCriterion("emp_sex  not like ", value, "emp_sex", 1);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexLeftLike(String value) {
            addCriterion("emp_sex like ", value, "emp_sex", 0);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexNotLeftLike(String value) {
            addCriterion("emp_sex  not like ", value, "emp_sex", 0);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexRightLike(String value) {
            addCriterion("emp_sex like ", value, "emp_sex", 2);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexNotRightLike(String value) {
            addCriterion("emp_sex  not like ", value, "emp_sex", 2);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexIn(List<String> values) {
            addCriterion("emp_sex  in ", values, "emp_sex");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexNotIn(List<String> values) {
            addCriterion("emp_sex not in ", values, "emp_sex");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexBetween(String value1, String value2) {
            addCriterion("emp_sex between ", value1, value2, "emp_sex");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpSexNotBetween(String value1, String value2) {
            addCriterion("emp_sex not between ", value1, value2, "emp_sex");
            return (EhcacheCriteria) this;
        }
        public EhcacheCriteria andEmpBirthdayIsNull() {
            addCriterion("emp_birthday is null");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayIsNotNull() {
            addCriterion("emp_birthday is not null");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayEqualTo(Date value) {
            addCriterion("emp_birthday =", value, "emp_birthday");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayNotEqualTo(Date value) {
            addCriterion("emp_birthday <>", value, "emp_birthday");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayGreaterThan(Date value) {
            addCriterion("emp_birthday >", value, "emp_birthday");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("emp_birthday >=", value, "emp_birthday");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayLessThan(Date value) {
            addCriterion("emp_birthday <", value, "emp_birthday");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("emp_birthday <=", value, "emp_birthday");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayLike(Date value) {
            addCriterion("emp_birthday like ", value, "emp_birthday", 1);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayNotLike(Date value) {
            addCriterion("emp_birthday  not like ", value, "emp_birthday", 1);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayLeftLike(Date value) {
            addCriterion("emp_birthday like ", value, "emp_birthday", 0);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayNotLeftLike(Date value) {
            addCriterion("emp_birthday  not like ", value, "emp_birthday", 0);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayRightLike(Date value) {
            addCriterion("emp_birthday like ", value, "emp_birthday", 2);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayNotRightLike(Date value) {
            addCriterion("emp_birthday  not like ", value, "emp_birthday", 2);
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayIn(List<Date> values) {
            addCriterion("emp_birthday  in ", values, "emp_birthday");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayNotIn(List<Date> values) {
            addCriterion("emp_birthday not in ", values, "emp_birthday");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayBetween(Date value1, Date value2) {
            addCriterion("emp_birthday between ", value1, value2, "emp_birthday");
            return (EhcacheCriteria) this;
        }

        public EhcacheCriteria andEmpBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("emp_birthday not between ", value1, value2, "emp_birthday");
            return (EhcacheCriteria) this;
        }

    }

    public static class EhcacheCriteria extends GeneratedCriteria {

        protected EhcacheCriteria() {
            super();
        }
    }

    public static class EhcacheCriterion {
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

        protected EhcacheCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected EhcacheCriterion(String condition, Object value, int likeType) {
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

        protected EhcacheCriterion(String condition, Object value,
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

        protected EhcacheCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected EhcacheCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected EhcacheCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}