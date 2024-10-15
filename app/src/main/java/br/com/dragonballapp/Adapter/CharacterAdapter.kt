package br.com.dragonballapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.dragonballapp.CharacterDetailActivity
import br.com.dragonballapp.R
import br.com.dragonballapp.models.Character
import com.squareup.picasso.Picasso

class CharacterAdapter (private val characters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return characters.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val character = characters[position]

            holder.addItem(character)
        }

        class ViewHolder (item : View) : RecyclerView.ViewHolder(item) {

            val image = item.findViewById<ImageView>(R.id.image)
            val description = item.findViewById<TextView>(R.id.description)
            val name = item.findViewById<TextView>(R.id.name)
            val botom = item.findViewById<Button>(R.id.btnvermais)

            fun addItem( character : Character) {
                name.text = character.name
                description.text = character.description

                Picasso.get().load(character.image).into(image)

                botom.setOnClickListener {

                    val intent = Intent(itemView.context, CharacterDetailActivity::class.java)
                    intent.putExtra("item_character", character)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }