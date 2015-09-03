package com.ztesoft.web.information.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class  CxrzArg {
    private String pk_name = "ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<CxrzCriteria> oredCriteria;

    public CxrzArg() {
        oredCriteria = new ArrayList<CxrzCriteria>();
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

    public List<CxrzCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(CxrzCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public CxrzCriteria or() {
    	CxrzCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CxrzCriteria createCriteria() {
    	CxrzCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CxrzCriteria createCriteriaInternal() {
    	CxrzCriteria criteria = new CxrzCriteria();
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
        protected List<CxrzCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<CxrzCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<CxrzCriterion> getAllCriteria() {
            return criteria;
        }

        public List<CxrzCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new CxrzCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new CxrzCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new CxrzCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new CxrzCriterion(condition, value1, value2));
        }

        public CxrzCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andIdIsNull() {
            addCriterion("ID is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdLessThan(String value) {
            addCriterion("ID <", value, "ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdLike(String value) {
            addCriterion("ID like ", value, "ID", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdNotLike(String value) {
            addCriterion("ID  not like ", value, "ID", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdLeftLike(String value) {
            addCriterion("ID like ", value, "ID", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdNotLeftLike(String value) {
            addCriterion("ID  not like ", value, "ID", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdRightLike(String value) {
            addCriterion("ID like ", value, "ID", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdNotRightLike(String value) {
            addCriterion("ID  not like ", value, "ID", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdIn(List<String> values) {
            addCriterion("ID  in ", values, "ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdNotIn(List<String> values) {
            addCriterion("ID not in ", values, "ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdBetween(String value1, String value2) {
            addCriterion("ID between ", value1, value2, "ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between ", value1, value2, "ID");
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andSqrIdIsNull() {
            addCriterion("SQR_ID is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdIsNotNull() {
            addCriterion("SQR_ID is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdEqualTo(String value) {
            addCriterion("SQR_ID =", value, "SQR_ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdNotEqualTo(String value) {
            addCriterion("SQR_ID <>", value, "SQR_ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdGreaterThan(String value) {
            addCriterion("SQR_ID >", value, "SQR_ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdGreaterThanOrEqualTo(String value) {
            addCriterion("SQR_ID >=", value, "SQR_ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdLessThan(String value) {
            addCriterion("SQR_ID <", value, "SQR_ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdLessThanOrEqualTo(String value) {
            addCriterion("SQR_ID <=", value, "SQR_ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdLike(String value) {
            addCriterion("SQR_ID like ", value, "SQR_ID", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdNotLike(String value) {
            addCriterion("SQR_ID  not like ", value, "SQR_ID", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdLeftLike(String value) {
            addCriterion("SQR_ID like ", value, "SQR_ID", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdNotLeftLike(String value) {
            addCriterion("SQR_ID  not like ", value, "SQR_ID", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdRightLike(String value) {
            addCriterion("SQR_ID like ", value, "SQR_ID", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdNotRightLike(String value) {
            addCriterion("SQR_ID  not like ", value, "SQR_ID", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdIn(List<String> values) {
            addCriterion("SQR_ID  in ", values, "SQR_ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdNotIn(List<String> values) {
            addCriterion("SQR_ID not in ", values, "SQR_ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdBetween(String value1, String value2) {
            addCriterion("SQR_ID between ", value1, value2, "SQR_ID");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andSqrIdNotBetween(String value1, String value2) {
            addCriterion("SQR_ID not between ", value1, value2, "SQR_ID");
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andCxrqIsNull() {
            addCriterion("CXRQ is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqIsNotNull() {
            addCriterion("CXRQ is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqEqualTo(String value) {
            addCriterion("CXRQ =", value, "CXRQ");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqNotEqualTo(String value) {
            addCriterion("CXRQ <>", value, "CXRQ");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqGreaterThan(String value) {
            addCriterion("CXRQ >", value, "CXRQ");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqGreaterThanOrEqualTo(String value) {
            addCriterion("CXRQ >=", value, "CXRQ");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqLessThan(String value) {
            addCriterion("CXRQ <", value, "CXRQ");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqLessThanOrEqualTo(String value) {
            addCriterion("CXRQ <=", value, "CXRQ");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqLike(String value) {
            addCriterion("CXRQ like ", value, "CXRQ", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqNotLike(String value) {
            addCriterion("CXRQ  not like ", value, "CXRQ", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqLeftLike(String value) {
            addCriterion("CXRQ like ", value, "CXRQ", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqNotLeftLike(String value) {
            addCriterion("CXRQ  not like ", value, "CXRQ", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqRightLike(String value) {
            addCriterion("CXRQ like ", value, "CXRQ", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqNotRightLike(String value) {
            addCriterion("CXRQ  not like ", value, "CXRQ", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqIn(List<String> values) {
            addCriterion("CXRQ  in ", values, "CXRQ");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqNotIn(List<String> values) {
            addCriterion("CXRQ not in ", values, "CXRQ");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqBetween(String value1, String value2) {
            addCriterion("CXRQ between ", value1, value2, "CXRQ");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxrqNotBetween(String value1, String value2) {
            addCriterion("CXRQ not between ", value1, value2, "CXRQ");
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andCxbsIsNull() {
            addCriterion("CXBS is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsIsNotNull() {
            addCriterion("CXBS is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsEqualTo(String value) {
            addCriterion("CXBS =", value, "CXBS");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsNotEqualTo(String value) {
            addCriterion("CXBS <>", value, "CXBS");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsGreaterThan(String value) {
            addCriterion("CXBS >", value, "CXBS");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsGreaterThanOrEqualTo(String value) {
            addCriterion("CXBS >=", value, "CXBS");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsLessThan(String value) {
            addCriterion("CXBS <", value, "CXBS");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsLessThanOrEqualTo(String value) {
            addCriterion("CXBS <=", value, "CXBS");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsLike(String value) {
            addCriterion("CXBS like ", value, "CXBS", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsNotLike(String value) {
            addCriterion("CXBS  not like ", value, "CXBS", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsLeftLike(String value) {
            addCriterion("CXBS like ", value, "CXBS", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsNotLeftLike(String value) {
            addCriterion("CXBS  not like ", value, "CXBS", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsRightLike(String value) {
            addCriterion("CXBS like ", value, "CXBS", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsNotRightLike(String value) {
            addCriterion("CXBS  not like ", value, "CXBS", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsIn(List<String> values) {
            addCriterion("CXBS  in ", values, "CXBS");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsNotIn(List<String> values) {
            addCriterion("CXBS not in ", values, "CXBS");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsBetween(String value1, String value2) {
            addCriterion("CXBS between ", value1, value2, "CXBS");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andCxbsNotBetween(String value1, String value2) {
            addCriterion("CXBS not between ", value1, value2, "CXBS");
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andColumn7IsNull() {
            addCriterion("Column_7 is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7IsNotNull() {
            addCriterion("Column_7 is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7EqualTo(String value) {
            addCriterion("Column_7 =", value, "Column_7");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7NotEqualTo(String value) {
            addCriterion("Column_7 <>", value, "Column_7");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7GreaterThan(String value) {
            addCriterion("Column_7 >", value, "Column_7");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7GreaterThanOrEqualTo(String value) {
            addCriterion("Column_7 >=", value, "Column_7");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7LessThan(String value) {
            addCriterion("Column_7 <", value, "Column_7");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7LessThanOrEqualTo(String value) {
            addCriterion("Column_7 <=", value, "Column_7");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7Like(String value) {
            addCriterion("Column_7 like ", value, "Column_7", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7NotLike(String value) {
            addCriterion("Column_7  not like ", value, "Column_7", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7LeftLike(String value) {
            addCriterion("Column_7 like ", value, "Column_7", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7NotLeftLike(String value) {
            addCriterion("Column_7  not like ", value, "Column_7", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7RightLike(String value) {
            addCriterion("Column_7 like ", value, "Column_7", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7NotRightLike(String value) {
            addCriterion("Column_7  not like ", value, "Column_7", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7In(List<String> values) {
            addCriterion("Column_7  in ", values, "Column_7");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7NotIn(List<String> values) {
            addCriterion("Column_7 not in ", values, "Column_7");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7Between(String value1, String value2) {
            addCriterion("Column_7 between ", value1, value2, "Column_7");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn7NotBetween(String value1, String value2) {
            addCriterion("Column_7 not between ", value1, value2, "Column_7");
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andColumn8IsNull() {
            addCriterion("Column_8 is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8IsNotNull() {
            addCriterion("Column_8 is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8EqualTo(String value) {
            addCriterion("Column_8 =", value, "Column_8");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8NotEqualTo(String value) {
            addCriterion("Column_8 <>", value, "Column_8");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8GreaterThan(String value) {
            addCriterion("Column_8 >", value, "Column_8");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8GreaterThanOrEqualTo(String value) {
            addCriterion("Column_8 >=", value, "Column_8");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8LessThan(String value) {
            addCriterion("Column_8 <", value, "Column_8");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8LessThanOrEqualTo(String value) {
            addCriterion("Column_8 <=", value, "Column_8");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8Like(String value) {
            addCriterion("Column_8 like ", value, "Column_8", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8NotLike(String value) {
            addCriterion("Column_8  not like ", value, "Column_8", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8LeftLike(String value) {
            addCriterion("Column_8 like ", value, "Column_8", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8NotLeftLike(String value) {
            addCriterion("Column_8  not like ", value, "Column_8", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8RightLike(String value) {
            addCriterion("Column_8 like ", value, "Column_8", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8NotRightLike(String value) {
            addCriterion("Column_8  not like ", value, "Column_8", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8In(List<String> values) {
            addCriterion("Column_8  in ", values, "Column_8");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8NotIn(List<String> values) {
            addCriterion("Column_8 not in ", values, "Column_8");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8Between(String value1, String value2) {
            addCriterion("Column_8 between ", value1, value2, "Column_8");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn8NotBetween(String value1, String value2) {
            addCriterion("Column_8 not between ", value1, value2, "Column_8");
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andColumn9IsNull() {
            addCriterion("Column_9 is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9IsNotNull() {
            addCriterion("Column_9 is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9EqualTo(String value) {
            addCriterion("Column_9 =", value, "Column_9");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9NotEqualTo(String value) {
            addCriterion("Column_9 <>", value, "Column_9");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9GreaterThan(String value) {
            addCriterion("Column_9 >", value, "Column_9");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9GreaterThanOrEqualTo(String value) {
            addCriterion("Column_9 >=", value, "Column_9");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9LessThan(String value) {
            addCriterion("Column_9 <", value, "Column_9");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9LessThanOrEqualTo(String value) {
            addCriterion("Column_9 <=", value, "Column_9");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9Like(String value) {
            addCriterion("Column_9 like ", value, "Column_9", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9NotLike(String value) {
            addCriterion("Column_9  not like ", value, "Column_9", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9LeftLike(String value) {
            addCriterion("Column_9 like ", value, "Column_9", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9NotLeftLike(String value) {
            addCriterion("Column_9  not like ", value, "Column_9", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9RightLike(String value) {
            addCriterion("Column_9 like ", value, "Column_9", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9NotRightLike(String value) {
            addCriterion("Column_9  not like ", value, "Column_9", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9In(List<String> values) {
            addCriterion("Column_9  in ", values, "Column_9");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9NotIn(List<String> values) {
            addCriterion("Column_9 not in ", values, "Column_9");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9Between(String value1, String value2) {
            addCriterion("Column_9 between ", value1, value2, "Column_9");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn9NotBetween(String value1, String value2) {
            addCriterion("Column_9 not between ", value1, value2, "Column_9");
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andColumn10IsNull() {
            addCriterion("Column_10 is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10IsNotNull() {
            addCriterion("Column_10 is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10EqualTo(String value) {
            addCriterion("Column_10 =", value, "Column_10");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10NotEqualTo(String value) {
            addCriterion("Column_10 <>", value, "Column_10");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10GreaterThan(String value) {
            addCriterion("Column_10 >", value, "Column_10");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10GreaterThanOrEqualTo(String value) {
            addCriterion("Column_10 >=", value, "Column_10");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10LessThan(String value) {
            addCriterion("Column_10 <", value, "Column_10");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10LessThanOrEqualTo(String value) {
            addCriterion("Column_10 <=", value, "Column_10");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10Like(String value) {
            addCriterion("Column_10 like ", value, "Column_10", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10NotLike(String value) {
            addCriterion("Column_10  not like ", value, "Column_10", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10LeftLike(String value) {
            addCriterion("Column_10 like ", value, "Column_10", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10NotLeftLike(String value) {
            addCriterion("Column_10  not like ", value, "Column_10", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10RightLike(String value) {
            addCriterion("Column_10 like ", value, "Column_10", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10NotRightLike(String value) {
            addCriterion("Column_10  not like ", value, "Column_10", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10In(List<String> values) {
            addCriterion("Column_10  in ", values, "Column_10");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10NotIn(List<String> values) {
            addCriterion("Column_10 not in ", values, "Column_10");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10Between(String value1, String value2) {
            addCriterion("Column_10 between ", value1, value2, "Column_10");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn10NotBetween(String value1, String value2) {
            addCriterion("Column_10 not between ", value1, value2, "Column_10");
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andColumn11IsNull() {
            addCriterion("Column_11 is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11IsNotNull() {
            addCriterion("Column_11 is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11EqualTo(String value) {
            addCriterion("Column_11 =", value, "Column_11");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11NotEqualTo(String value) {
            addCriterion("Column_11 <>", value, "Column_11");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11GreaterThan(String value) {
            addCriterion("Column_11 >", value, "Column_11");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11GreaterThanOrEqualTo(String value) {
            addCriterion("Column_11 >=", value, "Column_11");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11LessThan(String value) {
            addCriterion("Column_11 <", value, "Column_11");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11LessThanOrEqualTo(String value) {
            addCriterion("Column_11 <=", value, "Column_11");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11Like(String value) {
            addCriterion("Column_11 like ", value, "Column_11", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11NotLike(String value) {
            addCriterion("Column_11  not like ", value, "Column_11", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11LeftLike(String value) {
            addCriterion("Column_11 like ", value, "Column_11", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11NotLeftLike(String value) {
            addCriterion("Column_11  not like ", value, "Column_11", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11RightLike(String value) {
            addCriterion("Column_11 like ", value, "Column_11", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11NotRightLike(String value) {
            addCriterion("Column_11  not like ", value, "Column_11", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11In(List<String> values) {
            addCriterion("Column_11  in ", values, "Column_11");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11NotIn(List<String> values) {
            addCriterion("Column_11 not in ", values, "Column_11");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11Between(String value1, String value2) {
            addCriterion("Column_11 between ", value1, value2, "Column_11");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn11NotBetween(String value1, String value2) {
            addCriterion("Column_11 not between ", value1, value2, "Column_11");
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andColumn12IsNull() {
            addCriterion("Column_12 is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12IsNotNull() {
            addCriterion("Column_12 is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12EqualTo(String value) {
            addCriterion("Column_12 =", value, "Column_12");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12NotEqualTo(String value) {
            addCriterion("Column_12 <>", value, "Column_12");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12GreaterThan(String value) {
            addCriterion("Column_12 >", value, "Column_12");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12GreaterThanOrEqualTo(String value) {
            addCriterion("Column_12 >=", value, "Column_12");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12LessThan(String value) {
            addCriterion("Column_12 <", value, "Column_12");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12LessThanOrEqualTo(String value) {
            addCriterion("Column_12 <=", value, "Column_12");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12Like(String value) {
            addCriterion("Column_12 like ", value, "Column_12", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12NotLike(String value) {
            addCriterion("Column_12  not like ", value, "Column_12", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12LeftLike(String value) {
            addCriterion("Column_12 like ", value, "Column_12", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12NotLeftLike(String value) {
            addCriterion("Column_12  not like ", value, "Column_12", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12RightLike(String value) {
            addCriterion("Column_12 like ", value, "Column_12", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12NotRightLike(String value) {
            addCriterion("Column_12  not like ", value, "Column_12", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12In(List<String> values) {
            addCriterion("Column_12  in ", values, "Column_12");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12NotIn(List<String> values) {
            addCriterion("Column_12 not in ", values, "Column_12");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12Between(String value1, String value2) {
            addCriterion("Column_12 between ", value1, value2, "Column_12");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn12NotBetween(String value1, String value2) {
            addCriterion("Column_12 not between ", value1, value2, "Column_12");
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andColumn13IsNull() {
            addCriterion("Column_13 is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13IsNotNull() {
            addCriterion("Column_13 is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13EqualTo(String value) {
            addCriterion("Column_13 =", value, "Column_13");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13NotEqualTo(String value) {
            addCriterion("Column_13 <>", value, "Column_13");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13GreaterThan(String value) {
            addCriterion("Column_13 >", value, "Column_13");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13GreaterThanOrEqualTo(String value) {
            addCriterion("Column_13 >=", value, "Column_13");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13LessThan(String value) {
            addCriterion("Column_13 <", value, "Column_13");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13LessThanOrEqualTo(String value) {
            addCriterion("Column_13 <=", value, "Column_13");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13Like(String value) {
            addCriterion("Column_13 like ", value, "Column_13", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13NotLike(String value) {
            addCriterion("Column_13  not like ", value, "Column_13", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13LeftLike(String value) {
            addCriterion("Column_13 like ", value, "Column_13", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13NotLeftLike(String value) {
            addCriterion("Column_13  not like ", value, "Column_13", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13RightLike(String value) {
            addCriterion("Column_13 like ", value, "Column_13", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13NotRightLike(String value) {
            addCriterion("Column_13  not like ", value, "Column_13", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13In(List<String> values) {
            addCriterion("Column_13  in ", values, "Column_13");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13NotIn(List<String> values) {
            addCriterion("Column_13 not in ", values, "Column_13");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13Between(String value1, String value2) {
            addCriterion("Column_13 between ", value1, value2, "Column_13");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn13NotBetween(String value1, String value2) {
            addCriterion("Column_13 not between ", value1, value2, "Column_13");
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andColumn14IsNull() {
            addCriterion("Column_14 is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14IsNotNull() {
            addCriterion("Column_14 is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14EqualTo(String value) {
            addCriterion("Column_14 =", value, "Column_14");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14NotEqualTo(String value) {
            addCriterion("Column_14 <>", value, "Column_14");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14GreaterThan(String value) {
            addCriterion("Column_14 >", value, "Column_14");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14GreaterThanOrEqualTo(String value) {
            addCriterion("Column_14 >=", value, "Column_14");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14LessThan(String value) {
            addCriterion("Column_14 <", value, "Column_14");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14LessThanOrEqualTo(String value) {
            addCriterion("Column_14 <=", value, "Column_14");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14Like(String value) {
            addCriterion("Column_14 like ", value, "Column_14", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14NotLike(String value) {
            addCriterion("Column_14  not like ", value, "Column_14", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14LeftLike(String value) {
            addCriterion("Column_14 like ", value, "Column_14", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14NotLeftLike(String value) {
            addCriterion("Column_14  not like ", value, "Column_14", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14RightLike(String value) {
            addCriterion("Column_14 like ", value, "Column_14", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14NotRightLike(String value) {
            addCriterion("Column_14  not like ", value, "Column_14", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14In(List<String> values) {
            addCriterion("Column_14  in ", values, "Column_14");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14NotIn(List<String> values) {
            addCriterion("Column_14 not in ", values, "Column_14");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14Between(String value1, String value2) {
            addCriterion("Column_14 between ", value1, value2, "Column_14");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn14NotBetween(String value1, String value2) {
            addCriterion("Column_14 not between ", value1, value2, "Column_14");
            return (CxrzCriteria) this;
        }
        public CxrzCriteria andColumn15IsNull() {
            addCriterion("Column_15 is null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15IsNotNull() {
            addCriterion("Column_15 is not null");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15EqualTo(String value) {
            addCriterion("Column_15 =", value, "Column_15");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15NotEqualTo(String value) {
            addCriterion("Column_15 <>", value, "Column_15");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15GreaterThan(String value) {
            addCriterion("Column_15 >", value, "Column_15");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15GreaterThanOrEqualTo(String value) {
            addCriterion("Column_15 >=", value, "Column_15");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15LessThan(String value) {
            addCriterion("Column_15 <", value, "Column_15");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15LessThanOrEqualTo(String value) {
            addCriterion("Column_15 <=", value, "Column_15");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15Like(String value) {
            addCriterion("Column_15 like ", value, "Column_15", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15NotLike(String value) {
            addCriterion("Column_15  not like ", value, "Column_15", 1);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15LeftLike(String value) {
            addCriterion("Column_15 like ", value, "Column_15", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15NotLeftLike(String value) {
            addCriterion("Column_15  not like ", value, "Column_15", 0);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15RightLike(String value) {
            addCriterion("Column_15 like ", value, "Column_15", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15NotRightLike(String value) {
            addCriterion("Column_15  not like ", value, "Column_15", 2);
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15In(List<String> values) {
            addCriterion("Column_15  in ", values, "Column_15");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15NotIn(List<String> values) {
            addCriterion("Column_15 not in ", values, "Column_15");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15Between(String value1, String value2) {
            addCriterion("Column_15 between ", value1, value2, "Column_15");
            return (CxrzCriteria) this;
        }

        public CxrzCriteria andColumn15NotBetween(String value1, String value2) {
            addCriterion("Column_15 not between ", value1, value2, "Column_15");
            return (CxrzCriteria) this;
        }

    }

    public static class CxrzCriteria extends GeneratedCriteria {

        protected CxrzCriteria() {
            super();
        }
    }

    public static class CxrzCriterion {
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

        protected CxrzCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected CxrzCriterion(String condition, Object value, int likeType) {
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

        protected CxrzCriterion(String condition, Object value,
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

        protected CxrzCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected CxrzCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected CxrzCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}