package com.ifs21002.dinopedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ifs21002.dinopedia.databinding.ActivityDetailDinoBinding

class DetailDinoActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_ICON = "extra_icon"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_HABITAT = "extra_habitat"
        const val EXTRA_CHAR = "extra_char"
    }
    private lateinit var binding : ActivityDetailDinoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDinoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name = intent.getStringExtra(EXTRA_NAME)
        var icon = intent.getIntExtra(EXTRA_ICON, 1)
        var desc = intent.getStringExtra(EXTRA_DESC)
        var habitat = intent.getStringExtra(EXTRA_HABITAT)
        var char = intent.getStringExtra(EXTRA_CHAR)

        binding.ivDetailIcon.setImageResource(icon)
        binding.tvDetailName.text = name
        binding.tvDetailDescription.text = desc
        binding.tvDetailHabitat.text = habitat
        binding.tvDetailCharacteristic.text = char

        binding.button.setOnClickListener{
            showSelectedDino(name)
        }
    }

    private fun showSelectedDino(name : String?) {
        val listDino = ArrayList<Unit>()
        val intentWithData = Intent(this@DetailDinoActivity,
            UnitActivity::class.java)

        when (name){
            "Theropoda" -> {
                val theroName = resources.getStringArray(R.array.thero_name)
                val theroImg = resources.obtainTypedArray(R.array.thero_image)
                val theroDesc = resources.getStringArray(R.array.thero_description)
                val theroHabitat = resources.getStringArray(R.array.thero_habitat)
                val theroChar = resources.getStringArray(R.array.thero_characteristic)
                val theroKel = resources.getStringArray(R.array.thero_kelompok)
                val theroMak = resources.getStringArray(R.array.thero_makanan)
                val theroPan = resources.getStringArray(R.array.thero_panjang)
                val theroTing = resources.getStringArray(R.array.thero_tinggi)
                val theroBot = resources.getStringArray(R.array.thero_bobot)
                val theroKelemahan = resources.getStringArray(R.array.thero_kelemahan)

                for (i in theroName.indices){
                    val list = Unit( theroName[i], theroImg.getResourceId(i,-1),
                        theroDesc[i], theroChar[i], theroHabitat[i], theroKelemahan[i], theroPan[i], theroTing[i], theroBot[i],theroMak[i], theroKel[i])
                    listDino.add(list)
                }
            }

            "Sauropoda" -> {
                val theroName = resources.getStringArray(R.array.sauro_name)
                val theroImg = resources.obtainTypedArray(R.array.sauro_image)
                val theroDesc = resources.getStringArray(R.array.sauro_description)
                val theroHabitat = resources.getStringArray(R.array.sauro_habitat)
                val theroChar = resources.getStringArray(R.array.sauro_characteristic)
                val theroKel = resources.getStringArray(R.array.sauro_kelompok)
                val theroMak = resources.getStringArray(R.array.sauro_makanan)
                val theroPan = resources.getStringArray(R.array.sauro_panjang)
                val theroTing = resources.getStringArray(R.array.sauro_tinggi)
                val theroBot = resources.getStringArray(R.array.sauro_bobot)
                val theroKelemahan = resources.getStringArray(R.array.sauro_kelemahan)

                for (i in theroName.indices){
                    val list = Unit( theroName[i], theroImg.getResourceId(i,-1),
                        theroDesc[i], theroChar[i], theroHabitat[i], theroKelemahan[i], theroPan[i], theroTing[i], theroBot[i],theroMak[i], theroKel[i])
                    listDino.add(list)
                }
            }

            "Stegosauridae" -> {
                val theroName = resources.getStringArray(R.array.stego_name)
                val theroImg = resources.obtainTypedArray(R.array.stego_image)
                val theroDesc = resources.getStringArray(R.array.stego_description)
                val theroHabitat = resources.getStringArray(R.array.stego_habitat)
                val theroChar = resources.getStringArray(R.array.stego_characteristic)
                val theroKel = resources.getStringArray(R.array.stego_kelompok)
                val theroMak = resources.getStringArray(R.array.stego_makanan)
                val theroPan = resources.getStringArray(R.array.stego_panjang)
                val theroTing = resources.getStringArray(R.array.stego_tinggi)
                val theroBot = resources.getStringArray(R.array.stego_bobot)
                val theroKelemahan = resources.getStringArray(R.array.stego_kelemahan)

                for (i in theroName.indices){
                    val list = Unit( theroName[i], theroImg.getResourceId(i,-1),
                        theroDesc[i], theroChar[i], theroHabitat[i], theroKelemahan[i], theroPan[i], theroTing[i], theroBot[i],theroMak[i], theroKel[i])
                    listDino.add(list)
                }
            }

            "Hadrosauridae" -> {
                val theroName = resources.getStringArray(R.array.hadro_name)
                val theroImg = resources.obtainTypedArray(R.array.hadro_image)
                val theroDesc = resources.getStringArray(R.array.hadro_description)
                val theroHabitat = resources.getStringArray(R.array.hadro_habitat)
                val theroChar = resources.getStringArray(R.array.hadro_characteristic)
                val theroKel = resources.getStringArray(R.array.hadro_kelompok)
                val theroMak = resources.getStringArray(R.array.hadro_makanan)
                val theroPan = resources.getStringArray(R.array.hadro_panjang)
                val theroTing = resources.getStringArray(R.array.hadro_tinggi)
                val theroBot = resources.getStringArray(R.array.hadro_bobot)
                val theroKelemahan = resources.getStringArray(R.array.hadro_kelemahan)

                for (i in theroName.indices){
                    val list = Unit( theroName[i], theroImg.getResourceId(i,-1),
                        theroDesc[i], theroChar[i], theroHabitat[i], theroKelemahan[i], theroPan[i], theroTing[i], theroBot[i],theroMak[i], theroKel[i])
                    listDino.add(list)
                }
            }

            "Ceratopsidae" -> {
                val theroName = resources.getStringArray(R.array.cera_name)
                val theroImg = resources.obtainTypedArray(R.array.cera_image)
                val theroDesc = resources.getStringArray(R.array.cera_description)
                val theroHabitat = resources.getStringArray(R.array.cera_habitat)
                val theroChar = resources.getStringArray(R.array.cera_characteristic)
                val theroKel = resources.getStringArray(R.array.cera_kelompok)
                val theroMak = resources.getStringArray(R.array.cera_makanan)
                val theroPan = resources.getStringArray(R.array.cera_panjang)
                val theroTing = resources.getStringArray(R.array.cera_tinggi)
                val theroBot = resources.getStringArray(R.array.cera_bobot)
                val theroKelemahan = resources.getStringArray(R.array.cera_kelemahan)

                for (i in theroName.indices){
                    val list = Unit( theroName[i], theroImg.getResourceId(i,-1),
                        theroDesc[i], theroChar[i], theroHabitat[i], theroKelemahan[i], theroPan[i], theroTing[i], theroBot[i],theroMak[i], theroKel[i])
                    listDino.add(list)
                }
            }

            "Ankylosauridae" -> {
                val theroName = resources.getStringArray(R.array.anky_name)
                val theroImg = resources.obtainTypedArray(R.array.anky_image)
                val theroDesc = resources.getStringArray(R.array.anky_description)
                val theroHabitat = resources.getStringArray(R.array.anky_habitat)
                val theroChar = resources.getStringArray(R.array.anky_characteristic)
                val theroKel = resources.getStringArray(R.array.anky_kelompok)
                val theroMak = resources.getStringArray(R.array.anky_makanan)
                val theroPan = resources.getStringArray(R.array.anky_panjang)
                val theroTing = resources.getStringArray(R.array.anky_tinggi)
                val theroBot = resources.getStringArray(R.array.anky_bobot)
                val theroKelemahan = resources.getStringArray(R.array.anky_kelemahan)

                for (i in theroName.indices){
                    val list = Unit( theroName[i], theroImg.getResourceId(i,-1),
                        theroDesc[i], theroChar[i], theroHabitat[i], theroKelemahan[i], theroPan[i], theroTing[i], theroBot[i],theroMak[i], theroKel[i])
                    listDino.add(list)
                }
            }

            "Ornithomimidae" -> {
                val theroName = resources.getStringArray(R.array.orni_name)
                val theroImg = resources.obtainTypedArray(R.array.orni_image)
                val theroDesc = resources.getStringArray(R.array.orni_description)
                val theroHabitat = resources.getStringArray(R.array.orni_habitat)
                val theroChar = resources.getStringArray(R.array.orni_characteristic)
                val theroKel = resources.getStringArray(R.array.orni_kelompok)
                val theroMak = resources.getStringArray(R.array.orni_makanan)
                val theroPan = resources.getStringArray(R.array.orni_panjang)
                val theroTing = resources.getStringArray(R.array.orni_tinggi)
                val theroBot = resources.getStringArray(R.array.orni_bobot)
                val theroKelemahan = resources.getStringArray(R.array.orni_kelemahan)

                for (i in theroName.indices){
                    val list = Unit( theroName[i], theroImg.getResourceId(i,-1),
                        theroDesc[i], theroChar[i], theroHabitat[i], theroKelemahan[i], theroPan[i], theroTing[i], theroBot[i],theroMak[i], theroKel[i])
                    listDino.add(list)
                }
            }

            "Pterosauria" -> {
                val theroName = resources.getStringArray(R.array.ptero_name)
                val theroImg = resources.obtainTypedArray(R.array.ptero_image)
                val theroDesc = resources.getStringArray(R.array.ptero_description)
                val theroHabitat = resources.getStringArray(R.array.ptero_habitat)
                val theroChar = resources.getStringArray(R.array.ptero_characteristic)
                val theroKel = resources.getStringArray(R.array.ptero_kelompok)
                val theroMak = resources.getStringArray(R.array.ptero_makanan)
                val theroPan = resources.getStringArray(R.array.ptero_panjang)
                val theroTing = resources.getStringArray(R.array.ptero_tinggi)
                val theroBot = resources.getStringArray(R.array.ptero_bobot)
                val theroKelemahan = resources.getStringArray(R.array.ptero_kelemahan)

                for (i in theroName.indices){
                    val list = Unit( theroName[i], theroImg.getResourceId(i,-1),
                        theroDesc[i], theroChar[i], theroHabitat[i], theroKelemahan[i], theroPan[i], theroTing[i], theroBot[i],theroMak[i], theroKel[i])
                    listDino.add(list)
                }
            }
        }
        intentWithData.putExtra(UnitActivity.EXTRA_UNIT, listDino)
        startActivity(intentWithData)
    }
}