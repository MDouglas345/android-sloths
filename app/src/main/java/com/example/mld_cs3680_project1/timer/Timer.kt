package com.example.mld_cs3680_project1.timer

import android.os.CountDownTimer
import android.util.Log

class Timer constructor(length:Long, onEnd: () -> Unit){
     private var OnEndFunc : ()->Unit = onEnd
     private var time : Long = 0

    private var timer : CountDownTimer? = null

    init{
        OnEndFunc = onEnd
        time = length

         timer  = object  : CountDownTimer(length, 1000) {
            override fun onTick(p0: Long) {
                Log.i("CS3680", "We are ticking!")
            }

            override fun onFinish() {
                OnEndFunc()
            }
        }.start()

    }


}