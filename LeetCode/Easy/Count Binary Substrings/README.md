# Count Binary Substrings

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 9, 2026 |
| **Tags** | Two Pointers, String |
| **Link** | [View Problem](https://leetcode.com/problems/count-binary-substrings/) |
| **Runtime** | 10 ms |
| **Memory** | 46.2 MB |

## Problem Description

<p>Given a binary string <code>s</code>, return the number of non-empty substrings that have the same number of <code>0</code>'s and <code>1</code>'s, and all the <code>0</code>'s and all the <code>1</code>'s in these substrings are grouped consecutively.</p>

<p>Substrings that occur multiple times are counted the number of times they occur.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "00110011"
<strong>Output:</strong> 6
<strong>Explanation:</strong> There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "10101"
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: JS, Python, Java, C++ | Easy Rolling Count Solution w/ Explanation
**Author**: [@sgallivan](https://leetcode.com/sgallivan/)
**Upvotes**: 92 👍
**Link**: [View Original Post](https://leetcode.com/problems/count-binary-substrings/solutions/1172553/)

---

*(Note: This is part of a series of Leetcode solution explanations. If you like this solution or find it useful,* ***please upvote*** *this post.)*

---

#### ***Idea:***

Since the **0**\'s and **1**\'s have to be grouped consecutively, we only have to be concerned with the most recent two groups (**curr, prev**) at any time as we iterate through the input string (**s**). Since each addition to our answer (**ans**) must therefore be centered on the "edge" between the two groups, we should be able to count multiple increases to **ans** at the same time.

For example, if we find a group that is **"0001111"**, then we know that we\'ve found multiple answer counts centered on the **"01"**. Each additional extra character on both sides will be an extra answer, which means that **"0011"** and **"000111"** are also answers. In other words, the number that we should add to **ans** is equal to **min(zeros, ones)**, or **3** in this example.

So we can now iterate through **s**, keeping track of the **curr** and **prev** groups, and when we find the end of a group, we can calculate our addition to **ans** and then swap the two variables while resetting **curr** to **1**.

Since we\'re going to be comparing **s[i]** to **s[i-1]** to see if the character has changed, we\'ll need to start our iteration with **i = 1** which means we should define a starting value for **curr** of **1**. Also, since the end of **s** is technically the end of a group, we should add another **min(curr, prev)** onto **ans** before we **return ans**, as it won\'t be accounted for in the iteration through **s**.

 - _**Time Complexity: O(N)** where **N** is the length of **s**_
 - _**Space Complexity: O(1)**_

---

#### ***Implementation:***

There are only minor differences in the code for all four languages.

---

#### ***Javascript Code:***
```javascript
var countBinarySubstrings = function(s) {
    let curr = 1, prev = 0, ans = 0
    for (let i = 1; i < s.length; i++)
        if (s[i] === s[i-1]) curr++
        else ans += Math.min(curr, prev), prev = curr, curr = 1
    return ans + Math.min(curr, prev)
};
```

---

#### ***Python Code:***
```python
class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        curr, prev, ans = 1, 0, 0
        for i in range(1, len(s)):
            if s[i] == s[i-1]: curr += 1
            else:
                ans += min(curr, prev)
                prev, curr = curr, 1
        return ans + min(curr, prev)
```

---

#### ***Java Code:***
```java
class Solution {
    public int countBinarySubstrings(String s) {
        int curr = 1, prev = 0, ans = 0;
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) == s.charAt(i-1)) curr++;
            else {
                ans += Math.min(curr, prev);
                prev = curr;
                curr = 1;
            }
        return ans + Math.min(curr, prev);
    }
}
```

---

#### ***C++ Code:***
```c++
class Solution {
public:
    int countBinarySubstrings(string s) {
        int curr = 1, prev = 0, ans = 0;
        for (int i = 1; i < s.length(); i++)
            if (s[i] == s[i-1]) curr++;
            else ans += min(curr, prev), prev = curr, curr = 1;
        return ans + min(curr, prev);
    }
};
```

</details>
