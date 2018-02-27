import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class BST<T extends Comparable<T>> {
	Node root;
	static class Node<T>{
//		private  Node<T> root;
//		private Comparator<T> comparator;
		private T data;
		private Node<T> left;
		private Node<T> right;
		public Node(T data , Node<T> lt , Node<T> rt) {
			left = lt;
			right = rt;
			this.data = data;
		}
		
		public Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public String toString() {
			return data.toString();
		}
		
	}
    public void insert(T val) {
    	 if(isempty()) {
    	    	root = new Node(val);
    	    }
    	    else {
    	    	insert(root,val);
    	    }
    }
   
   private void insert(Node node, T val) {
    	if(val.compareTo((T) node.data) < 0) {
    		if(node.left == null) {
    			node.left = new Node(val);
    		}
    		else {
    			insert(node.left,val);
    		}
    	}
    	else if(val.compareTo((T) node.data) >= 0) {
    		if(node.right == null) {
    			node.right = new Node(val);
    		}
    		else {
    			insert(node.right,val);
    		}
    	}
    }
   
   public boolean isempty() {
	   return (root == null)? true: false;
   }

   
   ArrayList<Object> array = new ArrayList<Object>();
   public ArrayList<Object> inorder(ArrayList<Object> array) {
		function(root);
		return array;
   }
		private void function(Node root) {
			if(root != null) {
				function(root.left);
			//	array[index++] =  (Node) root.data;
				System.out.print(root + " ");
				array.add(root.data);
				function(root.right);
				
			}
		}
		
		   public static int count (Node root) { 
			   if (root==null)
			   return 0; 
			   else
			   return 1 + count (root.left) + count(root.right); 
		   }
		
		
		public class BSTFilesBuilder {

			public void createBSTFiles(int numStudents, int numTrees) {
				Random rand = new Random();
				for (int i = 1; i <= numTrees; i++) {
				    try {
						PrintWriter w = new PrintWriter("./src/" + i + ".txt", "UTF-8");
						int type = rand.nextInt(3) + 1;
						if(type == 1) {
							w.println("Integer");
							w.println(numStudents);
							for (int j = 1; j <= numStudents; j++) {
								w.print(rand.nextInt(1000));
								w.print(" ");
							}
						}
						else if(type == 2) {
							w.println("Float");
							w.println(numStudents);
							for (int j = 1; j <= numStudents; j++) {
								w.print(rand.nextFloat()*1000);
								w.print(" ");
							}
						}
						else {
							w.println("String");
							w.println(numStudents);
							String alphabet = "abcdefghijklmnopqrstuvwxyz";
							for (int j = 1; j <= numStudents; j++) {
								int len = rand.nextInt(10)+1;
								for (int k = 0; k < len; k++)
									w.print(alphabet.charAt(rand.nextInt(alphabet.length())));
								w.print(" ");
							}
						}
						w.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//	read text file insert in binary tree
	//	BST binarytree = new BST();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		int one = Integer.parseInt(reader.readLine());
//		int two = Integer.parseInt(reader.readLine());
//		int three = Integer.parseInt(reader.readLine());
//		int four = Integer.parseInt(reader.readLine());
//		int five = Integer.parseInt(reader.readLine());
//		int six = Integer.parseInt(reader.readLine());
//		int seven = Integer.parseInt(reader.readLine());

//		binarytree.insert(one);
//		binarytree.insert(two);
//		binarytree.insert(three);
//		binarytree.insert(four);
//		binarytree.insert(five);
//		binarytree.insert(six);
//		binarytree.insert(seven);
//
//		binarytree.inorder();
		try {
			FileInputStream file = new FileInputStream("\1.txt");
			int i=0;
			while((i = file.read()) != -1) {
				System.out.print((char)i);
			}
			file.close();
		}catch(Exception e) {System.out.println(e);}
		

		

		String[] array = reader.readLine().split(" ");
		int trees =array[0];
		int students = array[1];
		
		
		String type = reader.readLine();
		int number = Integer.parseInt(reader.readLine());
		String[] toinsert = reader.readLine().split(" ");
		
		
		ArrayList<ArrayList<?>> students = new ArrayList<ArrayList<?>>();
		for(int z=0;z<number+1;z++) {
			ArrayList stud = new ArrayList<String>();
			students.add(stud);
		}
		
		if(type == "String") {
			//String[] arr1;
			BST<String> bt1 = new BST<String>();
			for(int i=0;i<toinsert.length;i++) {
				bt1.insert(toinsert[i]);
			}
			ArrayList<Object> arr1 = new ArrayList<Object>();
			bt1.inorder(arr1);
			Iterator<Object> iterator1 = arr1.iterator();
			//String yahss = null;
			while(iterator1.hasNext()) {
				System.out.print( iterator1.next() + " ");
			}		
			int root1 = count(bt1.root.left);
			int r1 = arr1.indexOf(root1);
			int studentno1 = (int) arr1.get(r1);
			//System.out.println(studentno1 + yahss);
			
			
		}
		else if(type == "Float") {
			BST<Float> bt2 = new BST<Float>();
			for(int j=0;j<toinsert.length;j++) {
				bt2.insert(Float.parseFloat(toinsert[j]));
			}
			ArrayList<Object> arr2 = new ArrayList<Object>();
			bt2.inorder(arr2);
			//Iterator<Object> iterator2 = arr2.iterator();
			Float sum=(float) 0;
			for(int k=0;k<arr2.size();k++) {
				sum += (Float)(arr2.get(k));
				//System.out.println(sum);
			}
			int root2 = count(bt2.root.left);
			int r2 = arr2.indexOf(root2);
			int studentno2 = (int) arr2.get(r2);
			System.out.println(studentno2 + sum);
		}
		else {
			BST<Integer> bt3 = new BST<Integer>();
			for(int k=0;k<toinsert.length;k++) {
				bt3.insert(Integer.parseInt(toinsert[k]));
			}
			ArrayList<Object> arr3 = new ArrayList<Object>();
			bt3.inorder(arr3);
			int sup = 0;
			for(int t=0;t<arr3.size();t++) {
				sup += (int)(arr3.get(t));
				System.out.println(sup);
			}
			int root3 = count(bt3.root.left);
			int r3 = arr3.indexOf(root3);
			int studentno3 = (int) arr3.get(r3);
			System.out.println(studentno3 + sup);
		}
		


	}
//	//288 530 706 562 522 54 426 
}


