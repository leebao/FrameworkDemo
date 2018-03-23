package com.example.greendaodemo;

import android.content.Context;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by libao on 2018/3/22.
 */

public class PersonDaoUtil {

    private DBManager dbManager;

    public PersonDaoUtil(Context context) {
        dbManager = DBManager.getInstance();
        dbManager.init(context);
    }

    /**
     * 插入一条数据
     *
     * @param person
     * @return
     */
    public boolean insertPerson(Person person) {
        boolean flag = false;
        flag = dbManager.getDaoSession().getPersonDao().insert(person) != -1;
        return flag;
    }

    /**
     * 插入多条数据
     *
     * @param persons
     * @return
     */
    public void insertMultPerson(List<Person> persons) {
        dbManager.getDaoSession().getPersonDao().insertOrReplaceInTx(persons);
    }

    /**
     * 修改数据
     */
    public void updatePerson(Person person) {
        dbManager.getDaoSession().getPersonDao().update(person);
    }

    /**
     * 批量修改数据
     */
    public void updateMult(List<Person> personList) {
        try {
            DaoSession daoSession = dbManager.getDaoSession();
            dbManager.getDatabase().beginTransaction();
            daoSession.getPersonDao().updateInTx(personList);
            dbManager.getDatabase().setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            dbManager.getDatabase().endTransaction();
        }
    }


}
