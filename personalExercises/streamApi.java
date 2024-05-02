package personalExercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class streamApi {

    public static class Person{
        String name;
        Integer age;
        public Person(String name, Integer age){
             this.name=name;
             this.age=age;
         }

    }

    public static void main(String[] args) {

        List<Person> students= Arrays.asList(

                new Person("mugabo",18),
                new Person("Ayabagabo",28),
                new Person("Uwamahoro",12),
                new Person("sebatware",54),
                new Person("semugabo",12),
                new Person("uwiteka",44),
                new Person("Louis",54),
                new Person("rukundo",4),
                new Person("mendy",9),
                new Person("ishimwe",2)
        );
        List<Person> filterd=
        students.stream()
                .filter(person -> person.age<=10)
                .toList();
    filterd.forEach(student->System.out.println(student.name+student.age));

        students.forEach(student->System.out.println("name:"+student.name+","+"age"+student.age));

    }

}
