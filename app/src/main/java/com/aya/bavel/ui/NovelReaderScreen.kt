package com.aya.bavel.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NovelReaderScreen() {
    // Pengaturan sederhana untuk pembaca novel
    var textSize by remember { mutableStateOf(16.sp) }
    var isDarkMode by remember { mutableStateOf(true) }

    // Warna latar belakang dan teks berdasarkan mode gelap/terang
    val backgroundColor = if (isDarkMode) Color(0xFF121212) else Color(0xFFF5F5F5)
    val textColor = if (isDarkMode) Color(0xFFE0E0E0) else Color(0xFF212121)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bab 1: Awal Perjalanan") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (isDarkMode) Color(0xFF1F1F1F) else Color.White,
                    titleContentColor = textColor
                ),
                actions = {
                    // Tombol pengubah ukuran teks
                    TextButton(onClick = { textSize = if (textSize == 16.sp) 20.sp else 16.sp }) {
                        Text("A+", color = textColor)
                    }
                    // Tombol pengubah tema gelap/terang
                    TextButton(onClick = { isDarkMode = !isDarkMode }) {
                        Text(if (isDarkMode) "☀️" else "🌙")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(paddingValues)
        ) {
            // Konten teks novel dengan fitur scroll vertikal
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Bab 1: Awal Perjalanan\n\n" +
                            "Angin malam berhembus lembut melewati jendela kamar tua itu. Di atas meja kayu, sebuah buku catatan tua terbuka dengan halaman-halaman yang mulai menguning.\n\n" +
                            "Bavel, sebuah nama yang telah lama terlupakan dalam sejarah dunia persilatan dan literatur kuno, kini bangkit kembali melalui tekad seorang pembaca setia.\n\n" +
                            "\"Apakah takdirku benar-benar hanya sampai di sini?\" gumam sang tokoh utama sambil menatap langit malam yang dipenuhi bintang tanpa suara.\n\n" +
                            "Tiba-tiba, sebuah cahaya misterius terpancar dari balik buku tersebut, membawa petualangan baru yang tidak pernah ia bayangkan sebelumnya...",
                    fontSize = textSize,
                    color = textColor,
                    lineHeight = (textSize.value * 1.5).sp,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }
}
