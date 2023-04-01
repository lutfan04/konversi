package org.d3if0099.konversi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import org.d3if0099.konversi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isDarkModeOn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConvert.setOnClickListener {
            val celsius = binding.etCelsius.text.toString().toDoubleOrNull()
            val fahrenheit = binding.etFahrenheit.text.toString().toDoubleOrNull()

            if (celsius != null && fahrenheit == null) {
                val result = (celsius * 9 / 5) + 32
                binding.etFahrenheit.setText(result.toString())
            } else if (celsius == null && fahrenheit != null) {
                val result = (fahrenheit - 32) * 5 / 9
                binding.etCelsius.setText(result.toString())
            } else {
                // Show error message
            }
        }
        binding.btnReset.setOnClickListener {
            // Tambahkan kode untuk mereset nilai pada EditText atau TextView
            binding.etCelsius.text.clear()
            binding.etFahrenheit.text.clear()
            binding.textView.text = ""

        }
        binding.switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            isDarkModeOn = isChecked
            applyTheme()
        }
    }

    private fun applyTheme() {
        if (isDarkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}

