class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        for (i in 0..199) {
            if (!strs.all { str -> i < str.length && str[i] == strs.first()[i] }) {
                return if (i == 0) "" else strs.first().substring(0, i)
            }
        }

        return strs.first()
    }
}