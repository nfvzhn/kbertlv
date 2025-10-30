package com.nfvzhn.kbertlv

class ApplicationId(v: Long) : TlvNumeric(v) {
    override val tag = 0xDF8041
    override val maxSize = 12
}

class Sequence(v: Long) : TlvNumeric(v) {
    override val tag = 0xDF805D
    override val maxSize = 2
}

class NumberOfRecords(v: Long) : TlvNumeric(v) {
    override val tag = 0xDF807E
    override val maxSize = 12
    override val paddingToMaxSize = true
}

class RecordNumber(v: Long) : TlvNumeric(v) {
    override val tag = 0xDF8001
    override val maxSize = 12
    override val paddingToMaxSize = true
}

class PrimaryFlag(v: Long) : TlvNumeric(v) {
    override val tag = 0xDF803A
    override val maxSize = 1
}

class CorporateCode(v: Long) : TlvNumeric(v) {
    override val tag = 0xDF8005
    override val maxSize = 8
    override val paddingToMaxSize = true
}

class PersonProcessingMode(v: Long) : TlvNumeric(v) {
    override val tag = 0xDF8108
    override val maxSize = 1
}

class AddressProcessingMode(v: Long) : TlvNumeric(v) {
    override val tag = 0xDF8108
    override val maxSize = 1
}

class PostalCode(v: Long) : TlvNumeric(v) {
    override val tag = 0xDF8026
    override val maxSize = 12
}
