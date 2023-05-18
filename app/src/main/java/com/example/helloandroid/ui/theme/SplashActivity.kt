package com.example.helloandroid.ui.theme

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.helloandroid.MainActivity
import com.example.helloandroid.ui.theme.presentation.SplashScreen
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloAndroidTheme {
                var changeScreen by remember {
                    mutableStateOf(false)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = GoldF6C700
                ) {
                    SplashScreen()
                    LaunchedEffect(key1 = Unit) {
                        delay(3.seconds)
                        changeScreen = true
                    }
                    if (changeScreen) {
                        val intent = Intent(this, MainActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        }
                        startActivity(intent)
                    }
                }
            }
        }
    }
}