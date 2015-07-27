package com.ztesoft.web.cache.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class AmUserTmpArg {
    private String pk_name = "USER_ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<AmUserTmpCriteria> oredCriteria;

    public AmUserTmpArg() {
        oredCriteria = new ArrayList<AmUserTmpCriteria>();
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

    public List<AmUserTmpCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(AmUserTmpCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public AmUserTmpCriteria or() {
    	AmUserTmpCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AmUserTmpCriteria createCriteria() {
    	AmUserTmpCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AmUserTmpCriteria createCriteriaInternal() {
    	AmUserTmpCriteria criteria = new AmUserTmpCriteria();
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
        protected List<AmUserTmpCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<AmUserTmpCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<AmUserTmpCriterion> getAllCriteria() {
            return criteria;
        }

        public List<AmUserTmpCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new AmUserTmpCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AmUserTmpCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AmUserTmpCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new AmUserTmpCriterion(condition, value1, value2));
        }

        public AmUserTmpCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "USER_ID");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "USER_ID");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "USER_ID");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "USER_ID");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "USER_ID");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "USER_ID");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdNotLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdLeftLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdNotLeftLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdRightLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdNotRightLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID  in ", values, "USER_ID");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in ", values, "USER_ID");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between ", value1, value2, "USER_ID");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between ", value1, value2, "USER_ID");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "USER_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "USER_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "USER_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "USER_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "USER_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "USER_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameLike(String value) {
            addCriterion("USER_NAME like ", value, "USER_NAME", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME  not like ", value, "USER_NAME", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameLeftLike(String value) {
            addCriterion("USER_NAME like ", value, "USER_NAME", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameNotLeftLike(String value) {
            addCriterion("USER_NAME  not like ", value, "USER_NAME", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameRightLike(String value) {
            addCriterion("USER_NAME like ", value, "USER_NAME", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameNotRightLike(String value) {
            addCriterion("USER_NAME  not like ", value, "USER_NAME", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME  in ", values, "USER_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in ", values, "USER_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between ", value1, value2, "USER_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between ", value1, value2, "USER_NAME");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andNickNameIsNull() {
            addCriterion("NICK_NAME is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameIsNotNull() {
            addCriterion("NICK_NAME is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameEqualTo(String value) {
            addCriterion("NICK_NAME =", value, "NICK_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameNotEqualTo(String value) {
            addCriterion("NICK_NAME <>", value, "NICK_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameGreaterThan(String value) {
            addCriterion("NICK_NAME >", value, "NICK_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("NICK_NAME >=", value, "NICK_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameLessThan(String value) {
            addCriterion("NICK_NAME <", value, "NICK_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("NICK_NAME <=", value, "NICK_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameLike(String value) {
            addCriterion("NICK_NAME like ", value, "NICK_NAME", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameNotLike(String value) {
            addCriterion("NICK_NAME  not like ", value, "NICK_NAME", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameLeftLike(String value) {
            addCriterion("NICK_NAME like ", value, "NICK_NAME", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameNotLeftLike(String value) {
            addCriterion("NICK_NAME  not like ", value, "NICK_NAME", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameRightLike(String value) {
            addCriterion("NICK_NAME like ", value, "NICK_NAME", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameNotRightLike(String value) {
            addCriterion("NICK_NAME  not like ", value, "NICK_NAME", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameIn(List<String> values) {
            addCriterion("NICK_NAME  in ", values, "NICK_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameNotIn(List<String> values) {
            addCriterion("NICK_NAME not in ", values, "NICK_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameBetween(String value1, String value2) {
            addCriterion("NICK_NAME between ", value1, value2, "NICK_NAME");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("NICK_NAME not between ", value1, value2, "NICK_NAME");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andUserCodeIsNull() {
            addCriterion("USER_CODE is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeIsNotNull() {
            addCriterion("USER_CODE is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeEqualTo(String value) {
            addCriterion("USER_CODE =", value, "USER_CODE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeNotEqualTo(String value) {
            addCriterion("USER_CODE <>", value, "USER_CODE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeGreaterThan(String value) {
            addCriterion("USER_CODE >", value, "USER_CODE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_CODE >=", value, "USER_CODE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeLessThan(String value) {
            addCriterion("USER_CODE <", value, "USER_CODE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeLessThanOrEqualTo(String value) {
            addCriterion("USER_CODE <=", value, "USER_CODE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeLike(String value) {
            addCriterion("USER_CODE like ", value, "USER_CODE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeNotLike(String value) {
            addCriterion("USER_CODE  not like ", value, "USER_CODE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeLeftLike(String value) {
            addCriterion("USER_CODE like ", value, "USER_CODE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeNotLeftLike(String value) {
            addCriterion("USER_CODE  not like ", value, "USER_CODE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeRightLike(String value) {
            addCriterion("USER_CODE like ", value, "USER_CODE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeNotRightLike(String value) {
            addCriterion("USER_CODE  not like ", value, "USER_CODE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeIn(List<String> values) {
            addCriterion("USER_CODE  in ", values, "USER_CODE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeNotIn(List<String> values) {
            addCriterion("USER_CODE not in ", values, "USER_CODE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeBetween(String value1, String value2) {
            addCriterion("USER_CODE between ", value1, value2, "USER_CODE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andUserCodeNotBetween(String value1, String value2) {
            addCriterion("USER_CODE not between ", value1, value2, "USER_CODE");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andTelephoneIsNull() {
            addCriterion("TELEPHONE is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneIsNotNull() {
            addCriterion("TELEPHONE is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneEqualTo(String value) {
            addCriterion("TELEPHONE =", value, "TELEPHONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneNotEqualTo(String value) {
            addCriterion("TELEPHONE <>", value, "TELEPHONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneGreaterThan(String value) {
            addCriterion("TELEPHONE >", value, "TELEPHONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("TELEPHONE >=", value, "TELEPHONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneLessThan(String value) {
            addCriterion("TELEPHONE <", value, "TELEPHONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("TELEPHONE <=", value, "TELEPHONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneLike(String value) {
            addCriterion("TELEPHONE like ", value, "TELEPHONE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneNotLike(String value) {
            addCriterion("TELEPHONE  not like ", value, "TELEPHONE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneLeftLike(String value) {
            addCriterion("TELEPHONE like ", value, "TELEPHONE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneNotLeftLike(String value) {
            addCriterion("TELEPHONE  not like ", value, "TELEPHONE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneRightLike(String value) {
            addCriterion("TELEPHONE like ", value, "TELEPHONE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneNotRightLike(String value) {
            addCriterion("TELEPHONE  not like ", value, "TELEPHONE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneIn(List<String> values) {
            addCriterion("TELEPHONE  in ", values, "TELEPHONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneNotIn(List<String> values) {
            addCriterion("TELEPHONE not in ", values, "TELEPHONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneBetween(String value1, String value2) {
            addCriterion("TELEPHONE between ", value1, value2, "TELEPHONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("TELEPHONE not between ", value1, value2, "TELEPHONE");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "EMAIL");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "EMAIL");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "EMAIL");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "EMAIL");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "EMAIL");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "EMAIL");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailLike(String value) {
            addCriterion("EMAIL like ", value, "EMAIL", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailNotLike(String value) {
            addCriterion("EMAIL  not like ", value, "EMAIL", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailLeftLike(String value) {
            addCriterion("EMAIL like ", value, "EMAIL", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailNotLeftLike(String value) {
            addCriterion("EMAIL  not like ", value, "EMAIL", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailRightLike(String value) {
            addCriterion("EMAIL like ", value, "EMAIL", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailNotRightLike(String value) {
            addCriterion("EMAIL  not like ", value, "EMAIL", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailIn(List<String> values) {
            addCriterion("EMAIL  in ", values, "EMAIL");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in ", values, "EMAIL");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between ", value1, value2, "EMAIL");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between ", value1, value2, "EMAIL");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "PASSWORD");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "PASSWORD");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "PASSWORD");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "PASSWORD");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "PASSWORD");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "PASSWORD");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordLike(String value) {
            addCriterion("PASSWORD like ", value, "PASSWORD", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD  not like ", value, "PASSWORD", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordLeftLike(String value) {
            addCriterion("PASSWORD like ", value, "PASSWORD", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordNotLeftLike(String value) {
            addCriterion("PASSWORD  not like ", value, "PASSWORD", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordRightLike(String value) {
            addCriterion("PASSWORD like ", value, "PASSWORD", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordNotRightLike(String value) {
            addCriterion("PASSWORD  not like ", value, "PASSWORD", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD  in ", values, "PASSWORD");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in ", values, "PASSWORD");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between ", value1, value2, "PASSWORD");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between ", value1, value2, "PASSWORD");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeEqualTo(Integer value) {
            addCriterion("AGE =", value, "AGE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeNotEqualTo(Integer value) {
            addCriterion("AGE <>", value, "AGE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeGreaterThan(Integer value) {
            addCriterion("AGE >", value, "AGE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AGE >=", value, "AGE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeLessThan(Integer value) {
            addCriterion("AGE <", value, "AGE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("AGE <=", value, "AGE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeLike(Integer value) {
            addCriterion("AGE like ", value, "AGE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeNotLike(Integer value) {
            addCriterion("AGE  not like ", value, "AGE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeLeftLike(Integer value) {
            addCriterion("AGE like ", value, "AGE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeNotLeftLike(Integer value) {
            addCriterion("AGE  not like ", value, "AGE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeRightLike(Integer value) {
            addCriterion("AGE like ", value, "AGE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeNotRightLike(Integer value) {
            addCriterion("AGE  not like ", value, "AGE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeIn(List<Integer> values) {
            addCriterion("AGE  in ", values, "AGE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeNotIn(List<Integer> values) {
            addCriterion("AGE not in ", values, "AGE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("AGE between ", value1, value2, "AGE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("AGE not between ", value1, value2, "AGE");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andStateIsNull() {
            addCriterion("STATE is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "STATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "STATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "STATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "STATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "STATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "STATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateLike(String value) {
            addCriterion("STATE like ", value, "STATE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateNotLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateLeftLike(String value) {
            addCriterion("STATE like ", value, "STATE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateNotLeftLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateRightLike(String value) {
            addCriterion("STATE like ", value, "STATE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateNotRightLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateIn(List<String> values) {
            addCriterion("STATE  in ", values, "STATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in ", values, "STATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between ", value1, value2, "STATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between ", value1, value2, "STATE");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andCreatedDateIsNull() {
            addCriterion("CREATED_DATE is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateIsNotNull() {
            addCriterion("CREATED_DATE is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateEqualTo(Date value) {
            addCriterion("CREATED_DATE =", value, "CREATED_DATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("CREATED_DATE <>", value, "CREATED_DATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateGreaterThan(Date value) {
            addCriterion("CREATED_DATE >", value, "CREATED_DATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE >=", value, "CREATED_DATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateLessThan(Date value) {
            addCriterion("CREATED_DATE <", value, "CREATED_DATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE <=", value, "CREATED_DATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateNotLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateLeftLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateNotLeftLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateRightLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateNotRightLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateIn(List<Date> values) {
            addCriterion("CREATED_DATE  in ", values, "CREATED_DATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("CREATED_DATE not in ", values, "CREATED_DATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE between ", value1, value2, "CREATED_DATE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE not between ", value1, value2, "CREATED_DATE");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andTestNumberOneIsNull() {
            addCriterion("TEST_NUMBER_ONE is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneIsNotNull() {
            addCriterion("TEST_NUMBER_ONE is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE =", value, "TEST_NUMBER_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneNotEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE <>", value, "TEST_NUMBER_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneGreaterThan(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE >", value, "TEST_NUMBER_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE >=", value, "TEST_NUMBER_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneLessThan(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE <", value, "TEST_NUMBER_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE <=", value, "TEST_NUMBER_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE like ", value, "TEST_NUMBER_ONE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneNotLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE  not like ", value, "TEST_NUMBER_ONE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneLeftLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE like ", value, "TEST_NUMBER_ONE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneNotLeftLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE  not like ", value, "TEST_NUMBER_ONE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneRightLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE like ", value, "TEST_NUMBER_ONE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneNotRightLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE  not like ", value, "TEST_NUMBER_ONE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneIn(List<BigDecimal> values) {
            addCriterion("TEST_NUMBER_ONE  in ", values, "TEST_NUMBER_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneNotIn(List<BigDecimal> values) {
            addCriterion("TEST_NUMBER_ONE not in ", values, "TEST_NUMBER_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TEST_NUMBER_ONE between ", value1, value2, "TEST_NUMBER_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberOneNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TEST_NUMBER_ONE not between ", value1, value2, "TEST_NUMBER_ONE");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andTestNumberTwoIsNull() {
            addCriterion("TEST_NUMBER_TWO is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoIsNotNull() {
            addCriterion("TEST_NUMBER_TWO is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO =", value, "TEST_NUMBER_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoNotEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO <>", value, "TEST_NUMBER_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoGreaterThan(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO >", value, "TEST_NUMBER_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO >=", value, "TEST_NUMBER_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoLessThan(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO <", value, "TEST_NUMBER_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO <=", value, "TEST_NUMBER_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO like ", value, "TEST_NUMBER_TWO", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoNotLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO  not like ", value, "TEST_NUMBER_TWO", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoLeftLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO like ", value, "TEST_NUMBER_TWO", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoNotLeftLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO  not like ", value, "TEST_NUMBER_TWO", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoRightLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO like ", value, "TEST_NUMBER_TWO", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoNotRightLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO  not like ", value, "TEST_NUMBER_TWO", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoIn(List<BigDecimal> values) {
            addCriterion("TEST_NUMBER_TWO  in ", values, "TEST_NUMBER_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoNotIn(List<BigDecimal> values) {
            addCriterion("TEST_NUMBER_TWO not in ", values, "TEST_NUMBER_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TEST_NUMBER_TWO between ", value1, value2, "TEST_NUMBER_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestNumberTwoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TEST_NUMBER_TWO not between ", value1, value2, "TEST_NUMBER_TWO");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andTestDoubleOneIsNull() {
            addCriterion("TEST_DOUBLE_ONE is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneIsNotNull() {
            addCriterion("TEST_DOUBLE_ONE is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_ONE =", value, "TEST_DOUBLE_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneNotEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_ONE <>", value, "TEST_DOUBLE_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneGreaterThan(Double value) {
            addCriterion("TEST_DOUBLE_ONE >", value, "TEST_DOUBLE_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneGreaterThanOrEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_ONE >=", value, "TEST_DOUBLE_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneLessThan(Double value) {
            addCriterion("TEST_DOUBLE_ONE <", value, "TEST_DOUBLE_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneLessThanOrEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_ONE <=", value, "TEST_DOUBLE_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneLike(Double value) {
            addCriterion("TEST_DOUBLE_ONE like ", value, "TEST_DOUBLE_ONE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneNotLike(Double value) {
            addCriterion("TEST_DOUBLE_ONE  not like ", value, "TEST_DOUBLE_ONE", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneLeftLike(Double value) {
            addCriterion("TEST_DOUBLE_ONE like ", value, "TEST_DOUBLE_ONE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneNotLeftLike(Double value) {
            addCriterion("TEST_DOUBLE_ONE  not like ", value, "TEST_DOUBLE_ONE", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneRightLike(Double value) {
            addCriterion("TEST_DOUBLE_ONE like ", value, "TEST_DOUBLE_ONE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneNotRightLike(Double value) {
            addCriterion("TEST_DOUBLE_ONE  not like ", value, "TEST_DOUBLE_ONE", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneIn(List<Double> values) {
            addCriterion("TEST_DOUBLE_ONE  in ", values, "TEST_DOUBLE_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneNotIn(List<Double> values) {
            addCriterion("TEST_DOUBLE_ONE not in ", values, "TEST_DOUBLE_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneBetween(Double value1, Double value2) {
            addCriterion("TEST_DOUBLE_ONE between ", value1, value2, "TEST_DOUBLE_ONE");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleOneNotBetween(Double value1, Double value2) {
            addCriterion("TEST_DOUBLE_ONE not between ", value1, value2, "TEST_DOUBLE_ONE");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andTestDoubleTwoIsNull() {
            addCriterion("TEST_DOUBLE_TWO is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoIsNotNull() {
            addCriterion("TEST_DOUBLE_TWO is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_TWO =", value, "TEST_DOUBLE_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoNotEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_TWO <>", value, "TEST_DOUBLE_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoGreaterThan(Double value) {
            addCriterion("TEST_DOUBLE_TWO >", value, "TEST_DOUBLE_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoGreaterThanOrEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_TWO >=", value, "TEST_DOUBLE_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoLessThan(Double value) {
            addCriterion("TEST_DOUBLE_TWO <", value, "TEST_DOUBLE_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoLessThanOrEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_TWO <=", value, "TEST_DOUBLE_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoLike(Double value) {
            addCriterion("TEST_DOUBLE_TWO like ", value, "TEST_DOUBLE_TWO", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoNotLike(Double value) {
            addCriterion("TEST_DOUBLE_TWO  not like ", value, "TEST_DOUBLE_TWO", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoLeftLike(Double value) {
            addCriterion("TEST_DOUBLE_TWO like ", value, "TEST_DOUBLE_TWO", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoNotLeftLike(Double value) {
            addCriterion("TEST_DOUBLE_TWO  not like ", value, "TEST_DOUBLE_TWO", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoRightLike(Double value) {
            addCriterion("TEST_DOUBLE_TWO like ", value, "TEST_DOUBLE_TWO", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoNotRightLike(Double value) {
            addCriterion("TEST_DOUBLE_TWO  not like ", value, "TEST_DOUBLE_TWO", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoIn(List<Double> values) {
            addCriterion("TEST_DOUBLE_TWO  in ", values, "TEST_DOUBLE_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoNotIn(List<Double> values) {
            addCriterion("TEST_DOUBLE_TWO not in ", values, "TEST_DOUBLE_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoBetween(Double value1, Double value2) {
            addCriterion("TEST_DOUBLE_TWO between ", value1, value2, "TEST_DOUBLE_TWO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestDoubleTwoNotBetween(Double value1, Double value2) {
            addCriterion("TEST_DOUBLE_TWO not between ", value1, value2, "TEST_DOUBLE_TWO");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andPhotoIsNull() {
            addCriterion("PHOTO is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoIsNotNull() {
            addCriterion("PHOTO is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoEqualTo(String value) {
            addCriterion("PHOTO =", value, "PHOTO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoNotEqualTo(String value) {
            addCriterion("PHOTO <>", value, "PHOTO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoGreaterThan(String value) {
            addCriterion("PHOTO >", value, "PHOTO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("PHOTO >=", value, "PHOTO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoLessThan(String value) {
            addCriterion("PHOTO <", value, "PHOTO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("PHOTO <=", value, "PHOTO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoLike(String value) {
            addCriterion("PHOTO like ", value, "PHOTO", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoNotLike(String value) {
            addCriterion("PHOTO  not like ", value, "PHOTO", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoLeftLike(String value) {
            addCriterion("PHOTO like ", value, "PHOTO", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoNotLeftLike(String value) {
            addCriterion("PHOTO  not like ", value, "PHOTO", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoRightLike(String value) {
            addCriterion("PHOTO like ", value, "PHOTO", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoNotRightLike(String value) {
            addCriterion("PHOTO  not like ", value, "PHOTO", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoIn(List<String> values) {
            addCriterion("PHOTO  in ", values, "PHOTO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoNotIn(List<String> values) {
            addCriterion("PHOTO not in ", values, "PHOTO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoBetween(String value1, String value2) {
            addCriterion("PHOTO between ", value1, value2, "PHOTO");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("PHOTO not between ", value1, value2, "PHOTO");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andTestTextIsNull() {
            addCriterion("TEST_TEXT is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextIsNotNull() {
            addCriterion("TEST_TEXT is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextEqualTo(String value) {
            addCriterion("TEST_TEXT =", value, "TEST_TEXT");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextNotEqualTo(String value) {
            addCriterion("TEST_TEXT <>", value, "TEST_TEXT");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextGreaterThan(String value) {
            addCriterion("TEST_TEXT >", value, "TEST_TEXT");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_TEXT >=", value, "TEST_TEXT");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextLessThan(String value) {
            addCriterion("TEST_TEXT <", value, "TEST_TEXT");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextLessThanOrEqualTo(String value) {
            addCriterion("TEST_TEXT <=", value, "TEST_TEXT");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextLike(String value) {
            addCriterion("TEST_TEXT like ", value, "TEST_TEXT", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextNotLike(String value) {
            addCriterion("TEST_TEXT  not like ", value, "TEST_TEXT", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextLeftLike(String value) {
            addCriterion("TEST_TEXT like ", value, "TEST_TEXT", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextNotLeftLike(String value) {
            addCriterion("TEST_TEXT  not like ", value, "TEST_TEXT", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextRightLike(String value) {
            addCriterion("TEST_TEXT like ", value, "TEST_TEXT", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextNotRightLike(String value) {
            addCriterion("TEST_TEXT  not like ", value, "TEST_TEXT", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextIn(List<String> values) {
            addCriterion("TEST_TEXT  in ", values, "TEST_TEXT");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextNotIn(List<String> values) {
            addCriterion("TEST_TEXT not in ", values, "TEST_TEXT");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextBetween(String value1, String value2) {
            addCriterion("TEST_TEXT between ", value1, value2, "TEST_TEXT");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andTestTextNotBetween(String value1, String value2) {
            addCriterion("TEST_TEXT not between ", value1, value2, "TEST_TEXT");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andAcctItemIdIsNull() {
            addCriterion("acct_item_id is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdIsNotNull() {
            addCriterion("acct_item_id is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdEqualTo(BigDecimal value) {
            addCriterion("acct_item_id =", value, "acct_item_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdNotEqualTo(BigDecimal value) {
            addCriterion("acct_item_id <>", value, "acct_item_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdGreaterThan(BigDecimal value) {
            addCriterion("acct_item_id >", value, "acct_item_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("acct_item_id >=", value, "acct_item_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdLessThan(BigDecimal value) {
            addCriterion("acct_item_id <", value, "acct_item_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("acct_item_id <=", value, "acct_item_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdLike(BigDecimal value) {
            addCriterion("acct_item_id like ", value, "acct_item_id", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdNotLike(BigDecimal value) {
            addCriterion("acct_item_id  not like ", value, "acct_item_id", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdLeftLike(BigDecimal value) {
            addCriterion("acct_item_id like ", value, "acct_item_id", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdNotLeftLike(BigDecimal value) {
            addCriterion("acct_item_id  not like ", value, "acct_item_id", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdRightLike(BigDecimal value) {
            addCriterion("acct_item_id like ", value, "acct_item_id", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdNotRightLike(BigDecimal value) {
            addCriterion("acct_item_id  not like ", value, "acct_item_id", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdIn(List<BigDecimal> values) {
            addCriterion("acct_item_id  in ", values, "acct_item_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdNotIn(List<BigDecimal> values) {
            addCriterion("acct_item_id not in ", values, "acct_item_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("acct_item_id between ", value1, value2, "acct_item_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAcctItemIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("acct_item_id not between ", value1, value2, "acct_item_id");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andServIdIsNull() {
            addCriterion("serv_id is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdIsNotNull() {
            addCriterion("serv_id is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdEqualTo(BigDecimal value) {
            addCriterion("serv_id =", value, "serv_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdNotEqualTo(BigDecimal value) {
            addCriterion("serv_id <>", value, "serv_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdGreaterThan(BigDecimal value) {
            addCriterion("serv_id >", value, "serv_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("serv_id >=", value, "serv_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdLessThan(BigDecimal value) {
            addCriterion("serv_id <", value, "serv_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("serv_id <=", value, "serv_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdLike(BigDecimal value) {
            addCriterion("serv_id like ", value, "serv_id", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdNotLike(BigDecimal value) {
            addCriterion("serv_id  not like ", value, "serv_id", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdLeftLike(BigDecimal value) {
            addCriterion("serv_id like ", value, "serv_id", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdNotLeftLike(BigDecimal value) {
            addCriterion("serv_id  not like ", value, "serv_id", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdRightLike(BigDecimal value) {
            addCriterion("serv_id like ", value, "serv_id", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdNotRightLike(BigDecimal value) {
            addCriterion("serv_id  not like ", value, "serv_id", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdIn(List<BigDecimal> values) {
            addCriterion("serv_id  in ", values, "serv_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdNotIn(List<BigDecimal> values) {
            addCriterion("serv_id not in ", values, "serv_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("serv_id between ", value1, value2, "serv_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andServIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("serv_id not between ", value1, value2, "serv_id");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andAmountIsNull() {
            addCriterion("amount is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountLike(BigDecimal value) {
            addCriterion("amount like ", value, "amount", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountNotLike(BigDecimal value) {
            addCriterion("amount  not like ", value, "amount", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountLeftLike(BigDecimal value) {
            addCriterion("amount like ", value, "amount", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountNotLeftLike(BigDecimal value) {
            addCriterion("amount  not like ", value, "amount", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountRightLike(BigDecimal value) {
            addCriterion("amount like ", value, "amount", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountNotRightLike(BigDecimal value) {
            addCriterion("amount  not like ", value, "amount", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount  in ", values, "amount");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in ", values, "amount");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between ", value1, value2, "amount");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between ", value1, value2, "amount");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andFeeCycleIdIsNull() {
            addCriterion("fee_cycle_id is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdIsNotNull() {
            addCriterion("fee_cycle_id is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdEqualTo(BigDecimal value) {
            addCriterion("fee_cycle_id =", value, "fee_cycle_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdNotEqualTo(BigDecimal value) {
            addCriterion("fee_cycle_id <>", value, "fee_cycle_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdGreaterThan(BigDecimal value) {
            addCriterion("fee_cycle_id >", value, "fee_cycle_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_cycle_id >=", value, "fee_cycle_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdLessThan(BigDecimal value) {
            addCriterion("fee_cycle_id <", value, "fee_cycle_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_cycle_id <=", value, "fee_cycle_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdLike(BigDecimal value) {
            addCriterion("fee_cycle_id like ", value, "fee_cycle_id", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdNotLike(BigDecimal value) {
            addCriterion("fee_cycle_id  not like ", value, "fee_cycle_id", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdLeftLike(BigDecimal value) {
            addCriterion("fee_cycle_id like ", value, "fee_cycle_id", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdNotLeftLike(BigDecimal value) {
            addCriterion("fee_cycle_id  not like ", value, "fee_cycle_id", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdRightLike(BigDecimal value) {
            addCriterion("fee_cycle_id like ", value, "fee_cycle_id", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdNotRightLike(BigDecimal value) {
            addCriterion("fee_cycle_id  not like ", value, "fee_cycle_id", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdIn(List<BigDecimal> values) {
            addCriterion("fee_cycle_id  in ", values, "fee_cycle_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdNotIn(List<BigDecimal> values) {
            addCriterion("fee_cycle_id not in ", values, "fee_cycle_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_cycle_id between ", value1, value2, "fee_cycle_id");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andFeeCycleIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_cycle_id not between ", value1, value2, "fee_cycle_id");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andStateDateIsNull() {
            addCriterion("state_date is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateIsNotNull() {
            addCriterion("state_date is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateEqualTo(Date value) {
            addCriterion("state_date =", value, "state_date");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateNotEqualTo(Date value) {
            addCriterion("state_date <>", value, "state_date");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateGreaterThan(Date value) {
            addCriterion("state_date >", value, "state_date");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("state_date >=", value, "state_date");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateLessThan(Date value) {
            addCriterion("state_date <", value, "state_date");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateLessThanOrEqualTo(Date value) {
            addCriterion("state_date <=", value, "state_date");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateLike(Date value) {
            addCriterion("state_date like ", value, "state_date", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateNotLike(Date value) {
            addCriterion("state_date  not like ", value, "state_date", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateLeftLike(Date value) {
            addCriterion("state_date like ", value, "state_date", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateNotLeftLike(Date value) {
            addCriterion("state_date  not like ", value, "state_date", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateRightLike(Date value) {
            addCriterion("state_date like ", value, "state_date", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateNotRightLike(Date value) {
            addCriterion("state_date  not like ", value, "state_date", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateIn(List<Date> values) {
            addCriterion("state_date  in ", values, "state_date");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateNotIn(List<Date> values) {
            addCriterion("state_date not in ", values, "state_date");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateBetween(Date value1, Date value2) {
            addCriterion("state_date between ", value1, value2, "state_date");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andStateDateNotBetween(Date value1, Date value2) {
            addCriterion("state_date not between ", value1, value2, "state_date");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andBalancePaidIsNull() {
            addCriterion("balance_paid is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidIsNotNull() {
            addCriterion("balance_paid is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidEqualTo(BigDecimal value) {
            addCriterion("balance_paid =", value, "balance_paid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidNotEqualTo(BigDecimal value) {
            addCriterion("balance_paid <>", value, "balance_paid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidGreaterThan(BigDecimal value) {
            addCriterion("balance_paid >", value, "balance_paid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_paid >=", value, "balance_paid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidLessThan(BigDecimal value) {
            addCriterion("balance_paid <", value, "balance_paid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_paid <=", value, "balance_paid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidLike(BigDecimal value) {
            addCriterion("balance_paid like ", value, "balance_paid", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidNotLike(BigDecimal value) {
            addCriterion("balance_paid  not like ", value, "balance_paid", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidLeftLike(BigDecimal value) {
            addCriterion("balance_paid like ", value, "balance_paid", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidNotLeftLike(BigDecimal value) {
            addCriterion("balance_paid  not like ", value, "balance_paid", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidRightLike(BigDecimal value) {
            addCriterion("balance_paid like ", value, "balance_paid", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidNotRightLike(BigDecimal value) {
            addCriterion("balance_paid  not like ", value, "balance_paid", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidIn(List<BigDecimal> values) {
            addCriterion("balance_paid  in ", values, "balance_paid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidNotIn(List<BigDecimal> values) {
            addCriterion("balance_paid not in ", values, "balance_paid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_paid between ", value1, value2, "balance_paid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andBalancePaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_paid not between ", value1, value2, "balance_paid");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andDealSourceIsNull() {
            addCriterion("deal_source is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceIsNotNull() {
            addCriterion("deal_source is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceEqualTo(Integer value) {
            addCriterion("deal_source =", value, "deal_source");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceNotEqualTo(Integer value) {
            addCriterion("deal_source <>", value, "deal_source");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceGreaterThan(Integer value) {
            addCriterion("deal_source >", value, "deal_source");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_source >=", value, "deal_source");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceLessThan(Integer value) {
            addCriterion("deal_source <", value, "deal_source");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceLessThanOrEqualTo(Integer value) {
            addCriterion("deal_source <=", value, "deal_source");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceLike(Integer value) {
            addCriterion("deal_source like ", value, "deal_source", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceNotLike(Integer value) {
            addCriterion("deal_source  not like ", value, "deal_source", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceLeftLike(Integer value) {
            addCriterion("deal_source like ", value, "deal_source", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceNotLeftLike(Integer value) {
            addCriterion("deal_source  not like ", value, "deal_source", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceRightLike(Integer value) {
            addCriterion("deal_source like ", value, "deal_source", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceNotRightLike(Integer value) {
            addCriterion("deal_source  not like ", value, "deal_source", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceIn(List<Integer> values) {
            addCriterion("deal_source  in ", values, "deal_source");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceNotIn(List<Integer> values) {
            addCriterion("deal_source not in ", values, "deal_source");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceBetween(Integer value1, Integer value2) {
            addCriterion("deal_source between ", value1, value2, "deal_source");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andDealSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_source not between ", value1, value2, "deal_source");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andMeterReadingIsNull() {
            addCriterion("meter_reading is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingIsNotNull() {
            addCriterion("meter_reading is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingEqualTo(BigDecimal value) {
            addCriterion("meter_reading =", value, "meter_reading");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingNotEqualTo(BigDecimal value) {
            addCriterion("meter_reading <>", value, "meter_reading");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingGreaterThan(BigDecimal value) {
            addCriterion("meter_reading >", value, "meter_reading");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("meter_reading >=", value, "meter_reading");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingLessThan(BigDecimal value) {
            addCriterion("meter_reading <", value, "meter_reading");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("meter_reading <=", value, "meter_reading");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingLike(BigDecimal value) {
            addCriterion("meter_reading like ", value, "meter_reading", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingNotLike(BigDecimal value) {
            addCriterion("meter_reading  not like ", value, "meter_reading", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingLeftLike(BigDecimal value) {
            addCriterion("meter_reading like ", value, "meter_reading", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingNotLeftLike(BigDecimal value) {
            addCriterion("meter_reading  not like ", value, "meter_reading", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingRightLike(BigDecimal value) {
            addCriterion("meter_reading like ", value, "meter_reading", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingNotRightLike(BigDecimal value) {
            addCriterion("meter_reading  not like ", value, "meter_reading", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingIn(List<BigDecimal> values) {
            addCriterion("meter_reading  in ", values, "meter_reading");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingNotIn(List<BigDecimal> values) {
            addCriterion("meter_reading not in ", values, "meter_reading");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("meter_reading between ", value1, value2, "meter_reading");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andMeterReadingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("meter_reading not between ", value1, value2, "meter_reading");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andPseudoFlagIsNull() {
            addCriterion("pseudo_flag is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagIsNotNull() {
            addCriterion("pseudo_flag is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagEqualTo(String value) {
            addCriterion("pseudo_flag =", value, "pseudo_flag");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagNotEqualTo(String value) {
            addCriterion("pseudo_flag <>", value, "pseudo_flag");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagGreaterThan(String value) {
            addCriterion("pseudo_flag >", value, "pseudo_flag");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagGreaterThanOrEqualTo(String value) {
            addCriterion("pseudo_flag >=", value, "pseudo_flag");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagLessThan(String value) {
            addCriterion("pseudo_flag <", value, "pseudo_flag");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagLessThanOrEqualTo(String value) {
            addCriterion("pseudo_flag <=", value, "pseudo_flag");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagLike(String value) {
            addCriterion("pseudo_flag like ", value, "pseudo_flag", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagNotLike(String value) {
            addCriterion("pseudo_flag  not like ", value, "pseudo_flag", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagLeftLike(String value) {
            addCriterion("pseudo_flag like ", value, "pseudo_flag", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagNotLeftLike(String value) {
            addCriterion("pseudo_flag  not like ", value, "pseudo_flag", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagRightLike(String value) {
            addCriterion("pseudo_flag like ", value, "pseudo_flag", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagNotRightLike(String value) {
            addCriterion("pseudo_flag  not like ", value, "pseudo_flag", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagIn(List<String> values) {
            addCriterion("pseudo_flag  in ", values, "pseudo_flag");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagNotIn(List<String> values) {
            addCriterion("pseudo_flag not in ", values, "pseudo_flag");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagBetween(String value1, String value2) {
            addCriterion("pseudo_flag between ", value1, value2, "pseudo_flag");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPseudoFlagNotBetween(String value1, String value2) {
            addCriterion("pseudo_flag not between ", value1, value2, "pseudo_flag");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andPartitionChargeIsNull() {
            addCriterion("partition_charge is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeIsNotNull() {
            addCriterion("partition_charge is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeEqualTo(BigDecimal value) {
            addCriterion("partition_charge =", value, "partition_charge");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeNotEqualTo(BigDecimal value) {
            addCriterion("partition_charge <>", value, "partition_charge");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeGreaterThan(BigDecimal value) {
            addCriterion("partition_charge >", value, "partition_charge");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("partition_charge >=", value, "partition_charge");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeLessThan(BigDecimal value) {
            addCriterion("partition_charge <", value, "partition_charge");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("partition_charge <=", value, "partition_charge");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeLike(BigDecimal value) {
            addCriterion("partition_charge like ", value, "partition_charge", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeNotLike(BigDecimal value) {
            addCriterion("partition_charge  not like ", value, "partition_charge", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeLeftLike(BigDecimal value) {
            addCriterion("partition_charge like ", value, "partition_charge", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeNotLeftLike(BigDecimal value) {
            addCriterion("partition_charge  not like ", value, "partition_charge", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeRightLike(BigDecimal value) {
            addCriterion("partition_charge like ", value, "partition_charge", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeNotRightLike(BigDecimal value) {
            addCriterion("partition_charge  not like ", value, "partition_charge", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeIn(List<BigDecimal> values) {
            addCriterion("partition_charge  in ", values, "partition_charge");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeNotIn(List<BigDecimal> values) {
            addCriterion("partition_charge not in ", values, "partition_charge");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("partition_charge between ", value1, value2, "partition_charge");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andPartitionChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("partition_charge not between ", value1, value2, "partition_charge");
            return (AmUserTmpCriteria) this;
        }
        public AmUserTmpCriteria andCpidIsNull() {
            addCriterion("cpid is null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidIsNotNull() {
            addCriterion("cpid is not null");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidEqualTo(String value) {
            addCriterion("cpid =", value, "cpid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidNotEqualTo(String value) {
            addCriterion("cpid <>", value, "cpid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidGreaterThan(String value) {
            addCriterion("cpid >", value, "cpid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidGreaterThanOrEqualTo(String value) {
            addCriterion("cpid >=", value, "cpid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidLessThan(String value) {
            addCriterion("cpid <", value, "cpid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidLessThanOrEqualTo(String value) {
            addCriterion("cpid <=", value, "cpid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidLike(String value) {
            addCriterion("cpid like ", value, "cpid", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidNotLike(String value) {
            addCriterion("cpid  not like ", value, "cpid", 1);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidLeftLike(String value) {
            addCriterion("cpid like ", value, "cpid", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidNotLeftLike(String value) {
            addCriterion("cpid  not like ", value, "cpid", 0);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidRightLike(String value) {
            addCriterion("cpid like ", value, "cpid", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidNotRightLike(String value) {
            addCriterion("cpid  not like ", value, "cpid", 2);
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidIn(List<String> values) {
            addCriterion("cpid  in ", values, "cpid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidNotIn(List<String> values) {
            addCriterion("cpid not in ", values, "cpid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidBetween(String value1, String value2) {
            addCriterion("cpid between ", value1, value2, "cpid");
            return (AmUserTmpCriteria) this;
        }

        public AmUserTmpCriteria andCpidNotBetween(String value1, String value2) {
            addCriterion("cpid not between ", value1, value2, "cpid");
            return (AmUserTmpCriteria) this;
        }

    }

    public static class AmUserTmpCriteria extends GeneratedCriteria {

        protected AmUserTmpCriteria() {
            super();
        }
    }

    public static class AmUserTmpCriterion {
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

        protected AmUserTmpCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected AmUserTmpCriterion(String condition, Object value, int likeType) {
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

        protected AmUserTmpCriterion(String condition, Object value,
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

        protected AmUserTmpCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected AmUserTmpCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected AmUserTmpCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}