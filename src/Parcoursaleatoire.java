import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Parcoursaleatoire{
    private Graph graph;
    private ArrayList<Arc> tree;
    private HashSet<Integer> visited;
    private ArrayList<Arc> frontiere;
    private Random random;

    public Parcoursaleatoire (Graph graph){
        this.graph = graph;
        this.frontiere = new ArrayList<>();
        this.visited = new HashSet<>();
        this.tree = new ArrayList<>();
        this.random = new Random();
    }

    public Arc Extraire  (){
        return frontiere.remove(random.nextInt(frontiere.size()));
    }

    public void parcoursAleatoire(int sommet){
        visited.add(sommet);
        ajoute(sommet);
        while(!frontiere.isEmpty()){
            Arc arc = Extraire();
            if(!visited.contains(arc.getDest())){
                visited.add(arc.getDest());
                tree.add(arc);
                ajoute(arc.getDest());
            }
        }

    }
//Ajoute de tout les arcs sortant d'un sommet dans la frontière
    public void ajoute(int sommet){
        for(Arc arc : graph.outNeighbours(sommet)){
            frontiere.add(arc);
        }
    }
    public static ArrayList<Arc> generateTree(Graph graph, int root){
        Parcoursaleatoire algo = new Parcoursaleatoire(graph);
        algo.parcoursAleatoire(root);
        return algo.tree;
    }


}