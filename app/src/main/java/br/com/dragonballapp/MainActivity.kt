package br.com.dragonballapp

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.dragonballapp.Adapter.CharacterAdapter
import br.com.dragonballapp.api.CharacterAPI
import br.com.dragonballapp.api.CharacterService
import br.com.dragonballapp.models.Character
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val api = CharacterAPI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvCharacters = findViewById<RecyclerView>(R.id.rvCharacters)
        val loading = findViewById<ProgressBar>(R.id.loading)

        lifecycleScope.launch {
            val service = api.getRetrofit().create(CharacterService::class.java)
            val call = service.getCharacters()

            if(call.isSuccessful) {
                val charactersList = call.body()?.items ?: listOf()
                rvCharacters.adapter = CharacterAdapter(charactersList)

                loading.visibility = View.GONE
                rvCharacters.visibility = View.VISIBLE
            }
            rvCharacters.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}