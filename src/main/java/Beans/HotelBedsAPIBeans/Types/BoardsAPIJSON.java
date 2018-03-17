package Beans.HotelBedsAPIBeans.Types;

import Beans.HotelBedsAPIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 11/03/2018.
 */
public class BoardsAPIJSON extends APIJSONMetada{

    private List<Board> boards;

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
}
