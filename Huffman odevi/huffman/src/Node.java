
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Node implements Comparable<Node> {

    private final int frequency;
    private Node leftNode;
    private Node rightNode;

    public Node(Node leftNode, Node rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.frequency = leftNode.getFrequency() + rightNode.getFrequency();
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(frequency, node.getFrequency());
    }

}