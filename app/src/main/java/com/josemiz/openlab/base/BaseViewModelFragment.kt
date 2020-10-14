package com.josemiz.openlab.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseViewModelFragment<V : ViewModel, T : ViewDataBinding> :
    BaseDataBindingFragment<T>() {
    //If the build fails, check the current actual types (possibly the argument must be change to 1 because of the data binding)
    protected var viewModel: V? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = if (viewModel == null) getViewModelScope() else viewModel
        bindViewModel()?.let {
            dataBinding.setVariable(it, viewModel)
        }
        setupObservers()
    }

    abstract fun getViewModelScope(): V
    abstract fun bindViewModel(): Int?
    abstract fun setupObservers()

}