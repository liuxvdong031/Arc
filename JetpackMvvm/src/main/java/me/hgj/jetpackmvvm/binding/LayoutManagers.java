package me.hgj.jetpackmvvm.binding;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * A collection of factories to create RecyclerView LayoutManagers so that you can easily set them
 * in your layout.
 */
public class LayoutManagers {
    protected LayoutManagers() {
    }

    public interface LayoutManagerFactory {
        RecyclerView.LayoutManager create(RecyclerView recyclerView);
    }

    /**
     * A {@link LinearLayoutManager}.
     */
    public static LayoutManagerFactory linear() {
        return recyclerView -> new LinearLayoutManager(recyclerView.getContext());
    }

    public static LayoutManagerFactory linear(int orientation, boolean canScroll) {
        if (0 == orientation) {
            return recyclerView -> new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL,false) {
                @Override
                public boolean canScrollHorizontally() {
                    return canScroll;
                }
            };
        } else {
            return recyclerView -> new LinearLayoutManager(recyclerView.getContext(),LinearLayoutManager.VERTICAL,false) {
                @Override
                public boolean canScrollVertically() {
                    return canScroll;
                }
            };
        }
    }

    /**
     * A {@link GridLayoutManager} with the given spanCount.
     */
    public static LayoutManagerFactory grid(final int spanCount) {
        return new LayoutManagerFactory() {
            @Override
            public RecyclerView.LayoutManager create(RecyclerView recyclerView) {
                return new GridLayoutManager(recyclerView.getContext(), spanCount);
            }
        };
    }

    /**
     * A {@link GridLayoutManager} with the given spanCount, orientation and reverseLayout.
     **/
    public static LayoutManagerFactory grid(final int spanCount, @Orientation final int orientation, final boolean reverseLayout) {
        return new LayoutManagerFactory() {
            @Override
            public RecyclerView.LayoutManager create(RecyclerView recyclerView) {
                return new GridLayoutManager(recyclerView.getContext(), spanCount, orientation, reverseLayout);
            }
        };
    }

    /**
     * A {@link StaggeredGridLayoutManager} with the given spanCount and orientation.
     */
    public static LayoutManagerFactory staggeredGrid(final int spanCount, @Orientation final int orientation) {
        return new LayoutManagerFactory() {
            @Override
            public RecyclerView.LayoutManager create(RecyclerView recyclerView) {
                return new StaggeredGridLayoutManager(spanCount, orientation);
            }
        };
    }

    /**
     * A {@link StaggeredGridLayoutManager} with the given spanCount and orientation.
     */
    public static LayoutManagerFactory staggeredGrid(final int spanCount, @Orientation final int orientation,boolean canScroller) {
        return new LayoutManagerFactory() {
            @Override
            public RecyclerView.LayoutManager create(RecyclerView recyclerView) {
                return new StaggeredGridLayoutManager(spanCount, orientation){
                    @Override
                    public boolean canScrollVertically() {
                        return canScroller;
                    }
                };
            }
        };
    }
    public static LayoutManagerFactory grid(final int spanCount,final boolean canScroller) {
        return new LayoutManagerFactory() {
            @Override
            public RecyclerView.LayoutManager create(RecyclerView recyclerView) {
                return new GridLayoutManager(recyclerView.getContext(), spanCount){
                    @Override
                    public boolean canScrollVertically() {
                        return canScroller;
                    }
                };
            }
        };
    }

    @IntDef({LinearLayoutManager.HORIZONTAL, LinearLayoutManager.VERTICAL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation { }
}