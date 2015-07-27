package com.ztesoft.web.permission.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class AuditMenuArg {
    private String pk_name = "MENU_ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<AuditMenuCriteria> oredCriteria;

    public AuditMenuArg() {
        oredCriteria = new ArrayList<AuditMenuCriteria>();
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

    public List<AuditMenuCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(AuditMenuCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public AuditMenuCriteria or() {
    	AuditMenuCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AuditMenuCriteria createCriteria() {
    	AuditMenuCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AuditMenuCriteria createCriteriaInternal() {
    	AuditMenuCriteria criteria = new AuditMenuCriteria();
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
        protected List<AuditMenuCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<AuditMenuCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<AuditMenuCriterion> getAllCriteria() {
            return criteria;
        }

        public List<AuditMenuCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new AuditMenuCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditMenuCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditMenuCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditMenuCriterion(condition, value1, value2));
        }

        public AuditMenuCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (AuditMenuCriteria) this;
        }
        public AuditMenuCriteria andMenuIdIsNull() {
            addCriterion("MENU_ID is null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdIsNotNull() {
            addCriterion("MENU_ID is not null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdEqualTo(Integer value) {
            addCriterion("MENU_ID =", value, "MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("MENU_ID <>", value, "MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdGreaterThan(Integer value) {
            addCriterion("MENU_ID >", value, "MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MENU_ID >=", value, "MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdLessThan(Integer value) {
            addCriterion("MENU_ID <", value, "MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("MENU_ID <=", value, "MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdLike(Integer value) {
            addCriterion("MENU_ID like ", value, "MENU_ID", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdNotLike(Integer value) {
            addCriterion("MENU_ID  not like ", value, "MENU_ID", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdLeftLike(Integer value) {
            addCriterion("MENU_ID like ", value, "MENU_ID", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdNotLeftLike(Integer value) {
            addCriterion("MENU_ID  not like ", value, "MENU_ID", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdRightLike(Integer value) {
            addCriterion("MENU_ID like ", value, "MENU_ID", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdNotRightLike(Integer value) {
            addCriterion("MENU_ID  not like ", value, "MENU_ID", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdIn(List<Integer> values) {
            addCriterion("MENU_ID  in ", values, "MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("MENU_ID not in ", values, "MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("MENU_ID between ", value1, value2, "MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MENU_ID not between ", value1, value2, "MENU_ID");
            return (AuditMenuCriteria) this;
        }
        public AuditMenuCriteria andMenuTitleIsNull() {
            addCriterion("MENU_TITLE is null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleIsNotNull() {
            addCriterion("MENU_TITLE is not null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleEqualTo(String value) {
            addCriterion("MENU_TITLE =", value, "MENU_TITLE");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleNotEqualTo(String value) {
            addCriterion("MENU_TITLE <>", value, "MENU_TITLE");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleGreaterThan(String value) {
            addCriterion("MENU_TITLE >", value, "MENU_TITLE");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_TITLE >=", value, "MENU_TITLE");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleLessThan(String value) {
            addCriterion("MENU_TITLE <", value, "MENU_TITLE");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleLessThanOrEqualTo(String value) {
            addCriterion("MENU_TITLE <=", value, "MENU_TITLE");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleLike(String value) {
            addCriterion("MENU_TITLE like ", value, "MENU_TITLE", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleNotLike(String value) {
            addCriterion("MENU_TITLE  not like ", value, "MENU_TITLE", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleLeftLike(String value) {
            addCriterion("MENU_TITLE like ", value, "MENU_TITLE", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleNotLeftLike(String value) {
            addCriterion("MENU_TITLE  not like ", value, "MENU_TITLE", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleRightLike(String value) {
            addCriterion("MENU_TITLE like ", value, "MENU_TITLE", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleNotRightLike(String value) {
            addCriterion("MENU_TITLE  not like ", value, "MENU_TITLE", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleIn(List<String> values) {
            addCriterion("MENU_TITLE  in ", values, "MENU_TITLE");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleNotIn(List<String> values) {
            addCriterion("MENU_TITLE not in ", values, "MENU_TITLE");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleBetween(String value1, String value2) {
            addCriterion("MENU_TITLE between ", value1, value2, "MENU_TITLE");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuTitleNotBetween(String value1, String value2) {
            addCriterion("MENU_TITLE not between ", value1, value2, "MENU_TITLE");
            return (AuditMenuCriteria) this;
        }
        public AuditMenuCriteria andMenuIconPathIsNull() {
            addCriterion("MENU_ICON_PATH is null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathIsNotNull() {
            addCriterion("MENU_ICON_PATH is not null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathEqualTo(String value) {
            addCriterion("MENU_ICON_PATH =", value, "MENU_ICON_PATH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathNotEqualTo(String value) {
            addCriterion("MENU_ICON_PATH <>", value, "MENU_ICON_PATH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathGreaterThan(String value) {
            addCriterion("MENU_ICON_PATH >", value, "MENU_ICON_PATH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_ICON_PATH >=", value, "MENU_ICON_PATH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathLessThan(String value) {
            addCriterion("MENU_ICON_PATH <", value, "MENU_ICON_PATH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathLessThanOrEqualTo(String value) {
            addCriterion("MENU_ICON_PATH <=", value, "MENU_ICON_PATH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathLike(String value) {
            addCriterion("MENU_ICON_PATH like ", value, "MENU_ICON_PATH", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathNotLike(String value) {
            addCriterion("MENU_ICON_PATH  not like ", value, "MENU_ICON_PATH", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathLeftLike(String value) {
            addCriterion("MENU_ICON_PATH like ", value, "MENU_ICON_PATH", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathNotLeftLike(String value) {
            addCriterion("MENU_ICON_PATH  not like ", value, "MENU_ICON_PATH", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathRightLike(String value) {
            addCriterion("MENU_ICON_PATH like ", value, "MENU_ICON_PATH", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathNotRightLike(String value) {
            addCriterion("MENU_ICON_PATH  not like ", value, "MENU_ICON_PATH", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathIn(List<String> values) {
            addCriterion("MENU_ICON_PATH  in ", values, "MENU_ICON_PATH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathNotIn(List<String> values) {
            addCriterion("MENU_ICON_PATH not in ", values, "MENU_ICON_PATH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathBetween(String value1, String value2) {
            addCriterion("MENU_ICON_PATH between ", value1, value2, "MENU_ICON_PATH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andMenuIconPathNotBetween(String value1, String value2) {
            addCriterion("MENU_ICON_PATH not between ", value1, value2, "MENU_ICON_PATH");
            return (AuditMenuCriteria) this;
        }
        public AuditMenuCriteria andUrlStringIsNull() {
            addCriterion("URL_STRING is null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringIsNotNull() {
            addCriterion("URL_STRING is not null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringEqualTo(String value) {
            addCriterion("URL_STRING =", value, "URL_STRING");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringNotEqualTo(String value) {
            addCriterion("URL_STRING <>", value, "URL_STRING");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringGreaterThan(String value) {
            addCriterion("URL_STRING >", value, "URL_STRING");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringGreaterThanOrEqualTo(String value) {
            addCriterion("URL_STRING >=", value, "URL_STRING");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringLessThan(String value) {
            addCriterion("URL_STRING <", value, "URL_STRING");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringLessThanOrEqualTo(String value) {
            addCriterion("URL_STRING <=", value, "URL_STRING");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringLike(String value) {
            addCriterion("URL_STRING like ", value, "URL_STRING", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringNotLike(String value) {
            addCriterion("URL_STRING  not like ", value, "URL_STRING", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringLeftLike(String value) {
            addCriterion("URL_STRING like ", value, "URL_STRING", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringNotLeftLike(String value) {
            addCriterion("URL_STRING  not like ", value, "URL_STRING", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringRightLike(String value) {
            addCriterion("URL_STRING like ", value, "URL_STRING", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringNotRightLike(String value) {
            addCriterion("URL_STRING  not like ", value, "URL_STRING", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringIn(List<String> values) {
            addCriterion("URL_STRING  in ", values, "URL_STRING");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringNotIn(List<String> values) {
            addCriterion("URL_STRING not in ", values, "URL_STRING");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringBetween(String value1, String value2) {
            addCriterion("URL_STRING between ", value1, value2, "URL_STRING");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andUrlStringNotBetween(String value1, String value2) {
            addCriterion("URL_STRING not between ", value1, value2, "URL_STRING");
            return (AuditMenuCriteria) this;
        }
        public AuditMenuCriteria andDisplayIndexIsNull() {
            addCriterion("DISPLAY_INDEX is null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexIsNotNull() {
            addCriterion("DISPLAY_INDEX is not null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexEqualTo(Integer value) {
            addCriterion("DISPLAY_INDEX =", value, "DISPLAY_INDEX");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexNotEqualTo(Integer value) {
            addCriterion("DISPLAY_INDEX <>", value, "DISPLAY_INDEX");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexGreaterThan(Integer value) {
            addCriterion("DISPLAY_INDEX >", value, "DISPLAY_INDEX");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("DISPLAY_INDEX >=", value, "DISPLAY_INDEX");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexLessThan(Integer value) {
            addCriterion("DISPLAY_INDEX <", value, "DISPLAY_INDEX");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexLessThanOrEqualTo(Integer value) {
            addCriterion("DISPLAY_INDEX <=", value, "DISPLAY_INDEX");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexLike(Integer value) {
            addCriterion("DISPLAY_INDEX like ", value, "DISPLAY_INDEX", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexNotLike(Integer value) {
            addCriterion("DISPLAY_INDEX  not like ", value, "DISPLAY_INDEX", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexLeftLike(Integer value) {
            addCriterion("DISPLAY_INDEX like ", value, "DISPLAY_INDEX", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexNotLeftLike(Integer value) {
            addCriterion("DISPLAY_INDEX  not like ", value, "DISPLAY_INDEX", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexRightLike(Integer value) {
            addCriterion("DISPLAY_INDEX like ", value, "DISPLAY_INDEX", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexNotRightLike(Integer value) {
            addCriterion("DISPLAY_INDEX  not like ", value, "DISPLAY_INDEX", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexIn(List<Integer> values) {
            addCriterion("DISPLAY_INDEX  in ", values, "DISPLAY_INDEX");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexNotIn(List<Integer> values) {
            addCriterion("DISPLAY_INDEX not in ", values, "DISPLAY_INDEX");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexBetween(Integer value1, Integer value2) {
            addCriterion("DISPLAY_INDEX between ", value1, value2, "DISPLAY_INDEX");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andDisplayIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("DISPLAY_INDEX not between ", value1, value2, "DISPLAY_INDEX");
            return (AuditMenuCriteria) this;
        }
        public AuditMenuCriteria andHeightIsNull() {
            addCriterion("HEIGHT is null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightIsNotNull() {
            addCriterion("HEIGHT is not null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightEqualTo(BigDecimal value) {
            addCriterion("HEIGHT =", value, "HEIGHT");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightNotEqualTo(BigDecimal value) {
            addCriterion("HEIGHT <>", value, "HEIGHT");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightGreaterThan(BigDecimal value) {
            addCriterion("HEIGHT >", value, "HEIGHT");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HEIGHT >=", value, "HEIGHT");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightLessThan(BigDecimal value) {
            addCriterion("HEIGHT <", value, "HEIGHT");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HEIGHT <=", value, "HEIGHT");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightLike(BigDecimal value) {
            addCriterion("HEIGHT like ", value, "HEIGHT", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightNotLike(BigDecimal value) {
            addCriterion("HEIGHT  not like ", value, "HEIGHT", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightLeftLike(BigDecimal value) {
            addCriterion("HEIGHT like ", value, "HEIGHT", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightNotLeftLike(BigDecimal value) {
            addCriterion("HEIGHT  not like ", value, "HEIGHT", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightRightLike(BigDecimal value) {
            addCriterion("HEIGHT like ", value, "HEIGHT", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightNotRightLike(BigDecimal value) {
            addCriterion("HEIGHT  not like ", value, "HEIGHT", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightIn(List<BigDecimal> values) {
            addCriterion("HEIGHT  in ", values, "HEIGHT");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightNotIn(List<BigDecimal> values) {
            addCriterion("HEIGHT not in ", values, "HEIGHT");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HEIGHT between ", value1, value2, "HEIGHT");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andHeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HEIGHT not between ", value1, value2, "HEIGHT");
            return (AuditMenuCriteria) this;
        }
        public AuditMenuCriteria andWidthIsNull() {
            addCriterion("WIDTH is null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthIsNotNull() {
            addCriterion("WIDTH is not null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthEqualTo(BigDecimal value) {
            addCriterion("WIDTH =", value, "WIDTH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthNotEqualTo(BigDecimal value) {
            addCriterion("WIDTH <>", value, "WIDTH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthGreaterThan(BigDecimal value) {
            addCriterion("WIDTH >", value, "WIDTH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WIDTH >=", value, "WIDTH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthLessThan(BigDecimal value) {
            addCriterion("WIDTH <", value, "WIDTH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WIDTH <=", value, "WIDTH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthLike(BigDecimal value) {
            addCriterion("WIDTH like ", value, "WIDTH", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthNotLike(BigDecimal value) {
            addCriterion("WIDTH  not like ", value, "WIDTH", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthLeftLike(BigDecimal value) {
            addCriterion("WIDTH like ", value, "WIDTH", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthNotLeftLike(BigDecimal value) {
            addCriterion("WIDTH  not like ", value, "WIDTH", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthRightLike(BigDecimal value) {
            addCriterion("WIDTH like ", value, "WIDTH", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthNotRightLike(BigDecimal value) {
            addCriterion("WIDTH  not like ", value, "WIDTH", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthIn(List<BigDecimal> values) {
            addCriterion("WIDTH  in ", values, "WIDTH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthNotIn(List<BigDecimal> values) {
            addCriterion("WIDTH not in ", values, "WIDTH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WIDTH between ", value1, value2, "WIDTH");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andWidthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WIDTH not between ", value1, value2, "WIDTH");
            return (AuditMenuCriteria) this;
        }
        public AuditMenuCriteria andParentMenuIdIsNull() {
            addCriterion("PARENT_MENU_ID is null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdIsNotNull() {
            addCriterion("PARENT_MENU_ID is not null");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdEqualTo(Integer value) {
            addCriterion("PARENT_MENU_ID =", value, "PARENT_MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdNotEqualTo(Integer value) {
            addCriterion("PARENT_MENU_ID <>", value, "PARENT_MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdGreaterThan(Integer value) {
            addCriterion("PARENT_MENU_ID >", value, "PARENT_MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARENT_MENU_ID >=", value, "PARENT_MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdLessThan(Integer value) {
            addCriterion("PARENT_MENU_ID <", value, "PARENT_MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("PARENT_MENU_ID <=", value, "PARENT_MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdLike(Integer value) {
            addCriterion("PARENT_MENU_ID like ", value, "PARENT_MENU_ID", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdNotLike(Integer value) {
            addCriterion("PARENT_MENU_ID  not like ", value, "PARENT_MENU_ID", 1);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdLeftLike(Integer value) {
            addCriterion("PARENT_MENU_ID like ", value, "PARENT_MENU_ID", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdNotLeftLike(Integer value) {
            addCriterion("PARENT_MENU_ID  not like ", value, "PARENT_MENU_ID", 0);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdRightLike(Integer value) {
            addCriterion("PARENT_MENU_ID like ", value, "PARENT_MENU_ID", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdNotRightLike(Integer value) {
            addCriterion("PARENT_MENU_ID  not like ", value, "PARENT_MENU_ID", 2);
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdIn(List<Integer> values) {
            addCriterion("PARENT_MENU_ID  in ", values, "PARENT_MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdNotIn(List<Integer> values) {
            addCriterion("PARENT_MENU_ID not in ", values, "PARENT_MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_MENU_ID between ", value1, value2, "PARENT_MENU_ID");
            return (AuditMenuCriteria) this;
        }

        public AuditMenuCriteria andParentMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_MENU_ID not between ", value1, value2, "PARENT_MENU_ID");
            return (AuditMenuCriteria) this;
        }

    }

    public static class AuditMenuCriteria extends GeneratedCriteria {

        protected AuditMenuCriteria() {
            super();
        }
    }

    public static class AuditMenuCriterion {
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

        protected AuditMenuCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected AuditMenuCriterion(String condition, Object value, int likeType) {
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

        protected AuditMenuCriterion(String condition, Object value,
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

        protected AuditMenuCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected AuditMenuCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected AuditMenuCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}