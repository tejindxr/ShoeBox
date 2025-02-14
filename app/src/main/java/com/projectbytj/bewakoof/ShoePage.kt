package com.projectbytj.bewakoof

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun ShoePage(navController: NavController, viewModel: PageLink) {

    val Shoe by viewModel.selectedProduct.collectAsState()

    Shoe?.let { product ->  // Use safe call to prevent null crashes
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize().clip(RoundedCornerShape(10.dp))
                .background(Color.White)

        ) {

            LazyColumn(modifier = Modifier.fillMaxSize()
            ) {

                item {
                    // Shoe Image
                    Image(
                        painter = painterResource(product.pic),  // Ensure 'pic' is a Painter
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
                        fontSize = 25.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        text = product.Brand,
                        modifier = Modifier.padding(start = 10.dp),
                        fontSize = 15.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "₹${product.Price}",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontSize = 25.sp ,
                        fontWeight = FontWeight.Bold

                    )

                    Text(
                        text = "Inclusive all Taxes \n(Also include all applicable duties)",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontSize = 10.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "Description: This is a demo project, so the description is not available.",
                        modifier = Modifier.padding(10.dp),
                        fontSize = 10.sp,
                    )

                    val shoeSizes: List<Int> = listOf(2, 4, 5, 6, 8, 9)
                    product.sizeSelected = shoeSize(shoeSizes)

                    Text(
                        text = "Reviews",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontSize = 15.sp,
                        color = Color.Gray
                    )
                }
            }


            // Back Button
            IconButton(
                onClick = { navController.navigate("menNAV") },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(2.dp)
            ) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }


            // Like Button

            var isLiked by remember { mutableStateOf(product in Liked) }
            var likeheart by remember {  mutableStateOf(if (isLiked) R.drawable.likefilled else R.drawable.like) }

            IconButton(

                    onClick = {
                        if (Shoe != null) {
                        if (isLiked) {
                            Liked.remove(Shoe!!)
                            likeheart = R.drawable.like
                        } else {
                            Liked.add(Shoe!!)
                            likeheart = R.drawable.likefilled
                        }
                            isLiked = !isLiked  // Toggle state
                        }
                              },
                    modifier = Modifier.align(Alignment.CenterEnd)
            ){
                Icon(painter = painterResource( likeheart) ,"heart" ,
                    tint = Color.Red,
                    modifier = Modifier.fillMaxHeight(0.75f))
            }








            // Cart Button

            var atccolor by remember { mutableStateOf(if (Shoe in Cart) Color.Black else Color.White) }
            var atcText by remember { mutableStateOf(if (Shoe in Cart) "View Cart" else "Add to Bag") }
            var atcTextColor by remember { mutableStateOf(if (Shoe in Cart) Color.White else Color.Black) }
            var inCart by remember { mutableStateOf(product in Cart) }



            Button(
                onClick =
                    {
                      if (inCart) {
                          navController.navigate("cartNAV")
                        }
                      else{
                          atccolor = Color.Black
                          atcText = "View Cart"
                          atcTextColor = Color.White
                          Cart.add(Shoe!!)
                          inCart = true
                      }
                          },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(0.85f)
                    .padding(bottom = 10.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(atccolor),
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Text(atcText, color = atcTextColor)
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
fun shoeSize( Shoesize : List<Int>  ): Int? {
    var selectedSize by remember { mutableStateOf<Int?>(null) }



    LazyRow(modifier = Modifier.padding(top = 20.dp , start = 10.dp)) {

        items(Shoesize){ size ->

            val isSelected = selectedSize == size
            val bgColor = animateColorAsState(if (isSelected) Color.Black else Color.White, label = "")
            val textColor = animateColorAsState(if (isSelected) Color.White else Color.Black, label = "")

            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(8.dp))
                    .background(bgColor.value)
                    .padding(vertical = 8.dp, horizontal = 16.dp)
                    .clickable { selectedSize = size }
            ) {
                Text(
                    text = "$size UK",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = textColor.value
                )

        }
}}
return selectedSize
}


