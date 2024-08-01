package com.nicolascristaldo.a30daysofanimals

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicolascristaldo.a30daysofanimals.model.Animal
import com.nicolascristaldo.a30daysofanimals.model.AnimalRepository
import com.nicolascristaldo.a30daysofanimals.ui.theme.Shapes
import com.nicolascristaldo.a30daysofanimals.ui.theme._30DaysOfAnimalsTheme

@Composable
fun AnimalList(
    animals: List<Animal>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier
    ) {
        items(animals) { animal ->
            AnimalItem(
                animal = animal,
                day = animals.indexOf(animal) + 1,
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(id = R.dimen.padding_small),
                        horizontal = dimensionResource(id = R.dimen.padding_medium)
                    )
            )
        }
    }
}

@Composable
fun AnimalItem(
    animal: Animal,
    day: Int,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding()
        ) {
            Text(text = stringResource(
                id = R.string.day, day),
                style = MaterialTheme.typography.displayMedium
            )
            AnimalImage(imageRes = animal.image)
            Text(
                text = stringResource(id = animal.name),
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(bottom = dimensionResource(id = R.dimen.padding_short))
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(id = animal.description),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


@Composable
fun AnimalImage(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small))
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.clip(shape = Shapes.small)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(modifier: Modifier = Modifier) {
    _30DaysOfAnimalsTheme {
        AnimalList(animals = AnimalRepository.animals)
    }
}