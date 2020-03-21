import java.util.Arrays;
import java.util.Scanner;

/**
*@author furkan celen
Note:Admin id is 306
*/

public class Main{


/** 
general main
*/
 public static  void main(String args[]){

		int adminid = 306,trackno=1,systemid,i=0,ccount=0,bcount=0,tcount=0,branchcount =0,nid,j;
		boolean flag = false,flag2 = false,flag3 =false ; 
		String nstatus,sname,rname,bname;
		Customer customers[] = new Customer [10];
		Bemployee bemployees[] = new Bemployee[10];
		Temployee temployees[] = new Temployee[10];
		Branch branches[]=new Branch[10];
		
		Customer c1 = new Customer();
		customers[ccount]=c1;
		
		Bemployee b1 = new Bemployee();
		bemployees[bcount]=b1;
		
		Temployee t1 = new Temployee();
		temployees[tcount]=t1;

		Branch br1 = new Branch();
		branches[branchcount]=br1;

		Scanner input = new Scanner( System.in );
		int sec,sec2;
		
		while(true){
			System.out.println("\n-------WELCOME TO THE CARGO SYSTEM------\n");
			System.out.println("1:Enter track number(For customers) \n2:Login system\n3:Exit\n");
			System.out.println("Please select the number of the action you want \n");
			System.out.println("Enter number: ");
			sec=input.nextInt();
			
			if(sec == 1){
				customerenter(customers,c1.getccount());
			}
			else if(sec ==2){//if person want to enter system

				System.out.println("\nAttention we got "+br1.getcount()+" branches in sytem \n");
				System.out.println("Select your position \n1)ADMIN\n2)Branch Employee\n3)Transporter \nenter number");
				
				j=input.nextInt();
				
				if (j!=1 && j!=2 && j!=3){ System.out.println("Invalıd number you must enter (1-2-3) OK!");}
				
				else{	if(j==1){ 
							adminenter(temployees,t1.gettcount(),bemployees,b1.getbcount(),branches,br1.getcount());
							}
					else if(j==2 && br1.getcount() >1 ){	//if there is less than 2 branches we cant add new cargo
							branchempenter(bemployees,b1.getbcount(),customers,c1.getccount(),branches,br1.getcount());
							}
					else if(j==3 && br1.getcount() >1){	tempenter(temployees,t1.gettcount(),customers,c1.getccount());
							}
					
				}
			    if(br1.getcount() < 2){ System.out.println("YOU CAN'T ENTER NEW SHIPMENT OR ADD CUSTOMER \nWHILE THERE ARE NOT ENOUGH BRANCH(< 2)");
				System.out.println("YOU MUST HAVE 2 BRANCHES AT LEAST FOR THE USING SYSTEM WELL");				
				}			
			}
			

			else if(sec == 3){
				System.out.println("exiting,bye");
				System.exit(0);
			}	
			else System.out.println("You entered wrong number TRY IT AGAIN,select TRUE NUMBER!");
		}//while curl
	
}//main curl








/**
Menu for the customer entrance
@param c[] is the customers array
*/
 public static void customerenter(Customer c[],int custcount){
	boolean flag=false;
	int i=0;
	Scanner input = new Scanner( System.in );
	System.out.println("Enter cargo track number Dear Customer");
			int trackno = input.nextInt();
				
				while(i<custcount && flag ==false){
					if(trackno == c[i].getid()){//if it is customer----------
						flag = true;
					}
					else{flag = false;
					i++;
					}
				
				}
				
				if(flag == false)
					System.out.println("Your track no is INCORRECT");
				else
					System.out.println(c[i].toString());

	}

 
/** 
menu for the branch employee entrance
@param b[] is b.employee array
@param customer[] is the customers array
*/
 public static void branchempenter(Bemployee b[],int bcount,Customer customer[],int custcount,Branch br[],int brcount){
	boolean flag=false,flag2=false;
	int i=0,systemid,sec2,trackno,j=0;
	String nstatus,sname,rname,bname,sbranch,rbranch;
	Scanner input = new Scanner( System.in );
	System.out.println("Enter your system id");
				systemid=input.nextInt();
							
				while(i<bcount && flag ==false){
					if(systemid == b[i].getid()){                             //if it is branch employee----------
						System.out.println("Welcome BRANCH EMPLOYEE,what do you want\n");
						System.out.println("1:Add customer 2:Remove customer \n");
						System.out.println("3:Update cargo status\n");
						System.out.println("Enter number: ");
						sec2=input.nextInt();
						Scanner line = new Scanner( System.in );
						if(sec2==1){
							System.out.println("Enter track no ");
							trackno=input.nextInt();
							System.out.println("Enter sender name");
							sname=line.nextLine();
							System.out.println("Enter receiver name");	
							rname=line.nextLine();
							showbranches(br,brcount);//showing branches for the branch employee
							System.out.println("Enter sender branch name of this cargo");	
							sbranch=line.nextLine();
							System.out.println("Enter receiver branch name of this cargo");	
							rbranch=line.nextLine();
							System.out.println("Enter current status of cargo");	
							nstatus=line.nextLine();

							Customer c2 = new Customer(trackno,sname,rname,sbranch,rbranch,nstatus);
							customer[custcount]=c2;

							System.out.println("Now you have "+customer[custcount].getccount()+" customer");
							flag=true;
						}
						else if(sec2==2){
							System.out.println("Enter track no for remove customer");
							trackno=input.nextInt();
							cremove(customer,trackno,custcount);
							flag=true;
							custcount--;
							Customer c2 = new Customer();
							c2.setccount(custcount);
						}	
						else if(sec2==3){

							System.out.println("Now Enter track no for update status");
							trackno=input.nextInt();
							
							
							while(j<custcount && flag2 ==false){
								if(trackno == customer[j].getid()){
										flag2 = true;
								}
								else{flag2 = false;
									j++;
								}
							}
									
							if(flag2 == false){
								System.out.println("Your track no is INCORRECT");}
							else{
								System.out.println("Enter new current status of cargo");	
								nstatus=line.nextLine();
								customer[j].setstatus(nstatus);	
							}
							flag=true;					
						}					
						else {System.out.println("You entered wrong number TRY IT AGAIN,select TRUE NUMBER!");}
						
						
					}
					i++;	
				}
				
		if(flag == false)
			System.out.println("\nYour id number is INCORRECT branch employee,,contact with the general center for reset your id,or try it again \n");

	}
	
/** 
menu for the transporter employee entrance
@param t[] is t.employee array
@param customers[] is the customers array
*/
 public static void tempenter(Temployee t[],int tcount,Customer customers[],int custcount){ // if it is a transport employee------
		int i=0,j=0,systemid,trackno;
		String nstatus;
		Scanner input = new Scanner( System.in );
		boolean flag=false,flag2=false;
		System.out.println("Enter your system id");
			systemid=input.nextInt();

		while(j<tcount && flag2==false){
			if( systemid == t[j].getid()){                     
				Scanner line = new Scanner( System.in );
				
				System.out.println("Enter cargo track number that you want to update");
				trackno = input.nextInt();
				i=0;
				while(i<custcount && flag ==false){
					if(trackno == customers[i].getid()){
						flag = true;
						}
					else{flag = false;
						i++;
					     }
				}
				
				if(flag == false){
					System.out.println("Your track no is INCORRECT,TRY IT AGAIN");
				}				
				else {	System.out.println("Welcome TRANSPORT EMPLOYEE,enter new status of cargo\n");
					nstatus=line.nextLine();
					customers[i].setstatus(nstatus);
				}
			flag2=true;	
			}
			j++;

		}

		if(flag2 == false)
			System.out.println("\nYour id number is INCORRECT transporter,,contact with the general center for reset your id,or try it again \n");


}

/** 
menu for the Admin entrance
@param t[] is t.employee array
@param b[] is b.employee array
@param br[] is the branch array
*/
 public static void adminenter(Temployee t[],int tcount,Bemployee b[],int bcount,Branch br[],int brcount){
				int i=0,j=0,systemid,adminid=306,sec2,nid;
				boolean flag=false,flag2=false;
				String bname;
				Scanner input = new Scanner( System.in );
				System.out.println("Enter your system id");
				systemid=input.nextInt();
				if(systemid == adminid){                                         //-------if it is admin--------
					System.out.println("Welcome ADMIN,what do you want king\n");
					System.out.println("1:Add new b.employee 2:Remove b.employee  \n");
					System.out.println("3:Add new branch 4:Remove branch\n");
					System.out.println("5:Add new t.employee 6:Remove t.employee  \n");
					System.out.println("Enter number: ");
					sec2=input.nextInt();
					Scanner line = new Scanner( System.in );
					if(sec2==1 && brcount > 1 ){System.out.println("Enter new b.employee's id");
							nid=input.nextInt();
							Bemployee b2 = new Bemployee(nid);
							b[bcount]=b2;
							System.out.println("Entered new b.employee with id: "+b[bcount].getid());
							bcount++;
							System.out.println("\nnow you have "+b2.getbcount()+" b.employees");
							
					}

					else if(sec2==2 && brcount > 1){System.out.println("Enter id no for remove b.emp.");
							if(bcount > 0){							
							nid=input.nextInt();
							bremove(b,nid,bcount);
							}
							else{
								System.out.println("You have NO! branchemployee for removing");			
								}
						}

						
					else if(sec2==3){System.out.println("Enter new branch's name");

							bname=line.nextLine();
	
							Branch br2 = new Branch(bname);
							br[brcount]=br2;
							brcount++;
						}
					else if(sec2==4 ){
						if(brcount > 0){	
							showbranches(br,brcount);
							System.out.println("Enter branch name from list for remove"); 						
							bname=line.nextLine();
							branchremove(br,bname,brcount);
							}
						else{
							System.out.println("You have NO! branch for removing");			
								}	

						}

					else if(sec2==5 && brcount > 1){System.out.println("Enter new t.employee's id");
							nid=input.nextInt();
							Temployee t2 = new Temployee(nid);
							t[tcount]=t2;
							System.out.println("Entered new t.employee with id: "+t[tcount].getid());
							tcount++;
							System.out.println("\nnow you have "+tcount+" t.employees");
							
						}
					else if(sec2==6 && brcount > 1){System.out.println("Enter id no for remove t.emp.");
							

						if(tcount > 0){	
							nid=input.nextInt();
							tremove(t,nid,10);
							tcount--;
							Temployee t2 = new Temployee();
							t2.settcount(tcount);
							}
						else{
							System.out.println("You have NO! transporter for removing");			
								}



					}
						
					else {System.out.println("Admin,You entered wrong number TRY IT AGAIN,select TRUE NUMBER!");}
			}

			else{System.out.println("\nYour id number is INCORRECT ,contact with the general center for reset your id,or try it again\n");}

	}

/**
helper function for the removing customer from array
*/
 public static void cremove(Customer c[],int trackno,int size){
		int i=0,j;
		boolean flag=false;
		System.out.println("Removing customer ,size = "+size);
		while(i<size && flag ==false){
			if(trackno == c[i].getid()){
			   flag = true;
			}
			else{flag = false;
				i++;
			}
		}
				
		if(flag == false){
			System.out.println("Your track no is INCORRECT");}
		else{
			for(j=i;j<size-1;j++){
				c[j]=c[j+1];}
			Customer  c2 = new Customer();
				i=c2.getccount();
				i--;
				c2.setccount(i);

		}
				
}


/**
helper function for the removing b.employee from array
@param idno is the id no for the employee
*/
 public static void bremove(Bemployee c[],int idno,int size){
		int i=0,j;
		boolean flag=false;
		
		System.out.println("Removing bemployee ,size = "+size);
		while(i<size && flag ==false){
			if(idno == c[i].getid()){
					flag = true;
			}
			else{flag = false;
				i++;
			}
		}
				
		if(flag == false){
			System.out.println("Your track no is INCORRECT");}
		else	{
			for(j=i;j<size-1;j++){
				c[j]=c[j+1];}
				
				Bemployee b2 = new Bemployee();
				i=b2.getbcount();
				i--;
				b2.setbcount(i);
		}
				
}

/**
helper function for the removing t.employee from array
@param idno is the id no for the employee
*/
 public static void tremove(Temployee c[],int idno,int size){
		int i=0,j;
		boolean flag=false;
		
		System.out.println("Removing temployee ,size = "+size);
		while(i<size && flag ==false){
			if(idno == c[i].getid()){
					flag = true;
			}
			else{flag = false;
				i++;
			}
		}
				
		if(flag == false){
			System.out.println("Your track no is INCORRECT");}
		else{
			for(j=i;j<size-1;j++)
				c[j]=c[j+1];

			Temployee t2 = new Temployee();
				i=t2.gettcount();
				i--;
				t2.settcount(i);

		}
				
 } 

/**
helper function for the removing branch from array
@param name is the branch name for finding 
*/
 public static void branchremove(Branch c[],String name,int size){
		int i=0,j;
		boolean flag=false;
		System.out.println("We will try to remove your ' "+name+"' with there are "+size+"branches");
		while(i<size && flag ==false){
			if(name.equals(c[i].getname())){
					flag = true;
			}
			else{flag = false;
				i++;
			}
		}
				
		if(flag == false){
			System.out.println("Your Branch name is INCORRECT for removing ,select name from the list truely");
		}
		else {
			for(j=i;j<size-1;j++){
				c[j]=c[j+1];
			}

			Branch br2 = new Branch();
			i=br2.getcount();
			i--;	
			br2.setcount(i);
		}	
 }
/**
helper function for the showing branches
@param c[] is the branch array
*/
 public static void showbranches(Branch c[],int size){
	int i,j;	
	System.out.println("You have got "+size+" branches,their names are:");	
	for(i=0;i<size;i++){
		j=i+1;
		System.out.println(j+") "+c[i].getname());
	}

 }


}// end of the main class
