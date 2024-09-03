package com.example.androidtvcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.PivotOffsets
import androidx.tv.foundation.lazy.list.TvLazyListScope
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.rememberTvLazyListState
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Surface
import com.example.androidtvcompose.ui.theme.AndroidTvComposeTheme
import com.example.androidtvcompose.ui.theme.Pink40
import com.example.androidtvcompose.ui.theme.Pink80

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTvComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top)
    ) {
        var selectedNav = remember {
            mutableStateOf(
                0
            )
        }
        Text(
            text = "ZamaonPrmie :3",
            modifier = modifier
                .padding(start = 8.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.headlineLarge.copy(
                color = Color.White,
            ),
            textAlign = TextAlign.Start
        )

        rememberLazyListState()
        LazyRow {
            items(12) { index ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillParentMaxWidth(0.35f)
                        .fillParentMaxHeight(0.4f)
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color.Blue.copy(alpha = 0.3f),
                                    Color.Black
                                )
                            ),
                            RoundedCornerShape(34.dp),
                        )
                        .border(
                            if (selectedNav.value == index) {
                                BorderStroke(1.dp, Color.White,)

                            } else {
                                BorderStroke(0.dp, Color.Black,)

                            },
                            RoundedCornerShape(34.dp)
                        )
                        .padding(12.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Watch Item ${index.inc()}",
                            style = MaterialTheme.typography.titleLarge.copy(
                                color = Color.White,
                            )
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White.copy(0.4f))
                                .height(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, device = "id:tv_4k")
@Composable
fun GreetingPreview() {
    AndroidTvComposeTheme {
        Greeting("Android")
    }
}