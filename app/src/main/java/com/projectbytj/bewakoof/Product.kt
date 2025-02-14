package com.projectbytj.bewakoof

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


public final data class product(
    val name: String,
    val pic: Int,
    val category: String,
    val Price: Int,
    val Brand: String,
    val sunCategory: String,
    var sizeSelected: Int?
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

    val menShoe = listOf(
        product("Adidas comfi co 1", R.drawable.m1, "Men", 10000, "Adidas", "Men" , null),
        product("Adidas comfi co 2", R.drawable.m2, "Men", 12999, "Adidas", "Men", null),
        product("Adidas samba", R.drawable.m3, "Men", 9999, "Adidas", "Men", null),
        product("Adidas air float", R.drawable.m4, "Men", 4999, "Adidas", "Men", null),
        product("Adidas Rainy Day", R.drawable.m5, "Men", 8599, "Adidas", "Men", null),
        product("Adidas Big Boss", R.drawable.m6, "Men", 2999, "Nike", "Men", null),
        product("Adidas Big Boss", R.drawable.m7, "Men", 2999, "Converse", "Men", null),
        product("Adidas Big Boss", R.drawable.m8, "Men", 2999, "Converse", "Men", null)
    )



    Column(
        modifier = Modifier.padding(top = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        heading("Men's Shoes")


        LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp)) {
            items(menShoe) { item ->


                productCard(item, navController, viewModel)
            }
        }
    }


}



@Composable
fun women(navController: NavController, viewModel: PageLink){



    var femaleShoe = listOf(
        product("Jordan 1", R.drawable.f1, "Female", 10000, "Nike", "Female", null),
        product("Lows co 2", R.drawable.f2, "Female", 12999, "Converse", "Female", null),
        product("Flame co 4", R.drawable.f3, "Female", 9999, "Converse", "Female", null),
        product("ASexy shoe", R.drawable.f4, "Female", 4999, "Converse", "Female", null),
        product("Blazers", R.drawable.f5, "Female", 8599, "Nike", "Female", null),
        product("Nike Big BOss", R.drawable.f6, "Female", 2999, "Nike", "Female", null),
        product("Adidas Big BOss", R.drawable.f7, "Female", 12999, "Adidas", "Female", null),
        product("Nike Terminator", R.drawable.f8, "Female", 22999, "Nike", "Female", null)
    )



    Column(
        modifier = Modifier.padding(top = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        heading("Women's Shoes")

        LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp)) {
            items(femaleShoe) { item ->


                productCard(item, navController, viewModel)
            }
        }
    }

}



@Composable
fun child(navController: NavController , viewModel: PageLink){

    var kidShoe = listOf(
        product("AirForce 1", R.drawable.k1, "Kids", 10000, "Nike", "Kids", null),
        product("Converse 1", R.drawable.k2, "Kids", 12999, "Converse", "Kids", null),
        product("Con high end", R.drawable.k3, "Kids", 9999, "Converse", "Kids", null),
        product("Lows Co", R.drawable.k4, "Kids", 4999, "Converse", "Kids", null),
        product("Nike Jordan 4", R.drawable.k5, "Kids", 8599, "Nike", "Kids", null),
        product("NIke Blazers Kids", R.drawable.k6, "Kids", 2999, "Nike", "Kids", null),
        product("Adidas Big BOss", R.drawable.k7, "Kids", 12999, "Adidas", "Kids", null)
    )


    Column(
        modifier = Modifier.padding(top = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        heading("Kid's Shoes")


        LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp)) {
            items(kidShoe) { item ->


                productCard(item, navController, viewModel)
            }
        }
    }

}



/*
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
                painter = painterResource(list.pic),
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

 */
@Composable
fun productCard(product: product, navController: NavController, viewModel: PageLink) {
    Card(
        modifier = Modifier
            .padding(8.dp) // Reduced padding for better grid spacing
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .shadow(6.dp, shape = RoundedCornerShape(12.dp))
            .clickable {
                viewModel.setProduct(product)
                navController.navigate("ShoePageNAV")
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp) // Tighter spacing for grid
        ) {
            Image(
                painter = painterResource(product.pic),
                contentDescription = product.name,
                modifier = Modifier
                    .height(100.dp) // Adjusted size for grid
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = product.Brand,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 4.dp)
            )

            Text(
                text = "₹${product.Price}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun heading(name : String){


    Text(name, fontSize = 20.sp, fontWeight = FontWeight.Bold ,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth() ,
        color = Color.White)


}

