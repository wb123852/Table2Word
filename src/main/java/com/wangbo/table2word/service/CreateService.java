package com.wangbo.table2word.service;

import com.wangbo.table2word.mapper.QueryMapper;
import com.wangbo.table2word.domain.Tables;
import com.wangbo.table2word.util.DateToWordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangBo
 * @since 2020/1/6 17:22
 **/
@Service
public class CreateService {

    @Autowired
    QueryMapper queryMapper;

    @Autowired
    DateToWordUtil dateToWordUtil;

    public void getTableInfo(String dataName) {
        List<Tables> tables = queryMapper.getAllTables(dataName);
        dateToWordUtil.toWord(tables);
    }
}
