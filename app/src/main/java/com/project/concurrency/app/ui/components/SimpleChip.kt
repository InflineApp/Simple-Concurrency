package com.project.concurrency.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.project.concurrency.app.ui.theme.Gray

@Composable
fun <T> SimpleChip(
    optionsList: List<T>,
    selectedOptions: Set<T>,
    onSelectedOptionsChange: (Set<T>) -> Unit,
    label: (T) -> Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        optionsList.forEach { option ->
            val isSelected = selectedOptions.contains(option)

            FilterChip(
                selected = isSelected,
                onClick = {
                    val newSelection = if(isSelected) selectedOptions - option else selectedOptions + option

                    onSelectedOptionsChange(newSelection)
                },
                label = { Text(stringResource(label(option))) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Gray,
                    selectedLabelColor = Color.White,

                    disabledSelectedContainerColor = Color.White,
                    disabledLabelColor = Gray
                )
            )
        }
    }
}

@Composable
fun <T> SimpleChipSingleSelect(
    optionsList: List<T>,
    selectedOption: T,
    onSelectedOptionChange: (T) -> Unit,
    label: (T) -> Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        optionsList.forEach { option ->
            val isSelected = selectedOption == option

            FilterChip(
                selected = isSelected,
                onClick = {
                    onSelectedOptionChange(option)
                },
                label = { Text(stringResource(label(option))) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Gray,
                    selectedLabelColor = Color.White,

                    disabledSelectedContainerColor = Color.White,
                    disabledLabelColor = Gray
                )
            )
        }
    }
}