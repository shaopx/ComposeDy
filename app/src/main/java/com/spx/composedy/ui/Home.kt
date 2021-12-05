package com.spx.composedy.ui

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.spx.composedy.ComposeDyViewModel
import kotlin.math.absoluteValue

var TAG = "Home"

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Home() {
  var viewModel: ComposeDyViewModel = viewModel()

  Column(Modifier.fillMaxSize()) {
    val pagerState = rememberPagerState(initialPage = 0)
    VerticalPager(
      count = 100,
      state = pagerState,
      itemSpacing = 16.dp,
      modifier = Modifier
        .weight(1f)
        .fillMaxHeight(),
    ) { page ->
      val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
      Log.i(
        TAG,
        "Home: VideoPlayer select $page: currentPage:" + pagerState.currentPage
            + ",targetPage:" + pagerState.targetPage
            + ",currentPageOffset:" + pagerState.currentPageOffset
            + ",pageOffset:" + pageOffset
      )
      var url = viewModel.getVideoUrl(page)
      VideoPlayer(
        Uri.parse(url),
        page,
        page == pagerState.currentPage,
        modifier = Modifier
          .weight(1f)
          .fillMaxHeight()
      )
    }

    BottomBar()
  }
}