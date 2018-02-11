package hellokotlin

import lejos.hardware.BrickFinder

fun main(args: Array<String>) {
    val LCD = BrickFinder.getLocal().textLCD
    LCD.clear()
    LCD.drawString("Hello Kotlin!", 3, 3)
    BrickFinder.getLocal().keys.waitForAnyPress()
}