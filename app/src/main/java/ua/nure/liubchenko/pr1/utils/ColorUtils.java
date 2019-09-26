package ua.nure.liubchenko.pr1.utils;

import java.util.stream.Stream;

public class ColorUtils {

    public static Integer[] decomposeColor(Integer color) {
        return new Integer[] {
            color >> 24 & 0xff,
            color >> 16 & 0xff,
            color >> 8  & 0xff,
            color       & 0xff
        };
    }

    public static Integer composeColor(Integer alpha,
                                       Integer red,
                                       Integer green,
                                       Integer blue) {
        return Stream.of(
                (alpha & 0xff) << 24,
                (red   & 0xff) << 16,
                (green & 0xff) << 8,
                (blue  & 0xff)
        ).reduce(Integer::sum).get();
    }
}
