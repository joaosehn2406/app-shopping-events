package com.example.shopping_events_app.destinations

import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
object AddEventRoute

@Serializable
data class EventDetailsRoute(val eventId: Long, val eventName: String)
