package com.example.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insert(View view){
        PersonDaoUtil personDaoUtil=new PersonDaoUtil(this);

        List<Person> personList=new ArrayList<>();
        Person person=new Person(1l,"123qwe","28","上海","男");
        Person person2=new Person(2l,"456rty","28","上海","男");

        personList.add(person);
        personList.add(person2);

//        personDaoUtil.insertPerson(person);

        personDaoUtil.updateMult(personList);

    }
}
