package com.example.sharedpreference

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var sharedPriference:SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etname = findViewById<EditText>(R.id.etname)
        var etpass = findViewById<EditText>(R.id.etpass)
        var tvname = findViewById<TextView>(R.id.tvName)
        var tvpass = findViewById<TextView>(R.id.tvPass)
        var btn1 = findViewById<Button>(R.id.btn1)
        var btn2 = findViewById<Button>(R.id.btn2)

   sharedPriference = getSharedPreferences("SharedPrieference", MODE_PRIVATE)

   btn1.setOnClickListener {
       var editor = sharedPriference.edit()
       editor.putString("Name",etname.text.toString())
       editor.putString("Password",etpass.text.toString())

       editor.apply()

       etname.setText("")
       etpass.setText("")

   }

btn2.setOnClickListener {
    tvname.text = sharedPriference.getString("Name", etname.text.toString())
    tvpass.text = sharedPriference.getString("Password", etpass.text.toString())

}






    }
}