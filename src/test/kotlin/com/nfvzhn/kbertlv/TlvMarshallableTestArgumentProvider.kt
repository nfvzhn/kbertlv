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
            .map { Arguments.of(TlvMarshallableTestCase(it.first, it.second)) }
            .stream()
}

class TlvAlphaNumericTestArgumentProvider : ArgumentsProvider {
    override fun provideArguments(parameters: ParameterDeclarations, context: ExtensionContext): Stream<out Arguments> =
        listOf(
            FileType("FTYPIIA") to "DF807D07FTYPIIA",
            FileDate("16.10.2017_19:55:49") to "DF807C1316.10.2017_19:55:49",
            InstitutionNumber("0789") to "DF8079040789",
            AgentCode("000789") to "DF807A06000789",
            ApplicationType("BTRT01") to "DF800006BTRT01",
            ContractId("561119") to "DF800206561119",
            RejectCode("APRJ00") to "DF803D06APRJ00",
            ApplicationSource("MSRC0") to "DF803E05MSRC0",
            OfficerId("OFFICER_USER_ID1") to "DF803F10OFFICER_USER_ID1",
            ApplicationLetterScheme("1") to "DF8040011",
            CustomerId("F50000I2") to "DF800308F50000I2",
            CustomerId("1000001") to "DF80030801000001",
            NewCustomerDescription("ਨਵਾਂ ਗਾਹਕ ਵੇਰਵਾ") to "DF8004400000000000000000000000000000000000000000000000000ਨਵਾਂ ਗਾਹਕ ਵੇਰਵਾ",
            FirstName("Bogusław") to "DF801908BOGUSŁAW",
            SecondName("Əkbər") to "DF801A05ƏKBƏR",
            AddressLine1("Lalebahçe, Lalebahçe Cd. No:80, 42140 Meram/Konya") to "DF802031LALEBAHÇE, LALEBAHÇE CD. NO:80, 42140 MERAM/KONYA",
            )
            .map { Arguments.of(TlvMarshallableTestCase(it.first, it.second)) }
            .stream()
}

data class TlvMarshallableTestCase(val tlv: TlvMarshallable, val expected: String)
