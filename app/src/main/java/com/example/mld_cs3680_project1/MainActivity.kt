package com.example.mld_cs3680_project1

/**
 *
 * First stab at android programming proper
 *
 * From what I understand so far...
 *
 * An app is broken into Activity objects that provide overarching functionality
 *
 * An Activity object can be further modularized into Fragment objects.
 *
 * A Fragment is a small part of the over arching functionality, and there tends to be
 * multiple fragments to achieve that functionality
 *
 * For example, an app that allows the user buys items will have a main Activity
 * It would have a fragment for selecting items, adding them to a cart
 * and it would have a fragment for checking out and totaling the price for the items
 *
 *
 * This first project is relatively simple :
 *
 * Create an app that makes the user tap as many times as they want,
 *                  and then shoot a photo up the number of times they have tapped the screen.
 *
 *
 * The main activity of this app is showing images to the screen X times
 *
 * The first fragment is just a screen that prompts the user to tap the screen as fast as they can in S seconds
 * The second fragment will take an image and throw them onto the screen X times
 *
 *
 * Plan change! Only 1 fragment and images come up (and fade?) as button taps come in
 *
 */


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.mld_cs3680_project1.communicator.Communicator
import com.example.mld_cs3680_project1.displayimagesscreen.displayimages
import com.example.mld_cs3680_project1.tappingscreen.TappingScreen

class MainActivity : AppCompatActivity(), Communicator {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun passNumOfTaps(taps: Int) {
        val bundle = Bundle()
        bundle.putInt("numoftaps", taps)

        val transaction = this.supportFragmentManager.beginTransaction()
        val displayImagesFrag = displayimages()
        displayImagesFrag.arguments = bundle

        transaction.replace(R.id.FragmentContainer, displayImagesFrag)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}