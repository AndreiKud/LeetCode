class Solution {
    fun removeVowels(s: String): String {
        val vowels = setOf('a', 'u', 'e', 'o', 'i')
        return s.filter { it !in vowels }
    }
}