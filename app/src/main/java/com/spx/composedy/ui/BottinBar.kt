package com.spx.composedy.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spx.composedy.R
import com.spx.composedy.ui.theme.ComposeDyTheme


@Composable
fun BottomBar() {
  Row(
    Modifier.fillMaxWidth(1f).height(50.dp)
      .background(Color.Black),
    verticalAlignment = Alignment.CenterVertically
  ) {
    TextTabItem(title = "首页", Modifier.weight(1f))
    TextTabItem(title = "关注", Modifier.weight(1f))
    IconTabItem(Modifier.weight(1f))
    TextTabItem(title = "消息", Modifier.weight(1f))
    TextTabItem(title = "我", Modifier.weight(1f))
  }
}

@Composable
fun TextTabItem(title: String, modifier: Modifier = Modifier) {
  Column(
    modifier.padding(8.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Text(text = title, fontSize = 15.sp, color = Color.White)
  }
}

@Composable
fun IconTabItem(modifier: Modifier = Modifier) {
  Column(
    modifier.padding(8.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Icon(
      painterResource(id = R.drawable.add_bg),
      "post_icon", tint = Color.White, modifier = Modifier.size(32.dp)
    )
  }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
  ComposeDyTheme {
    BottomBar()
  }
}
