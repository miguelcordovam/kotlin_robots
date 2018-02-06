package buttons

import lejos.hardware.Button

fun main(args: Array<String>) {

    println("Showing keys: ")

    for (i in 1..10) {
        val key = Button.waitForAnyPress()

        when(key) {
            1 -> println ("UP")
            2 -> println ("OK")
            4 -> println ("DOWN")
            8 -> println ("RIGHT")
            16 -> println ("LEFT")
            32 -> println ("ESCAPE")
            else -> println("UNKNOWN")
        }

    }
}