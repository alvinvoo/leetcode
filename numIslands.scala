//problem 200 Number of Islands

object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = 
    var nIslands = 0
    for i <- Range(0, grid.length) do
      for j <- Range(0, grid(0).length) do
          // when its a 1
          // use dfs to 'flood' or mark all adjacent tiles which are 1
          // increment count for this patch of land
          if grid(i)(j) == '1' then
            dfs(grid, i, j)

            nIslands += 1
    nIslands

  def dfs(grid: Array[Array[Char]], i: Int, j: Int): Unit =
    if i < 0 || i >= grid.length || j < 0 || j >= grid(0).length || grid(i)(j) != '1' then
      ()
    else
      grid(i)(j) = '#'
      dfs(grid, i - 1, j)
      dfs(grid, i + 1, j)
      dfs(grid, i, j - 1)
      dfs(grid, i, j + 1)
      () 

}

val tt = Array(
  Array('1','1','1','1','0'),
  Array('1','1','0','1','0'),
  Array('1','1','0','0','0'),
  Array('1','1','0','0','0'),
  Array('0','0','0','0','0'),
  )

val tt2 = Array(
  Array('1','1','0','0','0'),
  Array('1','1','0','0','0'),
  Array('0','0','1','0','0'),
  Array('0','0','0','0','0'),
  Array('0','0','0','1','1'),
  )
