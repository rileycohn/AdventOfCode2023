package com.riley.project.tst.day1

import com.riley.project.Day1
import com.riley.project.tst.BaseTest
import org.testng.Assert.assertEquals
import org.testng.annotations.Test
import java.io.File

class Day1Test : BaseTest() {

    @Test
    fun part1() {
        val result = Day1("1").part1(getPart1File("1"))
        assertEquals(result,"142")
    }

    @Test
    fun part2() {
        val result = Day1("1").part2(getPart2File("1"))
        assertEquals(result,"281")
    }

    @Test
    fun solve() {
        val result = Day1("1").solve(getInputFile("1"))
        println(result)
    }
}