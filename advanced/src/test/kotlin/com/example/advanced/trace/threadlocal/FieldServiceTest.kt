package com.example.advanced.trace.threadlocal

import com.example.advanced.trace.threadlocal.code.FieldService
import org.junit.jupiter.api.Test

class FieldServiceTest {

    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)
    private val fieldService = FieldService()

    /**
     * 동시성 문제가 발생 안하는 코드
     */
    @Test
    fun field() {
        log.info("main start")
        val userA = Runnable {
            fieldService.logic("userA")
        }

        val userB = Runnable {
            fieldService.logic("userB")
        }

        val threadA = Thread(userA)
        threadA.name = "thread-A"
        val threadB = Thread(userB)
        threadB.name = "thread-B"

        threadA.start()
        sleep(2000)
        threadB.start()

        sleep(2000)
        println("main end")
    }

    @Test
    fun 동시성이슈발생코드() {
        log.info("main start")
        val userA = Runnable {
            fieldService.logic("userA")
        }

        val userB = Runnable {
            fieldService.logic("userB")
        }

        val threadA = Thread(userA)
        threadA.name = "thread-A"
        val threadB = Thread(userB)
        threadB.name = "thread-B"

        threadA.start()
        sleep(100)
        threadB.start()

        sleep(2000)
        println("main end")
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

}