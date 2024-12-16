class Main {
  public static void main(String[] args) {
      UnweightedGraph<String> graph = new UnweightedGraph<>();
      graph.addVertex("Liberal Arts");
      graph.addVertex("Theatre");
      graph.addVertex("Business & Technology");
      graph.addVertex("Student Services");
      graph.addVertex("Technology Learning Center");
      graph.addVertex("Health Careers & Sciences");
      graph.addVertex("Health Technologies Center");
      graph.addVertex("Recreation Center");

      graph.addEdge(graph.getIndex("Liberal Arts"), graph.getIndex("Theatre"));
      graph.addEdge(graph.getIndex("Theatre"), graph.getIndex("Business & Technology"));
      graph.addEdge(graph.getIndex("Liberal Arts"), graph.getIndex("Student Services"));
      graph.addEdge(graph.getIndex("Business & Technology"), graph.getIndex("Student Services"));
      graph.addEdge(graph.getIndex("Student Services"), graph.getIndex("Technology Learning Center"));
      graph.addEdge(graph.getIndex("Student Services"), graph.getIndex("Recreation Center"));
      graph.addEdge(graph.getIndex("Recreation Center"), graph.getIndex("Health Careers & Sciences"));
      graph.addEdge(graph.getIndex("Health Careers & Sciences"), graph.getIndex("Health Technologies Center"));

      int startVertex = graph.getIndex("Business & Technology");

      System.out.println("Paths from Business & Technology:");
      UnweightedGraph<String>.SearchTree bfsTree = graph.bfs(startVertex);

      bfsTree.printPath(graph.getIndex("Health Technologies Center"));
      System.out.println();
      bfsTree.printPath(graph.getIndex("Student Services"));
      System.out.println();
      bfsTree.printPath(graph.getIndex("Recreation Center"));
      System.out.println();

      System.out.println("Business & Technology:");
      bfsTree.printTree();
      
      Graph<String> graph2 = new UnweightedGraph<>(graph.getVertices(), graph.getEdges());

      UnweightedGraph<String>.SearchTree dfs = graph2.dfs(graph2.getIndex("Business & Technology"));

      java.util.List<Integer> searchOrders = dfs.getSearchOrder();
      System.out.println("\n" + dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
      for (int i = 0; i < searchOrders.size(); i++)
          System.out.print(graph2.getVertex(searchOrders.get(i)) + " ");
      System.out.println();

      for (int i = 0; i < searchOrders.size(); i++)
          if (dfs.getParent(i) != -1)
              System.out.println("Parent of " + graph2.getVertex(i) +
                      " is " + graph2.getVertex(dfs.getParent(i)));
  }
}
