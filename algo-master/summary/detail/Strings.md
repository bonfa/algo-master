# Current solution

## Exercises Not Solved
- Guess the Word - I sorted the words related to their similarity, but it was not enough. I needed to cluster them instead.

## Exercises Solved But Not In The Best Way
- is palindrome (the solution is good, I forgot the numeric case when reading the requirements. moreover, I am not super fluent in kotlin operators for strings)
- longest common prefix (solved vertically. I did not even think about binary search)
- Zig Zag conversion (solved in the proper way. The only thing I did not use the string builder but I created new string at each iteration, which is a bit more costly that using a string builder).
- Reverse words (if the string was mutable, I would not have thought about the multiple reverse in place that could be done to reduce space).

## Exercises Solved Perfectly
- is subsequence