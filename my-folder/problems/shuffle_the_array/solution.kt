class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        var res = mutableListOf<Int>()
        for (i in 0 until n) {
            res.add(nums[i])
            res.add(nums[i + n])
        }

        return res.toIntArray()
    }
}