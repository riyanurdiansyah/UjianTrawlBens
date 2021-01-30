package com.riyanurdiansyah.trawlbens.codetest1

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.riyanurdiansyah.trawlbens.R
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {
    private val signInFragment = SignInFragment()
    private val signUpFragment = SignUpFragment()

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        if(savedInstanceState == null) {
            loadFragment(signInFragment)
            btnSignOff()
        }

        btnSignIn.setOnClickListener{
            loadFragment(signInFragment)
            btnSignOff()

        }

        btnSignUp.setOnClickListener {
            loadFragment(signUpFragment)
            btnSignupOff()
        }
    }

    private fun btnSignupOff() {
        btnSignIn.isEnabled = true
        btnSignUp.isEnabled = false
        btnSignIn.setBackgroundResource(R.drawable.bg_button)
        btnSignUp.setBackgroundResource(R.drawable.bg_button_false)
    }

    private fun btnSignOff() {
        btnSignIn.isEnabled = false
        btnSignUp.isEnabled = true
        btnSignIn.setBackgroundResource(R.drawable.bg_button_false)
        btnSignUp.setBackgroundResource(R.drawable.bg_button)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}

