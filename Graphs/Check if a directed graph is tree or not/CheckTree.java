
public class CheckTree {
	public static boolean isTree(Graph g) {
		int root = 0;
		boolean[] visited = new boolean[g.vertices];
		
		Queue<Integer> queue = new Queue<>(g.vertices);
		queue.enqueue(root);
		visited[root] = true;
		
		int numberOfVisited = 1;
		
		while(!queue.isEmpty()) {
			int current_node = queue.dequeue();
			
			DoublyLinkedList<Integer>.Node temp = null;
			if(g.adjacencyList[current_node] != null) {
				temp = g.adjacencyList[current_node].headNode;
			}
			
			while(temp != null) {
				if(!visited[temp.data]) {
					queue.enqueue(temp.data);
					visited[temp.data] = true;
					numberOfVisited++;
				}else {
					return false;
				}
				temp = temp.nextNode;
			}
		}
		if(numberOfVisited == g.vertices) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,3);
		g.addEdge(3,4);
		g.printGraph();
		System.out.println("isTree: " + isTree(g));
		
		Graph g2 = new Graph(4);
		g2.addEdge(0,1);
		g2.addEdge(0,2);
		g2.addEdge(0,3);
		g2.addEdge(3,2);
		g2.printGraph();
		System.out.println("isTree " + isTree(g2));
		
		Graph g3 = new Graph(6);
		g3.addEdge(0,1);
		g3.addEdge(0,2);
		g3.addEdge(0,3);
		g3.addEdge(4,5);
		g3.printGraph();
		System.out.println("isTree: " + isTree(g3));

	}

}
