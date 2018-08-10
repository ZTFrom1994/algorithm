package astar;

import java.util.*;

/**
 * @author theozhang on 8/10/18
 */
public class AStar {
    /**
     * Start : -1
     * End : 1
     * available :0
     * unavailable : -2
     */
    private static Integer[][] map = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, -2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, -2, 0, 0, 0, 0},
            {0, 0, -1, 0, 0, -2, 0, 0, 0, 0},
            {0, 0, -2, 0, 0, -2, 0, 0, 0, 0},
            {0, 0, -2, -2, -2, -2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, -2, -2, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    public static void main(String[] args) {
        Lattice[][] latticeMap = new Lattice[10][10];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                Lattice lattice = new Lattice();
                lattice.setX(i);
                lattice.setY(j);
                switch (map[i][j]) {
                    case 0:
                        lattice.setType(Type.NORMAL);
                        break;
                    case 1:
                        lattice.setType(Type.END);
                        break;
                    case -1:
                        lattice.setType(Type.START);
                        break;
                    case -2:
                        lattice.setType(Type.BLOCK);
                        break;
                    default:
                }
                latticeMap[i][j] = lattice;
            }
        }
        Lattice start = latticeMap[4][2];
        Lattice end = latticeMap[7][8];

        Lattice now = start;
        Set<Lattice> openList = new HashSet<>();
        Set<Lattice> closeList = new HashSet<>();

        openList.addAll(getSurroundLattices(start, latticeMap, closeList));
        for (Lattice lattice : openList) {
            lattice.setG(getDistance(lattice, start));
            lattice.setH(getH(lattice,end));
            lattice.setF(lattice.getG() + lattice.getH());
            lattice.setParent(start);
        }

        while (!openList.isEmpty()) {
            Lattice minFLattice = findMinF(openList);
            openList.remove(minFLattice);
            closeList.add(minFLattice);
            List<Lattice> successors = getSurroundLattices(minFLattice, latticeMap, closeList);
            for (Lattice successor : successors) {
                if (successor.getType().equals(Type.END)) {
                    successor.setParent(minFLattice);
                    openList.clear();
                    break;
                }
                if (closeList.contains(successor)) {
                    continue;
                }

                double newG = minFLattice.getG() + getDistance(successor, minFLattice);
                if (!openList.contains(successor)) {
                    openList.add(successor);
                } else if (newG >= successor.getG()) {
                    continue;
                }
                successor.setParent(minFLattice);

                successor.setG(newG);
                successor.setH(getH(successor,end));
                successor.setF(successor.getG() + successor.getH());
            }
        }
        Lattice front = end.getParent();
        while (front != null) {
            System.out.println(front.toString());
            front = front.getParent();
        }
    }

    private static List<Lattice> getSurroundLattices(Lattice current, Lattice[][] latticeMap, Set<Lattice> closeList) {
        List<Lattice> surroundLattices = new ArrayList<>();

        List<Integer> xList = new ArrayList<>();
        xList.add(current.getX());
        List<Integer> yList = new ArrayList<>();
        yList.add(current.getY());
        Integer leftX = current.getX() - 1;
        Integer rightX = current.getX() + 1;
        Integer leftY = current.getY() - 1;
        Integer rightY = current.getY() + 1;
        if (leftX != -1) {
            xList.add(leftX);
        }
        if (rightX != 10) {
            xList.add(rightX);
        }
        if (leftY != -1) {
            yList.add(leftY);
        }
        if (rightY != 10) {
            yList.add(rightY);
        }

        for (Integer x : xList) {
            for (Integer y : yList) {
                if (current.getX().equals(x) && y.equals(current.getY())) {
                    continue;
                }
                if (Math.abs(x - current.getX()) + Math.abs(y - current.getY()) == 1){
                    surroundLattices.add(latticeMap[x][y]);
                }
            }
        }

        List<Lattice> useful = new ArrayList<>();
        for (Lattice lattice : surroundLattices) {
            if ((lattice.getType().equals(Type.NORMAL) || lattice.getType().equals(Type.END)) && !closeList.contains(lattice)) {
                useful.add(lattice);
            }
        }
        return useful;
    }

    private static Lattice findMinF(Set<Lattice> openList) {
        Lattice lattice = null;
        for (Lattice item : openList) {
            if (lattice == null) {
                lattice = item;
            } else {
                if (lattice.getF() > item.getF()) {
                    lattice = item;
                }
            }
        }
        return lattice;
    }

    private static Double getDistance(Lattice lattice1, Lattice lattice2) {
        Integer side1 = Math.abs(lattice1.getX() - lattice2.getX());
        Integer side2 = Math.abs(lattice1.getY() - lattice2.getY());
        Double side3 = Math.sqrt(side1 * side1 + side2 * side2);
        return side3;
    }

    private static Double getH(Lattice lattice,Lattice end){
        return new Double(Math.abs(lattice.getX() - end.getX()) + Math.abs(lattice.getY() - end.getY()));
    }
}
