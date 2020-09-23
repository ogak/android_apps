package com.example.dadu

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var gambarDadu : ImageView
    lateinit var gambarDadu2 : ImageView
    lateinit var switchDadu : Switch
    lateinit var acakBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        acakBtn = findViewById(R.id.acak_btn)
        gambarDadu = findViewById(R.id.gambar_dadu)
        gambarDadu2 = findViewById(R.id.gambar_dadu2)
        switchDadu = findViewById(R.id.switch_dadu)
        InitialDisplay()
        acakBtn.setOnClickListener {
           Acak()
        }
        switchDadu.setOnCheckedChangeListener { _ , isChecked ->
          if (isChecked) {
              gambar_dadu2.visibility = View.VISIBLE
              ChangeViewWrapContent(gambar_dadu)
          } else {
              gambar_dadu2.visibility = View.GONE
              ChangeViewMatchParent(gambarDadu)
          }
        }

    }

    private fun InitialDisplay() {
        gambar_dadu2.visibility = View.GONE
        ChangeViewMatchParent(gambar_dadu)
    }
    private fun Acak() {
        gambarDadu.setImageResource(getRandomGambarDadu())
        gambarDadu2.setImageResource(getRandomGambarDadu())
    }

    private fun getRandomGambarDadu() : Int {
        val drawableResource = when (Randomizer()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }

    private fun Randomizer(): Int {
        val randomizer = Random.nextInt(6) + 1
        return randomizer
    }

    private fun ChangeViewMatchParent(v: View){
        v.getLayoutParams().width= LinearLayout.LayoutParams.MATCH_PARENT;
    }
    private fun ChangeViewWrapContent(v: View) {
        v.getLayoutParams().width= LinearLayout.LayoutParams.WRAP_CONTENT;
    }
}