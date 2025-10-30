package com.nfvzhn.kbertlv

abstract class PrimitiveDataObject<T>() : TlvDataObject<T>, TlvMarshallable, TlvValid {

    abstract val maxSize: Int

    abstract val paddingToMaxSize: Boolean

    override fun validate() {
        require(length <= maxSize)
        { "Maximum value size=$maxSize has been exceeded: $this" }
    }

    override fun toString() = "${this.javaClass.simpleName}<0x${"%x".format(tag)}=$value>"
}
