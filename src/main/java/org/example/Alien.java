package org.example;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
//@Table(name="alien_table")
public class Alien{

    @Id
    private int id;
    private AlienName name;
    //@Column(name="alien_color")
    private String color;

    @OneToMany(mappedBy = "alien", fetch = FetchType.EAGER)
    private Collection<Laptop> laps = new ArrayList<Laptop>();

    public Alien() {

    }

    public Alien(int id, AlienName name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AlienName getName() {
        return name;
    }

    public void setName(AlienName name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Collection<Laptop> getLaps() {
        return laps;
    }

    public void setLaps(Collection<Laptop> laps) {
        this.laps = laps;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name=" + name +
                ", color='" + color + '\'' +
                '}';
    }
}