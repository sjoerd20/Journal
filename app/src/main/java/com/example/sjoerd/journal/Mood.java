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

    public int getMoodImageView() {
        switch (this) {
            case HAPPY:
                return R.id.moodHappy;
            case SAD:
                return R.id.moodSad;
            case INLOVE:
                return R.id.moodInLove;
            case ANGRY:
                return R.id.moodAngry;
            default:
                return R.id.moodHappy;
        }
    }

    public Mood getMood() {
        switch (this) {
            case HAPPY:
                return HAPPY;
            case SAD:
                return SAD;
            case INLOVE:
                return INLOVE;
            case ANGRY:
                return ANGRY;
            default:
                return HAPPY;
        }
    }
}