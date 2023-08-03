package com.incomeBank.ws.rest.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

@Data
public class Filter {

    private String property;
    private String value;
    private Operator operator;

    public enum Operator {
        _EQUAL("equal"),
        EQUAL("eq"),
        NOT_EQUAL("neq"),
        LIKE("like"),
        BETWEEN("between"),
        AFTER("after"),
        BEFORE("before"),
        IN("in"),
        NOT_IN("nin"),
        GREATER_THAN_OR_EQUAL("gte"),
        LESS_THAN_OR_EQUAL("lte"),
        GREATER_THAN("gt"),
        LESS_THAN("lt"),
        IS_NULL("isn"),
        IS_NOT_NULL("inn"),
        MAX("max"),
        LIKE_CASE_INSENSITIVE("lci");

        private String name;

        Operator(String name) {
            this.name = name;
        }

        @JsonCreator
        public static Operator fromString(String value) {
            return getValue(value);
        }

        @JsonValue
        public String fromObject(Operator operator) {
            return operator.name;
        }

        public static Operator getValue(String value) {
            for (Operator operator : Operator.values()) {
                if (operator.name.equalsIgnoreCase(value))
                    return operator;
            }
            return null;
        }
    }
}
