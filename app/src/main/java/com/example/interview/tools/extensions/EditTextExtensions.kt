package com.example.interview.tools.extensions

import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import com.google.android.material.textfield.TextInputEditText

//just handle IME_ACTION_DONE and IME_ACTION_SEARCH
fun TextInputEditText.enterKey(enterAction: () -> Unit) {
    setOnEditorActionListener { _, actionID, _ ->
        if (actionID == EditorInfo.IME_ACTION_DONE || actionID == EditorInfo.IME_ACTION_SEARCH) {
            enterAction()
        }
        false
    }
    setOnKeyListener { _, _, keyEvent ->
        if (keyEvent.action == KeyEvent.ACTION_DOWN && (keyEvent.keyCode == KeyEvent.KEYCODE_ENTER || keyEvent.keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER)) {
            enterAction()
            true
        } else false
    }
}

fun TextInputEditText.afterTextChangeListener(
    afterTextChangedAction: () -> Unit
) {
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(
            charSequence: CharSequence,
            i: Int,
            i1: Int,
            i2: Int
        ) {
        }

        override fun onTextChanged(
            charSequence: CharSequence,
            i: Int,
            i1: Int,
            i2: Int
        ) {
        }

        override fun afterTextChanged(editable: Editable) = afterTextChangedAction()
    })
}