package com.spx.composedy.ui

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun ExoPlayer(url: String, selected: Boolean) {
  val context = LocalContext.current

  val exoPlayer = remember {
    SimpleExoPlayer.Builder(context).build().apply {
      repeatMode = Player.REPEAT_MODE_ALL
    }
  }

  if (selected) {
    updateCurrentlyPlayingItem(exoPlayer = exoPlayer, url)

    exoPlayer.playWhenReady = false
  } else {
    exoPlayer.playWhenReady = false
  }

  Column {
    PlayerViewItem(exoPlayer = exoPlayer)
  }

//  val lifecycleOwner by rememberUpdatedState(LocalLifecycleOwner.current)
//  DisposableEffect(lifecycleOwner) {
//    val lifecycle = lifecycleOwner.lifecycle
//    val observer = LifecycleEventObserver { _, event ->
//      when (event) {
//        Lifecycle.Event.ON_PAUSE -> {
//          exoPlayer.playWhenReady = false
//        }
////        Lifecycle.Event.ON_RESUME -> {
////          exoPlayer.playWhenReady = true
////        }
//        Lifecycle.Event.ON_DESTROY -> {
//          exoPlayer.run {
//            stop()
//            release()
//          }
//        }
//      }
//    }
//    lifecycle.addObserver(observer)
//    onDispose {
//      lifecycle.removeObserver(observer)
//    }
//  }


}

@Composable
private fun PlayerViewItem(
  exoPlayer: SimpleExoPlayer
) {
  val context = LocalContext.current
  val playerView = PlayerView(context).apply {
    useController = false
  }
  Box {
    AndroidView(
      factory = { context ->
        playerView.apply {
          player = exoPlayer
        }
      }
    )
  }

}

@Composable
private fun updateCurrentlyPlayingItem(
  exoPlayer: SimpleExoPlayer,
  url: String
) {
  val context = LocalContext.current

  LaunchedEffect(url) {
    exoPlayer.apply {
      if (url != null) {
        setMediaItem(MediaItem.fromUri(Uri.parse(url)))
        prepare()
//        playWhenReady = true

      } else {
        stop()
      }
    }
  }
}