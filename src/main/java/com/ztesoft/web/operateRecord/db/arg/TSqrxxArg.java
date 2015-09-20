package com.ztesoft.web.operateRecord.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class TSqrxxArg {
    private String pk_name = "ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<TSqrxxCriteria> oredCriteria;

    public TSqrxxArg() {
        oredCriteria = new ArrayList<TSqrxxCriteria>();
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

    public List<TSqrxxCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(TSqrxxCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public TSqrxxCriteria or() {
    	TSqrxxCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public TSqrxxCriteria createCriteria() {
    	TSqrxxCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected TSqrxxCriteria createCriteriaInternal() {
    	TSqrxxCriteria criteria = new TSqrxxCriteria();
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
        protected List<TSqrxxCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<TSqrxxCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<TSqrxxCriterion> getAllCriteria() {
            return criteria;
        }

        public List<TSqrxxCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new TSqrxxCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new TSqrxxCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new TSqrxxCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new TSqrxxCriterion(condition, value1, value2));
        }

        public TSqrxxCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (TSqrxxCriteria) this;
        }
        public TSqrxxCriteria andIdIsNull() {
            addCriterion("ID is null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "ID");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "ID");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "ID");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "ID");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdLessThan(String value) {
            addCriterion("ID <", value, "ID");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "ID");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdLike(String value) {
            addCriterion("ID like ", value, "ID", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdNotLike(String value) {
            addCriterion("ID  not like ", value, "ID", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdLeftLike(String value) {
            addCriterion("ID like ", value, "ID", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdNotLeftLike(String value) {
            addCriterion("ID  not like ", value, "ID", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdRightLike(String value) {
            addCriterion("ID like ", value, "ID", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdNotRightLike(String value) {
            addCriterion("ID  not like ", value, "ID", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdIn(List<String> values) {
            addCriterion("ID  in ", values, "ID");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdNotIn(List<String> values) {
            addCriterion("ID not in ", values, "ID");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdBetween(String value1, String value2) {
            addCriterion("ID between ", value1, value2, "ID");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between ", value1, value2, "ID");
            return (TSqrxxCriteria) this;
        }
        public TSqrxxCriteria andZjhIsNull() {
            addCriterion("ZJH is null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhIsNotNull() {
            addCriterion("ZJH is not null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhEqualTo(String value) {
            addCriterion("ZJH =", value, "ZJH");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhNotEqualTo(String value) {
            addCriterion("ZJH <>", value, "ZJH");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhGreaterThan(String value) {
            addCriterion("ZJH >", value, "ZJH");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhGreaterThanOrEqualTo(String value) {
            addCriterion("ZJH >=", value, "ZJH");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhLessThan(String value) {
            addCriterion("ZJH <", value, "ZJH");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhLessThanOrEqualTo(String value) {
            addCriterion("ZJH <=", value, "ZJH");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhLike(String value) {
            addCriterion("ZJH like ", value, "ZJH", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhNotLike(String value) {
            addCriterion("ZJH  not like ", value, "ZJH", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhLeftLike(String value) {
            addCriterion("ZJH like ", value, "ZJH", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhNotLeftLike(String value) {
            addCriterion("ZJH  not like ", value, "ZJH", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhRightLike(String value) {
            addCriterion("ZJH like ", value, "ZJH", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhNotRightLike(String value) {
            addCriterion("ZJH  not like ", value, "ZJH", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhIn(List<String> values) {
            addCriterion("ZJH  in ", values, "ZJH");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhNotIn(List<String> values) {
            addCriterion("ZJH not in ", values, "ZJH");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhBetween(String value1, String value2) {
            addCriterion("ZJH between ", value1, value2, "ZJH");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjhNotBetween(String value1, String value2) {
            addCriterion("ZJH not between ", value1, value2, "ZJH");
            return (TSqrxxCriteria) this;
        }
        public TSqrxxCriteria andZjlxIsNull() {
            addCriterion("ZJLX is null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxIsNotNull() {
            addCriterion("ZJLX is not null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxEqualTo(String value) {
            addCriterion("ZJLX =", value, "ZJLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxNotEqualTo(String value) {
            addCriterion("ZJLX <>", value, "ZJLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxGreaterThan(String value) {
            addCriterion("ZJLX >", value, "ZJLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxGreaterThanOrEqualTo(String value) {
            addCriterion("ZJLX >=", value, "ZJLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxLessThan(String value) {
            addCriterion("ZJLX <", value, "ZJLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxLessThanOrEqualTo(String value) {
            addCriterion("ZJLX <=", value, "ZJLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxLike(String value) {
            addCriterion("ZJLX like ", value, "ZJLX", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxNotLike(String value) {
            addCriterion("ZJLX  not like ", value, "ZJLX", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxLeftLike(String value) {
            addCriterion("ZJLX like ", value, "ZJLX", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxNotLeftLike(String value) {
            addCriterion("ZJLX  not like ", value, "ZJLX", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxRightLike(String value) {
            addCriterion("ZJLX like ", value, "ZJLX", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxNotRightLike(String value) {
            addCriterion("ZJLX  not like ", value, "ZJLX", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxIn(List<String> values) {
            addCriterion("ZJLX  in ", values, "ZJLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxNotIn(List<String> values) {
            addCriterion("ZJLX not in ", values, "ZJLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxBetween(String value1, String value2) {
            addCriterion("ZJLX between ", value1, value2, "ZJLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andZjlxNotBetween(String value1, String value2) {
            addCriterion("ZJLX not between ", value1, value2, "ZJLX");
            return (TSqrxxCriteria) this;
        }
        public TSqrxxCriteria andXmIsNull() {
            addCriterion("XM is null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmIsNotNull() {
            addCriterion("XM is not null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmEqualTo(String value) {
            addCriterion("XM =", value, "XM");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmNotEqualTo(String value) {
            addCriterion("XM <>", value, "XM");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmGreaterThan(String value) {
            addCriterion("XM >", value, "XM");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmGreaterThanOrEqualTo(String value) {
            addCriterion("XM >=", value, "XM");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmLessThan(String value) {
            addCriterion("XM <", value, "XM");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmLessThanOrEqualTo(String value) {
            addCriterion("XM <=", value, "XM");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmLike(String value) {
            addCriterion("XM like ", value, "XM", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmNotLike(String value) {
            addCriterion("XM  not like ", value, "XM", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmLeftLike(String value) {
            addCriterion("XM like ", value, "XM", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmNotLeftLike(String value) {
            addCriterion("XM  not like ", value, "XM", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmRightLike(String value) {
            addCriterion("XM like ", value, "XM", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmNotRightLike(String value) {
            addCriterion("XM  not like ", value, "XM", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmIn(List<String> values) {
            addCriterion("XM  in ", values, "XM");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmNotIn(List<String> values) {
            addCriterion("XM not in ", values, "XM");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmBetween(String value1, String value2) {
            addCriterion("XM between ", value1, value2, "XM");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andXmNotBetween(String value1, String value2) {
            addCriterion("XM not between ", value1, value2, "XM");
            return (TSqrxxCriteria) this;
        }
        public TSqrxxCriteria andCxsqrlxIsNull() {
            addCriterion("CXSQRLX is null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxIsNotNull() {
            addCriterion("CXSQRLX is not null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxEqualTo(String value) {
            addCriterion("CXSQRLX =", value, "CXSQRLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxNotEqualTo(String value) {
            addCriterion("CXSQRLX <>", value, "CXSQRLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxGreaterThan(String value) {
            addCriterion("CXSQRLX >", value, "CXSQRLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxGreaterThanOrEqualTo(String value) {
            addCriterion("CXSQRLX >=", value, "CXSQRLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxLessThan(String value) {
            addCriterion("CXSQRLX <", value, "CXSQRLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxLessThanOrEqualTo(String value) {
            addCriterion("CXSQRLX <=", value, "CXSQRLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxLike(String value) {
            addCriterion("CXSQRLX like ", value, "CXSQRLX", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxNotLike(String value) {
            addCriterion("CXSQRLX  not like ", value, "CXSQRLX", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxLeftLike(String value) {
            addCriterion("CXSQRLX like ", value, "CXSQRLX", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxNotLeftLike(String value) {
            addCriterion("CXSQRLX  not like ", value, "CXSQRLX", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxRightLike(String value) {
            addCriterion("CXSQRLX like ", value, "CXSQRLX", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxNotRightLike(String value) {
            addCriterion("CXSQRLX  not like ", value, "CXSQRLX", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxIn(List<String> values) {
            addCriterion("CXSQRLX  in ", values, "CXSQRLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxNotIn(List<String> values) {
            addCriterion("CXSQRLX not in ", values, "CXSQRLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxBetween(String value1, String value2) {
            addCriterion("CXSQRLX between ", value1, value2, "CXSQRLX");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsqrlxNotBetween(String value1, String value2) {
            addCriterion("CXSQRLX not between ", value1, value2, "CXSQRLX");
            return (TSqrxxCriteria) this;
        }
        public TSqrxxCriteria andCxrdwIsNull() {
            addCriterion("CXRDW is null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwIsNotNull() {
            addCriterion("CXRDW is not null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwEqualTo(String value) {
            addCriterion("CXRDW =", value, "CXRDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwNotEqualTo(String value) {
            addCriterion("CXRDW <>", value, "CXRDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwGreaterThan(String value) {
            addCriterion("CXRDW >", value, "CXRDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwGreaterThanOrEqualTo(String value) {
            addCriterion("CXRDW >=", value, "CXRDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwLessThan(String value) {
            addCriterion("CXRDW <", value, "CXRDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwLessThanOrEqualTo(String value) {
            addCriterion("CXRDW <=", value, "CXRDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwLike(String value) {
            addCriterion("CXRDW like ", value, "CXRDW", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwNotLike(String value) {
            addCriterion("CXRDW  not like ", value, "CXRDW", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwLeftLike(String value) {
            addCriterion("CXRDW like ", value, "CXRDW", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwNotLeftLike(String value) {
            addCriterion("CXRDW  not like ", value, "CXRDW", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwRightLike(String value) {
            addCriterion("CXRDW like ", value, "CXRDW", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwNotRightLike(String value) {
            addCriterion("CXRDW  not like ", value, "CXRDW", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwIn(List<String> values) {
            addCriterion("CXRDW  in ", values, "CXRDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwNotIn(List<String> values) {
            addCriterion("CXRDW not in ", values, "CXRDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwBetween(String value1, String value2) {
            addCriterion("CXRDW between ", value1, value2, "CXRDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrdwNotBetween(String value1, String value2) {
            addCriterion("CXRDW not between ", value1, value2, "CXRDW");
            return (TSqrxxCriteria) this;
        }
        public TSqrxxCriteria andCxsyIsNull() {
            addCriterion("CXSY is null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyIsNotNull() {
            addCriterion("CXSY is not null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyEqualTo(String value) {
            addCriterion("CXSY =", value, "CXSY");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyNotEqualTo(String value) {
            addCriterion("CXSY <>", value, "CXSY");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyGreaterThan(String value) {
            addCriterion("CXSY >", value, "CXSY");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyGreaterThanOrEqualTo(String value) {
            addCriterion("CXSY >=", value, "CXSY");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyLessThan(String value) {
            addCriterion("CXSY <", value, "CXSY");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyLessThanOrEqualTo(String value) {
            addCriterion("CXSY <=", value, "CXSY");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyLike(String value) {
            addCriterion("CXSY like ", value, "CXSY", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyNotLike(String value) {
            addCriterion("CXSY  not like ", value, "CXSY", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyLeftLike(String value) {
            addCriterion("CXSY like ", value, "CXSY", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyNotLeftLike(String value) {
            addCriterion("CXSY  not like ", value, "CXSY", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyRightLike(String value) {
            addCriterion("CXSY like ", value, "CXSY", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyNotRightLike(String value) {
            addCriterion("CXSY  not like ", value, "CXSY", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyIn(List<String> values) {
            addCriterion("CXSY  in ", values, "CXSY");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyNotIn(List<String> values) {
            addCriterion("CXSY not in ", values, "CXSY");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyBetween(String value1, String value2) {
            addCriterion("CXSY between ", value1, value2, "CXSY");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxsyNotBetween(String value1, String value2) {
            addCriterion("CXSY not between ", value1, value2, "CXSY");
            return (TSqrxxCriteria) this;
        }
        public TSqrxxCriteria andCxrqIsNull() {
            addCriterion("CXRQ is null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqIsNotNull() {
            addCriterion("CXRQ is not null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqEqualTo(String value) {
            addCriterion("CXRQ =", value, "CXRQ");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqNotEqualTo(String value) {
            addCriterion("CXRQ <>", value, "CXRQ");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqGreaterThan(String value) {
            addCriterion("CXRQ >", value, "CXRQ");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqGreaterThanOrEqualTo(String value) {
            addCriterion("CXRQ >=", value, "CXRQ");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqLessThan(String value) {
            addCriterion("CXRQ <", value, "CXRQ");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqLessThanOrEqualTo(String value) {
            addCriterion("CXRQ <=", value, "CXRQ");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqLike(String value) {
            addCriterion("CXRQ like ", value, "CXRQ", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqNotLike(String value) {
            addCriterion("CXRQ  not like ", value, "CXRQ", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqLeftLike(String value) {
            addCriterion("CXRQ like ", value, "CXRQ", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqNotLeftLike(String value) {
            addCriterion("CXRQ  not like ", value, "CXRQ", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqRightLike(String value) {
            addCriterion("CXRQ like ", value, "CXRQ", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqNotRightLike(String value) {
            addCriterion("CXRQ  not like ", value, "CXRQ", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqIn(List<String> values) {
            addCriterion("CXRQ  in ", values, "CXRQ");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqNotIn(List<String> values) {
            addCriterion("CXRQ not in ", values, "CXRQ");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqBetween(String value1, String value2) {
            addCriterion("CXRQ between ", value1, value2, "CXRQ");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxrqNotBetween(String value1, String value2) {
            addCriterion("CXRQ not between ", value1, value2, "CXRQ");
            return (TSqrxxCriteria) this;
        }
        public TSqrxxCriteria andCzdwIsNull() {
            addCriterion("CZDW is null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwIsNotNull() {
            addCriterion("CZDW is not null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwEqualTo(String value) {
            addCriterion("CZDW =", value, "CZDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwNotEqualTo(String value) {
            addCriterion("CZDW <>", value, "CZDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwGreaterThan(String value) {
            addCriterion("CZDW >", value, "CZDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwGreaterThanOrEqualTo(String value) {
            addCriterion("CZDW >=", value, "CZDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwLessThan(String value) {
            addCriterion("CZDW <", value, "CZDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwLessThanOrEqualTo(String value) {
            addCriterion("CZDW <=", value, "CZDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwLike(String value) {
            addCriterion("CZDW like ", value, "CZDW", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwNotLike(String value) {
            addCriterion("CZDW  not like ", value, "CZDW", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwLeftLike(String value) {
            addCriterion("CZDW like ", value, "CZDW", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwNotLeftLike(String value) {
            addCriterion("CZDW  not like ", value, "CZDW", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwRightLike(String value) {
            addCriterion("CZDW like ", value, "CZDW", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwNotRightLike(String value) {
            addCriterion("CZDW  not like ", value, "CZDW", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwIn(List<String> values) {
            addCriterion("CZDW  in ", values, "CZDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwNotIn(List<String> values) {
            addCriterion("CZDW not in ", values, "CZDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwBetween(String value1, String value2) {
            addCriterion("CZDW between ", value1, value2, "CZDW");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzdwNotBetween(String value1, String value2) {
            addCriterion("CZDW not between ", value1, value2, "CZDW");
            return (TSqrxxCriteria) this;
        }
        public TSqrxxCriteria andCzrIsNull() {
            addCriterion("CZR is null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrIsNotNull() {
            addCriterion("CZR is not null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrEqualTo(String value) {
            addCriterion("CZR =", value, "CZR");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrNotEqualTo(String value) {
            addCriterion("CZR <>", value, "CZR");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrGreaterThan(String value) {
            addCriterion("CZR >", value, "CZR");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrGreaterThanOrEqualTo(String value) {
            addCriterion("CZR >=", value, "CZR");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrLessThan(String value) {
            addCriterion("CZR <", value, "CZR");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrLessThanOrEqualTo(String value) {
            addCriterion("CZR <=", value, "CZR");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrLike(String value) {
            addCriterion("CZR like ", value, "CZR", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrNotLike(String value) {
            addCriterion("CZR  not like ", value, "CZR", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrLeftLike(String value) {
            addCriterion("CZR like ", value, "CZR", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrNotLeftLike(String value) {
            addCriterion("CZR  not like ", value, "CZR", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrRightLike(String value) {
            addCriterion("CZR like ", value, "CZR", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrNotRightLike(String value) {
            addCriterion("CZR  not like ", value, "CZR", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrIn(List<String> values) {
            addCriterion("CZR  in ", values, "CZR");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrNotIn(List<String> values) {
            addCriterion("CZR not in ", values, "CZR");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrBetween(String value1, String value2) {
            addCriterion("CZR between ", value1, value2, "CZR");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCzrNotBetween(String value1, String value2) {
            addCriterion("CZR not between ", value1, value2, "CZR");
            return (TSqrxxCriteria) this;
        }
        public TSqrxxCriteria andCxbsIsNull() {
            addCriterion("CXBS is null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsIsNotNull() {
            addCriterion("CXBS is not null");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsEqualTo(String value) {
            addCriterion("CXBS =", value, "CXBS");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsNotEqualTo(String value) {
            addCriterion("CXBS <>", value, "CXBS");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsGreaterThan(String value) {
            addCriterion("CXBS >", value, "CXBS");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsGreaterThanOrEqualTo(String value) {
            addCriterion("CXBS >=", value, "CXBS");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsLessThan(String value) {
            addCriterion("CXBS <", value, "CXBS");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsLessThanOrEqualTo(String value) {
            addCriterion("CXBS <=", value, "CXBS");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsLike(String value) {
            addCriterion("CXBS like ", value, "CXBS", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsNotLike(String value) {
            addCriterion("CXBS  not like ", value, "CXBS", 1);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsLeftLike(String value) {
            addCriterion("CXBS like ", value, "CXBS", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsNotLeftLike(String value) {
            addCriterion("CXBS  not like ", value, "CXBS", 0);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsRightLike(String value) {
            addCriterion("CXBS like ", value, "CXBS", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsNotRightLike(String value) {
            addCriterion("CXBS  not like ", value, "CXBS", 2);
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsIn(List<String> values) {
            addCriterion("CXBS  in ", values, "CXBS");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsNotIn(List<String> values) {
            addCriterion("CXBS not in ", values, "CXBS");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsBetween(String value1, String value2) {
            addCriterion("CXBS between ", value1, value2, "CXBS");
            return (TSqrxxCriteria) this;
        }

        public TSqrxxCriteria andCxbsNotBetween(String value1, String value2) {
            addCriterion("CXBS not between ", value1, value2, "CXBS");
            return (TSqrxxCriteria) this;
        }

    }

    public static class TSqrxxCriteria extends GeneratedCriteria {

        protected TSqrxxCriteria() {
            super();
        }
    }

    public static class TSqrxxCriterion {
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

        protected TSqrxxCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected TSqrxxCriterion(String condition, Object value, int likeType) {
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

        protected TSqrxxCriterion(String condition, Object value,
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

        protected TSqrxxCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected TSqrxxCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected TSqrxxCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}