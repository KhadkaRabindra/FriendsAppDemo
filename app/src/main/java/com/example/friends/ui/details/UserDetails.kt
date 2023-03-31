package com.example.friends.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.friends.domain.model.User
import com.example.friends.domain.utils.Screen

//User Detail Screen
@Composable
fun UserDetailsScreen(navController: NavHostController, user: User) {

    Column(
        Modifier
            .padding(8.dp)
            .background(Color.White)
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {

        Row(
            modifier = Modifier
                .padding(8.dp)
                .background(Color.White)
                .fillMaxWidth()
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
        }

        Box(
            modifier = Modifier
                .padding(8.dp, 4.dp, 8.dp, 4.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                AsyncImage(
                    modifier = Modifier
                        .size(250.dp)
                        .align(Alignment.CenterHorizontally)
                        .clip(RoundedCornerShape(CornerSize(10.dp))),
                    model = user.portrait,
                    contentDescription = null
                )


                Text(
                    text = "Full Name: " + user.fullName,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1,
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(Screen.Home.route)
                        },
                ) {
                    Text(
                        text = "Address: ",
                        style = MaterialTheme.typography.caption,
                    )
                    Text(
                        text = user.address ?: "",
                        style = MaterialTheme.typography.caption,
                        softWrap = true
                    )
                }

                Text(
                    text = "City: " + user.city,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.caption,
                )

                Text(
                    text = "State: " + user.state,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.caption,
                )

                Text(
                    text = "Country: " + user.country,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.caption,
                )

                Text(
                    text = "Email: " + user.email,
                    modifier = Modifier.padding(0.dp, 0.dp, 4.dp, 0.dp),
                    style = MaterialTheme.typography.caption,
                )

                Text(
                    text = "Cell Phone: " + user.phoneNo,
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }
}