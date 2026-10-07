package br.com.denisecastro.androidrunner.game.components.collectibles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.R
import br.com.denisecastro.androidrunner.game.model.CollectibleType
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme

@Composable
fun GameCollectible(
    type: CollectibleType,
    modifier: Modifier = Modifier
) {

    val drawableRes = when (type) {
        CollectibleType.ANDROID_COIN ->
            R.drawable.collectible_android_coin

        CollectibleType.CODE_TOKEN ->
            R.drawable.collectible_code_token

        CollectibleType.DATA_CHIP ->
            R.drawable.collectible_data_chip

        CollectibleType.KOTLIN_GEM ->
            R.drawable.collectible_kotlin_gem

        CollectibleType.ENERGY_BOLT ->
            R.drawable.collectible_energy_bolt

        CollectibleType.BUG_FIX ->
            R.drawable.collectible_bug_fix

        CollectibleType.BATTERY ->
            R.drawable.collectible_battery

        CollectibleType.STAR_XP ->
            R.drawable.collectible_star_xp
    }

    val imageScale = when (type) {
        CollectibleType.KOTLIN_GEM -> 1.8f
        CollectibleType.STAR_XP -> 2.0f
        else -> 1f
    }

    Image(
        painter = painterResource(
            id = drawableRes
        ),
        contentDescription = "Collectible",
        modifier = modifier.scale(imageScale),
        contentScale = ContentScale.Fit
    )
}

@Preview(
    name = "All Collectibles",
    showBackground = true,
    widthDp = 360,
    heightDp = 240
)
@Composable
private fun GameCollectiblePreview() {
    AndroidRunnerTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                GameCollectible(
                    type = CollectibleType.ANDROID_COIN,
                    modifier = Modifier.size(64.dp)
                )

                GameCollectible(
                    type = CollectibleType.CODE_TOKEN,
                    modifier = Modifier.size(64.dp)
                )

                GameCollectible(
                    type = CollectibleType.DATA_CHIP,
                    modifier = Modifier.size(64.dp)
                )

                GameCollectible(
                    type = CollectibleType.KOTLIN_GEM,
                    modifier = Modifier.size(64.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                GameCollectible(
                    type = CollectibleType.ENERGY_BOLT,
                    modifier = Modifier.size(64.dp)
                )

                GameCollectible(
                    type = CollectibleType.BUG_FIX,
                    modifier = Modifier.size(64.dp)
                )

                GameCollectible(
                    type = CollectibleType.BATTERY,
                    modifier = Modifier.size(64.dp)
                )

                GameCollectible(
                    type = CollectibleType.STAR_XP,
                    modifier = Modifier.size(64.dp)
                )
            }
        }
    }
}