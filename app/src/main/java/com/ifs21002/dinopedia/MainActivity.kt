package com.ifs21002.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21002.dinopedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataFruits = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvFruits.setHasFixedSize(false)
        dataFruits.addAll(getListFruits())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }



    @SuppressLint("Recycle")
    private fun getListFruits(): ArrayList<Fruit> {
        val dataName =
            resources.getStringArray(R.array.fruits_name)
        val dataIcon =
            resources.obtainTypedArray(R.array.fruits_icon)
        val dataDescription =
            resources.getStringArray(R.array.fruits_description)
        val dataCharacteristic =
            resources.getStringArray(R.array.fruits_characteristic)
        val dataHabitat =
            resources.getStringArray(R.array.fruits_habitat)


        val listFruit = ArrayList<Fruit>()
        for (i in dataName.indices) {
            val fruit = Fruit(dataName[i],
                dataIcon.getResourceId(i, -1), dataDescription[i],
                dataCharacteristic[i], dataHabitat[i])
            listFruit.add(fruit)
        }
        return listFruit
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvFruits.layoutManager =
                GridLayoutManager(this, 2)
        } else {
            binding.rvFruits.layoutManager =
                LinearLayoutManager(this)
        }

        val listFruitAdapter = ListFruitAdapter(dataFruits)
        binding.rvFruits.adapter = listFruitAdapter
        listFruitAdapter.setOnItemClickCallback(object :
            ListFruitAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Fruit) {
                showSelectedFruit(data)
            }
        })
    }

    private fun showSelectedFruit(fruit: Fruit) {
        val intentWithData = Intent(this@MainActivity,
            DetailActivity::class.java)
        intentWithData.putExtra(DetailActivity.EXTRA_FRUIT, fruit)
        startActivity(intentWithData)
    }

    private fun openProfile(){
        val intent = Intent(this@MainActivity, ProfileActivity::class.java)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_about -> {
                // Tambahkan kode aksi yang diinginkan di sini
                openProfile()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }
}

