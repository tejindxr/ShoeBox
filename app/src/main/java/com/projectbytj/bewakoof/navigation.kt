package com.projectbytj.bewakoof

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

data class  destination(
    val route : String ,
    val title : String
)


@Composable
fun Nav(viewModel: PageLink){


    val tj = rememberNavController()
    NavHost(navController = tj , startDestination = "mainNAV"){
        composable("mainNAV"){
            topbar(tj){
                homescreen(tj )
            }
        }
        composable("homeNAV"){
           homescreen(tj)
        }
        composable("womenNAV"){
            topbar(tj){
                women(tj, viewModel)
            }
        }
        composable("childNAV"){
            topbar(tj){
                child(tj,viewModel)
            }
        }
        composable("menNAV"){
           topbar(tj ){
               men(tj , viewModel)
           }
        }

        composable("likepageNAV"){
            topbar(tj){
                likepage(tj , viewModel)
            }
        }

        composable("ShoePageNAV"){
            topbar(tj){
                ShoePage(tj, viewModel)
            }
        }

        composable("cartNAV") {
            topbar(tj) {
                cart(tj, viewModel)
            }
        }

        composable("signinNAV") {
            topbar(tj) {
                signin(tj)
            }
        }

        composable("signupNAV") {
            topbar(tj) {
                signup(tj)
            }
        }
        composable("proflieNAV") {
            topbar(tj) {
                ProfileScreen(tj)
            }
        }


    }

    startup(navController = tj)



}