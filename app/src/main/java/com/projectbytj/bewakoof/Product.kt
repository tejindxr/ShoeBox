package com.projectbytj.bewakoof

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


data class product(
    val name : String ,
    val pic: Painter ,
    val category : String,
    val Price : Int ,
    val Brand : String
)
/*
var menShoe = listOf<product>(
    product("Adidas comfi co 1", painterResource(R.drawable.m1), "Men" , 10000, "Adidas") ,
    product("Adidas comfi co 2", painterResource(R.drawable.m2), "Men" , 12999, "Adidas") ,
    product("Adidas samba", painterResource(R.drawable.m3), "Men" , 9999, "Adidas"),
    product("Adidas air float", painterResource(R.drawable.m4), "Men" ,4999 , "Adidas"),
    product("Adidas Rainy Day", painterResource(R.drawable.m5), "Men" , 8599, "Adidas"),
    product("Adidas Big BOss", painterResource(R.drawable.m6), "Men" ,2999 , "Nike"),
    product("Adidas Big BOss", painterResource(R.drawable.m7), "Men" ,2999 , "Converse"),
    product("Adidas Big BOss", painterResource(R.drawable.m8), "Men" ,2999 , "Converse")

)


var femaleShoe = listOf<product>(
    product("Jordan 1", painterResource(R.drawable.f1), "Female" , 10000, "Nike") ,
    product("Lows  co 2", painterResource(R.drawable.f2), "Female" , 12999, "Converse") ,
    product("Flame co 4", painterResource(R.drawable.f3), "Female" , 9999, "Converse"),
    product("ASexy shoe", painterResource(R.drawable.f4), "Female" ,4999 , "Converse"),
    product("Blazers", painterResource(R.drawable.f5), "Female" , 8599, "Nike"),
    product("Nike Big BOss", painterResource(R.drawable.f6), "Female" ,2999 , "Nike"),
    product("Adidas Big BOss", painterResource(R.drawable.f7), "Female" ,12999 , "Adidas"),
    product("Nike Terminator", painterResource(R.drawable.f8), "Female" ,22999 , "Nike")

)
var kidShoe = listOf<product>(
    product("AirForce 1", painterResource(R.drawable.k1), "Kids" , 10000, "Nike") ,
    product("Converse 1", painterResource(R.drawable.k2), "Kids" , 12999, "Converse") ,
    product("Con high end", painterResource(R.drawable.k3), "Kids" , 9999, "Converse"),
    product("Lows Co ", painterResource(R.drawable.k4), "Kids" ,4999 , "Converse"),
    product("Nike Jordan 4", painterResource(R.drawable.k5), "Kids" , 8599, "Nike"),
    product("NIke Blazers Kids", painterResource(R.drawable.k6), "Kids" ,2999 , "Nike"),
    product("Adidas Big BOss", painterResource(R.drawable.k7), "Kids" ,12999 , "Adidas")
)

 */

@Composable
fun men(navController: NavController) {

    val menShoe =  listOf<product>(
        product("Adidas comfi co 1",painterResource(R.drawable.m1), "Men" , 10000, "Adidas") ,
        product("Adidas comfi co 2", painterResource(R.drawable.m2), "Men" , 12999, "Adidas") ,
        product("Adidas samba",  painterResource(R.drawable.m3), "Men" , 9999, "Adidas"),
        product("Adidas air float", painterResource(R.drawable.m4), "Men" ,4999 , "Adidas"),
        product("Adidas Rainy Day", painterResource(R.drawable.m5), "Men" , 8599, "Adidas"),
        product("Adidas Big BOss", painterResource(R.drawable.m6), "Men" ,2999 , "Nike"),
        product("Adidas Big BOss",  painterResource(R.drawable.m7), "Men" ,2999 , "Converse"),
        product("Adidas Big BOss",  painterResource(R.drawable.m8), "Men" ,2999 , "Converse")

    )


  //  val list1 = remember { mutableStateOf(menShoe) }
Column(modifier = Modifier.padding(top = 20.dp),
    verticalArrangement = Arrangement.Center) {
    Text("MEN'S SHOES" , fontSize = 20.sp)
    LazyVerticalGrid(GridCells.Fixed(2)){

        items(menShoe){item ->
            productCard(item)

        }
    }}}



@Composable
fun women(navController: NavController){



    var femaleShoe = listOf<product>(
        product("Jordan 1", painterResource(R.drawable.f1), "Female" , 10000, "Nike") ,
        product("Lows  co 2", painterResource(R.drawable.f2), "Female" , 12999, "Converse") ,
        product("Flame co 4", painterResource(R.drawable.f3), "Female" , 9999, "Converse"),
        product("ASexy shoe", painterResource(R.drawable.f4), "Female" ,4999 , "Converse"),
        product("Blazers", painterResource(R.drawable.f5), "Female" , 8599, "Nike"),
        product("Nike Big BOss", painterResource(R.drawable.f6), "Female" ,2999 , "Nike"),
        product("Adidas Big BOss", painterResource(R.drawable.f7), "Female" ,12999 , "Adidas"),
        product("Nike Terminator", painterResource(R.drawable.f8), "Female" ,22999 , "Nike")

    )


    //  val list1 = remember { mutableStateOf(menShoe) }
    Column(
        modifier = Modifier.padding(top = 20.dp),
        verticalArrangement = Arrangement.Center)
    {

             Text("WOMEN'S SHOES" , fontSize = 20.sp)
             LazyVerticalGrid(GridCells.Fixed(2)){

                      items(femaleShoe){item ->
                       productCard(item)

            }
        }}}
@Composable
fun child(navController: NavController){

    var kidShoe = listOf<product>(
        product("AirForce 1", painterResource(R.drawable.k1), "Kids" , 10000, "Nike") ,
        product("Converse 1", painterResource(R.drawable.k2), "Kids" , 12999, "Converse") ,
        product("Con high end", painterResource(R.drawable.k3), "Kids" , 9999, "Converse"),
        product("Lows Co ", painterResource(R.drawable.k4), "Kids" ,4999 , "Converse"),
        product("Nike Jordan 4", painterResource(R.drawable.k5), "Kids" , 8599, "Nike"),
        product("NIke Blazers Kids", painterResource(R.drawable.k6), "Kids" ,2999 , "Nike"),
        product("Adidas Big BOss", painterResource(R.drawable.k7), "Kids" ,12999 , "Adidas")
    )


    //  val list1 = remember { mutableStateOf(menShoe) }
    Column(modifier = Modifier.padding(top = 20.dp),
        verticalArrangement = Arrangement.Center) {
        Text("KID'S SHOES" , fontSize = 20.sp)
        LazyVerticalGrid(GridCells.Fixed(2)){

            items(kidShoe){item ->
                productCard(item)

            }
        }}}




@Composable
fun productCard(list: product){
    Card(
        modifier = Modifier.padding(8.dp),
        colors = CardDefaults.cardColors(Color.White),
        ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = list.pic,
                contentDescription = list.name,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
            )
            Text(text = list.name, style = MaterialTheme.typography.headlineMedium , fontSize = 20.sp )
            Text(text = list.Brand, style = MaterialTheme.typography.headlineMedium , fontSize = 15.sp)
            Text(text = "₹${list.Price}", style = MaterialTheme.typography.headlineMedium, fontSize = 20.sp)
        }
    }
}