package Home;

public class OrderID {
	private int orderid;

	public synchronized int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	
	public synchronized void addOrderID(){
		orderid=orderid+1;
	}
	
}
