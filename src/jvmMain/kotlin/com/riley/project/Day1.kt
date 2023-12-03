package com.riley.project

import java.io.File

class Day1(override val day: String) : IDay {

    override fun part1(file: File): String {
        val inputList = Utils.readFileToList(file)
        var sum = 0
        for (line in inputList) {
            val firstDigit = line.asSequence()
                .filter { it.isDigit() }
                .map { it.toString().toInt() }
                .firstOrNull()

            val lastDigit = line.reversed().asSequence()
                .filter { it.isDigit() }
                .map { it.toString().toInt() }
                .firstOrNull()

            val combined = firstDigit.toString() + lastDigit.toString()

            sum += combined.toInt()
        }
        return sum.toString()
    }

    companion object {
        val spelledOutNums = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9)
    }

    override fun part2(file: File): String {
        val inputList = Utils.readFileToList(file)
        var sum: Long = 0
        for (line in inputList) {
            var firstDigit: Int = -1
            var firstDigitIndex = Int.MAX_VALUE
            for (index in line.indices) {
                if (line[index].isDigit()) {
                    firstDigit = line[index].toString().toInt()
                    firstDigitIndex = index
                    break
                }
            }

            for (spelledOutNum in spelledOutNums.entries) {
                val indexOfNum = line.indexOf(spelledOutNum.key)
                if (indexOfNum < firstDigitIndex && indexOfNum > -1) {
                    firstDigit = spelledOutNum.value
                    firstDigitIndex = indexOfNum
                }
            }

            var lastDigit: Int = -1
            var lastDigitIndex = Int.MIN_VALUE
            for (i in line.length - 1 downTo 0) {
                if (line[i].isDigit()) {
                    lastDigit = line[i].toString().toInt()
                    lastDigitIndex = i
                    break
                }
            }

            for (spelledOutNum in spelledOutNums.entries) {
                val indexOfNum = line.lastIndexOf(spelledOutNum.key)
                if (indexOfNum > lastDigitIndex && indexOfNum > -1) {
                    lastDigitIndex = indexOfNum
                    lastDigit = spelledOutNum.value
                }
            }

            val combined = firstDigit.toString() + lastDigit.toString()

            println("Line: $line. First: $firstDigit Second: $lastDigit Combined $combined")

            sum += combined.toInt()

            println("Rolling Sum: $sum")
        }

        // Needs to be higher than 54844
        return sum.toString()
    }
}