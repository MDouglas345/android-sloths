package com.example.mld_cs3680_project1.displayimagesscreen

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.example.mld_cs3680_project1.R
import com.example.mld_cs3680_project1.position.position
import kotlin.random.Random


class DrawingView(context: Context, attributeSet: AttributeSet) : View(context,attributeSet){

    var m_context : Context = context

    var displayWidth : Int? = null
    var displayHeight : Int? = null

    init{


    }

    val drawable: Drawable? = ResourcesCompat.getDrawable(m_context.resources, R.drawable.sloth, null)
    val positions: MutableList<position> = mutableListOf<position>()

    val bitmap: Bitmap = BitmapFactory.decodeResource(m_context.resources,R.drawable.sloth);
    var paint: Paint = Paint()


    fun initArray(numOfDrawables: Int) {
        //displayWidth = layoutParams.width
        //displayHeight = layoutParams.height

        var array : IntArray =  IntArray(2)
        this.getLocationOnScreen(array)



        for (i in 1..numOfDrawables){
            positions.add(position((Random.nextFloat() * 300).toDouble(),(Random.nextFloat() * 3000).toDouble()))
        }

    }

    override fun onDraw(canvas: Canvas) {
        // call the super method to keep any drawing from the parent side.
        super.onDraw(canvas)
        canvas.drawColor(Color.YELLOW)




        for (position in positions){
            canvas.drawBitmap(bitmap, position.m_x.toFloat(), position.m_y.toFloat(), paint)
        }

    }


}

