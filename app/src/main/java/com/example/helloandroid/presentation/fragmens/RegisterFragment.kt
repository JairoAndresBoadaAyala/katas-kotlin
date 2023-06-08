package com.example.helloandroid.presentation.fragmens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.helloandroid.R
import com.example.helloandroid.presentation.theme.Gray4B4747
import com.example.helloandroid.presentation.theme.Gray707070
import com.example.helloandroid.presentation.theme.HelloAndroidTheme
import com.example.helloandroid.presentation.theme.Shapes
import com.example.helloandroid.presentation.Header

class RegisterFragment : Fragment() {

    @ExperimentalMaterial3Api
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                HelloAndroidTheme {
                    var currentTextState by remember {
                        mutableStateOf("")
                    }
                    var currentEmailState by remember {
                        mutableStateOf("")
                    }
                    var currentPasswordState by remember {
                        mutableStateOf("")
                    }
                    Scaffold(topBar = {
                        TopAppBar(title = {

                        }, navigationIcon = {
                            Row {
                                Spacer(modifier = Modifier.width(16.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.ic_back),
                                    contentDescription = null,
                                    modifier = Modifier.clickable {
                                        findNavController().popBackStack()
                                    }
                                )
                            }
                        })
                    }) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = it.calculateTopPadding())
                                .padding(horizontal = 46.dp),
                            horizontalAlignment = Start
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Header(
                                    modifier = Modifier
                                        .width(115.dp)
                                        .height(58.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(34.dp))
                            Text(
                                text = stringResource(id = R.string.label_create_account),
                                color = Gray707070,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(19.dp))
                            OutlinedTextField(
                                value = currentTextState, onValueChange = { value ->
                                    currentTextState = value
                                },
                                modifier = Modifier.fillMaxWidth(),
                                shape = Shapes.medium,
                                label = {
                                    Text(text = "Nombre")
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Gray4B4747
                                )
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            OutlinedTextField(
                                value = currentEmailState, onValueChange = { value ->
                                    currentEmailState = value
                                },
                                modifier = Modifier.fillMaxWidth(),
                                shape = Shapes.medium,
                                label = {
                                    Text(text = "Correo electronico")
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Gray4B4747
                                ), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            OutlinedTextField(
                                value = currentPasswordState,
                                onValueChange = { value ->
                                    currentPasswordState = value
                                },
                                modifier = Modifier.fillMaxWidth(),
                                shape = Shapes.medium,
                                label = {
                                    Text(text = "Contraseña")
                                },
                                trailingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_password_off),
                                        contentDescription = null
                                    )
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Gray4B4747
                                ),
                                visualTransformation = PasswordVisualTransformation()
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "La contraseña debe contener 8 caracteres",
                                fontStyle = FontStyle.Italic,
                                fontSize = 12.sp,
                                color = Gray4B4747
                            )
                            Spacer(modifier = Modifier.height(34.dp))
                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(54.dp),
                                shape = Shapes.medium.copy(CornerSize(12.dp)),
                                colors = ButtonDefaults.buttonColors(containerColor = Gray707070)
                            ) {
                                Text(text = "Aceptar")
                            }
                        }

                        it.calculateTopPadding()
                    }
                }
            }
        }
    }
}