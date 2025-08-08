package com.example.dndhandbook.presentation.screen.home.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.ui.theme.Black700
import com.example.dndhandbook.presentation.ui.theme.Gold700
import com.example.dndhandbook.presentation.ui.theme.Gray300
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeBestiary(onBestiaryClicked: (() -> Unit)? = null) {

    val scope = rememberCoroutineScope()
    val scaleAnim = remember { Animatable(1f) }

    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Black700,
        modifier = Modifier
            .graphicsLayer {
                scaleX = scaleAnim.value
                scaleY = scaleAnim.value
            }
            .fillMaxWidth()
            .padding(bottom = 20.dp, start = 20.dp, end = 20.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    scope.launch {
                        scaleAnim.animateTo(
                            targetValue = 1.03f,
                            animationSpec = tween(durationMillis = 100)
                        )
                        scaleAnim.animateTo(
                            targetValue = 1f,
                            animationSpec = tween(durationMillis = 100)
                        )
                        onBestiaryClicked?.invoke()
                    }
                },
            ),
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            BaseText(
                text = stringResource(R.string.bestiary),
                fontSize = 24.sp,
                fontWeight = FontWeight.W700,
                color = Gold700,
            )
            Spacer(Modifier.height(12.dp))
            BaseText(
                text = stringResource(R.string.bestiary_detail),
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                color = Gray300,
            )
            Spacer(Modifier.height(20.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeBestiaryPreview() {
    HomeBestiary()
}