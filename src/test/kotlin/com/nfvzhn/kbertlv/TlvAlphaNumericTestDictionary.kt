package com.nfvzhn.kbertlv

class FileType(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF807D
    override val maxSize = 8
}

class FileDate(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF807C
    override val maxSize = 19
}

class InstitutionNumber(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF8079
    override val maxSize = 4
}

class AgentCode(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF807A
    override val maxSize = 12
}

class ApplicationType(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF8000
    override val maxSize = 8
}

class ContractId(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF8002
    override val maxSize = 6
}

class RejectCode(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF803D
    override val maxSize = 8
}

class ApplicationSource(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF803E
    override val maxSize = 8
}

class OfficerId(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF803F
    override val maxSize = 32
}

class ApplicationLetterScheme(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF8040
    override val maxSize = 3
}

class CustomerId(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF8003
    override val maxSize = 8
    override val paddingToMaxSize = true
}

class NewCustomerDescription(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF8004
    override val maxSize = 64
    override val paddingToMaxSize = true
}

class FirstName(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF8019
    override val maxSize = 32
}

class SecondName(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF801A
    override val maxSize = 32
}

class AddressLine1(v: String) : TlvAlphaNumeric(v) {
    override val tag = 0xDF8020
    override val maxSize = 64
}
