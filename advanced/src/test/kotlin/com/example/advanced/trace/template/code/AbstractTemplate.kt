package com.example.advanced.trace.template.code

abstract class AbstractTemplate {
    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    fun execute() {
        val startTime = System.currentTimeMillis()
        call()
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info(resultTime.toString())
    }

    protected abstract fun call();
}