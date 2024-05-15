package com.aladinjunior.gestor

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aladinjunior.gestor.Destinations.DASHBOARD_ROUTE
import com.aladinjunior.gestor.Destinations.PEOPLE_ROUTE
import com.aladinjunior.gestor.Destinations.SIGN_IN_ROUTE
import com.aladinjunior.gestor.dashboard.Actions.PEOPLE
import com.aladinjunior.gestor.dashboard.DashboardRoute
import com.aladinjunior.gestor.people.PeopleRoute
import com.aladinjunior.gestor.signin.data.local.FakeLocalDataSource
import com.aladinjunior.gestor.signin.presentation.SignInRoute

object Destinations {
    const val SIGN_IN_ROUTE = "signin"
    const val DASHBOARD_ROUTE = "dashboard/{userId}"
    const val PEOPLE_ROUTE = "people"
}

@Composable
fun GestorNavHost(
    navController: NavHostController = rememberNavController()
) {

    NavHost(navController = navController,
        startDestination = SIGN_IN_ROUTE,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        }) {
        composable(SIGN_IN_ROUTE) {
            SignInRoute(
                onSignInComplete = {
                    navController.navigate("dashboard/$it")
                },
                onSignInFailure = {
                }
            )
        }
        composable(
            DASHBOARD_ROUTE,
            arguments = listOf(
                navArgument("userId") {
                    type = NavType.IntType
                }
            ),

            ) {
            val userId = it.arguments?.getInt("userId")
            val loggedInUser = FakeLocalDataSource.accounts[userId] ?: FakeLocalDataSource.user {
                name = "empty user"
            }
            DashboardRoute(
                loggedInUser = loggedInUser,
                onActionClicked = { action ->
                    when (action) {
                        PEOPLE -> navController.navigate(PEOPLE_ROUTE)
                    }

                })
        }
        composable(
            PEOPLE_ROUTE,

        ) {
            PeopleRoute()
        }
    }


}

