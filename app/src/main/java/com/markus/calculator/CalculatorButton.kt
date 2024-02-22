package com.markus.calculator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.markus.calculator.FontFamily

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit,
    color: Color,
    colors: CardColors = CardDefaults.cardColors(containerColor = color),
) {
    val fontFamily = FontFamily()
    Card(
        modifier = Modifier
            .clip(CircleShape)
            .clickable {
                onClick()
            }
            .then(modifier),
        colors = colors,
        //shape = CircleShape *causes inconsistency in the clickable area(clickable area does not take shape into account)
        // hence we have to modify shape, using clip modifier, before making it clickable.
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = symbol,
                textAlign = TextAlign.Center,
                fontSize = 36.sp,
                color = MaterialTheme.colorScheme.onSurface,
                fontFamily = fontFamily.fontFamily
            )
        }
    }
}
