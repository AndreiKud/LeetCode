class Solution {
    fun decode(encoded: IntArray, first: Int): IntArray {
        val res = IntArray(encoded.size + 1)
        res[0] = first
        encoded.forEachIndexed { i, v ->
            res[i + 1] = v.xor(res[i])
        }

        return res
    }
}
