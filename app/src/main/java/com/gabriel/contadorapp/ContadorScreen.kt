package com.gabriel.contadorapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContadorScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contador") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
    var contador by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Valor atual",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        val corDoNumero = if (contador == 0) {
            MaterialTheme.colorScheme.onSurface
        } else {
            MaterialTheme.colorScheme.primary
        }

        Text(
            text = "$contador",
            style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Bold),
            color = corDoNumero,
            modifier = Modifier.padding(vertical = 32.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { contador++ }) {
                Text("+ Somar")
            }

            OutlinedButton(
                onClick = { contador-- },
                enabled = contador > 0
            ) {
                Text("— Subtrair")
            }
        }
        TextButton(
            onClick = { contador = 0 },
            modifier = Modifier.padding(top = 16.dp),
            enabled = contador != 0
        ) {
            Text("Zerar")
        }
    }
}
}

@Preview(showBackground = true)
@Composable
fun ContadorScreenPreview() {
    MaterialTheme {
        ContadorScreen()
    }
}