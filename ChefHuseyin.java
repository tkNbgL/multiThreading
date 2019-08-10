package Home;

public class ChefHuseyin implements Runnable{
	OrderListHuseyin ordersToHuseyinCon;
	DeliveryTable deliveryToWaiters;
	
	public ChefHuseyin(OrderListHuseyin ordersToHuseyinCon,DeliveryTable deliveryToWaiters){
		this.ordersToHuseyinCon=ordersToHuseyinCon;
		this.deliveryToWaiters=deliveryToWaiters;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		
			int orderID=ordersToHuseyinCon.orderConsumer();
			//System.out.println("order"+ orderID + " is reached chef huseyin\n");
			
			//System.out.println("order"+ orderID +  " is going to DELÝVERYTABLE to serve by huseyin \n");
			deliveryToWaiters.deliveryProducer(orderID);
		
		
		}
	}

}
