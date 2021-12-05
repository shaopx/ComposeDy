package com.spx.composedy.ui


import android.net.Uri
import android.util.Log
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.spx.composedy.R

@Composable
fun VideoPlayer(uri: Uri, index: Int, selected: Boolean, modifier: Modifier) {
  val context = LocalContext.current
  Log.i(TAG, "VideoPlayer[$index]: selected:$selected")

  val exoPlayer = remember {
    SimpleExoPlayer.Builder(context)
      .build()
      .apply {
        val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
          context,
          Util.getUserAgent(context, context.packageName)
        )

        val source = ProgressiveMediaSource.Factory(dataSourceFactory)
          .createMediaSource(uri)

        this.prepare(source)
      }
  }

  exoPlayer.playWhenReady = selected
  exoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
  exoPlayer.repeatMode = Player.REPEAT_MODE_ALL

  Column(modifier) {
    DisposableEffect(AndroidView(factory = {
      PlayerView(context).apply {
        Log.i(TAG, "VideoPlayer[$index]: in DisposableEffect")
        hideController()
        useController = false
        resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
        setShutterBackgroundColor(R.color.Black)
        player = exoPlayer
      layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
      }
    })) {
      onDispose {
        Log.i(TAG, "VideoPlayer[$index]: onDispose ")
        exoPlayer.release()
      }
    }
  }
}