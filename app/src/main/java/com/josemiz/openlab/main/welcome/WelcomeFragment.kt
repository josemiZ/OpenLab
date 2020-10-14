package com.josemiz.openlab.main.welcome

import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.josemiz.openlab.BR
import com.josemiz.openlab.R
import com.josemiz.openlab.base.BaseViewModelFragment
import com.josemiz.openlab.databinding.FragmentWelcomeBinding
import org.koin.androidx.scope.currentScope


class WelcomeFragment :
    BaseViewModelFragment<WelcomeViewModel, FragmentWelcomeBinding>() {
    override fun getLayout(): Int = R.layout.fragment_welcome

    override fun setup() {
        dataBinding.rvWelcome.adapter = WelcomeAdapter()
        dataBinding.rvWelcome.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                when {
                    dy > 0 && dataBinding.fabContactUs.isShown -> {
                        // Scroll Down
                        dataBinding.fabContactUs.hide()
                    }
                    dy < 0 && !dataBinding.fabContactUs.isShown -> {
                        // Scroll Up
                        dataBinding.fabContactUs.show()
                    }
                }
            }
        })
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

    override fun setupObservers() = with(viewModel!!) {
        setupList(context)
    }

    override fun getViewModelScope(): WelcomeViewModel {
        return currentScope.get()
    }
}