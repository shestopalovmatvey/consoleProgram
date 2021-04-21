package org.example

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val x = ConsoleProgram()
    x.launch(args)
    val output = if (x.outputFile == null) System.out.bufferedWriter() else File(x.outputFile!!).bufferedWriter()
    val input = if (x.nameFile == null) System.`in`.bufferedReader() else File(x.nameFile!!).bufferedReader()
    transposes(input, output, x.a, x.t, x.r)
    output.close()
}

fun transposes(input: BufferedReader, output: BufferedWriter, a: Int, t: Boolean, r: Boolean) {
    val matrix = createMatrix(input)
    val size = matrix.maxOf { it.size }
    for (i in 0 until size) {
        for (j in matrix.indices) {
            val word: StringBuilder = if (matrix[j].size > i) {
                StringBuilder(matrix[j][i])
            } else {
                StringBuilder(" ".repeat(a))
            }
            if (t && word.length > a) {
                word.deleteRange(a, word.lastIndex)
            }
            if (word.length < a) {
                if (r) {
                    word.insert(0, " ".repeat(a - word.length))
                } else {
                    word.append(" ".repeat(a - word.length))
                }
            }
            output.append("$word ")
        }
        output.newLine()
    }
}

fun createMatrix(input: BufferedReader): List<List<String>> {
    val matrix = mutableListOf<List<String>>()
    input.forEachLine {
        matrix.add(it.split(Regex("""\s+""")))
    }
    return matrix
}



