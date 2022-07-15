package nix.summer.practice.mvc

/**
 * @author Anastasiia Rybalka
 * @file Model.kt
 */
/**
 * enum class describes the count of resources we need to make a definite type of coffee
 */
enum class Coffee(val water: Int, val milk: Int, val coffeeBeans: Int, val disposableCups: Int, val money: Int) {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6)
}

data class Response(var responseString: String)

data class Order(var coffeeType: String)

data class Resources(var haveWater: Int, var haveMilk: Int, var haveCoffeeBeans: Int, var haveDisposableCups: Int)

/**
 * Model class - the main class with components and method we work with
 */
class Model(
    private var water: Int = 400,
    private var milk: Int = 540,
    private var coffeeBeans: Int = 120,
    private var disposableCups: Int = 9,
    private var money: Int = 550
) {
    /**
     * Public function remaining gives us information about resources in coffee machine
     * @return information about the condition of coffee machine
     */

    fun remaining(): String {
        return "The coffee machine has:\n" +
                "$water ml of water \n" +
                "$milk ml of milk \n" +
                "$coffeeBeans of coffee beans \n" +
                "$disposableCups of disposable cups \n" +
                "$money of money"
    }


    /**
     * Public function that defines the type of coffee for next checking
     * @param coffee - type of coffee that was chosen by user
     * @return information about ordered coffee
     */
    fun chooseCoffee(coffee: Order): Response {
        val choice = when (coffee.coffeeType) {
            "Espresso" -> {
                checkResources(Coffee.ESPRESSO)
                remaining()
            }
            "Latte" -> {
                checkResources(Coffee.LATTE)
                remaining()
            }
            else -> {
                checkResources(Coffee.CAPPUCCINO)
                remaining()
            }
        }
        return Response(choice)
    }


    /**
     * Private function that checks if there are enough resources in the coffee machine to create a certain type of coffee
     * @param error - store the string with error message
     * @param coffee - store information about the type of coffee
     * @return information about resources or error message
     */
    private fun checkResources(coffee: Coffee): String {
        val error = "I have enough resources to make you a coffee!"
        if (water >= coffee.water && milk >= coffee.milk && coffeeBeans >= coffee.coffeeBeans && disposableCups > 0) {
            buyCoffee(coffee)
            return ("I have enough resources to make you a coffee!\n")
        } else {
            return error
        }
    }

    /**
     * Private function that reduces the value of resources in coffee machine depending on definite type of coffee
     * @param water - count of water in coffee machine
     * @param milk - count of milk in coffee machine
     * @param coffeeBeans - count of coffee beans in coffee machine
     * @param disponsableCups - count of disponsable cups in coffee machine
     * @param money - count of money in coffee machine
     */
    private fun buyCoffee(type: Coffee) {
        water -= type.water
        milk -= type.milk
        coffeeBeans -= type.coffeeBeans
        disposableCups -= type.disposableCups
        money += type.money
    }

    /**
     * Public function that give us possibility to add resources to coffee machine
     * @param haveWather - count of definite resource we add to coffee machine
     * @param haveMilk - count of definite resource we add to coffee machine
     * @param haveCoffeeBeans - count of definite resource we add to coffee machine
     * @param haveDisponsibleCups - count of definite resource we add to coffee machine
     * @return information about resources in coffee machine
     */
    fun fillCoffeeMachine(resources: Resources): Response {
        water += resources.haveWater.toInt()
        milk += resources.haveMilk.toInt()
        coffeeBeans += resources.haveCoffeeBeans.toInt()
        disposableCups += resources.haveDisposableCups.toInt()

        return Response(remaining())
    }

    /**
     * Public function that define the count of money that we take from coffee machine
     * @param moneyNow - stores the amount of money we have taken
     * @return information about the amout of money we have taken
     */
    fun takeMoney(): Response {
        val moneyNow = money
        money = 0
        return Response("I gave you $moneyNow\n")
    }
}