package com.projectbytj.bewakoof

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


data class drawerItem(
    val name: String,
    val color: Color,
    val bg: Painter,
    val dis: String,
    val route : String ,
    var faltru : String
    )

@Composable
fun drawerCard(navController: NavController){
    var items = listOf<drawerItem>(
        drawerItem("MEN" , color = Color.Black, painterResource(  R.drawable.man)  ,"men" , "menNAV"  , "MEN"),
        drawerItem("WOMEN" , color = Color.Black, painterResource(  R.drawable.woman)  ,"Women" ,"womenNAV" , "WOMEN" ),
        drawerItem("KIDS" , color = Color.Black, painterResource(  R.drawable.baby)  ,"kids" , "childNAV" , "KIDS"),
        drawerItem("SALE" , color = Color.Black, painterResource(  R.drawable.coupon)  ,"sale" , "", "")
    )
    for (item in items){
        Card(

            modifier = Modifier.fillMaxWidth(0.75f).height(80.dp).padding(vertical = 20.dp).background(color = Color.White),

            ){
            Row( modifier = Modifier.padding(start = 20.dp) ,
            ) {
                item.faltru = remember { mutableStateOf(false) }.toString()
                Image( item.bg  , item.dis  , modifier = Modifier.padding(end = 10.dp))

                Text(item.name , color = item.color , fontSize = 25.sp , modifier = Modifier.clickable {
                    navController.navigate(item.route)
                    item.faltru = true.toString()
                })
            }


        }
    }

}



