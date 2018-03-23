package com.example.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by libao on 2018/3/22.
 */

@Entity(nameInDb = "infor_animal")
public class Animal {

    @NotNull
    @Property(nameInDb = "NAME")
    private String name;
    @Property(nameInDb = "AGE")
    private String age;
    @Generated(hash = 286846991)
    public Animal(@NotNull String name, String age) {
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 308569294)
    public Animal() {
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
}
