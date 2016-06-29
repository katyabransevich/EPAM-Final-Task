package by.epam.finaltask.facultative.entity;


public class CourseDescription {
    private  int id;
    private String courseName;
    private User teacher;
    private String time;
    private int numberOfStudent;
    private int numberOfCurrentStudent;
    private String startCourse;
    private String endCourse;
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }




    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public int getNumberOfCurrentStudent() {
        return numberOfCurrentStudent;
    }

    public void setNumberOfCurrentStudent(int numberOfCurrentStudent) {
        this.numberOfCurrentStudent = numberOfCurrentStudent;
    }




    public String getEndCourse() {
        return endCourse;
    }

    public void setEndCourse(String endCourse) {
        this.endCourse = endCourse;
    }

    public String getStartCourse() {
        return startCourse;
    }

    public void setStartCourse(String startCourse) {
        this.startCourse = startCourse;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
