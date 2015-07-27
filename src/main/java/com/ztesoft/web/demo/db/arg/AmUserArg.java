package com.ztesoft.web.demo.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class AmUserArg {
    private String pk_name = "USER_ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<AmUserCriteria> oredCriteria;

    public AmUserArg() {
        oredCriteria = new ArrayList<AmUserCriteria>();
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

    public List<AmUserCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(AmUserCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public AmUserCriteria or() {
        AmUserCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AmUserCriteria createCriteria() {
        AmUserCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AmUserCriteria createCriteriaInternal() {
        AmUserCriteria criteria = new AmUserCriteria();
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
        protected List<AmUserCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<AmUserCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<AmUserCriterion> getAllCriteria() {
            return criteria;
        }

        public List<AmUserCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new AmUserCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AmUserCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AmUserCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new AmUserCriterion(condition, value1, value2));
        }

        public AmUserCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "USER_ID");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "USER_ID");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "USER_ID");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "USER_ID");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "USER_ID");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "USER_ID");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdNotLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdLeftLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdNotLeftLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdRightLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdNotRightLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID  in ", values, "USER_ID");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in ", values, "USER_ID");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between ", value1, value2, "USER_ID");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between ", value1, value2, "USER_ID");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "USER_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "USER_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "USER_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "USER_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "USER_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "USER_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameLike(String value) {
            addCriterion("USER_NAME like ", value, "USER_NAME", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME  not like ", value, "USER_NAME", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameLeftLike(String value) {
            addCriterion("USER_NAME like ", value, "USER_NAME", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameNotLeftLike(String value) {
            addCriterion("USER_NAME  not like ", value, "USER_NAME", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameRightLike(String value) {
            addCriterion("USER_NAME like ", value, "USER_NAME", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameNotRightLike(String value) {
            addCriterion("USER_NAME  not like ", value, "USER_NAME", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME  in ", values, "USER_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in ", values, "USER_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between ", value1, value2, "USER_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between ", value1, value2, "USER_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameIsNull() {
            addCriterion("NICK_NAME is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameIsNotNull() {
            addCriterion("NICK_NAME is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameEqualTo(String value) {
            addCriterion("NICK_NAME =", value, "NICK_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameNotEqualTo(String value) {
            addCriterion("NICK_NAME <>", value, "NICK_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameGreaterThan(String value) {
            addCriterion("NICK_NAME >", value, "NICK_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("NICK_NAME >=", value, "NICK_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameLessThan(String value) {
            addCriterion("NICK_NAME <", value, "NICK_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("NICK_NAME <=", value, "NICK_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameLike(String value) {
            addCriterion("NICK_NAME like ", value, "NICK_NAME", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameNotLike(String value) {
            addCriterion("NICK_NAME  not like ", value, "NICK_NAME", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameLeftLike(String value) {
            addCriterion("NICK_NAME like ", value, "NICK_NAME", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameNotLeftLike(String value) {
            addCriterion("NICK_NAME  not like ", value, "NICK_NAME", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameRightLike(String value) {
            addCriterion("NICK_NAME like ", value, "NICK_NAME", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameNotRightLike(String value) {
            addCriterion("NICK_NAME  not like ", value, "NICK_NAME", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameIn(List<String> values) {
            addCriterion("NICK_NAME  in ", values, "NICK_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameNotIn(List<String> values) {
            addCriterion("NICK_NAME not in ", values, "NICK_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameBetween(String value1, String value2) {
            addCriterion("NICK_NAME between ", value1, value2, "NICK_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("NICK_NAME not between ", value1, value2, "NICK_NAME");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeIsNull() {
            addCriterion("USER_CODE is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeIsNotNull() {
            addCriterion("USER_CODE is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeEqualTo(String value) {
            addCriterion("USER_CODE =", value, "USER_CODE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeNotEqualTo(String value) {
            addCriterion("USER_CODE <>", value, "USER_CODE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeGreaterThan(String value) {
            addCriterion("USER_CODE >", value, "USER_CODE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_CODE >=", value, "USER_CODE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeLessThan(String value) {
            addCriterion("USER_CODE <", value, "USER_CODE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeLessThanOrEqualTo(String value) {
            addCriterion("USER_CODE <=", value, "USER_CODE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeLike(String value) {
            addCriterion("USER_CODE like ", value, "USER_CODE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeNotLike(String value) {
            addCriterion("USER_CODE  not like ", value, "USER_CODE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeLeftLike(String value) {
            addCriterion("USER_CODE like ", value, "USER_CODE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeNotLeftLike(String value) {
            addCriterion("USER_CODE  not like ", value, "USER_CODE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeRightLike(String value) {
            addCriterion("USER_CODE like ", value, "USER_CODE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeNotRightLike(String value) {
            addCriterion("USER_CODE  not like ", value, "USER_CODE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeIn(List<String> values) {
            addCriterion("USER_CODE  in ", values, "USER_CODE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeNotIn(List<String> values) {
            addCriterion("USER_CODE not in ", values, "USER_CODE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeBetween(String value1, String value2) {
            addCriterion("USER_CODE between ", value1, value2, "USER_CODE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andUserCodeNotBetween(String value1, String value2) {
            addCriterion("USER_CODE not between ", value1, value2, "USER_CODE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneIsNull() {
            addCriterion("TELEPHONE is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneIsNotNull() {
            addCriterion("TELEPHONE is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneEqualTo(String value) {
            addCriterion("TELEPHONE =", value, "TELEPHONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneNotEqualTo(String value) {
            addCriterion("TELEPHONE <>", value, "TELEPHONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneGreaterThan(String value) {
            addCriterion("TELEPHONE >", value, "TELEPHONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("TELEPHONE >=", value, "TELEPHONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneLessThan(String value) {
            addCriterion("TELEPHONE <", value, "TELEPHONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("TELEPHONE <=", value, "TELEPHONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneLike(String value) {
            addCriterion("TELEPHONE like ", value, "TELEPHONE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneNotLike(String value) {
            addCriterion("TELEPHONE  not like ", value, "TELEPHONE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneLeftLike(String value) {
            addCriterion("TELEPHONE like ", value, "TELEPHONE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneNotLeftLike(String value) {
            addCriterion("TELEPHONE  not like ", value, "TELEPHONE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneRightLike(String value) {
            addCriterion("TELEPHONE like ", value, "TELEPHONE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneNotRightLike(String value) {
            addCriterion("TELEPHONE  not like ", value, "TELEPHONE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneIn(List<String> values) {
            addCriterion("TELEPHONE  in ", values, "TELEPHONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneNotIn(List<String> values) {
            addCriterion("TELEPHONE not in ", values, "TELEPHONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneBetween(String value1, String value2) {
            addCriterion("TELEPHONE between ", value1, value2, "TELEPHONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTelephoneNotBetween(String value1,
                String value2) {
            addCriterion("TELEPHONE not between ", value1, value2, "TELEPHONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "EMAIL");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "EMAIL");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "EMAIL");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "EMAIL");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "EMAIL");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "EMAIL");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailLike(String value) {
            addCriterion("EMAIL like ", value, "EMAIL", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailNotLike(String value) {
            addCriterion("EMAIL  not like ", value, "EMAIL", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailLeftLike(String value) {
            addCriterion("EMAIL like ", value, "EMAIL", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailNotLeftLike(String value) {
            addCriterion("EMAIL  not like ", value, "EMAIL", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailRightLike(String value) {
            addCriterion("EMAIL like ", value, "EMAIL", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailNotRightLike(String value) {
            addCriterion("EMAIL  not like ", value, "EMAIL", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailIn(List<String> values) {
            addCriterion("EMAIL  in ", values, "EMAIL");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in ", values, "EMAIL");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between ", value1, value2, "EMAIL");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between ", value1, value2, "EMAIL");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "PASSWORD");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "PASSWORD");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "PASSWORD");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "PASSWORD");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "PASSWORD");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "PASSWORD");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordLike(String value) {
            addCriterion("PASSWORD like ", value, "PASSWORD", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD  not like ", value, "PASSWORD", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordLeftLike(String value) {
            addCriterion("PASSWORD like ", value, "PASSWORD", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordNotLeftLike(String value) {
            addCriterion("PASSWORD  not like ", value, "PASSWORD", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordRightLike(String value) {
            addCriterion("PASSWORD like ", value, "PASSWORD", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordNotRightLike(String value) {
            addCriterion("PASSWORD  not like ", value, "PASSWORD", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD  in ", values, "PASSWORD");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in ", values, "PASSWORD");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between ", value1, value2, "PASSWORD");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between ", value1, value2, "PASSWORD");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeEqualTo(Integer value) {
            addCriterion("AGE =", value, "AGE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeNotEqualTo(Integer value) {
            addCriterion("AGE <>", value, "AGE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeGreaterThan(Integer value) {
            addCriterion("AGE >", value, "AGE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AGE >=", value, "AGE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeLessThan(Integer value) {
            addCriterion("AGE <", value, "AGE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("AGE <=", value, "AGE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeLike(Integer value) {
            addCriterion("AGE like ", value, "AGE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeNotLike(Integer value) {
            addCriterion("AGE  not like ", value, "AGE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeLeftLike(Integer value) {
            addCriterion("AGE like ", value, "AGE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeNotLeftLike(Integer value) {
            addCriterion("AGE  not like ", value, "AGE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeRightLike(Integer value) {
            addCriterion("AGE like ", value, "AGE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeNotRightLike(Integer value) {
            addCriterion("AGE  not like ", value, "AGE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeIn(List<Integer> values) {
            addCriterion("AGE  in ", values, "AGE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeNotIn(List<Integer> values) {
            addCriterion("AGE not in ", values, "AGE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("AGE between ", value1, value2, "AGE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("AGE not between ", value1, value2, "AGE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateIsNull() {
            addCriterion("STATE is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "STATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "STATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "STATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "STATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "STATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "STATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateLike(String value) {
            addCriterion("STATE like ", value, "STATE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateNotLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateLeftLike(String value) {
            addCriterion("STATE like ", value, "STATE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateNotLeftLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateRightLike(String value) {
            addCriterion("STATE like ", value, "STATE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateNotRightLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateIn(List<String> values) {
            addCriterion("STATE  in ", values, "STATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in ", values, "STATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between ", value1, value2, "STATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between ", value1, value2, "STATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateIsNull() {
            addCriterion("CREATED_DATE is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateIsNotNull() {
            addCriterion("CREATED_DATE is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateEqualTo(Date value) {
            addCriterion("CREATED_DATE =", value, "CREATED_DATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("CREATED_DATE <>", value, "CREATED_DATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateGreaterThan(Date value) {
            addCriterion("CREATED_DATE >", value, "CREATED_DATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE >=", value, "CREATED_DATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateLessThan(Date value) {
            addCriterion("CREATED_DATE <", value, "CREATED_DATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE <=", value, "CREATED_DATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateNotLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateLeftLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateNotLeftLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateRightLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateNotRightLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateIn(List<Date> values) {
            addCriterion("CREATED_DATE  in ", values, "CREATED_DATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("CREATED_DATE not in ", values, "CREATED_DATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE between ", value1, value2,
                    "CREATED_DATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE not between ", value1, value2,
                    "CREATED_DATE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneIsNull() {
            addCriterion("TEST_NUMBER_ONE is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneIsNotNull() {
            addCriterion("TEST_NUMBER_ONE is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE =", value, "TEST_NUMBER_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneNotEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE <>", value, "TEST_NUMBER_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneGreaterThan(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE >", value, "TEST_NUMBER_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneGreaterThanOrEqualTo(
                BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE >=", value, "TEST_NUMBER_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneLessThan(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE <", value, "TEST_NUMBER_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE <=", value, "TEST_NUMBER_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE like ", value, "TEST_NUMBER_ONE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneNotLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE  not like ", value,
                    "TEST_NUMBER_ONE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneLeftLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE like ", value, "TEST_NUMBER_ONE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneNotLeftLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE  not like ", value,
                    "TEST_NUMBER_ONE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneRightLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE like ", value, "TEST_NUMBER_ONE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneNotRightLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_ONE  not like ", value,
                    "TEST_NUMBER_ONE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneIn(List<BigDecimal> values) {
            addCriterion("TEST_NUMBER_ONE  in ", values, "TEST_NUMBER_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneNotIn(List<BigDecimal> values) {
            addCriterion("TEST_NUMBER_ONE not in ", values, "TEST_NUMBER_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneBetween(BigDecimal value1,
                BigDecimal value2) {
            addCriterion("TEST_NUMBER_ONE between ", value1, value2,
                    "TEST_NUMBER_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberOneNotBetween(BigDecimal value1,
                BigDecimal value2) {
            addCriterion("TEST_NUMBER_ONE not between ", value1, value2,
                    "TEST_NUMBER_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoIsNull() {
            addCriterion("TEST_NUMBER_TWO is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoIsNotNull() {
            addCriterion("TEST_NUMBER_TWO is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO =", value, "TEST_NUMBER_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoNotEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO <>", value, "TEST_NUMBER_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoGreaterThan(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO >", value, "TEST_NUMBER_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoGreaterThanOrEqualTo(
                BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO >=", value, "TEST_NUMBER_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoLessThan(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO <", value, "TEST_NUMBER_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO <=", value, "TEST_NUMBER_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO like ", value, "TEST_NUMBER_TWO", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoNotLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO  not like ", value,
                    "TEST_NUMBER_TWO", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoLeftLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO like ", value, "TEST_NUMBER_TWO", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoNotLeftLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO  not like ", value,
                    "TEST_NUMBER_TWO", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoRightLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO like ", value, "TEST_NUMBER_TWO", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoNotRightLike(BigDecimal value) {
            addCriterion("TEST_NUMBER_TWO  not like ", value,
                    "TEST_NUMBER_TWO", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoIn(List<BigDecimal> values) {
            addCriterion("TEST_NUMBER_TWO  in ", values, "TEST_NUMBER_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoNotIn(List<BigDecimal> values) {
            addCriterion("TEST_NUMBER_TWO not in ", values, "TEST_NUMBER_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoBetween(BigDecimal value1,
                BigDecimal value2) {
            addCriterion("TEST_NUMBER_TWO between ", value1, value2,
                    "TEST_NUMBER_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestNumberTwoNotBetween(BigDecimal value1,
                BigDecimal value2) {
            addCriterion("TEST_NUMBER_TWO not between ", value1, value2,
                    "TEST_NUMBER_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneIsNull() {
            addCriterion("TEST_DOUBLE_ONE is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneIsNotNull() {
            addCriterion("TEST_DOUBLE_ONE is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_ONE =", value, "TEST_DOUBLE_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneNotEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_ONE <>", value, "TEST_DOUBLE_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneGreaterThan(Double value) {
            addCriterion("TEST_DOUBLE_ONE >", value, "TEST_DOUBLE_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneGreaterThanOrEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_ONE >=", value, "TEST_DOUBLE_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneLessThan(Double value) {
            addCriterion("TEST_DOUBLE_ONE <", value, "TEST_DOUBLE_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneLessThanOrEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_ONE <=", value, "TEST_DOUBLE_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneLike(Double value) {
            addCriterion("TEST_DOUBLE_ONE like ", value, "TEST_DOUBLE_ONE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneNotLike(Double value) {
            addCriterion("TEST_DOUBLE_ONE  not like ", value,
                    "TEST_DOUBLE_ONE", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneLeftLike(Double value) {
            addCriterion("TEST_DOUBLE_ONE like ", value, "TEST_DOUBLE_ONE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneNotLeftLike(Double value) {
            addCriterion("TEST_DOUBLE_ONE  not like ", value,
                    "TEST_DOUBLE_ONE", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneRightLike(Double value) {
            addCriterion("TEST_DOUBLE_ONE like ", value, "TEST_DOUBLE_ONE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneNotRightLike(Double value) {
            addCriterion("TEST_DOUBLE_ONE  not like ", value,
                    "TEST_DOUBLE_ONE", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneIn(List<Double> values) {
            addCriterion("TEST_DOUBLE_ONE  in ", values, "TEST_DOUBLE_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneNotIn(List<Double> values) {
            addCriterion("TEST_DOUBLE_ONE not in ", values, "TEST_DOUBLE_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneBetween(Double value1,
                Double value2) {
            addCriterion("TEST_DOUBLE_ONE between ", value1, value2,
                    "TEST_DOUBLE_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleOneNotBetween(Double value1,
                Double value2) {
            addCriterion("TEST_DOUBLE_ONE not between ", value1, value2,
                    "TEST_DOUBLE_ONE");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoIsNull() {
            addCriterion("TEST_DOUBLE_TWO is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoIsNotNull() {
            addCriterion("TEST_DOUBLE_TWO is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_TWO =", value, "TEST_DOUBLE_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoNotEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_TWO <>", value, "TEST_DOUBLE_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoGreaterThan(Double value) {
            addCriterion("TEST_DOUBLE_TWO >", value, "TEST_DOUBLE_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoGreaterThanOrEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_TWO >=", value, "TEST_DOUBLE_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoLessThan(Double value) {
            addCriterion("TEST_DOUBLE_TWO <", value, "TEST_DOUBLE_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoLessThanOrEqualTo(Double value) {
            addCriterion("TEST_DOUBLE_TWO <=", value, "TEST_DOUBLE_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoLike(Double value) {
            addCriterion("TEST_DOUBLE_TWO like ", value, "TEST_DOUBLE_TWO", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoNotLike(Double value) {
            addCriterion("TEST_DOUBLE_TWO  not like ", value,
                    "TEST_DOUBLE_TWO", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoLeftLike(Double value) {
            addCriterion("TEST_DOUBLE_TWO like ", value, "TEST_DOUBLE_TWO", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoNotLeftLike(Double value) {
            addCriterion("TEST_DOUBLE_TWO  not like ", value,
                    "TEST_DOUBLE_TWO", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoRightLike(Double value) {
            addCriterion("TEST_DOUBLE_TWO like ", value, "TEST_DOUBLE_TWO", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoNotRightLike(Double value) {
            addCriterion("TEST_DOUBLE_TWO  not like ", value,
                    "TEST_DOUBLE_TWO", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoIn(List<Double> values) {
            addCriterion("TEST_DOUBLE_TWO  in ", values, "TEST_DOUBLE_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoNotIn(List<Double> values) {
            addCriterion("TEST_DOUBLE_TWO not in ", values, "TEST_DOUBLE_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoBetween(Double value1,
                Double value2) {
            addCriterion("TEST_DOUBLE_TWO between ", value1, value2,
                    "TEST_DOUBLE_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestDoubleTwoNotBetween(Double value1,
                Double value2) {
            addCriterion("TEST_DOUBLE_TWO not between ", value1, value2,
                    "TEST_DOUBLE_TWO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoIsNull() {
            addCriterion("PHOTO is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoIsNotNull() {
            addCriterion("PHOTO is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoEqualTo(byte[] value) {
            addCriterion("PHOTO =", value, "PHOTO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoNotEqualTo(byte[] value) {
            addCriterion("PHOTO <>", value, "PHOTO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoGreaterThan(byte[] value) {
            addCriterion("PHOTO >", value, "PHOTO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoGreaterThanOrEqualTo(byte[] value) {
            addCriterion("PHOTO >=", value, "PHOTO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoLessThan(byte[] value) {
            addCriterion("PHOTO <", value, "PHOTO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoLessThanOrEqualTo(byte[] value) {
            addCriterion("PHOTO <=", value, "PHOTO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoLike(byte[] value) {
            addCriterion("PHOTO like ", value, "PHOTO", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoNotLike(byte[] value) {
            addCriterion("PHOTO  not like ", value, "PHOTO", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoLeftLike(byte[] value) {
            addCriterion("PHOTO like ", value, "PHOTO", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoNotLeftLike(byte[] value) {
            addCriterion("PHOTO  not like ", value, "PHOTO", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoRightLike(byte[] value) {
            addCriterion("PHOTO like ", value, "PHOTO", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoNotRightLike(byte[] value) {
            addCriterion("PHOTO  not like ", value, "PHOTO", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoIn(List<byte[]> values) {
            addCriterion("PHOTO  in ", values, "PHOTO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoNotIn(List<byte[]> values) {
            addCriterion("PHOTO not in ", values, "PHOTO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoBetween(byte[] value1, byte[] value2) {
            addCriterion("PHOTO between ", value1, value2, "PHOTO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andPhotoNotBetween(byte[] value1, byte[] value2) {
            addCriterion("PHOTO not between ", value1, value2, "PHOTO");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextIsNull() {
            addCriterion("TEST_TEXT is null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextIsNotNull() {
            addCriterion("TEST_TEXT is not null");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextEqualTo(String value) {
            addCriterion("TEST_TEXT =", value, "TEST_TEXT");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextNotEqualTo(String value) {
            addCriterion("TEST_TEXT <>", value, "TEST_TEXT");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextGreaterThan(String value) {
            addCriterion("TEST_TEXT >", value, "TEST_TEXT");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_TEXT >=", value, "TEST_TEXT");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextLessThan(String value) {
            addCriterion("TEST_TEXT <", value, "TEST_TEXT");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextLessThanOrEqualTo(String value) {
            addCriterion("TEST_TEXT <=", value, "TEST_TEXT");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextLike(String value) {
            addCriterion("TEST_TEXT like ", value, "TEST_TEXT", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextNotLike(String value) {
            addCriterion("TEST_TEXT  not like ", value, "TEST_TEXT", 1);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextLeftLike(String value) {
            addCriterion("TEST_TEXT like ", value, "TEST_TEXT", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextNotLeftLike(String value) {
            addCriterion("TEST_TEXT  not like ", value, "TEST_TEXT", 0);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextRightLike(String value) {
            addCriterion("TEST_TEXT like ", value, "TEST_TEXT", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextNotRightLike(String value) {
            addCriterion("TEST_TEXT  not like ", value, "TEST_TEXT", 2);
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextIn(List<String> values) {
            addCriterion("TEST_TEXT  in ", values, "TEST_TEXT");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextNotIn(List<String> values) {
            addCriterion("TEST_TEXT not in ", values, "TEST_TEXT");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextBetween(String value1, String value2) {
            addCriterion("TEST_TEXT between ", value1, value2, "TEST_TEXT");
            return (AmUserCriteria) this;
        }

        public AmUserCriteria andTestTextNotBetween(String value1, String value2) {
            addCriterion("TEST_TEXT not between ", value1, value2, "TEST_TEXT");
            return (AmUserCriteria) this;
        }

    }

    public static class AmUserCriteria extends GeneratedCriteria {

        protected AmUserCriteria() {
            super();
        }
    }

    public static class AmUserCriterion {
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

        protected AmUserCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected AmUserCriterion(String condition, Object value, int likeType) {
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

        protected AmUserCriterion(String condition, Object value,
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

        protected AmUserCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected AmUserCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected AmUserCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}