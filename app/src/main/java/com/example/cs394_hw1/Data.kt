package com.example.cs394_hw1

import java.io.Serializable
import android.util.Log

data class Data(
    val id: Int,
    val first_name: String,
    val last_name: String,
    val email: String,
    val gender: String,
    val ip_address: String
) : Serializable {
    companion object {
        @JvmStatic
        fun stringToData(data: String): Data? {
            val splitData = data.split(",")
            return try {
                // Ensure we have enough parts before accessing indices
                if (splitData.size >= 6) {
                    Data(
                        id = splitData[0].toInt(),
                        first_name = splitData[1],
                        last_name = splitData[2],
                        email = splitData[3],
                        gender = splitData[4],
                        ip_address = splitData[5]
                    )
                } else {
                    Log.e("DATA", "Invalid data format: $data")
                    null
                }
            } catch (e: Exception) {
                Log.e("DATA", "Error parsing data: $data", e)
                null
            }
        }

        @JvmStatic
        fun strListToDataList(dataList: List<String>): List<Data> {
            val result = mutableListOf<Data>()
            for (data in dataList) {
                stringToData(data)?.let { result.add(it) }
            }
            return result
        }
    }
}
