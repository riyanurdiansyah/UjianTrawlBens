package com.riyanurdiansyah.trawlbens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.riyanurdiansyah.trawlbens.codetest1.AuthActivity
import com.riyanurdiansyah.trawlbens.codetest2.MenuActivity
import com.riyanurdiansyah.trawlbens.codetest3.DesignActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val window: Window = this.window
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        btnTes1.setOnClickListener {
            startActivity(Intent(this, AuthActivity::class.java))
        }

        btnTes2.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

        btnTes3.setOnClickListener {
            startActivity(Intent(this, DesignActivity::class.java))
        }
    }
}