package com.example.krymov.views;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemRecyclerView extends RecyclerView.ItemDecoration  {
    private Drawable dividerItem;
    private int orentationItem;

    public DividerItemRecyclerView(Drawable divider) {
        dividerItem = divider;
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        if (orentationItem == LinearLayoutManager.HORIZONTAL) {
            drawHorizontalDividers(canvas, parent);
        } else if (orentationItem == LinearLayoutManager.VERTICAL) {
            drawVerticalDividers(canvas, parent);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getChildAdapterPosition(view) == 0) {
            return;
        }

        orentationItem = ((LinearLayoutManager) parent.getLayoutManager()).getOrientation();
        if (orentationItem == LinearLayoutManager.HORIZONTAL) {
            outRect.left = dividerItem.getIntrinsicWidth();
        } else if (orentationItem == LinearLayoutManager.VERTICAL) {
            outRect.top = dividerItem.getIntrinsicHeight();
        }
    }

    private void drawHorizontalDividers(Canvas canvas, RecyclerView parent) {
        int parentTop = parent.getPaddingTop();
        int parentBottom = parent.getHeight() - parent.getPaddingBottom();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int parentLeft = child.getRight() + params.rightMargin;
            int parentRight = parentLeft + dividerItem.getIntrinsicWidth();

            dividerItem.setBounds(parentLeft, parentTop, parentRight, parentBottom);
            dividerItem.draw(canvas);
        }
    }

    private void drawVerticalDividers(Canvas canvas, RecyclerView parent) {
        int parentLeft = parent.getPaddingTop() * 9;
        int parentRight = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int parentTop = child.getBottom() + params.bottomMargin;
            int parentBottom = parentTop + dividerItem.getIntrinsicHeight();

            dividerItem.setBounds(parentLeft, parentTop, parentRight, parentBottom);
            dividerItem.draw(canvas);
        }
    }
}
