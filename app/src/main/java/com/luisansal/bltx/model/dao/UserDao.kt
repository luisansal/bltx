package com.luisansal.bltx.model.dao

import com.luisansal.bltx.model.domain.User

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: User): Long?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(users: List<User>)

    @Query("DELETE FROM tbluser")
    fun deleteAll()

    @Query("SELECT * from tbluser ORDER BY nombre ASC")
    fun findAllUsers(): LiveData<List<User>>

    @Query("SELECT * from tbluser ORDER BY nombre ASC")
    fun findAllUsersInline(): List<User>

    @Query("SELECT * from tbluser where dni = :dni")
    fun findOneByDni(dni: String): User
}
