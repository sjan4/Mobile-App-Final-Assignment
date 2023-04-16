package com.example.courselist

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 3) {

    companion object {
        val DATABASE_NAME = "courses.db"
        val TABLE_NAME = "courses"
        val TT_TABLE_NAME="timetable"
        val ID = "ID"
        val course_code = "CODE"
        val course_name= "NAME"
        val credits = "CREDITS"
        val prereq = "PREREQ"
        val des="DESCRIPTION"}
        val day="DAY"
        val start="START"
        val endTime ="ENDTIME"


    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("create table $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT,CODE TEXT,NAME TEXT,CREDITS TEXT, PREREQ TEXT, DESCRIPTION TEXT)")
        db.execSQL("create table $TT_TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT,CODE TEXT,NAME TEXT,DAY TEXT, START TEXT, ENDTIME TEXT)")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
            db.execSQL("DROP TABLE IF EXISTS " + TT_TABLE_NAME)
            onCreate(db)

    }

    //Insert data into user_table
    fun insertData(CODE: String, NAME: String,CREDITS: String,PREREQ: String,DES:String) {
        val db = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put(course_code, CODE)
        contentValues.put(course_name, NAME)
        contentValues.put(credits, CREDITS)
        contentValues.put(prereq,PREREQ)
        contentValues.put(des,DES)
        db.insert(TABLE_NAME, null, contentValues)
    }

    //List all users in user_table
    fun listOfCourses(): ArrayList<CourseInfo>  {
        val db = this.writableDatabase
        val res = db.rawQuery("select * from " + TABLE_NAME, null)
        val courseList = ArrayList<CourseInfo>()
        while (res.moveToNext()) {
            var courseInfo = CourseInfo()
            courseInfo.id = Integer.valueOf(res.getString(0))
            courseInfo.course_code = res.getString(1)
            courseInfo.course_name = res.getString(2)
            courseInfo.credits = res.getString(3)
            courseInfo.prereq = res.getString(4)
            courseInfo.des = res.getString(5)
           courseList.add(courseInfo)
        }
        return courseList
    }




    //Insert data into user_table
    fun insertTimeTableData(CODE: String, NAME: String,DAY: String,START: String,ENDTIME:String) {
        val db = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put(course_code, CODE)
        contentValues.put(course_name, NAME)
        contentValues.put(day, DAY)
        contentValues.put(start,START)
        contentValues.put(endTime,ENDTIME)
        db.insert(TT_TABLE_NAME, null, contentValues)
    }

    //List all users in user_table
    fun TimeTableList(): ArrayList<TimeTableInfo>  {
        val db = this.writableDatabase
        val res = db.rawQuery("select * from " + TT_TABLE_NAME, null)
        val TimeTableList = ArrayList<TimeTableInfo>()
        while (res.moveToNext()) {
            var timetableInfo = TimeTableInfo()
            timetableInfo.id = Integer.valueOf(res.getString(0))
            timetableInfo.course_code = res.getString(1)
            timetableInfo.course_name = res.getString(2)
            timetableInfo.day = res.getString(3)
            timetableInfo.start = res.getString(4)
            timetableInfo.end = res.getString(5)
            TimeTableList.add(timetableInfo)
        }
        return TimeTableList
    }



    @SuppressLint("Range")
    fun getParticularUserData(id: String): CourseInfo {
        var userInfo  = CourseInfo()
        val db = this.readableDatabase
        val selectQuery = "SELECT  * FROM " + TABLE_NAME + " WHERE " + ID + " = '" + id + "'"
        val cursor = db.rawQuery(selectQuery, null)
        try {
            if (cursor.getCount() != 0) {
                cursor.moveToFirst();
                if (cursor.getCount() > 0) {
                    do {
                        userInfo.id = cursor.getInt(cursor.getColumnIndex(ID))
                        userInfo.course_code = cursor.getString(cursor.getColumnIndex(course_code))
                        userInfo.course_name = cursor.getString(cursor.getColumnIndex(course_name))
                        userInfo.credits = cursor.getString(cursor.getColumnIndex(credits))
                        userInfo.prereq = cursor.getString(cursor.getColumnIndex(prereq))
                        userInfo.des = cursor.getString(cursor.getColumnIndex(des))
                    } while ((cursor.moveToNext()));
                }
            }
        } finally {
            cursor.close();
        }
        return userInfo
    }


}