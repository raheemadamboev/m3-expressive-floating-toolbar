package xyz.teamgravity.m3expressivefloatingtoolbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Redo
import androidx.compose.material.icons.automirrored.rounded.Undo
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingToolbarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.VerticalFloatingToolbar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.util.fastForEach
import xyz.teamgravity.m3expressivefloatingtoolbar.ui.theme.M3ExpressiveFloatingToolbarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M3ExpressiveFloatingToolbarTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { padding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        var expanded by remember { mutableStateOf(true) }

                        VerticalFloatingToolbar(
                            expanded = expanded,
                            colors = FloatingToolbarDefaults.standardFloatingToolbarColors(),
                            modifier = Modifier.align(Alignment.CenterEnd),
                            floatingActionButton = {
                                FloatingActionButton(
                                    onClick = {
                                        expanded = !expanded
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Save,
                                        contentDescription = null
                                    )
                                }
                            }
                        ) {
                            MENU.fastForEach { icon ->
                                IconButton(
                                    onClick = {
                                    }
                                ) {
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private val MENU: List<ImageVector> = listOf(
    Icons.AutoMirrored.Rounded.Undo,
    Icons.AutoMirrored.Rounded.Redo,
    Icons.Rounded.Share,
    Icons.Rounded.Delete
)