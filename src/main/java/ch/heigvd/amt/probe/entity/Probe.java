package ch.heigvd.amt.probe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Probe {

    @Id
    private String url;

    public Probe(String url) {
        this.url = url;
    }

    public Probe() {
        // do nothing
    }

    public String getUrl() {
        return url;
    }

}
