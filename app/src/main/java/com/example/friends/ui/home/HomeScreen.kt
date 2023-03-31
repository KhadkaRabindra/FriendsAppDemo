package com.example.friends.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.friends.domain.model.User
import com.example.friends.domain.utils.DataStatus
import com.example.friends.domain.utils.Screen
import com.example.friends.ui.common.ProgressBarComponent
import com.example.friends.ui.viewmodel.UserViewModel

@Composable
fun HomeScreen(
    navController: NavHostController, viewModel: UserViewModel
) {
    val userListDetail by viewModel.userListDetailState.collectAsState()
    DisposableEffect(Unit) {
        viewModel.getAllUsers("10")
        onDispose {
        }
    }

    when (userListDetail.status) {
        DataStatus.LOADING -> {
            ProgressBarComponent()
        }
        DataStatus.SUCCESS -> {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(8.dp),
                columns = GridCells.Fixed(2)
            ) {
                userListDetail.data?.size?.let {
                    items(it) {
                        UserRow(
                            user = userListDetail.data!![it],
                            navController = navController,
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
        else -> {}
    }
}


//List Item
@Composable
fun UserRow(user: User, navController: NavHostController, viewModel: UserViewModel) {
    Card(
        modifier = Modifier
            .padding(5.dp, 4.dp, 5.dp, 4.dp)
            .fillMaxWidth()
            .clickable(indication = rememberRipple(bounded = true),
                interactionSource = remember { MutableInteractionSource() }) {
                viewModel.selectedUser = user
                navController.navigate(Screen.Details.route)
            },
        shape = RoundedCornerShape(CornerSize(5.dp)),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(CornerSize(10.dp))),
                model = user.portrait,
                contentDescription = null
            )

            Column(
                modifier = Modifier
                    .padding(10.dp, 5.dp, 0.dp, 5.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = user.fullName ?: "",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1,
                )

                Text(
                    text = user.address ?: "",
                    maxLines = 1,
                    style = MaterialTheme.typography.h6,
                )
            }
        }
    }
}

