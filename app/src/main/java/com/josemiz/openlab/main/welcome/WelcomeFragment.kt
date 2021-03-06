package com.josemiz.openlab.main.welcome

import android.content.Intent
import android.net.Uri
import com.josemiz.openlab.BR
import com.josemiz.openlab.R
import com.josemiz.openlab.base.BaseViewModelFragment
import com.josemiz.openlab.databinding.FragmentWelcomeBinding


class WelcomeFragment :
    BaseViewModelFragment<WelcomeViewModel, FragmentWelcomeBinding>() {
    override fun getLayout(): Int = R.layout.fragment_welcome

    override fun setup() {
        dataBinding.rvWelcome.adapter = WelcomeAdapter()
        dataBinding.fabContactUs.setOnClickListener {
            val url = "https://www.facebook.com/OpenLabPERU"
            Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }.also {
                startActivity(it)
            }
        }
    }

    override fun bindViewModel(): Int? = BR.viewModel

    override fun setupObservers() {
        viewModel.setupList(context)
    }
}