package com.devscion.kmmtodo.android.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devscion.kmmtodo.android.R
import com.devscion.kmmtodo.model.Todo

@Composable
fun TodoListItem(todo: Todo, viewModel: TodosViewModel) {
    Column(Modifier.padding(10.dp), verticalArrangement = Arrangement.Center) {
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .padding(1.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
                    .padding(1.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(1.dp)
                    .toggleable(todo.isDone) {
                        viewModel.toggleDone(todo)
                    },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painterResource(
                        id = if (todo.isDone) R.drawable.ic_round_done_24
                        else R.drawable.ic_round_access_time_filled_24
                    ),
                    tint = if (todo.isDone) Color.Green else Color.Red,
                    contentDescription = "done"
                )
            }
            Text(
                text = todo.todo,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .weight(2f)
                    .padding(horizontal = 5.dp)
            )
            IconButton(
                onClick = {
                    viewModel.deleteTodo(todo)
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_delete_24),
                    contentDescription = "delete",
                    tint = Color.Red
                )
            }
        }
        Text(
            text = todo.date,
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
    }
}