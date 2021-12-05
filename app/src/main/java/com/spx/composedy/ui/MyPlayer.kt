package com.spx.composedy.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.spx.composedy.ComposeDyViewModel


@Composable
fun MyPlayer(index:Int, videoUrl:String, play:Boolean) {
//  const val TAG ="MyPlayer"
//  val sampleVideo = "http://txmov6.a.yximgs.com/ksc1/MnGQs_16aR9OgiLHaKsWDLGch6pZW7I-ZqlVC5mwBwoOkCAoTmSQpfnuWQevXzY3g5OuNmFdntQlSGYVLtIUZUrIlNk4oWuu2vaW0Iw7WpBEBbNluWH1jrLQCCi0wSAF0XoKyHxN8N0LkCswtX4R0wgmCrsvUQaFZA4QT-sgNYahvd-U_9aFI7bwfOY3rXkV.mp4?tag=1-1638269079-n-0-5967be10b83044ab-3d4b358efb604372&clientCacheKey=3xnz7exfguyeisa_b.mp4&tt=b&di=b44c958d&bp=10531"
  var viewModel: ComposeDyViewModel = viewModel()
  val context = LocalContext.current
  val player = SimpleExoPlayer.Builder(context).build()
  val playerView = PlayerView(context).apply {
    useController = false
  }
  Log.i(TAG, "MyPlayer[$index][$play]: "+playerView)
  val mediaItem = MediaItem.fromUri(videoUrl)
  var selectedTab by remember { mutableStateOf(0) }
  val playWhenReady by remember {
    mutableStateOf(true)
  }
  player.setMediaItem(mediaItem)
  player.addListener(object :Player.Listener{
    override fun onEvents(player: Player, events: Player.Events) {
      super.onEvents(player, events)
    }
  })
  playerView.player = player
  LaunchedEffect(player) {
    player.prepare()
    player.playWhenReady = playWhenReady
  }
  playWhenReady.or(play)
  AndroidView(factory = {
    playerView
  })
}