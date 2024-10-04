package ch.heigvd.amt.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"url"})
        }
)
public class Probe {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @NotBlank
    @URL
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

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
