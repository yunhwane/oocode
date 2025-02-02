package com.example.advanced.config

import com.example.advanced.trace.logtrace.FieldLogTrace
import com.example.advanced.trace.logtrace.LogTrace
import com.example.advanced.trace.logtrace.ThreadLocalLogTrace
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class LogTraceConfig {

    /**
     * 싱글톤으로 등록됨
     */
    @Bean
    fun logTrace(): LogTrace {
        return ThreadLocalLogTrace()
    }

}