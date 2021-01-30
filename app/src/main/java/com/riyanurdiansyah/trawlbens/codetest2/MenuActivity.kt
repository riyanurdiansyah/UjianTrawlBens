package com.riyanurdiansyah.trawlbens.codetest2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.riyanurdiansyah.trawlbens.MainActivity
import com.riyanurdiansyah.trawlbens.R
import com.riyanurdiansyah.trawlbens.codetest2.adapter.CategoriesAdapter
import com.riyanurdiansyah.trawlbens.codetest2.api.ApiClient
import com.riyanurdiansyah.trawlbens.codetest2.model.Categories
import com.riyanurdiansyah.trawlbens.codetest2.model.CategoriesObject
import kotlinx.android.synthetic.main.activity_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuActivity : AppCompatActivity() {

    private val list = ArrayList<CategoriesObject>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val window: Window = this.window
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        showData()
    }

    private fun showData() {
        rvCategori.setHasFixedSize(true)
        rvCategori.layoutManager = GridLayoutManager(this, 2)
        ApiClient.instance.getCategories().enqueue(object : Callback<Categories>{
            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                Toast.makeText(applicationContext, "Status kode : "+response.code(), Toast.LENGTH_SHORT).show()

                val listResponse = response.body()?.categories
                listResponse?.let { list.addAll(it) }
                val adapter = CategoriesAdapter(list)
                rvCategori.adapter = adapter
            }

            override fun onFailure(call: Call<Categories>, t: Throwable) {
                Toast.makeText(applicationContext, ""+t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}