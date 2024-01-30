import kotlin.random.Random

fun main() {
    var randomNumber = Random.nextInt(1, 11)

    while(true) {
        println("Guess the number from 1-10!")
        val guess = readln().toIntOrNull()

        if(guess == null) {
            println("Guess must be a number.")

        } else if(guess == randomNumber) {
            println("Your guess is correct!")

            while(true) {
                print("Continue? (Y/n)")
                val choice = readln().lowercase()
                
                if(choice == "n") {
                    return
                } else if(choice == "y" || choice == "") {
                    randomNumber = Random.nextInt(1, 11)
                    break
                } else {
                    println("invalid input")
                    continue
                }
            }
        } else if(guess < randomNumber) {
            println("Your guess is lower.")

        } else {
            println("Your guess is higher.")
        }
    }
}