package com.example.apistudiesproject.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.apistudiesproject.model.MovieModel

@Composable
fun HomeScreen() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.stateFlow.collectAsState()

    LazyColumn(content = {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }
        items(state) { item: MovieModel ->
            MovieImageCard(movieModel = item)
        }
    })

}

@Composable
fun MovieImageCard(movieModel: MovieModel) {
    val imagerPainter = rememberAsyncImagePainter(model = movieModel.image)

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = imagerPainter,
                contentDescription = null,
                modifier = Modifier.size(75.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.width(20.dp))
            Surface(
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f),
                contentColor = MaterialTheme.colors.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(text = "Movie Name:  ${movieModel.name}", color = Color.Black)
                    Text(text = "edited")
                }
            }
        }
    }
}