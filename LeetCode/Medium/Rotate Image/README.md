# Rotate Image

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | August 20, 2026 |
| **Tags** | Array, Math, Matrix |
| **Link** | [View Problem](https://leetcode.com/problems/rotate-image/) |
| **Runtime** | 0 ms |
| **Memory** | 44 MB |

## Problem Description

<p>You are given an <code>n x n</code> 2D <code>matrix</code> representing an image, rotate the image by <strong>90</strong> degrees (clockwise).</p>

<p>You have to rotate the image <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>, which means you have to modify the input 2D matrix directly. <strong>DO NOT</strong> allocate another 2D matrix and do the rotation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg" style="width: 500px; height: 188px;">
<pre><strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [[7,4,1],[8,5,2],[9,6,3]]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg" style="width: 500px; height: 201px;">
<pre><strong>Input:</strong> matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
<strong>Output:</strong> [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == matrix.length == matrix[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 20</code></li>
	<li><code>-1000 &lt;= matrix[i][j] &lt;= 1000</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: AC Java in place solution with explanation Easy to understand.
**Author**: [@LuckyIdiot](https://leetcode.com/LuckyIdiot/)
**Upvotes**: 659 👍
**Link**: [View Original Post](https://leetcode.com/problems/rotate-image/solutions/18879/)

---

The idea was firstly transpose the matrix and then flip it symmetrically. For instance, 

    1  2  3             
    4  5  6
    7  8  9

after transpose, it will be swap(matrix[i][j], matrix[j][i])

    1  4  7
    2  5  8
    3  6  9

Then flip the matrix horizontally.  (swap(matrix[i][j], matrix[i][matrix.length-1-j])

    7  4  1
    8  5  2
    9  6  3

Hope this helps.

    public class Solution {
        public void rotate(int[][] matrix) {
            for(int i = 0; i<matrix.length; i++){
                for(int j = i; j<matrix[0].length; j++){
                    int temp = 0;
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            for(int i =0 ; i<matrix.length; i++){
                for(int j = 0; j<matrix.length/2; j++){
                    int temp = 0;
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length-1-j];
                    matrix[i][matrix.length-1-j] = temp;
                }
            }
        }
    }

</details>
