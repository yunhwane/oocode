package com.example.advanced.trace.strategy

import com.example.advanced.trace.strategy.code.strategy.ContextV2
import com.example.advanced.trace.strategy.code.strategy.Strategy
import com.example.advanced.trace.strategy.code.strategy.StrategyLogic1
import com.example.advanced.trace.strategy.code.strategy.StrategyLogic2
import org.junit.jupiter.api.Test

class ContextV2Test {

    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    @Test
    fun strategyV1() {
        val context = ContextV2()
        context.execute(StrategyLogic1())
        context.execute(StrategyLogic2())
    }


    /**
     * 익명 내부 클래스로 전략 패턴 사용하기
     */
    @Test
    fun strategyV2() {
        val context = ContextV2()
        context.execute(object : Strategy {
            override fun call() {
                log.info("비즈니스 로직 1")
            }
        })
        context.execute(object : Strategy {
            override fun call() {
                log.info("비즈니스 로직 2")
            }
        })
    }

    /**
     * 람다로 전략 패턴 사용하기
     */

    @Test
    fun strategyV3() {
        val context = ContextV2()
        context.execute { log.info("비즈니스 로직 1") }
        context.execute { log.info("비즈니스 로직 2") }
    }



}