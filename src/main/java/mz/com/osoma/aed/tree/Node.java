
package mz.com.osoma.aed.tree;

/**
 *
 * @author feler
 */
public class Node {
    
    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public Node(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }
    
    @Override
    public String toString(){
        return "{"+iData+", "+dData+"}";
    } 
    
}
