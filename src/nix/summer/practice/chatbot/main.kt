package nix.summer.practice.chatbot
import java.util.Scanner

fun main() {
    println("Welcome to testing!\nAnswer the questions correctly to get high scores!\n");
    firstQuestion();
}
fun firstQuestion() {
    val scanner = Scanner(System.`in`)
    println("Who is the creator of the kotlin programming language?\n1 - Bjarne Stroustrup;\n2 - Elon Mask;\n3 - JetBrains;\n4 - Steve Jobs.");
    val answer = scanner.nextLine().toInt();
    when (answer) {
        1 -> {
            println("Please, try again.\n")
            firstQuestion ()
        }
        2 -> {
            println("Please, try again.\n")
            firstQuestion ()
        }
        3 -> {
            println("Great, you right!\n")
            secondQuestion()
        }
        4 -> {
            println("Please, try again.\n")
            firstQuestion ()
        }
    }
}
fun secondQuestion() {
    val scanner = Scanner(System.`in`)
    println("What year was the Kotlin programming language created?\n1 - 2011;\n2 - 2007;\n3 - 2018;\n4 - 1999.");
    val answer = scanner.nextLine().toInt();
    when (answer) {
        1 -> {
            println("Great, you right!\n")
            thirdQuestion()
        }
        2 -> {
            println("Please, try again.\n")
            secondQuestion()
        }
        3 -> {
            println("Please, try again.\n")
            secondQuestion()
        }
        4 -> {
            println("Please, try again.\n")
            secondQuestion()
        }
    }
}
fun thirdQuestion() {
    val scanner = Scanner(System.`in`)
    println("What is the Kotlin programming language named after?\n1 - City;\n2 - Country;\n3 - River;\n4 - Island.");
    val answer = scanner.nextLine().toInt();
    when (answer) {
        1 -> {
            println("Please, try again.\n")
            thirdQuestion ()
        }
        2 -> {
            println("Please, try again.\n")
            thirdQuestion ()
        }
        3 -> {
            println("Please, try again.\n")
            thirdQuestion()
        }
        4 -> {
            println("Great, you right!\nGoodbye, have a nice day!")
            return;
        }
    }
}
