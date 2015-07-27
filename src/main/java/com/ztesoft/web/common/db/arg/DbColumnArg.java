package com.ztesoft.web.common.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class DbColumnArg {
    private String pk_name = "id";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<DbColumnCriteria> oredCriteria;

    public DbColumnArg() {
        oredCriteria = new ArrayList<DbColumnCriteria>();
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

    public List<DbColumnCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(DbColumnCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public DbColumnCriteria or() {
    	DbColumnCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public DbColumnCriteria createCriteria() {
    	DbColumnCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected DbColumnCriteria createCriteriaInternal() {
    	DbColumnCriteria criteria = new DbColumnCriteria();
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
        protected List<DbColumnCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<DbColumnCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<DbColumnCriterion> getAllCriteria() {
            return criteria;
        }

        public List<DbColumnCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new DbColumnCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new DbColumnCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new DbColumnCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new DbColumnCriterion(condition, value1, value2));
        }

        public DbColumnCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (DbColumnCriteria) this;
        }
        public DbColumnCriteria andIdIsNull() {
            addCriterion("id is null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdLike(Integer value) {
            addCriterion("id like ", value, "id", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdNotLike(Integer value) {
            addCriterion("id  not like ", value, "id", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdLeftLike(Integer value) {
            addCriterion("id like ", value, "id", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdNotLeftLike(Integer value) {
            addCriterion("id  not like ", value, "id", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdRightLike(Integer value) {
            addCriterion("id like ", value, "id", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdNotRightLike(Integer value) {
            addCriterion("id  not like ", value, "id", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdIn(List<Integer> values) {
            addCriterion("id  in ", values, "id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in ", values, "id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between ", value1, value2, "id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between ", value1, value2, "id");
            return (DbColumnCriteria) this;
        }
        public DbColumnCriteria andTableIdIsNull() {
            addCriterion("table_id is null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdIsNotNull() {
            addCriterion("table_id is not null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdEqualTo(Integer value) {
            addCriterion("table_id =", value, "table_id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdNotEqualTo(Integer value) {
            addCriterion("table_id <>", value, "table_id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdGreaterThan(Integer value) {
            addCriterion("table_id >", value, "table_id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("table_id >=", value, "table_id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdLessThan(Integer value) {
            addCriterion("table_id <", value, "table_id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdLessThanOrEqualTo(Integer value) {
            addCriterion("table_id <=", value, "table_id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdLike(Integer value) {
            addCriterion("table_id like ", value, "table_id", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdNotLike(Integer value) {
            addCriterion("table_id  not like ", value, "table_id", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdLeftLike(Integer value) {
            addCriterion("table_id like ", value, "table_id", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdNotLeftLike(Integer value) {
            addCriterion("table_id  not like ", value, "table_id", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdRightLike(Integer value) {
            addCriterion("table_id like ", value, "table_id", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdNotRightLike(Integer value) {
            addCriterion("table_id  not like ", value, "table_id", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdIn(List<Integer> values) {
            addCriterion("table_id  in ", values, "table_id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdNotIn(List<Integer> values) {
            addCriterion("table_id not in ", values, "table_id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdBetween(Integer value1, Integer value2) {
            addCriterion("table_id between ", value1, value2, "table_id");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("table_id not between ", value1, value2, "table_id");
            return (DbColumnCriteria) this;
        }
        public DbColumnCriteria andKeyTypeIsNull() {
            addCriterion("key_type is null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeIsNotNull() {
            addCriterion("key_type is not null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeEqualTo(String value) {
            addCriterion("key_type =", value, "key_type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeNotEqualTo(String value) {
            addCriterion("key_type <>", value, "key_type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeGreaterThan(String value) {
            addCriterion("key_type >", value, "key_type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("key_type >=", value, "key_type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeLessThan(String value) {
            addCriterion("key_type <", value, "key_type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeLessThanOrEqualTo(String value) {
            addCriterion("key_type <=", value, "key_type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeLike(String value) {
            addCriterion("key_type like ", value, "key_type", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeNotLike(String value) {
            addCriterion("key_type  not like ", value, "key_type", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeLeftLike(String value) {
            addCriterion("key_type like ", value, "key_type", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeNotLeftLike(String value) {
            addCriterion("key_type  not like ", value, "key_type", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeRightLike(String value) {
            addCriterion("key_type like ", value, "key_type", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeNotRightLike(String value) {
            addCriterion("key_type  not like ", value, "key_type", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeIn(List<String> values) {
            addCriterion("key_type  in ", values, "key_type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeNotIn(List<String> values) {
            addCriterion("key_type not in ", values, "key_type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeBetween(String value1, String value2) {
            addCriterion("key_type between ", value1, value2, "key_type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andKeyTypeNotBetween(String value1, String value2) {
            addCriterion("key_type not between ", value1, value2, "key_type");
            return (DbColumnCriteria) this;
        }
        public DbColumnCriteria andNameIsNull() {
            addCriterion("name is null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameLike(String value) {
            addCriterion("name like ", value, "name", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameNotLike(String value) {
            addCriterion("name  not like ", value, "name", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameLeftLike(String value) {
            addCriterion("name like ", value, "name", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameNotLeftLike(String value) {
            addCriterion("name  not like ", value, "name", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameRightLike(String value) {
            addCriterion("name like ", value, "name", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameNotRightLike(String value) {
            addCriterion("name  not like ", value, "name", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameIn(List<String> values) {
            addCriterion("name  in ", values, "name");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameNotIn(List<String> values) {
            addCriterion("name not in ", values, "name");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameBetween(String value1, String value2) {
            addCriterion("name between ", value1, value2, "name");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between ", value1, value2, "name");
            return (DbColumnCriteria) this;
        }
        public DbColumnCriteria andTypeIsNull() {
            addCriterion("type is null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeLike(String value) {
            addCriterion("type like ", value, "type", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeNotLike(String value) {
            addCriterion("type  not like ", value, "type", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeLeftLike(String value) {
            addCriterion("type like ", value, "type", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeNotLeftLike(String value) {
            addCriterion("type  not like ", value, "type", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeRightLike(String value) {
            addCriterion("type like ", value, "type", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeNotRightLike(String value) {
            addCriterion("type  not like ", value, "type", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeIn(List<String> values) {
            addCriterion("type  in ", values, "type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeNotIn(List<String> values) {
            addCriterion("type not in ", values, "type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeBetween(String value1, String value2) {
            addCriterion("type between ", value1, value2, "type");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between ", value1, value2, "type");
            return (DbColumnCriteria) this;
        }
        public DbColumnCriteria andSizeIsNull() {
            addCriterion("size is null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeEqualTo(Integer value) {
            addCriterion("size =", value, "size");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeNotEqualTo(Integer value) {
            addCriterion("size <>", value, "size");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeGreaterThan(Integer value) {
            addCriterion("size >", value, "size");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("size >=", value, "size");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeLessThan(Integer value) {
            addCriterion("size <", value, "size");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeLessThanOrEqualTo(Integer value) {
            addCriterion("size <=", value, "size");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeLike(Integer value) {
            addCriterion("size like ", value, "size", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeNotLike(Integer value) {
            addCriterion("size  not like ", value, "size", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeLeftLike(Integer value) {
            addCriterion("size like ", value, "size", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeNotLeftLike(Integer value) {
            addCriterion("size  not like ", value, "size", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeRightLike(Integer value) {
            addCriterion("size like ", value, "size", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeNotRightLike(Integer value) {
            addCriterion("size  not like ", value, "size", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeIn(List<Integer> values) {
            addCriterion("size  in ", values, "size");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeNotIn(List<Integer> values) {
            addCriterion("size not in ", values, "size");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeBetween(Integer value1, Integer value2) {
            addCriterion("size between ", value1, value2, "size");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("size not between ", value1, value2, "size");
            return (DbColumnCriteria) this;
        }
        public DbColumnCriteria andNullAbleIsNull() {
            addCriterion("null_able is null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleIsNotNull() {
            addCriterion("null_able is not null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleEqualTo(String value) {
            addCriterion("null_able =", value, "null_able");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleNotEqualTo(String value) {
            addCriterion("null_able <>", value, "null_able");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleGreaterThan(String value) {
            addCriterion("null_able >", value, "null_able");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleGreaterThanOrEqualTo(String value) {
            addCriterion("null_able >=", value, "null_able");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleLessThan(String value) {
            addCriterion("null_able <", value, "null_able");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleLessThanOrEqualTo(String value) {
            addCriterion("null_able <=", value, "null_able");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleLike(String value) {
            addCriterion("null_able like ", value, "null_able", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleNotLike(String value) {
            addCriterion("null_able  not like ", value, "null_able", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleLeftLike(String value) {
            addCriterion("null_able like ", value, "null_able", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleNotLeftLike(String value) {
            addCriterion("null_able  not like ", value, "null_able", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleRightLike(String value) {
            addCriterion("null_able like ", value, "null_able", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleNotRightLike(String value) {
            addCriterion("null_able  not like ", value, "null_able", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleIn(List<String> values) {
            addCriterion("null_able  in ", values, "null_able");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleNotIn(List<String> values) {
            addCriterion("null_able not in ", values, "null_able");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleBetween(String value1, String value2) {
            addCriterion("null_able between ", value1, value2, "null_able");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andNullAbleNotBetween(String value1, String value2) {
            addCriterion("null_able not between ", value1, value2, "null_able");
            return (DbColumnCriteria) this;
        }
        public DbColumnCriteria andDefaultValueIsNull() {
            addCriterion("default_value is null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueIsNotNull() {
            addCriterion("default_value is not null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueEqualTo(String value) {
            addCriterion("default_value =", value, "default_value");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueNotEqualTo(String value) {
            addCriterion("default_value <>", value, "default_value");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueGreaterThan(String value) {
            addCriterion("default_value >", value, "default_value");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueGreaterThanOrEqualTo(String value) {
            addCriterion("default_value >=", value, "default_value");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueLessThan(String value) {
            addCriterion("default_value <", value, "default_value");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueLessThanOrEqualTo(String value) {
            addCriterion("default_value <=", value, "default_value");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueLike(String value) {
            addCriterion("default_value like ", value, "default_value", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueNotLike(String value) {
            addCriterion("default_value  not like ", value, "default_value", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueLeftLike(String value) {
            addCriterion("default_value like ", value, "default_value", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueNotLeftLike(String value) {
            addCriterion("default_value  not like ", value, "default_value", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueRightLike(String value) {
            addCriterion("default_value like ", value, "default_value", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueNotRightLike(String value) {
            addCriterion("default_value  not like ", value, "default_value", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueIn(List<String> values) {
            addCriterion("default_value  in ", values, "default_value");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueNotIn(List<String> values) {
            addCriterion("default_value not in ", values, "default_value");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueBetween(String value1, String value2) {
            addCriterion("default_value between ", value1, value2, "default_value");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andDefaultValueNotBetween(String value1, String value2) {
            addCriterion("default_value not between ", value1, value2, "default_value");
            return (DbColumnCriteria) this;
        }
        public DbColumnCriteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksLike(String value) {
            addCriterion("remarks like ", value, "remarks", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksNotLike(String value) {
            addCriterion("remarks  not like ", value, "remarks", 1);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksLeftLike(String value) {
            addCriterion("remarks like ", value, "remarks", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksNotLeftLike(String value) {
            addCriterion("remarks  not like ", value, "remarks", 0);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksRightLike(String value) {
            addCriterion("remarks like ", value, "remarks", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksNotRightLike(String value) {
            addCriterion("remarks  not like ", value, "remarks", 2);
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksIn(List<String> values) {
            addCriterion("remarks  in ", values, "remarks");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in ", values, "remarks");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between ", value1, value2, "remarks");
            return (DbColumnCriteria) this;
        }

        public DbColumnCriteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between ", value1, value2, "remarks");
            return (DbColumnCriteria) this;
        }

    }

    public static class DbColumnCriteria extends GeneratedCriteria {

        protected DbColumnCriteria() {
            super();
        }
    }

    public static class DbColumnCriterion {
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

        protected DbColumnCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected DbColumnCriterion(String condition, Object value, int likeType) {
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

        protected DbColumnCriterion(String condition, Object value,
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

        protected DbColumnCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected DbColumnCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected DbColumnCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}