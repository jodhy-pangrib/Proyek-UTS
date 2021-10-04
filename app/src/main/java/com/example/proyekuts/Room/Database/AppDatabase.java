package com.example.proyekuts.Room.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.proyekuts.Room.Dao.AkunDao;
import com.example.proyekuts.Room.Entity.Akun;

@Database(entities = {Akun.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AkunDao akunDao();
}
