package ru.otus.mybatis;

import org.apache.ibatis.jdbc.SQL;

public class CityQueries {

    public String findCityByCountry(final String country) {
        return new SQL() {
            {
                SELECT("*");
                FROM("city");
                if (country != null) WHERE("country = #{country}");
                ORDER_BY("name");
            }
        }.toString();
    }
/*
    public String findCityByCountry(final String country) {
        return new SQL()
                .SELECT("*")
                .FROM("city")
                .WHERE("country = #{country}")
                .ORDER_BY("name")
                .toString();
    }
*/
}
