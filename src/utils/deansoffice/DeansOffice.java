package utils.deansoffice;

import interfaces.IteratorInterface;
import utils.FifoQueue;
import utils.MyList;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 * Class simulates basic functionality of dean's office in regards to accepting students with their
 * day-to-day issues
 */
public class DeansOffice {
    private static final Format FORMATTER = new SimpleDateFormat("HH:mm:ss");
    private MyList<DeansOfficeVeryKindLady> employees;
    IteratorInterface<DeansOfficeVeryKindLady> employeesIterable;
    private FifoQueue<Student> waitingList;
    private Date openTime;
    private Date closeTime;
    private Date currentTime;

    /**
     * @param {Date} openTime opening hour of the dean's office
     * @param {Date} closeTime closing hour of the dean's office
     */
    public DeansOffice(Date openTime, Date closeTime){
        this.employees = new MyList<>();
        this.employeesIterable = this.employees.iterator();
        this.waitingList = new FifoQueue<>();
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    /**
     * Method adds employee to the employee list
     * @param {DeansOfficeVeryKindLady} employee
     */
    public void addEmployee(DeansOfficeVeryKindLady employee){
        employee.atWork(this.openTime);
        this.employees.add(employee);
    }

    /**
     * Method starts the day of dean's office operation and iterates over time adding new students to the queue and
     * assigning them to the unoccupied employee
     */
    public void openDeansOffice(){
        this.currentTime = new Date(this.openTime.getTime());
        while (this.currentTime.before(this.closeTime)){
            if (Math.random() > 0.8) {
                Student newStudent = Student.studentArrives();
                System.out.println(
                        FORMATTER.format(this.currentTime) +
                        "\tStudent " +
                        newStudent.getIndexNumber() +
                        " arrives in the deans office"
                );
                waitingList.push(newStudent);
            }
            this.assignStudent();
            this.notifyEmployees();
            this.currentTime.setTime(this.currentTime.getTime() + 60*1000);
        }
        while(!this.waitingList.isEmpty()) System.out.println(
                FORMATTER.format(this.currentTime) +
                "\tStudent " +
                this.waitingList.pop().getIndexNumber() +
                " was to late and returns home with nothing"
        );
        this.employeesIterable.first();
        while(!this.employeesIterable.isDone()){
            if (!this.employeesIterable.current().isAvailable()) {
                System.out.println(
                        FORMATTER.format(this.currentTime) +
                        "\tMrs. " +
                        this.employeesIterable.current().getName() +
                        " was not able to finish the case of student " +
                        this.employeesIterable.current().askStudentOut().getIndexNumber() +
                        " in time. Hopefully tomorrow she will succeed");
            }
            this.employeesIterable.next();
        }
    }

    /**
     * Informs employees about the current time
     */
    public void notifyEmployees() {
        this.employeesIterable.first();
        while(!this.employeesIterable.isDone()){
            this.employeesIterable.current().update(this.currentTime);
            this.employeesIterable.next();
        }
    }

    /**
     * Assigns first student in the queue to the first unoccupied employee
     */
    public void assignStudent(){
        this.employeesIterable.first();
        while (!employeesIterable.isDone() && !this.waitingList.isEmpty()){
            if (this.employeesIterable.current().isAvailable())
                this.employeesIterable.current().acceptStudent(this.waitingList.pop());
            this.employeesIterable.next();
        }
    }
}