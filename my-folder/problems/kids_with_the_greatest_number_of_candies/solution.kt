class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        return candies.map { if (candies.max()!! - it <= extraCandies) true else false }
    }
}