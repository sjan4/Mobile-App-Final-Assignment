package com.example.courselist

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Timetable : AppCompatActivity() {

    private var helper = DatabaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timetable_list)

        var listData: ArrayList<TimeTableInfo> = helper.TimeTableList()

        var listView: ListView = findViewById(R.id.lvNames)
        var listAdapter = TTAdapter(this, listData)
        listView.adapter = listAdapter


    }
}