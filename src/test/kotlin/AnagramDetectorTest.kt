import com.ashrapov.AnagramDetector
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AnagramDetectorTest {

    @Test
    fun shouldPassForValidAnagram() {
        val detector = AnagramDetector(HashMap())
        val first = "i am an anagram"
        val second = shuffleString(first)
        val result = detector.isAnagram(first, second)
        assertTrue(result, "'$first' and '$second' should be recognized as anagrams!")
    }

    @Test
    fun shouldFailIfNotAnagram() {
        val detector = AnagramDetector(HashMap())
        val first = "i am not an anagram"
        val second = "me neither"
        val result = detector.isAnagram(first, second)
        assertFalse(result, "'$first' and '$second' are NOT anagrams!")
    }

    @Test
    fun shouldReturnAllAnagramsExceptItself() {
        val detector = AnagramDetector(HashMap())
        val first = "1234"
        val generatedAnagrams: MutableSet<String> = HashSet()

        for (i in 1..3){
            val second = shuffleString(first)
            generatedAnagrams.add(second)

            assertTrue(detector.isAnagram(first, second), "'$first' and '$second' were not recognized as anagrams")
        }

        val expectedCount = generatedAnagrams.size

        for(input in generatedAnagrams) {
            val storedAnagrams = detector.getAllAnagrams(input)

            assertEquals(storedAnagrams.size, expectedCount, "'$storedAnagrams' should have '$expectedCount' entries")
            assertFalse(storedAnagrams.contains(input), "'$storedAnagrams' should not contain '$input' as anagram")
        }
    }

    private fun shuffleString(input: String): String{
        val chars = input.toMutableList()
        chars.shuffle(Random())

        return chars.joinToString("")
    }
}