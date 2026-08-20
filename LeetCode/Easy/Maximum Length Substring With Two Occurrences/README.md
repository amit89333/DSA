# Maximum Length Substring With Two Occurrences

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 20, 2026 |
| **Tags** | Hash Table, String, Sliding Window |
| **Link** | [View Problem](https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/) |
| **Runtime** | 3 ms |
| **Memory** | 44 MB |

## Problem Description

Given a string <code>s</code>, return the <strong>maximum</strong> length of a <span data-keyword="substring" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_t_" data-state="closed" class="">substring</button></span>&nbsp;such that it contains <em>at most two occurrences</em> of each character.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "bcbbbcba"</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>
The following substring has a length of 4 and contains at most two occurrences of each character: <code>"bcbb<u>bcba</u>"</code>.</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "aaaa"</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>
The following substring has a length of 2 and contains at most two occurrences of each character: <code>"<u>aa</u>aa"</code>.</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Easy Video Solution 🔥 || Brute Force->Optimal ✅|| Sliding Window
**Author**: [@ayushnemmaniwar12](https://leetcode.com/ayushnemmaniwar12/)
**Upvotes**: 18 👍
**Link**: [View Original Post](https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/solutions/4916854/)

---

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Try with Brute Force approach then optmize it


# ***Easy Video Explanation***

https://youtu.be/sJ_vin3I04s

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
    O(N*N)->O(N)
    

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
    O(N)
    

# Code


```C++ []
class Solution {
public:
    int maximumLengthSubstring(string s) {
        
        int n = s.length();
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            vector<int>arr(26, 0);
            for(int j = i; j < n; j++) {
                if(++arr[s[j] - \'a\'] == 3) break;
                maxLen = max(maxLen, j - i + 1);
            }
        }
        
        return maxLen;
    }
};
```
```python []
class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        n = len(s)
        maxLen = 0
        for i in range(n):
            arr = [0] * 26
            for j in range(i, n):
                arr[ord(s[j]) - ord(\'a\')] += 1
                if arr[ord(s[j]) - ord(\'a\')] == 3:
                    break
                maxLen = max(maxLen, j - i + 1)
        return maxLen

```
```Java []
public class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = new int[26];
            for (int j = i; j < n; j++) {
                if (++arr[s.charAt(j) - \'a\'] == 3) break;
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
}


```

# ***If you like the solution Please Upvote and subscribe to my youtube channel***
***It Motivates me to record more videos***

*Thank you* \uD83D\uDE00

</details>
