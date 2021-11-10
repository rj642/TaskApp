package com.softocorp.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.softocorp.task.adapter.ExaminationAdapter
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder

class MainActivity : AppCompatActivity() {

    private lateinit var btnAdd: ImageView
    private lateinit var txtUsername: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var spinner: Spinner
    var list_of_items = arrayOf("Natural Language Programming", "Data Science", "Operating System", "Object Detection Algorithms")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnAdd = findViewById(R.id.imgAdd)
        recyclerView = findViewById(R.id.recyclerView)
        txtUsername = findViewById(R.id.txtUsername)
        spinner = findViewById(R.id.spinner)

        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, list_of_items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(adapter)

        val dummyValue = GroupAdapter<ViewHolder>()
        dummyValue.add(ExaminationAdapter("Multi-Threading", "3 pm - 5 pm", "60"))
        dummyValue.add(ExaminationAdapter("Operating System Fundamentals", "3 pm - 5 pm", "60"))
        dummyValue.add(ExaminationAdapter("Time Management", "3 pm - 5 pm", "60"))
        dummyValue.add(ExaminationAdapter("Cryptography", "3 pm - 5 pm", "60"))
        recyclerView.adapter = dummyValue

        btnAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, CreateExamActivity::class.java)
            startActivity(intent)
        }


    }
}