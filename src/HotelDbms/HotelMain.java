package HotelDbms;

import java.util.Scanner;


public class HotelMain {
	static void menueFunction() {
		System.out.println("***************************");
		System.out.println("Welcome...Select one of the options:");
		System.out.println("1.crate tables ");
		System.out.println("2.Insert 10,000 hotels");
		System.out.println("3.Insert 1 hotel ");
		System.out.println("4. Print 10 hotels");
		System.out.println("5. Make first 10 hotels 'is_Active' = false");
		System.out.println("6. Make first 10 hotels 'is_Active' = true");
		System.out.println("7. Print hotel information by user input");
		System.out.println("8.- Exit App");
		
	}
	public static void main(String[] args)throws Throwable {

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
				Hotels.insertIntoTable(10000);
				
				
				
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
				
				Hotels.insertIntoTable(1);
				menueFunction();
				break;

			case 4:
				  // to read 10 values in table hotel?
				 Hotels.readFromTable(10);
				menueFunction();

				break;
			case 5:
				
				//to make it return false?
				//Hotels.makeIsActiveFalseById();
				
				
				//to make it return true?
				Hotels.makeIsActivTrueById();
				menueFunction();
				break;
			case 6:
				
				

				break;

			case 7: 
				System.out.println("bye..");
				System.exit(0);
				break;
			

			
			}

		} while (true);

}




	}


