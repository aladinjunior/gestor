package com.aladinjunior.gestor.people.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.ui.theme.GestorTheme
import com.aladinjunior.gestor.util.GenericInfoText

private val searchBarMinHeight = 45.dp
private val cornerSearchBarSize = 8.dp
private val iconHorizontalPadding = 10.dp
private val searchBarHintSize = 16.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GestorSearchBar(
    modifier: Modifier = Modifier,
    hint: String,
) {

    SearchBar(
        query = "",
        onQueryChange = {},
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "search", tint = MaterialTheme.colorScheme.onSurfaceVariant)},
        placeholder = { GenericInfoText(text = hint, textSize = searchBarHintSize, textColor = MaterialTheme.colorScheme.onSurface)},
        colors = SearchBarDefaults.colors(containerColor = MaterialTheme.colorScheme.surfaceContainerHigh),
        modifier = modifier,
        shape = RoundedCornerShape(cornerSearchBarSize)
    ) {


    }

}

@Preview(showBackground = true)
@Composable
private fun GestorSearchBarPreview() {

    GestorTheme {
        Box(modifier = Modifier.fillMaxSize()) {

            GestorSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                hint = "Pessoa"
            )
        }
    }
}
