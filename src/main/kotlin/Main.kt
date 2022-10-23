//import kotlin.random.Random

fun play(highScores: MutableList<Int>) {
    var win = true
    val buttonOrder = mutableListOf<String>()
    val playerOrder = mutableListOf<String>()
    var level = 1

    while (win) {
        println("Simon Says...")
        for (i in 1..level) {
            if (i > buttonOrder.size) {
                val randomColor = (1..4).random()

                when (randomColor) {
                    1 -> buttonOrder.add("red")
                    2 -> buttonOrder.add("blue")
                    3 -> buttonOrder.add("yellow")
                    4 -> buttonOrder.add("green")
                }
            }
            println(buttonOrder[i - 1])
        }

        val str1 = buttonOrder.joinToString(",", "[", "]")
        println(str1)

        println("Your turn!")
        //get player's button order guess
        playerOrder.clear()
        for (i in 1..level) {
            val playerButton = readln()
            playerOrder.add(playerButton)
            println("added item $playerButton to index $i")
        }

        val str2 = playerOrder.joinToString(",", "[", "]")
        println(str2)

        //iterates through comp's button order and player's and compares to see if player wins level
        for (i in 1..level) {
            if (playerOrder[i-1] != buttonOrder[i-1]) {
                //println(playerOrder[i-1] + playerOrder[i-1])
                win = false
                val button1 = buttonOrder[i-1]
                val button2 = playerOrder[i-1]
                println("wrong bc $button1 is not $button2 at index $i")
                break
            }
        }

        //if player lost, game over
        if (!win) {
            println("Game Over! Lost at level: $level")
            highScores.add(level)
            highScores.sort()
            return
        }

        //otherwise, increase level
        level += 1
    }

}

fun main() {
    var playerMenuChoice = ""
    //list of high scores
    val highScores = mutableListOf(0)

    //menu and getting player choice
    println("Welcome to Memory Game!")
    println("1. Start")
    println("2. Exit")
    println("3. High Scores")
    playerMenuChoice = readln()

    when (playerMenuChoice) {
       "1" -> {
           println("Game Start!")
           play(highScores)
       }
        "2" -> println("Thank you for playing")
        "3" -> {
            println("High Scores")
            }
        }
    }
