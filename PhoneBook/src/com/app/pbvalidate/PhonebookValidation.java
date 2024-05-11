package com.app.pbvalidate;

import java.util.List;

import javax.crypto.spec.PBEKeySpec;

import com.app.phonebook.PhoneBook;
import com.contact.Contact;
import com.pbexception.PBException;

public class PhonebookValidation {
	public void displayAll(PhoneBook phoneBook) {
		System.out.println("All contacts:");
		for (Contact contact : phoneBook.getAllContacts()) {
			System.out.println(contact.getName() + " - " + contact.getPhoneNumber() + " - " + contact.getEmail());
		}
	}

	public void checkContact(long contact) throws PBException {
		
		if (String.valueOf(contact).length()!=10) {
			throw new PBException("Enter 10-digit Number!!");
		}
	}

	public void sortContacts(PhoneBook phoneBook) {
		phoneBook.sortContactsByName();
		System.out.println("Contacts sorted by name:");
		displayAll(phoneBook);
	}

	public void removeContact(PhoneBook phoneBook, String name) {
		List<Contact> contacts = phoneBook.getAllContacts();
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				phoneBook.removeContact(contact);
				System.out.println("Contact '" + name + "' removed.");
				return;
			}
		}
		System.out.println("Contact '" + name + "' not found.");
	}

	public long updateContact(PhoneBook phoneBook, long number, long newno) throws PBException {
		List<Contact> contacts = phoneBook.getAllContacts();
		for (Contact contact : contacts) {
			if (contact.getPhoneNumber() != number) {
			throw new PBException("Contact Not Found!!");
			}
		}
		return newno;
	}
}
