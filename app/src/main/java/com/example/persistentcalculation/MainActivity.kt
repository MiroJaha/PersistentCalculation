package com.example.persistentcalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var entry1: EditText
    private lateinit var entry2: EditText
    private lateinit var resultTV: TextView
    private var result: Float =0f

    /**/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*if(savedInstanceState!=null) {
            result = savedInstanceState.getFloat("myNumber", 0f)
        }*/


            entry1= findViewById(R.id.entry1)
        entry2= findViewById(R.id.entry2)
        resultTV= findViewById(R.id.resultTV)

    }

    fun multiply(view: View) {
        if (entry1.text.isNotBlank() && entry2.text.isNotBlank()) {
            result = entry1.text.toString().toFloat() * entry2.text.toString().toFloat()
            resultTV.text= result.toString()
        }
        else
            Toast.makeText(this,"Please Enter Valid Values",Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
        outState.putFloat("myNumber", result)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)
        result = savedInstanceState.getFloat("myNumber", 0f)
        resultTV.text= result.toString()
    }

}