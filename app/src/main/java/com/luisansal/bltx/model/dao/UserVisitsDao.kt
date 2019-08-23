package com.luisansal.bltx.model.dao

import com.luisansal.bltx.model.domain.UserAndVists

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserVisitsDao {
    @Query("SELECT * FROM tbluser WHERE id = :id")
    fun findUserAllVisitsById(id: Long?): LiveData<UserAndVists>

    @Query("SELECT * FROM tbluser WHERE dni = :dni")
    fun findUserAllVisitsByDni(dni: String): LiveData<UserAndVists>
}
