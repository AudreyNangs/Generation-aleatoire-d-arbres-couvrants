import java.util.*;

public class Aldouss {
    Graph graph;

    Random random = new Random();
    HashSet<Integer> visited ;

    ArrayList<Arc> tree;
    Arc currentArc;
    public Aldouss(Graph graph){
        this.graph = graph;
        this.tree =new ArrayList<>();
        this.visited=new HashSet<>();
    }
    public int choix(int sommet ){

            int nbreArcsortant=graph.outAdjacency.get(sommet).size();
            currentArc  = graph.outAdjacency.get(sommet).get(random.nextInt(nbreArcsortant));
            int sommetAleatoire=currentArc.getDest();
            return sommetAleatoire;
//on choisit un arc aleatoire parmis les arcs sortant d'un sommet et on prend sa destination
        }
    public void marche(int sommetActuel){
                 visited.add(sommetActuel);
            while (visited.size() < graph.order) {
                if(!visited.contains(sommetActuel)){
                    visited.add(sommetActuel);
                    tree.add(currentArc);
                }
                    int sommetSuivant = choix(sommetActuel);
                    sommetActuel = sommetSuivant;


            }
        }
        public static ArrayList<Arc> generateTree(Graph graph , int currentVertex) {
        Aldouss algo=new Aldouss(graph);
        algo.marche(currentVertex);
        return algo.tree;

        }
}