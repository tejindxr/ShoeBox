package com.projectbytj.bewakoof

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


var Liked =  mutableListOf<product>(
  //  product("Adidas comfi co 1",painterResource(R.drawable.m1), "Men" , 10000, "Adidas" ,"Men" ) ,


)


@Composable
fun likepage(navController: NavController, viewModel: PageLink) {




    Column(modifier = Modifier.padding(top = 20.dp),
        verticalArrangement = Arrangement.Center) {


        heading("Liked ")

        if (Liked.isEmpty() ){
            Image(painterResource(R.drawable.liked_doodle), "Liked doodle",
                modifier = Modifier.alpha(0.5f))
        }
        else{
        LazyVerticalGrid(GridCells.Fixed(2)){

            items(Liked){item ->
                productCard(item , navController , viewModel)

            }
        }

        }
    }

}


