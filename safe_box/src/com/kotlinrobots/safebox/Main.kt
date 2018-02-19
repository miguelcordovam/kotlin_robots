package com.kotlinrobots.safebox

import lejos.hardware.BrickFinder
import lejos.hardware.Sound
import lejos.hardware.motor.EV3LargeRegulatedMotor
import lejos.hardware.port.MotorPort
import lejos.hardware.port.SensorPort
import lejos.hardware.sensor.EV3ColorSensor
import lejos.robotics.Color

fun main(args: Array<String>) {
    val motorA = EV3LargeRegulatedMotor(MotorPort.A)
    val colorSensor = EV3ColorSensor(SensorPort.S1)

    var valid = 0
    val password = listOf(Color.RED, Color.WHITE, Color.RED)

    println("Please enter your password: ")
    for (i in 0..2) {
        BrickFinder.getLocal().keys.waitForAnyPress()
        if (colorSensor.readColorId() == password[i]) {
            valid++
        } else {
            break;
        }
    }

    if (valid == 3) {
        motorA.speed = 360
        motorA.rotate(-100)
        println("Your password is OK!")
    } else {
        println("Your password is wrong.")
        Sound.buzz()
    }

    motorA.close()
    colorSensor.close()

    println("Press any key to exit...")
    BrickFinder.getLocal().keys.waitForAnyPress()
}