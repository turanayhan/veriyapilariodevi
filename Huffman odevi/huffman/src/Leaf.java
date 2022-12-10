
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Leaf extends Node {

    private final char character;

    public Leaf(char character, int frequency) {
        super(frequency);
        this.character = character;
    }

}