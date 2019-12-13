package com.shmglickman.clickscounter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mCounter = 0

    private val  STATE_COUNTER ="SC"

    companion object {
        const val COUNTER_CURRENT_SCORE = "CCS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STATE_COUNTER, mCounter)
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        mCounter = savedInstanceState.getInt(STATE_COUNTER)
        updateCounterValue(mCounter)
        super.onRestoreInstanceState(savedInstanceState)
    }


    fun increaseCount(view: View) {
        mCounter++

        if (mCounter > 10) {
            navigateToSecondActivity()
            return
        }
        updateCounterValue(mCounter)
    }

    private fun updateCounterValue(counter: Int) {
        amTextViewCounter.text = counter.toString()
    }

    private fun navigateToSecondActivity() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        val openSecondActivity = Intent(this, SecondActivity::class.java)
//
//        openSecondActivity.putExtra(COUNTER_CURRENT_SCORE, mCounter)
//
//        startActivity(openSecondActivity)
        if (mCounter > 11) mCounter = 11
        SecondActivity.start(this, mCounter)
    }

}
