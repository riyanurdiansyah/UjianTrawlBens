package com.riyanurdiansyah.trawlbens.codetest2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.riyanurdiansyah.trawlbens.R
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.SimpleDateFormat

class DetailActivity : AppCompatActivity() {
    private var backPressDelay = 0L
    private var press = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val window: Window = this.window
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        tvCategoriDetail.text = intent.getStringExtra("kategori")
        tvDeskripsiDetail.text = intent.getStringExtra("deskripsi")

        Glide.with(this)
            .load(intent.getStringExtra("foto"))
            .into(ivFotoDetail)

        ivBack.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }

    override fun onBackPressed() {
        Handler(Looper.getMainLooper()).postDelayed({
            super.onBackPressed()
        }, 3000)
    }
}