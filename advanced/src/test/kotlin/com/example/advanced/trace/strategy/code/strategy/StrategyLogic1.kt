package com.example.advanced.trace.strategy.code.strategy

class StrategyLogic1 : Strategy {

    override fun call() {
        val log = org.slf4j.LoggerFactory.getLogger(this::class.java)
        log.info("비즈니스 로직1 실행")
    }
}