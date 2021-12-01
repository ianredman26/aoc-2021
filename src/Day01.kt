fun main() {
    fun part1(input: List<String>): Int {
        var increments = 0

        input.forEachIndexed { index, depth ->
            if (index > 0) {
                if (depth.toInt() > input[index - 1].toInt()) {
                    increments = increments.plus(1)
                }
            }
        }

        return increments
    }

    fun part2(input: List<String>): Int {
        var increments = 0

        input.forEachIndexed { index, _ ->
            if (index.plus(3) < input.size) {
                val firstWindow = input[index].toInt()
                    .plus(input[index + 1].toInt())
                    .plus(input[index + 2].toInt())

                val secondWindow = input[index + 1].toInt()
                    .plus(input[index + 2].toInt())
                    .plus(input[index + 3].toInt())

                if (secondWindow > firstWindow) {
                    increments = increments.plus(1)
                }
            }
        }

        return increments
    }
    
    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
