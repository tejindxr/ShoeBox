package com.projectbytj.bewakoof

import android.graphics.Typeface
import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun homescreen(navController: NavController): Unit {



        LazyColumn {
        items(1) {


            Box() {



                Column {

                    Box {
                        Image(
                            painter = painterResource(R.drawable.home1),
                            "home1",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )


                    }


                    Image(
                        painter = painterResource(R.drawable.menmodel),
                        "home1",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Text("Shop the latest collection\n Adidas Sambas \n 20% off ",
                    color = Color.White ,
                    fontSize = 40.sp ,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    modifier = Modifier.align(androidx.compose.ui.Alignment.Center)
                )

                Button(onClick = {navController.navigate("menNAV")} ,
                    shape = RectangleShape ,
                    modifier = Modifier.align(androidx.compose.ui.Alignment.BottomCenter).padding(bottom = 20.dp),
                    colors = ButtonDefaults.buttonColors(Color.White) ){
                    Text("Shop MEN" , color = Color.Black)
                }

            }
            Box {

                Column{
                    Image(
                        painter = painterResource(R.drawable.home2),
                        "home1",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    Image(
                        painter = painterResource(R.drawable.womenmodel),
                        "home1",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Text("Shop for the\n" +
                          "latest\n" +
                          "Jordan 1's",
                    color = Color.White ,
                    fontSize = 40.sp ,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    textAlign = TextAlign.End,
                    modifier = Modifier.align(androidx.compose.ui.Alignment.CenterEnd).padding(bottom = 60.dp)
                )


                Button(onClick = {navController.navigate("womenNAV")} ,
                    shape = RectangleShape ,
                    modifier = Modifier.align(androidx.compose.ui.Alignment.BottomCenter).padding(bottom = 20.dp),
                    colors = ButtonDefaults.buttonColors(Color.White) ){
                    Text("Shop WOMEN" , color = Color.Black)
                }


            }
            Box{
                Column {


                    Image(
                        painter = painterResource(R.drawable.home3),
                        "home1",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Image(
                        painter = painterResource(R.drawable.kidsmodel),
                        "home1",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Text("Check the\n" +
                        "latest\n" +
                        "Kids Collection",
                    color = Color.White ,
                    fontSize = 40.sp ,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    modifier = Modifier.align(androidx.compose.ui.Alignment.TopCenter).padding(top = 100.dp)
                )

                Button(onClick = {navController.navigate("childNAV")} ,
                    shape = RectangleShape ,
                    modifier = Modifier.align(androidx.compose.ui.Alignment.BottomCenter).padding(bottom = 20.dp),
                    colors = ButtonDefaults.buttonColors(Color.White) ){
                    Text("Shop KIDS" , color = Color.Black)
                }

            }



            // this is the footer of the front page .
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF0A1B4E))

            ){
                Text("Contact Us \uD83D\uDCDE\n" +
                        "\uD83D\uDCCD Address: XYZ Tower, 4th Floor, MG Road, Bangalore, India - 560001\n\n" +
                        "\uD83D\uDCE7 Email: support@shoeboxapp.com\n\n" +
                        "\uD83D\uDCDE Customer Support: +91 98765 43210\n\n" +
                        "\n" +
                        "Follow Us \uD83D\uDCF2\n\n" +
                        "\uD83C\uDF10 Website: www.shoeboxapp.com\n\n" +
                        "\uD83D\uDCF7 Instagram: @shoeboxapp\n\n" +
                        "\uD83D\uDCD8 Facebook: Shoebox Official\n\n" +
                        "\uD83D\uDC26 Twitter (X): @shoeboxapp\n\n" +
                        "\n" +
                        "© 2025 Shoebox App. All rights reserved."

                            , color = Color.White , fontSize = 8.sp ,
                            fontStyle = androidx.compose.ui.text.font.FontStyle.Normal ,
                           // fontFamily = FontFamily(Typeface.SERIF) ,
                            modifier = Modifier.padding(10.dp)
                )

            }

        }

    }

}
