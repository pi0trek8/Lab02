package org.pwr;

import org.pwr.problem.Problem;
import org.pwr.logic.ProblemSolver;
import org.pwr.service.FileService;
import org.pwr.service.impl.FileServiceImpl;

public class Main {
    public static void main(String[] args) {
        String fileToJugs = "src/main/resources/jugs.txt";
        String fileToPeople = "src/main/resources/people.txt";
        String resultFile = "src/main/resources/result.txt";

        FileService service = new FileServiceImpl();
        Problem problem = new Problem();
        problem.setJugs(service.getJugs(fileToJugs));
        problem.setPeople(service.getPeople(fileToPeople));

        var solution = ProblemSolver.solve(problem);
        String solutionString = solution.toString();
        System.out.println(solutionString);

        service.saveResults(resultFile, solutionString);
    }
}