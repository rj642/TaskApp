package com.softocorp.task

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.addTextChangedListener
import java.util.*
import android.widget.DatePicker
import java.text.SimpleDateFormat


class CreateExamActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var btnNext: Button
    private lateinit var spinner: Spinner
    private lateinit var datePicker: EditText
    private val calendar = Calendar.getInstance()
    private lateinit var timePicker: EditText
    var list_of_items = arrayOf("Natural Language Programming", "Data Science", "Operating System", "Object Detection Algorithms")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_exam)

        toolbar = findViewById(R.id.toolbar)
        btnNext = findViewById(R.id.btnNext)
        spinner = findViewById(R.id.spinner)
        datePicker = findViewById(R.id.datePicker)
        timePicker = findViewById(R.id.etTimePicker)


        timePicker.setOnClickListener {
            timePicker()
        }

        val date =
            OnDateSetListener { view, year, monthOfYear, dayOfMonth -> // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateLabel()
            }

        datePicker.setOnClickListener {
            DatePickerDialog(this@CreateExamActivity, date, calendar
                .get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        val adapter = ArrayAdapter(this@CreateExamActivity, android.R.layout.simple_spinner_item, list_of_items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(adapter)

        btnNext.setOnClickListener {
            setContentView(R.layout.activity_create_exam_new)
            val etAddQuestion = findViewById<EditText>(R.id.etAddNewQues)
            val llOption1 = findViewById<LinearLayout>(R.id.lloptionA)
            val llOption2 = findViewById<LinearLayout>(R.id.lloptionB)
            val llOption3 = findViewById<LinearLayout>(R.id.lloptionC)
            val llOption4 = findViewById<LinearLayout>(R.id.lloptionD)
            etAddQuestion.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s.toString().trim().length > 0) {
                        llOption2.visibility = View.VISIBLE
                        llOption3.visibility = View.VISIBLE
                        llOption4.visibility = View.VISIBLE
                    } else {
                        llOption2.visibility = View.GONE
                        llOption3.visibility = View.GONE
                        llOption4.visibility = View.GONE
                    }
                }

                override fun afterTextChanged(s: Editable?) {

                }

            })
        }

        setUpToolbar()

    }

    private fun updateLabel() {
        val format: String = "MM/dd/yy"
        val sdf = SimpleDateFormat(format, Locale.US)
        datePicker.setText(sdf.format(calendar.time))
    }

    private fun timePicker() {
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val second = calendar.get(Calendar.SECOND)
        val timePickerDialog = TimePickerDialog(this@CreateExamActivity, object: TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                timePicker.setText("$hourOfDay : $minute : 00")
            }

        }, hour, minute, false)
        timePickerDialog.show()
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

}