package com.example.animalquizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultAct : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvScore: String? =intent.getStringExtra(Constants.tvScore)
        val userName: String? =intent.getStringExtra(Constants.userName)
        val tvscore5: TextView=findViewById(R.id.tvscore5)
        tvscore5.text="Your score is ${tvScore} out of 5"
        val tvname4: TextView=findViewById(R.id.tvname4)
        tvname4.text="${userName}"

        val fin:Button=findViewById(R.id.btnFinish)
        fin.setOnClickListener(){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)}

    }
}