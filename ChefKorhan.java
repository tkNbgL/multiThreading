package Home;

public class ChefKorhan implements Runnable{
	OrderListKorhan orderToKorhanCon;
	DeliveryTable deliveryToWaiters;
	
	public ChefKorhan(OrderListKorhan orderToKorhanCon,DeliveryTable deliveryToWaiters){
		this.orderToKorhanCon=orderToKorhanCon;
		this.deliveryToWaiters=deliveryToWaiters;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
				int orderID=orderToKorhanCon.orderConsumer();
			//	System.out.println("order"+ orderID + " is reached chef KORHAN\n");
				
			//	System.out.println("order"+ orderID +  " is going to DELÝVERYTABLE to serve by KORHAN\n");
				deliveryToWaiters.deliveryProducer(orderID);
			
			
			}
	}
	
	
}
