package me.hgj.jetpackmvvm.base.viewmodel

/**
 * Created by xvDong on 2023/8/24.
 */
open class MultiItemViewModel<VM : BaseViewModel> : ItemViewModel<VM> {

    companion object {
        const val TYPE_HEAD = 0
        const val TYPE_ITEM = 1
        const val TYPE_EMPTY = 2
        const val TYPE_FOOT = 3
    }

    var itemType: Int = TYPE_ITEM

    constructor(viewModel: VM) : super(viewModel)

    constructor(viewModel: VM, index: Int) : this(viewModel) {

    }
}