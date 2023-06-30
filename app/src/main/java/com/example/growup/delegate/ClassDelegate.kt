package com.example.growup.delegate

import kotlin.reflect.KProperty

class ValidatedStringDelegate(private var value: String = "") {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: String) {
        value = if (newValue.isBlank() || newValue.length < 5 || newValue.contains(Regex("[^a-zA-Z0-9]"))) {
            "Default"
        } else {
            newValue
        }
    }
}

class User {
    var username: String by ValidatedStringDelegate()
}

fun main() {
    val user = User()

    user.username = "Valod"
    println(user.username)

    user.username = ""
    println(user.username)

    user.username = "Poxos12!"
    println(user.username)

    user.username = "Saqulik"
    println(user.username)
}
