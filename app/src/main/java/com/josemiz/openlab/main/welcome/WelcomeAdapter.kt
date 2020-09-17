package com.josemiz.openlab.main.welcome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.josemiz.openlab.R
import com.josemiz.openlab.base.BaseAdapter
import com.josemiz.openlab.databinding.ItemHeaderWelcomeBinding
import com.josemiz.openlab.databinding.ItemWelcomeBinding
import com.josemiz.openlab.model.WelcomeHeaderModel
import com.josemiz.openlab.model.WelcomeModel

class WelcomeAdapter : BaseAdapter<RecyclerView.ViewHolder, Any>() {

    override fun getItemViewType(position: Int): Int = when (list[position]) {
        is WelcomeModel -> NORMAL
        is WelcomeHeaderModel -> HEADER
        else -> OTHER
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        when (viewType) {
            HEADER -> {
                val itemBinding = DataBindingUtil.inflate<ItemHeaderWelcomeBinding>(
                    inflater,
                    R.layout.item_header_welcome,
                    parent,
                    false
                )
                return WelcomeHeaderViewHolder(itemBinding)
            }
            else -> {
                val itemBinding = DataBindingUtil.inflate<ItemWelcomeBinding>(
                    inflater,
                    R.layout.item_welcome,
                    parent,
                    false
                )
                return WelcomeViewHolder(itemBinding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            HEADER -> {
                val headerHolder = holder as WelcomeHeaderViewHolder
                val item = list[position] as WelcomeHeaderModel
                headerHolder.bind(item)
            }
            NORMAL -> {
                val contentHolder = holder as WelcomeViewHolder
                val item = list[position] as WelcomeModel
                contentHolder.bind(item)
            }
        }
    }

    class WelcomeViewHolder(
        private val item: ItemWelcomeBinding
    ) : RecyclerView.ViewHolder(item.root) {
        fun bind(model: WelcomeModel) {
            item.model = model
            item.executePendingBindings()
        }
    }

    class WelcomeHeaderViewHolder(
        private val item: ItemHeaderWelcomeBinding
    ) : RecyclerView.ViewHolder(item.root) {
        fun bind(model: WelcomeHeaderModel) {
            item.model = model
            item.executePendingBindings()
        }
    }

    companion object {
        private const val HEADER = 1
        private const val NORMAL = 2
        private const val OTHER = -1
    }
}