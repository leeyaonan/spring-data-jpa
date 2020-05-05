package com.leeyaonan.pojo;

import javax.persistence.*;

/**
 * 简历实体类，
 * 1. 在类中要使用注解建立实力类与数据表之间的映射关系， -> @Entity, @Table
 * 2. 以及属性和字段的映射关系 -> @Id标识主键,@Generate标识主键的生成策略,@Colume建立属性和字段的映射
 * @Author leeyaonan
 * @Date 2020/5/4 23:21
 */
@Entity
@Table(name = "resume")
public class Resume {

    @Id
    /**
     * 生成策略经常使用的两种：
     * GenerationType.IDENTITY:依赖数据库中主键自增功能  Mysql
     * GenerationType.SEQUENCE:依靠序列来产生逐渐 Oracle
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
