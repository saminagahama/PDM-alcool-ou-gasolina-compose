package com.example.alcoolougasolina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                FuelCalculatorScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FuelCalculatorScreen() {
    var alcoholPrice by remember { mutableStateOf("") }
    var gasolinePrice by remember { mutableStateOf("") }
    var percentual by remember { mutableStateOf(0.7) }
    var result by remember { mutableStateOf("") }

    MaterialTheme {
        val colors = MaterialTheme.colorScheme

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "Bomba de gasolina",
                modifier = Modifier
                    .padding(top = 50.dp, bottom = 30.dp)
                    .size(width = 150.dp, height = 150.dp)
            )

            TextField(
                value = alcoholPrice,
                onValueChange = { alcoholPrice = it },
                label = { Text("Preço do Álcool") },
                colors = TextFieldDefaults.textFieldColors(containerColor = colors.surfaceVariant),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            TextField(
                value = gasolinePrice,
                onValueChange = { gasolinePrice = it },
                placeholder = { Text("Preço da Gasolina") },
                colors = TextFieldDefaults.textFieldColors(containerColor = colors.surfaceVariant),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Usar percentual 0.75: ",
                    color = colors.onBackground
                )
                Switch(
                    checked = percentual == 0.75,
                    onCheckedChange = { percentual = if (it) 0.75 else 0.7 },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = colors.primary,
                        uncheckedThumbColor = colors.onSurface,
                        checkedTrackColor = colors.primaryContainer,
                        uncheckedTrackColor = colors.onSurfaceVariant
                    )
                )
            }

            Button(
                onClick = {
                    val alcoholPriceValue = alcoholPrice.toDoubleOrNull()
                    val gasolinePriceValue = gasolinePrice.toDoubleOrNull()

                    if (alcoholPriceValue != null && gasolinePriceValue != null)
                        result = calculateFuel(alcoholPriceValue, gasolinePriceValue, percentual) else {
                        result = "Preencha os valores de álcool e gasolina."
                    }
                },
                modifier = Modifier
                    .width(120.dp)
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = colors.primary)
            ) {
                Text(text = "Calcular", color = colors.onPrimary)
            }

            Text(
                text = result,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = colors.onBackground
            )
        }
    }
}

private fun calculateFuel(alcoholPrice: Double, gasolinePrice: Double, percentual: Double): String {
    val ratio = alcoholPrice / gasolinePrice

    return if (ratio <= percentual) {
        "Álcool é mais vantajoso."
    } else {
        "Gasolina é mais vantajosa."
    }
}


@Preview
@Composable
fun FuelCalculatorScreenPreview() {
    FuelCalculatorScreen()
}
