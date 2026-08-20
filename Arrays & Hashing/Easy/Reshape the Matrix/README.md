# Reshape the Matrix

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 20, 2026 |
| **Tags** | Array, Matrix, Simulation |
| **Link** | [View Problem](https://leetcode.com/problems/reshape-the-matrix/) |
| **Runtime** | 0 ms |
| **Memory** | 47.4 MB |

## Problem Description

<p>In MATLAB, there is a handy function called <code>reshape</code> which can reshape an <code>m x n</code> matrix into a new one with a different size <code>r x c</code> keeping its original data.</p>

<p>You are given an <code>m x n</code> matrix <code>mat</code> and two integers <code>r</code> and <code>c</code> representing the number of rows and the number of columns of the wanted reshaped matrix.</p>

<p>The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.</p>

<p>If the <code>reshape</code> operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/24/reshape1-grid.jpg" style="width: 613px; height: 173px;">
<pre><strong>Input:</strong> mat = [[1,2],[3,4]], r = 1, c = 4
<strong>Output:</strong> [[1,2,3,4]]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/24/reshape2-grid.jpg" style="width: 453px; height: 173px;">
<pre><strong>Input:</strong> mat = [[1,2],[3,4]], r = 2, c = 4
<strong>Output:</strong> [[1,2],[3,4]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>-1000 &lt;= mat[i][j] &lt;= 1000</code></li>
	<li><code>1 &lt;= r, c &lt;= 300</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: JAVA SOLUTION || DETAILED EXPLANATION || EASY APPROCH || 100% Efficent
**Author**: [@sarrthac](https://leetcode.com/sarrthac/)
**Upvotes**: 136 👍
**Link**: [View Original Post](https://leetcode.com/problems/reshape-the-matrix/solutions/1727031/)

---

# Approch -``

***1st condition** to be checked -*
Firstly will have to check if the product of dimension of the given array matrix(**mat**) and the product of dimensions of the new array matrix are eqaul. If they are not equal this means we cannot fill all the elements perfectly in one of the matrix hence in this condition, will have to return the original array.

***Secondly***, we will traverse through the first matrix and add the elements in our newly created **output matrix**, but here we have to keep in mind to add elements column wise and not row wise. i.e we will maintain two seperate pointers for rows and colums and firstly we will go through colums & if (**column == c**) then we will move to next row & also set the column pointer to zero again.

***For Better unnderstnading let\'s look at the code***

```
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        //Storing the values of mat matrix
        //i.e m = rows & n = cols
        int rows = mat.length;
        int cols = mat[0].length;
        
        //if the product of rows & cols of mat matrix and the new matrix are not same then return original matrix
        if((rows * cols) != (r * c)) return mat;
        
        //Creating the new matrix
        int[][] output = new int[r][c];
        int output_rows = 0;
        int output_cols = 0;
        
        
        //Traversing the mat matrix and storing the its values in new matrix output cols wise
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                output[output_rows][output_cols] = mat[i][j];
                output_cols++;
                
                //if the cols value reached then change the row and set the cols value to 0.
                if(output_cols == c)
                {
                    output_cols = 0;
                    output_rows++;
                }
            }
        }
        
        return output;
    }
}
```


**If found helpful, please upvote.
Thank You !!**

</details>
