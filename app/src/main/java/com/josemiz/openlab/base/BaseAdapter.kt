package com.josemiz.openlab.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<V : RecyclerView.ViewHolder,T> : RecyclerView.Adapter<V>() {

    var list: List<T> = emptyList()

    override fun getItemCount(): Int = list.size

    fun setData(list: List<T>) {
        this.list = list
        notifyDataSetChanged()
    }

}