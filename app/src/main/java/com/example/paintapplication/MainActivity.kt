package com.example.paintapplication

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.paintapplication.PaintView.Companion.colorList
import com.example.paintapplication.PaintView.Companion.currentBrush
import com.example.paintapplication.PaintView.Companion.pathList

class MainActivity : AppCompatActivity() {

    companion object{

        var path = Path()
        var paintBrush  = Paint()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val redButton = findViewById<ImageButton>(R.id.redColor)
        val blueButton = findViewById<ImageButton>(R.id.blueColor)
        val yellowButton = findViewById<ImageButton>(R.id.yellowColor)
        val whiteButton = findViewById<ImageButton>(R.id.whiteColor)


        redButton.setOnClickListener {
            paintBrush.color = Color.RED
            currentColor(paintBrush.color)
        }

        blueButton.setOnClickListener {
            paintBrush.color = Color.BLUE
            currentColor(paintBrush.color)
        }

        yellowButton.setOnClickListener {
            paintBrush.setColor(Color.YELLOW)
            currentColor(paintBrush.color)
        }

        whiteButton.setOnClickListener {
            pathList.clear()
            colorList.clear()
            path.reset()
        }
    }

    private fun currentColor(color: Int){
        currentBrush = color
        path =  Path()
    }

}