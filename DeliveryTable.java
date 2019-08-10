package Home;

import java.util.ArrayList;
import java.util.Observable;

public class DeliveryTable extends Observable{
	private ArrayList<Integer> DeliveryList=new ArrayList<Integer>();
	private final int size=5;
	
	public int getMaxSize(){
		return size;
	}
	
	
	public int getSize(){
		return DeliveryList.size();
	}
	
	public ArrayList<Integer> getList(){
		return DeliveryList;
	}
	
	public synchronized void deliveryProducer(int orderID){
		while(DeliveryList.size()==size){
			System.out.println("size of deliveryTable is"+ DeliveryList.size()+  "chef is waiting \n");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DeliveryList.add(orderID);
		setChanged();
		notifyObservers();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("order"+ orderID +   "is prepared and added to deliveryList\n");
		notify();
	}
	
	public synchronized void deliveryConsumer(String name){
		while(DeliveryList.isEmpty()){
			System.out.println("size of deliveryTable is " + DeliveryList.size() + "  waiters is waiting\n");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int servedID=DeliveryList.remove(0);
		setChanged();
		notifyObservers();
		System.out.println(servedID + " is served  by "+ name + "\n" );
		notify();
	}
}
