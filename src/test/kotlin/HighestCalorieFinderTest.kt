import java.nio.file.Files
import java.util.ResourceBundle
import kotlin.io.path.Path
import kotlin.test.Test
import kotlin.test.assertEquals

internal class HighestCalorieFinderTest {

    @Test
    fun canFindTheHighestOfOneElf(): Unit {
        val highestTotal = HighestCalorieFinder().highest("1")
        assertEquals(1, highestTotal)
    }

    @Test
    fun canFindTheHighestOfTwoElves(): Unit {
        val highestTotal = HighestCalorieFinder().highest("1\n\n10")
        assertEquals(10, highestTotal)
    }

    @Test
    fun theActualHighestCalorieAmount(): Unit {
        val input = Files.readAllLines(Path("src/test/resources/elfCalories" +
                ".txt"))
            .joinToString("\n")
        val highestTotal = HighestCalorieFinder().highest(input)
        assertEquals(66487, highestTotal)
    }

    @Test
    fun canFindTheTotalOfTheTopThreeElves(): Unit {
        val highestTotal = HighestCalorieFinder().topThreeTotal("1\n\n10\n\n20")
        assertEquals(31, highestTotal)
    }

    @Test
    fun theActualTotalOfThreeHighestCalorieAmounts(): Unit {
        val input = Files.readAllLines(Path("src/test/resources/elfCalories" +
                ".txt"))
            .joinToString("\n")
        val highestTotal = HighestCalorieFinder().topThreeTotal(input)
        assertEquals(197301, highestTotal)
    }
}
