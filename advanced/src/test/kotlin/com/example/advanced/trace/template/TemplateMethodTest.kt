package com.example.advanced.trace.template

import com.example.advanced.trace.template.code.SubClassLogic1
import com.example.advanced.trace.template.code.SubClassLogic2
import org.junit.jupiter.api.Test

class TemplateMethodTest {

    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    @Test
    fun templateMethodV0() {
        logic1()
        logic2()
    }


    private fun logic1() {
        val startTime = System.currentTimeMillis()
        log.info("logic1() 시작")
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info(resultTime.toString())
        log.info("logic1() 종료")
    }

    private fun logic2() {
        val startTime = System.currentTimeMillis()
        log.info("logic2() 시작")
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info(resultTime.toString())
        log.info("logic2() 종료")
    }


    /**
     * Template Method Pattern
     * 단일 책임 원칙을 지키며 중복된 코드를 제거하는 방법
     */
    @Test
    fun templateMethodV1() {
        val logic1 = SubClassLogic1()
        logic1.execute()

        val logic2 = SubClassLogic2()
        logic2.execute()
    }


    /**
     * 익명 내부 클래스로 구현하기
     */

    @Test
    fun templateMethodV2() {
        val logic1 = object : SubClassLogic1() {
            override fun call() {
                log.info("비즈니스 로직 1")
            }
        }
        logic1.execute()

        val logic2 = object : SubClassLogic2() {
            override fun call() {
                log.info("비즈니스 로직 2")
            }
        }
        logic2.execute()
    }
}