package lc305;
import java.util.*;

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (m < 1 || n < 1) {
            return result;
        }
            
        
        UF uf = new UF(m, n);
        for (int[] pos: positions) {
            uf.add(pos);
            result.add(uf.getNum());
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[][] input = new int[][] {{0,0},{0,1},{1,2},{2,1}};
        Solution so = new Solution();
        List<Integer> output = so.numIslands2(3, 3, input);
        System.out.println(Arrays.toString(output.toArray()));
    }
}

class UF {
    int[] parent;
    int[] rank;
    int[][] map;
    int num;
    int R, C;
    
    
    public UF (int m , int n) {
    	R = m;
        C = n;
        
        parent = new int[m * n];
        for (int i = 0; i < R * C; i++) {
            parent[i] = i;
        }
        
        rank = new int[m * n]; // initialized to all 0
        map = new int[m][n];
        num = 0;  
    }
    
    public void add(int[] pos) {
        
        System.out.println("Adding position " + pos[0] + " " +  pos[1]);
        int x = pos[0];
        int y = pos[1];
        if (x < 0 || x >= R || y < 0 || y >= C)
            return;
        
        map[x][y] = 1; // mark pos in map
        num++;
        int index = x * C + y;
        
        // only union when root is different
        if (x - 1 >= 0 && map[x-1][y] == 1) { // up
            if (find(index) != find((x-1) * C + y)) {
                union(index, (x - 1) * C + y);
                num--;
            } 
        }
        if (y - 1 >= 0 && map[x][y-1] == 1) { // left
            if (find(index) != find(x * C + y - 1)) {
                System.out.println("add left");
                union(index, x * C + y - 1);
                num--;
            } 
        } 
        if (x + 1 < R && map[x+1][y] == 1) { // down
            if (find(index) != find((x + 1) * C + y)) {
                System.out.println("add down");
                union(index, (x + 1) * C + y);
                num--;
            } 
        }
        if (y + 1 < C && map[x][y+1] == 1) { // right
            if (find(index) != find(x * C + y + 1)) {
                System.out.println("add right");
               union (index, x * C + y + 1);
               num--; 
            }  
        }
        return;     
    }
    
    public int getNum() {
        return this.num;
    }
    
    private int find(int x) {
        if (parent[x] != x) 
            parent[x] = find(parent[x]);
        return parent[x];
    }
    
    // if we union x y, return true
    // else return false
    private boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr)
            return false;
        else {
            if (rank[xr] > rank[yr]) {
                parent[yr] = xr;
            } else if (rank[xr] < rank[yr]) {
                parent[yr] = xr;
            } else {
                parent[yr] = xr;
                rank[xr]++;
            }
            return true; 
        }
        
    }
}
