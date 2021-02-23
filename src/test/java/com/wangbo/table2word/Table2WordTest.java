package com.wangbo.table2word;

import com.wangbo.table2word.service.CreateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author WangBo
 * @date 2020/01/07 13:50
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Table2WordTest {

    @Autowired
    CreateService createService;

    @Value("${database}")
    private String dataName;

    @Test
    public void test() {
        createService.getTableInfo(dataName);
    }
}
