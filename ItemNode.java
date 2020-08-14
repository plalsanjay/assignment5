//package col106.assignment5;

public class ItemNode implements ItemInterface{

	int itemId;
	String itemName;
	int stock;
	LinkedList<PurchaseNode> m = new LinkedList<PurchaseNode>();
	

	public ItemNode(int itemId, String itemName, int stock){
		this.itemId = itemId;
		this.itemName = itemName;
		this.stock = stock;
		PurchaseNode we = new PurchaseNode(0,1,8,1970);
		this.m.add(we);
	}

	public int getItemId(){
		//Enter your code here
		return this.itemId;
	}

	public  String getItemName(){
		//Enter your code here
		return this.itemName;
	}

	public int getStockLeft(){
		//Enter your code here
		return this.stock;
	}

	public void addTransaction(PurchaseNode purchaseT){
		//Enter your code here
		int e= purchaseT.numItemsPurchased();
		this.stock=this.stock-e;
		Node<PurchaseNode> s = this.m.getHead();
		this.m.add(purchaseT);
		
	}

	public Node<PurchaseNode> getPurchaseHead(){
		//Enter your code here
		
		return m.getHead();

	}

}
