package com.kotlinrobots.extensionprops

import lejos.hardware.motor.EV3LargeRegulatedMotor
import lejos.utility.Stopwatch

fun Stopwatch.elapsedSecondsIsLessThan(seconds: Int): Boolean = this.elapsedSeconds() < seconds
fun Stopwatch.elapsedSeconds(): Int = this.elapsed() / 1000

var EV3LargeRegulatedMotor.speedInRPM : Int
    get() = speed / 360
    set(speed: Int) {
        this.speed = 360 * speed
    }
