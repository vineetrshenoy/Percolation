
public class Percolation {

	private int N;
	private boolean [] sites;
	private WeightedQuickUnionUF uf;
	
	public Percolation(int N){
		if (N <= 0)
			throw new IllegalArgumentException();
		this.N = N;
		int totalSpaces = (int) Math.pow(N, 2);
		uf = new WeightedQuickUnionUF(totalSpaces);
		sites = new boolean[totalSpaces];
		
		//site[0] is designated as the virtual top site
		//sites[sites.length-1] is designated as the virtual bottom site
	}
	
	public void open(int i, int j){
		if (i < 1 || i > N)
			throw new IndexOutOfBoundsException();
		if (j < 1 || j > N)
			throw new IndexOutOfBoundsException();
		
		int index = this.changeCoordinates(i, j);
		//Signals an open site
		sites[index] = true;
		
		//union with site to the left, if it exists
		if ((index) % N != 0 && this.isOpen(i, j-1))
			uf.union(index, index-1);
		//union with site to the right, if it exists
		if ((index) % N != (N-1)&& this.isOpen(i, j+1))
			uf.union(index, index+1);
		
		
		//union with site above,if it exists. If it is in the top row,
		// union with virtual top site
		
		if (!(index-N<0)){
			if (this.isOpen(i-1, j))
				uf.union(index, index-N);
		}
		else
			uf.union(index, 0);
		
		// union with site below, if it exists. If it is in the bottom row
		// union with the virtual bottom site
		
		if (!(index+N>=sites.length)){
			if (this.isOpen(i+1, j))
				uf.union(index, index+N);
		}
		else
			uf.union(index, sites.length-1);
	}
	
	public boolean isFull(int i, int j){
		if (i < 1 || i > N)
			throw new IndexOutOfBoundsException();
		if (j < 1 || j > N)
			throw new IndexOutOfBoundsException();
		
		int index = this.changeCoordinates(i, j);
		return (this.isOpen(i, j) && uf.connected(0, index));
	}
	
	
	public boolean isOpen(int i, int j){
		if (i < 1 || i > N)
			throw new IndexOutOfBoundsException();
		if (j < 1 || j > N)
			throw new IndexOutOfBoundsException();
		
		int index = this.changeCoordinates(i, j);
		return sites[index] == true;
	}
		
	public boolean percolates(){
		if (N == 1)
			return this.isOpen(1, 1);
		return uf.connected(0, sites.length-1);
	}
	
	private int changeCoordinates(int row, int column){
		return (row-1) * N + (column-1);
	}
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
