package me.hgj.jetpackmvvm.binding.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.TouchDelegate;
import android.view.View;

import com.blankj.utilcode.util.ClickUtils;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import me.hgj.jetpackmvvm.binding.command.BindingCommand;


public class ViewAdapter {
    //防重复点击间隔(秒)
    public static final long CLICK_INTERVAL = 2000;
    //level代表该view 嵌套层级  1 或者 2
    public static void expandClickArea(@NonNull final View view, final int expandSize, final int level) {
        expandClickArea(view, expandSize, expandSize, expandSize, expandSize,level);
    }

    public static void expandClickArea(@NonNull final View view,
                                       final int expandSizeTop,
                                       final int expandSizeLeft,
                                       final int expandSizeRight,
                                       final int expandSizeBottom,
                                       final  int level) {
        final View parentView = level==1?(View) view.getParent():(View) view.getParent().getParent();
        if (parentView == null) {
            Log.e("ClickUtils", "expandClickArea must have parent view.");
            return;
        }
        parentView.post(() -> {
            final Rect rect = new Rect();
            view.getHitRect(rect);
            rect.top -= expandSizeTop;
            rect.bottom += expandSizeBottom;
            rect.left -= expandSizeLeft;
            rect.right += expandSizeRight;
            parentView.setTouchDelegate(new TouchDelegate(rect, view));
        });
    }


    /**
     * requireAll 是意思是是否需要绑定全部参数, false为否
     * View的onClick事件绑定
     * onClickCommand 绑定的命令,
     * isThrottleFirst 是否开启防止过快点击
     */
    @BindingAdapter(value = {"onClickCommand"}, requireAll = false)
    public static void onClickCommand(View view, final BindingCommand bindingCommand) {
        ClickUtils.applySingleDebouncing(view,CLICK_INTERVAL,click -> {
            if (bindingCommand != null) {
                bindingCommand.execute();
            }
        });
    }


    /**
     * 回调控件本身
     *
     * @param currentView
     * @param bindingCommand
     */
    @BindingAdapter(value = {"onClickCommandView"}, requireAll = false)
    public static void onClickCommandView(View currentView, BindingCommand bindingCommand) {
        ClickUtils.applySingleDebouncing(currentView,CLICK_INTERVAL,clickView -> {
            if (bindingCommand != null) {
                bindingCommand.execute(clickView);
            }
        });
    }

    @BindingAdapter(value = {"currentView"}, requireAll = false)
    public static void replyCurrentView(View currentView, BindingCommand bindingCommand) {
        if (bindingCommand != null) {
            bindingCommand.execute(currentView);
        }
    }
    /**
     * view是否需要获取焦点
     */
    @BindingAdapter({"requestFocus"})
    public static void requestFocusCommand(View view, final Boolean needRequestFocus) {
        if (needRequestFocus) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        } else {
            view.clearFocus();
        }
    }

    /**
     * view的焦点发生变化的事件绑定
     */
    @BindingAdapter({"onFocusChangeCommand"})
    public static void onFocusChangeCommand(View view, final BindingCommand<Boolean> onFocusChangeCommand) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (onFocusChangeCommand != null) {
                    onFocusChangeCommand.execute(hasFocus);
                }
            }
        });
    }

    /**
     * view的显示隐藏
     */
    @BindingAdapter(value = {"isVisible"}, requireAll = false)
    public static void isVisible(View view, final Boolean visibility) {
        if (visibility) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }
}
