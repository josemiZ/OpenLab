package com.josemiz.openlab.main.team

import com.josemiz.openlab.BR
import com.josemiz.openlab.R
import com.josemiz.openlab.base.BaseViewModelFragment
import com.josemiz.openlab.databinding.FragmentTeamBinding

class TeamFragment : BaseViewModelFragment<TeamViewModel, FragmentTeamBinding>() {
    override fun getLayout(): Int = R.layout.fragment_team

    override fun setup() {
        dataBinding.rvTeam.adapter = TeamAdapter()
    }

    override fun bindViewModel(): Int? = BR.viewModel

    override fun setupObservers() {
        viewModel.setupList(context)
    }
}