class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val m = HashSet<Int>()
        for (num in nums) {
            if (!m.add(num)) {
                return true
            }
        }
        return false
    }
}