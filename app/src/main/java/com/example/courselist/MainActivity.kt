package com.example.courselist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    internal var helper = DatabaseHandler(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val course: ImageView = findViewById(R.id.courseBtn)
        course.setOnClickListener {
            val intent = Intent(this, CourseListing::class.java)
            startActivity(intent)
        }

        val social: ImageView = findViewById(R.id.socialsBtn)
        social.setOnClickListener {
            val intent = Intent(this, Socials::class.java)
            startActivity(intent)
        }

        val directory: ImageView = findViewById(R.id.directoryBtn)
        directory.setOnClickListener {
            val intent = Intent(this, Directory::class.java)
            startActivity(intent)
        }

        val timetable: ImageView = findViewById(R.id.timetableBtn)
        timetable.setOnClickListener{
            val intent = Intent(this, Timetable::class.java)
            startActivity(intent)
        }

        val admission: ImageView = findViewById(R.id.admissionBtn)
        admission.setOnClickListener{
            val intent = Intent(this, Admission::class.java)
            startActivity(intent)
        }


        helper.insertData("ITT313","Fundamentals of Computer Graphic Designs","3","NONE", "This foundation course explores the essential knowledge students need to create, design and edit images in any graphical design software.  Students will use the concepts explored in this course in advertising, graphic design, web design, illustration, broadcast design, photography and game design and many others. Assessment will be based on technical understanding and creative use of resources for the completion of various assignments using Photoshop or Illustrator and InDesign.")
        helper.insertData("ITT203","Data Structure & File Mgt I","3","Object Oriented Programming using C++", "This course will introduce basic algorithms and data structures in computer science.  It will also introduce students to the mathematical analysis of algorithms, and provide efficient programming techniques.")
        helper.insertData("ITT408","Information Assurance And Security","3","NONE", "The information technology (IT) professional must understand, apply, and manage information assurance and security (IAS) in computing, communication, and organizational systems. It is also important for the IT professional to provide users with a framework to be sufficiently security aware to be an asset to the organization rather than a liability. This course includes operational issues, policies and procedures, attacks and defense mechanisms, risk analyses, recovery, and information security. ")
        helper.insertData("ITT304","Database Management Systems II","3","Database Management Systems I", "This course is aimed at providing upper level undergraduate students with intermediate to advanced concepts in data modelling design and database administration. The course explores the variety of options available in database development and administration for current and future use on particular software platform technologies.")
        helper.insertData("MKT201","Principle of Marketing","3","NONE", "This introductory course in marketing will expose students to the fundamentals and principles of marketing. Participants will gain a general knowledge of marketing, marketing research, consumer behavior, designing and developing products and the pricing and placing of products. Emphasis will be placed during the course on the application of the marketing principles to real world situations. \n" +
                "\n" +
                "The course does not assume prior knowledge of core concepts; therefore a great deal of reading is obligatory.  The discipline of the subject matter will entail that students shed biases and prejudices for the adoption of an open mind in dealing with the content.")
        helper.insertData("ITT411","Project +","3","System Analysis & Design II", "This course is aimed at providing the student with the tools and techniques needed for successful Project management. The references will mainly be drawn from IT-related projects. This course will certify that the successful candidate has important core knowledge of the project life-cycle, roles and skills necessary to effectively initiate, plan, execute, monitor/control and close a project. ")
        helper.insertData("ITT300","Discrete Mathematics II","3","Discrete Math I", "This course builds on the fundamentals of discrete mathematics covered in Discrete Structures I.  The main focus will be on developing a sound theoretical foundation for further work in computer science and information science.  The topics covered in this course will not be exhaustive to discrete structures but will provide the basis for pursuing other advanced courses in discrete structures and mathematics.")
        helper.insertData("ITT318","Cloud Computing","3","NONE", " This course is designed to introduce the concept of cloud computing as the new computing technology and will explore the different computing technologies, including infrastructure as a Service, Platform, Software and Physical Systems. Real case scenarios and market cloud based tools will be introduced and identified in order to provide students with a better understanding of cloud computing applications.")
        helper.insertData("ITT306","IT Audit And Control","3","NONE", "This course introduces the fundamental concepts of the information technology audit and control function. The main focus of this course is on understanding information controls, the types of controls and their impact on the organization, and how to manage and audit them. The concepts and techniques used in information technology audits will be presented. Students will learn the process of creating a control structure with goals and objectives, audit an information technology infrastructure against it, and establish a systematic remediation procedure for any inadequacies. The challenge of dealing with best practices, standards, and regulatory requirements governing information and controls is addressed.\n" +
                "The course will be taught using lectures and seminars, which will focus on the advanced principles, theories and practices of systems analysis and design. The lectures will cover some of the advanced topics relative to the course, which students need to be familiar with in order to practice in the field. More advanced case studies will also be used to bring students closer to practical situations. In these case studies, students will be expected to present materials in simulation with real projects. The assignments may be based on advanced case material presented in the textbook(s) or other cases provided by the lecturer, at the lecturer’s discretion.")
        helper.insertData("ITT420","Mobile Application Development","3","NONE", "This course will introduce students to the core conceptual skills and basic practices needed to develop an Android application.  The course will focus on how the application communicates to retrieve, store and interact with other devices on any android platform. Topics will include memory management, user interface design, user interface building, input methods, data handling, and network techniques.")


        helper.insertTimeTableData("ITT313","Fundamentals of Computer Graphic Designs","Thur","6:00 pm", "8:00 pm")
        helper.insertTimeTableData("ITT203","Data Structure & File Mgt I","Tue","6:00 pm", "8:00 pm")
        helper.insertTimeTableData("ITT408","Information Assurance And Security","Mon","6:00 pm", "8:00 pm")
        helper.insertTimeTableData("ITT304","Database Management Systems II","Sun","8:00 pm", "10:00 pm")
        helper.insertTimeTableData("MKT201","Principles of Marketing","Sun","4:00 pm", "6:00 pm")
        helper.insertTimeTableData("ITT411","Project +","Mon","8:00 pm", "10:00 pm")
        helper.insertTimeTableData("ITT300","Discrete Mathematics II","Sun","2:00 pm", "4:00 pm")
        helper.insertTimeTableData("ITT318","Cloud Computing","Sun","2:00 pm", "4:00 pm")
        helper.insertTimeTableData("ITT306","IT Audit And Control","Sun","8:00 pm", "10:00 pm")
        helper.insertTimeTableData("ITT420","Mobile Application Development","Sun","4:00 pm", "6:00 pm")

    }

}