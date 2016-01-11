package com.ztesoft.web.information.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class TBcxrxxArg {
    private String pk_name = "ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<TBcxrxxCriteria> oredCriteria;

    public TBcxrxxArg() {
        oredCriteria = new ArrayList<TBcxrxxCriteria>();
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

    public List<TBcxrxxCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(TBcxrxxCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public TBcxrxxCriteria or() {
    	TBcxrxxCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public TBcxrxxCriteria createCriteria() {
    	TBcxrxxCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected TBcxrxxCriteria createCriteriaInternal() {
    	TBcxrxxCriteria criteria = new TBcxrxxCriteria();
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
        protected List<TBcxrxxCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<TBcxrxxCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<TBcxrxxCriterion> getAllCriteria() {
            return criteria;
        }

        public List<TBcxrxxCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new TBcxrxxCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new TBcxrxxCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new TBcxrxxCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new TBcxrxxCriterion(condition, value1, value2));
        }

        public TBcxrxxCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andIdIsNull() {
            addCriterion("ID is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdLessThan(String value) {
            addCriterion("ID <", value, "ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdLike(String value) {
            addCriterion("ID like ", value, "ID", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdNotLike(String value) {
            addCriterion("ID  not like ", value, "ID", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdLeftLike(String value) {
            addCriterion("ID like ", value, "ID", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdNotLeftLike(String value) {
            addCriterion("ID  not like ", value, "ID", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdRightLike(String value) {
            addCriterion("ID like ", value, "ID", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdNotRightLike(String value) {
            addCriterion("ID  not like ", value, "ID", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdIn(List<String> values) {
            addCriterion("ID  in ", values, "ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdNotIn(List<String> values) {
            addCriterion("ID not in ", values, "ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdBetween(String value1, String value2) {
            addCriterion("ID between ", value1, value2, "ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between ", value1, value2, "ID");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andSqrIdIsNull() {
            addCriterion("SQR_ID is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdIsNotNull() {
            addCriterion("SQR_ID is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdEqualTo(String value) {
            addCriterion("SQR_ID =", value, "SQR_ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdNotEqualTo(String value) {
            addCriterion("SQR_ID <>", value, "SQR_ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdGreaterThan(String value) {
            addCriterion("SQR_ID >", value, "SQR_ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdGreaterThanOrEqualTo(String value) {
            addCriterion("SQR_ID >=", value, "SQR_ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdLessThan(String value) {
            addCriterion("SQR_ID <", value, "SQR_ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdLessThanOrEqualTo(String value) {
            addCriterion("SQR_ID <=", value, "SQR_ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdLike(String value) {
            addCriterion("SQR_ID like ", value, "SQR_ID", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdNotLike(String value) {
            addCriterion("SQR_ID  not like ", value, "SQR_ID", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdLeftLike(String value) {
            addCriterion("SQR_ID like ", value, "SQR_ID", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdNotLeftLike(String value) {
            addCriterion("SQR_ID  not like ", value, "SQR_ID", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdRightLike(String value) {
            addCriterion("SQR_ID like ", value, "SQR_ID", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdNotRightLike(String value) {
            addCriterion("SQR_ID  not like ", value, "SQR_ID", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdIn(List<String> values) {
            addCriterion("SQR_ID  in ", values, "SQR_ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdNotIn(List<String> values) {
            addCriterion("SQR_ID not in ", values, "SQR_ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdBetween(String value1, String value2) {
            addCriterion("SQR_ID between ", value1, value2, "SQR_ID");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSqrIdNotBetween(String value1, String value2) {
            addCriterion("SQR_ID not between ", value1, value2, "SQR_ID");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andZjhIsNull() {
            addCriterion("ZJH is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhIsNotNull() {
            addCriterion("ZJH is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhEqualTo(String value) {
            addCriterion("ZJH =", value, "ZJH");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhNotEqualTo(String value) {
            addCriterion("ZJH <>", value, "ZJH");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhGreaterThan(String value) {
            addCriterion("ZJH >", value, "ZJH");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhGreaterThanOrEqualTo(String value) {
            addCriterion("ZJH >=", value, "ZJH");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhLessThan(String value) {
            addCriterion("ZJH <", value, "ZJH");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhLessThanOrEqualTo(String value) {
            addCriterion("ZJH <=", value, "ZJH");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhLike(String value) {
            addCriterion("ZJH like ", value, "ZJH", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhNotLike(String value) {
            addCriterion("ZJH  not like ", value, "ZJH", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhLeftLike(String value) {
            addCriterion("ZJH like ", value, "ZJH", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhNotLeftLike(String value) {
            addCriterion("ZJH  not like ", value, "ZJH", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhRightLike(String value) {
            addCriterion("ZJH like ", value, "ZJH", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhNotRightLike(String value) {
            addCriterion("ZJH  not like ", value, "ZJH", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhIn(List<String> values) {
            addCriterion("ZJH  in ", values, "ZJH");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhNotIn(List<String> values) {
            addCriterion("ZJH not in ", values, "ZJH");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhBetween(String value1, String value2) {
            addCriterion("ZJH between ", value1, value2, "ZJH");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjhNotBetween(String value1, String value2) {
            addCriterion("ZJH not between ", value1, value2, "ZJH");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andZjlxIsNull() {
            addCriterion("ZJLX is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxIsNotNull() {
            addCriterion("ZJLX is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxEqualTo(String value) {
            addCriterion("ZJLX =", value, "ZJLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxNotEqualTo(String value) {
            addCriterion("ZJLX <>", value, "ZJLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxGreaterThan(String value) {
            addCriterion("ZJLX >", value, "ZJLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxGreaterThanOrEqualTo(String value) {
            addCriterion("ZJLX >=", value, "ZJLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxLessThan(String value) {
            addCriterion("ZJLX <", value, "ZJLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxLessThanOrEqualTo(String value) {
            addCriterion("ZJLX <=", value, "ZJLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxLike(String value) {
            addCriterion("ZJLX like ", value, "ZJLX", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxNotLike(String value) {
            addCriterion("ZJLX  not like ", value, "ZJLX", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxLeftLike(String value) {
            addCriterion("ZJLX like ", value, "ZJLX", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxNotLeftLike(String value) {
            addCriterion("ZJLX  not like ", value, "ZJLX", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxRightLike(String value) {
            addCriterion("ZJLX like ", value, "ZJLX", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxNotRightLike(String value) {
            addCriterion("ZJLX  not like ", value, "ZJLX", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxIn(List<String> values) {
            addCriterion("ZJLX  in ", values, "ZJLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxNotIn(List<String> values) {
            addCriterion("ZJLX not in ", values, "ZJLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxBetween(String value1, String value2) {
            addCriterion("ZJLX between ", value1, value2, "ZJLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZjlxNotBetween(String value1, String value2) {
            addCriterion("ZJLX not between ", value1, value2, "ZJLX");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andXmIsNull() {
            addCriterion("XM is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmIsNotNull() {
            addCriterion("XM is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmEqualTo(String value) {
            addCriterion("XM =", value, "XM");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmNotEqualTo(String value) {
            addCriterion("XM <>", value, "XM");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmGreaterThan(String value) {
            addCriterion("XM >", value, "XM");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmGreaterThanOrEqualTo(String value) {
            addCriterion("XM >=", value, "XM");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmLessThan(String value) {
            addCriterion("XM <", value, "XM");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmLessThanOrEqualTo(String value) {
            addCriterion("XM <=", value, "XM");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmLike(String value) {
            addCriterion("XM like ", value, "XM", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmNotLike(String value) {
            addCriterion("XM  not like ", value, "XM", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmLeftLike(String value) {
            addCriterion("XM like ", value, "XM", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmNotLeftLike(String value) {
            addCriterion("XM  not like ", value, "XM", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmRightLike(String value) {
            addCriterion("XM like ", value, "XM", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmNotRightLike(String value) {
            addCriterion("XM  not like ", value, "XM", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmIn(List<String> values) {
            addCriterion("XM  in ", values, "XM");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmNotIn(List<String> values) {
            addCriterion("XM not in ", values, "XM");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmBetween(String value1, String value2) {
            addCriterion("XM between ", value1, value2, "XM");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXmNotBetween(String value1, String value2) {
            addCriterion("XM not between ", value1, value2, "XM");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andSfzzpIsNull() {
            addCriterion("SFZZP is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpIsNotNull() {
            addCriterion("SFZZP is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpEqualTo(String value) {
            addCriterion("SFZZP =", value, "SFZZP");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpNotEqualTo(String value) {
            addCriterion("SFZZP <>", value, "SFZZP");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpGreaterThan(String value) {
            addCriterion("SFZZP >", value, "SFZZP");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpGreaterThanOrEqualTo(String value) {
            addCriterion("SFZZP >=", value, "SFZZP");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpLessThan(String value) {
            addCriterion("SFZZP <", value, "SFZZP");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpLessThanOrEqualTo(String value) {
            addCriterion("SFZZP <=", value, "SFZZP");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpLike(String value) {
            addCriterion("SFZZP like ", value, "SFZZP", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpNotLike(String value) {
            addCriterion("SFZZP  not like ", value, "SFZZP", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpLeftLike(String value) {
            addCriterion("SFZZP like ", value, "SFZZP", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpNotLeftLike(String value) {
            addCriterion("SFZZP  not like ", value, "SFZZP", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpRightLike(String value) {
            addCriterion("SFZZP like ", value, "SFZZP", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpNotRightLike(String value) {
            addCriterion("SFZZP  not like ", value, "SFZZP", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpIn(List<String> values) {
            addCriterion("SFZZP  in ", values, "SFZZP");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpNotIn(List<String> values) {
            addCriterion("SFZZP not in ", values, "SFZZP");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpBetween(String value1, String value2) {
            addCriterion("SFZZP between ", value1, value2, "SFZZP");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzzpNotBetween(String value1, String value2) {
            addCriterion("SFZZP not between ", value1, value2, "SFZZP");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andSfzfIsNull() {
            addCriterion("SFZF is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfIsNotNull() {
            addCriterion("SFZF is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfEqualTo(String value) {
            addCriterion("SFZF =", value, "SFZF");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfNotEqualTo(String value) {
            addCriterion("SFZF <>", value, "SFZF");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfGreaterThan(String value) {
            addCriterion("SFZF >", value, "SFZF");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfGreaterThanOrEqualTo(String value) {
            addCriterion("SFZF >=", value, "SFZF");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfLessThan(String value) {
            addCriterion("SFZF <", value, "SFZF");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfLessThanOrEqualTo(String value) {
            addCriterion("SFZF <=", value, "SFZF");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfLike(String value) {
            addCriterion("SFZF like ", value, "SFZF", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfNotLike(String value) {
            addCriterion("SFZF  not like ", value, "SFZF", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfLeftLike(String value) {
            addCriterion("SFZF like ", value, "SFZF", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfNotLeftLike(String value) {
            addCriterion("SFZF  not like ", value, "SFZF", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfRightLike(String value) {
            addCriterion("SFZF like ", value, "SFZF", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfNotRightLike(String value) {
            addCriterion("SFZF  not like ", value, "SFZF", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfIn(List<String> values) {
            addCriterion("SFZF  in ", values, "SFZF");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfNotIn(List<String> values) {
            addCriterion("SFZF not in ", values, "SFZF");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfBetween(String value1, String value2) {
            addCriterion("SFZF between ", value1, value2, "SFZF");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfzfNotBetween(String value1, String value2) {
            addCriterion("SFZF not between ", value1, value2, "SFZF");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andZflyIsNull() {
            addCriterion("ZFLY is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyIsNotNull() {
            addCriterion("ZFLY is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyEqualTo(String value) {
            addCriterion("ZFLY =", value, "ZFLY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyNotEqualTo(String value) {
            addCriterion("ZFLY <>", value, "ZFLY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyGreaterThan(String value) {
            addCriterion("ZFLY >", value, "ZFLY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyGreaterThanOrEqualTo(String value) {
            addCriterion("ZFLY >=", value, "ZFLY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyLessThan(String value) {
            addCriterion("ZFLY <", value, "ZFLY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyLessThanOrEqualTo(String value) {
            addCriterion("ZFLY <=", value, "ZFLY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyLike(String value) {
            addCriterion("ZFLY like ", value, "ZFLY", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyNotLike(String value) {
            addCriterion("ZFLY  not like ", value, "ZFLY", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyLeftLike(String value) {
            addCriterion("ZFLY like ", value, "ZFLY", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyNotLeftLike(String value) {
            addCriterion("ZFLY  not like ", value, "ZFLY", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyRightLike(String value) {
            addCriterion("ZFLY like ", value, "ZFLY", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyNotRightLike(String value) {
            addCriterion("ZFLY  not like ", value, "ZFLY", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyIn(List<String> values) {
            addCriterion("ZFLY  in ", values, "ZFLY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyNotIn(List<String> values) {
            addCriterion("ZFLY not in ", values, "ZFLY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyBetween(String value1, String value2) {
            addCriterion("ZFLY between ", value1, value2, "ZFLY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andZflyNotBetween(String value1, String value2) {
            addCriterion("ZFLY not between ", value1, value2, "ZFLY");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andSfdyIsNull() {
            addCriterion("SFDY is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyIsNotNull() {
            addCriterion("SFDY is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyEqualTo(String value) {
            addCriterion("SFDY =", value, "SFDY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyNotEqualTo(String value) {
            addCriterion("SFDY <>", value, "SFDY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyGreaterThan(String value) {
            addCriterion("SFDY >", value, "SFDY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyGreaterThanOrEqualTo(String value) {
            addCriterion("SFDY >=", value, "SFDY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyLessThan(String value) {
            addCriterion("SFDY <", value, "SFDY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyLessThanOrEqualTo(String value) {
            addCriterion("SFDY <=", value, "SFDY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyLike(String value) {
            addCriterion("SFDY like ", value, "SFDY", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyNotLike(String value) {
            addCriterion("SFDY  not like ", value, "SFDY", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyLeftLike(String value) {
            addCriterion("SFDY like ", value, "SFDY", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyNotLeftLike(String value) {
            addCriterion("SFDY  not like ", value, "SFDY", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyRightLike(String value) {
            addCriterion("SFDY like ", value, "SFDY", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyNotRightLike(String value) {
            addCriterion("SFDY  not like ", value, "SFDY", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyIn(List<String> values) {
            addCriterion("SFDY  in ", values, "SFDY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyNotIn(List<String> values) {
            addCriterion("SFDY not in ", values, "SFDY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyBetween(String value1, String value2) {
            addCriterion("SFDY between ", value1, value2, "SFDY");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andSfdyNotBetween(String value1, String value2) {
            addCriterion("SFDY not between ", value1, value2, "SFDY");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andBcxrqIsNull() {
            addCriterion("BCXRQ is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqIsNotNull() {
            addCriterion("BCXRQ is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqEqualTo(String value) {
            addCriterion("BCXRQ =", value, "BCXRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqNotEqualTo(String value) {
            addCriterion("BCXRQ <>", value, "BCXRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqGreaterThan(String value) {
            addCriterion("BCXRQ >", value, "BCXRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqGreaterThanOrEqualTo(String value) {
            addCriterion("BCXRQ >=", value, "BCXRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqLessThan(String value) {
            addCriterion("BCXRQ <", value, "BCXRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqLessThanOrEqualTo(String value) {
            addCriterion("BCXRQ <=", value, "BCXRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqLike(String value) {
            addCriterion("BCXRQ like ", value, "BCXRQ", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqNotLike(String value) {
            addCriterion("BCXRQ  not like ", value, "BCXRQ", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqLeftLike(String value) {
            addCriterion("BCXRQ like ", value, "BCXRQ", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqNotLeftLike(String value) {
            addCriterion("BCXRQ  not like ", value, "BCXRQ", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqRightLike(String value) {
            addCriterion("BCXRQ like ", value, "BCXRQ", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqNotRightLike(String value) {
            addCriterion("BCXRQ  not like ", value, "BCXRQ", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqIn(List<String> values) {
            addCriterion("BCXRQ  in ", values, "BCXRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqNotIn(List<String> values) {
            addCriterion("BCXRQ not in ", values, "BCXRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqBetween(String value1, String value2) {
            addCriterion("BCXRQ between ", value1, value2, "BCXRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andBcxrqNotBetween(String value1, String value2) {
            addCriterion("BCXRQ not between ", value1, value2, "BCXRQ");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andXgrqIsNull() {
            addCriterion("XGRQ is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqIsNotNull() {
            addCriterion("XGRQ is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqEqualTo(String value) {
            addCriterion("XGRQ =", value, "XGRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqNotEqualTo(String value) {
            addCriterion("XGRQ <>", value, "XGRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqGreaterThan(String value) {
            addCriterion("XGRQ >", value, "XGRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqGreaterThanOrEqualTo(String value) {
            addCriterion("XGRQ >=", value, "XGRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqLessThan(String value) {
            addCriterion("XGRQ <", value, "XGRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqLessThanOrEqualTo(String value) {
            addCriterion("XGRQ <=", value, "XGRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqLike(String value) {
            addCriterion("XGRQ like ", value, "XGRQ", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqNotLike(String value) {
            addCriterion("XGRQ  not like ", value, "XGRQ", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqLeftLike(String value) {
            addCriterion("XGRQ like ", value, "XGRQ", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqNotLeftLike(String value) {
            addCriterion("XGRQ  not like ", value, "XGRQ", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqRightLike(String value) {
            addCriterion("XGRQ like ", value, "XGRQ", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqNotRightLike(String value) {
            addCriterion("XGRQ  not like ", value, "XGRQ", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqIn(List<String> values) {
            addCriterion("XGRQ  in ", values, "XGRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqNotIn(List<String> values) {
            addCriterion("XGRQ not in ", values, "XGRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqBetween(String value1, String value2) {
            addCriterion("XGRQ between ", value1, value2, "XGRQ");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andXgrqNotBetween(String value1, String value2) {
            addCriterion("XGRQ not between ", value1, value2, "XGRQ");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andRklxIsNull() {
            addCriterion("RKLX is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxIsNotNull() {
            addCriterion("RKLX is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxEqualTo(String value) {
            addCriterion("RKLX =", value, "RKLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxNotEqualTo(String value) {
            addCriterion("RKLX <>", value, "RKLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxGreaterThan(String value) {
            addCriterion("RKLX >", value, "RKLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxGreaterThanOrEqualTo(String value) {
            addCriterion("RKLX >=", value, "RKLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxLessThan(String value) {
            addCriterion("RKLX <", value, "RKLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxLessThanOrEqualTo(String value) {
            addCriterion("RKLX <=", value, "RKLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxLike(String value) {
            addCriterion("RKLX like ", value, "RKLX", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxNotLike(String value) {
            addCriterion("RKLX  not like ", value, "RKLX", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxLeftLike(String value) {
            addCriterion("RKLX like ", value, "RKLX", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxNotLeftLike(String value) {
            addCriterion("RKLX  not like ", value, "RKLX", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxRightLike(String value) {
            addCriterion("RKLX like ", value, "RKLX", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxNotRightLike(String value) {
            addCriterion("RKLX  not like ", value, "RKLX", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxIn(List<String> values) {
            addCriterion("RKLX  in ", values, "RKLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxNotIn(List<String> values) {
            addCriterion("RKLX not in ", values, "RKLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxBetween(String value1, String value2) {
            addCriterion("RKLX between ", value1, value2, "RKLX");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andRklxNotBetween(String value1, String value2) {
            addCriterion("RKLX not between ", value1, value2, "RKLX");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andCxcsIsNull() {
            addCriterion("CXCS is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsIsNotNull() {
            addCriterion("CXCS is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsEqualTo(Integer value) {
            addCriterion("CXCS =", value, "CXCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsNotEqualTo(Integer value) {
            addCriterion("CXCS <>", value, "CXCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsGreaterThan(Integer value) {
            addCriterion("CXCS >", value, "CXCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsGreaterThanOrEqualTo(Integer value) {
            addCriterion("CXCS >=", value, "CXCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsLessThan(Integer value) {
            addCriterion("CXCS <", value, "CXCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsLessThanOrEqualTo(Integer value) {
            addCriterion("CXCS <=", value, "CXCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsLike(Integer value) {
            addCriterion("CXCS like ", value, "CXCS", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsNotLike(Integer value) {
            addCriterion("CXCS  not like ", value, "CXCS", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsLeftLike(Integer value) {
            addCriterion("CXCS like ", value, "CXCS", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsNotLeftLike(Integer value) {
            addCriterion("CXCS  not like ", value, "CXCS", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsRightLike(Integer value) {
            addCriterion("CXCS like ", value, "CXCS", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsNotRightLike(Integer value) {
            addCriterion("CXCS  not like ", value, "CXCS", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsIn(List<Integer> values) {
            addCriterion("CXCS  in ", values, "CXCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsNotIn(List<Integer> values) {
            addCriterion("CXCS not in ", values, "CXCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsBetween(Integer value1, Integer value2) {
            addCriterion("CXCS between ", value1, value2, "CXCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andCxcsNotBetween(Integer value1, Integer value2) {
            addCriterion("CXCS not between ", value1, value2, "CXCS");
            return (TBcxrxxCriteria) this;
        }
        public TBcxrxxCriteria andDycsIsNull() {
            addCriterion("DYCS is null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsIsNotNull() {
            addCriterion("DYCS is not null");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsEqualTo(Integer value) {
            addCriterion("DYCS =", value, "DYCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsNotEqualTo(Integer value) {
            addCriterion("DYCS <>", value, "DYCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsGreaterThan(Integer value) {
            addCriterion("DYCS >", value, "DYCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsGreaterThanOrEqualTo(Integer value) {
            addCriterion("DYCS >=", value, "DYCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsLessThan(Integer value) {
            addCriterion("DYCS <", value, "DYCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsLessThanOrEqualTo(Integer value) {
            addCriterion("DYCS <=", value, "DYCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsLike(Integer value) {
            addCriterion("DYCS like ", value, "DYCS", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsNotLike(Integer value) {
            addCriterion("DYCS  not like ", value, "DYCS", 1);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsLeftLike(Integer value) {
            addCriterion("DYCS like ", value, "DYCS", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsNotLeftLike(Integer value) {
            addCriterion("DYCS  not like ", value, "DYCS", 0);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsRightLike(Integer value) {
            addCriterion("DYCS like ", value, "DYCS", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsNotRightLike(Integer value) {
            addCriterion("DYCS  not like ", value, "DYCS", 2);
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsIn(List<Integer> values) {
            addCriterion("DYCS  in ", values, "DYCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsNotIn(List<Integer> values) {
            addCriterion("DYCS not in ", values, "DYCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsBetween(Integer value1, Integer value2) {
            addCriterion("DYCS between ", value1, value2, "DYCS");
            return (TBcxrxxCriteria) this;
        }

        public TBcxrxxCriteria andDycsNotBetween(Integer value1, Integer value2) {
            addCriterion("DYCS not between ", value1, value2, "DYCS");
            return (TBcxrxxCriteria) this;
        }

    }

    public static class TBcxrxxCriteria extends GeneratedCriteria {

        protected TBcxrxxCriteria() {
            super();
        }
    }

    public static class TBcxrxxCriterion {
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

        protected TBcxrxxCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected TBcxrxxCriterion(String condition, Object value, int likeType) {
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

        protected TBcxrxxCriterion(String condition, Object value,
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

        protected TBcxrxxCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected TBcxrxxCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected TBcxrxxCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}