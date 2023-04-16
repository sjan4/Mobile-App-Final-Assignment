package com.example.courselist

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Display : AppCompatActivity() {

    private var helper = DatabaseHandler(this)
    var isFull: Boolean = false;
    var id: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val txtCode: TextView = findViewById(R.id.txtCode)
        val txtName: TextView = findViewById(R.id.txtName)
        val txtCredit: TextView = findViewById(R.id.txtCredit)
        val txtPrereq: TextView = findViewById(R.id.txtPrereq)
        val txtDes: TextView = findViewById(R.id.txtDes)

        isFull = intent.getBooleanExtra("DISPLAY", true);
        id = intent.getIntExtra("ID", 0)

        if (!isFull) {
            var user = helper.getParticularUserData("" + id)
            txtCode.setText(user.course_code)
            txtName.setText("" + user.course_name)
            txtCredit.setText("" + user.credits)
            txtPrereq.setText(user.prereq)
            txtDes.setText(user.des)


        }


    }
}