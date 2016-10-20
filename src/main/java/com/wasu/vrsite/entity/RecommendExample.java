package com.wasu.vrsite.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecommendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecommendExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andPoster1IsNull() {
            addCriterion("poster1 is null");
            return (Criteria) this;
        }

        public Criteria andPoster1IsNotNull() {
            addCriterion("poster1 is not null");
            return (Criteria) this;
        }

        public Criteria andPoster1EqualTo(String value) {
            addCriterion("poster1 =", value, "poster1");
            return (Criteria) this;
        }

        public Criteria andPoster1NotEqualTo(String value) {
            addCriterion("poster1 <>", value, "poster1");
            return (Criteria) this;
        }

        public Criteria andPoster1GreaterThan(String value) {
            addCriterion("poster1 >", value, "poster1");
            return (Criteria) this;
        }

        public Criteria andPoster1GreaterThanOrEqualTo(String value) {
            addCriterion("poster1 >=", value, "poster1");
            return (Criteria) this;
        }

        public Criteria andPoster1LessThan(String value) {
            addCriterion("poster1 <", value, "poster1");
            return (Criteria) this;
        }

        public Criteria andPoster1LessThanOrEqualTo(String value) {
            addCriterion("poster1 <=", value, "poster1");
            return (Criteria) this;
        }

        public Criteria andPoster1Like(String value) {
            addCriterion("poster1 like", value, "poster1");
            return (Criteria) this;
        }

        public Criteria andPoster1NotLike(String value) {
            addCriterion("poster1 not like", value, "poster1");
            return (Criteria) this;
        }

        public Criteria andPoster1In(List<String> values) {
            addCriterion("poster1 in", values, "poster1");
            return (Criteria) this;
        }

        public Criteria andPoster1NotIn(List<String> values) {
            addCriterion("poster1 not in", values, "poster1");
            return (Criteria) this;
        }

        public Criteria andPoster1Between(String value1, String value2) {
            addCriterion("poster1 between", value1, value2, "poster1");
            return (Criteria) this;
        }

        public Criteria andPoster1NotBetween(String value1, String value2) {
            addCriterion("poster1 not between", value1, value2, "poster1");
            return (Criteria) this;
        }

        public Criteria andPoster2IsNull() {
            addCriterion("poster2 is null");
            return (Criteria) this;
        }

        public Criteria andPoster2IsNotNull() {
            addCriterion("poster2 is not null");
            return (Criteria) this;
        }

        public Criteria andPoster2EqualTo(String value) {
            addCriterion("poster2 =", value, "poster2");
            return (Criteria) this;
        }

        public Criteria andPoster2NotEqualTo(String value) {
            addCriterion("poster2 <>", value, "poster2");
            return (Criteria) this;
        }

        public Criteria andPoster2GreaterThan(String value) {
            addCriterion("poster2 >", value, "poster2");
            return (Criteria) this;
        }

        public Criteria andPoster2GreaterThanOrEqualTo(String value) {
            addCriterion("poster2 >=", value, "poster2");
            return (Criteria) this;
        }

        public Criteria andPoster2LessThan(String value) {
            addCriterion("poster2 <", value, "poster2");
            return (Criteria) this;
        }

        public Criteria andPoster2LessThanOrEqualTo(String value) {
            addCriterion("poster2 <=", value, "poster2");
            return (Criteria) this;
        }

        public Criteria andPoster2Like(String value) {
            addCriterion("poster2 like", value, "poster2");
            return (Criteria) this;
        }

        public Criteria andPoster2NotLike(String value) {
            addCriterion("poster2 not like", value, "poster2");
            return (Criteria) this;
        }

        public Criteria andPoster2In(List<String> values) {
            addCriterion("poster2 in", values, "poster2");
            return (Criteria) this;
        }

        public Criteria andPoster2NotIn(List<String> values) {
            addCriterion("poster2 not in", values, "poster2");
            return (Criteria) this;
        }

        public Criteria andPoster2Between(String value1, String value2) {
            addCriterion("poster2 between", value1, value2, "poster2");
            return (Criteria) this;
        }

        public Criteria andPoster2NotBetween(String value1, String value2) {
            addCriterion("poster2 not between", value1, value2, "poster2");
            return (Criteria) this;
        }

        public Criteria andPoster3IsNull() {
            addCriterion("poster3 is null");
            return (Criteria) this;
        }

        public Criteria andPoster3IsNotNull() {
            addCriterion("poster3 is not null");
            return (Criteria) this;
        }

        public Criteria andPoster3EqualTo(String value) {
            addCriterion("poster3 =", value, "poster3");
            return (Criteria) this;
        }

        public Criteria andPoster3NotEqualTo(String value) {
            addCriterion("poster3 <>", value, "poster3");
            return (Criteria) this;
        }

        public Criteria andPoster3GreaterThan(String value) {
            addCriterion("poster3 >", value, "poster3");
            return (Criteria) this;
        }

        public Criteria andPoster3GreaterThanOrEqualTo(String value) {
            addCriterion("poster3 >=", value, "poster3");
            return (Criteria) this;
        }

        public Criteria andPoster3LessThan(String value) {
            addCriterion("poster3 <", value, "poster3");
            return (Criteria) this;
        }

        public Criteria andPoster3LessThanOrEqualTo(String value) {
            addCriterion("poster3 <=", value, "poster3");
            return (Criteria) this;
        }

        public Criteria andPoster3Like(String value) {
            addCriterion("poster3 like", value, "poster3");
            return (Criteria) this;
        }

        public Criteria andPoster3NotLike(String value) {
            addCriterion("poster3 not like", value, "poster3");
            return (Criteria) this;
        }

        public Criteria andPoster3In(List<String> values) {
            addCriterion("poster3 in", values, "poster3");
            return (Criteria) this;
        }

        public Criteria andPoster3NotIn(List<String> values) {
            addCriterion("poster3 not in", values, "poster3");
            return (Criteria) this;
        }

        public Criteria andPoster3Between(String value1, String value2) {
            addCriterion("poster3 between", value1, value2, "poster3");
            return (Criteria) this;
        }

        public Criteria andPoster3NotBetween(String value1, String value2) {
            addCriterion("poster3 not between", value1, value2, "poster3");
            return (Criteria) this;
        }

        public Criteria andPoster4IsNull() {
            addCriterion("poster4 is null");
            return (Criteria) this;
        }

        public Criteria andPoster4IsNotNull() {
            addCriterion("poster4 is not null");
            return (Criteria) this;
        }

        public Criteria andPoster4EqualTo(String value) {
            addCriterion("poster4 =", value, "poster4");
            return (Criteria) this;
        }

        public Criteria andPoster4NotEqualTo(String value) {
            addCriterion("poster4 <>", value, "poster4");
            return (Criteria) this;
        }

        public Criteria andPoster4GreaterThan(String value) {
            addCriterion("poster4 >", value, "poster4");
            return (Criteria) this;
        }

        public Criteria andPoster4GreaterThanOrEqualTo(String value) {
            addCriterion("poster4 >=", value, "poster4");
            return (Criteria) this;
        }

        public Criteria andPoster4LessThan(String value) {
            addCriterion("poster4 <", value, "poster4");
            return (Criteria) this;
        }

        public Criteria andPoster4LessThanOrEqualTo(String value) {
            addCriterion("poster4 <=", value, "poster4");
            return (Criteria) this;
        }

        public Criteria andPoster4Like(String value) {
            addCriterion("poster4 like", value, "poster4");
            return (Criteria) this;
        }

        public Criteria andPoster4NotLike(String value) {
            addCriterion("poster4 not like", value, "poster4");
            return (Criteria) this;
        }

        public Criteria andPoster4In(List<String> values) {
            addCriterion("poster4 in", values, "poster4");
            return (Criteria) this;
        }

        public Criteria andPoster4NotIn(List<String> values) {
            addCriterion("poster4 not in", values, "poster4");
            return (Criteria) this;
        }

        public Criteria andPoster4Between(String value1, String value2) {
            addCriterion("poster4 between", value1, value2, "poster4");
            return (Criteria) this;
        }

        public Criteria andPoster4NotBetween(String value1, String value2) {
            addCriterion("poster4 not between", value1, value2, "poster4");
            return (Criteria) this;
        }

        public Criteria andPoster5IsNull() {
            addCriterion("poster5 is null");
            return (Criteria) this;
        }

        public Criteria andPoster5IsNotNull() {
            addCriterion("poster5 is not null");
            return (Criteria) this;
        }

        public Criteria andPoster5EqualTo(String value) {
            addCriterion("poster5 =", value, "poster5");
            return (Criteria) this;
        }

        public Criteria andPoster5NotEqualTo(String value) {
            addCriterion("poster5 <>", value, "poster5");
            return (Criteria) this;
        }

        public Criteria andPoster5GreaterThan(String value) {
            addCriterion("poster5 >", value, "poster5");
            return (Criteria) this;
        }

        public Criteria andPoster5GreaterThanOrEqualTo(String value) {
            addCriterion("poster5 >=", value, "poster5");
            return (Criteria) this;
        }

        public Criteria andPoster5LessThan(String value) {
            addCriterion("poster5 <", value, "poster5");
            return (Criteria) this;
        }

        public Criteria andPoster5LessThanOrEqualTo(String value) {
            addCriterion("poster5 <=", value, "poster5");
            return (Criteria) this;
        }

        public Criteria andPoster5Like(String value) {
            addCriterion("poster5 like", value, "poster5");
            return (Criteria) this;
        }

        public Criteria andPoster5NotLike(String value) {
            addCriterion("poster5 not like", value, "poster5");
            return (Criteria) this;
        }

        public Criteria andPoster5In(List<String> values) {
            addCriterion("poster5 in", values, "poster5");
            return (Criteria) this;
        }

        public Criteria andPoster5NotIn(List<String> values) {
            addCriterion("poster5 not in", values, "poster5");
            return (Criteria) this;
        }

        public Criteria andPoster5Between(String value1, String value2) {
            addCriterion("poster5 between", value1, value2, "poster5");
            return (Criteria) this;
        }

        public Criteria andPoster5NotBetween(String value1, String value2) {
            addCriterion("poster5 not between", value1, value2, "poster5");
            return (Criteria) this;
        }

        public Criteria andPoster6IsNull() {
            addCriterion("poster6 is null");
            return (Criteria) this;
        }

        public Criteria andPoster6IsNotNull() {
            addCriterion("poster6 is not null");
            return (Criteria) this;
        }

        public Criteria andPoster6EqualTo(String value) {
            addCriterion("poster6 =", value, "poster6");
            return (Criteria) this;
        }

        public Criteria andPoster6NotEqualTo(String value) {
            addCriterion("poster6 <>", value, "poster6");
            return (Criteria) this;
        }

        public Criteria andPoster6GreaterThan(String value) {
            addCriterion("poster6 >", value, "poster6");
            return (Criteria) this;
        }

        public Criteria andPoster6GreaterThanOrEqualTo(String value) {
            addCriterion("poster6 >=", value, "poster6");
            return (Criteria) this;
        }

        public Criteria andPoster6LessThan(String value) {
            addCriterion("poster6 <", value, "poster6");
            return (Criteria) this;
        }

        public Criteria andPoster6LessThanOrEqualTo(String value) {
            addCriterion("poster6 <=", value, "poster6");
            return (Criteria) this;
        }

        public Criteria andPoster6Like(String value) {
            addCriterion("poster6 like", value, "poster6");
            return (Criteria) this;
        }

        public Criteria andPoster6NotLike(String value) {
            addCriterion("poster6 not like", value, "poster6");
            return (Criteria) this;
        }

        public Criteria andPoster6In(List<String> values) {
            addCriterion("poster6 in", values, "poster6");
            return (Criteria) this;
        }

        public Criteria andPoster6NotIn(List<String> values) {
            addCriterion("poster6 not in", values, "poster6");
            return (Criteria) this;
        }

        public Criteria andPoster6Between(String value1, String value2) {
            addCriterion("poster6 between", value1, value2, "poster6");
            return (Criteria) this;
        }

        public Criteria andPoster6NotBetween(String value1, String value2) {
            addCriterion("poster6 not between", value1, value2, "poster6");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}