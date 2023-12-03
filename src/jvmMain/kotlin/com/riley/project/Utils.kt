package com.riley.project

import java.io.File

class Utils {

    companion object {
        fun readFileToList(file: File): List<String> {
            val lines = mutableListOf<String>()

            try {
                file.forEachLine { line ->
                    lines.add(line)
                }
            } catch (e: Exception) {
                // Handle exceptions, e.g., file not found, IO errors
                println("Error reading file: ${e.message}")
            }

            return lines
        }

        fun readFileInto2DArray(file: File): List<List<Char>> {
            val lines = file.readLines()

            return lines.map { line -> line.map { it } }

        }
    }


}