fun main() {
    val forward = "forward"
    val down = "down"
    val up = "up"

    fun splitInput(s: String): Int {
        return (s.split(" ")[1].toInt())
    }

    fun part1(input: List<String>): Int {
        var horizontal = 0
        var depth = 0

        input.forEach { movement ->
            when {
                movement.contains(forward) -> {
                    val i = splitInput(movement)
                    horizontal = horizontal.plus(i)
                }
                movement.contains(down) -> {
                    val i = splitInput(movement)
                    depth = depth.plus(i)
                }
                movement.contains(up) -> {
                    val i = splitInput(movement)
                    depth = depth.minus(i)
                }
            }
        }
        return horizontal.times(depth)
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0

        input.forEach { movement ->
            when {
                movement.contains(forward) -> {
                    val i = splitInput(movement)
                    horizontal = horizontal.plus(i)
                    depth = depth.plus(i.times(aim))
                }
                movement.contains(down) -> {
                    val i = splitInput(movement)
                    aim = aim.plus(i)
                }
                movement.contains(up) -> {
                    val i = splitInput(movement)
                    aim = aim.minus(i)
                }
            }
        }
        return horizontal.times(depth)
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
