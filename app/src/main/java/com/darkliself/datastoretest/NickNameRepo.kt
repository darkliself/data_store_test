package com.darkliself.datastoretest

import kotlinx.coroutines.flow.flowOf

object NickNameRepo {
    val tasks = flowOf(
        listOf(
            Nickname(
                name = "Test1"
            ),
            Nickname(
                name = "Test2"
            )
        )
    )
}