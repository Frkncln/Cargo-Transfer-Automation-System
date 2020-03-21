/**
branch personnel class
*/
public class Bemployee{


	private int bid;
	private static int bemployeecount=0;
/**
Default Constructor for the bemployee class
*/
	public Bemployee() {
		bid = 2;//default id

	}	
/**
Constructor for the bemployee class
*/
	public Bemployee(int id) {
		bid=id;
		bemployeecount++;
	}

	public int getid(){
		return bid;
	}

	public void setid(int id){
		 bid=id;
	}
	public int getbcount(){
		return bemployeecount;
	}
	public void setbcount(int bcount){
		bemployeecount=bcount;
	}


}
