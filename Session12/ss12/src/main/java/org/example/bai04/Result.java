package org.example.bai04;

public class Result {
    private String resultID;
    private String resultText;

    public Result() {
    }

    public Result(String resultID, String resultText) {
        this.resultID = resultID;
        this.resultText = resultText;
    }

    public String getResultID() {
        return resultID;
    }

    public void setResultID(String resultID) {
        this.resultID = resultID;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }
}
