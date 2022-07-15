package nix.summer.practice.mvc

/**
 * @author Anastasiia Rybalka
 * @file TerminalView.kt
 */

import java.util.*

/**
 * TerminalView class - a class that displays information to the terminal and interacts with the user
 * @param controller - obgect we work with
 */
class TerminalView(private var controller: Controller) : View {

    val scanner = Scanner(System.`in`)

    private lateinit var answer: Response

    /**
     * Start function
     * @param info - initial message when the program start
     */
    override fun start(info: String) {
        println(info)
    }

    /**
     * Main function to interact between events
     */
    fun menu() {
        println("\nWrite action (buy, fill, take, remaining, exit):")

        var choice = scanner.nextLine()
        when (choice) {
            "buy" -> {
                println(choosePurchase(controller))
                menu()
            }
            "fill" -> {
                chooseFill(controller)
                menu()
            }
            "remaining" -> {
                val ans = controller.remaining()
                println(ans.responseString)
                menu()
            }
            "take" -> {
                val ans = controller.takeMoney()
                println(ans.responseString)
                menu()
            }
            "exit" -> return
        }
    }

    /**
     * Private function that helps user to choose what type of coffee user want
     * @param controller - give access to interact with controller
     * @return information about what type of coffee the user has chosen
     */
    private fun choosePurchase(controller: Controller): String {
        println("What do you want to buy?\n1 - espresso, 2 - latte, 3 - cappuccino.")
        val ans = readLine()

        val choice = when (ans) {
            "1" -> Order("Espresso")
            "2" -> Order("Latte")
            else -> Order("Cappuccino")
        }
        val info = controller.chooseCoffee(choice)
        return info.responseString
    }

    /**
     * Private function that asks user the count of resources he wants to add
     * @param controller - give access to interact with controller
     */
    private fun chooseFill(controller: Controller) {
        println("Write how many ml of water you want to add:")
        val haveWater = scanner.nextLine().toInt()
        println("Write how many ml of milk you want to add:")
        val haveMilk = scanner.nextLine().toInt()
        println("Write how many grams of coffee beans you want to add:")
        val haveCoffeeBeans = scanner.nextLine().toInt()
        println("Write how many disposable coffee cups you want to add:")
        val haveDisposableCups = scanner.nextLine().toInt()
        val choice = controller.fillAll(Resources(haveWater, haveMilk, haveCoffeeBeans, haveDisposableCups))
        println(choice.responseString)
    }
}