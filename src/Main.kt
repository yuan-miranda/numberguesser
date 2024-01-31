import kotlin.random.Random

fun main() {
    var numFrom = 1
    var numUntil = 10
    var randomNumber = Random.nextInt(numFrom, numUntil + 1)
    var lives = 5
    val levels = 5
    var currentLevel = 1

    while(true) {
        // check if lives is 0
        if(lives == 0) {
            println("Game over!")
            return
        }

        // prompt the user to guess
        println("($lives/${5 * currentLevel}) Guess the number from $numFrom-$numUntil!")
        val guess = readln().toIntOrNull()

        // check if guess is valid number
        if(guess == null) {
            println("Guess must be a number.")

        // check if guess is correct
        } else if(guess == randomNumber) {
            println("Your guess is correct!")
            currentLevel++
            
            // completed all levels
            if(currentLevel > levels) {
                println("You completed all the levels, congrats!")
                return
            }

            // play again?
            while(true) {
                print("Continue? (Y/n)")
                val choice = readln().lowercase()

                if(choice == "n") {
                    return
                } else if(choice == "y" || choice == "") {
                    numUntil += 10
                    randomNumber = Random.nextInt(numFrom, numUntil)
                    lives = 5*currentLevel
                    break
                } else {
                    println("invalid input")
                    continue
                }
            }

        // guess is lower
        } else if(guess < randomNumber) {
            println("Your guess is lower.")
            lives--

        // guess is higher
        } else {
            println("Your guess is higher.")
            lives--
        }
    }
}