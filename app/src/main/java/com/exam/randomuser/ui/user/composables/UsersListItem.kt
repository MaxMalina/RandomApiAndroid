package com.exam.randomuser.ui.user.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.exam.randomuser.data.model.User
import com.exam.randomuser.R
import com.exam.randomuser.data.model.buildUserPreview
import com.exam.randomuser.ui.common.RoundedImage


@Composable
fun UsersListItem(
    user: User,
    onItemClick: (User) -> Unit
) {
    val paddingXXSmall = dimensionResource(id = R.dimen.padding_xxsmall)
    val paddingMedium = dimensionResource(id = R.dimen.padding_medium)
    val avatarSize = dimensionResource(id = R.dimen.avatar_size_medium)
    val dividerStartIndent = dimensionResource(id = R.dimen.user_list_item_start_indent)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(user)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingMedium)
        ) {
            RoundedImage(
                url = user.picture,
                placeholder = R.drawable.ic_launcher_foreground,
                modifier = Modifier
                    .size(avatarSize)
                    .padding(end = paddingMedium)
            )
            Column {
                Text(
                    text = user.first,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.size(paddingXXSmall))

                Text(
                    text = user.last,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Divider(
            startIndent = dividerStartIndent,
            modifier = Modifier.padding(end = paddingMedium)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UsersListItemPreview() {
    UsersListItem(user = buildUserPreview(), onItemClick = {})
}