package com.sanoma.nuplayer.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.sanoma.nuplayer.R
import com.sanoma.nuplayer.player.NuPlayerMock
import kotlinx.android.synthetic.main.player_view.view.*

class PlayerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val player = NuPlayerMock {
        when (it) {
            NuPlayerMock.State.PLAYING -> {
                button.setImageResource(R.drawable.ic_pause)
                title.text = context.getString(R.string.title_play)
                subtitle.text = context.getString(R.string.subtitle_play)
            }
            NuPlayerMock.State.PAUSED -> {
                button.setImageResource(R.drawable.ic_stop)
                title.text = context.getString(R.string.title_pause)
                subtitle.text = context.getString(R.string.subtitle_paused)
            }
            NuPlayerMock.State.STOPPED -> {
                button.setImageResource(R.drawable.ic_play)
                title.text = context.getString(R.string.title_stopped)
                subtitle.text = context.getString(R.string.subtitle_stopped)
            }
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        button.setOnClickListener {
            when (player.state) {
                NuPlayerMock.State.PLAYING -> player.pause()
                NuPlayerMock.State.PAUSED -> player.stop()
                NuPlayerMock.State.STOPPED -> player.play()
            }
        }
    }

}