fun main() {
    val array = arrayOf(1,1,0,1,0,0,0,1,1)
    val text = arrayListOf('h','e','l','l','o')
    val bracket = "{[(])}" // "{(([])[])[]}" // "([{}])"

    maximumConsecutive(array)
    println()
    reverseString(text,0)
    println()
    if (balancedBrackets(bracket)) print("YES") else print("NO")
}

fun maximumConsecutive(binaryArray: Array<Int>) {
    var count = 0
    var temp = 0

    for (i in binaryArray.indices) {
        if (i == 0) {
            count++
        } else {
            if (binaryArray[i] != binaryArray[i-1]) {
                if (count >= temp) {
                    temp = count
                    count = 1
                }
            } else if (binaryArray[i] == binaryArray[i-1]) {
                count++
                if (i == binaryArray.size-1 && count >= temp) {
                    temp = count
                    count = 1
                }
            }
        }
    }

    return print(temp)
}

fun reverseString(text: ArrayList<Char>, next: Int, newText: ArrayList<Char> = arrayListOf()) {

    if (next >= text.size) {
        return
    } else {
        reverseString(text, next + 1, newText)
        newText.add(text[next])
        if (next == 0) {
            print(newText)
        }
    }
}

fun balancedBrackets(bracket: String): Boolean {
    val temp = ArrayList<Char>()

    for (char in bracket) {
        if (char == '(' || char == '{' || char == '[') {
            temp.add(char)
        } else {
            if (temp.isEmpty()) return false

            val check: Char
            when (char) {
                ')' -> {
                    check = temp.removeLast()
                    if (check == '{' || check == '[') return false
                }
                '}' -> {
                    check = temp.removeLast()
                    if (check == '(' || check == '[') return false
                }
                ']' -> {
                    check = temp.removeLast()
                    if (check == '{' || check == '(') return false
                }
            }
        }
    }

    return temp.isEmpty()
}