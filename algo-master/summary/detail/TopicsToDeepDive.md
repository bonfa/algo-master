# Topics To Deep Dive 
## Bit Manipulation
* Sum without + and - operations
* Multiplication using just shift and sum
* Division using subtractions and shifts
* Hamming weight (counting the number of bits set to 1)
* Find the least significant bit set to 1
* Inverting the bits
* Changing two numbers without a temporary variable
* Determine if a number is a power of 2 or not
* Bit rotation
* Great common divisor with Stein algorithm

## Sum Prefix
* The cumulative sum up to i is represented as sum[i], and the cumulative sum up to j is sum[j].
  * If the remainder of sum[i] and sum[j] with respect to K is the same, then: $$ (sum[j] - sum[i]) \mod K = 0 $$
  This means that the difference between sum[j] and sum[i], that is, the sum of the subarray from i+1 to j, is divisible by K.
  * The sum of a subarray can be calculated as: $$ sum(i, j) = sum(0, j) - sum(0, i-1) $$ 
  Where: 
    * sum(i, j) is the sum of the elements in the subarray ranging from index i to index j. 
    * sum(0, j) and sum(0, i-1) are cumulative sums. 
    * If sum(i, j) = k, then: $$ sum(0, j) - sum(0, i-1) = k \implies sum(0, i-1) = sum(0, j) - k $$

## Other Topics
* Priority Queue (how it works in detail, when to use it, how to use it) --> see Hash Tables - Reorganize String
* Union find algorithm (how it works in detail, when to use it, how to use it) --> see Hash Tables - Longest Consecutive Sequence
* 

