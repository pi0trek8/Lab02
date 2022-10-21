package org.pwr.models;

public class Jug implements org.pwr.common.Jug {
    private final long id;
//    private final Flavour flavour;

    private final Integer flavour;
    private final int volume;

    public Jug(long id, Integer flavour, int volume) {
        this.id = id;
        this.flavour = flavour;
        this.volume = volume;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public Integer getFlavour() {
        return flavour;
    }

    @Override
    public String toString() {
        return "JugEntity{" +
                "id=" + id +
                ", flavour=" + flavour +
                ", volume=" + volume +
                '}';
    }
}
