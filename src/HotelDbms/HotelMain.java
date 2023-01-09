package HotelDbms;

import java.io.IOException;
import java.util.Scanner;


public class HotelMain {
	static void menueFunction() {
		System.out.println("***************************");
		System.out.println("Welcome...Select one of the options:");
		System.out.println("1.crate tables ");
		System.out.println("2.Insert 10,000 hotels");
		System.out.println("3.Insert values for all the tables  ");
		System.out.println("4. Print 10 hotels");
		System.out.println("5. Make first 10 hotels 'is_Active' = false");
		System.out.println("6. Make first 10 hotels 'is_Active' = true");
		System.out.println("7. Print hotel information by user input");
		System.out.println("8. Exit App");
		System.out.println("9. insert data into Employees");
		
	}
	public static void main(String[] args)throws IOException{

		Scanner sc = new Scanner (System.in);
		menueFunction();
		
		do {
			

			int studentMenue = sc.nextInt();


			switch (studentMenue) {
			case 1:
				Hotels Hotelsobj = new Hotels();
				Hotelsobj.tableHotels();
				

				
				RoomType RoomObj = new RoomType();
				RoomObj.Room_Type();
				
				Room RoomObject = new Room();
				RoomObject.Room();
				
				Guests GuestsObj = new Guests ();
				GuestsObj.Guests();
				
				Employee_Type EmployeeObj = new Employee_Type ();
				EmployeeObj.Employee_Type();
				
				Employees EmployeeObject = new Employees ();
				EmployeeObject.Employees();
				
				
				menueFunction();
				
				break;
			case 2 :
				//Hotels insertValue = new Hotels();
				//to insert 10,000 ?
//				Hotels.insertIntoTable(10000);
				
				
				
				//how to update the id?
				//Hotels.updateById();
				
				
				//how to get the id you want?
				//Hotels.getById();
				
				
				//update the id by the name and location that i been given?
				//Hotels.updateById();
				
				
				//it will delete the row that i have chose by the ID?
				//Hotels.deleteById();
				
				//Make it the  IsActive into false ?
				//Hotels.makeIsActiveFalseById();
				
				
				menueFunction();
				break;

			case 3:
				//There have to be More than 100 hotels?
				//Hotels Hotelsobj2 = new Hotels();
				//Hotelsobj2.insertIntoTable(100);
				
				//RoomType roomObj= new RoomType();
				//roomObj.insertIntoTable();
//				
//				Room roomObj= new Room();
//				roomObj.insertIntoTable();
//				
				
				
				
				         //1000 guests?
				Guests GuestsObj1=new Guests();
				GuestsObj1.insertIntoTable(1000);
				
				//Employee_Type empObj = new Employee_Type();
				//empObj.insertIntoTableEmp();
				
				    //20 employees?
				//Employees employeeObj = new Employees();
				//employeeObj.insertIntoTableEmployees(20);
				break;

			case 4:
				  // to read 10 values in table hotel?
//				 Hotels.readFromTable(10);
//				menueFunction();

				break;
			case 5:
				
				//to make it return false?
				Hotels.makeIsActiveFalseById();
				menueFunction();
				
				
				
				break;
			case 6:
				//to make it return true?
				Hotels.makeIsActivTrueById();
				menueFunction();
				

				break;

			case 7: 
				Hotels.readFromTableUserInput();
				menueFunction();
				
				break;
				
				
			case 8: 
				System.out.println("bye..");
				System.exit(0);
				break;
			case 9: 
				//Employees EmployeesObj=new Employees ();
				//EmployeesObj.insertIntoTable();
				break;
			

			
			}

		} while (true);

}




	}


