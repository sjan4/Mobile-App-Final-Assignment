package com.example.courselist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Directory : AppCompatActivity() {
    private val mail: String = "ithod@ucc.edu.jm"
    private lateinit var mailBtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_directory)

        mailBtn = findViewById(R.id.mail)

        //Reads faculty list from items in strings.xml file
        val facultyList: Array<String> = resources.getStringArray(R.array.faculty)
        //Creates adapter that sets list type and list item
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, facultyList)

        val listView: ListView = findViewById(R.id.lvFaculty)
        //ListView control populated with list items
        listView.adapter = adapter

        //Defines action when list item is clicked
        listView.setOnItemClickListener { parent, view, position, id ->
            //Displays a message showing list item index
            Toast.makeText(this, "Clicked item : "+position, Toast.LENGTH_SHORT).show()
            //Specifies which activity should be launched
            val intent = Intent(this, Details::class.java);
            //Stores index number to be shared with Details activity
            intent.putExtra("listIndex", position.toString());
            //Starts activity
            this.startActivity(intent);
        }

        mailBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", mail, null))
            intent.putExtra(Intent.EXTRA_EMAIL, mail)
            startActivity(intent)
        }
    }
}