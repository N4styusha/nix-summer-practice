package nix.summer.practice.mvc

/**
 * @author Anastasiia Rybalka
 * @file SwingView.kt
 */

import java.awt.FlowLayout
import java.awt.GridLayout
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.*

/**
 * SwingView - class for work with swingUI lib
 */
class SwingView(private var controller: Controller) : View {
    private lateinit var mainFrame: JFrame
    private lateinit var statusLabel: JLabel
    private lateinit var orderPanel: JPanel
    private lateinit var fillPanel: JPanel
    private lateinit var takeMoneyPanel: JPanel

    init {
        createUI()
    }

    /**
     * Private function that creates the main window
     */
    private fun createUI() {
        statusLabel = JLabel("", JLabel.CENTER)

        orderPanel = JPanel().apply { layout = FlowLayout() }
        fillPanel = JPanel().apply { layout = FlowLayout() }
        takeMoneyPanel = JPanel().apply { layout = FlowLayout() }

        mainFrame = JFrame("COFFEE MACHINE").apply {
            setSize(1000, 400)
            layout = GridLayout(4, 1)
            addWindowListener(object : WindowAdapter() {
                override fun windowClosing(windowEvent: WindowEvent?) {
                    System.exit(0)
                }
            })
            add(statusLabel)
            add(orderPanel)
            add(fillPanel)
            add(takeMoneyPanel)
            isVisible = true
        }
    }

    /**
     * Private function that adds elements to choose type of coffee
     */
    private fun orderPanel() {
        val espressoButton = JButton("Espresso").apply {
            addActionListener {
                val typeOfCoffee = Order("Espresso")
                val choice = controller.chooseCoffee(typeOfCoffee)
                statusLabel.text = choice.responseString
            }
        }
        val latteButton = JButton("Latte").apply {
            addActionListener {
                val typeOfCoffee = Order("Latte")
                val choice = controller.chooseCoffee(typeOfCoffee)
                statusLabel.text = choice.responseString
            }
        }
        val cappuccinoButton = JButton("Cappuccino").apply {
            addActionListener {
                val typeOfCoffee = Order("Cappuccino")
                val choice = controller.chooseCoffee(typeOfCoffee)
                statusLabel.text = choice.responseString
            }
        }
        orderPanel.add(espressoButton)
        orderPanel.add(latteButton)
        orderPanel.add(cappuccinoButton)
    }

    /**
     * Private function that adds elements to fill the coffee machine
     */
    private fun createFillPanel() {
        val waterLabel = JLabel("Water:", JLabel.LEFT).apply {
            setSize(300, 100)
        }
        fillPanel.add(waterLabel)

        val waterField = JTextField("0", 6)
        fillPanel.add(waterField)

        val milkLabel = JLabel("Milk:", JLabel.LEFT).apply {
            setSize(300, 100)
        }
        fillPanel.add(milkLabel)

        val milkField = JTextField("0", 6)
        fillPanel.add(milkField)

        val coffeeBeansLabel = JLabel("Coffee beans:", JLabel.LEFT).apply {
            setSize(300, 100)
        }
        fillPanel.add(coffeeBeansLabel)

        val coffeeBeansField = JTextField("0", 6)
        fillPanel.add(coffeeBeansField)

        val cupLabel = JLabel("Cups:", JLabel.LEFT).apply {
            setSize(300, 100)
        }
        fillPanel.add(cupLabel)

        val disposableCups = JTextField("0", 6)

        fillPanel.add(disposableCups)

        val fillButton = JButton("Fill me").apply {
            addActionListener {
                val resources = Resources(
                    haveWater = waterField.text.toInt(),
                    haveMilk = milkField.text.toInt(),
                    haveCoffeeBeans = coffeeBeansField.text.toInt(),
                    haveDisposableCups = disposableCups.text.toInt()
                )
                val filledResources = controller.fillAll(resources)
                statusLabel.text = filledResources.responseString
            }
        }

        fillPanel.add(fillButton)
    }

    /**
     * Private function that adds element to take money from coffee machine
     */
    private fun takePanel() {
        val takeMoneyButton = JButton("Take money").apply {
            addActionListener {
                val action = controller.takeMoney()
                statusLabel.text = action.responseString
            }
        }
        takeMoneyPanel.add(takeMoneyButton)
    }

    internal fun showEventDemo() {
        orderPanel()
        createFillPanel()
        takePanel()

        mainFrame.isVisible = true
    }

    /**
     * Start function
     * @param info - initial message when the program start
     */
    override fun start(info: String) {
        statusLabel.text = info
    }
}
