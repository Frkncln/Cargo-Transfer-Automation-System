/**
Customer class:we use this class for save cargo infos and track no 
*/

public class Customer{

	private static int ccount=0;
	private int trackid;
	private String sendername,receivername,currentstatus,senderbranch,receiverbranch;
	
	public Customer() {
		trackid=1;//default
		sendername="defaultsender";
		receivername="defaultreceiver";
		currentstatus ="defaultstatus";
	}

	


/**
Constructor for the customer class
*/
	public Customer(int id,String sname,String rname,String sbranch,String rbranch,String status) {
		trackid=id;
		sendername=sname;
		receivername=rname;
		currentstatus =status;
		senderbranch=sbranch;
		receiverbranch=rbranch;			
		ccount++;
	}
		
	public int getid(){
		return trackid;
	}
	public void setid(int nid){
 		trackid=nid;
	}

	public String getsender(){
		return sendername;
	}

	public String getreceiver(){
		return receivername;
	}

	public String getsenderbranch(){
		return senderbranch;
	}

	public String getreceiverbranch(){
		return receiverbranch;
	}

	
	public String getstatus(){
		return  currentstatus;
	}
	public void setstatus(String status){
		currentstatus = status;
	}
/**
tostring method for the customer class
we use it for showing cargo infos
*/
	public String toString(){
		return 	"------CARGO INFO------\n"+
			"Sender name--> "+sendername+
			 "\nReceiver name--> "+receivername +
			"\nSender Branch name--> "+senderbranch+ 
			"\nReceiver Branch name--> "+receiverbranch +
			"\nCurrent status is--> "+currentstatus;
	}

	public int getccount(){
		return ccount;
	}
	public void setccount(int count){
		ccount=count;
	}



}

