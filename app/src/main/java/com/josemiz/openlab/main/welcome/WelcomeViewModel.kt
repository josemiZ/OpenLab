package com.josemiz.openlab.main.welcome

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josemiz.openlab.R
import com.josemiz.openlab.model.WelcomeHeaderModel
import com.josemiz.openlab.model.WelcomeModel

class WelcomeViewModel : ViewModel() {

    private val itemList: MutableLiveData<List<Any>> = MutableLiveData()

    val getItemList: LiveData<List<Any>>
        get() = itemList


    fun setupList(context: Context?) {
        if (context == null) {
            return
        }
        val list = listOf(
            WelcomeHeaderModel(
                context.getString(R.string.txt_welcome),
                context.getString(R.string.txt_welcome_to_open_lab_description)
            ),
            WelcomeModel(
                context.getString(R.string.txt_open_lab_mission),
                context.getString(R.string.txt_open_lab_mission_description)
            ),
            WelcomeModel(
                context.getString(R.string.txt_open_lab_vision),
                context.getString(R.string.txt_open_lab_vision_description)
            ),
            WelcomeModel(
                context.getString(R.string.txt_open_lab_collaborative_approach),
                context.getString(R.string.txt_open_lab_collaborative_approach_description)
            )
        )
        itemList.value = list
    }

}