package com.dbottillo.departnow.feature.departures

import com.dbottillo.departnow.ApiResult
import com.dbottillo.departnow.AppBuildConfig
import com.dbottillo.departnow.BusStopTimetableResponse
import com.dbottillo.departnow.DeparturesApiInterface
import com.dbottillo.departnow.StationTimetableResponse
import javax.inject.Inject

class DeparturesRepository @Inject constructor(
    private val api: DeparturesApiInterface,
    private val appBuildConfig: AppBuildConfig
) {

    @Suppress("TooGenericExceptionCaught")
    suspend fun getStationTimetable(): ApiResult<StationTimetableResponse> {
        return try {
            val response = api.stationTimetable(
                station = "HRN",
                appId = appBuildConfig.transportAppId,
                appKey = appBuildConfig.transportAppKey,
                limit = STATION_TIMETABLE_LIMIT,
                live = true,
                trainStatus = STATION_TIMETABLE_TRAIN_STATUS_PASSENGER,
                type = STATION_TIMETABLE_TYPE_DEPARTURE,
                callingAt = "FPK"
            )
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return ApiResult.Success(body)
            }
            ApiResult.Error(Throwable("${response.code()} ${response.message()}"))
        } catch (e: Exception) {
            ApiResult.Error(Throwable(e.message ?: e.toString()))
        }
    }

    @Suppress("TooGenericExceptionCaught")
    suspend fun getBusDepartures(): ApiResult<BusStopTimetableResponse> {
        return try {
            val response = api.busStopTimetable(
                busStop = "490011232S",
                appId = appBuildConfig.transportAppId,
                appKey = appBuildConfig.transportAppKey,
                limit = STATION_TIMETABLE_LIMIT,
                live = true
            )
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return ApiResult.Success(body)
            }
            ApiResult.Error(Throwable("${response.code()} ${response.message()}"))
        } catch (e: Exception) {
            ApiResult.Error(Throwable(e.message ?: e.toString()))
        }
    }
}

private const val STATION_TIMETABLE_LIMIT = 20
private const val STATION_TIMETABLE_TRAIN_STATUS_PASSENGER = "passenger"
private const val STATION_TIMETABLE_TYPE_DEPARTURE = "departure"
