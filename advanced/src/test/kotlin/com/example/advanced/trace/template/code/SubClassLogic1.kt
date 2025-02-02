package com.example.advanced.trace.template.code

open class SubClassLogic1 : AbstractTemplate() {

    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    override fun call() {
        log.info("비즈니스 로직 1")
    }

}