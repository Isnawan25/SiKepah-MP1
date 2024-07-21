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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.aplikasisikepah.R

@Composable
fun HomeScreen(navController: NavController) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BarAtas()

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = stringResource(id = R.string.kategori_sampah),
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))

                Divider(
                    color = Color.Black,
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                BarTengah(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    items = listOf(
                        KategoriSampah(R.string.KategoriSampah1, R.drawable.gambar1),
                        KategoriSampah(R.string.KategoriSampah2, R.drawable.gambar2),
                        KategoriSampah(R.string.KategoriSampah3, R.drawable.gambar3),
                        KategoriSampah(R.string.KategoriSampah4, R.drawable.gambar4),
                        KategoriSampah(R.string.KategoriSampah5, R.drawable.gambar5)
                    )
                )

                Spacer(modifier = Modifier.height(30.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    item {
                        ExpandableSection(
                            title = stringResource(id = R.string.organik),
                            description = stringResource(id = R.string.organik_description),
                            color = Color.Green
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        ExpandableSection(
                            title = stringResource(id = R.string.anorganik),
                            description = stringResource(id = R.string.anorganik_description),
                            color = Color.Yellow
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        ExpandableSection(
                            title = stringResource(id = R.string.sampah_b3),
                            description = stringResource(id = R.string.sampah_b3_description),
                            color = Color.Red
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        ExpandableSection(
                            title = stringResource(id = R.string.sampah_kertas),
                            description = stringResource(id = R.string.sampah_kertas_description),
                            color = Color.Blue
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        ExpandableSection(
                            title = stringResource(id = R.string.sampah_residu),
                            description = stringResource(id = R.string.sampah_residu_description),
                            color = Color.DarkGray
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                    }
                }
            }

            BarBawah(navController = navController)
        }
    }
}

@Composable
fun BarAtas() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Selamat Datang\nDi SiKepah",
                color = Color.Black,
                fontSize = 30.sp,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Left
            )
            Image(
                modifier = Modifier.size(65.dp),
                painter = painterResource(id = R.drawable.logo_app),
                contentDescription = null
            )
        }
    }
}



@Composable
fun BarTengah(modifier: Modifier = Modifier, items: List<KategoriSampah>) {
    LazyRow(modifier = modifier) {
        items(items) { item ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 2.dp)
                    .background(Color.White)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = item.imageResId),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = stringResource(id = item.nameResId))
            }
        }
    }
}



@Composable
fun ExpandableSection(title: String, description: String, color: Color) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = color.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(10.dp)
                )
                .clickable { expanded = !expanded }
                .padding(vertical = 20.dp, horizontal = 16.dp)
        ) {
            Text(
                text = title,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Box(
                modifier = Modifier
                    .background(Color.Black, shape = RoundedCornerShape(50))
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand/Collapse",
                    tint = Color.White
                )
            }
        }
        if (expanded) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = description,
                color = Color.Black,
                textAlign = TextAlign.Justify,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}



@Composable
fun BarBawah(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
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



data class KategoriSampah(val nameResId: Int, val imageResId: Int)

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
