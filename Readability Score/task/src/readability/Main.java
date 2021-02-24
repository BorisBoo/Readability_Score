package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try (//Scanner scanner = new Scanner(new File("C:\\Users\\olehn\\IdeaProjects\\Readability Score\\Readability Score\\task\\src\\readability\\in.txt"))
            Scanner scanner = new Scanner(new File(args[0]))
        ){
            while (scanner.hasNext()){
                builder.append(scanner.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("Error! File not found");
        };

        CheckText checkText =new CheckText(builder.toString());
        checkText.check();
        System.out.println(checkText.toString());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String test = scanner.nextLine();
        System.out.println();

        NumberFormat formatter = new DecimalFormat("#0.00");

        switch (test){
            case "ARI":
                Redability aRI = new AutomatedRedabilityIndex(checkText);
                System.out.println("Automated Readability Index: " + formatter.format(aRI.getScore())
                        + " (about " + aRI.getRedability() + "-year-olds).");
                break;
            case "FK":
                Redability fKR = new FleschKincaidTests(checkText);
                System.out.println("Flesch–Kincaid readability tests: " + formatter.format(fKR.getScore())
                        + " (about " + fKR.getRedability() + "-year-olds).");
                break;
            case "SMOG":
                Redability sMOG = new SMOG(checkText);
                System.out.println("Simple Measure of Gobbledygook: " + formatter.format(sMOG.getScore())
                        + " (about " + sMOG.getRedability() + "-year-olds).");
                break;
            case "CL":
                Redability cLI = new ColemanLiauIndex(checkText);
                System.out.println("Coleman–Liau index: " + formatter.format(cLI.getScore())
                        + " (about " + cLI.getRedability() + "-year-olds).");
                break;
            case "all":
                Redability aRI1 = new AutomatedRedabilityIndex(checkText);
                System.out.println("Automated Readability Index: " + formatter.format(aRI1.getScore())
                        + " (about " + aRI1.getRedability() + "-year-olds).");
                Redability fKR1 = new FleschKincaidTests(checkText);
                System.out.println("Flesch–Kincaid readability tests: " + formatter.format(fKR1.getScore())
                        + " (about " + fKR1.getRedability() + "-year-olds).");
                Redability sMOG1 = new SMOG(checkText);
                System.out.println("Simple Measure of Gobbledygook: " + formatter.format(sMOG1.getScore())
                        + " (about " + sMOG1.getRedability() + "-year-olds).");
                Redability cLI1 = new ColemanLiauIndex(checkText);
                System.out.println("Coleman–Liau index: " + formatter.format(cLI1.getScore())
                        + " (about " + cLI1.getRedability() + "-year-olds).");
                System.out.println();
                double result = Double.parseDouble(aRI1.getRedability())
                        + Double.parseDouble(fKR1.getRedability())
                        + Double.parseDouble(sMOG1.getRedability())
                        + Double.parseDouble(cLI1.getRedability());
                result /= 4;
                System.out.println("This text should be understood in average by " + formatter.format(result) + "-year-olds.");
                break;
        }









    }
}

