package practice9;

public class Playlist {
    private String name;
    private final AudioTrack[] tracks;
    private int trackCount;

    /**
     * @param name     назва плейлиста
     * @param capacity максимальна кількість треків
     */
    public Playlist(String name, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Місткість має бути додатною");
        }
        this.name = name;
        this.tracks = new AudioTrack[capacity];
        this.trackCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrackCount() {
        return trackCount;
    }

    /**
     * Додає трек у плейлист.
     *
     * @return true, якщо трек додано; false, якщо track == null або плейлист заповнений
     */
    public boolean addTrack(AudioTrack track) {
        if (track == null || trackCount >= tracks.length) {
            return false;
        }
        tracks[trackCount++] = track;
        return true;
    }

    /**
     * Сумарна тривалість усіх треків у секундах.
     */
    public int getTotalDurationSeconds() {
        int total = 0;
        for (int i = 0; i < trackCount; i++) {
            total += tracks[i].getDurationSeconds();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Плейлист: ").append(name).append('\n');

        if (trackCount == 0) {
            sb.append("(порожньо)\n");
        }
        for (int i = 0; i < trackCount; i++) {
            sb.append(i + 1).append(". ").append(tracks[i]).append('\n');
        }

        int total = getTotalDurationSeconds();
        sb.append("Загальна тривалість: ")
                .append(total / 60).append(" хв ")
                .append(total % 60).append(" сек");
        return sb.toString();
    }
}

