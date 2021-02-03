package com.arabam.android.assigment.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SpecialSharedPreferences {
    companion object {
        private val TIME = "time"
        private var sharedPreferences : SharedPreferences? = null
        @Volatile private var instance : SpecialSharedPreferences? = null
        private var lock = Any()
        operator fun invoke(context: Context) : SpecialSharedPreferences = instance ?: synchronized(lock){
            instance ?: createSP(context).also {
                instance = it
            }
        }
        private fun createSP(context: Context) : SpecialSharedPreferences{
            sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
            return SpecialSharedPreferences()
        }
    }
    fun setTime(time : Long){
        sharedPreferences?.edit(commit = true){
            putLong(TIME, time)
        }
    }

    fun getTime() = sharedPreferences?.getLong(TIME, 0)
}