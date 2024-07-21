package com.example.aplikasisikepah.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.aplikasisikepah.R

data class Item(val id: Int, val imageRes: Int, val text: String, var quantity: Int = 0)

@Composable
fun PickUpScreen(navController: NavController) {
    val items = remember {
        mutableStateListOf(
            Item(1, R.drawable.gambar1, "Plastik"),
            Item(2, R.drawable.gambar2, "Kertas"),
            Item(3, R.drawable.gambar3, "Metal"),
            Item(4, R.drawable.gambar4, "Kaca"),
            Item(5, R.drawable.gambar5, "Elektronik")
        )
    }
    val selectedItems = remember { mutableStateListOf<Item>() }
    val totalQuantity = remember { mutableStateOf(0) }
    val namaValue = remember { mutableStateOf("") }
    val alamatValue = remember { mutableStateOf("") }
    val tanggalValue = remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Surface {
                BarAtasBaru(navController = navController)
            }

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Informasi Sampah",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items.forEach { item ->
                            ListSampah(item = item) { quantityChange ->
                                item.quantity += quantityChange
                                if (quantityChange > 0) {
                                    if (!selectedItems.contains(item)) {
                                        selectedItems.add(item)
                                    }
                                } else {
                                    selectedItems.remove(item)
                                }
                                totalQuantity.value += quantityChange
                            }
                            Divider(color = Color.Black, thickness = 1.dp)
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    HasilBerat(selectedItems = selectedItems, totalQuantity = totalQuantity.value)

                    Spacer(modifier = Modifier.height(16.dp))

                    Inputdata("Nama", onValueChanged = { namaValue.value = it })

                    Inputdata("Alamat", onValueChanged = { alamatValue.value = it })

                    Inputdata("Tanggal", onValueChanged = { tanggalValue.value = it })

                    Spacer(modifier = Modifier.height(16.dp))


                    Spacer(modifier = Modifier.height(100.dp))
                }
            }
        }

        BarBawahBaru(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}


@Composable
fun ListSampah(item: Item, onQuantityChange: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = item.text,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = item.text,
            modifier = Modifier.weight(1f),
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.width(50.dp))
        Tambahdankurang(iconSize = 24.dp, onQuantityChange = onQuantityChange)
    }
    Divider(color = Color.Black, thickness = 1.dp)
}

@Composable
fun Tambahdankurang(iconSize: Dp, onQuantityChange: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .height(24.dp)
            .width(110.dp)
    ) {
        val counter = remember { mutableStateOf(0) }

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.clickable {
                    if (counter.value > 0) {
                        counter.value -= 1
                        onQuantityChange(-1)
                    }
                },
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.remove),
                    contentDescription = null,
                    modifier = Modifier.size(iconSize)
                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Text(text = "${counter.value}")

            Spacer(modifier = Modifier.width(20.dp))
            Card(
                modifier = Modifier.clickable {
                    counter.value += 1
                    onQuantityChange(1)
                },
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = null,
                    modifier = Modifier.size(iconSize)
                )
            }
        }
    }
}

@Composable
fun HasilBerat(
    selectedItems: List<Item>,
    totalQuantity: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Informasi Penjemputan",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 2.dp)
        )

        selectedItems.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = item.text,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "${item.text}: ${item.quantity} KG",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Total:",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "$totalQuantity KG",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}

@Composable
fun Inputdata(label: String, onValueChanged: (String) -> Unit) {
    val inputValue = remember { mutableStateOf("") }

    OutlinedTextField(
        value = inputValue.value,
        onValueChange = {
            inputValue.value = it
            onValueChanged(it)
        },
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    )
}

@Composable
fun BarAtasBaru(navController: NavController) {
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
                text = "Pickup",
                color = Color.White,
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,
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
fun BarBawahBaru(navController: NavController, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(vertical = 16.dp, horizontal = 16.dp)
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

@Composable
@Preview
fun PickUpScreenPreview() {
    val navController = rememberNavController()
    PickUpScreen(navController = navController)
}
