package Jdbc.library;
import java.sql.*;
import java.util.Scanner;

public class LibraryManage {
	
	static Scanner sc=new Scanner(System.in);
	
	 public static void main (String[] args) throws SQLException {
		 
		 	int bid;
			String title;
			String author;
			int price;
			boolean flag = true;
			
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","1683087");
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement st=con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 LibraryManage lib = new LibraryManage();
		 do {
		 System.out.println("*******************WELCOME TO THE LIBRARY***************************");
		 System.out.println("\t 1. List the Books\r\n" + "\t 2. Add the Books in the Library\r\n" + "\t 3. Update the Books in the Library\r\n" + "\t 4. Delete the Books From the Library\r\n" + "\t 5. Search the Books in the Library\r\n" +"\t 6. Exit From Library\r\n");
		 
		 System.out.println("Enter Your Choice : ");
		 
		 int choice=sc.nextInt();
		 switch(choice) {

			 

			case 1: 
				 try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select * from libsysytem");
						while(rs.next())
			            {
			                System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
			            }
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			break;
			
			
			case 2: 
				System.out.println("Enter Book ID : ");
				bid=sc.nextInt();
				System.out.println("Enter Book Title : ");
				title=sc.next();
				System.out.println("Enter Book Author Name : ");
				author=sc.next();
				System.out.println("Enter Book Price : ");
				price=sc.nextInt();

				try
				   {  
					Class.forName("com.mysql.cj.jdbc.Driver");
					Statement st=con.createStatement(); 
				    st.executeUpdate("insert into libsysytem values('"+bid+"','"+title+"','"+author+"','"+price+"')");    
				   System.out.println("Added the Record in the Library List"); 
				   ResultSet rs=st.executeQuery("select * from libsysytem");
					while(rs.next())
		            {
		                System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
		            }
				    }  
				   
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}      
				   break;
				   
			case 3: 
				
				System.out.println("Enter Book Id to be updated");  
			    int nbid=sc.nextInt();
			    System.out.println("Enter the price to be updated");  
			    int nprice=sc.nextInt();
				try  
				   {  
				    	    
				    Class.forName("com.mysql.cj.jdbc.Driver");
					Statement st=con.createStatement();
					String sql = "UPDATE libsysytem set price=" +nprice+ " WHERE bid= " + nbid;
					st.executeUpdate(sql);
					System.out.println("Updated the Record in the Library List"); 
					ResultSet rs=st.executeQuery("select * from libsysytem");
					while(rs.next())
		            {
		                System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
		            }
				   }
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}      
				   break;
				
				case 4: 
				
				System.out.println("Enter Book Id to be updated");  
			    bid =sc.nextInt();

				try  
				   {  
				    	    
				    Class.forName("com.mysql.cj.jdbc.Driver");
					Statement st=con.createStatement();
					String sql = "DELETE FROM libsysytem" + " WHERE bid = "+ bid ;
					st.executeUpdate(sql);
					System.out.println("Deleted the Record From the Library List"); 
					ResultSet rs=st.executeQuery("select * from libsysytem");
					while(rs.next())
		            {
		                System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
		            }
				   }
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}      
				   break;
				   
				   
				case 5: 
					
					System.out.println("Enter Book Id To Be Searched: ");  
				    bid =sc.nextInt();

					try  
					   {  
					    	    
					    Class.forName("com.mysql.cj.jdbc.Driver");
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select * from libsysytem WHERE bid = "+ bid) ;
						System.out.println("The Searched Record From the Library List"); 
						while(rs.next())
			            {
			                System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
			            }
						
					   }
					catch (ClassNotFoundException e) {
						e.printStackTrace();
					}      
					   break;
					   
				case 6:
					System.exit(1);  
				    break;
				   
			default: System.out.println("Wrong choice..Please enter no between 1 to 5");
			}
		 System.out.println("do u want to continue(yes /no)");  
		 String str=sc.next();  
		 if(str.equals("yes")|| str.equals("y"))  
		 flag=true;  
		 if(str.equals("no")||str.equals("no"))  
		 flag=false;  
		 }while(flag);    
		  }  
		 }  
		 
	 
	 

