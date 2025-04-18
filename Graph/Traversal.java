import java.util.*;
public class Traversal {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        } 
    }
    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q=new LinkedList<Integer>() ;
        boolean vis[]=new boolean[graph.length];
        q.add(0);
        //vis[0]=true;
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.println(curr+" ");
                vis[curr]=true;
                
                for(int i=0;i<graph[curr].size();i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
            

            //another way with line 17;
            // System.out.println(curr+" ");
            // for(int i=0;i<graph[curr].size();i++){
            //     if(!vis[graph[curr].get(i).dest]){
            //         vis[graph[curr].get(i).dest]=true;
            //         q.add(graph[curr].get(i).dest);
            //     }
            // }
        }
            
       
    }

    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean vis[]){
        System.out.println(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
   
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>[] graph=new ArrayList[v]; 
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        //0- vertex
        graph[0].add(new Edge(0, 1, 5));
        //1- vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 2, 1));
        //2- vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        //3- vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        //4- vertex
        graph[4].add(new Edge(4, 2, 2));
        //bfs(graph);
        dfs(graph, 0, new boolean[graph.length]);
    }
}
