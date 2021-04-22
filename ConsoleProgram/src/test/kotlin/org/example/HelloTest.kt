package org.example

import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Test {
    val nl = System.lineSeparator()
    @Test
    fun test() {
        val inputFile = File("input")
        inputFile.writeText("ABVC B CU DOT ER FACE${nl}" +
                "GRED HaN IM JU LAY MKEP N OPEN PIN R${nl}" +
                "Sd TiRY Yang UI${nl}" +
                "VIEW WHEELS")
        val outputFile = File("output")
        val out = outputFile.bufferedWriter()
        transposes(inputFile.bufferedReader(), out, 10 , false, false)
        out.close()
        val result = "ABVC       GRED       Sd         VIEW       ${nl}" +
                "B          HaN        TiRY       WHEELS     ${nl}" +
                "CU         IM         Yang                  ${nl}" +
                "DOT        JU         UI                    ${nl}" +
                "ER         LAY                              ${nl}" +
                "FACE       MKEP                             ${nl}" +
                "           N                                ${nl}" +
                "           OPEN                             ${nl}" +
                "           PIN                              ${nl}" +
                "           R                                ${nl}"
        assertEquals(result, outputFile.readText())
    }

    @Test
    fun consoleOut() {
        val inputFile = File("input1")
        inputFile.writeText("ABVC B CU DOT ER FACE UP${nl}" +
                "GRED HaN IM JU LAY MKEP N OPEN PIN R${nl}" +
                "Sd TiRY Yang UI${nl}" +
                "VIEW WHEELS")
        main("input1 -a 6 -r".split(" ").toTypedArray())
    }

    @Test
    fun mistakeObject() {
        main("-z 6 -dafaf".split(" ").toTypedArray())
    }

}
