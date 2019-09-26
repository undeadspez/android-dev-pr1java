package ua.nure.liubchenko.pr1

import org.junit.Test
import org.junit.Assert.*
import ua.nure.liubchenko.pr1.utils.ColorUtils

@Suppress("ConvertToStringTemplate", "ComplexRedundantLet", "SpellCheckingInspection")
class ColorUtilsUnitTest {

    companion object {
        const val CRIMSON = 0xdc143c
        const val AQUAMARINE = 8388564
    }

    @Test fun decomposition_isCorrect() {
        ColorUtils.decomposeColor(AQUAMARINE)
                .map { it.toString(16).padStart(2, '0') }
                .let { (_, r, g ,b) -> assertEquals("#7fffd4", "#" + r + g + b) }
    }

    @Test fun composition_isCorrect() {
        ColorUtils.composeColor(0xff, 0xdc, 0x14, 0x3c)
                .let { color -> assertEquals(CRIMSON, color and 0xffffff)}
    }

}
