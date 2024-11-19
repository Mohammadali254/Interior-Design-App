package com.example.interiordesigns


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interiordesigns.model.Interior
import com.example.interiordesigns.model.InteriorRepository
import com.example.interiordesigns.ui.theme.InteriorDesignsTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InteriorDesignsTheme {
               Surface(modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
               )
               {
                  InteriorDesignsApp()
               }
            }
        }
    }
}

@Composable
fun InteriorDesignsApp(modifier: Modifier = Modifier){


    Scaffold (
        topBar = { TopAppBar() }
    ){ paddingValues ->
        Surface(modifier = modifier.fillMaxSize()
            .padding(paddingValues)) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium)),
                modifier = Modifier.padding(dimensionResource(id = R.dimen.medium))
            )
            {
                items(InteriorRepository.items) { item ->
                    InteriorDesignsCard(items = item)
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
           Text(
               text = stringResource(R.string.app_name),
               style = MaterialTheme.typography.displayLarge
           )
        },
        modifier = modifier
    )
}


@Composable
//defines the App layout
fun InteriorDesignsCard(
    items : Interior,
    modifier: Modifier = Modifier
){
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = CardDefaults.cardElevation(40.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(dimensionResource(id = R.dimen.large))
            .animateContentSize()
            .height(if (expanded) 400.dp else 200.dp)
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { androidx.compose.foundation.interaction.MutableInteractionSource() },
                indication = null
            ){
                expanded = !expanded
            },
        border = BorderStroke(1.dp, Color(0xFF99FFCC))
    ){
        Column(modifier = Modifier
            .fillMaxWidth())
        {
            // Title
            Text(
                text = stringResource(items.nameRes),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(
                    top = dimensionResource(id = R.dimen.medium),
                    start = dimensionResource(id = R.dimen.small),
                    )
            )

            // Tip
            Text(
                text = stringResource(items.tipRes),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.small)),
                )

            Spacer(modifier = Modifier.heightIn(dimensionResource(id = R.dimen.medium)))
            // Image
            Image(
                painter = painterResource(items.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.medium)))
            // Description
            Text(
                text = stringResource(items.descriptionRes),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.medium),
                    bottom = dimensionResource(id = R.dimen.large)
                )

            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InteriorDesignsTheme() {
     //  InteriorDesignsCard(
       //    Interior(R.string.bathroom_4, R.string.tip_4, R.drawable.bath_4, R.string.description_4)
      // )

      InteriorDesignsApp()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingDarkPreview() {
    InteriorDesignsTheme(darkTheme = true) {
        InteriorDesignsApp()
    }
}