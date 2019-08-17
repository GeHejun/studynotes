package graph;

/**
 * @author gehj
 * @version 1.0
 * @description 图的常用工具类
 * @date 2019/8/17 10:04
 */
public class GraphUtils {

    /**
     * 计算v的度数
     * @param G
     * @param v
     * @return
     */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree++;
        }
        return degree;
    }

    /**
     * 计算所有顶点的最大度数
     * @param G
     * @return
     */
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }

    /**
     * 计算所有顶点的平均度数
     * @return
     */
    public static int avgDegree(Graph G) {
        return 2 * G.E() / G.V();
    }

    /**
     * 计算自环的个数
     * @param G
     * @return
     */
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    count ++;
                }
            }
        }
        return count / 2;
    }
}
