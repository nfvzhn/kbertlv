package com.nfvzhn.kbertlv

import kotlin.text.padStart

abstract class TlvNumeric(override val value: Long) : PrimitiveDataObject<Long>() {

    override val paddingToMaxSize = false

    override val length: Int
        get() = valuePadding(value).length

    override fun marshall(sequenceNumberSupplier: () -> Int): String {
        validate()
        val t = tag.toString(16).uppercase()
        val l: String = lengthPadding(length)
        val v = valuePadding(value)
        return t + l + v
    }

    private fun lengthPadding(l: Int): String {
        val lengthPadding: Int = if (length shr 7 == 0) 2 else 4
        val s = l.toString(16).uppercase()
        return s.padStart(lengthPadding, padChar = '0')
    }

    private fun valuePadding(v: Long): String {
        val s = v.toString().uppercase()
        return if (paddingToMaxSize) {
            s.padStart(maxSize, '0')
        } else s
    }
}
