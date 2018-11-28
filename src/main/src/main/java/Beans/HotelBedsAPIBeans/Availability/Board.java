package Beans.HotelBedsAPIBeans.Availability;

import java.util.List;

/**
 * Created by George on 25/04/2018.
 */
public class Board {

    private boolean included;
    private List<String> board;

    public boolean isIncluded() {
        return included;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    public List<String> getBoard() {
        return board;
    }

    public void setBoard(List<String> board) {
        this.board = board;
    }
}
