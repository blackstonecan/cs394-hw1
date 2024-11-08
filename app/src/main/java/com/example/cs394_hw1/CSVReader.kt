package com.example.cs394_hw1

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

object CSVReader {

    fun readCsvFile(context: Context, fileName: String): List<String> {
        val result = mutableListOf<String>()

        try {
            context.assets.open(fileName).use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).use { reader ->
                    var line: String?
                    var pass = true
                    while (reader.readLine().also { line = it } != null) {
                        if (pass) {
                            pass = false
                            continue
                        }
                        if(line?.split(",")?.size == 6) {
                            result.add(line!!)
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }
}
