package com.example.shualeduridaigi


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val text1=findViewById<EditText>(R.id.editText1)
        val text2=findViewById<EditText>(R.id.editText2)
        val myButton=findViewById<Button>(R.id.myButton)

        myButton.setOnClickListener {
            val resultText1= text1.text.toString()
            val resultText2 = text2.text.toString()
            if(resultText1 == "" || resultText2=="") {
                Toast.makeText(this,"გრაფა ცარიელია",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, first::class.java).also {
                    it.putExtra("firstPlayer", resultText1)
                    it.putExtra("secondPlayer", resultText2)
                }
                startActivity(intent)
            }

        }








    }
}