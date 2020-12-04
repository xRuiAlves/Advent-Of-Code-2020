package day3

import utils.FileReader

object Day3Part2 {
    final val TREE = '#'
    final val OPEN = '.'
    final val SLOPES = List((1 , 1), (3, 1), (5, 1), (7, 1), (1, 2))

    def main(args: Array[String]): Unit = {
        val map = FileReader.readFile("Advent-Of-Code-2020/day3/input.txt").toArray
        val num_trees = SLOPES.map(slope => countTrees(map.clone, slope)).product
        println(num_trees)
    }

    def countTrees(map: Array[String], slope: (Int, Int)): Int = {
        var x = 0
        var y = 0
        var tree_count = 0

        while (y < map.length) {
            if (map(y)(x % map(y).length) == TREE) tree_count += 1
            x += slope._1
            y += slope._2
        }
        tree_count
    }
}