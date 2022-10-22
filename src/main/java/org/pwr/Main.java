/**
 * @author Piotr Szczypior 26648
 *
 * @jar - using maven build tool
 * mvn package
 *
 * @run-jar
 * java -jar lab02_pop.jar
 *
 * @comment
 * Apart from printing the result to console,
 * program will additionally save result into lab02Result.txt file in the same directory as jar
 */
package org.pwr;

import org.pwr.problem.Problem;
import org.pwr.logic.ProblemSolver;
import org.pwr.service.FileService;
import org.pwr.service.impl.FileServiceImpl;

public class Main {
    public static void main(String[] args) {
        String fileToJugs = "/jugs.txt";
        String fileToPeople = "/people.txt";
        var currentJarLocation = System.getProperty("user.dir");
        String resultFile = currentJarLocation + "/Lab02Result.txt";

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