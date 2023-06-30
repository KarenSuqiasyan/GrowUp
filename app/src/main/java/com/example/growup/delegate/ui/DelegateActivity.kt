package com.example.growup.delegate.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.growup.databinding.ActivityDelegateBinding
import com.example.growup.delegate.viewmodel.SettingsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DelegateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDelegateBinding
    private val viewModel: SettingsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDelegateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        binding.apply {
            nameEditText.setText(viewModel.name)
            switcher.isChecked = viewModel.switcher
            switcher.text = getSwitcherText(viewModel.switcher)
            seekBar.progress = viewModel.seekBar.toInt()
        }
    }

    private fun setupListeners() {
        binding.apply {
            switcher.setOnCheckedChangeListener { _, isChecked ->
                viewModel.switcher = isChecked
                switcher.text = getSwitcherText(isChecked)
            }

            saveButton.setOnClickListener {
                viewModel.name = nameEditText.text.toString()
                viewModel.switcher = switcher.isChecked
                viewModel.seekBar = seekBar.progress.toFloat()
                viewModel.save()
            }
        }
    }

    private fun getSwitcherText(isChecked: Boolean) = if (isChecked) "Enable" else "Disable"
}