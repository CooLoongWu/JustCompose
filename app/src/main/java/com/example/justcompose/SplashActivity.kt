package com.example.justcompose

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.justcompose.layout.BoxDemo
import com.example.justcompose.ui.netEasyColor

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SplashMainLayout()
        }

        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            },
            1000
        )
    }
}

@Composable
fun SplashMainLayout() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(netEasyColor)
            .padding(0.dp, 156.dp, 0.dp, 0.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            bitmap = imageResource(id = R.drawable.logo),
            modifier = Modifier.size(92.dp)
        )
    }
}
