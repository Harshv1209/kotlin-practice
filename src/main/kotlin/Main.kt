data class Book(val name: String, val author: String, val year: Int, val price: Double, val stock: Int)

class BookStore {
    private val books = mutableListOf<Book>()

    fun run() {
        var choice = 0
        while (choice != 5) {
            printMenu()
            choice = readln().toInt()
            when (choice) {
                1 -> addBook()
                2 -> deleteBookPrompt()
                3 -> listBooks()
                4 -> printTotalBooks()
                5 -> println("Exiting...")
                else -> println("Invalid choice")
            }
            println()
        }
    }

    private fun printMenu() {
        println("1. Add book")
        println("2. Delete book")
        println("3. List books")
        println("4. Total books")
        println("5. Exit")
        print("Enter choice: ")
    }

    private fun addBook() {
        val name = readInput("Enter book name")
        val author = readInput("Enter author name")
        val year = readInput("Enter year").toInt()
        val price = readInput("Enter price").toDouble()
        val stock = readInput("Enter stock").toInt()
        books.add(Book(name, author, year, price, stock))
    }

    private fun deleteBookPrompt() {
        val name = readInput("Enter book name to delete")
        deleteBook(name)
    }

    private fun deleteBook(name: String) {
        books.removeIf { it.name == name }
    }

    private fun listBooks() {
        println("\nBooks:")
        books.forEach {
            println("-\tname: ${it.name}, author: ${it.author}, year: ${it.year}, price: ${it.price}, stock: ${it.stock}")
        }
    }

    private fun printTotalBooks() {
        println("Total books: ${books.size}")
    }

    private fun readInput(prompt: String): String {
        print("$prompt: ")
        return readln()
    }
}

fun main() {
    val bookStore = BookStore()
    bookStore.run()
}
