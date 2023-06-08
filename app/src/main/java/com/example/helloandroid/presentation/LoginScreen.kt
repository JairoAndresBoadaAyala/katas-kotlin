@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.helloandroid.presentation

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloandroid.R
import com.example.helloandroid.presentation.activities.SearchActivity
import com.example.helloandroid.presentation.theme.GoldF6C700
import com.example.helloandroid.presentation.theme.Gray707070
import com.example.helloandroid.presentation.theme.HelloAndroidTheme
import com.example.helloandroid.presentation.theme.Shapes

@Composable
fun LoginScreen(onRegisterClick: () -> Unit) {
    val currentTextState = remember {
        mutableStateOf("")
    }
    val currentPasswordState = remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    val validateFields =
        currentTextState.value.isNotEmpty() && currentPasswordState.value.isNotEmpty()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = GoldF6C700)
            .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Header()
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text(text = stringResource(id = R.string.label_user_name), fontSize = 16.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = currentTextState.value,
                onValueChange = { value ->
                    currentTextState.value = value
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                maxLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Gray707070,
                    unfocusedTextColor = Gray707070,
                    disabledTextColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = Shapes.medium,
                textStyle = TextStyle(fontSize = 14.sp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text(text = stringResource(id = R.string.label_password), fontSize = 16.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = currentPasswordState.value,
                onValueChange = { value ->
                    currentPasswordState.value = value
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                maxLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Gray707070,
                    unfocusedTextColor = Gray707070,
                    disabledTextColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                visualTransformation = PasswordVisualTransformation(),
                shape = Shapes.medium,
                textStyle = TextStyle(fontSize = 14.sp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(id = R.string.label_forgot_password),
                modifier = Modifier.clickable {
                    println("jairo---- click")
                }, fontSize = 12.sp,
                fontStyle = FontStyle(FontStyle.Italic.value)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Button(
                onClick = {
                    // TODO: con esto se lanza la nueva actividad
                    context.startActivity(Intent(context, SearchActivity::class.java))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = Shapes.medium,
                colors = ButtonDefaults.buttonColors(containerColor = Gray707070),
                enabled = validateFields
            ) {
                Text(
                    text = stringResource(id = R.string.label_login),
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = stringResource(id = R.string.label_other_options))
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(58.dp)
                    .background(color = Color.White, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_apple),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))

            Box(
                modifier = Modifier
                    .size(58.dp)
                    .background(color = Color.White, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))

            Box(
                modifier = Modifier
                    .size(58.dp)
                    .background(color = Color.White, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row() {
            Text(text = stringResource(id = R.string.label_not_account))
            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = stringResource(id = R.string.label_registry),
                modifier = Modifier.clickable {
                    onRegisterClick.invoke()
                }, fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.label_continue_as_invite),
            modifier = Modifier.clickable {
                println("jairo---- click")
            },
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    HelloAndroidTheme {
        LoginScreen {

        }
    }
}