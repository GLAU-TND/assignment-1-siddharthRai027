package Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Methods {
    Scanner sc;
    Person p;
    Person front;
    Person rear;

    Methods() {
        sc = new Scanner(System.in);
        p = null;
        front = null;
        rear = null;
    }

    public int menu() {
        int choice = 0;
        System.out.println("Welcome to DBC's Contact List App\n" +
                "Press 1 to add a new contact\n" +
                "Press 2 to view all contacts\n" +
                "Press 3 to search for a contact\n" +
                "Press 4 to delete a contact\n" +
                "Press 5 to exit program ");
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException E) {
            System.out.println("Invalid Choice");
            System.exit(-1);
        }
        return choice;

    }

    private boolean selection() {

        char c = sc.next().charAt(0);
        if (c == 'Y' || c == 'y') {
            return true;
        } else if (c == 'N' || c == 'n') {
            return false;
        } else {
            return false;
        }
    }


    private Person addContact() {
        String choice = null;
        String phone[] = new String[10];
        int i = 0;
        String email = null;
        String first = null;
        String last = null;

        System.out.println("First Name : ");
        first = sc.next();
        System.out.println("Last Name : ");
        last = sc.next();

        do {
            System.out.print("Phone number : ");
            phone[i] = sc.next();
            System.out.print("Would you like to add another contact number? (y/n)");
            i++;
        }
        while (selection());

        System.out.print("Would you like to add email address? (y/n)");
        if (selection())
            email = sc.next();

        p = new Person(first, last, phone, email);

        return p;
    }


    public void insert() {
        int f = 0;
        Person p = addContact();

        if (front == null || p.priority < front.priority) {
            p.next = front;
            front = p;
        } else {
            Person temp = front;

            while (temp.next != null && temp.next.priority <= p.priority) {
                temp = temp.next;
            }
            p.next = temp.next;
            temp.next = p;
        }
    }


    public void displayAll() {
        Person temp = front;
        System.out.println("---Here are all your contacts---");
        while (temp != null) {
            int ctr = 0;
            int i = 0;

            System.out.println("-------- * -------- * -------- * --------");

            System.out.println("First Name :" + temp.first);
            System.out.println("Last Name:" + temp.last);
            while (temp.phone[i] != null) {
                ctr++;
                i++;
            }
            i = 0;
            if (ctr == 1) {
                System.out.println("Contact Number:" + temp.phone[0]);
                break;
            } else {
                System.out.print("Contact Number(s):");
                while (temp.phone[i] != null) {
                    System.out.print(temp.phone[i] + ", ");
                    i++;
                }
                System.out.println("\b");

            }
            System.out.println("Email address:" + temp.email);
            temp = temp.next;
        }
    }

    public void search() {
        System.out.println("write the first name to search contact");
        String search = sc.next();
        Person temp = front;
        int ctr = 0;
        while (temp != null) {
            if (temp.first.equals(search)) {
                ctr++;
            }
            temp = temp.next;
        }
        temp = front;
        System.out.println(ctr + "matches found!");
        while (temp != null) {
            if (temp.first.equals(search)) {
                System.out.println("First Name: " + temp.first);
                System.out.println("last Name: " + temp.last);
                if (temp.phone[1] != null) {
                    System.out.print("Contact Number(s): ");
                } else {
                    System.out.print("Contact Number: ");
                }
                for (String i : temp.phone) {
                    if (i != null)
                        System.out.println(i + ",");
                }
                System.out.println("\b");
                System.out.println("Email Address" + temp.email);
            } else
                temp = temp.next;
            break;

        }
    }

    public void delete() {
        int i = 0;
        Person temp = front;
        while (temp != null) {
            i++;
            System.out.println(i + ". " + temp.first + " " + temp.last);
            temp = temp.next;
        }
        System.out.println("Press the number against contact to delete");
        int pos = sc.nextInt();
        temp = front;
        if (pos == 1) {
            System.out.println("Deleteing Contact" + front.first + " front.last");
            front = temp.next;
            temp = front;
            return;
        }
        if (pos == 2) {
            System.out.println("Deleting Contact" + temp.first + " " + temp.last);
            temp.next = temp.next.next;
            return;
        }
        for (i = 1; i <= pos - 2; i++) {
            temp = temp.next;
            if (i == pos - 2) {
                System.out.println("Deleting Contact" + temp.first + " " + temp.last);
                temp.next = temp.next.next;
                return;
            }
        }
    }


    public void exit() {
        System.out.println("Exitting .......");
        System.exit(0);
    }


}