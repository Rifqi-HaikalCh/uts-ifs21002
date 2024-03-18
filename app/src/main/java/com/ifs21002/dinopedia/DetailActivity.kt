package com.ifs21002.dinopedia

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ifs21002.dinopedia.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var fruit: Fruit? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fruit = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_FRUIT, Fruit::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_FRUIT)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (fruit != null) {
            supportActionBar?.title = "About ${fruit!!.name}"
            loadData(fruit!!)
        } else {
            finish()
        }
    }

    private fun loadData(fruit: Fruit) {
        binding.ivDetailIcon.setImageResource(fruit.icon)
        binding.tvDetailName.text = fruit.name
        binding.tvDetailDescription.text = fruit.description
        binding.tvDetailCharacteristic.text = fruit.characteristic
        binding.tvDetailHabitat.text = fruit.habitat
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
            R.id.menu_about -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.setType("text/plain")
                shareIntent.putExtra(Intent.EXTRA_TEXT, "${fruit!!.name}, ${fruit!!.description}")
                startActivity(Intent.createChooser(shareIntent, "Share Via"))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_FRUIT = "extra_fruit"
    }

}