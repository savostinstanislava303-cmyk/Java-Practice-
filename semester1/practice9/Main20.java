package practice9;

public class Main20 {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("Ранковий драйв", 3);
        System.out.println(playlist.addTrack(new AudioTrack("Ранковий ритм", "Артист А", 215)));
        System.out.println(playlist.addTrack(new AudioTrack("Нічне місто", "Артист Б", 187)));
        System.out.println(playlist.addTrack(new AudioTrack("Літній вітер", "Артист В", 242)));
        System.out.println(playlist.addTrack(new AudioTrack("Зайвий трек", "Артист Г", 100)));
        System.out.println(playlist.addTrack(null));
        System.out.println();
        System.out.println(playlist);
        System.out.println("Секунд усього: " + playlist.getTotalDurationSeconds());
    }
}
