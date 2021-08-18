class SparseVector(nums: IntArray) : Iterable<Pair<Int, Int>> {
    private var isStronglySparsed: Boolean = false
    private var dict: MutableMap<Int, Int>? = null
    private var arr: IntArray? = null

    init {
        isStronglySparsed = nums.count { it == 0 } > nums.size / 3
        if (isStronglySparsed) {
            dict = HashMap<Int, Int>()
            nums.forEachIndexed { i, v ->
                if (v != 0) {
                    dict!![i] = v
                }
            }
        } else {
            arr = nums
        }
    }

    fun dotProduct(vec: SparseVector): Int {
        var dot = 0
        for ((k, v) in this) {
            dot += v * vec.getValueByIndex(k)
        }

        return dot
    }

    fun getValueByIndex(index: Int): Int {
        return if (isStronglySparsed) {
            dict!!.getOrElse(index) { 0 }
        } else {
            arr!![index]
        }
    }

    override fun iterator(): SparseIterator {
        return if (isStronglySparsed) {
            StronglySparsedIterator(dict!!)
        } else {
            WeaklySparsedIterator(arr!!)
        }
    }

    abstract class SparseIterator : Iterator<Pair<Int, Int>>

    class StronglySparsedIterator(private val dict: MutableMap<Int, Int>) : SparseIterator() {
        private val leftKeys = HashSet<Int>(dict.keys)

        override fun hasNext(): Boolean {
            return !leftKeys.isEmpty()
        }

        override fun next(): Pair<Int, Int> {
            val key = leftKeys.last()
            leftKeys.remove(key)
            return Pair(key, dict[key]!!)
        }

    }

    class WeaklySparsedIterator(private val arr: IntArray) : SparseIterator() {
        private var currentIndex = 0

        override fun hasNext(): Boolean {
            for (idx in currentIndex until arr.size) {
                if (arr[idx] != 0) {
                    currentIndex = idx
                    return true
                }
            }

            return false
        }

        override fun next(): Pair<Int, Int> {
            return Pair(currentIndex, arr[currentIndex])
        }

    }
}


/**
 * Your SparseVector object will be instantiated and called as such:
 * var v1 = SparseVector(nums1)
 * var v2 = SparseVector(nums2)
 * val ans = v1.dotProduct(v2)
 */