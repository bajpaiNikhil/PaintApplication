package com.example.paintapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paintapplication.MainActivity.Companion.paintBrush
import com.example.paintapplication.MainActivity.Companion.path

class PaintView : View {

    var params : ViewGroup.LayoutParams? = null

    companion object{
        var pathList = ArrayList<Path>()
        var colorList =  ArrayList<Int>()
        var currentBrush = Color.BLACK

    }

    constructor(context: Context) : this(context, null){
        init()
    }


    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()
    }


    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        paintBrush.isAntiAlias = true
        paintBrush.color = currentBrush
        paintBrush.style = Paint.Style.STROKE
        paintBrush.strokeJoin =  Paint.Join.ROUND
        paintBrush.strokeWidth = 8f

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT)

    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        val xCoordinate = event.x
        val yCoordinate = event.y

        when (event.action){
            MotionEvent.ACTION_DOWN->{
                path.moveTo(xCoordinate , yCoordinate)
                return true
            }
            MotionEvent.ACTION_MOVE ->{
                path.lineTo(xCoordinate , yCoordinate)
                pathList.add(path)
                colorList.add(currentBrush)
            }
            else ->{
                return false
            }
        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas) {

        for( i in pathList.indices){
            paintBrush.setColor(colorList[i])
            canvas.drawPath(pathList[i] , paintBrush )
            invalidate()
        }

    }



}