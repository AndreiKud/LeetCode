class Solution {
    fun isPalindrome(x: Int): Boolean {
        val str = x.toString()
        val mid = str.length / 2
        for (i in (0..mid)) {
            if (str[i] != str[str.length - i - 1]) {
                return false
            }
        }
        return true
    }
}