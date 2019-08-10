package Home;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class OrderListHuseyin extends Observable{

	private ArrayList<Integer> orderList=new ArrayList<Integer>();
	private final int size=6;
	private OrderID orderid;
	private int lastIndex;
	
	public int getMaxSize(){
		return size;
	}
	
	public OrderListHuseyin(OrderID orderid){
		this.orderid=orderid;
		
	}
	
	public int getSize(){
		return orderList.size();
	}
	
	public ArrayList<Integer> getList(){
		return orderList;
	}
	
	/*public void addListener(MyEventListener listener){
		
		listeners.add(listener);
	}*/
	
	public void lastIndexinc(){
		lastIndex++;
	}
	
	public void lastIndexdec(){
		lastIndex--;
	}
	
	
	
	
	public int getLastIndex() {
		return lastIndex;
	}

	public synchronized void orderProducer(String name){
		//System.out.println("size of huseyin's orderlist is "+getSize()+" \n");
		while(orderList.size()==size){
			System.out.println("huseyin queue is full and waiting\n");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		orderList.add(orderid.getOrderid());
		setChanged();
		notifyObservers();
		System.out.println(name+" Produced: "+ orderid.getOrderid() +"\n");
		//System.out.println("size of huseyin's orderlist is "+getSize()+" \n");
		orderid.addOrderID();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notify();
	}
	
	public synchronized int orderConsumer(){
		//System.out.println("size of huseyin's orderlist is "+getSize()+"after consumed \n");
		while(orderList.isEmpty()){
			System.out.println("huseyin queue is empty orderConsumer is waiting\n");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int order=orderList.remove(0);
		//System.out.println(order +"huseyin  consumed\n");
		//System.out.println("size of huseyin's orderlist is "+getSize()+"after consumed \n");
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
