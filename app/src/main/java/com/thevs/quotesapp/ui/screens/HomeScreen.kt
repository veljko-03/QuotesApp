package com.thevs.quotesapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.thevs.quotesapp.model.QuotesAPI
import com.thevs.quotesapp.ui.components.Title
import com.thevs.quotesapp.ui.components.BaseButton
import com.thevs.quotesapp.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel) {
    Title(title = "Random Quote")
    Column {
        viewModel.quotes.value.forEach { quote ->
            QuoteItem(quote, viewModel)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun QuoteItem(quote: QuotesAPI.QuoteBean, viewModel: MainViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().padding(vertical = 136.dp)
    ) {
        Text(text = "${quote.text} - ${quote.author}", textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(8.dp))
        BaseButton({ viewModel.loadQuotes() }, "", "Refresh")
    }
}
