import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




class type<T extends Comparable<T>> implements Comparable<type<T>>{
//	public class type<T extends Comparable<T>> {

	private T data;
	public type<T> left;
	public type<T> right;
	public type(T data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
//	@override
	public int compareTo(type<T> b) {
		// TODO Auto-generated method stub
		return ( ((Comparable<T>) (T)this.getData()).compareTo((T)b.getData()));
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}



}
public class Lab5 {
	public static <T> type insert (type _root,type lol) {
		if (_root==(null))
		{
			_root = new type ( lol.getData());
//						 System.out.println(_root.getData()+" ");
		}
		else 
		{
			int k= ((Comparable<T>) lol.getData()).compareTo((T) ((type) _root).getData());
//					 System.out.println(_root.getData()+" "+lol.getData()+ " "+k);

			if (  k<=0)
			{
				_root.left = insert (_root.left, lol);
//				System.out.println("left: " + _root.left.getData());}
			}
			else
			{ _root.right = insert ( _root.right, lol);
//			System.out.println("right: " + _root.right.getData());}
			}
		}
		return (type) _root;
	}
	public static <T > void display (type _root,ArrayList<type> yo) {
		if (_root!=(null)) 
		{
			display (_root.left,yo );
			if(!yo.contains(_root))
			{
			yo.add(_root);
			}
			display (_root.right,yo);
		}
	}
	static int j=1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		//		Set<type<String>> set1=new TreeSet<type<String>>();
		ArrayList<ArrayList<type<?>>> setTrees=new ArrayList<ArrayList<type<?>>>();

		String[] input=reader.readLine().split(" ");
		Integer num_trees=Integer.parseInt(input[0]);
		Integer stu_num=Integer.parseInt(input[1]);
		Map<Integer,ArrayList<String>> hash = new HashMap<>();
		for(int i=1;i<=stu_num;i++)
		{
			ArrayList<String> yo=new ArrayList<>();
			hash.put(i, yo);
		}
		int c=0;
	BSTFilesBuilder yola=new BSTFilesBuilder();
		yola.createBSTFiles(stu_num, num_trees);

		for(int i1=1;i1<=num_trees;i1++) {
			FileInputStream fr = new FileInputStream("./src/" + i1 + ".txt");
			DataInputStream in = new DataInputStream(fr);
			//        BufferedReader bri = new BufferedReader(fr);
			String strLine;
			int flag = 0; 
			while((strLine = in.readLine()) != null && c<num_trees)
			{
				String tokens = strLine;
//				System.out.println(c);
				int len=Integer.parseInt(in.readLine());
				{
					String[] h=in.readLine().split(" ");
					type root=null;
					if(tokens.equals("Integer"))
					{
						 root=new type<Integer>((Integer)Integer.parseInt(h[0]));

					}
					else if(tokens.equals("Float"))
					{
						 root=new type<Float>((Float)Float.parseFloat(h[0]));

					}
					else
					{
						root=new type<String>(h[0]);

					}
					for(int i=1;i<len;i++)
					{
						if(tokens.equals("Integer"))
						{
							Integer ino=Integer.parseInt(h[i]);

							insert(root,new type<>(ino));		
						}
						else if(tokens.equals("Float"))
						{
							Float fo=Float.parseFloat(h[i].toString());

							insert(root,new type<>(fo));		

						}
						else {
							insert(root,new type<>(h[i]));		



						}
					}
					int count=0;
					ArrayList<type> no=new ArrayList<>();
					display(root,no);
					String str=func(no,root,tokens);
//					System.out.println(tokens);
//					System.out.println(j+" j");
					hash.get(j).add(str) ;
					j=1;
					c++;
//					System.out.println("KHATMA SAB BHGDBPOFIAksndfNn;bjhsdjFNDJBVjbhlhvkvjhbn");
				}

			}

		}
		boolean[] h=new boolean[stu_num+1];
		int cu=0;
		for(Map.Entry e:hash.entrySet()) {
			
			ArrayList<String> n= (ArrayList<String>) e.getValue();
			if(!(n.size()==0)) 
			{
				System.out.print(e.getKey()+" :");
				for(String s:n)
				{
					System.out.print(s+" ");
				}
				System.out.println();
				h[(int) e.getKey()]=true;
				cu++;
			}
			else {
			h[(int) e.getKey()]=false;
			}
			
		}
		if(cu!=stu_num)
		{
			for(int i=1;i<=num_trees;i++)
			{
				if(	!h[i]){
					System.out.println(i);				}
			}
		}

	}
	static String func (ArrayList<type> no,type root,String val) {
		int count=1;
		Integer count1=0;
		String count2="";
		Float h=(float) 0.0;



		for(type<?> l : no)
		{

			if(l.equals(root))
			{	j=count;	
//			System.out.println(count+" "+root.getData());
			}
			
			if(val.equals("String"))
			{
				count2+=l.getData();}
			else if(val.equals("Float")) {
				h+=Float.parseFloat(l.getData().toString());
			}
			else if(val.equals("Integer")) {
				count1+=Integer.parseInt( l.getData().toString());
//				System.out.println(count1);
			}
			count++;


		}
		if(val.equals("String"))
		{
//			System.out.println(count2+" string");
			return count2.toString();
		}
		else if(val.equals("Float"))
		{		
//			System.out.println(h+"FLOAT ");

			return h.toString();		}
		else if(val.equals("Integer")) {
//			System.out.println(count1);

			return count1.toString();

		}
		return "sharara";
	}
}
