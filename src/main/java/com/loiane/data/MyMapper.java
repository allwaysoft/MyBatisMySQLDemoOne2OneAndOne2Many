package com.loiane.data;



import org.apache.ibatis.annotations.Select;

public interface MyMapper {

    @Select("SELECT VERSION()")
    public String getMySQLVersion();
}
