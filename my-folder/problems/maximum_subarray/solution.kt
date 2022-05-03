import kotlin.math.max

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val dp = MutableList(nums.size) { 0 }
        var res = nums[0]
        dp[0] = nums[0]
        for (i in 1 until nums.size) {
            dp[i] = nums[i] + if (dp[i - 1] > 0) dp[i - 1] else 0
            res = max(res, dp[i])
        }
        return res
    }
}