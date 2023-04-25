fun main() {
    val inputString = "Elizabeth"
    val result = processString(inputString)

// Print the results
    println("First character: ${result.first}")
    println("Last character: ${result.second}")
    println("String length: ${result.third}")

    //Quiz 2
    val password = "sparksNjoroge54"
    val isPasswordValid = checkPassword(password)
    if (isPasswordValid) {
        println("true")
    } else {
        println("false")
    }



    // QUIZ 3
  printMultiples()
    //Quiz 4
    val account = CurrentAccount("5468289", "Elizabeth Njoroge", 1000.0)
    account.deposit(500.0)
    account.withdraw(200.0)
    account.details()

    //5

        val accounts = SavingsAccount("36489999","Vallary Buraje", 3000.50, 200)

        accounts.deposit(500.0)
        accounts.withdraw(200.0)
        accounts.withdraw(300.0)
        accounts.withdraw(400.0)
        accounts.withdraw(500.0)
        accounts.details()




}
//1. Write and invoke one function that takes in a random string and returns the
//following values: first character, last character, length of the string and
//whether it begins with a vowel or not.

fun processString(inputString: String): Triple<Char, Char, Int> {
    val firstChar = inputString.first()
    val lastChar = inputString.last()
    val stringLength = inputString.length

    val beginsWithVowel = when (firstChar.toLowerCase()) {
        'a', 'e', 'i', 'o', 'u' -> true
        else -> false
    }

    return Triple(firstChar, lastChar, stringLength)
}

//2. Create a function that takes in a password as a parameter. For a password to
//be valid it must meet the following conditions:
//Must be at least 8 characters long
// Must be at most 16 characters long
//Must not be “password”
// Must contain a digit
//Your function should determine whether the password provided is valid or not.
//The function returns true/false
fun checkPassword(password: String): Boolean {
    if (password.length < 8 || password.length > 16) {
        return false
    }
    if (password == "password") {
        return false
    }
    if (!password.any { it.isDigit() }) {
        return false
    }

    return true
}

//3. Create a function that prints out multiples of 6 and 8 between 1 and 1000. For
//multiples of both 6 and 8 it should print out “Bingo!”
//Divide numbers for both 6 and 8 first   ///output is Bingo!
//then divisible by 6
//then divisible by 8

fun printMultiples() {
    for (i in 1..1000) {
        if (i % 6 == 0 && i % 8 == 0) {
            println("Bingo!")
        } else if (i % 6 == 0) {
            println("$i multiple of 6")
        } else if (i % 8 == 0) {
            println("$i multiple of 8")
        }
    }
}

//4. Create a class CurrentAccount with the following attributes: account number,
//account name, balance. It has the following functions:
//a. deposit(amount: Double) - Increments the balance by the amount
//deposited
//b. withdraw(amount: Double) - Decrements the balance by the amount
//withdrawn
//c. details() - Prints out the account number and balance and name in
//this format: “Account number x with balance y is operated by z”
open class CurrentAccount(val accountNumber: String, val accountName: String, var balance: Double) {

    fun deposit(amount: Double) {
        balance += amount
    }

    open fun withdraw(amount: Double) {
        if (amount <= balance) {
            balance -= amount
        } else {
            println("Null")
        }
    }

    fun details() {
        println("Account number $accountNumber with balance $balance is operated by $accountName")
    }
}

//5. Create another class SavingsAccount. It has the same functions and
//attributes as the current account except for one attribute, withdrawals: Int.
//Withdrawals is a counter variable that is used to keep track of how many
//withdrawals have been made from the account in a year. The only other
//difference is that the savings account withdraw() method first checks if the
//number of withdrawals is less than 4 for it to allow one to withdraw money
//from the account. It also increments the withdrawals attribute after a
//successful withdrawal.
class SavingsAccount(accountNumber: String, accountName: String, balance: Double,withdrawals:Int):CurrentAccount(accountNumber, accountName, balance){
    var withdrawals:Int = 0
    override fun withdraw(amount: Double){
        if (withdrawals<4){
            super.withdraw(amount)
            withdrawals++
        }else{
            println("sorry,no more withdrawals")
        }
    }
}


