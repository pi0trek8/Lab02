package org.pwr.eto;

import org.pwr.models.PersonEntity;

import java.util.ArrayList;
import java.util.List;

public class JugEto{

    private final long id;

    private final Integer flavour;

    private int volume;

    private Integer portion;

    private final List<PersonEntity> people;

    public JugEto(long id, Integer flavour, int volume) {
        this.id = id;
        this.flavour = flavour;
        this.volume = volume;
        people = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }

    public Integer getFlavour() {
        return flavour;
    }

    public void pourOut(Integer volume) {
        this.volume -= volume;
    }

    public void assignPerson(PersonEntity person) {
        this.people.add(person);
    }

    public List<PersonEntity> getPeople() {
        return people;
    }

    public Integer getNumberOfAssignedPeople() {
        return people.size();
    }

    public Integer getPortion() {
        return portion;
    }

    public void setPortion(Integer portion) {
        this.portion = portion;
    }

    @Override
    public String toString() {
        return "JugEto{" +
                "id=" + id +
                ", flavour=" + flavour +
                ", volume=" + volume +
                '}';
    }
}
