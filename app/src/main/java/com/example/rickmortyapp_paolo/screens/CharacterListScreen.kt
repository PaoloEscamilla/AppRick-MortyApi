package com.example.rickmortyapp_paolo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberImagePainter
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.rickmortyapp_paolo.data.RetrofitInstance
import com.example.rickmortyapp_paolo.model.Character

@Composable
fun CharacterListScreen(onCharacterClick: (Character) -> Unit) {
    var characters by remember { mutableStateOf<List<Character>>(emptyList()) }

    // Efecto lanzado para cargar los personajes de la API
    LaunchedEffect(Unit) {
        val fetchedCharacters = RetrofitInstance.api.getCharacters().body()?.results
        if (fetchedCharacters != null) {
            characters = fetchedCharacters
        }
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(characters) { character ->
            CharacterCard(character = character, onClick = { onCharacterClick(character) })
        }
    }
}

@Composable
fun CharacterCard(character: Character, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)

    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberImagePainter(character.image),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = character.name, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
                Text(text = character.species, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
