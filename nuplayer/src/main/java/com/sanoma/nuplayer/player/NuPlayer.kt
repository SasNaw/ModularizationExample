package com.sanoma.nuplayer.player

import android.net.Uri
import timber.log.Timber

internal class NuPlayerMock(private val onPlayerStateChangedCallback: (State) -> Unit) {

    var state = State.STOPPED
        private set

    fun play(uri: Uri? = null) {
        state = State.PLAYING
        onPlayerStateChanged()
    }

    fun pause() {
        state = State.PAUSED
        onPlayerStateChanged()
    }

    fun stop() {
        state = State.STOPPED
        onPlayerStateChanged()
    }

    private fun onPlayerStateChanged() {
        Timber.d("### onPlayerStateChanged() - new state: $state")
        onPlayerStateChangedCallback(state)
    }

    enum class State {
        PLAYING,
        PAUSED,
        STOPPED
    }

}