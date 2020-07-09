package main.com.gameoflife;

public enum Cell {

    LIVE {
        @Override
        public Cell evaluateCell(int liveNeighbours) {
            return (liveNeighbours == 2 || liveNeighbours == 3) ? LIVE : DEAD;
        }

    }, DEAD {
        @Override
        public Cell evaluateCell(int liveNeighbours) {
            return liveNeighbours == 3 ? LIVE : DEAD;
        }
    };

    private static final char LIVE_PIXEL = '*';
    private static final char DEAD_PIXEL = '.';

    public abstract Cell evaluateCell(int liveNeighbours);

    public static Cell equalTo(char pixel) {
        Cell cell;
        switch (pixel) {
            case LIVE_PIXEL:
                cell = Cell.LIVE;
                break;
            default:
                cell = Cell.DEAD;
        }
        return cell;
    }

    public String toString() {
        StringBuilder pixel = new StringBuilder();
        switch (this) {
            case LIVE:
                pixel.append(LIVE_PIXEL);
                break;
            case DEAD:
                pixel.append(DEAD_PIXEL);
                break;
        }
        return pixel.toString();
    }
}
