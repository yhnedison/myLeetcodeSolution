package lc683;

public class Solution {

	public int kEmptySlots(int[] flowers, int k, int m) {
        // m groups, k flowers at least for each group, return last day
		UnionFind uf = new UnionFind(flowers.length);
		int n = 0;
		int result = 0;
		
		for(int flower: flowers) { 
			n++;
			uf.add(flower); // map 1 - N to 0 - N-1, so we can use index directly
			
			if (uf.numGroup == m) { // only check when numGroup == m
				for (int size: uf.size) {
					if (size < k) break;
				}
				result = n;
			}
		}
		return result == 0 ? -1 : result;
    }
	
	public static void main(String[] args) {
		int[] input = new int[] {2,1,0,4,5,3};
		
		Solution sol = new Solution();
		int result = sol.kEmptySlots(input, 2, 2);
		
		System.out.println(result);
	}
}

class UnionFind {
	int[] parents; // int[x] = y, flower at position x have parent y
	int[] size;	
	int numGroup;
	int N;
	
	public UnionFind(int n) {
		parents = new int[n];
		size = new int[n];
		N = n;
		for (int i = 0; i < n; i++) {
			parents[i] = i;
			size[i] = 0;
		}
	}
	
	public void add(int p) {
		validate(p);
		if (p == 0 || p == N-1) { // add edge case single flower
			if ((p == 0 && parents[p+1] == -1) || (p == N-1 && parents[p-1] == -1)) {
				numGroup++;
				parents[p] = p;
				size[p] = 1;
			} else if (p == 0 && parents[p+1] != -1) {
				union(p, p+1);
			} else if (p == N-1 && parents[p-1] != -1) {
				union(p, p-1);
			}
		} else if (parents[p-1] == -1 && parents[p+1] == -1 ) { // add single flower
			numGroup++;
			parents[p] = p;
			size[p] = 1;
		} else if (parents[p-1] != -1 && parents[p+1] != -1) { // join two existing group
			union(p, p-1);
			union(p, p+1);
			numGroup--;
		} else if (parents[p-1] != -1) { // join left
			union(p, p-1);
		} else if (parents[p+1] != -1) { // join right
			union(p, p+1);
		}
	}
	
	public int find(int p) { // path compression
		while (p != parents[p]) {
			parents[p] = parents[parents[p]];
			p = parents[p];
		}
		return p;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public void union(int p, int q) {
		int rootp = find(p);
		int rootq = find(q);
		if (rootp == rootq) return;
		
		// join root with smaller size to root with larger size
		// update root size
		if (size[rootp] < size[rootq]) {
			parents[rootp] = rootq;
			size[rootq] += size[rootq];
		} else {
			parents[rootq] = rootp;
			size[rootp] += size[rootq];
		}
	}
	
	private void validate(int p) {
        if (p < 0 || p >= N) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (N-1));  
        }
    }
}

