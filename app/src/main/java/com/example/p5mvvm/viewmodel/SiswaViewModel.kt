package com.example.p5mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.p5mvvm.model.DataSiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel() {

    //Request
    private val _statusUI = MutableStateFlow(DataSiswa())

    //Respone
    val statusUI: StateFlow<DataSiswa> = _statusUI.asStateFlow()

    fun saveDataSiswa(ls: MutableList<String>){
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[1],
                gender = ls[2],
                email = ls[3],
                alamat = ls[4],
                notelp = ls[5]
            )
        }
    }
}