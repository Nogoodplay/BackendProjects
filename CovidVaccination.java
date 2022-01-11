import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CovidVaccination {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	void AddDetails() {
		String Name,email,address,Dob,date,ph,age,dose,aadhar;
		boolean addmore=false;
		try {
			PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("testing2.txt",true)));
			do {
				System.out.println("Enter your name");
				Name=br.readLine();
				
//Age
				boolean resul0;
				do {
				System.out.println("Enter Your Age");
				age=br.readLine();
				String Regex0="^(([1-9][0-9])|(1[0][0-9]))$";
				Pattern pt0=Pattern.compile(Regex0);
				Matcher mt0=pt0.matcher(age);
				resul0=mt0.matches();
				if(resul0==false) {
					System.out.println("Enter the correct age");
				}else {
					break;
				}
				}while(resul0==false);
				
//Date of Birth
				boolean resul7;
				do {
				System.out.println("Date of birth(dd/mm/yyyy)");
				Dob=br.readLine();
				String Regex7="^((0?[1-9]|[12][0-9]|3[01])[/-](0?[1-9]|1[012])[/-](19[2-9][0-9])|(20[01][0-9]|20[2][01]))$";
				Pattern pt7=Pattern.compile(Regex7);
				Matcher mt7=pt7.matcher(Dob);
				resul7=mt7.matches();
				if(resul7==false) {
					System.out.println("Oops! Enter the correct date format(eg:01/01/1950)");
				}else {
					break;
				}
				}while(resul7==false);
				
//Aadhar Number
				
				boolean resul6;
				do {
					System.out.println("Enter your Aadhar number");
					aadhar=br.readLine();
					String Regex6="^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$";
					Pattern pt6=Pattern.compile(Regex6);
					Matcher mt6=pt6.matcher(aadhar);
					resul6=mt6.matches();
					if(resul6==false) {
						System.out.println("Oops!Enter a valid aadhar number");
					}else {
						break;
					}
					}while(resul6==false);
				
//Mobile Number
				boolean resul2;
				do{
				System.out.println("Enter your Mobile number");
				ph=br.readLine();
				String Regex2="^[6-9][0-9]{9}$";
				Pattern pt2=Pattern.compile(Regex2);
				Matcher mt2=pt2.matcher(ph);
				resul2=mt2.matches();
				if(resul2==false) {
					System.out.println("Invalid Mobile Number");
				}else {
					break;
				}
				}while(resul2==false);
				
//Email Id
				boolean resul;
				do {
				System.out.println("Enter your Email address");
				email=br.readLine();
				String Regex="^[A-Za-z0-9+-._]+@(.+)$";
				Pattern pt=Pattern.compile(Regex);
				Matcher mt=pt.matcher(email);
				resul=mt.matches();
				if(resul==false) {
					System.out.println("Invalid email address");
				}
				}while(resul==false);
				
//Address
				System.out.println("Enter your Address");
				address=br.readLine();
				
				
//Dose Completed
				boolean resul4;
				do {
				System.out.println("Dose Completed(if 1st dose enter '1' and 2nd dose '2' and if Notyet vaccinated enter '0')");
				dose=br.readLine();
				String Regex4="^([012])$";
				Pattern pt4=Pattern.compile(Regex4);
				Matcher mt4=pt4.matcher(dose);
				resul4=mt4.matches();
				if(resul4==false) {
					System.out.println("Dose Completed should be greater than 2");
				}
				}while(resul4==false);
				
//Date of Vaccination
				boolean resul3;
				do {
				System.out.println("Date of Vaccination(dd/mm/yyyy)");
				date=br.readLine();
				String Regex3="^((0?[1-9]|[12][0-9]|3[01])[/-](0?[1-9]|1[012])[/-](20[2][01]))$";
				Pattern pt3=Pattern.compile(Regex3);
				Matcher mt3=pt3.matcher(date);
				resul3=mt3.matches();
				if(resul3==false) {
					System.out.println("Oops! Enter the correct date format(eg:01/01/2021)");
				}else {
					break;
				}
				}while(resul3==false);
				
				pw.println(Name);
				pw.println(age);
				pw.println(Dob);
				pw.println(aadhar);
				pw.println(ph);
				pw.println(email);
				pw.println(address);
				pw.println(dose);
				pw.println(date);
				System.out.println("Do you Want to add more(Y/N)");
				String n=br.readLine();
					if(n.equalsIgnoreCase("y")) {
						addmore=true;
						AddDetails();
						System.out.println();
					}else {
						addmore=false;
					}
					}
					while(addmore);
					System.out.println("-----------------------");
					System.out.println("Registered Successfully");
					System.out.println("-----------------------");
					pw.close();
					showmenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void readData() {
		try {
			BufferedReader bf=new BufferedReader(new FileReader("testing2.txt"));
			String name;
			int n=1;
			while((name = bf.readLine()) != null) {
			System.out.println("Application No : "+(n++));
			System.out.println("---------------------------------------------");
			System.out.println("Name : "+name);
			System.out.println("Age : "+bf.readLine());
			System.out.println("Date of birth : "+bf.readLine());
			System.out.println("Aadhar Number : "+bf.readLine());
			System.out.println("Phone Number : "+bf.readLine());
			System.out.println("Email ID : "+bf.readLine());
			System.out.println("Address : "+bf.readLine());
			System.out.println("Dose Completed : "+bf.readLine());
			System.out.println("Date of Vaccination : "+bf.readLine());
			System.out.println();
			}
			bf.close();
			showmenu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void clear() {
		try {
			PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("testing2.txt")));
			pw.close();
			System.out.println("-----------------------------------");
			System.out.println("Data has been Cleared Successfully.");
			System.out.println("-----------------------------------");
			showmenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void showmenu() {
		System.out.println("Enter the choice");
		System.out.println("1.Register for vaccination.");
		System.out.println("2.display the details");
		System.out.println("3.Clear the data");
		System.out.println("4.Exit");
		int Choice;
		try {
			Choice = Integer.parseInt(br.readLine());
			switch(Choice) {
			case 1:
				AddDetails();
				break;
			case 2:
				readData();
				break;
			case 3:
				clear();
				break;
			case 4:
				System.out.println(":) ---------------EXITED-------------- (:");
				System.exit(0);
				break;
			default:
				System.out.println("---------------------------Invalid choice--------------------------");
				showmenu();
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CovidVaccination cv=new CovidVaccination();
		cv.showmenu();
		
	}

}
