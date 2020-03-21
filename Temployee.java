/**
transportation personnel class
*/
public class Temployee{


	private int tid;
	private static int temployeecount=0;
/**
Desfault Constructor for the temployee class
*/
	public Temployee() {
		tid = 3;//default id
	}	
/**
Constructor for the temployee class
*/
	public Temployee(int id) {
		tid=id;
		temployeecount++;
	}

	public int getid(){
		return tid;
	}
	public void setid(int id){
		 tid=id;
	}
	public int gettcount(){
		return temployeecount;
	}
	public void settcount(int tcount){
		temployeecount=tcount;
	}

}
