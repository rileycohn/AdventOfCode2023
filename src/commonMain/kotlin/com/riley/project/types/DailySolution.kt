package com.riley.project.types

import kotlinx.serialization.Serializable

@Serializable
data class DailySolution(val day: String?, val part1Solution: String?, val part2Solution: String?) {
    override fun toString(): String {
        return "Solution for day $day:\nPart 1: $part1Solution\nPart2: $part2Solution"
    }
}
