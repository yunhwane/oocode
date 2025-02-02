package com.example.advanced.trace.strategy.code.strategy

class StrategyLogic2 : Strategy {
    override fun call() {
        val log = org.slf4j.LoggerFactory.getLogger(this::class.java)
        log.info("비즈니스 로직2 실행")
    }
}