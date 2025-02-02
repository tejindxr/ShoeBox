package com.projectbytj.bewakoof

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun homescreen(navController: NavController): Unit {



        LazyColumn {
        items(1) {

            Image(painter = painterResource(R.drawable.home1), "home1" , modifier = Modifier.fillMaxSize() , contentScale = ContentScale.Crop)

            Image(painter = painterResource(R.drawable.home2), "home1" , modifier = Modifier.fillMaxSize() , contentScale = ContentScale.Crop)
            Image(painter = painterResource(R.drawable.home3), "home1" , modifier = Modifier.fillMaxSize() , contentScale = ContentScale.Crop)

        }

    }

}
