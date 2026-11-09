package com.example.tuckshoptill

// All the imports you need for every stage are already here.
// Grey ones are not used yet. That is fine.
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tuckshoptill.ui.theme.TuckShopTillTheme

// You do not need to change MainActivity. It starts the app and shows TuckShopTillApp().
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TuckShopTillTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TuckShopTillApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// =====================================================================
// YOUR CODE STARTS HERE
// Commit and push to GitHub at the end of every stage.
// =====================================================================

// ---- Stage 3: formatPounds -------------------------------------------
// Write fun formatPounds(pence: Int): String here.

fun formatPounds(pence: Int): String {
    val pounds = pence / 100
    val pennies = pence % 100
    return "£" + pounds + "." + pennies.toString().padStart(2, '0')
}


// ---- Stage 5: takePayment --------------------------------------------
// Write fun takePayment(paidText: String, toPay: Int): String here.

fun takePayment(paidText: String, toPay: Int): String {
    val paid = paidText.toIntOrNull()
    if (paid == null) {
        return "Please type a whole number of pence, like 200"
    } else if (paid < toPay) {
        return "Not enough. You need ${formatPounds(toPay - paid)} more"
    } else {
        return "Thank you! Change: ${formatPounds(paid - toPay)}"
    }
}



// ---- Stage 6: mealDealDiscount ---------------------------------------
// Write fun mealDealDiscount(basket: List<String>): Int here.


// ---- The app ---------------------------------------------------------
// Stage 1: replace this whole function with the code on your task sheet.
// After that, each stage adds to it.
@Composable
fun TuckShopTillApp(modifier: Modifier = Modifier) {
    var totalPence by remember { mutableStateOf(0) }
    var message by remember { mutableStateOf("") }
    val basket = remember { mutableStateListOf<String>() }
    var paidText by remember { mutableStateOf("") }
    fun addItem(name: String, price: Int) {
        basket.add(name)
        totalPence = totalPence + price
        message = "Added $name"

    }
    fun clearAll() {
        basket.clear()
        totalPence = 0
        message = ""
        paidText = ""
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        Text("Tuck Shop Till", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Total: ${formatPounds(totalPence)}", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { addItem("Crisps", 80) }) {
                Text("Crisps ${formatPounds(80)}")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { addItem("Chocolate", 95) }) {
                Text("Chocolate ${formatPounds(95)}")
            }
        }
        Row {
            Button(onClick = { addItem("Water", 70) }) {
                Text("Water ${formatPounds(70)}")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { addItem("Juice", 110) }) {
                Text("Juice ${formatPounds(110)}")
            }
        }
        OutlinedButton(onClick = { clearAll() }) {
            Text("Clear")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Basket: ${basket.size} items", fontSize = 20.sp)
        for (item in basket) {
            Text("- $item")
        }

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = paidText,
            onValueChange = { paidText = it },
            label = { Text("Money given, in pence") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = { message = takePayment(paidText, totalPence) }) {
            Text("Pay")
        }


        Spacer(modifier = Modifier.height(16.dp))
        Text(message, fontSize = 20.sp)
    }
}

// ---- Preview ---------------------------------------------------------
@Preview(showBackground = true)
@Composable
fun TuckShopTillAppPreview() {
    TuckShopTillTheme {
        TuckShopTillApp()
    }
}
