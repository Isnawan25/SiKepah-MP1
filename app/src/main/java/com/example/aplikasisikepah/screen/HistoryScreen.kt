package com.example.aplikasisikepah.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.aplikasisikepah.R

@Composable
fun HistoryScreen(navController: NavController) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BarAtas(navController = navController)

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.work_in_progress),
                        contentDescription = "Your Image",
                        modifier = Modifier.size(180.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "MASIH DALAM PERBAIKAN ! ! !",
                        color = Color.Red,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            BarBawahHistory(navController = navController)
        }
    }
}

@Composable
fun BarAtas(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Back Button",
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        navController.navigateUp()
                    }
            )
            Spacer(modifier = Modifier.width(14.dp))
            Text(
                text = "Riwayat Transaksi",
                color = Color.White,
                fontSize = 24.sp,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun BarBawahHistory(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(2.dp))
            .padding(vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        navController.navigate(Routes.HISTORY_SCREEN)
                    },
                painter = painterResource(id = R.drawable.history_icon),
                contentDescription = "Button 1"
            )
            Spacer(modifier = Modifier.width(70.dp))
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        navController.navigate(Routes.HOME_SCREEN)
                    },
                painter = painterResource(id = R.drawable.icon_home),
                contentDescription = "Button 2"
            )
            Spacer(modifier = Modifier.width(70.dp))
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        navController.navigate(Routes.PICKUP_SCREEN)
                    },
                painter = painterResource(id = R.drawable.ic_truk),
                contentDescription = "Button 3"
            )
        }
    }
}




@Composable
@Preview
fun HistoryScreenPreview() {
    val navController = rememberNavController()
    HistoryScreen(navController = navController)
}
