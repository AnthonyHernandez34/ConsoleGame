package oop;

public class Overriding {

    public static void main(String[] args) {
        //why override?

        // overloading vs overriding
        // overload: change the method's signature; also can change the method body (the actual code)

        // overriding: changing the code of an inherited method
        Person person = new Person();
        person.setName("Casey");
        person.setDateOfBirth("11-30-1989");

        System.out.println(person.toString());
    }
}
