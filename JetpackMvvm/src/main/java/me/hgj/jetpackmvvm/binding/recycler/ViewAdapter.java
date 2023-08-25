package me.hgj.jetpackmvvm.binding.recycler;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import me.hgj.jetpackmvvm.binding.LayoutManagers;
import me.hgj.jetpackmvvm.binding.LineManagers;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;


public class ViewAdapter {



    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, BindingRecyclerViewAdapter adapter) {
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("lineManager")
    public static void setLineManager(RecyclerView recyclerView, LineManagers.LineManagerFactory lineManagerFactory) {
        recyclerView.addItemDecoration(lineManagerFactory.create(recyclerView));
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView, LayoutManagers.LayoutManagerFactory layoutManagerFactory) {
        recyclerView.setLayoutManager(layoutManagerFactory.create(recyclerView));
    }


    @BindingAdapter("itemAnimator")
    public static void setItemAnimator(RecyclerView recyclerView, RecyclerView.ItemAnimator animator) {
        recyclerView.setItemAnimator(animator);
    }


    public static class ScrollDataWrapper {
        public float scrollX;
        public float scrollY;
        public int state;

        public ScrollDataWrapper(float scrollX, float scrollY, int state) {
            this.scrollX = scrollX;
            this.scrollY = scrollY;
            this.state = state;
        }
    }
}
