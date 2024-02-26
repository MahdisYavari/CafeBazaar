package com.example.interview.tools.utils

import java.text.DecimalFormat

object Formatter {
    fun formatAsMoney(value: Double): String {
        return DecimalFormat("###,###,###").format(value)
    }

    fun formatAsMoney(value: Int): String {
        return DecimalFormat("###,###,###").format(value)
    }
}
