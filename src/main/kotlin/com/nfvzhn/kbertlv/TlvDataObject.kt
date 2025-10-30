package com.nfvzhn.kbertlv

interface TlvDataObject<T> {

    val tag: Int

    val length: Int

    val value: T
}
