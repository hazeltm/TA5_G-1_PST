package com.example.pst_ta5_grupo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context) {
        super(context, "administracion", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table clientes(usuario text primary key,password text ,nombres text,apellidos text,correo text,celular text,favorito text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Boolean checkUsuario(String usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from clientes where usuario=?", new String[]{usuario});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkUsuarioPassword(String usuario, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from clientes where usuario=? and password=?", new String[]{usuario, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean insertData(String usuario, String password, String nombres, String apellidos, String correo, String celular, String favorito) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("usuario", usuario);
        contentValues.put("password", password);
        contentValues.put("nombres", nombres);
        contentValues.put("apellidos", apellidos);
        contentValues.put("correo", correo);
        contentValues.put("celular", celular);
        contentValues.put("favorito", favorito);
        long result = db.insert("clientes", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}