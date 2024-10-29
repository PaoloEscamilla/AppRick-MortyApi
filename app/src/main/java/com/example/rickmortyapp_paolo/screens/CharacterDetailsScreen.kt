package com.example.rickmortyapp_paolo.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rickmortyapp_paolo.model.Character
import com.example.rickmortyapp_paolo.data.RetrofitInstance

@Composable
fun CharacterDetailScreen(characterId: Int) {
    var character by remember { mutableStateOf<Character?>(null) }

    // Efecto para cargar los detalles del personaje
    LaunchedEffect(characterId) {
        val fetchedCharacter = RetrofitInstance.api.getCharacterById(characterId).body()
        character = fetchedCharacter
    }

    // Mostrar los detalles del personaje
    character?.let {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            AsyncImage(
                model = it.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it.name, style = MaterialTheme.typography.titleLarge)
            Text(text = "Status: ${it.status}")
            Text(text = "Species: ${it.species}")
            Text(text = "Gender: ${it.gender}")
            Text(text = "Location: ${it.location.name}")
        }
    }
}
