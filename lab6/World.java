package yahsss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import yahsss.Animal.Carnivore;
import yahsss.Animal.Carnivore.Herbivore;
import yahsss.Animal.Grassland;




abstract class Animal{
	protected float health;
	protected int timestamp;
	protected boolean dead;
	//protected int typeof;
	protected Grassland g1;
	protected Grassland g2;
	protected int[] coordinates;
	protected int radius;


	public float getHealth() {
		return health;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public int getradius() {
		return radius;
	}

	public void setTimestamp(int TS) {
		timestamp = TS;
	}

	public boolean getDead() {
		return dead;
	}

	public void setDaed() {
		dead = false;
	}

	public int[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(int[] nc) {
		coordinates[0] = nc[0];
		coordinates[1] = nc[1];
	}

	public int getDistance(int[] given) {
		double d = (double)((coordinates[1] - given[1]) * (coordinates[1] - given[1])) + ((coordinates[0] - given[0]) * (coordinates[0] - given[0]));
	    int finaldist = (int)(Math.floor(Math.sqrt(d)));
	    return finaldist;
	}



	public Animal(float h, int TS ,int x, int y , Grassland g1, Grassland g2) {
		this.health = h;
		timestamp  = TS;
		this.g1 = g1;
		this.g2 = g2;
	    boolean dead;
		this.coordinates = new int[2];
		coordinates[0] = x;
		coordinates[1] = y;
	}


	class Grassland{
		int availablegrass;
		int radius;
		int coordinates[];
		public Grassland(int availablegrass, int radius, int xc, int yc) {
			//super();
			this.availablegrass = availablegrass;
			this.radius = radius;
			this.coordinates = new int[2];
			coordinates[0] = xc;
			coordinates[1] = yc;
		}
		public int getAvailablegrass() {
			return availablegrass;
		}

//		public void setAvailablegrass(int availablegrass) {
//			this.availablegrass = availablegrass;
//		}
//
		public int getRadius() {
			return radius;
		}

//		public void setRadius(int radius) {
//			this.radius = radius;
//		}
//
		public int[] getCoordinates() {
			return coordinates;
		}

// one parameter left here

	}

	public int compareTo(Animal m) {
		if(this.getTimestamp() > m.getTimestamp()) {
			return 1;
		}
		else if(this.getTimestamp() < m.getTimestamp()) {
			return -1;
		}
		else {
			if(this.getHealth() > m.getHealth()) {
				return 1;
			}
			else if(this.getHealth() < m.getHealth()) {
				return -1;
			}
			else {
				if(this.getClass() == m.getClass()) {
					int[] origin = {0,0};
				  //origin.x = 0;
					if(this.getDistance(origin) > m.getDistance(origin)) {
						return 1;
					}
					else if(this.getDistance(origin) < m.getDistance(origin)) {
						return -1;
					}
					else {
						return 0;
					}
				}
				else if(m instanceof Herbivore) {
					return 1;
				}



			}
		}
		return 1;

	}

	public boolean grassland(Animal m) {
	//	m.getCoordinates();
		int x = m.coordinates[0];
		int y = m.coordinates[1];
		int r = m.radius;
		if((x*x) + (y*y) <= (r*r)) {
			return true;
		}
		else {
			return false;
		}
	}



	class Carnivore extends Animal{
	//	Herbivore h1 = new Herbivore(health, radius, radius, radius, g1, g1, radius);
		//Herbivore h1 = new Herbivore();
		//Herbivore h2 = new Herbivore();


		public Carnivore(float h, int TS, int x, int y, Grassland g1, Grassland g2) {
			super(h, TS, x, y, g1, g2);
		}

		public void turn(World w) {
		//	if(w.PQ.h1.getDead() == true && w.PQ. )
			if(w.countherb == 0) {
				if(grassland(this)== true) {
					health = health - 30;
				}
				else {
					health = health - 60;
				}
		}
			else {
				//w.PQ.poll();
				//yahssssssssssssssssssssss
				//int d = getDistance(w.)
			}


	}


	class Herbivore extends Animal{
		int cap;


		public Herbivore(float h, int TS, int x, int y, Grassland g1, Grassland g2, int cap) {
			super(h, TS, x, y, g1, g2);
			this.cap = cap;
		}


	}
	}
}






public class World {
	//static PriorityQueue<String> PQ = new PriorityQueue<String>();

	World w = new World();
	PriorityQueue<Animal> PQ = new PriorityQueue<Animal>();
	static final int countcarn = 2;
	static final int countherb = 2;




	public void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter    Total   Final   Time   for   Simulation: ");
		int time = Integer.parseInt(reader.readLine());

		System.out.println("Enter    x,   y   centre,   radius   and   Grass   Available   for   First   Grassland: ");
		String[] gl1 = reader.readLine().split(" ");
		Grassland g1 = new Grassland(Integer.parseInt(gl1[3]) , Integer.parseInt(gl1[2]) , Integer.parseInt(gl1[0]) , Integer.parseInt(gl1[1]) );


		System.out.println("Enter    x,   y   centre,   radius   and   Grass   Available   for   Second   Grassland: ");
		String[] gl2 = reader.readLine().split(" ");
		Grassland g2 = new Grassland(Integer.parseInt(gl2[3]) , Integer.parseInt(gl2[2]) , Integer.parseInt(gl2[0]) , Integer.parseInt(gl2[1]) );


		System.out.println("Enter   Health   and   Grass   Capacity   for   Herbivores: ");
		String[] herb = reader.readLine().split(" ");


		System.out.println("Enter   x,   y   position   and   timestamp   for   First   Herbivore: ");
		String[] herb1 = reader.readLine().split(" ");
		Herbivore h1 = new Herbivore(Integer.parseInt(herb[0]),Integer.parseInt(herb1[2]) , Integer.parseInt(herb1[0]), Integer.parseInt(herb1[1]), g2, g2, Integer.parseInt(herb[1]));


		System.out.println("Enter   x,   y   position   and   timestamp   for   Second   Herbivore: ");
		String[] herb2 = reader.readLine().split(" ");
		Herbivore h2 = new Herbivore(Integer.parseInt(herb[0]),Integer.parseInt(herb2[2]) , Integer.parseInt(herb2[0]), Integer.parseInt(herb2[1]), g2, g2, Integer.parseInt(herb[1]));



		System.out.println("Enter   Health   for   Carnivores: ");
		int carn = Integer.parseInt(reader.readLine());


		System.out.println("Enter   x,   y   position   and   timestamp   for   First   Carnivore: ");
		String[] carn1 = reader.readLine().split(" ");
		Carnivore c1 = new Carnivore(carn , Integer.parseInt(carn1[2]),Integer.parseInt(carn1[0]) , Integer.parseInt(carn1[1]) , g1,g2);


		System.out.println("Enter   x,   y   position   and   timestamp   for   Second   Carnivore: ");
		String[] carn2 = reader.readLine().split(" ");
		Carnivore c2 = new Carnivore(carn , Integer.parseInt(carn2[2]),Integer.parseInt(carn2[0]) , Integer.parseInt(carn2[1]) , g1,g2);

		PQ.add(h1);
		PQ.add(h2);
		PQ.add(c1);
		PQ.add(c2);
	}
}
}
