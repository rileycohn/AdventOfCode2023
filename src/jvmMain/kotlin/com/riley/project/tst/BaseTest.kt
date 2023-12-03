package com.riley.project.tst

import java.io.File

open class BaseTest {

    fun getPart1File(day: String): File {
        return File("/Users/cohriley/Documents/Personal/AdventOfCode2023/src/jvmMain/kotlin/com/riley/project/tst/day$day/part1_example.txt")
    }

    fun getPart2File(day: String): File {
        return File("/Users/cohriley/Documents/Personal/AdventOfCode2023/src/jvmMain/kotlin/com/riley/project/tst/day$day/part2_example.txt")
    }

    fun getInputFile(day: String): File {
        return File("/Users/cohriley/Documents/Personal/AdventOfCode2023/src/jvmMain/kotlin/com/riley/project/tst/day$day/input.txt")
    }
}