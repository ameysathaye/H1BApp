package mymaxcomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyMaxComparator 
{
    public static void main(String[] args) 
    {
      List<Empy> emps = new ArrayList<Empy>();
        emps.add(new Empy(10, "Raghu", 25000));
        emps.add(new Empy(120, "Krish", 45000));
        emps.add(new Empy(210, "John", 14000));
        emps.add(new Empy(150, "Kishore", 24000));
        Empy maxSal = Collections.max(emps, new EmpyComp());
        System.out.println("Employee with max salary: "+maxSal);
    }
    
}

class EmpyComp implements Comparator<Empy>{
 
    @Override
    public int compare(Empy e1, Empy e2) {
        return e1.getSalary().compareTo(e2.getSalary());
    }
}
 
class Empy{
     
    private int id;
    private String name;
    private Integer salary;
     
    public Empy(int id, String name, Integer sal){
        this.id = id;
        this.name = name;
        this.salary = sal;
    }
     
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    @Override
    public String toString(){
        return id+"  "+name+"   "+salary;
    }
}