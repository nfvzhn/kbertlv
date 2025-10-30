package com.nfvzhn.kbertlv

interface TlvMarshallable {

    fun marshall(sequenceNumberSupplier: () -> Int = { 1 }): String
}
