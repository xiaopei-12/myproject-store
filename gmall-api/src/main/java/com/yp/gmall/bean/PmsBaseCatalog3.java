package com.yp.gmall.bean;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * create with IDEA
 *
 * @Auther: yinpei
 * @Date : 2020/07/12/下午 19:44
 *
 * implements Serializable
 *  它的目的只是简单的标识一个类的对象可以被序列化。
 *
 * @Description;
 **/
public class PmsBaseCatalog3 implements Serializable {

    @Id
   private String  id;
    private String  name;
    private String catalog2Id;

    @Override
    public String toString() {
        return "PmsBaseCatalog3{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", catalog2Id='" + catalog2Id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalog2Id() {
        return catalog2Id;
    }

    public void setCatalog2Id(String catalog2Id) {
        this.catalog2Id = catalog2Id;
    }
}
