package com.riley.project.tst.day1

import com.riley.project.Day3
import com.riley.project.tst.BaseTest
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class Day3Test : BaseTest()  {

    @Test
    fun part1() {
        val result = Day3("3").part1(getPart1File("3"))
        assertEquals(result,"4361")
    }

    @Test
    fun part2() {
        val result = Day3("3").part2(getPart2File("3"))
        assertEquals(result,"467835")
    }

    @Test
    fun solve() {
        val result = Day3("3").solve(getInputFile("3"))
        println(result)
    }
}