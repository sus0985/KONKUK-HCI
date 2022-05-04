package com.hci.obtt.model

data class User(
    val id: String,
    val password: String,
    val action: (() -> Unit)? = null
)