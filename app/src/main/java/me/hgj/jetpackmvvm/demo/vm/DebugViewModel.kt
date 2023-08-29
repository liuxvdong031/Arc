package me.hgj.jetpackmvvm.demo.vm

import android.view.View
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * Created by xvDong on 2023/8/25.
 */
class DebugViewModel: BaseViewModel() {

    fun onClick(view:View){
        finishActivity()
    }
}