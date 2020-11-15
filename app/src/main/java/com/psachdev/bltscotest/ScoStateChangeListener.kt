package com.psachdev.bltscotest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.widget.TextView
import android.widget.Toast

class ScoStateChangeListener(private val textView: TextView) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val state = intent.getIntExtra(AudioManager.EXTRA_SCO_AUDIO_STATE, -1)
        when {
            AudioManager.SCO_AUDIO_STATE_CONNECTED == state -> {
                Toast.makeText(context, context.getString(R.string.sco_connected), Toast.LENGTH_SHORT).show()
            }
            AudioManager.SCO_AUDIO_STATE_DISCONNECTED == state -> {
                Toast.makeText(context, context.getString(R.string.sco_disconnected), Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(context, context.getString(R.string.sco_unknown_state), Toast.LENGTH_SHORT).show()
            }
        }
    }
}