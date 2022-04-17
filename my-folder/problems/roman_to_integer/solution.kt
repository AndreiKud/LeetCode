class Solution {

    private fun parse(char: Char, nextChar: Char?): Pair<Int, Boolean> {
        return when (char) {
            'I' -> {
                when (nextChar) {
                    'V' -> 4 to true
                    'X' -> 9 to true
                    else -> 1 to false
                }
            }
            'X' -> {
                when (nextChar) {
                    'L' -> 40 to true
                    'C' -> 90 to true
                    else -> 10 to false
                }
            }
            'C' -> {
                when (nextChar) {
                    'D' -> 400 to true
                    'M' -> 900 to true
                    else -> 100 to false
                }
            }
            'V' -> 5 to false
            'L' -> 50 to false
            'D' -> 500 to false
            'M' -> 1000 to false
            else -> throw IllegalArgumentException()
        }
    }

    fun romanToInt(s: String): Int {
        var i = 0
        var sum = 0
        while (i < s.length) {
            val nextChar = if (i < s.length - 1) s[i + 1] else null
            val res = parse(s[i], nextChar)
            sum += res.first
            i += if (res.second) 2 else 1
        }
        return sum
    }
}