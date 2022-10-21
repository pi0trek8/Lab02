package org.pwr.models;

import org.pwr.common.Jug;
import org.pwr.eto.JugEto;
import org.pwr.eto.PersonEto;

import java.util.*;
import java.util.stream.Collectors;

public class PersonEntity {
    private long id;
    private List<Integer> flavours;
    private int satisfaction;
    private int dissatisfaction;
    private final Map<Long, Integer> jugIdToVolume = new HashMap<>();
    private final List<JugEto> assignedJugs = new ArrayList<>();

    public PersonEntity(PersonEto personEto) {
        this.id = personEto.getId();
        this.flavours = personEto.getFlavourPreferencesList();
        satisfaction = 0;
        dissatisfaction = 400;
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

    public void minimizeDissatisfaction(Long jugId, Integer volume, Integer flavour) {
        int weight = flavours.size() - flavours.indexOf(flavour);
        satisfaction += weight * volume;
        dissatisfaction = Math.max(400 - volume, 0);
        jugIdToVolume.put(jugId, volume );
    }

    public void pour(Integer flavour, int volume) {
        var jug = this.assignedJugs.stream()
                        .filter(juice -> Objects.equals(juice.getFlavour(), flavour))
                        .findFirst()
                        .get();

        int weight = flavours.size() - flavours.indexOf(jug.getFlavour());
        satisfaction += weight * volume;
        jug.pourOut(volume);

        if (jugIdToVolume.containsKey(jug.getId())) {
            int addedVolume = jugIdToVolume.get(jug.getId());
            volume += addedVolume;
        }
        jugIdToVolume.put(jug.getId(), volume);
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", flavours=" + flavours +
                ", satisfaction=" + satisfaction +
                ", dissatisfaction=" + dissatisfaction +
                ",\n assignedJugs=" + assignedJugs.stream().map(JugEto::toString).collect(Collectors.toList()) +
                "flavourToVolume = " + jugIdToVolume +
                "}\n\n\n\n";
    }
}
