package com.example.courselist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CourseAdapter (context: Context, arrayOfData: ArrayList<CourseInfo>)  : BaseAdapter() {
    var arrayOfData : ArrayList<CourseInfo>
    private val mInflator: LayoutInflater

    init {
        this.arrayOfData = arrayOfData
        this.mInflator = LayoutInflater.from(context)
    }

    override fun getItem(position: Int): Any {
        return arrayOfData[position];
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayOfData.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.row_item, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }
        vh.courseCode.text = arrayOfData[position].course_code
        vh.courseName.text = ""+arrayOfData[position].course_name
        return view
    }

    private class ListRowHolder(row: View?) {
        public val courseCode: TextView
        public val courseName : TextView


        init {
            this.courseCode = row?.findViewById(R.id.courseCode) as TextView
            this.courseName = row?.findViewById(R.id.courseName) as TextView

        }
    }
}
