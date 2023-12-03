package com.riley.project

import com.riley.project.types.DailySolution
import io.kvision.remote.getService

object Model {

    private val solutionService = getService<ISolutionService>()

    suspend fun solve(day: String): DailySolution {
        return solutionService.solve(day)
    }

}
