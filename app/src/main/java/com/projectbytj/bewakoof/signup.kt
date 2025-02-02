package com.projectbytj.bewakoof

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import java.util.jar.Attributes.Name
import kotlin.math.log

@Composable
fun signup(navController: NavController){
    Column (
        modifier = androidx.compose.ui.Modifier.fillMaxWidth().fillMaxHeight(0.9f).padding(20.dp)
        , horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center
    ){
        logInfo("Name" , "" , "xyz")

        logInfo("Email" , "", "xyz@gmail.com")

        logInfo("Password" , "", "password")

        Button(
            onClick = {} , modifier = Modifier.padding(top = 20.dp)
        ){
            Text("Sign Up")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun logInfo(heading: String , input: String , hints : String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var input by remember { mutableStateOf("")  }
        Text(heading , textAlign = TextAlign.Start , fontSize = 20.sp ,color = Color.White )

        TextField(value = input ,
            { newhint ->  input = newhint }  ,
            label = ({ Text(hints , color = Color.White)}),
           colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent,)

        )



    }
}