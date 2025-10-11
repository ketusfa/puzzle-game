package com.example.puzzlesgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StartActivity : AppCompatActivity() {

    private val imageList = listOf(
        R.drawable.one,
        R.drawable.two,
        R.drawable.three
    )
    private var currentImageIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView = findViewById<ImageView>(R.id.imageselect)
        val downButton = findViewById<Button>(R.id.buttonnext)
        val nextButton = findViewById<Button>(R.id.buttondown)

        updateImage(imageView)

        nextButton.setOnClickListener {
            currentImageIndex = (currentImageIndex + 1) % imageList.size
            updateImage(imageView)
        }

        downButton.setOnClickListener {
            currentImageIndex = (currentImageIndex - 1 + imageList.size) % imageList.size
            updateImage(imageView)
        }

        //val startButton: Button = findViewById(R.id.buttonst)
        val menuButton: Button = findViewById(R.id.buttonmenu)

        menuButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun updateImage(imageView: ImageView) {
        imageView.setImageResource(imageList[currentImageIndex])
    }

}