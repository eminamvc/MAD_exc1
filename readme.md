# MAD - Exercise 01
## Tasks
* Watch the Kotlin Crashcourse Video in Moodle or complete the tutorials **[Introduction to programming in Kotlin](https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-1)** and **[Kotlin fundamentals](https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-1
)**.
* Answer the questions inside this Readme.md file and push it to your repository.
* Submit your coding solution of the Number Guessing Game inside the repository.
* Submit the link to your repository in Moodle.

## Questions
### Describe how Kotlin handles null safety. What are nullable types and non-null types in Kotlin? (0,5 points)
<span style="color:blue">Provide your answer here! </span>
> Note: you can also use code snippets to illustrate your answer.
```kotlin 
// example code snippet
val a: String = "value" // non-null type
```
Kotlin has a zero-safety system, as this is a problem with other programming languages. 
In Kotlin, all variable types are non-nullable by default and would lead to 
a compilation error if you try to assign a null value. If you declare a variable as a string, 
it can only contain string values, but not null.

But there are nullable types: variable types in Kotlin that can hold a null value.
They are identified by adding a question mark (?) after the type name. 
Example: String? --> can contain either a string value or null.

There are several ways to deal with nullable types.
First way: '?.' --> is used to safely call methods or properties of a nullable object. 
If the object is null, the call is ignored and null is returned.

Second way: '?:' --> is used to provide a default value if an expression returns null.

Third way: '!!' --> to trigger a null pointer exception if the variable is null after all. 

Through these techniques, Kotlin helps us to clearly distinguish between nullable and non-nullable types 
and promotes a safer handling of null.

### What are lambda expressions and higher order functions in Kotlin? Why would you store a function inside a variable? (0,5 points)
<span style="color:blue">Provide your answer here!</span>

By using lambda expressions and higher order functions, Kotlin code can be made more compact, readable and flexible.

Lambda Expressions: They are anonymous functions that can be used to define blocks of code that can be executed later. 
They make it possible to write functions briefly and clearly without having to name them.
Example: val sumOfAll = { x: Int, y: Int -> x + y }
The lambda expression is enclosed in curly brackets and may have parameters that are listed by an arrow ->.

Higher order functions: take other functions as parameters or return them as results. 
These are particularly useful in Kotlin because they allow you to be very expressive and flexible with functions.
Example: fun compute(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
return operation(a, b)
}

Functions inside a variable:You can reuse the same function in different parts of the program without having to rewrite the code. 
By saving a function in a variable, you can pass functions as parameters to other functions, which can be useful when using higher order functions. 
In addition, you can delay the execution of a function by saving it in a variable and calling it later, which is useful in situations where you need the result of an operation at a later time.

### Provide a solution for the following number guessing game inside `App.kt`. (3 points)

## Number Guessing Game in Kotlin
The game is a simple number guessing game. The task is to generate a random, max 9-digit, number. The number must **not contain repeating digits**. Valid digits are 1-9.
Ask the user to guess the max 9-digit number. The game is finished when the user guesses the correct digits in the correct order.
In each round, the user gets feedback about the number of correct digits and the number of correct digits in the correct position.
The output should be in the format "n:m", where "n" is the number of digits guessed correctly regardless of their position, 
and "m" is the number of digits guessed correctly at their correct position. Here are some examples:

This example shows the game flow with 4-digits to guess (the default argument)

Generated number: 8576
-	User input: 1234, Output: 0:0
-	User input: 5678, Output: 4:1
-	User input: 5555, Output: 1:1
-	User input: 3586, Output: 3:2
-	User input: 8576, Output: 4:4 -> user wins

Take a look into the provided code structure in `src/main/kotlin/App.kt`. Implement the following methods (lambda expressions):
- _playNumberGame(digitsToGuess: Int = 4)_ (1 point): The main game loop that handles user input and game state. Make use of _generateRandomNonRepeatingNumber_ and _checkUserInputAgainstGeneratedNumber_ here. This function also utilizes a default argument 
- _generateRandomNonRepeatingNumber_ (1 point): A lambda expression that generates a random number with non-repeating digits of a specified length.
- _checkUserInputAgainstGeneratedNumber_ (1 point): A lambda expression that compares the user's input against the generated number and provides feedback.

``CompareResult.kt`` This class is a data structure which helps with bundling the result of the comparison of the user input and the generated number. Look at the toSting() and use it in your output.

Run the project with `./gradlew run` and test your implementation with the provided tests in `src/test/kotlin/AppTest.kt` with `./gradlew test`.

# Project Structure
The project is structured into two main Kotlin files:

**App.kt**: Contains the main game logic and functions.

**AppTest.kt**: Contains unit tests for the various functions in App.kt.

