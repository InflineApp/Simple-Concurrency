package com.project.concurrency.app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly
import com.project.concurrency.app.R
import com.project.concurrency.app.ui.theme.Gray

@Composable
fun SimpleTextField(
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    label: String,
    modifier: Modifier = Modifier,
    isDigitsOnly: Boolean = true
) {
    val customTextSelectionColors = TextSelectionColors(
        handleColor = Gray,
        backgroundColor = Gray.copy(alpha = 0.4f)
    )

    CompositionLocalProvider(
        LocalTextSelectionColors provides customTextSelectionColors
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                if (isDigitsOnly && it.isDigitsOnly()) {
                    onValueChange(it)
                }
                else if(!isDigitsOnly){
                    onValueChange(it)
                }
            },
            label = {
                Text(
                    text = label
                )
            },
            modifier = modifier,
            keyboardOptions = keyboardOptions,
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Gray,
                focusedBorderColor = Gray,
                focusedLabelColor = Gray,
                unfocusedTextColor = Gray,
                unfocusedBorderColor = Gray,
                unfocusedLabelColor = Gray,
                cursorColor = Gray
            )
        )
    }
}