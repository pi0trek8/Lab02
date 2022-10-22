package org.pwr.solution;

import org.pwr.models.PersonEntity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    private List<PersonEntity> results;
    private Integer totalSatisfaction = 0;
    private Integer totalDissatisfaction = 0;

    public List<PersonEntity> getResults() {
        return results;
    }

    public void setResults(List<PersonEntity> results) {
        this.results = results;
    }

    public void calculateSatisfaction() {
        results.forEach(personEntity -> {
                    totalSatisfaction += personEntity.getSatisfaction();
                }
        );
    }

    public void calculateTotalDissatisfaction() {
        results.forEach(personEntity -> {
                    totalDissatisfaction += personEntity.getDissatisfaction();
                }
        );
    }

    @Override
    public String toString() {

        return "Dane osoby" +
                "                        " +
                "Lista par ([id dzbanka, przydzielona ilość napoju])\n\n" +
                results.stream().sorted(Comparator.comparing(PersonEntity::getId)).map(PersonEntity::toString).collect(Collectors.joining("\n")) +
                "total satisfaction = " + totalSatisfaction +
                ", total dissatisfaction = " + totalDissatisfaction +
                "\nsatisfaction - dissatisfaction = "+ (totalSatisfaction-totalDissatisfaction);
    }
}
