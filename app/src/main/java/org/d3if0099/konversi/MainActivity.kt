package org.d3if0099.konversi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import org.d3if0099.konversi.databinding.ActivityMainBinding
import org.d3if0099.konversi.model.TemperatureViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isDarkModeOn = false

    private lateinit var temperatureViewModel: TemperatureViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        temperatureViewModel = ViewModelProvider(this).get(TemperatureViewModel::class.java)


        binding.btnConvert.setOnClickListener {
            val celsius = binding.etCelsius.text.toString().toDoubleOrNull()
            val fahrenheit = binding.etFahrenheit.text.toString().toDoubleOrNull()
            val kelvin = binding.etKelvin.text.toString().toDoubleOrNull()
            val reamur = binding.etReamur.text.toString().toDoubleOrNull()

            temperatureViewModel.convertTemperature(celsius, fahrenheit, kelvin, reamur)
        }

        temperatureViewModel.temperature.observe(this, { temperature ->
            binding.etCelsius.setText(temperature.celsius.toString())
            binding.etFahrenheit.setText(temperature.fahrenheit.toString())
            binding.etKelvin.setText(temperature.kelvin.toString())
            binding.etReamur.setText(temperature.reamur.toString())
        })

        binding.btnReset.setOnClickListener {
            binding.etCelsius.text.clear()
            binding.etFahrenheit.text.clear()
            binding.etKelvin.text.clear()
            binding.etReamur.text.clear()
        }
        binding.btnReset.setOnClickListener {
            // Tambahkan kode untuk mereset nilai pada EditText atau TextView
            binding.etCelsius.text.clear()
            binding.etFahrenheit.text.clear()
            binding.etKelvin.text.clear()
            binding.etReamur.text.clear()


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

