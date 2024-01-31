import kotlin.random.Random

fun main() {
    var randomNumber = Random.nextInt(1, 11)
    var lives = 5

    while(true) {
        // check if lives is 0
        if(lives == 0) {
            println("Game over!")
            return
        }

        // prompt the user to guess
        println("($lives/5) Guess the number from 1-10!")
        val guess = readln().toIntOrNull()

        // check if guess is valid number
        if(guess == null) {
            println("Guess must be a number.")

        // check if guess is correct
        } else if(guess == randomNumber) {
            println("Your guess is correct!")

            // play again?
            while(true) {
                print("Continue? (Y/n)")
                val choice = readln().lowercase()
                
                if(choice == "n") {
                    return
                } else if(choice == "y" || choice == "") {
                    randomNumber = Random.nextInt(1, 11)
                    lives = 5
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