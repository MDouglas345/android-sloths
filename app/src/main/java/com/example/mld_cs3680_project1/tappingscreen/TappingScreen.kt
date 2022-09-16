package com.example.mld_cs3680_project1.tappingscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mld_cs3680_project1.R
import com.example.mld_cs3680_project1.communicator.Communicator
import com.example.mld_cs3680_project1.timer.Timer


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [TappingScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class TappingScreen : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var startedTimer = false
    private var timer : Timer? = null

    var comm : Communicator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        comm = requireActivity() as Communicator
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_tapping_screen, container, false)

        view.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                TappingScreen.NumOfTaps++
                Log.i("CS3680", "DEBUG: Touchdown with num of taps = ${TappingScreen.NumOfTaps}")

                if (!this.startedTimer) {
                    timer = Timer(2000, this::TimerCallback)
                    this.startedTimer = true
                }

            }

            v.performClick()
            true
        }
        return view
    }

    fun TimerCallback(){
        Log.i("CS3680", "DEBUG: Timer ended!")
        comm!!.passNumOfTaps(TappingScreen.NumOfTaps)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TappingScreen.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TappingScreen().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        var NumOfTaps:Int = 0
    }
}