package nix.summer.practice.coffeemachine

class CoffeeMachine{
    var water: Int = 400
    var milk: Int = 540
    var coffeeBeans: Int = 120
    var disposableCups: Int = 9
    var money: Int = 550

    fun choose() {
        println("Write action (buy, fill, take, remaining, exit):")
        var choice = readln()
        when(choice) {
            "buy" -> buyCoffeeFromCoffeeMachine()
            "fill" -> fillCoffeeMachine()
            "take" -> takeMoneyFromCoffeeMachine()
            "remaining" -> remaining()
            "exit" -> return
        }
    }

    fun remaining() {
        println("The coffee machine has:\n$water of water\n$milk of milk\n$coffeeBeans of coffee beans\n$disposableCups of disposable cups\n$money of money\n")
        choose()
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
        choose()
    }

    fun takeMoneyFromCoffeeMachine() {
        println("I gave you $money\n")
        money = 0
        choose()
    }

    fun buyCoffeeFromCoffeeMachine() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:")
        var choice = readln()

        when(choice) {
            "1" -> {
                //espresso (250 water, 16 coffee beans + 4 hrn)
                if (water >= 250 && coffeeBeans >= 16 && disposableCups >= 1) {
                    water -= 250
                    coffeeBeans -= 16
                    disposableCups -= 1
                    money += 4
                } else {
                    println("I have enough resources, making you a coffee!")
                }
                choose()
            }
            "2" -> {
                //latte (350 water, 75 milk, 20 coffee beans + 7 hrn)
                if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && disposableCups >= 1) {
                    water -= 350
                    milk -= 75
                    coffeeBeans -= 20
                    disposableCups -= 1
                    money += 7
                } else {
                    println("I have enough resources, making you a coffee!")
                }
                choose()
            }
            "3" -> {
                //cappuccino (200 water, 100 milk, 12 coffee beans + 6 hrn)
                if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && disposableCups >= 1) {
                    water -= 200
                    milk -= 100
                    coffeeBeans -= 12
                    disposableCups -= 1
                    money += 6
                } else {
                    println("I have enough resources, making you a coffee!")
                }
                choose()
            }
            "back" -> choose()
        }
    }
}

fun main() {
    //firstStage()
    //secondStage()
    //thirdStage()
    //fourthStage()
    fifthStage()
}

fun fifthStage() {
    var coffeeMachine = CoffeeMachine()
    coffeeMachine.choose()
}


fun firstStage() {
    val rawString = """
        Starting to make a coffee in NIX office
        Grinding coffee beans
        Boiling water
        Mixing boiled water with crushed coffee beans
        Pouring coffee into the cup
        Pouring some milk into the cup
        Coffee is ready! Go to work!
    """.trimIndent()
    println(rawString)
}

fun secondStage() {
    println("Write how many cups of coffee you will need:")
    val numberOfCups = readln().toInt()
    println("For $numberOfCups cups of coffee you will need:\n" +
            "${numberOfCups * 200} ml of water\n" +
            "${numberOfCups * 50} ml of milk\n" +
            "${numberOfCups * 15} g of coffee beans")
}

fun thirdStage() {
     println("Write how many ml of water the coffee machine has:")
    val  water = readln().toInt()
    println("Write how many ml of milk the coffee machine has:")
    val  milk = readln().toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val  coffeeBeans = readln().toInt()
    println("Write how many cups of coffee you will need:")
    val numberOfCups = readln().toInt()

    val enoughWaterFor = water / 200
    val enoughMilkFor = milk / 50
    val enoughBeansFor = coffeeBeans / 15
    var i = 0

    while (i < enoughWaterFor && i < enoughMilkFor && i < enoughBeansFor) {
        i++
    }
    if (i == numberOfCups) {
        println("Yes, I can make that amount of coffee")
    } else if (i > numberOfCups) {
        println("Yes, I can make that amount of coffee (and even ${i - numberOfCups} more than that)")
    } else {
        println("No, I can make only $i cups of coffee")
    }
}

fun fourthStage() {
    var water = 400
    var milk = 540
    var coffeeBeans = 120
    var disposableCups = 9
    var money = 550
    printStatusOfCoffeeMachine(water, milk, coffeeBeans, disposableCups, money)
    println("Write action (buy, fill, take):")
    val choice = readln()
    when (choice) {
        "buy" -> buyCoffee(water, milk, coffeeBeans, disposableCups, money)
        "fill" -> fillCoffeeMachine(water, milk, coffeeBeans, disposableCups, money)
        "take" -> takeMoney(water, milk, coffeeBeans, disposableCups, money)
    }

}

fun printStatusOfCoffeeMachine(water: Int, milk: Int, coffeeBeans: Int, disposableCups: Int, money: Int) {
    println("The coffee machine has:\n$water of water\n$milk of milk\n$coffeeBeans of coffee beans\n$disposableCups of disposable cups\n$money of money\n")
}

fun buyCoffee(water: Int, milk: Int, coffeeBeans: Int, disposableCups: Int, money: Int) {
    var waterAfter = water
    var milkAfter = milk
    var coffeeBeansAfter = coffeeBeans
    var disposableCupsAfter = disposableCups
    var moneyAfter = money
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    var choice = readln().toInt()

    when(choice) {
        1 -> {
            //espresso (250 water, 16 coffee beans + 4 hrn)
            waterAfter -= 250
            coffeeBeansAfter -= 16
            disposableCupsAfter -= 1
            moneyAfter += 4

        }
        2 -> {
            //latte (350 water, 75 milk, 20 coffee beans + 7 hrn)
            waterAfter -= 350
            milkAfter -= 75
            coffeeBeansAfter -= 20
            disposableCupsAfter -= 1
            moneyAfter += 7
        }
        3 -> {
            //cappuccino (200 water, 100 milk, 12 coffee beans + 6 hrn)
            waterAfter -= 200
            milkAfter -= 100
            coffeeBeansAfter -= 12
            disposableCupsAfter -= 1
            moneyAfter += 6
        }
    }
    printStatusOfCoffeeMachine(waterAfter, milkAfter, coffeeBeansAfter, disposableCupsAfter, moneyAfter)
}

fun fillCoffeeMachine(water: Int, milk: Int, coffeeBeans: Int, disposableCups: Int, money: Int) {

    println("Write how many ml of water you want to add:")
    var waterAfter = water + readln().toInt()
    println("Write how many ml of milk you want to add:")
    var milkAfter = milk + readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    var coffeeBeansAfter = coffeeBeans + readln().toInt()
    println("Write how many disposable coffee cups you want to add:")
    var disposableCupsAfter = disposableCups + readln().toInt()
    var moneyAfter = money
    printStatusOfCoffeeMachine(waterAfter, milkAfter, coffeeBeansAfter, disposableCupsAfter, moneyAfter)
}

fun takeMoney(water: Int, milk: Int, coffeeBeans: Int, disposableCups: Int, money: Int) {
    var moneyAfter = money
    println("I gave you $money\n")
    moneyAfter = 0
    printStatusOfCoffeeMachine(water, milk, coffeeBeans, disposableCups, moneyAfter)
}

