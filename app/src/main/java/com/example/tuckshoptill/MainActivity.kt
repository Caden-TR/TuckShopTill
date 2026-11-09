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


// ---- Stage 5: takePayment --------------------------------------------
// Write fun takePayment(paidText: String, toPay: Int): String here.


// ---- Stage 6: mealDealDiscount ---------------------------------------
// Write fun mealDealDiscount(basket: List<String>): Int here.


// ---- The app ---------------------------------------------------------
// Stage 1: replace this whole function with the code on your task sheet.
// After that, each stage adds to it.
@Composable
fun TuckShopTillApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize().padding(24.dp)) {
        Text("Tuck Shop Till", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Your till goes here")
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
