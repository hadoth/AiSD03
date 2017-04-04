package utils.deansoffice;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 * Class emulates functionality of dean's office employee for the purpouse of dean's office simulation
 */
public class DeansOfficeVeryKindLady {
    private static final Format FORMATTER = new SimpleDateFormat("HH:mm:ss");
    private Student whatDoesHeWantFromMe;
    private String name;
    private Date date;
    private Date studentArrival;
    private int requiredTime;

    /**
     * Creates DeansOfficeVeryKindLady with the specified name
     * @param {String} name
     */
    public DeansOfficeVeryKindLady(String name){
        this.name = name;
    }

    /**
     * Assigns student with the issue to the employee and creates console log with the event specifics
     * @param {Student} student
     */
    public void acceptStudent(Student student){
        this.whatDoesHeWantFromMe = student;
        System.out.println(
                FORMATTER.format(this.date) +
                "\tMrs. " + this.name +
                " is helping student " +
                this.whatDoesHeWantFromMe.getIndexNumber() +
                " with the issue:");
        System.out.println("\t"+this.whatDoesHeWantFromMe.getIssue());
        this.requiredTime = this.whatDoesHeWantFromMe.getRequiredTime()*60*1000;
        this.studentArrival = new Date(this.date.getTime());
    }

    /**
     * Sets the time at which employee starts working
     * @param {Date} date
     */
    public void atWork(Date date){
        this.date = date;
    }

    /**
     * Method checks if employee is unoccupied with issue of another student
     * @return {boolean} result of this test
     */
    public boolean isAvailable(){
        return this.whatDoesHeWantFromMe == null;
    }

    /**
     * @return {String} name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Informs the employee about current time and triggers employee actions: fixing of student's issue and asking him
     * when the case is done
     * @param {Date} date current time
     */
    public void update(Date date) {
        this.date = date;
        if (!this.isAvailable()){
            if((this.date.getTime() - this.studentArrival.getTime()) >= this.requiredTime){
                System.out.println(FORMATTER.format(this.date) +
                        "\tStudent " +
                        this.whatDoesHeWantFromMe.getIndexNumber() +
                        " has been dealt with.");
                this.askStudentOut();
            }
        }
    }

    /**
     * Method removes the student from dean's office employee and returns it
     * @return {Student} student which issue has been dealt with
     */
    public Student askStudentOut(){
        Student result = this.whatDoesHeWantFromMe;
        this.whatDoesHeWantFromMe = null;
        this.studentArrival = null;
        this.requiredTime = -1;
        return result;
    }
}