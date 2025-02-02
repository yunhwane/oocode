package com.example.advanced.trace.threadlocal.code

class ThreadLocalService (
    var nameStore: ThreadLocal<String> = ThreadLocal()
){
    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    fun logic(name: String): String {
        log.info("FieldService.logic() : $name")
        nameStore.set(name)
        sleep(1000)
        log.info("FieldService.logic() 조회 : ${nameStore.get()}")
        return nameStore.get()
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}