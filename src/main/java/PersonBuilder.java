

import java.util.OptionalInt;

public class PersonBuilder {

    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public boolean hasAge() {
        return this.age.isPresent();
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public PersonBuilder() {
    }

    public PersonBuilder(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }


    public PersonBuilder setName(String name) {
        if ("".equals(name)) throw new NullFIOException("имя");
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if ("".equals(surname)) throw new NullFIOException("фамилия");
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) throw new ZeroAgeException("возраст");
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {

        this.address = address;
        return this;
    }

    public class ZeroAgeException extends IllegalArgumentException{
        public ZeroAgeException(String s) {

            super(String.format("Значение %s не должно быть отрицательным", s));
        }
    }



    public class NullFIOException extends IllegalStateException {
        public NullFIOException(String s) {
            super(String.format("Значение %s не должно быть пустым ", s));

        }
    }

    public Person build() {
        if (name == null || surname == null || age == null || address == null)
            throw new NullPointerException();
        return new Person(name, surname, age, address);
    }
}