package com.example.p5mvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.p5mvvm.model.DataSiswa

@Composable
fun TampilDataView(
    uiState: DataSiswa,
    onBackButton: () -> Unit)
{
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp))
    {
        TampilData(Param = "NIM", Argu = uiState.nim )
        TampilData(Param = "Nama", Argu = uiState.nama )
        TampilData(Param = "Jenis Kelamin", Argu = uiState.gender )
        TampilData(Param = "Alamat", Argu = uiState.alamat )
        TampilData(Param = "Email", Argu = uiState.email )
        TampilData(Param = "No Telepon", Argu = uiState.notelp )
        Button(onClick = onBackButton)
        {
            Text(text = "Kembali")
        }
    }
}

@Composable
fun TampilData(Param : String, Argu : String){
    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = Param, modifier = Modifier.weight(0.8f))
            Text(text = ": ", modifier = Modifier.weight(0.2f))
            Text(text = Argu, modifier = Modifier.weight(2f))
        }
    }
}