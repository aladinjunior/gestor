package com.aladinjunior.gestor

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aladinjunior.gestor.Destinations.DASHBOARD_ROUTE
import com.aladinjunior.gestor.Destinations.SIGN_IN_ROUTE
import com.aladinjunior.gestor.dashboard.DashboardRoute
import com.aladinjunior.gestor.signin.data.local.FakeLocalDataSource
import com.aladinjunior.gestor.signin.presentation.SignInRoute

object Destinations {
    const val SIGN_IN_ROUTE = "signin"
    const val DASHBOARD_ROUTE = "dashboard/{userId}"
}

@Composable
fun GestorNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = SIGN_IN_ROUTE) {
        composable(SIGN_IN_ROUTE) {
            SignInRoute(
                onSignInComplete = {
                    navController.navigate("dashboard/$it")
                },
                onSignInFailure = {
                }
            )
        }
        composable(DASHBOARD_ROUTE,
            arguments = listOf(
            navArgument("userId") {
                type = NavType.IntType
            }
        )) {
            val userId = it.arguments?.getInt("userId")
            Log.d("testando123321", "GestorNavHost: $userId")
            val loggedInUser = FakeLocalDataSource.accounts[userId] ?: FakeLocalDataSource.user {
                name = "usuario vazio"
            }
            DashboardRoute(loggedInUser)
        }
    }

}

