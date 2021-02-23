package com.wangbo.table2word.controller;

import com.wangbo.table2word.service.CreateService;
import com.wangbo.table2word.http.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author WangBo
 * @since 2020/1/6 17:22
 **/
@RestController
@RequestMapping("/test")
public class CreateController {

    @Autowired
    CreateService createService;

    @Value("${database}")
    private String dataName;

    @PostConstruct
    public void init() {
        createService.getTableInfo(dataName);
    }

    @RequestMapping("/demo")
    public R generate() {
        createService.getTableInfo(dataName);
        return R.ok();
    }

}
