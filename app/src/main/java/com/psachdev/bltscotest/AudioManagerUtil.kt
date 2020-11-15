package com.psachdev.bltscotest

import android.content.Context
import android.content.IntentFilter
import android.media.AudioManager

class AudioManagerUtil(private val context: Context) {
    private val mAudioManager: AudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private lateinit var scoStateChangeListener: ScoStateChangeListener

    fun startBltSco(){
        mAudioManager.startBluetoothSco()
    }

    fun stopBltSco(){
        mAudioManager.stopBluetoothSco()
    }

    fun isBltScoOn(): Boolean{
        return mAudioManager.isBluetoothScoOn
    }

    fun registerForBltScoStateChangeListener(scoStateChangeListener: ScoStateChangeListener){
        this.scoStateChangeListener = scoStateChangeListener
        val intentFilter = IntentFilter(AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED)
        context.registerReceiver(scoStateChangeListener, intentFilter)
    }

    fun unRegisterBltScoStateChangeListener(){
        if(::scoStateChangeListener.isInitialized) {
            context.unregisterReceiver(scoStateChangeListener)
        }
    }

}