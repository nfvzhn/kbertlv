package com.nfvzhn.kbertlv

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

class TlvNumericTestArgumentProvider : ArgumentsProvider {

    override fun provideArguments(parameters: ParameterDeclarations, context: ExtensionContext): Stream<out Arguments> =
        listOf(
            Sequence(0) to "DF805D010",
            Sequence(1) to "DF805D011",
            NumberOfRecords(3) to "DF807E0C000000000003",
            NumberOfRecords(999) to "DF807E0C000000000999",
            ApplicationId(470000032145) to "DF80410C470000032145",
            RecordNumber(2) to "DF80010C000000000002",
            RecordNumber(23456) to "DF80010C000000023456",
            PrimaryFlag(1) to "DF803A011",
            CorporateCode(49) to "DF80050800000049",
            PersonProcessingMode(1) to "DF8108011",
            AddressProcessingMode(1) to "DF8108011",
            PostalCode(230009) to "DF802606230009",
        )
            .map { Arguments.of(TlvNumericTestCase(it.first, it.second)) }
            .stream()
}

data class TlvNumericTestCase(val tlv: TlvNumeric, val expected: String)
