# Tower of Hanoi
Tower of Hanoi is a game and a solver to the classic Tower of Hanoi puzzle

## What is Tower of Hanoi?
- The Tower of Hanoi consists of three rods and a number of disks of different sizes, which can slide onto any rod.
- The puzzle starts with the disks in a neat stack in ascending order of size on one rod, the smallest at the top.
- **The objective** of the puzzle is to move the entire stack to another rod, obeying the following simple rules:
  1. Only one disk can be moved at a time.
  2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
  3. No disk may be placed on top of a smaller disk.

## Installation
- Download the entire repository to your local folder
- `make`

## USAGE
`make run`

## Note
- Since the shortest solution of `n` disks is 2 ^ n - 1, it would be wise to limit your input to within 6 to avoid a really long game.
- Currently, the game accepts `n` from 1 to 30

## Fun Facts
- There is a story about an Indian temple in Kashi Vishwanath, which contains a large room with three time-worn posts in it surrounded by 64 golden disks. Brahmin priests, acting out the command of an ancient prophecy, have been moving these disks, in accordance with the immutable rules of the Brahma, since that time.
- According to the legend, when the last move of the puzzle is completed, the world will end.
- **If the lengend were true**, and if the prists were able to move disks at a rate of one per second, using the smallest number of moves, it would take them roughly **585 billion years** to finish, which is about **42 times** the current age of Universe.
