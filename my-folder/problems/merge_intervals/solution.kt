class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) {
            return arrayOf<IntArray>()
        }

        val sorted = intervals.sortedBy { arr -> arr[0] }.toTypedArray()
        val result = mutableListOf<IntArray>(sorted[0])

        for (i in (sorted.indices - 0)) {
            val lastInterval = result.last()
            val currInterval = sorted[i]

            // Interval is fully consumed by latter.
            if (currInterval[1] <= lastInterval[1]) {
                continue
            }

            // If they partially intersect.
            if (currInterval[0] <= lastInterval[1] && currInterval[1] > lastInterval[1]) {
                result[result.size - 1][1] = currInterval[1]
            }

            if (currInterval[0] > lastInterval[1]) {
                result.add(currInterval)
            }
        }

        return result.toTypedArray()
    }
}