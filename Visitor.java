/**
 * Lab04
 * Visitor.java
 *
 * Student Name: Julia Dobrovodska	
 * Student Number: 3061278
 */
public class Visitor extends Thread{
	
	private ViewStand seat;
	int visitorNumber;
	
	//constructor new Visitor(1000 + i, v, i);
	public Visitor(ViewStand v, int j) {
		seat = v;
		visitorNumber = j;
	}
	
	public void run() {
		int seatNumber = seat.seat_take();
		System.out.println("Visitor: " + visitorNumber + " TAKE seat number :" + seatNumber);	
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e){
			throw new RuntimeException(e);
		}
		seat.leave(seatNumber);
		System.out.println("Visitor "+ visitorNumber +" LEFT seat number :" + seatNumber);	

	}

}
