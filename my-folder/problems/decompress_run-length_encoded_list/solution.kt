class Solution {
    fun decompressRLElist(nums: IntArray): IntArray {
        val res = mutableListOf<Int>()
        for (i in nums.indices step 2) {
            res.addAll(Array<Int>(nums[i]) { nums[i + 1] })
        }

        return res.toIntArray()
    }
}
