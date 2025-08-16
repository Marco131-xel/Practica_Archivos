package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class VideoGame implements Serializable {
    private final UUID id;
    private String title;
    private int hoursPlayed;
    private boolean completed;

    public VideoGame(UUID id, String title, int hoursPlayed, boolean completed) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.hoursPlayed = hoursPlayed;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return this.title + " " + this.id + " " + this.completed;
    }
}
