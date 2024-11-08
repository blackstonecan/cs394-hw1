package com.example.cs394_hw1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load user data
        val csvData = CSVReader.readCsvFile(this, "MOCK_DATA.csv")
        val processedData: List<Data> = Data.strListToDataList(csvData)

        // Get reference to TextView and RecyclerView
        val userCountTextView: TextView = findViewById(R.id.userCountTextView)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Set the user count in the TextView
        val userCount = processedData.size
        userCountTextView.text = "User List | $userCount users listed"

        // Set up RecyclerView with the data
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DataAdapter(this, processedData)
    }
}
