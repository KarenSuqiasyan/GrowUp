package com.example.growup.delegate.data

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


fun SharedPreferences.booleanDelegate(default:Boolean) = object : ReadWriteProperty<Any, Boolean> {
    override fun getValue(thisRef: Any, property: KProperty<*>): Boolean = getBoolean(property.name, default)
    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) = edit { putBoolean(property.name, value) }
}

fun SharedPreferences.floatDelegate(default:Float) = object : ReadWriteProperty<Any, Float> {
    override fun getValue(thisRef: Any, property: KProperty<*>): Float = getFloat(property.name, default)
    override fun setValue(thisRef: Any, property: KProperty<*>, value: Float) = edit { putFloat(property.name, value) }
}

fun SharedPreferences.stringDelegate(default:String) = object : ReadWriteProperty<Any, String?> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String? = getString(property.name, default)
    override fun setValue(thisRef: Any, property: KProperty<*>, value: String?) = edit { putString(property.name, value) }
}
