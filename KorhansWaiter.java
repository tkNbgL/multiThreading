package Home;

public class KorhansWaiter implements Runnable{
	private String WaiterName;
	OrderListKorhan ordersToKorhan;
	DeliveryTable DeliveryFromKorhan;
	
	public KorhansWaiter(String WaiterName,OrderListKorhan ordersToKorhan,DeliveryTable DeliveryFromKorhan){
		this.WaiterName=WaiterName;
		this.ordersToKorhan=ordersToKorhan;
		this.DeliveryFromKorhan=DeliveryFromKorhan;
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<15; i++){
			ordersToKorhan.orderProducer(WaiterName);
			
		
					DeliveryFromKorhan.deliveryConsumer(WaiterName);
				
			
		}
	}

}
