package com.example.composebusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebusinesscard.ui.theme.ComposeBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.Center)
                .fillMaxWidth(0.8F)
        ) {
            Header()
        }
    }
}

@Composable
fun Header() {
    Row(modifier = Modifier
        .padding(top = 40.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_person),
            null,
            Modifier.size(100.dp)
        )
    }
    Row(modifier = Modifier
    ) {
        CardContent(name = "Daffa", title = "CEO")
    }
}

@Composable
fun CardContent(name: String, title: String) {
    Column(modifier = Modifier
        .fillMaxWidth(0.8f)
        .padding(10.dp)
    ) {
        Text(text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(text = title,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Socials(phone = "+6281271233898", email = "daffa@randika.com", twitter = "daffa.randika")
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}

@Composable
fun Socials(phone: String, email: String, twitter: String) {
    Column(modifier = Modifier) {
        Row {
            Social(image = painterResource(id = R.drawable.ic_email), value = email)
        }
        Row {
            Social(image = painterResource(id = R.drawable.ic_phone), value = phone)
        }
        Row {
            Social(image = painterResource(id = R.drawable.ic_twitter), value = twitter)
        }
    }
}

@Composable
fun Social(image: Painter, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column {
            Image(painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(10.dp)
            )
        }
        Column {
            Text(text = value,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBusinessCardTheme {
        BusinessCard()
    }
}