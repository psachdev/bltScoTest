package com.psachdev.bltscotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var mAudioManagerUtil: AudioManagerUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAudioManagerUtil = AudioManagerUtil(this)
        mAudioManagerUtil.registerForBltScoStateChangeListener(ScoStateChangeListener())
    }

    override fun onDestroy() {
        super.onDestroy()
        mAudioManagerUtil.unRegisterBltScoStateChangeListener()
    }
}