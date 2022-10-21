package org.pwr.problem;

import org.pwr.eto.JugEto;
import org.pwr.eto.PersonEto;

import java.util.List;

public class Problem {

    private List<PersonEto> people;

    private List<JugEto> jugs;

    public List<PersonEto> getPeople() {
        return people;
    }

    public void setPeople(List<PersonEto> people) {
        this.people = people;
    }

    public List<JugEto> getJugs() {
        return jugs;
    }

    public void setJugs(List<JugEto> jugs) {
        this.jugs = jugs;
    }
}
