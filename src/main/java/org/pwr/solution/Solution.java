package org.pwr.solution;

import org.pwr.models.PersonEntity;

import java.util.List;

public class Solution {

    List<PersonEntity> peopleResult;
    Integer totalSatisfaction = 0;
    Integer totalDissatisfaction = 0;

    public List<PersonEntity> getPeopleResult() {
        return peopleResult;
    }

    public void setPeopleResult(List<PersonEntity> peopleResult) {
        this.peopleResult = peopleResult;
    }

    public void calculateSatisfaction() {
        peopleResult.forEach(personEntity -> {
                    totalSatisfaction += personEntity.getSatisfaction();
                }
        );
    }

    public void calculateTotalDissatisfaction() {
        peopleResult.forEach(personEntity -> {
                    totalDissatisfaction += personEntity.getDissatisfaction();
                }
        );
    }

    @Override
    public String toString() {
        return "Solution{" +
                "peopleResult=" + peopleResult +
                ", totalSatisfaction=" + totalSatisfaction +
                ", totalDissatisfaction=" + totalDissatisfaction + '}' +
                ",\n\n satisfaction - dissatisfaction = "+ (totalSatisfaction-totalDissatisfaction);
    }
}
