package com.example.advanced.trace.threadlocal.code

class FieldService (
    var nameStore: String? = null
){
    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    fun logic(name: String): String {
        log.info("FieldService.logic() : $name")
        nameStore = name
        sleep(1000)
        log.info("FieldService.logic() 조회 : $nameStore")
        return nameStore!!
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}