package com.example.courselist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TTAdapter (context: Context, arrayOfData: ArrayList<TimeTableInfo>)  : BaseAdapter() {
    var arrayOfData : ArrayList<TimeTableInfo>
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
            view = this.mInflator.inflate(R.layout.timetable_row, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }
        vh.ttCode.text = arrayOfData[position].course_code
        vh.ttName.text = ""+arrayOfData[position].course_name
        vh.ttDay.text = ""+arrayOfData[position].day
        vh.ttStart.text = ""+arrayOfData[position].start
        vh.ttEnd.text = ""+arrayOfData[position].end
        return view
    }

    private class ListRowHolder(row: View?) {
        public val ttCode: TextView
        public val ttName : TextView
        public val ttDay : TextView
        public val ttStart : TextView
        public val ttEnd : TextView

        init {
            this.ttCode = row?.findViewById(R.id.ttCode) as TextView
            this.ttName = row?.findViewById(R.id.ttName) as TextView
            this.ttDay = row?.findViewById(R.id.ttDay) as TextView
            this.ttStart = row?.findViewById(R.id.ttStart) as TextView
            this.ttEnd = row?.findViewById(R.id.ttEnd) as TextView
        }
    }
}
