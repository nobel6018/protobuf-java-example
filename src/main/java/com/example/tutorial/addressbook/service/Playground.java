package com.example.tutorial.addressbook.service;

import com.example.tutorial.addressbook.domain.AddressBook;
import com.example.tutorial.addressbook.domain.Person;

public class Playground {
    public static void main(String[] args) {
        Person person = Person.newBuilder()
            .setId(1)
            .setName("Lee,YoungHoon")
            .setEmail("test@gmail.com")
            .addPhones(
                Person.PhoneNumber.newBuilder()
                    .setNumber("010-1234-1234")
                    .setType(Person.PhoneType.MOBILE)
            )
            .addPhones(
                Person.PhoneNumber.newBuilder()
                    .setNumber("070-1234-1234")
                    .setType(Person.PhoneType.HOME)
            )
            .build();

        System.out.println("person.getName() = " + person.getName());
        for (Person.PhoneNumber phone : person.getPhonesList()) {
            System.out.println("phone = " + phone);
        }

        AddressBook addressBook = AddressBook.newBuilder()
            .addPeople(person)
            .build();

        System.out.println(addressBook);
    }
}
