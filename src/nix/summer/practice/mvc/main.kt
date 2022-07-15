package nix.summer.practice.mvc

/**
 * Main file with function that starts program
 *
 * @author Anastasiia Rybalka
 * @version 0.1
 * @date 15.07.2022
 *
 * @file main.kt
 */

fun main() {
    val model = Model()
    val controller = Controller(model)
    //val view = SwingView(controller)
    val view = TerminalView(controller)
    view.start("Hello! What would you like to buy?")
    view.menu()
    //controller.attachView(view)
    //view.showEventDemo()


}
