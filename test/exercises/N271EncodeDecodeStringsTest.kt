package exercises

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*


class N271EncodeDecodeStringsTest {
    private var encoderDecoder: N271EncodeDecodeStrings? = null

    @Before
    fun setUp() {
        encoderDecoder = N271EncodeDecodeStrings()
    }

    @Test
    fun testEncodeDecode_emptyList() {
        val input: List<String> = mutableListOf()
        val encoded = encoderDecoder!!.encode(input)
        val decoded = encoderDecoder!!.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun testEncodeDecode_singleEmptyString() {
        val input: List<String> = mutableListOf("")
        val encoded = encoderDecoder!!.encode(input)
        val decoded = encoderDecoder!!.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun testEncodeDecode_singleNonEmptyString() {
        val input: List<String> = mutableListOf("hello")
        val encoded = encoderDecoder!!.encode(input)
        val decoded = encoderDecoder!!.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun testEncodeDecode_multipleStrings() {
        val input: List<String> = mutableListOf("hello", "world", "this", "is", "a", "test")
        val encoded = encoderDecoder!!.encode(input)
        val decoded = encoderDecoder!!.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun testEncodeDecode_stringsWithNumbers() {
        val input: List<String> = mutableListOf("123", "abc456", "789xyz")
        val encoded = encoderDecoder!!.encode(input)
        val decoded = encoderDecoder!!.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun testEncodeDecode_stringsWithSpecialCharacters() {
        val input: List<String> = mutableListOf("!@#$", "%^&*()", "~`_+=")
        val encoded = encoderDecoder!!.encode(input)
        val decoded = encoderDecoder!!.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun testEncodeDecode_longStrings() {
        val longString1 =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        val longString2 =
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
        val input = listOf(longString1, longString2)
        val encoded = encoderDecoder!!.encode(input)
        val decoded = encoderDecoder!!.decode(encoded)
        assertEquals(input, decoded)
    }

    // Edge case: strings that contain the '#' character
    @Test
    fun testEncodeDecode_stringsWithHashCharacter() {
        val input: List<String> = mutableListOf("string#with#hash", "another#one")
        val encoded = encoderDecoder!!.encode(input)
        val decoded = encoderDecoder!!.decode(encoded)
        assertEquals(input, decoded)
    }
}