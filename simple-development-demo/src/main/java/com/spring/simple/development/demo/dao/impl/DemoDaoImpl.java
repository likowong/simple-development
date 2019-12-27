package com.spring.simple.development.demo.dao.impl;

import com.spring.simple.development.demo.dao.DemoDao;
import com.spring.simple.development.demo.mapper.DemoDoMapper;
import com.spring.simple.development.demo.model.DemoDo;
import com.spring.simple.development.demo.model.DemoDoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liko.wang
 * @Date 2019/12/20/020 15:09
 * @Description //TODO
 **/
@Component
public class DemoDaoImpl implements DemoDao {
    @Autowired
    private DemoDoMapper demoDoMapper;

    @Override
    public List<DemoDo> queryList() {
        DemoDoExample demoDoExample = new DemoDoExample();
        List<DemoDo> demoDoList = demoDoMapper.selectByExample(demoDoExample);
        return demoDoList;
    }

    @Override
    public void insertDemoDo(DemoDo demoDo) {
        demoDoMapper.insert(demoDo);
    }
}