package com.example.listadapterexample

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecoration(val largePadding: Int, val smallPadding: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = smallPadding
        outRect.right = smallPadding
        outRect.top = largePadding
        outRect.bottom = largePadding
    }
}