package com.example.quadrantcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrantcompose.ui.theme.QuadrantComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrantApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxSize()) {
        // Première ligne (Haut)
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(R.string.text_title),
                description = stringResource(R.string.text_desc),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = stringResource(R.string.image_title),
                description = stringResource(R.string.image_desc),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        // Deuxième ligne (Bas)
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(R.string.row_title),
                description = stringResource(R.string.row_desc),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = stringResource(R.string.column_title),
                description = stringResource(R.string.column_desc),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// Composable réutilisable pour chaque vignette / quadrant
@Composable
fun QuadrantCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        // 1. Définition de la couleur de fond et de la marge intérieure de 16dp demandée
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        // 2. Centre tout le contenu verticalement et horizontalement
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 3. Premier Text en gras avec une marge intérieure inférieure à 16dp
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // 4. Deuxième Text avec une taille par défaut et alignement Justify
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantPreview() {
    QuadrantComposeTheme {
        ComposeQuadrantApp()
    }
}