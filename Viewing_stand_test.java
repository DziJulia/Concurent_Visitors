/**
 * Lab04
 * Viewing_stant_test.java
 *
 * Student Name: Julia Dobrovodska	
 * Student Number: 3061278
 */

public class Viewing_stand_test{

	public static void main(String[] args) {

		ViewStand v = new ViewStand(10);
        //Starting from 1 as you can't have person 0 in reality
		for(int i=1; i <= 200;i++) {
			Visitor person = new Visitor(v, i);
			person.start();
		}
	}

}
