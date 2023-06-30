package com.example.growup

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.growup.databinding.ActivityMainBinding
import com.example.growup.delegate.ui.DelegateActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        GrowUpEnum.values().forEach {
            val button = AppCompatButton(this)
            button.text = it.name.replace("_", " ")
            button.tag = it
            binding.linearLayout.addView(button)
            button.setOnClickListener(this)
        }
    }
    override fun onClick(p0: View?) {
        when (p0?.tag as GrowUpEnum) {
            GrowUpEnum.DELEGATE -> startActivity(
                Intent(this, DelegateActivity::class.java)
            )
        }
    }
}
enum class GrowUpEnum {
    DELEGATE
}