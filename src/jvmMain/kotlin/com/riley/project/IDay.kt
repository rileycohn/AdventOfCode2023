package com.riley.project

import com.riley.project.types.DailySolution
import java.io.File

interface IDay {

    val day: String

    fun solve(file: File): DailySolution {
        return DailySolution(day, part1(file), part2(file))
    }

    fun part1(file: File): String

    fun part2(file: File): String

    fun getFilePath(): String {
        return "/Users/cohriley/Documents/Personal/AdventOfCode2023/src/jvmMain/kotlin/com/riley/project/inputs/day$day.txt"
    }
}