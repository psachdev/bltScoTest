package com.psachdev.bltscotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mAudioManagerUtil: AudioManagerUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAudioManagerUtil = AudioManagerUtil(this)
        mAudioManagerUtil.registerForBltScoStateChangeListener(ScoStateChangeListener(isBltScoOn))
        startBltSco.setOnClickListener {
            mAudioManagerUtil.startBltSco()
            isBltScoOn.text = mAudioManagerUtil.isBltScoOn().toString()
        }
        stopBltSco.setOnClickListener {
            mAudioManagerUtil.stopBltSco()
            isBltScoOn.text = mAudioManagerUtil.isBltScoOn().toString()
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        mAudioManagerUtil.unRegisterBltScoStateChangeListener()
    }
}