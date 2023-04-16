package com.example.courselist

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Admission : AppCompatActivity() {
    private lateinit var firstLine: TextView
    private lateinit var secLine: TextView
    private lateinit var thirdLine: TextView
    private lateinit var applyBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admission_activity)

        firstLine=findViewById(R.id.paraOne)
        secLine=findViewById(R.id.paraTwo)
        thirdLine=findViewById(R.id.paraThree)
        applyBtn=findViewById(R.id.btnApply)

        firstLine.text = "1.To be unconditionally admitted to complete UCC undergraduate programmes, individuals should possess a minimum of five (5) subjects" +
                    " at the GCE or CSEC level (including the mandatory English Language and Mathematics) at grades A, B, C or 1, 2, 3 respectively. A CSEC pass at " +
                    "level 3 must have been obtained since 1998."
        secLine.text="2.Candidates who have a minimum of 4 CXCs can also apply pending the outstanding CXC subjects or can opt to do UCC replacement " +
                     "courses Core Mathematics, English for Academic Purpose and Fundamentals of Accounting."
        thirdLine.text="3.Candidates can opt to apply under the Mature Entry option. To be accepted, applicants must be working for 5 years or more and be " +
                        "at a minimum age of 25 years. Academic qualifications, a detailed resume, a job letter and 3 professional references will be required."

        applyBtn.setOnClickListener {
            val intent = Intent(this, Application::class.java)
            startActivity(intent)
        }
    }
}