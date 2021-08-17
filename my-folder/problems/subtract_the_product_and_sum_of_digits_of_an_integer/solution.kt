class Solution {

    fun Int.toDigits(): List<Int> = toString().map { it.toInt() - '0'.toInt() }

    fun subtractProductAndSum(n: Int): Int {
        val digits = n.toDigits()
        val product = digits.reduce { acc, digit -> acc * digit }
        val sum = digits.reduce { acc, digit -> acc + digit }
        return product - sum
    }
}
