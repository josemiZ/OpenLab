package com.josemiz.openlab.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.josemiz.openlab.main.team.TeamAdapter
import com.josemiz.openlab.main.welcome.WelcomeAdapter
import com.josemiz.openlab.model.TeamModel

@BindingAdapter("data")
fun setRecyclerViewProperties(recyclerView: RecyclerView?, data: List<Any>?) {
    val adapter = recyclerView?.adapter
    if (data == null) {
        return
    }
    @Suppress("UNCHECKED_CAST")
    when (adapter) {
        is WelcomeAdapter -> adapter.setData(data)
        is TeamAdapter -> adapter.setData(data as List<TeamModel>)
    }
}