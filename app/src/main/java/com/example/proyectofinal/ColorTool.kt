package com.example.proyectofinal

import android.graphics.Color
import kotlin.math.abs


/**
 * A class with methods to help with colors.
 * (Only one method so far.)
 *
 */
class ColorTool {
    /**
     * Return true if the two colors are a pretty good match.
     * To be a good match, all three color values (RGB) must be within the tolerance value given.
     *
     * @param color1 int
     * @param color2 int
     * @param tolerance int - the max difference that is allowed for any of the RGB components
     * @return boolean
     */
    fun closeMatch(color1: Int, color2: Int, tolerance: Int): Boolean {
        if (abs(Color.red(color1) - Color.red(color2)) > tolerance) return false
        if (abs(Color.green(color1) - Color.green(color2)) > tolerance) return false
        return abs(Color.blue(color1) - Color.blue(color2)) <= tolerance
    } // end match
} // end class

