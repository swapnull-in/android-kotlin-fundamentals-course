package com.swapnull.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.swapnull.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Swapnil Godambe")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.btnDone.setOnClickListener { addNickname(it) }
        binding.tvNickName.setOnClickListener { updateNickname(it) }
    }

    private fun addNickname(view: View) {

        binding.apply {
            myName?.nickname = etNickName.text.toString()
            invalidateAll()
            tvNickName.visibility = View.VISIBLE
            etNickName.visibility = View.GONE
            btnDone.visibility = View.GONE
        }

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {

        binding.apply {
            tvNickName.visibility = View.GONE
            etNickName.visibility = View.VISIBLE
            btnDone.visibility = View.VISIBLE
            etNickName.requestFocus()
        }

        // Show the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.etNickName, 0)
    }

}