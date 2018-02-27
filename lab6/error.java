import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class coordinates{
	int x;
	int y;
	public coordinates(int x, int y) {
		//super();
		this.x = x;
		this.y = y;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
	
}
class knight{
	String name;
	//coordinates type;
	int size;
	int x;
	int y;
	int xcqueen;
	int ycqueen;
	int zindagi;
	Stack s = new Stack();
	
	public knight(String name, int size, int x, int y, Stack s,int xq,int yq) {
	//	super();
		this.name = name;
		this.size = size;
		this.x = x;
		this.y = y;
		this.s = s;
		this.xcqueen = xq;
		this.ycqueen = yq;
		this.zindagi = 1;
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	
	public boolean zinda() {
		if(zindagi == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	//exceptions
	public void findingfanny()throws FindQueenException{
		if(getX() == xcqueen && getY() == ycqueen ) {
			throw new FindQueenException("QueenFoundException:   Queen   has   been   Found.   Abort!");
		}
	}

	
	public void khalidabba()throws StackEmptyException{
		if(size<0) {
			
			throw new StackEmptyException("StackEmptyException:   Stack   Empty   exception");

		}
		
	}
	
	public void chadjaoekdusrepe()throws OverlapException{
		throw new OverlapException("OverlapException:   Knights   Overlap   Exception");
	}
	
	public void noncoordinateexception()throws  NonCoordinateException{
		throw new NonCoordinateException( "NonCoordinateException:  Not a coordinate Exception");
	}
	
}



public class error {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int knights = Integer.parseInt(reader.readLine());
		int iterations = Integer.parseInt(reader.readLine());
		String[] queen = reader.readLine().split(" ");
		int xq = Integer.parseInt(queen[0]);
		int yq = Integer.parseInt(queen[1]);
		coordinates Queen = new coordinates(xq,yq);
		Stack<knight> stack = new Stack<knight>();
		for(int j=0;j<knights;j++) {
			BufferedReader read = new BufferedReader(new FileReader("1.txt"));
			String name = read.readLine();
			String coordinates[] = read.readLine().split(" ");
			int m = Integer.parseInt(read.readLine());
			for(int i=0;i<m;i++) {
				String[] value = read.readLine().split(" ");
				if((value[0]).equals("String")) {
					
				}
				else if((value[0]).equals("Float")){
					
				}
				else if((value[0]).equals("Integer")) {
					
				}
				else {
					
				}
			}
			//knight object
			knight sipahi = new knight(name,m,Integer.parseInt(coordinates[0]) , Integer.parseInt(coordinates[1]),stack,xq,yq);
			stack.add(sipahi);
			
		}
		
		for(int z=0;z<iterations;z++) {
			int count =0;
		}
		
		
		
		

	}

}
