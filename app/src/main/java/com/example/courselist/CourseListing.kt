package com.example.courselist

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class CourseListing : AppCompatActivity() {

    private var helper = DatabaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_list)

        var listData: ArrayList<CourseInfo> = helper.listOfCourses()

        var listView: ListView = findViewById(R.id.lvCourse)
        var listAdapter = CourseAdapter(this, listData)
        listView.adapter = listAdapter


        listView.setOnItemClickListener { _, _, position, _ ->
            var intent = Intent(this, Display::class.java)
            intent.putExtra("DISPLAY", false)
            intent.putExtra("ID",listData[position].id)
            startActivity(intent)
        }

    }
}