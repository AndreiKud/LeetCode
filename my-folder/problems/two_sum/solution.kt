class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val m = mutableMapOf<Int, Int>()
        for ((i, v) in nums.withIndex()) {
            val difference = target - v
            if (m.contains(difference)) {
                return intArrayOf(m.getValue(difference), i)
            }

            m[v] = i
        }

        return IntArray(0)
    }
}