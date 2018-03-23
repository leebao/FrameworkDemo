package com.example.greendaodemo;

import android.content.Context;
import android.os.Environment;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.io.File;

/**
 * Created by libao on 2018/3/22.
 */

public class DBManager {

    private static final String TAG = DBManager.class.getSimpleName();
    private static final String DB_NAME = "greendaotest.db";

    private Context context;

    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private  Database database;

    private static DaoMaster.DevOpenHelper devOpenHelper;

    private static DBManager dbManger = new DBManager();

    public static DBManager getInstance() {
        return dbManger;
    }

    public void init(Context context) {
        this.context = context;
    }

    public Database getDatabase(){
        return database;
    }
    /**
     * 判断是否存在数据库，没有则创建
     *
     * @return
     */
    public DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            File file=new File(Environment.getExternalStorageDirectory(),"libao/data");
            if (!file.exists()) {
                file.mkdirs();
            }
            File dbFile=new File(file,DB_NAME);
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context,dbFile.getPath() , null);
            database=devOpenHelper.getWritableDb();
            daoMaster = new DaoMaster(database);
        }
        return daoMaster;
    }

    /**
     * @return
     */
    public DaoSession getDaoSession() {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }

        return daoSession;

    }

    public void setDebug() {
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }

    public void closeConnection() {
        closeHelper();
        closeDaoSession();
    }

    public void closeHelper() {
        if (devOpenHelper != null) {
            devOpenHelper.close();
            devOpenHelper = null;
        }
    }

    public void closeDaoSession() {
        if (daoSession != null) {
            daoSession.clear();
            daoSession = null;
        }
    }
}
