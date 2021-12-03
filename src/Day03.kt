fun main() {

    fun reverseBinaryNumber(binary: String): String {
        var res = ""

        for (s in binary) {
            res = if (s.toString() == "1") {
                res.plus("0")
            } else {
                res.plus("1")
            }
        }
        return res
    }

    fun convertBinaryToDecimal(num: Long): Int {
        var num = num
        var decimalNumber = 0
        var i = 0
        var remainder: Long

        while (num.toInt() != 0) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }

    fun part1(input: List<String>): Int {
        val length = input[0].length
        val zero = 0
        val one = 1

        var counterZero = 0
        var counterOne = 0

        var gamma = ""


        for (i in 0 until length) {

            input.forEach { s ->
                val number = s[i].digitToInt()
                if (number == zero) {
                    counterZero++
                } else if (number == one) {
                    counterOne++
                }
            }

            gamma = if (counterZero > counterOne) {
                gamma.plus(zero.toString())
            } else {
                gamma.plus(one.toString())
            }

            counterZero = 0
            counterOne = 0

        }


        val epsilonBinary = reverseBinaryNumber(gamma)
        println("Gamma is $gamma")
        println("Epsilon is $epsilonBinary")


        val epsilonRate = convertBinaryToDecimal(epsilonBinary.toLong())
        val gammaRate = convertBinaryToDecimal(gamma.toLong())

        println(epsilonRate)
        println(gammaRate)
        val res = gammaRate.times(epsilonRate)
        println(res)


        return res
    }


    fun bitCriteria(input: MutableList<String>, length: Int, mostCommon: Boolean): Int {
        val zero = 0
        val one = 1



        for (i in 0 until length) {
            var counterZero = 0
            var counterOne = 0

            println("-----------------")
            println("Size = ${input.size}")
            println(input)
            if (input.size == 1) {
                println("Found result ... break")
                break
            }

            input.forEach { s ->
                val number = s[i].digitToInt()
                if (number == zero) {
                    counterZero++
                } else if (number == one) {
                    counterOne++
                }
            }

            println("Counter One $counterOne")
            println("Counter Zero $counterZero")
            println("Counter total ${counterZero.plus(counterOne)}")


            when {
                counterZero == counterOne -> {
                    input.removeIf {
                        if (mostCommon) {
                            it[i].toString() == zero.toString()
                        } else {
                            it[i].toString() == one.toString()
                        }
                    }
                }
                counterZero > counterOne -> {
                    input.removeIf {
                        if (mostCommon) {
                            it[i].toString() == one.toString()
                        } else {
                            it[i].toString() == zero.toString()
                        }
                    }
                }
                else -> {
                    input.removeIf {
                        if (mostCommon) {
                            it[i].toString() == zero.toString()
                        } else {
                            it[i].toString() == one.toString()
                        }
                    }
                }
            }
        }

        println("Result is ... $input[0]")
        return convertBinaryToDecimal(input[0].toLong())
    }

    fun part2(input: List<String>): Int {
        val length = input[0].length


        val oxygenGeneratorRating = bitCriteria(input.toMutableList(), length, true)
        val scrubberRating = bitCriteria(input.toMutableList(), length, false)

        println(oxygenGeneratorRating)
        println(scrubberRating)
        println(oxygenGeneratorRating.times(scrubberRating))
        return 0

    }

    val input = readInput("Day03")
//    part1(input)
    println(part2(input))
//    println(part1(input))
//    println(part2(input))


//life support rating = the oxygen generator rating x the CO2 scrubber rating.

//start with the full list of binary numbers from your diagnostic report and consider just the first bit of those numbers


}
