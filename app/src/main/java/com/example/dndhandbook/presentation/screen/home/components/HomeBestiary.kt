package com.example.dndhandbook.presentation.screen.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.baseComponents.gif.BaseLottieGif
import com.example.dndhandbook.presentation.ui.theme.Black700

@Composable
fun HomeBestiary(onBestiaryClicked: (() -> Unit)? = null) {

    Surface(
        shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp),
        color = Black700,
        modifier = Modifier.fillMaxWidth().offset(x = 0.dp, y = 10.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp).fillMaxWidth()) {
            BaseText(
                text = stringResource(R.string.bestiary),
                fontSize = 20.sp,
                fontWeight = FontWeight.W700,
            )
            Spacer(Modifier.height(50.dp))
            BaseLottieGif(
                rawRes = R.raw.monster_eye_anim,
                iterations = 1,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(180.dp)
                    .clickable { onBestiaryClicked?.invoke() },
            )
            Spacer(Modifier.height(30.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeBestiaryPreview() {
    HomeBestiary()
}