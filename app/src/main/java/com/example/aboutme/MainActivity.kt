package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button).setOnClickListener { addNickName(it) }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener { updateNickName(it) }
    }

    private fun addNickName(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val textView = findViewById<TextView>(R.id.nickname_text)
        textView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        textView.visibility = View.VISIBLE
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickName(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButt = findViewById<Button>(R.id.done_button)
        editText.visibility = View.VISIBLE
        doneButt.visibility = View.VISIBLE
        view.visibility = View.GONE
        editText.requestFocus()
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText, 0)
    }
}