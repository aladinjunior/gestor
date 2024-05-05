package com.aladinjunior.gestor

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aladinjunior.gestor.Destinations.SIGN_IN_ROUTE
import com.aladinjunior.gestor.signin.presentation.SignInRoute
import com.aladinjunior.gestor.signin.presentation.SignInScreen

object Destinations {
    const val SIGN_IN_ROUTE = "signin"
}

@Composable
fun GestorNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = SIGN_IN_ROUTE,) {
        composable(SIGN_IN_ROUTE) {
            SignInRoute()
        }
    }

}