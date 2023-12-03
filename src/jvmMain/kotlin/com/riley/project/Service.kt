package com.riley.project

import com.riley.project.ISolutionService
import com.riley.project.types.DailySolution
import java.io.File

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class SolutionService : ISolutionService {

    override suspend fun solve(day: String): DailySolution {
        println(day)
        val solution: DailySolution = when (day.toInt()) {
            1 -> Day1(day).solve(getFile(day))
            else -> DailySolution(null, null, null)
        }
        return solution
    }

    private fun getFile(day: String): File {
        return File("/Users/cohriley/Documents/Personal/AdventOfCode2023/src/jvmMain/kotlin/com/riley/project/inputs/day$day.txt")
    }
}
