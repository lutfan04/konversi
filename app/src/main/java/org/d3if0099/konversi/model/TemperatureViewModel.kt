package org.d3if0099.konversi.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TemperatureViewModel : ViewModel() {

    private val _temperature = MutableLiveData<Temperature>()
    val temperature: LiveData<Temperature> = _temperature

    fun convertTemperature(celsius: Double?, fahrenheit: Double?, kelvin: Double?, reamur: Double?) {
        if (celsius != null) {
            val resultFahrenheit = (celsius * 9 / 5) + 32
            val resultKelvin = celsius + 273.15
            val resultReamur = celsius * 4 / 5
            _temperature.value = Temperature(celsius, resultFahrenheit, resultKelvin, resultReamur)
        } else if (fahrenheit != null) {
            val resultCelsius = (fahrenheit - 32) * 5 / 9
            val resultKelvin = (fahrenheit + 459.67) * 5 / 9
            val resultReamur = (fahrenheit - 32) * 4 / 9
            _temperature.value = Temperature(resultCelsius, fahrenheit, resultKelvin, resultReamur)
        } else if (kelvin != null) {
            val resultCelsius = kelvin - 273.15
            val resultFahrenheit = (kelvin * 9 / 5) - 459.67
            val resultReamur = (kelvin - 273.15) * 4 / 5
            _temperature.value = Temperature(resultCelsius, resultFahrenheit, kelvin, resultReamur)
        } else if (reamur != null) {
            val resultCelsius = reamur * 5 / 4
            val resultFahrenheit = (reamur * 9 / 4) + 32
            val resultKelvin = (reamur * 5 / 4) + 273.15
            _temperature.value = Temperature(resultCelsius, resultFahrenheit, resultKelvin, reamur)
        }
    }
}
