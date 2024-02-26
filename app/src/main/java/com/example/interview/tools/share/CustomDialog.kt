package com.example.interview.tools.share

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.viewbinding.ViewBinding

class CustomDialog<TView : ViewBinding>(
    private val context: Context,
    private val isShow: Boolean = true,
    // like : DialogCancelReceiptBinding.inflate(layoutInflater)
    private val inflateAction: () -> TView
) {

    lateinit var dialog: AlertDialog
    val binding = inflateAction()

    init {
        createDialog()
    }

    private fun createDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            .setView(binding.root)
        if (isShow) dialog = builder.show()
        else dialog = builder.create()
    }
}