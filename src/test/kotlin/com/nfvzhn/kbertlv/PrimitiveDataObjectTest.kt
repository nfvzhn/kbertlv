package com.nfvzhn.kbertlv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource

class PrimitiveDataObjectTest {

    @Nested
    inner class TlvNumericTest {

        @Test
        fun `When create numeric tag with value of N chars, Then tag length() should return N`() {
            assertEquals(5, ApplicationId(12345).length)
        }

        @Test
        fun `When numeric tag length overflow, Then throw IllegalArgumentException`() {
            val seq = Sequence(12345)
            val e = assertThrows<IllegalArgumentException> { seq.marshall() }
            assertEquals("Maximum value size=2 has been exceeded: Sequence<0xdf805d=12345>", e.message)
        }

        @ParameterizedTest
        @ArgumentsSource(TlvNumericTestArgumentProvider::class)
        fun `Marshalling tests`(case: TlvNumericTestCase) {
            assertEquals(case.expected, case.tlv.marshall())
        }
    }
}
