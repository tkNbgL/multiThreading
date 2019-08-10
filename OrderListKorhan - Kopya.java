package Home;

import java.util.ArrayList;
import java.util.Observable;

public class OrderListKorhan extends Observable{
	private ArrayList<Integer> orderListKorhan=new ArrayList<Integer>();
	private final int size=6;
	private OrderID orderID;
	private int lastIndex;
	
	public int getLastIndexinc(){
		return lastIndex++;
	}
	
	public int getLastIndexdec(){
		return lastIndex--;
	}
	
	public OrderListKorhan(OrderID orderID){
		this.orderID=orderID;
	}
	
	public int getSize(){
		return orderListKorhan.size();
	}
	
	public ArrayList<Integer> getList(){
		return orderListKorhan;
	}
	
	public synchronized void orderProducer(String WaiterName){
		//System.out.println("before produced size of kurhan orderlist "+getSize()+ " \n");
		while(orderListKorhan.size()==size){
			System.out.println("KORHAN queue is full and waiting");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		orderListKorhan.add(orderID.getOrderid());
		setChanged();
		notifyObservers();
		System.out.println(WaiterName +	" Produced: "+ orderID.getOrderid() +"\n");
		//System.out.println("after produced size of kurhan orderlist "+getSize()+ " \n");
		orderID.addOrderID();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notify();
	}
	
	
	public synchronized int orderConsumer(){
		//System.out.println("before conusme size of kurhan orderlist "+getSize()+ " \n");
		while(orderListKorhan.isEmpty()){
			System.out.println("KORHAN queue is empty orderConsumer is waiting\n");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int order=orderListKorhan.remove(0);
		//System.out.println(order +"KORHAN is consumed\n");
		//System.out.println("after consumed size of kurhan orderlist "+getSize()+ " \n");
		setChanged();
		notifyObservers();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notify();
		return order;
	}
}
