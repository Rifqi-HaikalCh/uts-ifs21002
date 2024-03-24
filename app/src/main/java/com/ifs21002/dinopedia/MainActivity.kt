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
import com.ifs21002.dinopedia.ProfileActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataDinos = ArrayList<Dino>()
    private lateinit var intentDinos :Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intentDinos =  Intent(this@MainActivity, DetailDinoActivity::class.java)

        binding.rvDinos.setHasFixedSize(false)
        dataDinos.addAll(getListDinos())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    @SuppressLint("Recycle")
    private fun getListDinos(): ArrayList<Dino> {
        val dataName =
            resources.getStringArray(R.array.dinos_name)
        val dataIcon =
            resources.obtainTypedArray(R.array.dinos_icon)

        val listDino = ArrayList<Dino>()
        for (i in dataName.indices) {
            val dino = Dino(dataIcon.getResourceId(i, -1), dataName[i])
            listDino.add(dino)
        }
        return listDino
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvDinos.layoutManager =
                GridLayoutManager(this, 2)
        } else {
            binding.rvDinos.layoutManager =
                LinearLayoutManager(this)
        }

        val listDinoAdapter = ListDinoAdapter(dataDinos)
        binding.rvDinos.adapter = listDinoAdapter
        listDinoAdapter.setOnItemClickCallback(object :
            ListDinoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Dino) {
                showSelectedDino(data)
            }
        })
    }

    @SuppressLint("Recycle")
    private fun showSelectedDino(dino: Dino) {

        when (dino.text){
            "Theropoda" -> {
                getDetailFamili(0)
            }

            "Sauropoda" -> {
                getDetailFamili(1)
            }

            "Stegosauridae" -> {
                getDetailFamili(2)
            }

            "Hadrosauridae" -> {
                getDetailFamili(3)
            }

            "Ceratopsidae" -> {
                getDetailFamili(4)
            }

            "Ankylosauridae" -> {
                getDetailFamili(5)
            }

            "Ornithomimidae" -> {
                getDetailFamili(6)
            }

            "Pterosauria" -> {
                getDetailFamili(7)
            }
        }
        startActivity(intentDinos)
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
    private fun getDetailFamili(index : Int){
        val theroName = resources.getStringArray(R.array.dinos_name)
        val theroImg = resources.obtainTypedArray(R.array.dinos_icon)
        val theroDesc = resources.getStringArray(R.array.dinos_description)
        val theroHabitat = resources.getStringArray(R.array.dinos_habitat)
        val theroChar = resources.getStringArray(R.array.dinos_characteristic)

        intentDinos.putExtra(DetailDinoActivity.EXTRA_NAME, theroName[index])
        intentDinos.putExtra(DetailDinoActivity.EXTRA_ICON, theroImg.getResourceId(index, -1))
        intentDinos.putExtra(DetailDinoActivity.EXTRA_DESC, theroDesc[index])
        intentDinos.putExtra(DetailDinoActivity.EXTRA_HABITAT, theroHabitat[index])
        intentDinos.putExtra(DetailDinoActivity.EXTRA_CHAR, theroChar[index])
    }
}
