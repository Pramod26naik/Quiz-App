package com.example.animalquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class Quiz_Questions : AppCompatActivity(), View.OnClickListener {

    private var mcurPos:Int=0
    private var mUserName:String?=null
    private var score: Int=0
    private var mQueList: ArrayList<Question>?=null
    private var mSelOptPos:Int=0

    private var progBar:ProgressBar?=null
    private var tvProg:TextView?=null
    private var tvQue:TextView?=null
    private var ivImg:ImageView?=null

    private var tvOp1:TextView?=null
    private var tvOp2:TextView?=null
    private var tvOp3:TextView?=null
    private var tvOp4:TextView?=null
    private var btnSubmit: Button?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUserName=intent.getStringExtra(Constants.userName)
        progBar=findViewById(R.id.progBar)
        tvQue=findViewById(R.id.tv_que)
        tvProg=findViewById(R.id.tvProg)
        ivImg=findViewById(R.id.iv_img)

        tvOp1=findViewById(R.id.op1)
        tvOp2=findViewById(R.id.op2)
        tvOp3=findViewById(R.id.op3)
        tvOp4=findViewById(R.id.op4)
        btnSubmit=findViewById(R.id.button)

        tvOp1?.setOnClickListener(this)
        tvOp2?.setOnClickListener(this)
        tvOp3?.setOnClickListener(this)
        tvOp4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

          mQueList = Constants.getQue()
        setQuestion()



    }

    private fun setQuestion() {
        defaultOptView()
        val question: Question = mQueList!![mcurPos]
        ivImg?.setImageResource(question.image)
        progBar?.progress = mcurPos+1
        tvProg?.text = "${mcurPos+1}/${progBar?.max}"
        tvQue?.text = question.question

        tvOp1?.text = question.op1
        tvOp2?.text = question.op2
        tvOp3?.text = question.op3
        tvOp4?.text = question.op4

        if(mcurPos==mQueList!!.size){
            btnSubmit?.text="FINISH"
        }else{
            btnSubmit?.text="SUBMIT"
        }
    }

    private fun defaultOptView(){
        val options = ArrayList<TextView>()
        tvOp1?.let{
            options.add(0,it)
        }
        tvOp2?.let{
            options.add(1,it)
        }
        tvOp3?.let{
            options.add(2,it)
        }
        tvOp4?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.opborder
//                R.drawable.selected_option
            )
        }

    }
    private fun selectedOptView(tv:TextView, selecOptNum: Int){
        defaultOptView()
        mSelOptPos=selecOptNum
        tv.setTextColor(Color.parseColor("#7A8089"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
//            R.drawable.opborder
            R.drawable.selected_option
        )
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.op1 -> {
                tvOp1?.let{
                    selectedOptView(it,1)
                }
            }

            R.id.op2 -> {
                tvOp2?.let{
                    selectedOptView(it,2)
                }
            }
            R.id.op3 -> {
                tvOp3?.let{
                    selectedOptView(it,3)
                }
            }
            R.id.op4 -> {
                tvOp4?.let{
                    selectedOptView(it,4)
                }
            }
            R.id.button->{
                if(mSelOptPos==0){
                    mcurPos++
                    when{
                        mcurPos<=mQueList!!.size->{
                            setQuestion()
                        }
                        else ->{
                            val intent= Intent(this,ResultAct::class.java)
                            intent.putExtra(Constants.tvScore,score.toString())

                        }
                    }

                }else{
                    val question = mQueList?.get(mcurPos)
                    if(question!!.ans != mSelOptPos){
                        answerView(mSelOptPos,R.drawable.wrong_opt_border)

                    }else{
                        score++;
                    }
                        answerView(question.ans,R.drawable.correct_option_border)


                         if(mcurPos==mQueList!!.size-1){
                             btnSubmit?.text="FINISH"
                             val btnVerify : Button=findViewById(R.id.button)

                             btnVerify.setOnClickListener(){
                                 val intent= Intent(this,ResultAct::class.java)
                                 intent.putExtra(Constants.tvScore,score.toString())
                                 intent.putExtra(Constants.userName,mUserName)

                                 startActivity(intent)



                             }

                         }else{
                             btnSubmit?.text="NEXT"
                         }
                        mSelOptPos=0

                }
            }
        }

    }
    private fun answerView(answer: Int,drawableView:Int){
        when(answer){
            1->{
                tvOp1?.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2->{
                tvOp2?.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3->{
                tvOp3?.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4->{
                tvOp4?.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }
    }

}