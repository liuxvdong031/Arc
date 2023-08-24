package me.hgj.jetpackmvvm.base.viewmodel

/**
 * Created by xvDong on 2023/8/24.
 */
open class ItemViewModel<VM : BaseViewModel?>(viewModel: VM) {
    protected var viewModel: VM

    init {
        this.viewModel = viewModel
    }
}