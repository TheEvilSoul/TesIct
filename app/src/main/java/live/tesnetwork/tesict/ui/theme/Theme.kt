package live.tesnetwork.tesict.ui.theme

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF303F9F),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFF303F9F),
    onPrimaryContainer = Color(0xFFFFFFFF),
    inversePrimary = Color(0xFF303F9F),
    secondary = Color(0xFF512DA8),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFF512DA8),
    onSecondaryContainer = Color(0xFFFFFFFF),
    tertiary = Color(0xFF1976D2),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFF1976D2),
    onTertiaryContainer = Color(0xFFFFFFFF),
    background = Color.Black,
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF191C24),
    onSurface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFF272A32),
    onSurfaceVariant = Color(0xFFFFFFFF),
    surfaceTint = Color(0xFFFFFFFF),
    inverseSurface = Color(0xFFFFFFFF),
    inverseOnSurface = Color(0xFFFFFFFF),
    error = Color(0xFFFFFFFF),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFFFFF),
    outline = Color(0xFFFFFFFF),
    outlineVariant = Color(0xFFFFFFFF),
    scrim = Color(0xFFFFFFFF)
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun TesICTTheme(
    darkTheme: Boolean = true,//isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.surface.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}