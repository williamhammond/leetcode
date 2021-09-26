/*
// Definition for a Node.
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
};
*/
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return List.of();
        // List is safe because it's a DAG and ordering is convient
        List<Pair<Node, Integer>> visited = new ArrayList<>();
        Queue<Pair<Node, Integer>> queue=  new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while(!queue.isEmpty()) {
            Pair<Node, Integer> current = queue.remove();
            visited.add(current);
            for (Node child: current.first.children){
                queue.add(new Pair<>(child, current.second + 1));
            }
        }
    Collection<List<Pair<Node, Integer>>> groupedNodes = visited.stream().collect(Collectors.groupingBy(pair -> pair.second)).values();
        List<List<Integer>> result = new ArrayList<>();
        for (List<Pair<Node, Integer>> nodeGroup: groupedNodes) {
            result.add(
                    nodeGroup.stream().map(pair -> pair.first.val).collect(Collectors.toList())
            );
        }
        return result;
    }
    
    static class Pair<T, U> {
        T first;
        U second;
        public Pair(T t, U u) {
            this.first = t;
            this.second = u;
        }
    }
}