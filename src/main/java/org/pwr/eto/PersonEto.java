package org.pwr.eto;


import java.util.ArrayList;
import java.util.List;

public class PersonEto {

    private final long id;
    private final List<Integer> flavourPreferencesList;

    private final List<JugEto> assignedJugs = new ArrayList<>();

    public PersonEto(long id, List<Integer> flavourPreferencesList) {
        this.id = id;
        this.flavourPreferencesList = flavourPreferencesList;
    }

    public long getId() {
        return id;
    }

    public List<Integer> getFlavourPreferencesList() {
        return flavourPreferencesList;
    }

    public int getNumberOfPreferences() {
        return flavourPreferencesList.size();
    }

    public void assignJug(JugEto jug) {
        this.assignedJugs.add(jug);
    }

    public List<JugEto> getAssignedJugs() {
        return assignedJugs;
    }

//    @Override
//    public String toString() {
//        return "PersonEto{" +
//                "id=" + id +
//                ", flavourPreferencesList=" + flavourPreferencesList.stream().map(String::valueOf)
//                .collect(Collectors.joining(",", "{", "}"))+
//                '}';
//    }

    @Override
    public String toString() {
        return "PersonEto{" +
                "id=" + id +
                ", flavourPreferencesList=" + flavourPreferencesList +
                ", assignedJugs=" + assignedJugs +
                '}';
    }


    //    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", flavourPreferencesList=" +
//                flavourPreferencesList.stream()
//                        .map(flavour -> String.valueOf(flavour.getFlavourId()))
//                        .collect(Collectors.joining(",", "{", "}"))+'}';
//    }



}
