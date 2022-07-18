package com.example.mytodo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodo.databinding.TodoItemBinding
import com.example.mytodo.model.todo.ToDo
import java.text.SimpleDateFormat
import java.util.*

// アダプターで扱われるデータとviewholderを指定する
class ToDoAdapter: ListAdapter<ToDo, ToDoAdapter.TodoItemViewHolder>(callBacks) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(inflater, parent, false)
        return TodoItemViewHolder(binding)
    }

    // Viewに値のセットをする。holderとポジションを
    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        // アダプターが保持しているデータはgetitemで取得することができる
        val todo = getItem(position)
        holder.bindTo(todo)
    }

    class TodoItemViewHolder(
        private val binding: TodoItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        // viewに値をbindingをする
        fun bindTo(todo: ToDo) {
            binding.titleText.text = todo.title
            binding.createdText.text = SimpleDateFormat(
                "yyyy/MM/dd HH:mm:ss",
                Locale.JAPAN)
                .format(Date(todo.created))
        }
    }

    companion object {
        // 差分があったときだけここが動いて、viewを変更してくれる
        private val callBacks = object : DiffUtil.ItemCallback<ToDo>() {
            // アイテムが同じかどうかを判別する
            override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
                return oldItem._id == newItem._id
            }
            // リストに表示する内容が同じかどうかを判別する際に呼ばれる
            override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
                return oldItem.title == newItem.title && oldItem.created == newItem.created
            }
        }
    }
}
