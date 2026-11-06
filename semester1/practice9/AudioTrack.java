package practice9;

public class AudioTrack {
    private final String title;
    private final String artist;
    private final int durationSeconds;
    public AudioTrack(String title, String artist, int durationSeconds) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Назва треку не може бути порожньою");
        }
        if (artist == null || artist.isBlank()) {
            throw new IllegalArgumentException("Виконавець не може бути порожнім");
        }
        if (durationSeconds <= 0) {
            throw new IllegalArgumentException("Тривалість має бути додатною");
        }
        this.title = title;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public int getDurationSeconds() {
        return durationSeconds;
    }
    public String getFormattedDuration() {
        int minutes = durationSeconds / 60;
        int seconds = durationSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    @Override
    public String toString() {
        return artist + " - " + title + " [" + getFormattedDuration() + "]";
    }
}

