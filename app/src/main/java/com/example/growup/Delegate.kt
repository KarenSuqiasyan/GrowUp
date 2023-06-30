package com.example.growup

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

    user.username = "Alice"
    println(user.username) // Output: Alice

    user.username = "" // Validation fails, sets default value
    println(user.username) // Output: Default

    user.username = "Bob12!" // Validation fails, sets default value
    println(user.username) // Output: Default

    user.username = "Charlie"
    println(user.username) // Output: Charlie
}
