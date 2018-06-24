package com.kotlinrobots.seesaw

import lejos.hardware.motor.EV3LargeRegulatedMotor
import lejos.hardware.port.MotorPort

fun main(args: Array<String>) {

    val motorA = EV3LargeRegulatedMotor(MotorPort.A)
    val motorD = EV3LargeRegulatedMotor(MotorPort.D)

    for (i in 1..10) {
        Thread.sleep(1000)
        motorA.rotate(30 )
        motorA.rotate(-30 )
        Thread.sleep(1000)
        motorD.rotate(30 )
        motorD.rotate(-30 )
    }
}