package fipiar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lincoln
 */
public class ArvBi {
    private Node root;

    public void insert(int intValue, String string1, String string2) {
        root = insertNode(root, intValue, string1, string2);
    }

    private Node insertNode(Node currentNode, int intValue, String string1, String string2) {
        if (currentNode == null) {
            return new Node(intValue, string1, string2);
        }

        if (intValue < currentNode.getIntValue()) {
            currentNode.setLeft(insertNode(currentNode.getLeft(), intValue, string1, string2));
        } else if (intValue > currentNode.getIntValue()) {
            currentNode.setRight(insertNode(currentNode.getRight(), intValue, string1, string2));
        } else {
            // Handle duplicate values, if desired
        }

        return currentNode;
    }

    public String search(int intValue, int stringNumber) {
        Node foundNode = searchNode(root, intValue);
        if (foundNode != null) {
            if (stringNumber == 1) {
                return foundNode.getString1();
            } else if (stringNumber == 2) {
                return foundNode.getString2();
            } else {
                return null; // Invalid stringNumber
            }
        } else {
            return null; // Value not found
        }
    }

    private Node searchNode(Node currentNode, int intValue) {
        if (currentNode == null || intValue == currentNode.getIntValue()) {
            return currentNode;
        }

        if (intValue < currentNode.getIntValue()) {
            return searchNode(currentNode.getLeft(), intValue);
        } else {
            return searchNode(currentNode.getRight(), intValue);
        }
    }

    public int size() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(Node current) {
        if (current == null) {
            return 0;
        }

        int leftSize = sizeRecursive(current.left);
        int rightSize = sizeRecursive(current.right);

        return 1 + leftSize + rightSize;
    }

    public List<String> obterListaOrdenada() {
        List<String> listaOrdenada = new ArrayList<>();
        percorrerEmOrdem(root, listaOrdenada);
        Collections.sort(listaOrdenada);
        return listaOrdenada;
    }

    private void percorrerEmOrdem(Node currentNode, List<String> listaOrdenada) {
        if (currentNode != null) {
            percorrerEmOrdem(currentNode.getLeft(), listaOrdenada);
            listaOrdenada.add(formatarString(currentNode.getString1(), currentNode.getString2(), currentNode.getIntValue()));
            percorrerEmOrdem(currentNode.getRight(), listaOrdenada);
        }
    }

    private String formatarString(String string1, String string2, int intValue) {
        return "Nome: "+string1 + ", Gênero: " + string2 + ", ID: " + intValue;
        
    }
public void updateNome(int intValue, String newString1) {
    updateNomeNode(root, intValue, newString1);
}

private void updateNomeNode(Node currentNode, int intValue, String newString1) {
    if (currentNode == null) {
        return; // Value not found
    }

    if (intValue < currentNode.getIntValue()) {
        updateNomeNode(currentNode.getLeft(), intValue, newString1);
    } else if (intValue > currentNode.getIntValue()) {
        updateNomeNode(currentNode.getRight(), intValue, newString1);
    } else {
        // Update the node's name
        currentNode.setString1(newString1);
    }
}

public void updateGenero(int intValue, String newString2) {
    updateGeneroNode(root, intValue, newString2);
}

private void updateGeneroNode(Node currentNode, int intValue, String newString2) {
    if (currentNode == null) {
        return; // Value not found
    }

    if (intValue < currentNode.getIntValue()) {
        updateGeneroNode(currentNode.getLeft(), intValue, newString2);
    } else if (intValue > currentNode.getIntValue()) {
        updateGeneroNode(currentNode.getRight(), intValue, newString2);
    } else {
        // Update the node's genre
        currentNode.setString2(newString2);
    }
}


}
