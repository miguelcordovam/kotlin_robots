package com.kotlinrobots.spirograph

import lejos.hardware.motor.EV3LargeRegulatedMotor
import lejos.hardware.port.MotorPort
import lejos.utility.Delay

fun main(args: Array<String>) {

    val penMotor = EV3LargeRegulatedMotor(MotorPort.D)
    val tableMotor = EV3LargeRegulatedMotor(MotorPort.A)

    penMotor.speed = 750
    tableMotor.speed = 5

    tableMotor.forward()
    penMotor.forward()

    Delay.msDelay(80000)

    penMotor.close()
    tableMotor.close()
}