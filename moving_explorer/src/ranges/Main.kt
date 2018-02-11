package ranges

import lejos.hardware.motor.EV3LargeRegulatedMotor
import lejos.hardware.port.MotorPort
import lejos.utility.Stopwatch

fun main(args: Array<String>) {

    val motorA = EV3LargeRegulatedMotor(MotorPort.A)
    val motorD = EV3LargeRegulatedMotor(MotorPort.D)
    val watch = Stopwatch()

    motorA.speed = 360 // 1 RPM
    motorD.speed = 360 // 1 RPM

    watch.reset()

    while (watch.elapsed() < 10000) {
        println("Milliseconds : ${watch.elapsed()}")

        when (watch.elapsed()) {
            in 3000..5000, in 7000..9000 -> {
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