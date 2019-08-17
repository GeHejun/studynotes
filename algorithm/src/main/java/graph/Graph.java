package graph;


import java.io.InputStream;

/**
 * @author gehj
 * @version 1.0
 * @description 图的定义
 * @date 2019/8/17 9:54
 */
public class Graph {
    /**
     * 顶点的数目
     */
    private int V = 0;
    /**
     * 边的数目
     */
    private int E;
    /**
     * 邻接表
     */
    private Bag<Integer>[] adj;

    /**
     * 创建一个含有v个订单但不含有边的图
     */
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < v; v++) {
            adj(i) = new Bag<Integer>();
        }
    }

    /**
     * 从标准流in读入一幅图
     * @param in
     */
    public Graph(InputStream in) {

    }

    /**
     * 顶点数
     * @return
     */
    public int V() {
        return V;
    }

    /**
     * 边数
     * @return
     */
    public int E() {
        return E;
    }

    /**
     * 向图中插入一条边 v-w
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj(v).add(w);
        adj(w).add(v);
        E++;
    }

    /**
     * 和v相邻的所有顶点
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * toString方法
     * @return
     */
    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
                s += "\n";
            }
        }
        return s;
    }
}
