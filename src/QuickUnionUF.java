
public class QuickUnionUF {

	private int [] id;
	
	
	public QuickUnionUF(int N){
		id=new int[N];
		for(int i=0; i<N;i++){
			id[i]=i;
		}
	}
	
	private int root(int i){
		while(i!=id[i])
			i=id[i];
		return i;
	}
	
	public boolean isConnected(int p,int q){
		return this.root(p)==this.root(q);	
	}
	
	public void union(int p, int q){
		int i=root(p);
		int j=root(q);
		id[i]=j;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[5];
		System.out.println(array[2]);
	}

}
