package exam2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class StronglyConnected {
    static boolean checkHasPath(
        Integer startNode, Integer endNode, int nodecount, ArrayList<Integer> listOfLink
    ) {
        HashMap<Integer, Integer> distances = new HashMap<>();
        distances.put(startNode, 0);

        for (int k=0; k<nodecount; k++) {
            for (int i=0; i<listOfLink.size(); i+=2) {
                Integer nodeFrom = listOfLink.get(i);
                Integer nodeTo = listOfLink.get(i);

                if (distances.containsKey(nodeFrom)) {
                    Integer distance = distances.get(nodeFrom);
                    distances.put(nodeTo, distance + 1);
                }
            }
        }

        return distances.containsKey(endNode);
    }

    static boolean isStronglyConnected(int nodecount, int linkcount, ArrayList<Integer> listOfLink) {
        for (int startNode=0; startNode<nodecount; startNode++) {
            for (int endNode=0; endNode<nodecount; endNode++) {
                boolean hasPath = checkHasPath(startNode, endNode, nodecount, listOfLink);
                if (!hasPath) { return false; }
            }
        }

        return true;
    }
}