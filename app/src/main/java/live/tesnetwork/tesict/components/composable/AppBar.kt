@file:OptIn(ExperimentalMaterial3Api::class)

package live.tesnetwork.tesict.components.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import live.tesnetwork.tesict.components.data.ExampleData
import live.tesnetwork.tesict.components.data.user.User
import live.tesnetwork.tesict.ui.theme.TesICTTheme

@Composable
fun AppBar(
    user: User,
    onNavigationIconClick: () -> Unit = {}
) {
    val topBarColors = TopAppBarDefaults.smallTopAppBarColors(
        MaterialTheme.colorScheme.surface,
        Color.Yellow,
        MaterialTheme.colorScheme.onSurface,
        MaterialTheme.colorScheme.onSurface,
        MaterialTheme.colorScheme.onSurface
    )
    TopAppBar(
        title = {},
        colors = topBarColors,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Toggle drawer"
                )
            }

        },
        actions = {
            Box(modifier = Modifier.padding(16.dp)) {
                profile(user)
            }
        }
    )
    Divider(color = MaterialTheme.colorScheme.background, thickness = 1.dp)
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun profile(user : User, modifier: Modifier = Modifier) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = user.name,
            textAlign = TextAlign.Center,
            modifier=modifier.padding(end = 10.dp)
        )
        Image(
            painter = rememberImagePainter(
                data = user.profileImageUrl,
                builder = {
                    transformations(CircleCropTransformation())
                }
            ),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun appBarPreview() {
    TesICTTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { AppBar(ExampleData.getClient(0).getAsUser(), onNavigationIconClick = { }) }
        ) { paddingValues ->
            Surface(
                color = MaterialTheme.colorScheme.background, modifier = Modifier
                    .padding(top = paddingValues.calculateTopPadding())
                    .fillMaxSize()
            ) {
                Text(
                    text = "nothing here",
                    modifier = Modifier.padding(top = paddingValues.calculateTopPadding())
                )
            }
        }
    }
}