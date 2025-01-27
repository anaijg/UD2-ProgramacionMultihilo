package utilidades;

public enum Emoji {
    MOUSE("\uD83D\uDC2D"),
    RAT("\uD83D\uDC00"),
    HAMSTER("\uD83D\uDC39"),
    CHIPMUNK("\uD83D\uDC3F");

    private final String emoji;

    Emoji(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }
}