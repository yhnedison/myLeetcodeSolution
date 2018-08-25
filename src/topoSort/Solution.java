package topoSort;

public class Solution {
private List<Integer> result; // 用来存储结果集 privateQueue<Integer>setOfZeroIndegree; //用来存储入度为0的顶点 private int[] indegrees; // 记录每个顶点当前的入度
private int edges;
private Digraph di;
public KahnTopological(Digraph di) {
this.di = di;
this.edges = di.getE();
this.indegrees = new int[di.getV()];
this.result = new ArrayList<Integer>(); this.setOfZeroIndegree = new LinkedList<Integer>();
// 对入度为0的集合进行初始化 Iterable<Integer>[] adjs = di.getAdj(); for(int i = 0; i < adjs.length; i++)
{
// 对每一条边 v -> w for(int w : adjs[i])
{
indegrees[w]++; }
}
for(int i = 0; i < indegrees.length; i++) {
if(0 == indegrees[i]) {
setOfZeroIndegree.enqueue(i); }
}
process(); }
private void process() {
while(!setOfZeroIndegree.isEmpty()) {
int v = setOfZeroIndegree.dequeue();
// 将当前顶点添加到结果集中 result.add(v);
// 遍历由v引出的所有边 for(int w : di.adj(v))
{
// 将该边从图中移除，通过减少边的数量来表示
edges--;
if(0 == --indegrees[w]) // 如果入度为0，那么加入入度为0的集合 {
setOfZeroIndegree.enqueue(w); }
} }
// 如果此时图中还存在边，那么说明图中含有环路 if(0 != edges)
{
throw new IllegalArgumentException("Has Cycle !"); }
}
public Iterable<Integer> getResult() {
return result; }
}