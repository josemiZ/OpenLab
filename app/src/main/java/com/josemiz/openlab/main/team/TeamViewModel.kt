package com.josemiz.openlab.main.team

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josemiz.openlab.R
import com.josemiz.openlab.model.TeamModel

class TeamViewModel : ViewModel() {

    private val itemList: MutableLiveData<List<TeamModel>> = MutableLiveData()

    val getItemList: LiveData<List<TeamModel>>
        get() = itemList

    fun setupList(context: Context?) {
        if (context == null) {
            return
        }
        val list: ArrayList<TeamModel> = ArrayList()
        val names = context.resources.getStringArray(R.array.team_member_names)
        val descriptions = context.resources.getStringArray(R.array.team_member_descriptions)
        for (x in names.indices) {
            list.add(TeamModel(names[x], descriptions[x]))
        }
        itemList.value = list
    }

}