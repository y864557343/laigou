package com.yjf.laigou.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andtitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andtitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andtitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andtitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andtitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andtitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andoriginal_PriceIsNull() {
            addCriterion("original_Price is null");
            return (Criteria) this;
        }

        public Criteria andoriginal_PriceIsNotNull() {
            addCriterion("original_Price is not null");
            return (Criteria) this;
        }

        public Criteria andoriginal_PriceEqualTo(Float value) {
            addCriterion("original_Price =", value, "original_Price");
            return (Criteria) this;
        }

        public Criteria andoriginal_PriceNotEqualTo(Float value) {
            addCriterion("original_Price <>", value, "original_Price");
            return (Criteria) this;
        }

        public Criteria andoriginal_PriceGreaterThan(Float value) {
            addCriterion("original_Price >", value, "original_Price");
            return (Criteria) this;
        }

        public Criteria andoriginal_PriceGreaterThanOrEqualTo(Float value) {
            addCriterion("original_Price >=", value, "original_Price");
            return (Criteria) this;
        }

        public Criteria andoriginal_PriceLessThan(Float value) {
            addCriterion("original_Price <", value, "original_Price");
            return (Criteria) this;
        }

        public Criteria andoriginal_PriceLessThanOrEqualTo(Float value) {
            addCriterion("original_Price <=", value, "original_Price");
            return (Criteria) this;
        }

        public Criteria andoriginal_PriceIn(List<Float> values) {
            addCriterion("original_Price in", values, "original_Price");
            return (Criteria) this;
        }

        public Criteria andoriginal_PriceNotIn(List<Float> values) {
            addCriterion("original_Price not in", values, "original_Price");
            return (Criteria) this;
        }

        public Criteria andoriginal_PriceBetween(Float value1, Float value2) {
            addCriterion("original_Price between", value1, value2, "original_Price");
            return (Criteria) this;
        }

        public Criteria andoriginal_PriceNotBetween(Float value1, Float value2) {
            addCriterion("original_Price not between", value1, value2, "original_Price");
            return (Criteria) this;
        }

        public Criteria andpromote_PriceIsNull() {
            addCriterion("promote_Price is null");
            return (Criteria) this;
        }

        public Criteria andpromote_PriceIsNotNull() {
            addCriterion("promote_Price is not null");
            return (Criteria) this;
        }

        public Criteria andpromote_PriceEqualTo(Float value) {
            addCriterion("promote_Price =", value, "promote_Price");
            return (Criteria) this;
        }

        public Criteria andpromote_PriceNotEqualTo(Float value) {
            addCriterion("promote_Price <>", value, "promote_Price");
            return (Criteria) this;
        }

        public Criteria andpromote_PriceGreaterThan(Float value) {
            addCriterion("promote_Price >", value, "promote_Price");
            return (Criteria) this;
        }

        public Criteria andpromote_PriceGreaterThanOrEqualTo(Float value) {
            addCriterion("promote_Price >=", value, "promote_Price");
            return (Criteria) this;
        }

        public Criteria andpromote_PriceLessThan(Float value) {
            addCriterion("promote_Price <", value, "promote_Price");
            return (Criteria) this;
        }

        public Criteria andpromote_PriceLessThanOrEqualTo(Float value) {
            addCriterion("promote_Price <=", value, "promote_Price");
            return (Criteria) this;
        }

        public Criteria andpromote_PriceIn(List<Float> values) {
            addCriterion("promote_Price in", values, "promote_Price");
            return (Criteria) this;
        }

        public Criteria andpromote_PriceNotIn(List<Float> values) {
            addCriterion("promote_Price not in", values, "promote_Price");
            return (Criteria) this;
        }

        public Criteria andpromote_PriceBetween(Float value1, Float value2) {
            addCriterion("promote_Price between", value1, value2, "promote_Price");
            return (Criteria) this;
        }

        public Criteria andpromote_PriceNotBetween(Float value1, Float value2) {
            addCriterion("promote_Price not between", value1, value2, "promote_Price");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andcreate_DateIsNull() {
            addCriterion("create_Date is null");
            return (Criteria) this;
        }

        public Criteria andcreate_DateIsNotNull() {
            addCriterion("create_Date is not null");
            return (Criteria) this;
        }

        public Criteria andcreate_DateEqualTo(Date value) {
            addCriterion("create_Date =", value, "create_Date");
            return (Criteria) this;
        }

        public Criteria andcreate_DateNotEqualTo(Date value) {
            addCriterion("create_Date <>", value, "create_Date");
            return (Criteria) this;
        }

        public Criteria andcreate_DateGreaterThan(Date value) {
            addCriterion("create_Date >", value, "create_Date");
            return (Criteria) this;
        }

        public Criteria andcreate_DateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_Date >=", value, "create_Date");
            return (Criteria) this;
        }

        public Criteria andcreate_DateLessThan(Date value) {
            addCriterion("create_Date <", value, "create_Date");
            return (Criteria) this;
        }

        public Criteria andcreate_DateLessThanOrEqualTo(Date value) {
            addCriterion("create_Date <=", value, "create_Date");
            return (Criteria) this;
        }

        public Criteria andcreate_DateIn(List<Date> values) {
            addCriterion("create_Date in", values, "create_Date");
            return (Criteria) this;
        }

        public Criteria andcreate_DateNotIn(List<Date> values) {
            addCriterion("create_Date not in", values, "create_Date");
            return (Criteria) this;
        }

        public Criteria andcreate_DateBetween(Date value1, Date value2) {
            addCriterion("create_Date between", value1, value2, "create_Date");
            return (Criteria) this;
        }

        public Criteria andcreate_DateNotBetween(Date value1, Date value2) {
            addCriterion("create_Date not between", value1, value2, "create_Date");
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
