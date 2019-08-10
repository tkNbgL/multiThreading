package Home;

public class JustInCaseWaiters implements Runnable{

	private String WaiterName;
	OrderListHuseyin ordersToHuseyin;
	OrderListKorhan ordersToKorhan;
	DeliveryTable DeliveryFromTable;
	
	public JustInCaseWaiters(String WaiterName,OrderListHuseyin ordersToHuseyin,OrderListKorhan ordersToKorhan,DeliveryTable DeliveryFromTable){
		this.WaiterName=WaiterName;
		this.ordersToHuseyin=ordersToHuseyin;
		this.ordersToKorhan=ordersToKorhan;
		this.DeliveryFromTable=DeliveryFromTable;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<15; i++){
			if(ordersToHuseyin.getSize()>=3){
				ordersToKorhan.orderProducer(WaiterName);
			}else{
				ordersToHuseyin.orderProducer(WaiterName);
			}
			DeliveryFromTable.deliveryConsumer(WaiterName);
		}
		
	}

}
