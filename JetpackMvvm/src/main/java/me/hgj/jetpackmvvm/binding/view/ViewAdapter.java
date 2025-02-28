package me.hgj.jetpackmvvm.binding.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.TouchDelegate;
import android.view.View;

import com.blankj.utilcode.util.ClickUtils;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;


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


    @BindingAdapter({"android:onClick"})
    public static void setOnClick(View view, final View.OnClickListener clickListener) {
        ClickUtils.applySingleDebouncing(view,CLICK_INTERVAL,clickListener);
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
