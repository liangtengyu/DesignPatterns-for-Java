package com.lty.entity;



/**
 * @Author: lty
 * @Date: 2021/1/20 09:55
 */
public class Entity {
    private int id;
    private String name;
    private String jsonData;
    private ReferenceData referenceData;

    public ReferenceData getReferenceData() {
        return referenceData;
    }

    public Entity setReferenceData(ReferenceData referenceData) {
        this.referenceData = referenceData;
        return this;
    }

    public int getId() {
        return id;
    }

    public Entity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Entity setName(String name) {
        this.name = name;
        return this;
    }

    public String getJsonData() {
        return jsonData;
    }

    public Entity setJsonData(String jsonData) {
        this.jsonData = jsonData;
        return this;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jsonData='" + jsonData + '\'' +
                ", referenceData=" + referenceData +
                '}';
    }
}
