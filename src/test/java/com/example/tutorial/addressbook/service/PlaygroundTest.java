package com.example.tutorial.addressbook.service;

import com.example.tutorial.addressbook.domain.AddressBook;
import com.example.tutorial.addressbook.domain.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaygroundTest {

    @Test
    public void personTest() {
        Person person = Person.newBuilder()
            .setId(1234)
            .setName("TestUser")
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

        assertEquals(1234, person.getId());
        assertEquals("TestUser", person.getName());
        assertEquals("test@gmail.com", person.getEmail());
        assertEquals("010-1234-1234", person.getPhones(0).getNumber());
        assertEquals(Person.PhoneType.MOBILE, person.getPhones(0).getType());
        assertEquals("070-1234-1234", person.getPhones(1).getNumber());
        assertEquals(Person.PhoneType.HOME, person.getPhones(1).getType());
    }

    @Test
    public void addressBookTest() {
        Person person = Person.newBuilder()
            .setId(1234)
            .setName("TestUser")
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

        AddressBook addressBook = AddressBook.newBuilder()
            .addPeople(person)
            .build();

        assertEquals(1, addressBook.getPeopleCount());
        assertEquals(person.getId(), addressBook.getPeople(0).getId());
        assertEquals(person.getName(), addressBook.getPeople(0).getName());
        assertEquals(person.getEmail(), addressBook.getPeople(0).getEmail());
    }

}