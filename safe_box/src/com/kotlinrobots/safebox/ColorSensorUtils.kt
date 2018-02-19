package com.kotlinrobots.safebox

import lejos.hardware.sensor.EV3ColorSensor

fun EV3ColorSensor.readColorId(): Int {
    val colorIDMode = this.colorIDMode
    var sample = FloatArray(colorIDMode.sampleSize())
    colorIDMode.fetchSample(sample, 0)
    return sample.get(0).toInt();
}