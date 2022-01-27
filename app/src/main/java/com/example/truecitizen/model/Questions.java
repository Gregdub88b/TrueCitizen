package com.example.truecitizen.model;

public class Questions {

    private int answerResId;
    private boolean answerTrue;

    public Questions(int answerResId, boolean answerTrue) {
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }

    public int getAnswwerResId() {
        return answerResId;
    }

    public void setAnswwerResId(int answwerResId) {
        this.answerResId = answerResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
