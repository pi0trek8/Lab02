package org.pwr;

import org.pwr.problem.Problem;
import org.pwr.logic.ProblemSolver;
import org.pwr.service.FileService;
import org.pwr.service.impl.FileServiceImpl;

public class Main {
    public static void main(String[] args) {
        String fileToJugs = "src/jugs.txt";
        String fileToPeople = "src/people.txt";

        FileService service = new FileServiceImpl();
//        service.getJugs(fileToJugs).forEach(System.out::println);
//        System.out.println("------------------------------");
//        service.getPeople(fileToPeople).forEach(System.out::println);

//        var list = ProblemSolver.sortByPreferencesLength(service.getPeople(fileToPeople));

//        list.forEach(System.out::println);
        Problem problem = new Problem();
        problem.setJugs(service.getJugs(fileToJugs));
        problem.setPeople(service.getPeople(fileToPeople));

        var solution = ProblemSolver.solve(problem);

        System.out.println(solution);
    }
}