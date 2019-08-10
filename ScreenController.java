package Home;

import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingUtilities;

public class ScreenController implements Observer{
	
	private NewOrderInformationScreen theView;
	private Observable orderListHuseyin;
	private Observable orderListKorhan;
	private Observable deliveryTable;
	private Object monitor=new Object();
	
	public ScreenController(NewOrderInformationScreen theView,Observable orderListHuseyin,Observable orderListKorhan,Observable deliveryTable){
		this.theView=theView;
		this.orderListHuseyin = orderListHuseyin;
		orderListHuseyin.addObserver(this);
		this.orderListKorhan=orderListKorhan;
		orderListKorhan.addObserver(this);
		this.deliveryTable=deliveryTable;
		deliveryTable.addObserver(this);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		synchronized(monitor){
			if(o instanceof OrderListHuseyin){
				OrderListHuseyin listOfhuseyin=(OrderListHuseyin) o;
				SwingUtilities.invokeLater(new Runnable () {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						//theView.getLblhuseyinOrder2().setText(Integer.toString(listOfhuseyin.getList().get(0)));
						theView.getListHuseyin().setListData(listOfhuseyin.getList().toArray());
						//theView.getLblhuseyinOrder1().setText(Integer.toString(listOfhuseyin.getList().get(0)));
						//System.out.println("asdasds");
					}
					
				});
			}
			
			if(o instanceof OrderListKorhan){
				OrderListKorhan listOfkorhan=(OrderListKorhan) o;
				SwingUtilities.invokeLater(new Runnable () {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						theView.getListKorhan().setListData(listOfkorhan.getList().toArray());
						//theView.getLblkorhanOrder2().setText(Integer.toString(listOfkorhan.getList().lastIndexOf(listOfkorhan)));
						//theView.getLblkorhanOrder1().setText(Integer.toString(listOfkorhan.getList().get(0)));
						//System.out.println("asdasds");
					}
					
				});
			}
			
			if(o instanceof DeliveryTable){
				DeliveryTable listOfdel=(DeliveryTable) o;
				SwingUtilities.invokeLater(new Runnable () {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						theView.getListDelivery().setListData(listOfdel.getList().toArray());
						
						//theView.getLblDelivery1().setText(Integer.toString(listOfdel.getList().lastIndexOf(listOfdel)));
						//theView.getLblDelivery2().setText(Integer.toString(listOfdel.getList().get(0)));
						//System.out.println("asdasds");
					}
					
				});
			}
		}
	}

}
