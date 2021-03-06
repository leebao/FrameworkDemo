package com.example.greendaodemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "infor_animal".
*/
public class AnimalDao extends AbstractDao<Animal, Void> {

    public static final String TABLENAME = "infor_animal";

    /**
     * Properties of entity Animal.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Name = new Property(0, String.class, "name", false, "NAME");
        public final static Property Age = new Property(1, String.class, "age", false, "AGE");
    }


    public AnimalDao(DaoConfig config) {
        super(config);
    }
    
    public AnimalDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"infor_animal\" (" + //
                "\"NAME\" TEXT NOT NULL ," + // 0: name
                "\"AGE\" TEXT);"); // 1: age
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"infor_animal\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Animal entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getName());
 
        String age = entity.getAge();
        if (age != null) {
            stmt.bindString(2, age);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Animal entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getName());
 
        String age = entity.getAge();
        if (age != null) {
            stmt.bindString(2, age);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Animal readEntity(Cursor cursor, int offset) {
        Animal entity = new Animal( //
            cursor.getString(offset + 0), // name
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // age
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Animal entity, int offset) {
        entity.setName(cursor.getString(offset + 0));
        entity.setAge(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Animal entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Animal entity) {
        return null;
    }

    @Override
    public boolean hasKey(Animal entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
