package com.example.shopping_events_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shopping_events_app.destinations.AddEventRoute
import com.example.shopping_events_app.destinations.EventDetailsRoute
import com.example.shopping_events_app.destinations.HomeRoute
import com.example.shopping_events_app.ui.addevent.AddEventPage
import com.example.shopping_events_app.ui.eventdetails.AddEventDetailsPage
import com.example.shopping_events_app.ui.home.HomePage
import com.example.shopping_events_app.ui.theme.ShoppingeventsappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingApp()
        }
    }
}

@Composable
fun ShoppingApp(modifier: Modifier = Modifier) {
    ShoppingeventsappTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = HomeRoute
        ) {
            composable<HomeRoute> {
                HomePage(
                    navigateToAddEvent = {
                        navController.navigate(route = AddEventRoute)
                    },
                    navigateToEventDetails = { id, name ->
                        navController.navigate(route = EventDetailsRoute(id, name))
                    },
                    modifier = modifier
                )
            }

            composable<AddEventRoute> {
                AddEventPage(
                    navigateBack = { navController.popBackStack() },
                    navigateUp =  { navController.navigateUp() },
                    modifier = modifier
                )
            }

            composable<EventDetailsRoute> {
                AddEventDetailsPage(
                    navigateBack = { navController.popBackStack() },
                    navigateUp = { navController.navigateUp() },
                    modifier = modifier
                )
            }
        }
    }
}
