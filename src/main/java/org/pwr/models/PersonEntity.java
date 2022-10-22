package org.pwr.models;

import org.pwr.eto.JugEto;
import org.pwr.eto.PersonEto;

import java.util.*;
import java.util.stream.Collectors;

public class PersonEntity {
    private final long id;
    private final List<Integer> flavours;
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

    public int getSatisfaction() {
        return satisfaction;
    }

    public int getDissatisfaction() {
        return dissatisfaction;
    }


    public List<Integer> getFlavours() {
        return flavours;
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
        jugIdToVolume.put(jugId, volume);
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
        return "Person {" +
                "id = " + id + "                    " +
                jugIdToVolume.entrySet()
                        .stream()
                        .map(e ->"[" +e.getKey() + ", " + e.getValue() + "]")
                        .collect(Collectors.joining( ", ", "(", ")")) +
                "\nflavours = " + flavours +
                "\nsatisfaction = " + satisfaction +
                "\ndissatisfaction = " +
                dissatisfaction  + "}" +

                "\n\n";
    }
}
