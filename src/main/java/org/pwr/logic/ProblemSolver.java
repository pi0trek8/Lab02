package org.pwr.logic;

import org.pwr.eto.JugEto;
import org.pwr.eto.PersonEto;
import org.pwr.models.Flavour;
import org.pwr.models.PersonEntity;
import org.pwr.problem.Problem;
import org.pwr.solution.Solution;

import java.util.*;
import java.util.stream.Collectors;

public class ProblemSolver {
    public static Solution solve(Problem problem) {

        var people = problem.getPeople();

        var jugs = problem.getJugs();

        var sortedPeopleByAmountOfPreferences = sortByPreferencesLength(people);

        List<PersonEntity> personEntities = new ArrayList<>();

        for (var person : sortedPeopleByAmountOfPreferences) {
            PersonEntity personEntity = new PersonEntity(person);
            personEntities.add(personEntity);
        }

        for (var person : personEntities) {
            int favouriteFlavour = person.getFlavours().get(0);

            var jug = jugs.stream()
                    .filter(element -> element.getFlavour() == favouriteFlavour)
                    .max(Comparator.comparing(JugEto::getVolume));

            if (jug.isPresent()) {
                JugEto currentJug = jug.get();
                if (currentJug.getVolume() >= 400) {
                    person.addToMap(currentJug.getId(), 400, currentJug.getFlavour());
                    currentJug.pourOut(400);
                } else {
                    person.addToMap(currentJug.getId(), currentJug.getVolume(), currentJug.getFlavour());
                    currentJug.pourOut(currentJug.getVolume());
                    jugs.remove(currentJug);
                }
                person.assignJug(currentJug);
                currentJug.assignPerson(person);
            }
        }

        for (PersonEntity person : personEntities) {
            List<Integer> personsJugs = person.getAssignedJugs().stream()
                    .map(JugEto::getFlavour)
                    .collect(Collectors.toList());

            for (Integer flavour : person.getFlavours()) {
                List<JugEto> correctFlavourJugs = jugs.stream()
                        .filter(juice -> juice.getFlavour().equals(flavour))
                        .collect(Collectors.toList());


                if (!personsJugs.contains(flavour)) {
                    Optional<JugEto> jug = findBestJug(correctFlavourJugs, person);
                    if (jug.isPresent() && !person.getAssignedJugs().contains(jug.get())) {
                        person.assignJug(jug.get());
                        jug.get().assignPerson(person);
                    }
                }
            }
        }

        List<JugEto> usedJugs = jugs.stream()
                .filter(jug -> jug.getNumberOfAssignedPeople() > 0)
                .collect(Collectors.toList());

        for (JugEto jug : usedJugs) {
            int weight = getFlavourWeight(jug);

            int portion = jug.getVolume() / weight;
            jug.setPortion(portion);
        }


        for (JugEto jug : usedJugs) {
            for (PersonEntity person : jug.getPeople()) {
                int weight = person.getFlavours().size() - person.getFlavours().indexOf(jug.getFlavour());

                person.pour(jug.getFlavour(), jug.getPortion() * weight);
            }
        }


        Solution solution = new Solution();
        solution.setPeopleResult(personEntities);
        solution.calculateSatisfaction();
        solution.calculateTotalDissatisfaction();

        System.out.println(jugs);

        return solution;
    }

    private static Optional<JugEto> findBestJug(List<JugEto> filteredJugs, PersonEntity person) {
        Optional<JugEto> jugOptional = filteredJugs.stream()
                .filter(juice -> juice.getNumberOfAssignedPeople() == 0)
                .max(Comparator.comparing(JugEto::getVolume));

        if (jugOptional.isPresent()) {
            return jugOptional;
        }
        jugOptional = filteredJugs.stream()
                .max(Comparator.comparing(juice -> juice.getVolume() / juice.getNumberOfAssignedPeople()));

        return jugOptional;
    }

    private static List<PersonEto> sortByPreferencesLength(List<PersonEto> people) {
        return people.stream()
                .sorted(Comparator.comparing(PersonEto::getNumberOfPreferences).reversed())
                .collect(Collectors.toList());
    }

    private static Map<Integer, List<JugEto>> countSameFlavours(Set<Flavour> flavours, List<JugEto> jugs) {
        Map<Integer, List<JugEto>> flavourIdToJugs = new HashMap<>();

        for (var flavour : flavours) {
            var specificFlavourJugs = jugs.stream()
                    .filter(jug -> jug.getFlavour().equals(flavour.getFlavourId()))
                    .collect(Collectors.toList());

            flavourIdToJugs.put(flavour.getFlavourId(), specificFlavourJugs);
        }
        return flavourIdToJugs;
    }

    private static int getFlavourWeight(JugEto jug) {
        int weight = 0;
        for (PersonEntity person : jug.getPeople()) {
            weight += (person.getFlavours().size() - person.getFlavours().indexOf(jug.getFlavour()));
        }
        return weight;
    }
}
