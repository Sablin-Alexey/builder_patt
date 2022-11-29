import java.util.Objects;
import java.util.OptionalInt;


public class Person {


    protected String name;
    protected String surname;
    String address;
    int age;


    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Person(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }


    public boolean hasAge() {
        if (age == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasAddress() {
        if (address == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return  name;
    }

    public String getSurname() {
        return  surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;

    }

    public void happyBirthday() {
        age++;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAddress(), getAge());
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }


    public PersonBuilder newChildBuilder() {
        return new PersonBuilder();
    }
}


