package com.example.cs394_hw1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private val context: Context, private val items: List<Data>) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

        // Set the click listener on the whole item
        holder.itemView.setOnClickListener {
            // Navigate to DetailActivity and pass all user data
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("USER_ID", item.id)
            intent.putExtra("USER_FIRST_NAME", item.first_name)
            intent.putExtra("USER_LAST_NAME", item.last_name)
            intent.putExtra("USER_EMAIL", item.email)
            intent.putExtra("USER_GENDER", item.gender)
            intent.putExtra("USER_IP_ADDRESS", item.ip_address)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.itemNameTextView)
        private val emailTextView: TextView = view.findViewById(R.id.itemEmailTextView)
        private val userIcon: ImageView = view.findViewById(R.id.userIcon)

        fun bind(data: Data) {
            nameTextView.text = data.first_name
            emailTextView.text = data.email

            // Set color based on gender (as we did before)
            val textColor = if (data.gender == "Male") {
                ContextCompat.getColor(context, R.color.blue_men)
            } else {
                ContextCompat.getColor(context, R.color.coral_women)
            }

            nameTextView.setTextColor(textColor)
            emailTextView.setTextColor(textColor)
            userIcon.setColorFilter(textColor)
        }
    }
}


