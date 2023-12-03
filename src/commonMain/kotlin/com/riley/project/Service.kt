package com.riley.project

import com.riley.project.types.DailySolution
import io.kvision.annotations.KVService

@KVService
interface ISolutionService {
    suspend fun solve(day: String): DailySolution
}
