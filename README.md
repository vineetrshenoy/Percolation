# Percolation

Using UnionFind algorithms to determine whether a given grid percolates when sites are opened at random. This assignment was created as a part of Coursera's "Algorithms I" hosted by Princeton University. The official assignment specification can be foun here: http://coursera.cs.princeton.edu/algs4/assignments/percolation.html

Percolation can be modeled using an N x N grid in which sites are either opened or blocked. A full site is any open site that can connect to a open site in the top row by chaining adjacent open sites. A system percolates if any open site in the top row of the grid can connect to an open site in the bottom row of the grid through connections to adjacent open sites. See photo in the assignment specification for full details.

The APIs are as follows:

    public class Percolation {
    public Percolation(int N)               // create N-by-N grid, with all sites blocked
    public void open(int i, int j)          // open site (row i, column j) if it is not open already
    public boolean isOpen(int i, int j)     // is site (row i, column j) open?
    public boolean isFull(int i, int j)     // is site (row i, column j) full?
    public boolean percolates()             // does the system percolate?
    }
  

Once the percolation data type was created, the PercolationStats class was written to analyze the performance of the algorithm

    public class PercolationStats {
    public PercolationStats(int N, int T)     // perform T independent experiments on an N-by-N grid
    public double mean()                      // sample mean of percolation threshold
    public double stddev()                    // sample standard deviation of percolation threshold
    public double confidenceLo()              // low  endpoint of 95% confidence interval
    public double confidenceHi()              // high endpoint of 95% confidence interval
    public static void main(String[] args)    // test client 
    }


This assignment was completed on June 22, 2015
