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
        composable("profileNAV"){
            topbar(tj){
                signup(tj)
            }
        }

        composable("ShoePageNAV"){
            topbar(tj){
                ShoePage(tj, viewModel)
            }
        }
    }

    startup(navController = tj)



}