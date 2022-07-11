package nix.summer.practice.chatbot
import java.util.Scanner

fun main() {
    println("1-st stage\n")
    firstStage()
    println("\n2-nd stage\n")
    secondStage()
    println("\n3-rd stage\n")
    thirdStage()
    println("\n4-th stage\n")
    fourthStage()
    println("\n5-th stage\n")
    fifthStage()
}

fun firstStage() {
    val bot_name = "ChatBot"
    val year_of_creating = 2022
    println("Hello! My name is $bot_name. I was created in $year_of_creating")
}

fun secondStage() {
    val bot_name = "ChatBot"
    val year_of_creating = 2022
    println("Hello! My name is $bot_name.\nI was created in $year_of_creating.\nPlease, remind me your name.")
    val your_name = readLine()
    println("What a great name you have, $your_name!")
}

fun thirdStage() {
    val scanner = Scanner(System.`in`)
    val bot_name = "ChatBot"
    val year_of_creating = 2022
    println("Hello! My name is $bot_name.\nI was created in $year_of_creating.\nPlease, remind me your name.")
    val your_name = readLine()
    println("What a great name you have, $your_name!\nLet me guess your age.\nEnter remainders of dividing your age by 3, 5 and 7.")
    val remainder3 = scanner.nextLine().toInt()
    val remainder5 = scanner.nextLine().toInt()
    val remainder7 = scanner.nextLine().toInt()
    val age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
    val your_age = age
    println("Your age is $your_age; that's a good time to start programming!")
}

fun fourthStage () {
    val scanner = Scanner(System.`in`)
    println("I will prove to you that I can count to any number you want:")
    val number = scanner.nextLine().toInt()
    var count = 0
    while(count < number) {
        println("${++count}!")
    }
}

fun fifthStage() {
    println("Welcome to testing!\nAnswer the questions correctly to get high scores!\n")
    firstQuestion()
}

fun firstQuestion() {
    val scanner = Scanner(System.`in`)
    println("Who is the creator of the kotlin programming language?\n1 - Bjarne Stroustrup;\n2 - Elon Mask;\n3 - JetBrains;\n4 - Steve Jobs.")
    val answer = scanner.nextLine().toInt();
    when (answer) {
        1, 2, 4 -> {
            println("Please, try again.\n")
            firstQuestion ()
        }
        3 -> {
            println("Great, you right!\n")
            secondQuestion()
        }
    }
}

fun secondQuestion() {
    val scanner = Scanner(System.`in`)
    println("What year was the Kotlin programming language created?\n1 - 2011;\n2 - 2007;\n3 - 2018;\n4 - 1999.")
    val answer = scanner.nextLine().toInt()
    when (answer) {
        1 -> {
            println("Great, you right!\n")
            thirdQuestion()
        }
        2, 3, 4 -> {
            println("Please, try again.\n")
            secondQuestion()
        }
    }
}

fun thirdQuestion() {
    val scanner = Scanner(System.`in`)
    println("What is the Kotlin programming language named after?\n1 - City;\n2 - Country;\n3 - River;\n4 - Island.");
    val answer = scanner.nextLine().toInt()
    when (answer) {
        1, 2, 3 -> {
            println("Please, try again.\n")
            thirdQuestion()
        }
        4 -> {
            println("Great, you right!\nGoodbye, have a nice day!")
            return
        }
    }
}