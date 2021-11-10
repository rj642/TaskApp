package com.softocorp.task.adapter

import android.widget.TextView
import com.softocorp.task.R
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder


class ExaminationAdapter(val examName: String, val examTime: String, val totalMarks: String): Item<ViewHolder>() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.txtExaminationName).text = examName
        viewHolder.itemView.findViewById<TextView>(R.id.txtTime).text = examTime
        viewHolder.itemView.findViewById<TextView>(R.id.txtTotalMarks).text = totalMarks
    }

    override fun getLayout(): Int {
        return R.layout.recycler_examination_view
    }
}