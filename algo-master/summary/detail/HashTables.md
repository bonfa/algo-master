# Exercise list
1. Design HashMap
2. Maximum Number of Balloons
3. Number of Good Pairs
4. Isomorphic Strings
5. Ransom Note
6. Contains Duplicate II
7. Group Anagrams
8. Encode and Decode TinyURL
9. Reorganize String
10. Longest Consecutive Sequence
11. Split Array into Consecutive Subsequences
12. Number of Matching Subsequences
13. Number of Good Ways to Split a String

## Attempt 3
* Design HashMap (SOLVED PERFECTLY -> actually the tests are not working well with collision, but I am fine with that)
* Isomorphic Strings (SOLVED_SUB_OPTIMAL -> used one array instead of two)
* Group Anagrams (SOLVED_SUB_OPTIMAL -> The simple solution did not come to my mind)
* Encode and Decode TinyURL (SOLVED PERFECTLY)
* Reorganize String (SOLVED_SUB_OPTIMAL)
* Longest Consecutive Sequence (NOT SOLVED)
* Split Array into Consecutive Subsequences (SOLVED -> but optimally for space and not for time)
* Number of Matching Subsequences

## Attempt 1
1. Design HashMap (SOLVED_PERFECTLY (for time))
2. Maximum Number of Balloons (SOLVED_NOT_OPTIMAL -> Solved with map not with array)
3. Number of Good Pairs (SOLVED_PERFECTLY -> better than Hashish solution)
4. Isomorphic Strings (SOLVED_SUB_OPTIMAL -> very similar to best solution, just used one map rather than two)
5. Ransom note (SOLVED_PERFECTLY)
6. Contains duplicate II (SOLVED_SUB_OPTIMAL -> built a map and applied filter later, could have done it in place)
7. Group Anagrams (SOLVED_SUB_OPTIMAL -> the idea was correct. I just used less efficient data structures)
8. Encode and Decode TinyURL  (SOLVED_SUB_OPTIMAL -> I skipped the incremental value. I did not use base64 as encoding. I used a custom solution)
9. Reorganize String (SOLVED_SUB_OPTIMAL -> used a map, not a priority queue)
10. Longest Consecutive Sequence (SOLVED_SUB_OPTIMAL -> the solution fails with long inputs)
11. Split Array into Consecutive Subsequences (NOT_SOLVED -> tried to solve it by reasoning on the frequency of the numbers but the solution was not working)
12. Number of Matching Subsequences (SOLVED_SUB_OPTIMAL -> first solution "brute force", then improved. still not using binary search)
13. Number of Good Ways to Split a String (SOLVED_SUB_OPTIMAL -> the idea was there, but I could have improved the implementation significantly)

## Attempt 2
* Design HashMap (SOLVED_PERFECTLY (for time) -> but I would like to implement the hash-map by myself)
* Maximum Number of Balloons (SOLVED_PERFECTLY)
* Isomorphic Strings (SOLVED_SUB_OPTIMAL -> perfect solution but with the help of chatGpt in order to check the NULL value in charArray)
* Contains Duplicate II (SOLVED_PERFECTLY -> tried first with array, but it was too space consuming, so moved to map)
* Group Anagrams (SOLVED_SUB_OPTIMAL -> still can improve the key of the map)
* Encode and Decode TinyURL (SOLVED_SUB_OPTIMAL -> did not handle collisions between random keys)
* Reorganize String (SOLVED_SUB_OPTIMAL -> I did not use the priority queue, I did not shortcut the worst-case scenario)
* Longest Consecutive Sequence (SOLVED_SUB_OPTIMAL -> the solution fails with long inputs)
* Split Array into Consecutive Subsequences (NOT_SOLVED)
* Number of Matching Subsequences (SOLVED_SUB_OPTIMAL -> brute force)
* Number of Good Ways to Split a String (SOLVED_PERFECTLY)

# Revision List
## After Attempt 1
* Design HashMap (+ handle the collision)
* Maximum Number of Balloons
* Isomorphic Strings
* Contains Duplicate II
* Group Anagrams
* Encode and Decode TinyURL
* Reorganize String
* Longest Consecutive Sequence
* Split Array into Consecutive Subsequences
* Number of Matching Subsequences
* Number of Good Ways to Split a String

## After Attempt 2
* Design HashMap (+ handle the collision)
* Isomorphic Strings
* Group Anagrams
* Encode and Decode TinyURL
* Reorganize String
* Longest Consecutive Sequence
* Split Array into Consecutive Subsequences
* Number of Matching Subsequences