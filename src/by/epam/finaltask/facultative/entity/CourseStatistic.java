package by.epam.finaltask.facultative.entity;

/**
 * Created by Admin on 27.05.2016.
 */
public class CourseStatistic {
    private User student;
    private CourseDescription subject;
    private int mark;
    private String comment;




    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if (mark>=0&&mark<=10) {
            this.mark = mark;
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CourseDescription getSubject() {
        return subject;
    }

    public void setSubject(CourseDescription subject) {
        this.subject = subject;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }
}
