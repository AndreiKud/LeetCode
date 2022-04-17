class Solution {
    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()
        for (c in s) {
            if (stack.isNotEmpty() &&
                (c == ')' && stack.last() == '(' || c == ']' && stack.last() == '[' || c == '}' && stack.last() == '{')
            ) {
                stack.removeAt(stack.size - 1)
            } else {
                stack.add(c)
            }
        }
        return stack.isEmpty()
    }
}