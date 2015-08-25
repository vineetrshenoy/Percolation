
public class PercolationStats {

	private double [] x;
	private int T;
		
	public PercolationStats(int N, int T){
		if (N <= 0 || T <= 0)
			throw new IllegalArgumentException();
		x = new double[T];
		this.T = T;
		int openSites = 0;
		for (int i = 0; i < T;i++){
			Percolation p = new Percolation(N);
			openSites = 0;
			while (!p.percolates()){
				int row = StdRandom.uniform(1, N+1);
				int column = StdRandom.uniform(1, N+1);
				if (!p.isOpen(row, column)){
					p.open(row, column);
					openSites++;
				}
			}
			x[i] = (double)openSites/Math.pow(N, 2);
			
		}
		
		
	}
	
	
	public double mean(){
		return StdStats.mean(x);
	}
	
	public double stddev(){
		double stdDeviation = StdStats.stddev(x);
		return (stdDeviation);
	}
	
	public double confidenceLo(){
		double mean = this.mean();
		double stdDev = this.stddev();
		
		return mean - (1.96*stdDev) / Math.sqrt(T);
	}
	
	public double confidenceHi(){
		double mean = this.mean();
		double stdDev = this.stddev();
		
		return mean + (1.96*stdDev) / Math.sqrt(T);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		PercolationStats p = new PercolationStats(N,T);
		System.out.println("mean                     = " + p.mean());
		System.out.println("stddev                   = " + p.stddev());
		System.out.println("95% confidence interval  = " + p.confidenceLo() + "," + p.confidenceHi());

	}

}
