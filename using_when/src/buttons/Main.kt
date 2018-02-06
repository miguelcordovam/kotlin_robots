package buttons

import lejos.hardware.Button

fun main(args: Array<String>) {

    println("Showing keys: ")

    for (i in 1..10) {
        val key = Button.waitForAnyPress()

        when (key) {
            Button.ID_UP -> println("UP")
            Button.ID_ENTER -> println("OK")
            Button.ID_DOWN -> println("DOWN")
            Button.ID_RIGHT -> println("RIGHT")
            Button.ID_LEFT -> println("LEFT")
            Button.ID_ESCAPE -> println("ESCAPE")
            else -> println("UNKNOWN")
        }
    }
}