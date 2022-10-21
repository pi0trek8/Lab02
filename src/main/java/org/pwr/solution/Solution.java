package org.pwr.solution;

import org.pwr.models.PersonEntity;

import java.util.List;

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
        return "Solution{" +
                "peopleResult=" + results +
                ", totalSatisfaction=" + totalSatisfaction +
                ", totalDissatisfaction=" + totalDissatisfaction + '}' +
                ",\n\n satisfaction - dissatisfaction = "+ (totalSatisfaction-totalDissatisfaction);
    }
}
