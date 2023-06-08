package com.example.helloandroid.presentation.fragmens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.findNavController
import com.example.helloandroid.R
import com.example.helloandroid.presentation.theme.HelloAndroidTheme
import com.example.helloandroid.presentation.LoginScreen

class LoginFragment : androidx.fragment.app.Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                HelloAndroidTheme {
                    LoginScreen {
                        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
                    }
                }
            }
        }
    }
}