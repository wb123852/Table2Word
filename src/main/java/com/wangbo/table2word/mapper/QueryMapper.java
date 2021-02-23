package com.wangbo.table2word.mapper;

import com.wangbo.table2word.domain.TableFileds;
import com.wangbo.table2word.domain.Tables;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WangBo
 * @since 2020/1/6 17:22
 **/
@Mapper
public interface QueryMapper {

    @Select("select table_name as name, table_comment as comment from information_schema.tables where table_schema = #{dataName} order by table_name")
    List<Tables> getAllTables(@Param("dataName") String dataName);

    @Select("SHOW FULL FIELDS FROM ${tableName}")
    List<TableFileds> getTable(@Param("tableName") String tableName);

}
