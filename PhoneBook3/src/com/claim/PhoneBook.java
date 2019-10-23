package com.claim;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook
{
	
	public static Person[] persons = new Person[0];

	private static int choice = 0;
	private static int uchoice = 0;
	private static int schoice = 0;
	private static String updatedString = "";
	private static Scanner scannerint = new Scanner(System.in);
	private static Scanner scannerline = new Scanner(System.in);

	public static void main(String[] args)
	{
		loadArrayFromFile();
		TopMenuLoop();
		saveArrayToFile();

	}

	public static void TopMenuLoop()
	{

		System.out.println("Welcome to your Phone Book!");

		do
		{
			System.out.println("Please select from the following activities:");

			System.out.println("1 to Add a Person\n" + "2 to Delete a Person\n" + "3 to Update a Person\n"
					+ "4 to Search Phonebook\n"  + "8 to Show All Persons\n" + "9 to Exit");
			//+ "5 to Add 3 Test Cases to Phonebook\n" + "6 to Save File \n" + "7 to Load Array from File \n"

			choice = scannerint.nextInt();
			TopMenuActivity(choice);

		} while (choice != 9);

		System.out.println("Exited Program, Thank you!");
	}

	public static void TopMenuActivity(int key)
	{
		int arrayposition = -1;
		switch (key)
		{
		case 1:// Add
			System.out.println(" ");
			Person person = new Person(AskforAddUserString());
			copyandexpandpersons(person);
			System.out.println(" ");
			break;
		case 2:// Delete
			arrayposition = SelectPersonFromPhoneBook();
			DeletePersonFromPhoneBook(arrayposition);
			saveArrayToFile();
			break;
		case 3:// Update
			arrayposition = SelectPersonFromPhoneBook();
			UpdateMenuLoop(arrayposition);
			break;
		case 4:// Search
			SearchMenuLoop(arrayposition);
			break;
//		case 5:// Add 3 sample Person
//			Person person1 = new Person("John Doe, 114 Market St, St Louis, MO, 63403, 6366435698");
//			copyandexpandpersons(person1);
//			Person person2 = new Person("John E Doe, 324 Main St, St Charles, MO,63303, 8475390126");
//			copyandexpandpersons(person2);
//			Person person3 = new Person("John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375");
//			copyandexpandpersons(person3);
//			break;
//		case 6:// SaveFile
//			saveArrayToFile();
//			break;
//		case 7:// SaveFile
//			loadArrayFromFile();
//			break;
		case 8:// Display
			ShowAllPersons();
			break;

		case 9:// Exit

			break;

		default:
			System.out.println("Your selection is invald, please try again...");
		}

	}

	public static void UpdateMenuLoop(int arrayposition)
	{

		do
		{
			System.out.println("Please select from the following activities:");

			System.out.println("1 to Update the Person's First Name\n" + "2 to Update the Person's Middle Name\n"
					+ "3 to Update the Person's Last Name\n" + "4 to Update the Person's Telephone Number\n"
					+ "5 to Update the Person's Street\n" + "6 to Update the Person's City\n"
					+ "7 to Update the Person's State\n" + "8 to Update the Person's Zip Code\n"
					+ "9 to Exit the Person's Update Menu");

			uchoice = scannerint.nextInt();
			UpdateMenuActivity(uchoice, arrayposition);

		} while (uchoice != 9);

		System.out.println("Exiting Update Menu, Thank you!");
	}

	public static void UpdateMenuActivity(int key, int arrayposition)
	{

		switch (key)
		{
		case 1:// Update First Name
			System.out.println(" ");
			String updatedString = AskForNewUpdateString();
			persons[arrayposition].setFname(updatedString);
			System.out.println(" ");
			System.out.println(persons[arrayposition].toString());
			saveArrayToFile();
			break;
		case 2:// Update Middle Name
			System.out.println(" ");
			updatedString = AskForNewUpdateString();
			persons[arrayposition].setMname(updatedString);
			System.out.println(" ");
			System.out.println(persons[arrayposition].toString());
			saveArrayToFile();
			break;
		case 3:// Update Last Name
			System.out.println(" ");
			updatedString = AskForNewUpdateString();
			persons[arrayposition].setLname(updatedString);
			System.out.println(" ");
			System.out.println(persons[arrayposition].toString());
			saveArrayToFile();
			break;
		case 4:// Update Telephone Number
			System.out.println(" ");
			updatedString = AskForNewUpdateString();
			persons[arrayposition].setTelephone(updatedString);
			System.out.println(" ");
			System.out.println(persons[arrayposition].toString());
			saveArrayToFile();
			break;
		case 5:// Update Street
			System.out.println(" ");
			updatedString = AskForNewUpdateString();
			persons[arrayposition].getAddress().setStreet(updatedString);
			System.out.println(" ");
			System.out.println(persons[arrayposition].toString());saveArrayToFile();
			break;
		case 6:// Update City
			System.out.println(" ");
			updatedString = AskForNewUpdateString();
			persons[arrayposition].getAddress().setCity(updatedString);
			System.out.println(" ");
			System.out.println(persons[arrayposition].toString());
			saveArrayToFile();
			break;
		case 7:// Update State
			System.out.println(" ");
			updatedString = AskForNewUpdateString();
			persons[arrayposition].getAddress().setState(updatedString);
			System.out.println(" ");
			System.out.println(persons[arrayposition].toString());
			saveArrayToFile();
			break;
		case 8:// Update Zip
			System.out.println(" ");
			updatedString = AskForNewUpdateString();
			persons[arrayposition].getAddress().setZipcode(updatedString);
			System.out.println(" ");
			System.out.println(persons[arrayposition].toString());
			saveArrayToFile();
			break;
		case 9:// Exit

			break;

		default:
			System.out.println("Your selection is invald, please try again...");
		}

	}

	public static void SearchMenuLoop(int arrayposition)
	{

		do
		{
			System.out.println("Please select from the following search activities:");

			System.out.println("1 to Search by Person's First Name\n" + "2 to Search by Person's Last Name\n"
					+ "3 to Search by Person's Full Name\n" + "4 to Search by Person's Telephone Number\n"
					+ "5 to Search by Person's City\n" + "6 to Search by Person's State\n"
					+ "9 to Exit the Person's Update Menu");

			schoice = scannerint.nextInt();
			SearchMenuActivity(schoice, arrayposition);

		} while (schoice != 9);

		System.out.println("Exiting Search Menu Program, Thank you!");
	}

	public static void SearchMenuActivity(int key, int arrayposition)
	{

		switch (key)
		{
		case 1:// Search First Name
			System.out.println(" ");
			String searchString = AskForSearchString();
			SearchbyFirstName(searchString);
			System.out.println(" ");
			break;
		case 2:// Search Last Name
			System.out.println(" ");
			searchString = AskForSearchString();
			SearchbyLastName(searchString);
			System.out.println(" ");
			break;
		case 3:// Search Full Name
			System.out.println(" ");
			searchString = AskForSearchString();
			SearchbyFullName(searchString);
			System.out.println(" ");
			break;
		case 4:// Search Telephone Number
			System.out.println(" ");
			searchString = AskForSearchString();
			SearchbyPhoneNumber(searchString);
			System.out.println(" ");
			break;
		case 5:// Search City
			System.out.println(" ");
			searchString = AskForSearchString();
			SearchbyCity(searchString);
			System.out.println(" ");
			break;
		case 6:// Search State
			System.out.println(" ");
			searchString = AskForSearchString();
			SearchbyState(searchString);
			System.out.println(" ");
			break;
		case 9:// Exit

			break;

		default:
			System.out.println("Your selection is invald, please try again...");
		}

	}

	public static String AskforAddUserString()
	{
		String addUserString = "";

		System.out.println("Please enter the string per the example below:");
		System.out.println("   example: John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375");
		addUserString = scannerline.nextLine();

		return addUserString;
	}

	public static String AskForNewUpdateString()
	{
		String updatedString = "";
		System.out.println("Please enter the value you wish it changed to: ");
		updatedString = scannerline.nextLine();

		return updatedString;

	}

	public static String AskForSearchString()
	{
		String searchString = "";
		System.out.println("Please enter the value you wish to search on: ");
		searchString = scannerline.nextLine();

		return searchString;

	}

	public static void copyandexpandpersons(Person person)
	{
		Person[] newarray = new Person[persons.length + 1];
		for (int i = 0; i < persons.length; i++)
		{
			newarray[i] = persons[i];
		}
		newarray[newarray.length - 1] = person;
		persons = newarray;

		System.out.print("Added to Phone Book: ");
		System.out.print(person.toString());
		System.out.println();

	}

	public static void ShowAllPersons()
	{
		System.out.println(" ");
		System.out.println("***Phonebook Person List***");
//		Person[] persons1 = persons;
		Arrays.sort(persons);
		for (int i = 0; i < persons.length; i++)
		{
			System.out.println((i + 1) + ". " + persons[i].toString());
		}
		System.out.println(" ");
	}

	public static int SelectPersonFromPhoneBook()
	{
		int personsarrayindexvalue = -1;
		String telephone = "";
		ShowAllPersons();

		System.out.println(" ");
		System.out.println("Please enter the phone number for the person you wish to select:");
		telephone = scannerline.nextLine();

		for (int i = 0; i < persons.length; i++)
		{
//			System.out.println(i);
//			System.out.println(persons[i].getTelephone());
//			System.out.println(telephone);
			if (telephone.equals(persons[i].getTelephone()))
			{
				personsarrayindexvalue = i;
			}
		}
		return personsarrayindexvalue;

	}

	public static void DeletePersonFromPhoneBook(int arrayposition)

	{
		Person[] newarray = new Person[persons.length - 1];
		for (int i = 0; i < persons.length; i++)
		{
			if (i < arrayposition)
			{
				newarray[i] = persons[i];
			}
			if (i > arrayposition)
			{
				newarray[i - 1] = persons[i];
			}
		}
		persons = newarray;

		System.out.print("Person Deleted from Phone Book ");
		ShowAllPersons();
		System.out.println(" ");

	}

	public static void SearchbyFirstName(String string)
	{
		int responsecounter = 0;
		for (int i = 0; i < persons.length; i++)
		{

			if (persons[i].getFname().toLowerCase().startsWith(string.toLowerCase()))
			{
				System.out.println(persons[i].toString());
				responsecounter += 1;
			}
		}
		if (responsecounter == 0)
		{
			System.out.println("Sorry no matching results were found");
		}
	}

	public static void SearchbyLastName(String string)
	{
		int responsecounter = 0;
		for (int i = 0; i < persons.length; i++)
		{

			if (persons[i].getLname().toLowerCase().startsWith(string.toLowerCase()))
			{
				System.out.println(persons[i].toString());
				responsecounter += 1;
			}
		}
		if (responsecounter == 0)
		{
			System.out.println("Sorry no matching results were found");
		}
	}

	public static void SearchbyFullName(String string)
	{
		int responsecounter = 0;
		for (int i = 0; i < persons.length; i++)
		{

			if (persons[i].getFullName().toLowerCase().contains(string.toLowerCase()))
			{
				System.out.println(persons[i].toString());
				responsecounter += 1;
			}
		}
		if (responsecounter == 0)
		{
			System.out.println("Sorry no matching results were found");
		}
	}

	public static void SearchbyPhoneNumber(String string)
	{
		int responsecounter = 0;
		for (int i = 0; i < persons.length; i++)
		{

			if (persons[i].getTelephone().toLowerCase().contains(string.toLowerCase()))
			{
				System.out.println(persons[i].toString());
				responsecounter += 1;
			}
		}
		if (responsecounter == 0)
		{
			System.out.println("Sorry no matching results were found");
		}
	}

	public static void SearchbyCity(String string)
	{
		int responsecounter = 0;
		for (int i = 0; i < persons.length; i++)
		{

			if (persons[i].getAddress().getCity().toLowerCase().contains(string.toLowerCase()))
			{
				System.out.println(persons[i].toString());
				responsecounter += 1;
			}
		}
		if (responsecounter == 0)
		{
			System.out.println("Sorry no matching results were found");
		}
	}

	public static void SearchbyState(String string)
	{
		int responsecounter = 0;
		for (int i = 0; i < persons.length; i++)
		{

			if (persons[i].getAddress().getState().toLowerCase().contains(string.toLowerCase()))
			{
				System.out.println(persons[i].toString());
				responsecounter += 1;
			}
		}
		if (responsecounter == 0)
		{
			System.out.println("Sorry no matching results were found");
		}
	}

	public static void saveArrayToFile()
	{
		try
		{
			PrintWriter out = new PrintWriter(
					"C:\\Users\\mpaul\\Documents\\eclipse-workspace\\FileStorage\\phonebook.txt");
			for (int i = 0; i < persons.length; i++)
			{
				out.print(persons[i].toStringFileFormat() + "\n");
				out.flush();
			}
			out.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not Found.");
		}
		finally
		{
			
		}
//		try
//		{
//			FileOutputStream filepath = new FileOutputStream("C:\\Users\\mpaul\\Documents\\eclipse-workspace\\FileStorage\\phonebook.txt");
//			ObjectOutputStream outputStream = new ObjectOutputStream(filepath);
//			for (int i = 0; i < persons.length; i++)
//			{
//				outputStream.writeObject("a"+"\n");
//				outputStream.flush();
//			}
//			outputStream.close();
//		} catch (Exception e)
//		{
//
//		} finally
//		{
//			
//		}

	}

	public static void loadArrayFromFile()
	{
		try
		{
			
			String line = "";
			Scanner scanner3 = new Scanner(line);
			BufferedReader reader = new BufferedReader(
					new FileReader("C:\\Users\\mpaul\\Documents\\eclipse-workspace\\FileStorage\\phonebook.txt"));
			
			try
			{
				System.out.println("Loading contacts from file...");
//				Scanner scanner3 = new Scanner(line);
				while ((line = reader.readLine()) != null)
				{
					for (String token : line.split("\\n"))
					{
						Person person = new Person(token);
						copyandexpandpersons(person);
//						System.out.println(" ");
//						System.out.println("Add to Phonebook: "+person);
					}
				}

			} catch (IOException e)
			{
				System.out.println("Error reading file data");
//				e.printStackTrace();
			}
			finally
			{
				try
				{
					reader.close();
				} catch (IOException e)
				{
					System.out.println("Error closing Scanner reading file lines.");
					e.printStackTrace();
				}
				scanner3.close();
			}
		} catch (FileNotFoundException e)
		{
//			e.printStackTrace();
			System.out.println("File not Found");
		}


	}
}
