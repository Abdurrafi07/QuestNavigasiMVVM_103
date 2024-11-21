package com.example.p5mvvm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.p5mvvm.viewmodel.SiswaViewModel
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.p5mvvm.model.JenisKelamin
import com.example.p5mvvm.model.JenisKelamin.jenisK
import com.example.p5mvvm.ui.view.FormulirView
import com.example.p5mvvm.ui.view.TampilDataView

enum class Halaman{
    FORMULIR,
    TAMPILDATA
}

@Composable
fun NavigationControl(modifier: Modifier = Modifier,
                      viewModel: SiswaViewModel = viewModel(),
                      navHost: NavHostController = rememberNavController()
){
    val uiState by viewModel.statusUI.collectAsState()

    NavHost(
        navController = navHost,
        startDestination = Halaman.FORMULIR.name
    ) {
        composable(
            route = Halaman.FORMULIR.name
        ){
            val konteks = LocalContext.current
                FormulirView(
                    listJK = jenisK.map { id -> konteks.getString (id)},
                    onSumbitClicked = {
                        viewModel.saveDataSiswa(it)
                        navHost.navigate(
                            Halaman.TAMPILDATA.name
                        )
                    }
                )

        }
        composable(route = Halaman.TAMPILDATA.name){
            TampilDataView(
                uiState = uiState,
                onBackButton = {
                    navHost.popBackStack()
                }
            )
        }
    }
}