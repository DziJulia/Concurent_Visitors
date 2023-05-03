/**
 * Lab04
 * ViewStand.java
 *
 * Student Name: Julia Dobrovodska	
 * Student Number: 3061278
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ViewStand {
	Boolean seats[];
	int max;
	Lock lock = new ReentrantLock();
	Condition seatFull = lock.newCondition();

	public ViewStand(int m) {
		this.max = m;
		this.seats = new Boolean[m];
		for(int i = 0; i < m; i++) {
			seats[i] = true;
		}
	}

	public int seat_take(){
		lock.lock();
		try{
			while(max == 0){
				try{
					seatFull.await();
				}
				catch(InterruptedException e){}
			}
			int k = 0;
			while(!seats[k]) k++;
			seats[k] = false;
			max --;
			return k;
		}finally {
			lock.unlock();
		}
	}


	public void leave(int count){
		lock.lock();
		try{
			seats[count] = true; 
			max++;
			seatFull.signal();

		}finally {
			lock.unlock();
		}


	}
}
