package com.projectbytj.bewakoof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

          Nav()

        }
    }
}
@Composable
fun startup(navController: NavController){
    var effect by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = true){
        delay(1500)
        effect = false
    }
    if (effect){
        splash()
    }
    else{

        navController.navigate("ShoePageNAV") {
           // popUpTo("mainNAV") { inclusive = true }





        }



    }

}

@Composable
fun splash(){
    Card (
       modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.s2) , "splash",
                modifier = Modifier.fillMaxSize()
              , contentScale = ContentScale.Crop )

              Text("Welcome to the \n     ShoeBOX"  , fontWeight = FontWeight.Bold,
              color = Color.White ,
               fontSize = 30.sp ,
              modifier = Modifier.padding(bottom = 50.dp)
        )
    }}
}


