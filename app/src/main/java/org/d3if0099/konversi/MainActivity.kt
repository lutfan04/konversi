package org.d3if0099.konversi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.d3if0099.konversi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
    }
}

