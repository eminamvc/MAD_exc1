

package at.ac.fhcampuswien

import java.util.*

class App {
    fun playNumberGame(digitsToGuess: Int = 4) {

        //TODO: build a menu which calls the functions and works with the return values

        val randomNumber = generateRandomNonRepeatingNumber(digitsToGuess)
        var userGuess: Int
        var result: CompareResult

        do {
            println("Guess the $digitsToGuess-digit number:")
            userGuess = readln().toInt()
            result = checkUserInputAgainstGeneratedNumber(userGuess, randomNumber)
            println(result)
        } while (result.m != digitsToGuess)

        println("CONGRATS, you've guessed the correct number: $randomNumber")
    }

    val generateRandomNonRepeatingNumber: (Int) -> Int = { length ->

        //TODO implement the function

        require(length in 1..9) { "Choose Length please between 1 and 9" }
        val digits = (1..9).shuffled().take(length).joinToString("")
        digits.toInt()
    }

    val checkUserInputAgainstGeneratedNumber: (Int, Int) -> CompareResult = { input, generatedNumber ->

        //TODO implement the function

        val inputStr = input.toString()
        val generatedStr = generatedNumber.toString()

        require(inputStr.length == generatedStr.length) { "Input and generated number must have the same number of digits" }

        var correctPositions = 0
        var correctDigits = 0
        val seen = mutableSetOf<Char>()

        for (i in inputStr.indices) {
            if (inputStr[i] == generatedStr[i]) correctPositions++
            if (inputStr[i] in generatedStr && inputStr[i] !in seen) {
                correctDigits++
                seen.add(inputStr[i])
            }
        }

        CompareResult(correctDigits, correctPositions)
    }
}

fun main() {

    // TODO: call the App.playNumberGame function with and without default arguments

    val app = App()
    println("Welcome to the Number Guessing Game!")
    app.playNumberGame()
}