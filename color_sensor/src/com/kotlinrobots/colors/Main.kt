package com.kotlinrobots.colors

import lejos.hardware.BrickFinder
import lejos.hardware.port.SensorPort
import lejos.hardware.sensor.EV3ColorSensor
import lejos.robotics.Color

fun EV3ColorSensor.getColorName(): String {
    val colorIDMode = this.colorIDMode
    var sample = FloatArray(colorIDMode.sampleSize())
    colorIDMode.fetchSample(sample, 0)

    return when (sample.get(0).toInt()) {
        Color.GREEN -> "GREEN"
        Color.BLUE -> "BLUE"
        Color.YELLOW -> "YELLOW"
        Color.MAGENTA -> "MAGENTA"
        Color.ORANGE -> "ORANGE"
        Color.WHITE -> "WHITE"
        Color.BLACK -> "BLACK"
        Color.PINK -> "PINK"
        Color.GRAY -> "GRAY"
        Color.LIGHT_GRAY -> "LIGHT_GRAY"
        Color.DARK_GRAY -> "DARK_GRAY"
        Color.CYAN -> "CYAN"
        Color.BROWN -> "BROWN"
        Color.NONE -> "NONE"
        else -> "OTHER"
    }
}

fun main(args: Array<String>) {
    var colorSensor = EV3ColorSensor(SensorPort.S1)
    BrickFinder.getLocal().keys.waitForAnyPress()

    println("Color: ${colorSensor.getColorName()}")

    BrickFinder.getLocal().keys.waitForAnyPress()
}