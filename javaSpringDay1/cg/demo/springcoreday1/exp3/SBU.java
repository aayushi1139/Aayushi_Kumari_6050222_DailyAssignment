package cg.demo.springcoreday1.exp3;
import java.util.List;

public class SBU {

    private int sbuCode;
    private String sbuName;
    private String sbuHead;

    private List<Employee> empList;

    public SBU() {}

    public int getSbuCode() {
        return sbuCode;
    }

    public void setSbuCode(int sbuCode) {
        this.sbuCode = sbuCode;
    }

    public String getSbuName() {
        return sbuName;
    }

    public void setSbuName(String sbuName) {
        this.sbuName = sbuName;
    }

    public String getSbuHead() {
        return sbuHead;
    }

    public void setSbuHead(String sbuHead) {
        this.sbuHead = sbuHead;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public void display() {

        System.out.println("SBU details");
        System.out.println("sbuCode=" + sbuCode +
                ", sbuHead=" + sbuHead +
                ", sbuName=" + sbuName);

        System.out.println("Employee details:");

        for (Employee e : empList) {
            System.out.println(e);
        }
    }
}
