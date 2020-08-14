//package col106.assignment5;

public class StockMgmt implements StockMgmtInterface {
	//!!!!!!!*********DON'T CREATE YOUR OWN OBJECTS OF LLMergeSort*********!!!!!!!
	//use these only this object to sort
	LLMergeSort mergeSortobj;

	LinkedList<CategoryNode> categories;

	//DO NOT MNODIFY THIS CONSTRUCTOR
	public StockMgmt() {

		mergeSortobj = new LLMergeSort();
		categories = new LinkedList<CategoryNode>();

		categories.add(new CategoryNode(1, "Mobile"));
		categories.add(new CategoryNode(2, "Utensils"));
		categories.add(new CategoryNode(3, "Sanitary"));
		categories.add(new CategoryNode(4, "MedicalEquipment"));
		categories.add(new CategoryNode(5, "Clothes"));

	}

	public void addItem(int categoryId, int itemId, String itemName, int stock) {
		//Your code goes here
		Node<CategoryNode> p = this.categories.getHead();
		//CategoryNode r = p.getData();
		while(p.getData().categoryId!=categoryId && p!=null){
			p = p.next;}
		Node<ItemNode> e = p.getData().itemList.getHead();
		ItemNode d = new ItemNode(itemId,itemName,stock);
		p.getData().itemList.add(d);
			
		
	}

	public void addItemTransaction(int categoryId, int itemId, String itemName, int numItemPurchased, int day, int month, int year) {
		//Your code goes here
		Node<CategoryNode> p = this.categories.getHead();
		while(p.getData().categoryId!=categoryId){
			p = p.next;}
		Node<ItemNode> e = p.getData().itemList.getHead();
		while(e.getData().itemId!=itemId){
			e = e.next;}
		Node<PurchaseNode> m = e.getData().m.getHead();
		PurchaseNode d = new PurchaseNode(numItemPurchased,day,month,year);
		e.getData().addTransaction(d);
		e.getData().m=mergeSortobj.MergeSort1(e.getData().m);
			
	}

	//Query 1
	public LinkedList<ItemNode> sortByLastDate() {
		//Your code goes here
		LinkedList<ItemNode> b = new LinkedList<ItemNode>();
		Node<CategoryNode> p = this.categories.getHead();
		while(p!=null){
			Node<ItemNode> e = p.getData().itemList.getHead();
			while(e!=null && p.getData().itemList.getSize()>0){
				if(e.getData()!=null){
				b.add(e.getData());}
				//System.out.println(e.getData());
				e=e.next;}
			p = p.next;}
	LinkedList<ItemNode> m = mergeSortobj.MergeSort(b);
	return m;	
	}

	//Query 2
	public LinkedList<ItemNode> sortByPurchasePeriod(int day1, int month1, int year1, int day2, int month2, int year2) {
		//Your code goes here
		LinkedList<ItemNode> b = new LinkedList<ItemNode>();
		Node<CategoryNode> p = this.categories.getHead();
		while(p!=null){
			Node<ItemNode> e = p.getData().itemList.getHead();
			while(e!=null && p.getData().itemList.getSize()>0){
				if(e.getData()!=null){
				b.add(e.getData());			}
				//System.out.println(e.getData());
				e=e.next;}
			p = p.next;}
		LinkedList<ItemNode> m = mergeSortobj.MergeSort2(b,day1,month1,year1,day2,month2,year2);
		//System.out.println(m.getHead().getData().getItemName());
		return m;
	}

	//Query 3
	public LinkedList<ItemNode> sortByStockForCategory(int category) {
		//Your code goes here
	LinkedList<ItemNode> b = new LinkedList<ItemNode>();
	Node<CategoryNode> p = this.categories.getHead();
		while(p.getData().categoryId!=category){
			p = p.next;}
		Node<ItemNode> e = p.getData().itemList.getHead();
		while(e!=null && p.getData().itemList.getSize()>0){
			if(e.getData()!=null){
				b.add(e.getData());
				e=e.next;}
				}
		LinkedList<ItemNode> m = mergeSortobj.MergeSort3(b);

		return m;
	}

	//Query 4
	public LinkedList<ItemNode> filterByCategorySortByDate(int category) {
		//Your code goes here
	LinkedList<ItemNode> b = new LinkedList<ItemNode>();
	Node<CategoryNode> p = this.categories.getHead();
		while(p.getData().categoryId!=category){
			p = p.next;}
		Node<ItemNode> e = p.getData().itemList.getHead();
		while(e!=null && p.getData().itemList.getSize()>0){
			if(e.getData()!=null){
				b.add(e.getData());
				e=e.next;}
				}
		LinkedList<ItemNode> m = mergeSortobj.MergeSort4(b);
		return m;
	}

	//!!!!!*****DO NOT MODIFY THIS METHOD*****!!!!!//
	public LinkedList<ItemNode> checkMergeSort() {
		LinkedList<ItemNode> retLst = mergeSortobj.getGlobalList();
		mergeSortobj.clearGlobalList();
		return retLst;
	}
}
