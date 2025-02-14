package com.projectbytj.bewakoof

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

var Cart = mutableStateListOf<product>(
    product("Converse 1", R.drawable.k2, "Kids", 12999, "Converse", "Kids" , null),
    product("Con high end", R.drawable.k3, "Kids", 9999, "Converse", "Kids" , null),
    product("Lows Co", R.drawable.k4, "Kids", 4999, "Converse", "Kids" , null),

    )

                                                            //cart page
@Composable
fun cart(navController: NavController , viewModel : PageLink){


    Column(modifier = Modifier.padding(top = 20.dp).fillMaxHeight()) {

        heading("CART")

        var total = Cart.sumOf { it.Price }

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth().padding(bottom= 5.dp)
                ,
        ) {
            items(Cart) { item ->
                cartProduct(item, navController, viewModel)
            }

            item {
                OrderDetails(total)
                ReturnPolicy()
            }
        }

                                                        //total and checkout button
        PaymentCard(total)
    }


}

                                                            // cart product
@Composable
fun cartProduct(
    list: product,
    navController: NavController,
    viewModel: PageLink
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .height(120.dp) // Increased height for remove button
            .clickable {
                viewModel.setProduct(list)
                navController.navigate("ShoePageNAV")
            },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(12.dp) // Rounded corners for a sleek look
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Product Image
            Image(
                painter = painterResource(list.pic),
                contentDescription = list.name,
                modifier = Modifier
                    .size(80.dp) // Fixed size for consistency
                    .clip(RoundedCornerShape(8.dp)), // Rounded edges for a better look
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp)) // Space between image and text

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = list.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = list.Brand,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Text(
                    text = "Size: UK ${list.sizeSelected}", // Replace with actual size if available
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }

            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight()
            ) {
                // Price at the top right
                Text(
                    text = "₹${list.Price}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                // Remove Button
                OutlinedButton(
                    onClick = { Cart.remove(list) },
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xFFD32F2F)), // Softer Red
                    border = BorderStroke(1.dp, Color(0xFFB71C1C)), // Slightly darker border
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(28.dp) // Smaller height
                        .width(85.dp), // Smaller width
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text("Remove", color = Color.White, fontSize = 12.sp)
                }
            }
        }
    }
}


@Composable
fun OrderDetails(total: Int) {
    val deliveryFee = 100
    val platformFee = 19
    val payableAmount = total + deliveryFee + platformFee

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "ORDER DETAILS",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Start
            )
            Divider()

            OrderDetailRow("Bag Total", total)
            OrderDetailRow("Delivery Fee", deliveryFee)
            OrderDetailRow("Platform Fee", platformFee)

            Divider()

            OrderDetailRow("Amount Payable", payableAmount, isBold = true)
        }
    }
}

@Composable
fun OrderDetailRow(label: String, amount: Int, isBold: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp,
                fontWeight = if (isBold) FontWeight.Bold else FontWeight.Medium
            )
        )
        Text(
            text = "₹%.2f".format(amount.toDouble()), // Fixed currency formatting
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp,
                fontWeight = if (isBold) FontWeight.Bold else FontWeight.Medium
            )
        )
    }
}
                                                                        //Return and refund

@Composable
fun ReturnPolicy(){

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Return & Refund Policy",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Start
            )
            Text(
                text = "In case of any return , wen ensure quick refunds. Full amount will be reflected excluding Convenience Fee",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
            )



        }
    }
}
                                                                    // payment button

@Composable
fun PaymentCard(total: Int) {
    Card(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp , bottom = 6.dp )
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp), // Increased elevation for better effect
        colors = CardDefaults.cardColors(containerColor = Color.White), // Changed to white
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically, // Centers items vertically
            horizontalArrangement = Arrangement.SpaceBetween // Places items at left & right
        ) {
            // Total amount aligned to the left
            Text(
                text = "₹$total",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 18.sp, // Increased font size for better visibility
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(Modifier.width(10.dp))

            // Payment button aligned to the right
            Button(
                onClick = { /* Handle payment click */ },
                shape = RectangleShape, // Rectangle shape applied
                modifier = Modifier
                    .height(60.dp) // Ensures proper height
                    .clip(RoundedCornerShape(8.dp)), // Slightly rounded corners for better look
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 4.dp) // Subtle elevation
            ) {
                Text(
                    "Proceed to Payment >",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}
