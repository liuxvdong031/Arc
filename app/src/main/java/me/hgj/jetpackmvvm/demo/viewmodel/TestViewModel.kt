package me.hgj.jetpackmvvm.demo.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.blankj.utilcode.util.ToastUtils
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.base.viewmodel.MultiItemViewModel
import me.hgj.jetpackmvvm.demo.BR
import me.hgj.jetpackmvvm.demo.R
import me.hgj.jetpackmvvm.demo.bean.TestBean
import me.tatarka.bindingcollectionadapter2.ItemBinding

/**
 * Created by xvDong on 2023/8/24.
 */
class TestViewModel : BaseViewModel() {

    fun onClick(bean: TestBean) {
        ToastUtils.showShort("点击了${bean.url}")
    }

    var errorDetailsList: ObservableList<ItemTestViewModel> =
        ObservableArrayList()

    var errorDetailsBinding: ItemBinding<ItemTestViewModel> =
        ItemBinding.of(BR.viewModel, R.layout.item_todo)

    val error: ItemBinding<MultiItemViewModel<BaseViewModel>> =
        ItemBinding.of { itemBinding, position, item ->
            run {
                when (item.itemType) {
                    MultiItemViewModel.TYPE_ITEM -> {
                        itemBinding.set(
                            BR.viewModel,
                            R.layout.item_text
                        )
                    }

                    MultiItemViewModel.TYPE_HEAD -> {
                        itemBinding.set(
                            BR.viewModel,
                            R.layout.item_todo
                        )
                    }

                    else -> {
                    }
                }
            }
        }

    init {
        addItemTest()
    }

    fun addItemTest() {
        for (i in 1..10) {
            val viewModel = ItemTestViewModel(this)
            if (i % 2 == 0) {
                viewModel.itemType = MultiItemViewModel.TYPE_ITEM
            } else {
                viewModel.itemType = MultiItemViewModel.TYPE_HEAD
            }
            errorDetailsList.add(viewModel)
        }

    }
}