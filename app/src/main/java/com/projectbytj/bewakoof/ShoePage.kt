package com.projectbytj.bewakoof

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
/*
@Composable
fun ShoePage(navController: NavController ,viewModel: PageLink){

   // val Shoe = viewModel.selectedProduct.collectAsState()

    val xyz by viewModel.selectedProduct.collectAsState()


        Box(
            modifier = Modifier.fillMaxSize()
                //.padding(7.dp).clip(RoundedCornerShape(7))
                .background(Color.White)
        ) {

            LazyColumn(

            ) {
                items(1) {
                    xyz?.let {

                        // shoe image
                        Image(
                            painter = xyz!!.pic,
                            "home1",
                            modifier = Modifier.fillMaxHeight(0.7f)
                                .fillMaxWidth().align(Alignment.Center).padding(top = 10.dp),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Text(
                        "${xyz!!.name}",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontSize = 35.sp
                    )

                    Text(
                        "${xyz!!.Brand}",
                        modifier = Modifier.padding(start = 10.dp),
                        fontSize = 20.sp,
                        color = Color.Gray
                    )

                    Text(
                        "${xyz!!.Price}",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontSize = 30.sp
                    )

                    Text(
                        "Inclusive all Taxes \n " +
                                "(Also include all applicable duties)",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontSize = 15.sp,
                        color = Color.Gray
                    )

                    Text(
                        "discription , anfwjnflthis ia a demo prohject inthsi htejr is no description and there is only one thng to make and that is  so muxh money",
                        modifier = Modifier.padding(10.dp),
                        fontSize = 9.sp,
                    )


                    //  HorizontalDivider(thickness = 1.dp, color = Color.Black)

                    /*
                LazyVerticalGrid(columns = androidx.compose.foundation.lazy.grid.GridCells.Fixed(2)){
                    items(6){
                        Text("2uk")}
                }
             */


                    val Dunks: List<Int> = listOf(2, 4, 5, 6, 8, 9)
                    shoeSize(Dunks)




                    Text(
                        "scription , anfwjnflthis ia a demo prohject inthsi htejr is no description and there" +
                                "discription , anfwjnflthis ia a demo prohject inthsi htejr is no description and there" +
                                "discription " +

                                " is only one thng to make and that is  so muxh money",
                        modifier = Modifier.padding(25.dp),
                        fontSize = 11.sp,
                    )

                    Text(
                        "Reviews ",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontSize = 20.sp,
                        color = Color.Gray
                    )


                }}





//back button
            Button(onClick = { navController.navigate("menNAV") },
                modifier = Modifier.align(Alignment.TopStart))
            {
                Text("Back")
            }


//Like Button
            Button(
                onClick = { navController.navigate("menNAV") },
                modifier = Modifier.align(Alignment.CenterEnd)
            )
            {
                Text("Like")
            }

//Cart Button
            Button(onClick = { navController.navigate("menNAV") },
                modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(0.85f)
                    .padding(bottom = 10.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Color.White),
                border = ButtonDefaults.outlinedButtonBorder

            )
            {
                Text("Add to Bag", color = Color.Black)
            }



}}


 */
@Composable
fun ShoePage(navController: NavController, viewModel: PageLink) {

    val xyz by viewModel.selectedProduct.collectAsState()

    xyz?.let { product ->  // Use safe call to prevent null crashes
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {

                item {
                    // Shoe Image
                    Image(
                        painter = product.pic,  // Ensure 'pic' is a Painter
                        contentDescription = "Shoe Image",
                        modifier = Modifier
                            .fillMaxHeight(0.7f)
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .padding(top = 10.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = product.name,
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontSize = 35.sp
                    )

                    Text(
                        text = product.Brand,
                        modifier = Modifier.padding(start = 10.dp),
                        fontSize = 20.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "₹${product.Price}",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontSize = 30.sp
                    )

                    Text(
                        text = "Inclusive all Taxes \n(Also include all applicable duties)",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontSize = 15.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "Description: This is a demo project, so the description is not available.",
                        modifier = Modifier.padding(10.dp),
                        fontSize = 12.sp,
                    )

                    val shoeSizes: List<Int> = listOf(2, 4, 5, 6, 8, 9)
                    shoeSize(shoeSizes)

                    Text(
                        text = "Reviews",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontSize = 20.sp,
                        color = Color.Gray
                    )
                }
            }

            // Back Button
            Button(
                onClick = { navController.navigate("menNAV") },
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text("Back")
            }

            // Like Button
            Button(
                onClick = { /* Handle Like */ },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Text("Like")
            }

            // Cart Button
            Button(
                onClick = { /* Handle Add to Bag */ },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(0.85f)
                    .padding(bottom = 10.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Color.White),
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Text("Add to Bag", color = Color.Black)
            }
        }
    } ?: run {
        // Show this if product is null
        Text(
            text = "No product selected",
            modifier = Modifier.padding(16.dp),
            fontSize = 20.sp
        )
    }
}





@Composable
fun shoeSize( Shoesize : List<Int> ){

    var bgColor by remember {mutableStateOf(Color.White)}


    LazyRow(modifier = Modifier.padding(top = 20.dp , start = 10.dp)) {

        items(Shoesize){ size ->


                Box(
                    modifier = Modifier.padding(1.dp).border(BorderStroke(0.5.dp, Color.Gray))
                    .padding(10.dp).background(bgColor)
                        .clickable {
                            bgColor = if (bgColor == Color.White) {
                                Color.DarkGray
                            } else {
                                Color.White
                            }
                        }
                    ) {
                    Text("$size uk")



                }

        }
}}


