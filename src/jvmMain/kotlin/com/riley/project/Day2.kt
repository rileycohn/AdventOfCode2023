package com.riley.project

import java.io.File

class Day2(override val day: String) : IDay {

    override fun part1(file: File): String {
        val games = Utils.readFileToList(file)
        val totalCubes = mapOf("red" to 12, "green" to 13, "blue" to 14)
        var possibleGames = 0
        for (index in games.indices) {
            var validGame = true
            println("Game ${index + 1}")
            // simply loop over the colors and regex the number in front of it and compare to map
            for (color in totalCubes.keys) {
                val regex = Regex("""(\b\d+\b)\s+$color""")
                val matches = regex.findAll(games[index])
                val tooManyOfColor = matches
                    .filter { it.groupValues[1].toInt() > totalCubes[color]!! }
                    .map { it.groupValues[1].toInt() }.toList()
                if (tooManyOfColor.isNotEmpty()) {
                    validGame = false
                    break
                }
            }

            if (validGame) {
                println("Found Valid Game: ${index + 1}")
                possibleGames += index + 1
            }
        }

        return possibleGames.toString()

    }

    override fun part2(file: File): String {
        val games = Utils.readFileToList(file)
        var sumOfPowers = 0
        for (index in games.indices) {
            val minCubesPerColor = mutableMapOf("red" to 0, "blue" to 0, "green" to 0)
            println("Game ${index + 1}")
            // simply loop over the colors and regex the number in front of it and compare to map
            for (color in minCubesPerColor.keys) {
                val regex = Regex("""(\b\d+\b)\s+$color""")
                val matches = regex.findAll(games[index])
                val maxForColor = matches
                    .map { it.groupValues[1].toInt() }
                    .toList()
                    .max()
                println("Max for color $color : $maxForColor")
                if (maxForColor > minCubesPerColor[color]!!) {
                    minCubesPerColor[color] = maxForColor
                }
            }

            // Now do the power
            val power = minCubesPerColor.values.reduce {acc, value -> acc * value}
            println("Power: $power")
            sumOfPowers += power
        }

        return sumOfPowers.toString()
    }
}