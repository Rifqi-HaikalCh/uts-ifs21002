package com.ifs21002.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21002.dinopedia.databinding.ActivityUnitBinding
import com.ifs21002.dinopedia.ProfileActivity

class UnitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUnitBinding
    private val dataDinos = ArrayList<Unit>()

    companion object{
        const val EXTRA_UNIT = "extra_unit"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUnitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.unitDinos.setHasFixedSize(true)
        dataDinos.addAll(getListUnit())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    @SuppressLint("Recycle")
    private fun getListUnit(): ArrayList<Unit> {
        val data = intent.getParcelableArrayListExtra<Unit>(EXTRA_UNIT)

        val listDino = ArrayList<Unit>()
        if (data != null) {
            listDino.addAll(data)
        }
        return listDino
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            binding.unitDinos.layoutManager =
                GridLayoutManager(this, 2)
        } else {
            binding.unitDinos.layoutManager =
                LinearLayoutManager(this)
        }


        val listUnitAdapter = ListUnitAdapter(dataDinos)
        binding.unitDinos.adapter = listUnitAdapter
        listUnitAdapter.setOnItemClickCallback(object :
            ListUnitAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Unit) {
                showSelectedDino(data)
            }
        })
    }

    private fun showSelectedDino(dino: Unit) {
        val intentWithData = Intent(this@UnitActivity,
            DetailActivity::class.java)
        intentWithData.putExtra(DetailActivity.EXTRA_DINO, dino)
        startActivity(intentWithData)
    }

    private fun openProfile(){
        val intent = Intent(this@UnitActivity, ProfileActivity::class.java)
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