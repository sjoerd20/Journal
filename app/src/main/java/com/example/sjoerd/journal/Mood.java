package com.example.sjoerd.journal;

public enum Mood {
    HAPPY,
    SAD,
    INLOVE,
    ANGRY;

    public int getMoodImage() {
        switch (this) {
            case HAPPY:
                return R.drawable.laughing;
            case SAD:
                return R.drawable.sad;
            case INLOVE:
                return R.drawable.inlove;
            case ANGRY:
                return R.drawable.angry;
            default:
                return R.drawable.laughing;
        }
    }
}