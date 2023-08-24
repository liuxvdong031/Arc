package me.hgj.jetpackmvvm.binding;

import android.graphics.Color;

import com.blankj.utilcode.util.SizeUtils;

import androidx.recyclerview.widget.RecyclerView;


public class LineManagers {
    protected LineManagers() {
    }

    public interface LineManagerFactory {
        RecyclerView.ItemDecoration create(RecyclerView recyclerView);
    }


    public static LineManagerFactory both() {
        return recyclerView -> new DividerLine(recyclerView.getContext(), DividerLine.LineDrawMode.BOTH);
    }

    public static LineManagerFactory horizontal(double height) {
        return recyclerView -> getItemDecoration(recyclerView, height);
    }


    public static LineManagerFactory horizontal(double height, String color) {
        return recyclerView -> getItemDecoration(recyclerView, height, color);
    }


    public static LineManagerFactory vertical(double height) {
        return recyclerView -> getItemDecoration(recyclerView, height);
    }

    public static LineManagerFactory vertical(double height, String color) {
        return recyclerView -> getItemDecoration(recyclerView, height, color,1);
    }


    private static RecyclerView.ItemDecoration getItemDecoration(RecyclerView recyclerView, double height) {
        RecyclerView.ItemDecoration itemDecoration = null;
        if (recyclerView.getItemDecorationCount() > 0) {
            itemDecoration = recyclerView.getItemDecorationAt(0);
            if (itemDecoration == null) {
                itemDecoration = new RecycleViewDivider(recyclerView.getContext(), 0, SizeUtils.dp2px((float) height), Color.WHITE);
                recyclerView.addItemDecoration(itemDecoration);
            }
        } else {
            itemDecoration = new RecycleViewDivider(recyclerView.getContext(), 0, SizeUtils.dp2px((float) height), Color.WHITE);
            recyclerView.addItemDecoration(itemDecoration);
        }
        return itemDecoration;
    }

    private static RecyclerView.ItemDecoration getItemDecoration(RecyclerView recyclerView, double height, String color) {
        RecyclerView.ItemDecoration itemDecoration = null;
        if (recyclerView.getItemDecorationCount() > 0) {
            itemDecoration = recyclerView.getItemDecorationAt(0);
            if (itemDecoration == null) {
                itemDecoration = new RecycleViewDivider(recyclerView.getContext(), 0, SizeUtils.dp2px((float) height), Color.parseColor(color));
                recyclerView.addItemDecoration(itemDecoration);
            }
        } else {
            itemDecoration = new RecycleViewDivider(recyclerView.getContext(), 0, SizeUtils.dp2px((float) height), Color.parseColor(color));
            recyclerView.addItemDecoration(itemDecoration);
        }
        return itemDecoration;
    }


    private static RecyclerView.ItemDecoration getItemDecoration(RecyclerView recyclerView, double height, String color,int  index) {
        RecyclerView.ItemDecoration itemDecoration = null;
        if (recyclerView.getItemDecorationCount() > 0) {
            itemDecoration = recyclerView.getItemDecorationAt(0);
            if (itemDecoration == null) {
                itemDecoration = new RecycleViewDivider(recyclerView.getContext(), 1, SizeUtils.dp2px((float) height), Color.parseColor(color));
                recyclerView.addItemDecoration(itemDecoration);
            }
        } else {
            itemDecoration = new RecycleViewDivider(recyclerView.getContext(), 1, SizeUtils.dp2px((float) height), Color.parseColor(color));
            recyclerView.addItemDecoration(itemDecoration);
        }
        return itemDecoration;
    }

}
