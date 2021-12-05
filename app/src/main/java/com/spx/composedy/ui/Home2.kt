package com.spx.composedy.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.spx.composedy.ComposeDyViewModel
import com.spx.composedy.Greeting
import com.spx.composedy.PagerSampleItem
import com.spx.composedy.R
import com.spx.composedy.ui.theme.ComposeDyTheme

@OptIn(ExperimentalPagerApi::class)
@ExperimentalPagerApi
@Composable
fun Home2() {
  var viewModel: ComposeDyViewModel = viewModel()
  Column(Modifier.fillMaxSize()) {
    val pagerState = rememberPagerState()

    // Display 10 items
    VerticalPager(
      count = 10,
      state = pagerState,
      // Add some vertical spacing between items
//      contentPadding = PaddingValues(vertical = 1.dp),
      itemSpacing = 16.dp,
      modifier = Modifier
        .weight(1f).background(color = Color.Black)
        .fillMaxHeight(),
    ) { page ->
      PagerSampleItem(
        viewModel.getVideoUrl(page),
        page = page,
        page == pagerState.currentPage,
        modifier = Modifier.fillMaxSize()
      )
    }

    BottomBar()
  }
}

//@Preview(showBackground = true)
//@Composable
//fun Home2Preview() {
//  ComposeDyTheme {
//    Home2()
//  }
//}