package Uebung5

import scala.annotation.tailrec

object CharacterTree {
  def print_tree(height: Int): Unit = {
    print_tree_char(height, '*')
  }

  def print_tree_char(height: Int, char: Char): Unit = {
    if (height < 0) {
      println("Height can't be smaller than 0!")
      return
    }
    print_tree_body(height, char, 0)
    print_stem(height - 1)
  }

  @tailrec
  private def print_tree_body(height: Int, char: Char, i: Int): Unit = {
    if (i < height) {
      val spaces = height - i - 1
      val symbols = 2 * i + 1
      print_spaces(spaces)
      print_chars(symbols, char)
      println()
      print_tree_body(height, char, i + 1)
    }
  }

  @tailrec
  private def print_spaces(spaces: Int): Unit = {
    if (spaces > 0) {
      printf(" ")
      print_spaces(spaces - 1)
    }
  }

  @tailrec
  private def print_chars(symbols: Int, char: Char): Unit = {
    if (symbols > 0) {
      print(char)
      print_chars(symbols - 1, char)
    }
  }

  private def print_stem(height: Int): Unit = {
    print_spaces(height)
    println("*\n")
  }

  def main(args: Array[String]): Unit = {
    val foo: Int = 5
    print_tree(foo)
    print_tree_char(foo, 'o')
  }
}
