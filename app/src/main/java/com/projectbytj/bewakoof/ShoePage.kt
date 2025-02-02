package com.projectbytj.bewakoof

import android.text.Layout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ShoePage(navController: NavController){


    Box (
            modifier = Modifier.fillMaxSize()
                //.padding(7.dp).clip(RoundedCornerShape(7))
                .background(Color.White)
        ){

    LazyColumn (

    ){
        items(1){


            // shoe image
                Image(
                    painter = painterResource(R.drawable.m1),
                    "home1",
                    modifier = Modifier.fillMaxHeight(0.7f)
                        .fillMaxWidth().align(Alignment.Center).padding(top = 10.dp),
                    contentScale = ContentScale.Crop
                )


                Text("Shoe Name" ,
                    modifier = Modifier.padding(top = 10.dp , start = 10.dp) ,
                    fontSize = 30.sp)
                
                Text("$ 1000" ,
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp) ,
                    fontSize = 40.sp)

                Text("discription , anfwjnflthis ia a demo prohject inthsi htejr is no description and there is only one thng to make and that is  so muxh money",
                    modifier = Modifier.padding(10.dp) ,
                    fontSize = 9.sp , )

                HorizontalDivider(thickness = 1.dp, color = Color.Black)

            /*
                LazyVerticalGrid(columns = androidx.compose.foundation.lazy.grid.GridCells.Fixed(2)){
                    items(6){
                        Text("2uk")}
                }
             */


                val Dunks : List<Int> = listOf(2 , 4 ,5 ,6 ,8 ,9)
                shoeSize(Dunks)


                Text("scription , anfwjnflthis ia a demo prohject inthsi htejr is no description and there" +
                        "discription , anfwjnflthis ia a demo prohject inthsi htejr is no description and there" +
                        "discription , anfwjnflthis ia a demo prohject inthsi htejr is no description and there" +
                        "discription , anfwjnflthis ia a demo prohject inthsi htejr is no description and there" +
                        "discription , anfwjnflthis ia a demo prohject inthsi htejr is no description and there" +
                        "discription , anfwjnflthis ia a demo prohject inthsi htejr is no description and there" +
                        "discription , anfwjnflthis ia a demo prohject inthsi htejr is no description and there" +
                        " is only one thng to make and that is  so muxh money",
                     modifier = Modifier.padding(10.dp) ,
                     fontSize = 9.sp , )





}

}


//back button
Button(onClick = {navController.navigate("menNAV")} ,
modifier = Modifier.align(Alignment.TopStart))
{
Text("Back")
}




//Like Button
Button(onClick = {navController.navigate("menNAV")},
modifier = Modifier.align(Alignment.CenterEnd))
{
Text("Like")
}

//Cart Button
Button(onClick = {navController.navigate("menNAV")} ,
modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(0.85f).padding(bottom = 10.dp) ,
shape = RectangleShape ,
colors = ButtonDefaults.buttonColors(Color.White),
border = ButtonDefaults.outlinedButtonBorder

)
{
Text("Add to Bag", color = Color.Black)
}


}






}

@Composable
fun shoeSize( Shoesize : List<Int> ){

    var bgColor = remember {mutableStateOf(Color.White)}


    LazyRow(modifier = Modifier.padding(top = 20.dp , start = 10.dp)) {

        items(Shoesize){ size ->


                Box(
                    modifier = Modifier.padding(1.dp).border(BorderStroke(0.5.dp, Color.Gray))
                    .padding(10.dp)
                        .background(bgColor)
                    .clickable {
                        onClick = {
                        }
                    }) {
                    Text("$size uk")



                }

        }
}}


