import kotlin.math.cos
import kotlin.math.PI
import kotlin.math.absoluteValue
import kotlin.math.sin

typealias Vec2 = Pair<Double, Double>

private const val EPS = 1e-3

private operator fun Vec2.plus(rhs: Vec2): Vec2 = Vec2(first + rhs.first, second + rhs.second)

private fun Vec2.equalsEps(rhs: Vec2): Boolean =
    ((first - rhs.first).absoluteValue < EPS) && ((second - rhs.second).absoluteValue < EPS)

private fun toRad(deg: Double) = deg * PI / 180.0

class Solution {

    class RotationMatrix(angle: Double) {
        private val matrix = Pair<Vec2, Vec2>(
            Vec2(cos(angle), sin(angle)),
            Vec2(-sin(angle), cos(angle))
        )

        // Multiply direction vector with rotation matrix.
        fun rotate(dir: Vec2) = Vec2(
            matrix.first.first * dir.first + matrix.first.second * dir.second,
            matrix.second.first * dir.first + matrix.second.second * dir.second
        )
    }

    fun isRobotBounded(instructions: String): Boolean {
        var currPos = Vec2(0.0, 0.0)
        var currDir = Vec2(0.0, 1.0)
        val zeroVec = Vec2(0.0, 0.0)
        val leftRotMatrix = RotationMatrix(toRad(-90.0))
        val rightRotMatrix = RotationMatrix(toRad(90.0))
        instructions.forEach {
            when (it) {
                'L' -> {
                    currDir = leftRotMatrix.rotate(currDir)
                }
                'R' -> {
                    currDir = rightRotMatrix.rotate(currDir)
                }
                'G' -> {
                    currPos += currDir
                }
            }
        }

        if (currPos.equalsEps(zeroVec) || !currDir.equalsEps(Vec2(0.0, 1.0))) {
            return true
        }

        return false
    }
}
