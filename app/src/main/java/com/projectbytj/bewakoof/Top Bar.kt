package com.projectbytj.bewakoof

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun topbar(navController: NavController, content: @Composable () -> Unit){

    var drawerState : DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    val bottomPadding = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
    val topPadding = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() // Get dynamic top padding



    Box {
        Image(painter = painterResource(R.drawable.s4) , "")

    ModalNavigationDrawer(
        drawerState = drawerState ,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.fillMaxWidth(0.65f)
                , drawerContainerColor = Color.White


            ) {

                drawerCard(navController)
            }
        }
    ){
        Scaffold(
            topBar = {
                TopAppBar(drawerState, scope , navController)
            }

        ){ padding -> padding
            Box(modifier = Modifier.fillMaxSize()
                .padding(top= 60.dp,
                        bottom = bottomPadding
                )
            ) {
            Image(painter = painterResource(R.drawable.background_blue_orange) , "splash",
                modifier = Modifier.fillMaxSize()
                , contentScale = ContentScale.Crop )

                content()


        }}
    }
}}

@Composable
fun TopAppBar(drawerState: DrawerState, scope: CoroutineScope , navController: NavController) {


    Row(
        modifier = Modifier.padding(top = 20.dp).fillMaxWidth().fillMaxHeight(0.1f),
        horizontalArrangement = Arrangement.Center ,

    ){

        IconButton(
            onClick ={ scope.launch{
                drawerState.open()
            }
            }
        ){
            Icon(painter =  painterResource(R.drawable.menu) , "menu" ,
                modifier = Modifier.fillMaxHeight(0.7f).weight(0.1f))
        }
        val interactionSource = remember { MutableInteractionSource() }
        Text(
            text = "ShoeBOX",
            modifier = Modifier.weight(0.7f).clickable(
                onClick = { navController.navigate("mainNAV") },
                indication = null,  // Disables ripple effect
                interactionSource = interactionSource // Prevents unwanted interactions
            )
            //{ navController.navigate("mainNAV") }
                .fillMaxHeight(0.8f)
                .padding(start = 45.dp , top = 10.dp)
                ,
            fontSize = 25.sp ,
            textAlign = TextAlign.Center
        )


        IconButton(
            onClick = {
                navController.navigate("likepageNAV")
            }
        ){
            Icon(painter = painterResource(R.drawable.heart) ,"heart" ,
                modifier = Modifier.fillMaxHeight(0.6f).weight(0.05f))
        }

        IconButton(
            onClick = {
                    navController.navigate("proflieNAV")
            }
        ){
            Icon(painter = painterResource(R.drawable.user) ,"user" ,
                modifier = Modifier.fillMaxHeight(0.6f).weight(0.05f))
        }
    }
}


