package com.exam.randomuser.ui.user.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.exam.randomuser.data.model.User
import com.exam.randomuser.data.model.buildUserPreview

@Composable
fun UsersList(
    users: List<User>,
    onItemClick: (User) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                UsersListHeader()
            }
            items(users) { user ->
                UsersListItem(user = user, onItemClick = onItemClick)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsersListPreview() {
    val users = List(3) { buildUserPreview() }
    UsersList(users = users) {}
}