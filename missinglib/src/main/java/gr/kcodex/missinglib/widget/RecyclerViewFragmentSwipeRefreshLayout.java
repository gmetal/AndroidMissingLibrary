package gr.kcodex.missinglib.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Sub-class of {@link android.support.v4.widget.SwipeRefreshLayout} for use in this
 * {@link android.support.v4.app.ListFragment}. The reason that this is needed is because
 * {@link android.support.v4.widget.SwipeRefreshLayout} only supports a single child, which it
 * expects to be the one which triggers refreshes. In our case the layout's child is the content
 * view returned from
 * {@link android.support.v4.app.ListFragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)}
 * which is a {@link android.view.ViewGroup}.
 * <p>
 * <p>To enable 'swipe-to-refresh' support via the {@link android.widget.ListView} we need to
 * override the default behavior and properly signal when a gesture is possible. This is done by
 * overriding {@link #canChildScrollUp()}.
 */

public class RecyclerViewFragmentSwipeRefreshLayout extends SwipeRefreshLayout {
    private RecyclerView mRecyclerView;

    public RecyclerViewFragmentSwipeRefreshLayout(Context context, RecyclerView recyclerView) {
        super(context);
        mRecyclerView = recyclerView;
    }

    /**
     * As mentioned above, we need to override this method to properly signal when a
     * 'swipe-to-refresh' is possible.
     *
     * @return true if the {@link android.widget.ListView} is visible and can scroll up.
     */
    @Override
    public boolean canChildScrollUp() {
        if (mRecyclerView.getVisibility() == View.VISIBLE) {
            if (android.os.Build.VERSION.SDK_INT >= 14) {
                // For ICS and above we can call canScrollVertically() to determine this
                return ViewCompat.canScrollVertically(mRecyclerView, -1);
            } else {
                // Pre-ICS we need to manually check the first visible item and the child view's top
                // value
                RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {

                    return mRecyclerView.getChildCount() > 0 &&
                            (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() > 0
                                    || mRecyclerView.getChildAt(0).getTop() < mRecyclerView.getPaddingTop());
                } else if (layoutManager instanceof GridLayoutManager) {
                    return mRecyclerView.getChildCount() > 0 &&
                            (((GridLayoutManager) layoutManager).findFirstVisibleItemPosition() > 0
                                    || mRecyclerView.getChildAt(0).getTop() < mRecyclerView.getPaddingTop());

                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
