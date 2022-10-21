package org.pwr.models;

import org.pwr.eto.JugEto;
import org.pwr.eto.PersonEto;

import java.util.*;
import java.util.stream.Collectors;

public class PersonEntity {

    private long id;
    private List<Integer> flavours;
    private int satisfaction;
    private int dissatisfaction = 400;
    private Map<Long, Integer> jugIdToVolume = new HashMap<>();
    private Map<Long, Integer> flavourToVolume = new HashMap<>();

    private final List<JugEto> assignedJugs = new ArrayList<>();

    public PersonEntity(PersonEto personEto) {
        this.id = personEto.getId();
        this.flavours = personEto.getFlavourPreferencesList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public int getDissatisfaction() {
        return dissatisfaction;
    }

    public Map<Long, Integer> getJugIdToVolume() {
        return jugIdToVolume;
    }

    public void setJugIdToVolume(Map<Long, Integer> jugIdToVolume) {
        this.jugIdToVolume = jugIdToVolume;
    }

    public List<Integer> getFlavours() {
        return flavours;
    }

    public void setFlavours(List<Integer> flavours) {
        this.flavours = flavours;
    }

    public void assignJug(JugEto jug) {
        this.assignedJugs.add(jug);
    }

    public List<JugEto> getAssignedJugs() {
        return assignedJugs;
    }

    public void addToMap(Long jugId, Integer volume, Integer flavour) {
        int weight = flavours.size() - flavours.indexOf(flavour);
        this.satisfaction += weight * volume;
        if (flavours.indexOf(flavour) == 0) {
            dissatisfaction = Math.max(400 - volume, 0);
        }
        jugIdToVolume.put(jugId, volume );
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", flavours=" + flavours +
                ", satisfaction=" + satisfaction +
                ", dissatisfaction=" + dissatisfaction +
                ", jugIdToVolume=" + jugIdToVolume +
                ",\n assignedJugs=" + assignedJugs.stream().map(JugEto::toString).collect(Collectors.toList()) +
                "flavourToVolume = " + flavourToVolume +
                "}\n\n\n\n";
    }

    public void pour(Integer flavour, int volume) {
        var jug = this.assignedJugs.stream().filter(juice -> Objects.equals(juice.getFlavour(), flavour)).findFirst();
        int weight = flavours.size() - assignedJugs.indexOf(jug.get());
        satisfaction += weight * volume;
        jug.get().pourOut(volume);

        flavourToVolume.put(jug.get().getId(), volume);
    }
}
