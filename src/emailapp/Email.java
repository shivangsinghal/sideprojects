package emailapp;

import java.util.Scanner;

public class Email {
	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private String email;
	private int mailboxcapacity = 600;
	private int defaultpasswordLength = 10;
	private String alternateemail;
	private String companysuffix = "company.com";

    // Constructor to receive the first name and last name 
    public Email(String firstname, String lastname) {
    	this.firstname = firstname;
    	this.lastname = lastname;
    	
    	
    	//Call a method asking for the department - return the department
    	this.department = setDepartment();
    	
    	
    	//Call a method that returns a random password
    	this.password = randomPassword(defaultpasswordLength); 
    	System.out.println("Your password is: " + this.password);
    	
    	//Combine elements to generate email
    	email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@"+ department + "." + companysuffix;
    	
    }
	
    //Ask for the department
    private String setDepartment() {
    	System.out.println("New employee: " + firstname + ". Department Codes\n1 for Sales\n2 for Developnment\n3 for Accounting\n0 for none\nEnter department Code: ");
    	Scanner in = new Scanner(System.in);
    	int depChoice = in.nextInt();
    	if (depChoice == 1) { return "sales"; }
    	else if (depChoice == 2) { return "dev"; }
    	else if (depChoice == 3) { return "acct"; }
    	else { return ""; }
    }
    
    //Generate a random password
    private String randomPassword(int length) {
    	String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
        	int rand = (int) (Math.random() * passwordSet.length());
        	password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    //Set the mailbox capacity
    public void setMailboxcapacity(int capacity){
    	this.mailboxcapacity = capacity;
    }
    
    //Set the alternate email
    public void setAlternateemail(String altEmail) {
    	this.alternateemail = altEmail; 	
    }
    
    //Change the password
    public void changePassword(String password) {
    	this.password = password;
    }
    
    public int getMailboxcapacity() { return mailboxcapacity;}
    public String getAlternateemail() { return alternateemail;}
    public String getPassword() { return password;}
    
    public String showInfo() {
    	return "DISPLAY NAME: " + firstname + " " + lastname +
    			"\nCOMPANY EMAIL: " + email +
    			"\nMAILBOX CAPACITY: " + mailboxcapacity + "mb";
    }
}