package com.example.shualeduridaigi


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast



class first : AppCompatActivity(),View.OnClickListener{
    private lateinit var btn1:Button
    private lateinit var btn2:Button
    private lateinit var btn3:Button
    private lateinit var btn4:Button
    private lateinit var btn5:Button
    private lateinit var btn6:Button
    private lateinit var btn7:Button
    private lateinit var btn8:Button
    private lateinit var btn9:Button
    private lateinit var resetButton:Button
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private var scoreFirst=0
    private var scoreSecond=0
    private var endGame=0
    private lateinit var textView4:TextView
    private lateinit var textView5:TextView
    private lateinit var textView6:ImageView
    private lateinit var textView7:ImageView
    private var image=0
    private var activePlayer=1
    private var firstPlayer= mutableListOf<Int>()
    private var secondPlayer= mutableListOf<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)


        init()

        textView4=findViewById(R.id.textview4)
        textView5=findViewById(R.id.textview5)


        resetButton.setOnClickListener {
            reset()
        }

    }


    private fun init() {
        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        btn4 = findViewById(R.id.button4)
        btn5 = findViewById(R.id.button5)
        btn6 = findViewById(R.id.button6)
        btn7 = findViewById(R.id.button7)
        btn8 = findViewById(R.id.button8)
        btn9 = findViewById(R.id.button9)
        resetButton=findViewById(R.id.button10)
        textView1=findViewById(R.id.textview1)


        val resultFirst=intent.extras?.getString("firstPlayer")
        val resultSecond=intent.extras?.getString("secondPlayer")

        textView2=findViewById<TextView?>(R.id.textview2).apply {
            text=resultFirst
        }

        textView3=findViewById<TextView?>(R.id.textview3).apply {
            text=resultSecond
        }

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)

    }

    override  fun onClick(clickedView: View?){
        if (clickedView is Button){
            var buttonNumber=0
            when(clickedView.id){
                R.id.button1 -> buttonNumber=1
                R.id.button2 -> buttonNumber=2
                R.id.button3 -> buttonNumber=3
                R.id.button4 -> buttonNumber=4
                R.id.button5 -> buttonNumber=5
                R.id.button6 -> buttonNumber=6
                R.id.button7 -> buttonNumber=7
                R.id.button8 -> buttonNumber=8
                R.id.button9 -> buttonNumber=9


            }
            if (buttonNumber !=0){
                playGame(clickedView,buttonNumber)
            }

        }

    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {

        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        } else if (activePlayer == 2) {
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.GREEN)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }

        clickedView.isEnabled = false

        if (endGame == 0) {
            check()
        }

        if (endGame == 1) {
            activePlayer = 3
        }

    }


    private fun check(){
        var winnerPlayer=0
        if(firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer=1
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer=2
        }

        if(firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer=1
        }
        if(secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer=2
        }
        if(firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer=1
        }
        if(secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer=2
        }

        if(firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer=1
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer=2
        }

        if(firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer=1
        }
        if(secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer=2
        }
        if(firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer=1
        }
        if(secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer=2
        }

        if(firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer=1
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer=2
        }

        if(firstPlayer.contains(7) && firstPlayer.contains(5) && firstPlayer.contains(3)){
            winnerPlayer=1
        }
        if(secondPlayer.contains(7) && secondPlayer.contains(5) && secondPlayer.contains(3)){
            winnerPlayer=2
        }

        if(winnerPlayer==1){
            val resultFirst=intent.extras?.getString("firstPlayer")
            Toast.makeText(this,"Winner  Is  ${resultFirst}",Toast.LENGTH_LONG).show()
            scoreFirst+=1
            textView4.text=scoreFirst.toString()
            endGame=1
            textView6=findViewById(R.id.textview6)
            textView6.setImageResource(R.drawable.ic_crown)
            image=1
        }

        if(winnerPlayer==2){

            val resultSecond=intent.extras?.getString("secondPlayer")
            Toast.makeText(this,"Winner  Is  ${resultSecond}" ,Toast.LENGTH_LONG).show()
            scoreSecond+=1
            textView5.text=scoreSecond.toString()
            textView7=findViewById(R.id.textview7)
            textView7.setImageResource(R.drawable.ic_crown)
            image=2

        }

        if(firstPlayer.size+secondPlayer.size==9 && winnerPlayer==0){
            Toast.makeText(this,"It  Is  A  Draw",Toast.LENGTH_LONG).show()
        }


    }



    private fun reset() {
        btn1.text=""
        btn1.setBackgroundColor(Color.BLUE)
        btn2.text=""
        btn2.setBackgroundColor(Color.BLUE)
        btn3.text=""
        btn3.setBackgroundColor(Color.BLUE)
        btn4.text=""
        btn4.setBackgroundColor(Color.BLUE)
        btn5.text=""
        btn5.setBackgroundColor(Color.BLUE)
        btn6.text=""
        btn6.setBackgroundColor(Color.BLUE)
        btn7.text=""
        btn7.setBackgroundColor(Color.BLUE)
        btn8.text=""
        btn8.setBackgroundColor(Color.BLUE)
        btn9.text=""
        btn9.setBackgroundColor(Color.BLUE)

        firstPlayer.clear()
        secondPlayer.clear()
        activePlayer=1
        endGame=0


        btn1.isEnabled=true
        btn2.isEnabled=true
        btn3.isEnabled=true
        btn4.isEnabled=true
        btn5.isEnabled=true
        btn6.isEnabled=true
        btn7.isEnabled=true
        btn8.isEnabled=true
        btn9.isEnabled=true

        if(image==1){
            textView6.setImageResource(R.drawable.ic_baseline_email_24)
            image=0
        }else if(image==2) {
            textView7.setImageResource(R.drawable.ic_baseline_email_24)
            image=0
        }



    }



}