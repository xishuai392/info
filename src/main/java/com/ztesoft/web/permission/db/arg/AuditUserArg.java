package com.ztesoft.web.permission.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class AuditUserArg {
    private String pk_name = "USER_ID";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<AuditUserCriteria> oredCriteria;

    public AuditUserArg() {
        oredCriteria = new ArrayList<AuditUserCriteria>();
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

    public List<AuditUserCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(AuditUserCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public AuditUserCriteria or() {
    	AuditUserCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AuditUserCriteria createCriteria() {
    	AuditUserCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AuditUserCriteria createCriteriaInternal() {
    	AuditUserCriteria criteria = new AuditUserCriteria();
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
        protected List<AuditUserCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<AuditUserCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<AuditUserCriterion> getAllCriteria() {
            return criteria;
        }

        public List<AuditUserCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new AuditUserCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditUserCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditUserCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new AuditUserCriterion(condition, value1, value2));
        }

        public AuditUserCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (AuditUserCriteria) this;
        }
        public AuditUserCriteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "USER_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "USER_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "USER_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "USER_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "USER_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "USER_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdNotLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdLeftLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdNotLeftLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdRightLike(Integer value) {
            addCriterion("USER_ID like ", value, "USER_ID", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdNotRightLike(Integer value) {
            addCriterion("USER_ID  not like ", value, "USER_ID", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID  in ", values, "USER_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in ", values, "USER_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between ", value1, value2, "USER_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between ", value1, value2, "USER_ID");
            return (AuditUserCriteria) this;
        }
        public AuditUserCriteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "USER_NAME");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "USER_NAME");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "USER_NAME");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "USER_NAME");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "USER_NAME");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "USER_NAME");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameLike(String value) {
            addCriterion("USER_NAME like ", value, "USER_NAME", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME  not like ", value, "USER_NAME", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameLeftLike(String value) {
            addCriterion("USER_NAME like ", value, "USER_NAME", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameNotLeftLike(String value) {
            addCriterion("USER_NAME  not like ", value, "USER_NAME", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameRightLike(String value) {
            addCriterion("USER_NAME like ", value, "USER_NAME", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameNotRightLike(String value) {
            addCriterion("USER_NAME  not like ", value, "USER_NAME", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME  in ", values, "USER_NAME");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in ", values, "USER_NAME");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between ", value1, value2, "USER_NAME");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between ", value1, value2, "USER_NAME");
            return (AuditUserCriteria) this;
        }
        public AuditUserCriteria andUserCodeIsNull() {
            addCriterion("USER_CODE is null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeIsNotNull() {
            addCriterion("USER_CODE is not null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeEqualTo(String value) {
            addCriterion("USER_CODE =", value, "USER_CODE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeNotEqualTo(String value) {
            addCriterion("USER_CODE <>", value, "USER_CODE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeGreaterThan(String value) {
            addCriterion("USER_CODE >", value, "USER_CODE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_CODE >=", value, "USER_CODE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeLessThan(String value) {
            addCriterion("USER_CODE <", value, "USER_CODE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeLessThanOrEqualTo(String value) {
            addCriterion("USER_CODE <=", value, "USER_CODE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeLike(String value) {
            addCriterion("USER_CODE like ", value, "USER_CODE", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeNotLike(String value) {
            addCriterion("USER_CODE  not like ", value, "USER_CODE", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeLeftLike(String value) {
            addCriterion("USER_CODE like ", value, "USER_CODE", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeNotLeftLike(String value) {
            addCriterion("USER_CODE  not like ", value, "USER_CODE", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeRightLike(String value) {
            addCriterion("USER_CODE like ", value, "USER_CODE", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeNotRightLike(String value) {
            addCriterion("USER_CODE  not like ", value, "USER_CODE", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeIn(List<String> values) {
            addCriterion("USER_CODE  in ", values, "USER_CODE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeNotIn(List<String> values) {
            addCriterion("USER_CODE not in ", values, "USER_CODE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeBetween(String value1, String value2) {
            addCriterion("USER_CODE between ", value1, value2, "USER_CODE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCodeNotBetween(String value1, String value2) {
            addCriterion("USER_CODE not between ", value1, value2, "USER_CODE");
            return (AuditUserCriteria) this;
        }
        public AuditUserCriteria andTelephoneIsNull() {
            addCriterion("TELEPHONE is null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneIsNotNull() {
            addCriterion("TELEPHONE is not null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneEqualTo(String value) {
            addCriterion("TELEPHONE =", value, "TELEPHONE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneNotEqualTo(String value) {
            addCriterion("TELEPHONE <>", value, "TELEPHONE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneGreaterThan(String value) {
            addCriterion("TELEPHONE >", value, "TELEPHONE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("TELEPHONE >=", value, "TELEPHONE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneLessThan(String value) {
            addCriterion("TELEPHONE <", value, "TELEPHONE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("TELEPHONE <=", value, "TELEPHONE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneLike(String value) {
            addCriterion("TELEPHONE like ", value, "TELEPHONE", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneNotLike(String value) {
            addCriterion("TELEPHONE  not like ", value, "TELEPHONE", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneLeftLike(String value) {
            addCriterion("TELEPHONE like ", value, "TELEPHONE", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneNotLeftLike(String value) {
            addCriterion("TELEPHONE  not like ", value, "TELEPHONE", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneRightLike(String value) {
            addCriterion("TELEPHONE like ", value, "TELEPHONE", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneNotRightLike(String value) {
            addCriterion("TELEPHONE  not like ", value, "TELEPHONE", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneIn(List<String> values) {
            addCriterion("TELEPHONE  in ", values, "TELEPHONE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneNotIn(List<String> values) {
            addCriterion("TELEPHONE not in ", values, "TELEPHONE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneBetween(String value1, String value2) {
            addCriterion("TELEPHONE between ", value1, value2, "TELEPHONE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("TELEPHONE not between ", value1, value2, "TELEPHONE");
            return (AuditUserCriteria) this;
        }
        public AuditUserCriteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "EMAIL");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "EMAIL");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "EMAIL");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "EMAIL");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "EMAIL");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "EMAIL");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailLike(String value) {
            addCriterion("EMAIL like ", value, "EMAIL", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailNotLike(String value) {
            addCriterion("EMAIL  not like ", value, "EMAIL", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailLeftLike(String value) {
            addCriterion("EMAIL like ", value, "EMAIL", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailNotLeftLike(String value) {
            addCriterion("EMAIL  not like ", value, "EMAIL", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailRightLike(String value) {
            addCriterion("EMAIL like ", value, "EMAIL", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailNotRightLike(String value) {
            addCriterion("EMAIL  not like ", value, "EMAIL", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailIn(List<String> values) {
            addCriterion("EMAIL  in ", values, "EMAIL");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in ", values, "EMAIL");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between ", value1, value2, "EMAIL");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between ", value1, value2, "EMAIL");
            return (AuditUserCriteria) this;
        }
        public AuditUserCriteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "PASSWORD");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "PASSWORD");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "PASSWORD");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "PASSWORD");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "PASSWORD");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "PASSWORD");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordLike(String value) {
            addCriterion("PASSWORD like ", value, "PASSWORD", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD  not like ", value, "PASSWORD", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordLeftLike(String value) {
            addCriterion("PASSWORD like ", value, "PASSWORD", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordNotLeftLike(String value) {
            addCriterion("PASSWORD  not like ", value, "PASSWORD", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordRightLike(String value) {
            addCriterion("PASSWORD like ", value, "PASSWORD", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordNotRightLike(String value) {
            addCriterion("PASSWORD  not like ", value, "PASSWORD", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD  in ", values, "PASSWORD");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in ", values, "PASSWORD");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between ", value1, value2, "PASSWORD");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between ", value1, value2, "PASSWORD");
            return (AuditUserCriteria) this;
        }
        public AuditUserCriteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeEqualTo(Integer value) {
            addCriterion("AGE =", value, "AGE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeNotEqualTo(Integer value) {
            addCriterion("AGE <>", value, "AGE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeGreaterThan(Integer value) {
            addCriterion("AGE >", value, "AGE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AGE >=", value, "AGE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeLessThan(Integer value) {
            addCriterion("AGE <", value, "AGE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("AGE <=", value, "AGE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeLike(Integer value) {
            addCriterion("AGE like ", value, "AGE", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeNotLike(Integer value) {
            addCriterion("AGE  not like ", value, "AGE", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeLeftLike(Integer value) {
            addCriterion("AGE like ", value, "AGE", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeNotLeftLike(Integer value) {
            addCriterion("AGE  not like ", value, "AGE", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeRightLike(Integer value) {
            addCriterion("AGE like ", value, "AGE", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeNotRightLike(Integer value) {
            addCriterion("AGE  not like ", value, "AGE", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeIn(List<Integer> values) {
            addCriterion("AGE  in ", values, "AGE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeNotIn(List<Integer> values) {
            addCriterion("AGE not in ", values, "AGE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("AGE between ", value1, value2, "AGE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("AGE not between ", value1, value2, "AGE");
            return (AuditUserCriteria) this;
        }
        public AuditUserCriteria andStateIsNull() {
            addCriterion("STATE is null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "STATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "STATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "STATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "STATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "STATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "STATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateLike(String value) {
            addCriterion("STATE like ", value, "STATE", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateNotLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateLeftLike(String value) {
            addCriterion("STATE like ", value, "STATE", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateNotLeftLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateRightLike(String value) {
            addCriterion("STATE like ", value, "STATE", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateNotRightLike(String value) {
            addCriterion("STATE  not like ", value, "STATE", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateIn(List<String> values) {
            addCriterion("STATE  in ", values, "STATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in ", values, "STATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between ", value1, value2, "STATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between ", value1, value2, "STATE");
            return (AuditUserCriteria) this;
        }
        public AuditUserCriteria andCreatedDateIsNull() {
            addCriterion("CREATED_DATE is null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateIsNotNull() {
            addCriterion("CREATED_DATE is not null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateEqualTo(Date value) {
            addCriterion("CREATED_DATE =", value, "CREATED_DATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("CREATED_DATE <>", value, "CREATED_DATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateGreaterThan(Date value) {
            addCriterion("CREATED_DATE >", value, "CREATED_DATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE >=", value, "CREATED_DATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateLessThan(Date value) {
            addCriterion("CREATED_DATE <", value, "CREATED_DATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE <=", value, "CREATED_DATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateNotLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateLeftLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateNotLeftLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateRightLike(Date value) {
            addCriterion("CREATED_DATE like ", value, "CREATED_DATE", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateNotRightLike(Date value) {
            addCriterion("CREATED_DATE  not like ", value, "CREATED_DATE", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateIn(List<Date> values) {
            addCriterion("CREATED_DATE  in ", values, "CREATED_DATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("CREATED_DATE not in ", values, "CREATED_DATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE between ", value1, value2, "CREATED_DATE");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE not between ", value1, value2, "CREATED_DATE");
            return (AuditUserCriteria) this;
        }
        public AuditUserCriteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdEqualTo(Long value) {
            addCriterion("ORG_ID =", value, "ORG_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdNotEqualTo(Long value) {
            addCriterion("ORG_ID <>", value, "ORG_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdGreaterThan(Long value) {
            addCriterion("ORG_ID >", value, "ORG_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORG_ID >=", value, "ORG_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdLessThan(Long value) {
            addCriterion("ORG_ID <", value, "ORG_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("ORG_ID <=", value, "ORG_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdLike(Long value) {
            addCriterion("ORG_ID like ", value, "ORG_ID", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdNotLike(Long value) {
            addCriterion("ORG_ID  not like ", value, "ORG_ID", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdLeftLike(Long value) {
            addCriterion("ORG_ID like ", value, "ORG_ID", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdNotLeftLike(Long value) {
            addCriterion("ORG_ID  not like ", value, "ORG_ID", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdRightLike(Long value) {
            addCriterion("ORG_ID like ", value, "ORG_ID", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdNotRightLike(Long value) {
            addCriterion("ORG_ID  not like ", value, "ORG_ID", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdIn(List<Long> values) {
            addCriterion("ORG_ID  in ", values, "ORG_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdNotIn(List<Long> values) {
            addCriterion("ORG_ID not in ", values, "ORG_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdBetween(Long value1, Long value2) {
            addCriterion("ORG_ID between ", value1, value2, "ORG_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("ORG_ID not between ", value1, value2, "ORG_ID");
            return (AuditUserCriteria) this;
        }
        public AuditUserCriteria andUserCardIdIsNull() {
            addCriterion("USER_CARD_ID is null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdIsNotNull() {
            addCriterion("USER_CARD_ID is not null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdEqualTo(String value) {
            addCriterion("USER_CARD_ID =", value, "USER_CARD_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdNotEqualTo(String value) {
            addCriterion("USER_CARD_ID <>", value, "USER_CARD_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdGreaterThan(String value) {
            addCriterion("USER_CARD_ID >", value, "USER_CARD_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_CARD_ID >=", value, "USER_CARD_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdLessThan(String value) {
            addCriterion("USER_CARD_ID <", value, "USER_CARD_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdLessThanOrEqualTo(String value) {
            addCriterion("USER_CARD_ID <=", value, "USER_CARD_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdLike(String value) {
            addCriterion("USER_CARD_ID like ", value, "USER_CARD_ID", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdNotLike(String value) {
            addCriterion("USER_CARD_ID  not like ", value, "USER_CARD_ID", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdLeftLike(String value) {
            addCriterion("USER_CARD_ID like ", value, "USER_CARD_ID", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdNotLeftLike(String value) {
            addCriterion("USER_CARD_ID  not like ", value, "USER_CARD_ID", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdRightLike(String value) {
            addCriterion("USER_CARD_ID like ", value, "USER_CARD_ID", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdNotRightLike(String value) {
            addCriterion("USER_CARD_ID  not like ", value, "USER_CARD_ID", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdIn(List<String> values) {
            addCriterion("USER_CARD_ID  in ", values, "USER_CARD_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdNotIn(List<String> values) {
            addCriterion("USER_CARD_ID not in ", values, "USER_CARD_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdBetween(String value1, String value2) {
            addCriterion("USER_CARD_ID between ", value1, value2, "USER_CARD_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserCardIdNotBetween(String value1, String value2) {
            addCriterion("USER_CARD_ID not between ", value1, value2, "USER_CARD_ID");
            return (AuditUserCriteria) this;
        }
        public AuditUserCriteria andUserPkiIdIsNull() {
            addCriterion("USER_PKI_ID is null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdIsNotNull() {
            addCriterion("USER_PKI_ID is not null");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdEqualTo(String value) {
            addCriterion("USER_PKI_ID =", value, "USER_PKI_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdNotEqualTo(String value) {
            addCriterion("USER_PKI_ID <>", value, "USER_PKI_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdGreaterThan(String value) {
            addCriterion("USER_PKI_ID >", value, "USER_PKI_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PKI_ID >=", value, "USER_PKI_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdLessThan(String value) {
            addCriterion("USER_PKI_ID <", value, "USER_PKI_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdLessThanOrEqualTo(String value) {
            addCriterion("USER_PKI_ID <=", value, "USER_PKI_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdLike(String value) {
            addCriterion("USER_PKI_ID like ", value, "USER_PKI_ID", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdNotLike(String value) {
            addCriterion("USER_PKI_ID  not like ", value, "USER_PKI_ID", 1);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdLeftLike(String value) {
            addCriterion("USER_PKI_ID like ", value, "USER_PKI_ID", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdNotLeftLike(String value) {
            addCriterion("USER_PKI_ID  not like ", value, "USER_PKI_ID", 0);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdRightLike(String value) {
            addCriterion("USER_PKI_ID like ", value, "USER_PKI_ID", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdNotRightLike(String value) {
            addCriterion("USER_PKI_ID  not like ", value, "USER_PKI_ID", 2);
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdIn(List<String> values) {
            addCriterion("USER_PKI_ID  in ", values, "USER_PKI_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdNotIn(List<String> values) {
            addCriterion("USER_PKI_ID not in ", values, "USER_PKI_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdBetween(String value1, String value2) {
            addCriterion("USER_PKI_ID between ", value1, value2, "USER_PKI_ID");
            return (AuditUserCriteria) this;
        }

        public AuditUserCriteria andUserPkiIdNotBetween(String value1, String value2) {
            addCriterion("USER_PKI_ID not between ", value1, value2, "USER_PKI_ID");
            return (AuditUserCriteria) this;
        }

    }

    public static class AuditUserCriteria extends GeneratedCriteria {

        protected AuditUserCriteria() {
            super();
        }
    }

    public static class AuditUserCriterion {
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

        protected AuditUserCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected AuditUserCriterion(String condition, Object value, int likeType) {
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

        protected AuditUserCriterion(String condition, Object value,
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

        protected AuditUserCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected AuditUserCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected AuditUserCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}