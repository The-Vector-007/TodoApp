package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*
import java.text.SimpleDateFormat
import java.util.*

class TodoAdapter(val list: List<TodoTable>) : RecyclerView.Adapter<TodoAdapter.todoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoViewHolder {
        return todoViewHolder( LayoutInflater.from(parent.context).inflate( R.layout.item_todo, parent, false ) )
    }

    override fun onBindViewHolder(holder: todoViewHolder, position: Int) {
        holder.bind( list[position] )
    }

    override fun getItemCount() = list.size

    override fun getItemId(position: Int): Long {
        return list[position].id
    }

    class todoViewHolder( itemView : View) : RecyclerView.ViewHolder( itemView ){
        fun bind( todoTable: TodoTable ){
            with( itemView ){
                val colors = resources.getIntArray(R.array.random_color)
                val randomColor = colors[Random().nextInt(colors.size)]
                viewColorTag.setBackgroundColor(randomColor)
                txtShowTitle.text = todoTable.title
                txtShowTask.text = todoTable.description
                txtShowCategory.text = todoTable.category
                updateTime(todoTable.time)
                updateDate(todoTable.date)
            }
        }

        private fun updateTime(time: Long) {
            //Mon, 5 Jan 2020
            val myformat = "h:mm a"
            val sdf = SimpleDateFormat(myformat)
            itemView.txtShowTime.text = sdf.format(Date(time))

        }

        private fun updateDate(time: Long) {
            //Mon, 5 Jan 2020
            val myformat = "EEE, d MMM yyyy"
            val sdf = SimpleDateFormat(myformat)
            itemView.txtShowDate.text = sdf.format(Date(time))

        }
    }

}