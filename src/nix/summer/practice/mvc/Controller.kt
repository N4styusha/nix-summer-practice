package nix.summer.practice.mvc

/**
 * @author Anastasiia Rybalka
 * @file Controller.kt
 */

/**
 * Controller class helps the Model class to work with View interface
 * @param model - main object to work with
 * @param Model - main class we work with
 */
class Controller(private var model: Model) {
    private lateinit var view: View

    /**
     * Public function attachView()
     * @param attachView - public function to initialize view
     */
    fun attachView(_view: View) {
        view = _view
    }

    /**
     * Public function chooseCoffee()
     * @param chooseCoffee - public function that helps to interact between model and user order
     * @param order - keeps information about the type of coffee the user has chosen
     * @return conveys the type of coffee
     */
    fun chooseCoffee(order: Order): Response {
        return model.chooseCoffee(order)
    }

    /**
     * Public function chooseCoffee()
     * @param takeMoney - public function that helps to interact between model and user order
     * @return conveys the count of money
     */
    fun takeMoney(): Response {
        return model.takeMoney()
    }

    /**
     * Public function chooseCoffee()
     * @param remaining - public function that helps to interact between model and user
     * @return conveys the count of resources in coffee machine
     */
    fun remaining(): Response {
        return Response(model.remaining())
    }

    /**
     * Public function chooseCoffee()
     * @param fillAll - public function that helps to interact between model and user
     * @return conveys the count of resources that we would like to add in coffee machine
     */
    fun fillAll(resources: Resources): Response {
        return model.fillCoffeeMachine(resources)
    }
}
