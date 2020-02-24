package Person;
public class Person {
    String first;
    String last;
    String[] phone;
    String email;
    Person next;
    char priority;

    Person(String first, String last, String[] phone, String email) {
        this.first = first.toUpperCase();
        this.last = last.toUpperCase();
        this.phone = phone;
        this.email = email.toLowerCase();
        priority = (char) first.toUpperCase().charAt(0);
        next = null;

    }
}