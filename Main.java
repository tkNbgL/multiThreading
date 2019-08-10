package Home;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args){

		OrderID orders=new OrderID();
		OrderListHuseyin huseyinOrderList=new OrderListHuseyin(orders);
		OrderListKorhan korhanOrderList=new OrderListKorhan(orders);
		DeliveryTable deliveryTable=new DeliveryTable();
		NewOrderInformationScreen view=new NewOrderInformationScreen();
		ScreenController controller=new ScreenController(view,huseyinOrderList,korhanOrderList,deliveryTable);
		view.setVisible(true);
		
		KorhansWaiter kothanwaiter=new KorhansWaiter("osman",korhanOrderList,deliveryTable);
		KorhansWaiter kothanwaiter2=new KorhansWaiter("alican",korhanOrderList,deliveryTable);
		KorhansWaiter kothanwaiter3=new KorhansWaiter("mustafa",korhanOrderList,deliveryTable);
		KorhansWaiter kothanwaiter4=new KorhansWaiter("oktay",korhanOrderList,deliveryTable);
	
		JustInCaseWaiters universal=new JustInCaseWaiters("Cagatay",huseyinOrderList,korhanOrderList,deliveryTable);
		JustInCaseWaiters universal2=new JustInCaseWaiters("burcu",huseyinOrderList,korhanOrderList,deliveryTable);
		
		
		
		HuseyinsWaiter huseyinwaiter=new HuseyinsWaiter("özgür",huseyinOrderList,deliveryTable);
		HuseyinsWaiter huseyinwaiter2=new HuseyinsWaiter("gökhan",huseyinOrderList,deliveryTable);
		ChefHuseyin chef=new ChefHuseyin(huseyinOrderList,deliveryTable);
		ChefKorhan chef2=new ChefKorhan(korhanOrderList,deliveryTable);
		
		ExecutorService executor=Executors.newCachedThreadPool();
		
		executor.execute(huseyinwaiter);
		executor.execute(huseyinwaiter2);
		
		executor.execute(kothanwaiter);
		executor.execute(kothanwaiter2);
		executor.execute(kothanwaiter3);
		executor.execute(kothanwaiter4);
		executor.execute(universal);
		executor.execute(universal2);
	
		
		executor.execute(chef);
		executor.execute(chef2);
		executor.shutdown();
	}	
}
