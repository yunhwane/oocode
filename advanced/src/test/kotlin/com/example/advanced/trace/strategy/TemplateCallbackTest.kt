package com.example.advanced.trace.strategy

import com.example.advanced.trace.strategy.code.template.Callback
import com.example.advanced.trace.strategy.code.template.TimeLogTemplate
import org.junit.jupiter.api.Test

class TemplateCallbackTest {
    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    @Test
    fun callbackV1() {
        val template = TimeLogTemplate()
        template.execute { log.info("비즈니스 로직 1 실행") }
        template.execute { log.info("비즈니스 로직 2 실행") }
    }
}