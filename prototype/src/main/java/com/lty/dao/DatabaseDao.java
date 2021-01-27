package com.lty.dao;

import com.lty.entity.Entity;
import com.lty.entity.ReferenceData;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2021/1/20 09:55
 */
public  class DatabaseDao {
    //模拟数据库获取数据操作
    public static List<Entity> getList() {

        List<Entity> entityList = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            entityList.add(new Entity()
                    .setName("name" + i)
                    .setId(i)
                    .setJsonData("{'key':'value'}")
                    .setReferenceData(new ReferenceData("dataname",i+""))
            );
        }
        return entityList;
    }

}
