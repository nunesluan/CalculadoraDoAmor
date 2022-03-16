package model

import java.util.*

class RandomNumber {

    fun generateRandomNumber(): Int {
        val random = Random()
        return random.nextInt(100)

    }


}