package com.aya.bavel.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BavelAppNav() {
    // Status untuk menentukan halaman apa yang sedang dibuka (0: Library, 1: Reader)
    var currentScreen by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Text("📚") },
                    label = { Text("Perpustakaan") },
                    selected = currentScreen == 0,
                    onClick = { currentScreen = 0 }
                )
                NavigationBarItem(
                    icon = { Text("📖") },
                    label = { Text("Baca Novel") },
                    selected = currentScreen == 1,
                    onClick = { currentScreen = 1 }
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (currentScreen) {
                0 -> LibraryScreen()
                1 -> NovelReaderScreen()
            }
        }
    }
}
