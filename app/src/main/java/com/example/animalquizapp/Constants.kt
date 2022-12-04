package com.example.animalquizapp

object Constants {
    const val userName: String="username"
    const val total_que: String="total questions"
    const  val tvScore :String="total score"
    fun getQue():ArrayList<Question>{
        val queList=ArrayList<Question>()
        val q1=Question(
            1,"Name of this animal ?",R.drawable.panda,
            "Tiger","Lion","Panda","Gorilla",3
        )
        queList.add(q1)

        val q2=Question(
            2,"Name of this animal ?",R.drawable.redpanda,
            "RedPanda","Lion","Panda","Gorilla",1
        )
        queList.add(q2)

        val q3=Question(
            3,"Name of this animal ?",R.drawable.penguin,
            "Cheetah","Lion","Penguin","Gorilla",3
        )
        queList.add(q3)

        val q4=Question(
            4,"Name of this animal ?",R.drawable.turtle,
            "Tortoise","Turtle","Fish","Gorilla",2
        )
        queList.add(q4)

        val q5=Question(
            5,"Name of this animal ?",R.drawable.wilderbeast,
            "WilderBeast","Lion","Wild Ox","Gorilla",1
        )
        queList.add(q5)



        return queList
    }
}