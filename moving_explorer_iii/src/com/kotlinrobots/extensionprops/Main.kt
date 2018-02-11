package com.kotlinrobots.extensionprops

import lejos.hardware.motor.EV3LargeRegulatedMotor
import lejos.hardware.port.MotorPort
import lejos.utility.Stopwatch

fun main(args: Array<String>) {

    val motorA = EV3LargeRegulatedMotor(MotorPort.A)
    val motorD = EV3LargeRegulatedMotor(MotorPort.D)
    val watch = Stopwatch()

    motorA.speedInRPM = 1
    motorD.speedInRPM = 1

    watch.reset()

    while (watch.elapsedSecondsIsLessThan(10)) {
        println("Seconds : ${watch.elapsedSeconds()}")

        when (watch.elapsedSeconds()) {
            in 3..5, in 7..9 -> {
                motorA.backward()
                motorD.backward()
            }
            else -> {
                motorA.forward()
                motorD.forward()
            }
        }
    }

    motorA.stop()
    motorD.stop()
}