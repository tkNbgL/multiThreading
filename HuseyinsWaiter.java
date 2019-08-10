package Home;

public class HuseyinsWaiter implements Runnable{
	private String WaitersName;
	OrderListHuseyin ordersToHuseyin;
	DeliveryTable DeliveryFromHuseyin;
	
	public HuseyinsWaiter(String WaitersName,OrderListHuseyin ordersToHuseyin, DeliveryTable DeliveryFromHuseyin){
		this.WaitersName=WaitersName;
		this.ordersToHuseyin=ordersToHuseyin;
		this.DeliveryFromHuseyin=DeliveryFromHuseyin;
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<15; i++){
				
			ordersToHuseyin.orderProducer(WaitersName);
			
			
		    DeliveryFromHuseyin.deliveryConsumer(WaitersName);	
		
				
		}
		
		
		
		
		
	}
	
}
