class Solution {
    fun restoreString(s: String, indices: IntArray): String {
        var restored = String()
        for ((i, v) in s.withIndex()) {
            restored += s[indices.indexOf(i)]
        }

        return restored
    }
}
