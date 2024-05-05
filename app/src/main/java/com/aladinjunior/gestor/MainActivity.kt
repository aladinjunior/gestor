package com.aladinjunior.gestor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.aladinjunior.gestor.signin.LoginScreen
import com.aladinjunior.gestor.ui.theme.GestorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            GestorTheme {
                // A surface container using the 'background' color from the theme
                LoginScreen()
            }
        }
    }
}

