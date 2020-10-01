package com.swapnull.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDone.setOnClickListener { addNickname(it) }
        tvNickName.setOnClickListener { updateNickname(it) }
    }

    private fun addNickname(view: View) {
        tvNickName.text = etNickName.text
        tvNickName.visibility = View.VISIBLE
        etNickName.visibility = View.GONE
        view.visibility = View.GONE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {

        view.visibility = View.GONE
        etNickName.visibility = View.VISIBLE
        btnDone.visibility = View.VISIBLE

        etNickName.requestFocus()

        // Show the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(etNickName, 0)
    }

}