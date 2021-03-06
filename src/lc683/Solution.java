package lc683;

public class Solution {

	public int kEmptySlots(int[] flowers, int k, int m) {
        // m groups, k flowers at least for each group, return last day
		UnionFind uf = new UnionFind(flowers.length);
		int n = 0;
		int result = 0;

		for(int flower: flowers) {
			n++;
			uf.add(flower - 1); // transfer 1~N to 0~N-1

			check : {
				if (uf.getNumGroup() == m) { // only check when numGroup == m
					for (int i: flowers) {
						if (uf.getSize(i-1) >= 1 && uf.getSize(uf.find(i-1)) < k) {
							break check;
						}
					}
					result = n;
				}
			}

		}
		return result == 0 ? -1 : result;
    }

	public static void main(String[] args) {
		int[] input = new int[] {3,2,1,5,6,4};

		Solution sol = new Solution();
		int result = sol.kEmptySlots(input, 2, 2);
	}
}

class UnionFind {
	private int[] parents; // int[x] = y, flower at position x have parent y
	private int[] size;	// also use size to indicate added or not(size == 0)
	private int numGroup;
	private int N;

	public UnionFind(int n) {
		parents = new int[n];
		size = new int[n];
		N = n;
		for (int i = 0; i < n; i++) {
			parents[i] = i; // pointing to self
			size[i] = 0; // 0 indicates not added
		}
	}

	public int getNumGroup() {
		return numGroup;
	}

	public int getSize(int p) {
		return size[p];
	}

	public void add(int p) {
		validate(p);
		size[p] = 1;
		if (p == 0 || p == N-1) { // single flower, edge case
			if ((p == 0 && size[p+1] == 0) || (p == N-1 && size[p-1] == 0)) {
				numGroup++;
				parents[p] = p;
			} else if (p == 0 && size[p+1] != 0) {
				union(p, p+1);
			} else if (p == N-1 && size[p-1] != 0) {
				union(p, p-1);
			}
		} else if (size[p-1] == 0 && size[p+1] == 0 ) { // add single flower
			numGroup++;
			parents[p] = p;
		} else if (size[p-1] != 0 && size[p+1] != 0) { // join two existing group
			union(p, p-1);
			union(p, p+1);
			numGroup--;
		} else if (size[p-1] != 0) { // join left
			union(p, p-1);
		} else if (size[p+1] != 0) { // join right
			union(p, p+1);
		}
	}

	public int find(int p) { // with path compression, find root of p
		while (p != parents[p]) {
			parents[p] = parents[parents[p]];
			p = parents[p];
		}
		return p;
	}

	private void union(int p, int q) {
		int rootp = find(p);
		int rootq = find(q);
		if (rootp == rootq) return;

		// join root with smaller size to root with larger size
		// update root size
		if (size[rootp] < size[rootq]) {
			parents[rootp] = rootq;
			size[rootq] += size[rootp];
//			size[rootp] = size[rootq]; // update size of both root
		} else {
			parents[rootq] = rootp;
			size[rootp] += size[rootq];
//			size[rootq] = size[rootp]; // update size of both
		}
	}

	private void validate(int p) {
        if (p < 0 || p >= N) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (N-1));
        }
    }
}
