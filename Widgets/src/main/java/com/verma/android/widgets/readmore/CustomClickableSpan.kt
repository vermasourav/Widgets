package com.verma.android.widgets.readmore

import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View

class CustomClickableSpan(private val runnable: () -> Unit) : ClickableSpan() {

    override fun onClick(widget: View) {
        runnable()
    }

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.isUnderlineText = false
    }
}