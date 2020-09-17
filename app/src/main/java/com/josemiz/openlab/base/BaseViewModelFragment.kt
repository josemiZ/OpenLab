package com.josemiz.openlab.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import org.koin.androidx.scope.currentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

abstract class BaseViewModelFragment<V : ViewModel, T : ViewDataBinding>() :
    BaseDataBindingFragment<T>() {
    //If the build fails, check the current actual types (possibly the argument must be change to 1 because of the data binding)
    protected val viewModel: V by currentScope.viewModel(this, viewModelClass())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()?.let {
            dataBinding.setVariable(it, viewModel)
        }
        viewModelClass()
        setupObservers()
    }

    //We use this as a hack that checks the actual parameters of the child class
    @Suppress("UNCHECKED_CAST")
    private fun viewModelClass(): KClass<V> {
        return ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[ARGUMENT] as Class<V>).kotlin
    }

    abstract fun bindViewModel(): Int?
    abstract fun setupObservers()

    companion object {
        private const val ARGUMENT = 0
    }

}