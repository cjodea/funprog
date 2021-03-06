package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (r == 0 || c == 0 || c == r)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def countDepth(chars: List[Char], depth : Int) : Int = {
      if (chars.isEmpty || depth < 0)
        depth
      else if (chars.head == '(')
        countDepth(chars.tail, depth + 1)
      else if (chars.head == ')')
        countDepth(chars.tail, depth - 1)
      else
        countDepth(chars.tail, depth)
    }
    countDepth(chars, 0) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0)
      1
    else if (money <  0 || coins.isEmpty)
      0
    else
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
