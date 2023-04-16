package com.example.courselist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Details : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //Gets value sent from Directory activity
        val index: String? = this.intent.getStringExtra("listIndex")

        //Creates objects for each activity element
        val name: TextView = findViewById(R.id.facName)
        val phone: TextView = findViewById(R.id.facPhone)
        val email: TextView = findViewById(R.id.facEmail)
        val photo: ImageView = findViewById(R.id.ivProfile)

        //Assigns value to elements according to retrieved index
        when(index){
            "0" -> {
                name.text = "Ms. Natalie Rose"
                phone.text= "(876) 906-3000 ext: 4046"
                email.text = "ithod@ucc.edu.jm"
                photo.setImageResource(R.drawable.rose)
            }
            "1" -> {
                name.text = "Mrs. Sonia Davidson"
                phone.text= "(876) 906-3000 ext: 4044"
                email.text = "businessadminhod@ucc.edu.jm"
                photo.setImageResource(R.drawable.davidson)
            }

            "2" -> {
                name.text = "Mrs. Ionie Miller"
                phone.text= "(876) 906-3000 ext: 4019"
                email.text = "appliedpsychologyfaculty@ucc.edu.jm"
                photo.setImageResource(R.drawable.miller)
            }
            "3" -> {
                name.text = "Dr. Peter Ndajah"
                phone.text= "(876) 906-3000"
                email.text = "headofschoolsmathit@ucc.edu.jm"
                photo.setImageResource(R.drawable.ndajah)
            }
        }

        //Launches email client when email address is tapped
        email.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email.toString(), null))
            intent.putExtra(Intent.EXTRA_EMAIL, email.toString())
            startActivity(intent)
        }
    }
}