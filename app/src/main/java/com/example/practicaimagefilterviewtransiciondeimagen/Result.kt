package com.example.practicaimagefilterviewtransiciondeimagen

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class Result : AppCompatActivity() {
    lateinit var nameContact: TextView
    lateinit var description: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        nameContact = findViewById(R.id.name)
        description = findViewById(R.id.description)
        val toolbar2 = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarResult)
        val root = findViewById<TextView>(R.id.empty)
        setSupportActionBar(toolbar2)
        val intent = intent.extras
        val descriptionExtra = intent!!.getString("description")
        val transitionNameExtra = intent.getString("Transitionname")
        val name = intent.getString("name")
        root.transitionName = transitionNameExtra
        nameContact.text = name
        description.text = descriptionExtra
    }
}