import java.util.Arrays;

public class Dijkastra {
    private static final int NO_PARENT=-1;

    public static void Dijakra(int[][] adjacencyMAtrix ,int startNode){

        int numNodes=adjacencyMAtrix[0].length;


        int[] distance=new int[numNodes];
        int[] parents=new int[numNodes];

        Arrays.fill(distance,Integer.MAX_VALUE);
        Arrays.fill(parents,NO_PARENT);

        distance[startNode]=0;
    }
}
