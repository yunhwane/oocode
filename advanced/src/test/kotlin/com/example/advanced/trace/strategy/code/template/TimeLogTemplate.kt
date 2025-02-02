package com.example.advanced.trace.strategy.code.template

class TimeLogTemplate {

    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    fun execute(callback: Callback) {
        val startTime = System.currentTimeMillis()
        callback.call()
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info(resultTime.toString())
    }
}