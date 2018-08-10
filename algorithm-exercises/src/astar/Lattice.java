package astar;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author theozhang on 8/10/18
 */
@Data
@EqualsAndHashCode(of = {"x","y"})
public class Lattice {
    private Integer x;
    private Integer y;
    private Double g;
    private Double h;
    private Double f;
    private Type type;
    private Lattice parent;

    @Override
    public String toString(){
        return x + "-" + y;
    }
}
