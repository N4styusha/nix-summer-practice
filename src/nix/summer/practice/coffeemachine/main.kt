package nix.summer.practice.coffeemachine

enum class Coffee(val water: Int, val milk: Int, val coffeeBeans: Int, val disposableCups: Int, val money: Int) {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6)
}

class CoffeeMachine {
    var water: Int = 400
    var milk: Int = 540
    var coffeeBeans: Int = 120
    var disposableCups: Int = 9
    var money: Int = 550

    fun menu() {
        println("Write action (buy, fill, take, remaining, exit):")
        var choice = readln()
        when(choice) {
            "buy" -> chooseCofee()
            "fill" -> fillCoffeeMachine()
            "take" -> takeMoney()
            "remaining" -> remaining()
            "exit" -> return
        }
    }

    fun remaining() {
        val rawString = """
            The coffee machine has:
            $water of water
            $milk of milk
            $coffeeBeans of coffee beans
            $disposableCups of disposable cups
            $money of money
        """.trimIndent()
        println(rawString)
        menu()
    }

    fun fillCoffeeMachine() {
        println("Write how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        coffeeBeans += readln().toInt()
        println("Write how many disposable coffee cups you want to add:")
        disposableCups += readln().toInt()
        menu()
    }

    fun takeMoney() {
        println("I gave you $money\n")
        money = 0
        menu()
    }

    fun chooseCofee() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:")
        var choice = readln()
        when(choice) {
            "1" ->  buyCoffee(Coffee.ESPRESSO)
            "2" ->  buyCoffee(Coffee.LATTE)
            "3" ->  buyCoffee(Coffee.CAPPUCCINO)
        }
    }

    fun buyCoffee(TYPE: Coffee) {
        val error = "I have enough resources, making you a coffee!"
        if (water >= TYPE.water && milk >= TYPE.milk && coffeeBeans >= TYPE.coffeeBeans && disposableCups > 0) {
            water -= TYPE.water
            milk -= TYPE.milk
            coffeeBeans -= TYPE.coffeeBeans
            disposableCups -= TYPE.disposableCups
            money += TYPE.money
        } else {
            println(error)
        }
        menu()
    }
}

fun main() {
    var coffeeMachine = CoffeeMachine()
    coffeeMachine.menu()
}
