package com.riley.project

import java.io.File

class Day3(override val day: String) : IDay {

    data class DigitInGrid(val digit: Int, val minX: Int, val maxX: Int, val row: Int)

    override fun part1(file: File): String {
        val twoDArray = Utils.readFileInto2DArray(file)
        val digits = populateDigitMap(twoDArray)
        var sum = 0
        // Now we have the digits, check for neighbors
        for (digit in digits) {
            if (doesNeighborHaveSymbol(twoDArray, digit.digit, digit.row, digit.minX, digit.maxX, mutableMapOf())) {
                sum += digit.digit
            }
        }

        return sum.toString()
    }

    override fun part2(file: File): String {
        val twoDArray = Utils.readFileInto2DArray(file)
        val digits = populateDigitMap(twoDArray)
        val gearMap: MutableMap<Pair<Int, Int>, MutableList<Int>> = mutableMapOf()
        for (digit in digits) {
            // populate the gear map
            doesNeighborHaveSymbol(twoDArray, digit.digit, digit.row, digit.minX, digit.maxX, gearMap)
        }

        println("Gear Map: $gearMap")

        var sumOfGearRatios = 0
        for (gear in gearMap.entries) {
            // Only care about this gear if there are 2 digits
            if (gear.value.size == 2) {
                val gearRatio = gear.value[0] * gear.value[1]
                sumOfGearRatios += gearRatio
            }

        }
        return sumOfGearRatios.toString()
    }

    private fun populateDigitMap(twoDArray: List<List<Char>>) : MutableList<DigitInGrid> {
        var digits: MutableList<DigitInGrid> = mutableListOf()
        // Loop over each row
        for (rowIndex in 0 until twoDArray.size) {
            var currentlyParsingDigit = false
            var digitBeingParsed = ""
            var minX = 0
            var maxX = Int.MAX_VALUE
            for (elementIndex in 0 until twoDArray[rowIndex].size) {
                val element: Char = twoDArray[rowIndex][elementIndex]
                // If this element is digit, check the neighbors to find a symbol
                if (element.isDigit()) {
                    if (!currentlyParsingDigit) {
                        minX = elementIndex
                    }
                    digitBeingParsed += element
                    currentlyParsingDigit = true
                } else if (currentlyParsingDigit) {
                    // Found our end condition
                    val finalDigit = digitBeingParsed.toInt()
                    currentlyParsingDigit = false
                    digits.add(DigitInGrid(finalDigit, minX, elementIndex - 1, rowIndex))
                    digitBeingParsed = ""
                }
            }

            // If we reach the last column, we need to stop parsing
            if (currentlyParsingDigit) {
                val finalDigit = digitBeingParsed.toInt()
                maxX = twoDArray[rowIndex].size - 1
                digits.add(DigitInGrid(finalDigit, minX, maxX, rowIndex))
            }
        }
        println("Digits list: $digits")
        return digits
    }

    private fun doesNeighborHaveSymbol(array2D: List<List<Char>>, digit: Int, row: Int, minCol: Int, maxCol: Int, gearMap: MutableMap<Pair<Int, Int>, MutableList<Int>>) : Boolean {
        val numRows = array2D.size
        val numCols = array2D[0].size

        // Define the relative positions of neighbors
        val neighbors = listOf(
            Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
            Pair(0, -1), /* Current position */ Pair(0, 1),
            Pair(1, -1), Pair(1, 0), Pair(1, 1)
        )

        for (col in minCol until maxCol + 1) {
            // Check each neighbor
            for ((rowOffset, colOffset) in neighbors) {
                val newRow = row + rowOffset
                val newCol = col + colOffset

                // Check if the neighbor is within bounds
                if (newRow in 0 until numRows && newCol in 0 until numCols) {
                    val neighbor = array2D[newRow][newCol]

                    if (!neighbor.isDigit() && neighbor != '.') {
                        println("Found symbol: $neighbor for element $row $col")
                        if (neighbor == '*') {
                            val pair = Pair(newRow, newCol)
                            if (gearMap.containsKey(pair)) {
                                gearMap[pair]?.add(digit)
                            } else {
                                gearMap[pair] = mutableListOf(digit)
                            }
                        }
                        return true
                    }
                }
            }
        }

        return false
    }

}