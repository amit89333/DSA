# Projection Area of 3D Shapes

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 23, 2026 |
| **Tags** | Array, Math, Geometry, Matrix |
| **Link** | [View Problem](https://leetcode.com/problems/projection-area-of-3d-shapes/) |
| **Runtime** | 2 ms |
| **Memory** | 46.3 MB |

## Problem Description

<p>You are given an <code>n x n</code> <code>grid</code> where we place some <code>1 x 1 x 1</code> cubes that are axis-aligned with the <code>x</code>, <code>y</code>, and <code>z</code> axes.</p>

<p>Each value <code>v = grid[i][j]</code> represents a tower of <code>v</code> cubes placed on top of the cell <code>(i, j)</code>.</p>

<p>We view the projection of these cubes onto the <code>xy</code>, <code>yz</code>, and <code>zx</code> planes.</p>

<p>A <strong>projection</strong> is like a shadow, that maps our <strong>3-dimensional</strong> figure to a <strong>2-dimensional</strong> plane. We are viewing the "shadow" when looking at the cubes from the top, the front, and the side.</p>

<p>Return <em>the total area of all three projections</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/08/02/shadow.png" style="width: 800px; height: 214px;">
<pre><strong>Input:</strong> grid = [[1,2],[3,4]]
<strong>Output:</strong> 17
<strong>Explanation:</strong> Here are the three projections ("shadows") of the shape made with each axis-aligned plane.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [[2]]
<strong>Output:</strong> 5
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> grid = [[1,0],[0,2]]
<strong>Output:</strong> 8
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == grid.length == grid[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 50</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 50</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Solution
**Author**: [@deleted_user](https://leetcode.com/deleted_user/)
**Upvotes**: 2 👍
**Link**: [View Original Post](https://leetcode.com/problems/projection-area-of-3d-shapes/solutions/3507864/)

---

```C++ []
class Solution {
public:
    int projectionArea(vector<vector<int>>& grid) {
        int n = grid.size(), area = 0;
        vector<int> x_v(n), y_v(n);
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int v = grid[x][y];
                if (v) {
                    area++;
                    if (x_v[x] < v) x_v[x] = v;
                    if (y_v[y] < v) y_v[y] = v;
                }
            }
            area += x_v[x];
        }
        for (int y = 0; y < n; y++)
            area += y_v[y];
        return area;
    }
};
```

```Python3 []
class Solution:    
    def projectionArea(self, grid: List[List[int]]) -> int:
        xy = sum(i > 0 for s in grid for i in s)
        xz = sum(max(s) for s in grid)
        yz = sum(max(s[i] for s in grid) for i in range(len(grid)))
        return xy + xz + yz
```

```Java []
class Solution {
    public int projectionArea(int[][] grid) {
        int a=0,x=0;
        for(int i=0;i<grid.length;i++)
        {
            int mr=Integer.MIN_VALUE;
            int mc=Integer.MIN_VALUE;
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]!=0)x+=1;
                if(grid[i][j]>mr)mr=grid[i][j];
                if(grid[j][i]>mc)mc=grid[j][i];
            }
            a+=mr+mc;
        }
        return (a+x);
    }
}
```


</details>
