package com.luisansal.bltx.model.database

import android.content.Context
import android.os.AsyncTask
import android.util.Log

import com.luisansal.bltx.model.dao.UserDao
import com.luisansal.bltx.model.domain.User
import com.luisansal.bltx.model.domain.converter.LatLngConverter

import java.util.ArrayList
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.luisansal.bltx.model.dao.AuthorDao
import com.luisansal.bltx.model.domain.Author
import java.lang.Exception

@Database(entities = [User::class, Author::class], version = 8)
//@TypeConverters(LatLngConverter::class)
abstract class MyRoomDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun authorDao(): AuthorDao

    private class PopulateDbAsync(myRoomDatabase: MyRoomDatabase) : AsyncTask<Void, Void, Void>() {

        private val userDao: UserDao

        init {
            userDao = myRoomDatabase.userDao()
        }

        override fun doInBackground(vararg voids: Void): Void? {
            userDao.deleteAll()

            var user = User("05159410", "Juan", "Alvarez")

            val lastUserId = userDao.save(user)

            val users = ArrayList<User>()
            for (i in 0..999) {
                user = User("User" + (i + 1), "Apell" + (i + 1), "dni" + (i + 1))
                users.add(user)
            }
            userDao.saveAll(users)

            Log.i("DB_ACTIONS", "Database Populated")

            return null
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: MyRoomDatabase? = null

        fun getDatabase(context: Context): MyRoomDatabase? {
            return getDatabase(context, false)
        }

        fun getDatabase(context: Context, reopen: Boolean): MyRoomDatabase? {
            if (INSTANCE == null && !reopen) {
                synchronized(MyRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        doInstance(context)
                    }
                }
            } else {
                synchronized(MyRoomDatabase::class.java) {
                    doInstance(context)
                }
            }
            return INSTANCE
        }

        fun doInstance(context: Context) {
            INSTANCE = Room.databaseBuilder<MyRoomDatabase>(context, MyRoomDatabase::class.java, "myDatabase")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(sRoomDatabaseCallback)
                    .build()
        }


        private val sRoomDatabaseCallback = object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                try {
                    PopulateDbAsync(INSTANCE!!).execute()
                } catch (e: Exception) {
//                    e.printStackTrace()
                }

            }
        }
    }
}