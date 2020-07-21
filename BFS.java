import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

//  BFS模板
public class BFS {
    int bfs(Node root) {
        if (root == null) {
            return 0;
        }
        //  路径、层数
        int depth = 1;
        //  核心数据结构 - 队列
        Queue<Node> queue = new LinkedList<>();
        //  已访问节点，防止吃回头草
        List<Node> visited = new ArrayList<>();
        queue.offer(root);
        visited.add(root);

        while(!queue.isEmpty()) {
            int sz = queue.size();
            //  访问队列中的所有节点
            for (int i = 0; i < sz; i++) {
                Node cur = queue.poll();
                //  do sth

                //  这里将子节点都加入队列
                for (Node child : cur.children) {
                    if (!visited.contains(child)) {
                        queue.offer(child);
                        visited.add(child);
                    }
                }
            }
            depth ++;
        }
        return depth;
    }
}