package com.example.animalquizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart : Button=findViewById(R.id.button)
        val edtTxt :EditText=findViewById(R.id.edt_st)
        btnStart.setOnClickListener(){
            if (edtTxt.text.isEmpty()){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show()
            }else{
                val intent=Intent(this,Quiz_Questions::class.java)

                intent.putExtra(Constants.userName,edtTxt.text.toString())
                startActivity(intent)
            }
        }
    }
}