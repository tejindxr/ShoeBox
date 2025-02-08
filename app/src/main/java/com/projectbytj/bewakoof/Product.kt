package com.projectbytj.bewakoof

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


public final data class product(
    val name : String ,
    val pic: Painter ,
    val category : String,
    val Price : Int ,
    val Brand : String ,
    val sunCategory : String
)

class PageLink : ViewModel() {
    private val _selectedProduct = MutableStateFlow<product?>(null)
    val selectedProduct: StateFlow<product?> = _selectedProduct

    fun setProduct(product: product) {
        _selectedProduct.value = product
    }
}

@Composable
fun men(navController: NavController , viewModel: PageLink) {

    val menShoe =  listOf<product>(
        product("Adidas comfi co 1",painterResource(R.drawable.m1), "Men" , 10000, "Adidas" ,"Men" ) ,
        product("Adidas comfi co 2", painterResource(R.drawable.m2), "Men" , 12999, "Adidas" , "Men" ) ,
        product("Adidas samba",  painterResource(R.drawable.m3), "Men" , 9999, "Adidas","Men" ),
        product("Adidas air float", painterResource(R.drawable.m4), "Men" ,4999 , "Adidas","Men" ),
        product("Adidas Rainy Day", painterResource(R.drawable.m5), "Men" , 8599, "Adidas","Men" ),
        product("Adidas Big BOss", painterResource(R.drawable.m6), "Men" ,2999 , "Nike", "Men" ),
        product("Adidas Big BOss",  painterResource(R.drawable.m7), "Men" ,2999 , "Converse", "Men" ),
        product("Adidas Big BOss",  painterResource(R.drawable.m8), "Men" ,2999 , "Converse","Men" )

    )


  //  val list1 = remember { mutableStateOf(menShoe) }
Column(modifier = Modifier.padding(top = 20.dp),
    verticalArrangement = Arrangement.Center) {
    Text("MEN'S SHOES" , fontSize = 20.sp)
    LazyVerticalGrid(GridCells.Fixed(2)){

        items(menShoe){item ->
            productCard(item , navController , viewModel)

        }
    }}}



@Composable
fun women(navController: NavController, viewModel: PageLink){



    var femaleShoe = listOf<product>(
        product("Jordan 1", painterResource(R.drawable.f1), "Female" , 10000, "Nike" , "Female") ,
        product("Lows  co 2", painterResource(R.drawable.f2), "Female" , 12999, "Converse", "Female") ,
        product("Flame co 4", painterResource(R.drawable.f3), "Female" , 9999, "Converse", "Female"),
        product("ASexy shoe", painterResource(R.drawable.f4), "Female" ,4999 , "Converse", "Female"),
        product("Blazers", painterResource(R.drawable.f5), "Female" , 8599, "Nike", "Female"),
        product("Nike Big BOss", painterResource(R.drawable.f6), "Female" ,2999 , "Nike", "Female"),
        product("Adidas Big BOss", painterResource(R.drawable.f7), "Female" ,12999 , "Adidas", "Female"),
        product("Nike Terminator", painterResource(R.drawable.f8), "Female" ,22999 , "Nike", "Female")

    )


    //  val list1 = remember { mutableStateOf(menShoe) }
    Column(
        modifier = Modifier.padding(top = 20.dp),
        verticalArrangement = Arrangement.Center)
    {

             Text("WOMEN'S SHOES" , fontSize = 20.sp)
             LazyVerticalGrid(GridCells.Fixed(2)){

                      items(femaleShoe){item ->
                       productCard(item , navController ,viewModel)

            }
        }}}
@Composable
fun child(navController: NavController , viewModel: PageLink){

    var kidShoe = listOf<product>(
        product("AirForce 1", painterResource(R.drawable.k1), "Kids" , 10000, "Nike" ,"Kids") ,
        product("Converse 1", painterResource(R.drawable.k2), "Kids" , 12999, "Converse","Kids") ,
        product("Con high end", painterResource(R.drawable.k3), "Kids" , 9999, "Converse","Kids"),
        product("Lows Co ", painterResource(R.drawable.k4), "Kids" ,4999 , "Converse","Kids"),
        product("Nike Jordan 4", painterResource(R.drawable.k5), "Kids" , 8599, "Nike","Kids"),
        product("NIke Blazers Kids", painterResource(R.drawable.k6), "Kids" ,2999 , "Nike","Kids"),
        product("Adidas Big BOss", painterResource(R.drawable.k7), "Kids" ,12999 , "Adidas","Kids")
    )


    //  val list1 = remember { mutableStateOf(menShoe) }
    Column(modifier = Modifier.padding(top = 20.dp),
        verticalArrangement = Arrangement.Center) {
        Text("KID'S SHOES" , fontSize = 20.sp)
        LazyVerticalGrid(GridCells.Fixed(2)){

            items(kidShoe){item ->
                productCard(item , navController, viewModel)

            }
        }}}




@Composable
fun productCard(list: product , navController: NavController , viewModel: PageLink ){
    Card(
        modifier = Modifier.padding(8.dp).clickable {
            viewModel.setProduct(list)
            navController.navigate("ShoePageNAV")


        },
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