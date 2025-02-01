package com.example.advanced.trace

import java.util.UUID

data class TraceId(
    val id: String = createId(),
    val level: Int = 0
) {

    fun createNextId(): TraceId = copy(id = this.id, level = level + 1)

    fun createPreviousId(): TraceId = copy(id = this.id, level = level - 1)

    fun isFirstLevel(): Boolean = level == 0

    private companion object {
        fun createId() = UUID.randomUUID().toString().substring(0, 8)
    }
}
