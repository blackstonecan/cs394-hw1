package com.example.cs394_hw1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Retrieve data from Intent
        val userId = intent.getIntExtra("USER_ID", -1)
        val userFirstName = intent.getStringExtra("USER_FIRST_NAME")
        val userLastName = intent.getStringExtra("USER_LAST_NAME")
        val userEmail = intent.getStringExtra("USER_EMAIL")
        val userGender = intent.getStringExtra("USER_GENDER")
        val userIpAddress = intent.getStringExtra("USER_IP_ADDRESS")

        // Display the data (assuming there are TextViews in your layout for each field)
        findViewById<TextView>(R.id.userNameTextView).text = "Name: $userFirstName $userLastName"
        findViewById<TextView>(R.id.userEmailTextView).text = "Email: $userEmail"
        findViewById<TextView>(R.id.userGenderTextView).text = "Gender: $userGender"
        findViewById<TextView>(R.id.userIpAddressTextView).text = "IP Address: $userIpAddress"
    }
}
