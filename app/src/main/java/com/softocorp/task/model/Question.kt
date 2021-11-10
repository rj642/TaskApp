package com.softocorp.task.model

class Question {
    private var question: String? = null
    private var option1: String? = null
    private var option2: String? = null
    private var option3: String? = null
    private var option4: String? = null
    private var answerKey: Int? = null

    fun Question() {

    }

    fun Question(question: String, option1: String, option2: String, option3: String, option4: String, answerKey: Int) {
        this.question = question
        this.option1 = option1
        this.option2 = option2
        this.option3 = option3
        this.option4 = option4
        this.answerKey = answerKey
    }

    fun getQuestion(): String? {
        return question
    }

    fun setQuestion(question: String) {
        this.question = question
    }

    fun setOption1(option1: String) {
        this.option1 = option1
    }

    fun setOption2(option2: String) {
        this.option2 = option2
    }

    fun setOption3(option3: String) {
        this.option3 = option3
    }

    fun setOption4(option4: String) {
        this.option4 = option4
    }

    fun getAnswerKey(): Int? {
        return answerKey
    }

}