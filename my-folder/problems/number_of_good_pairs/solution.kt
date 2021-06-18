class Solution {
    fun numIdenticalPairs(nums: IntArray): Int {
        var res: Int = 0
        val m = mutableMapOf<Int, Int>()
        for (num1 in nums) {
            val num: Int = num1
            if (num in m) {
                res += m[num]!!
                m[num] = m[num]!! + 1
            } else {
                m[num] = 1
            }
        }

        return res
    }
}