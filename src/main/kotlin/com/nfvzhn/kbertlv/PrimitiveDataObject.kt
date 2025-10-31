package com.nfvzhn.kbertlv

abstract class PrimitiveDataObject<T>() : TlvDataObject<T>, TlvMarshallable, TlvValid {

    abstract val maxSize: Int

    open val paddingToMaxSize = false

    override val length: Int
        get() = valuePadding(value).length

    override fun validate() {
        require(length <= maxSize)
        { "Maximum value size=$maxSize has been exceeded: $this" }
    }

    override fun marshall(sequenceNumberSupplier: () -> Int): String {
        validate()
        val t = tag.toString(16).uppercase()
        val l: String = lengthPadding(length)
        val v = valuePadding(value)
        return t + l + v
    }

    override fun toString() = "${this.javaClass.simpleName}<0x${"%x".format(tag)}=$value>"

    private fun valuePadding(v: T): String {
        val strValue = v.toString()
        val paddedValue = if (paddingToMaxSize) {
            strValue.padStart(maxSize, '0')
        } else strValue
        return paddedValue.uppercase()
    }

    private fun lengthPadding(l: Int): String {
        val lengthPadding: Int = if (length shr 7 == 0) 2 else 4
        val s = l.toString(16).uppercase()
        return s.padStart(lengthPadding, padChar = '0')
    }
}
