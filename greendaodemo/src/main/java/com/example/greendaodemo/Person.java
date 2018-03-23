package com.example.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by libao on 2018/3/22.
 */
@Entity(nameInDb = "infor_person")
public class Person {

    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "NAME")
    @NotNull
    private String name;
    @Property(nameInDb = "AGE")
    private String age;
    @Property(nameInDb = "ADDRESS")
    private String address;
    @Property(nameInDb = "SEX")
    private String sex;
    @Generated(hash = 851508379)
    public Person(Long id, @NotNull String name, String age, String address,
            String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.sex = sex;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }


}
