package com.kotlinrobots.sharpener

import lejos.hardware.BrickFinder
import lejos.hardware.Keys
import lejos.hardware.motor.EV3LargeRegulatedMotor
import lejos.hardware.port.MotorPort
import lejos.hardware.port.SensorPort
import lejos.hardware.sensor.EV3TouchSensor

fun EV3TouchSensor.isTouched(): Boolean {
    val touchMode = this.touchMode
    val sample = FloatArray(touchMode.sampleSize())
    touchMode.fetchSample(sample, 0)
    return sample[0].toInt() == 1
}

fun main(args: Array<String>) {
    val motorA = EV3LargeRegulatedMotor(MotorPort.A)
    val touchSensor = EV3TouchSensor(SensorPort.S4)

    println("Insert your pencil")

    while (BrickFinder.getLocal().keys.buttons != Keys.ID_ESCAPE) {
        if (touchSensor.isTouched()) {
            Thread.sleep(2000)
            motorA.speed = 1080
            motorA.rotate(360 * 5)
        }
    }

    motorA.close()
    touchSensor.close()
}