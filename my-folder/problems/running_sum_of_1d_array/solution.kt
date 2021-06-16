class Solution {
    fun runningSum(nums: IntArray): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf()
        }

        var last = 0
        val res = mutableListOf<Int>()
        nums.forEach {
            last += it;
            res += last
        }

        return res.toIntArray()
    }
}