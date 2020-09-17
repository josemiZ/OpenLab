package com.josemiz.openlab.main.team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.josemiz.openlab.R
import com.josemiz.openlab.base.BaseAdapter
import com.josemiz.openlab.databinding.ItemTeamBinding
import com.josemiz.openlab.model.TeamModel

class TeamAdapter : BaseAdapter<TeamAdapter.TeamViewHolder, TeamModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = DataBindingUtil.inflate<ItemTeamBinding>(
            inflater,
            R.layout.item_team, parent, false
        )
        return TeamViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    class TeamViewHolder(
        private val item: ItemTeamBinding
    ) : RecyclerView.ViewHolder(item.root) {
        fun bind(model: TeamModel) = with(item) {
            this.model = model
            executePendingBindings()
        }
    }

}