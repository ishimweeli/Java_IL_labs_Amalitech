package week1_IL_labs;

public class InnerClass {
    private String schoolName;
    private int year;
    Students[] students;

    private InnerClass(String schoolName,int year, int students){
        this.schoolName=schoolName;
        this.year=year;
        this.students=new Students[students];
    }

    private class Students{
       String name;
       int age;
       String grade;
        public Students( String name,int age,String grade){
          this.name=name;
            this.age=age;
            this.grade=grade;
        }
        public void printStudentInfo() {
            System.out.println("name:"+name);
            System.out.println("age:"+age);
            System.out.println("grade:"+grade);
        }
    }



    public static void main(String[] args) {

        InnerClass school=new InnerClass("GS ifs",2024,90);

       InnerClass.Students student1=school.new Students("kagabo",2023,"S5");
        InnerClass.Students student2=school.new Students("kagabo",2023,"S5");
    student2.printStudentInfo();
    student1.printStudentInfo();
    }

}
