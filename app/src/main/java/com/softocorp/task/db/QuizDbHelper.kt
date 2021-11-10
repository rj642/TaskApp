package com.softocorp.task.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class QuizDbHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
): SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private val TABLE_NAME = "quiz_questions"
        private val COLUMN_QUESTION = "question"
        private val COLUMN_OPTION1 = "option1"
        private val COLUMN_OPTION2 = "option2"
        private val COLUMN_OPTION3 = "option3"
        private val COLUMN_OPTION4 = "option4"
        private val COLUMN_ANSWER_KEY = "answerkey"
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "TaskQuiz.db"
        private val _ID = "id"
    }

    private var db: SQLiteDatabase? = null

    override fun onCreate(db: SQLiteDatabase?) {
        this.db = db

        val SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_QUESTION + " TEXT, " +
                COLUMN_OPTION1 + " TEXT, " +
                COLUMN_OPTION2 + " TEXT, " +
                COLUMN_OPTION3 + " TEXT, " +
                COLUMN_OPTION4 + " TEXT, " +
                COLUMN_ANSWER_KEY + " INTEGER" +
                ")"
        db?.execSQL(SQL_CREATE_QUESTION_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }
}