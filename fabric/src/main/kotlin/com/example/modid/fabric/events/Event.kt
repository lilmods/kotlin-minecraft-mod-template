package com.example.modid.fabric.events

sealed interface Event

data class TickEvent(
    val something: String
) : Event
