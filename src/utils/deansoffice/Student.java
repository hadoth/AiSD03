package utils.deansoffice;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 * Class emulates student behavior in the student - dean's office interactions
 */
public class Student {
    private static final String[] typicalIssues = {
            "doesn't know",
            "wants to be added to group",
            "failed semester",
            "applies for scholarship",
            "came in by mistake",
            "there was a queue so there must be something important here",
            "recruits"
    };
    private static final int averageRequiredTime = 15;
    private static int index = 162503;
    private String issue;
    private int requiredTime;
    private int indexNumber;

    private Student(String issue, int requiredTime, int indexNumber){
        this.indexNumber = indexNumber;
        this.issue = issue;
        this.requiredTime = requiredTime;
    }

    /**
     * @return {int} time required to fix Student's issue in minutes
     */
    public int getRequiredTime() {
        return requiredTime;
    }

    /**
     * @return {String} type of issue which made student come to the dean's office
     */
    public String getIssue() {
        return issue;
    }

    /**
     * @return {int} indexNumber of the Student
     */
    public int getIndexNumber() {
        return indexNumber;
    }

    /**
     * Method automatically generates student with randomized issue and time required to fix it
     * @return {Student} ne randomized student
     */
    public static Student studentArrives(){
        String issue = typicalIssues[(int)(Math.random()*typicalIssues.length)];
        int requiredTime = (int)(Math.random()*averageRequiredTime*2);
        return new Student(issue, requiredTime, index++);
    }

    /**
     * @return {String} description of the student consisting of index number and the issue
     */
    public String toString(){
        return this.getIndexNumber() + ": " + this.issue;
    }
}
