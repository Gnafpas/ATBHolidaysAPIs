package Beans.TravelGateXBeans;

import Beans.TravelGateXBeans.Text;

import java.util.List;

/**
 * Created by George on 10/07/2018.
 */
public class BoardData {
    private String boardCode;
    private List<Text> texts;

    public String getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(String boardCode) {
        this.boardCode = boardCode;
    }

    public List<Text> getTexts() {
        return texts;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }
}
