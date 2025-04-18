import java.util.ArrayList;

public class Cycle {
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        } 
    }
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean visited[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                if(detetctCycleUtil(graph,visited,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detetctCycleUtil(ArrayList<Edge>[] graph,boolean visited[],int curr,int parent){
        visited[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            //case 3
            if(!visited[e.dest]){
                if(detetctCycleUtil(graph,visited,e.dest,curr)){
                    return true;
                }
                
            }
            //case 1
            else if(visited[e.dest] && e.dest!=parent){
                return true;
            }
            //case2-do nothing continue

        }
        return false;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>[] graph=new ArrayList[v]; 
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));


        System.out.println(detectCycle(graph));

        /*
         0-----------3
        /|           |
       / |           |
      1  |           4
      \  |
       \ |
        2 


         */
    }
}
