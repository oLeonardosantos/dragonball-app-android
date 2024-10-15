package br.com.dragonballapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.dragonballapp.models.Character
import com.squareup.picasso.Picasso

class CharacterDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        val character = intent.getSerializableExtra("item_character") as Character

        val image = findViewById<ImageView>(R.id.imagem)
        Picasso.get().load(character.image).into(image)

        val descricao = findViewById<TextView>(R.id.description)
        descricao.text = "${character.race} - ${character.gender}"

        val nome = findViewById<TextView>(R.id.goku)
        nome.text = character.name

        val ki = findViewById<TextView>(R.id.descriptionki)
        ki.text = character.ki

        val maxKi = findViewById<TextView>(R.id.ki)
        maxKi.text = character.maxKi

        val affi = findViewById<TextView>(R.id.afi)
        affi.text = character.affiliation
    }
}