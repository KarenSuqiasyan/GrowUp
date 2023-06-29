package com.example.growup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.growup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NetworkCallback {


    private lateinit var binding: ActivityMainBinding

//    var param: String by TrimDelegate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val delegate = NetworkDelegate()
        val client = NetworkClientWithDelegate(delegate)

        client.makeNetworkRequest()
    }

    override fun onSuccess(response: String) {
        binding.resultTextView.text = "Success: $response"
    }

    override fun onFailure(error: String) {
        binding.resultTextView.text = "Failure: $error"
    }
}

//class TrimDelegate : ReadWriteProperty<Any?, String> {
//
//    private var trimmedValue: String = ""
//
//    override fun getValue(
//        thisRef: Any?,
//        property: KProperty<*>
//    ): String {
//        return trimmedValue
//    }
//
//    override fun setValue(
//        thisRef: Any?,
//        property: KProperty<*>, value: String
//    ) {
//        trimmedValue = value.trim()
//    }
//}
//
//
//fun SharedPreferences.stringNullable(
//    defaultValue: String? = null,
//    key: (KProperty<*>) -> String = KProperty<*>::name
//): ReadWriteProperty<Any, String?> =
//    object : ReadWriteProperty<Any, String?> {
//        override fun getValue(
//            thisRef: Any,
//            property: KProperty<*>
//        ) = getString(key(property), defaultValue)
//
//        override fun setValue(
//            thisRef: Any,
//            property: KProperty<*>,
//            value: String?
//        ) = edit().putString(key(property), value).apply()
//    }
//
//fun SharedPreferences.int(
//    defaultValue: Int = 0,
//    key: (KProperty<*>) -> String = KProperty<*>::name
//): ReadWriteProperty<Any, Int> =
//    object : ReadWriteProperty<Any, Int> {
//        override fun getValue(
//            thisRef: Any,
//            property: KProperty<*>
//        ) = getInt(key(property), defaultValue)
//
//        override fun setValue(
//            thisRef: Any,
//            property: KProperty<*>,
//            value: Int
//        ) = edit().putInt(key(property), value).apply()
//    }
//
//class Settings(context: Context) {
//
//    private val prefs: SharedPreferences =
//        PreferenceManager.getDefaultSharedPreferences(context)
//
//    var param1 by prefs.stringNullable()
//    var param2 by prefs.int()
//
//}