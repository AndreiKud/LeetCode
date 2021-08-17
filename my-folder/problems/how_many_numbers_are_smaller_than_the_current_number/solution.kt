class Solution {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val cache = emptyMap<Int, Int>().toMutableMap()
        return nums.map { v ->
            cache.getOrPut(v) { nums.count { it < v } }
        }.toIntArray()
    }
}
