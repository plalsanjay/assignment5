//package col106.assignment5;

import java.util.Comparator;

/*
Implementation of MergeSort Algorithm :
    1. you get linked list of size <=1 you just return the list as it is already sorted
    2. Find mid node using findSplit method(Don't forget to add mid element to globalList before returning it)
    3. Create two LinkedList lt (with head = head and tail = mid) and rt (with head = mid.next and tail = tail)
    4. Now recursively MergSort lt and rt Linked lists(Maintain this order)
    5. Now merge these two lists that we got from recursive calls using given crieteria for ordering
    6. Return merged Linked list
*/

public class LLMergeSort <T>  {
	


  LinkedList<T>  globalList = new LinkedList<T>();

  //CALL THIS METHOD AFTER EVERY CALL OF findSplit and DO NOT MODIFY THIS METHOD
  public void adjustGlobalPointer(T node){
      globalList.add(node);
  }

  // Utility function to get the middle of the linked list
  public Node<T> findSplit(LinkedList<T>lst) {
    //find middle node of LL :
	int s = lst.getSize();
	if (s%2==0){
	s=s/2;}
	else{
		s=s/2+1;}
    Node<T> middle = lst.getHead();
		
	int r =0;
	while(r<s-1){
	//System.out.println(middle);
	middle =middle.getNext();
	r=r+1;}
	
	

    //Enter your code here
    //!!!!!*****DO NOT REMOVE THIS METHOD CALL (change the argument apprpriately)*****!!!!!
    adjustGlobalPointer(middle.getData()); //Add object of ItemNode after finding mid in each call
    return middle;
  }
 public Node<T> findSplit1(LinkedList<T>lst) {
    //find middle node of LL :
	int s = lst.getSize();
if (s%2==0){
	s=s/2;}
	else{
		s=s/2+1;}
    Node<T> middle = lst.getHead();
		
	int r =0;
	while(r<s-1){
	//System.out.println(middle);
	middle =middle.getNext();
	r=r+1;}
	
	

    //Enter your code here
    //!!!!!*****DO NOT REMOVE THIS METHOD CALL (change the argument apprpriately)*****!!!!!
    //adjustGlobalPointer(middle.getData()); //Add object of ItemNode after finding mid in each call
    return middle;
  }


  public LinkedList<T>  MergeSort(LinkedList<T>  lst) {
    //Recursively Apply MergeSort, by calling function findSplit(..) to find middle node to split
    //Enter your code here
	int ni = lst.getSize();
	int xi =ni/2;
	if(ni%2!=0){
		xi=xi+1;}
	int o = ni-xi;
	Node<T> s = findSplit(lst);
	LinkedList<T> q = new LinkedList<T>();
	LinkedList<T> w = new LinkedList<T>();
	Node<T> qr = s.next;
	s.next=null;
	q.setHead(lst.getHead());
	q.setTail(s);
	q.setSize(xi);
	w.setHead(qr);
	w.setTail(lst.getTail());
	w.setSize(o);
	//System.out.println(q.getSize());
	
	
	
	if(q.getSize()>1){
	q = MergeSort(q);}
	if(w.getSize()>1){
	w = MergeSort(w);}

	LinkedList<T> km = new LinkedList<T>();
	int n = q.getSize();
	int m = w.getSize();
	Node<T>x = q.getHead();
	Node<T>y = w.getHead();
	int ii =0;
	int jj=0;
	//String g = x.toString();
	//System.out.println(g);

						

	while(ii<n && jj<m){
		  ItemNode we = (ItemNode)x.getData();
		 ItemNode me = (ItemNode)y.getData();
		if(we.m.getHead().getData().getDate().year<(me.m.getHead().getData().getDate().year)){
				km.add(x.getData());
			ii++;	
			x=x.next;	}
		else if (we.m.getHead().getData().getDate().year==(me.m.getHead().getData().getDate().year)){

			if(we.m.getHead().getData().getDate().month<(me.m.getHead().getData().getDate().month)){
					km.add(x.getData());
					ii++;	
					x=x.next;		}
			else if (we.m.getHead().getData().getDate().month==(me.m.getHead().getData().getDate().month)){
				if(we.m.getHead().getData().getDate().day<(me.m.getHead().getData().getDate().day)){
							km.add(x.getData());
							ii++;	
					x=x.next;			}
			else if (we.m.getHead().getData().getDate().day==(me.m.getHead().getData().getDate().day)){
				if (we.itemName.compareTo(me.itemName)>0){
						km.add(x.getData());
						ii++;
					x=x.next;		}
				else {
					km.add(y.getData());
					jj++;
					y=y.next;}

				}
			else {
					km.add(y.getData());
					jj++;
					y=y.next;}
				}

			else {
					km.add(y.getData());
					jj++;
					y=y.next;}
				}
		else {
					km.add(y.getData());
					jj++;
					y=y.next;}
			}

		while (ii<n){
				km.add(x.getData());
				x=x.next;
				ii++;		}
		while(jj<m){
				km.add(y.getData());
				y=y.next;
				jj++;	}
		//System.out.println(km.getSize());

		return km;
//	return null;
  }
	public LinkedList<T> MergeSort1(LinkedList<T> lst){
			int ni = lst.getSize();
	int xi =ni/2;
	if(ni%2!=0){
		xi=xi+1;}
	int o = ni-xi;
	Node<T> s = findSplit1(lst);
	LinkedList<T> q = new LinkedList<T>();
	LinkedList<T> w = new LinkedList<T>();
	Node<T> qr = s.next;
	s.next=null;
	q.setHead(lst.getHead());
	q.setTail(s);
	q.setSize(xi);
	w.setHead(qr);
	w.setTail(lst.getTail());
	w.setSize(o);
	//System.out.println(q.getSize());
	
	
	
	if(q.getSize()>1){
	q = MergeSort1(q);}
	if(w.getSize()>1){
	w = MergeSort1(w);}

	LinkedList<T> km = new LinkedList<T>();
	int n = q.getSize();
	int m = w.getSize();
	Node<T>x = q.getHead();
	Node<T>y = w.getHead();
	int ii =0;
	int jj=0;
	while(ii<n && jj<m){
		  PurchaseNode we = (PurchaseNode)x.getData();
		 PurchaseNode me = (PurchaseNode)y.getData();
		if(we.getDate().year>(me.getDate().year)){
				km.add(x.getData());
			ii++;	
			x=x.next;	}
		else if (we.getDate().year==(me.getDate().year)){

			if(we.getDate().month>(me.getDate().month)){
					km.add(x.getData());
					ii++;	
					x=x.next;		}
			else if (we.getDate().month==(me.getDate().month)){
				if(we.getDate().day>(me.getDate().day)){
							km.add(x.getData());
							ii++;	
					x=x.next;			}
			else if (we.getDate().day==(me.getDate().day)){
						km.add(x.getData());
						ii++;
					x=x.next;				
					km.add(y.getData());
					jj++;}
			else {
					km.add(y.getData());
					jj++;
					y=y.next;}
				}

			else {
					km.add(y.getData());
					jj++;
					y=y.next;}
				}
		else {
					km.add(y.getData());
					jj++;
					y=y.next;}
			}

		while (ii<n){
				km.add(x.getData());
				x=x.next;
				ii++;		}
		while(jj<m){
				km.add(y.getData());
				y=y.next;
				jj++;	}
		//System.out.println(km.getSize());

		return km;
//	return null;
  }
 public LinkedList<T>  MergeSort2(LinkedList<T> lst,int day1,int month1,int year1, int day2, int month2, int year2) {
    //Recursively Apply MergeSort, by calling function findSplit(..) to find middle node to split
    //Enter your code here
	int ni = lst.getSize();
	int xi =ni/2;
	if(ni%2!=0){
		xi=xi+1;}
	int o = ni-xi;
	Node<T> s = findSplit(lst);
	LinkedList<T> q = new LinkedList<T>();
	LinkedList<T> w = new LinkedList<T>();
	Node<T> qr = s.next;
	s.next=null;
	q.setHead(lst.getHead());
	q.setTail(s);
	q.setSize(xi);
	w.setHead(qr);
	w.setTail(lst.getTail());
	w.setSize(o);
	//System.out.println(q.getSize());
	
	
	
	if(q.getSize()>1){
	q = MergeSort2(q,day1,month1,year1,day2,month2,year2);}
	if(w.getSize()>1){
	w = MergeSort2(w,day1,month1,year1,day2,month2,year2);}

	LinkedList<T> km = new LinkedList<T>();
	int n = q.getSize();
	int m = w.getSize();
	Node<T>x = q.getHead();
	Node<T>y = w.getHead();
	int ii =0;
	int jj=0;
	int Dat = Date(day1,month1,year1,day2,month2,year2);
	//String g = x.toString();
	//System.out.println(g);

						

	while(ii<n && jj<m){
		  ItemNode we = (ItemNode)x.getData();
		 ItemNode me = (ItemNode)y.getData();
			Node<PurchaseNode> aa = we.m.getHead();
			Node<PurchaseNode> bb = me.m.getHead();
		int kk =0;
		int ll=0;
			while(aa!=null){
			if(Dat-Date(day1,month1,year1,aa.getData().getDate().day,aa.getData().getDate().month,aa.getData().getDate().year)>=0 && Date(day1,month1,year1,aa.getData().getDate().day,aa.getData().getDate().month,aa.getData().getDate().year)>0){
					kk=kk+aa.getData().numItemsPurchased();}
				aa=aa.next;
					}
			while(bb!=null){
			if(Dat-Date(day1,month1,year1,bb.getData().getDate().day,bb.getData().getDate().month,bb.getData().getDate().year)>=0 && Date(day1,month1,year1,bb.getData().getDate().day,bb.getData().getDate().month,bb.getData().getDate().year)>0 ){
					ll=ll+bb.getData().numItemsPurchased();}
				bb=bb.next;
					}
			//System.out.println(kk);
			//System.out.println(ll);
			if(kk>ll){
			km.add(x.getData());
			ii++;	
			x=x.next;	}
		else if(kk==ll){
				if(we.getItemName().compareTo(me.getItemName())>0){
					km.add(x.getData());
					ii++;
					x=x.next;				
							}
				else{
					km.add(y.getData());
					jj++;							
					y=y.next;			}
		}
				
		else{
					km.add(y.getData());
					jj++;
					y=y.next;}
		}

		while (ii<n){
				km.add(x.getData());
				x=x.next;
				ii++;		}
		while(jj<m){
				km.add(y.getData());
				y=y.next;
				jj++;	}
		return km;
}
	

public int Date(int a,int b,int c,int d,int e,int f){
		int g = d-a;
		
		
		if(g<0){
			g = 30+d-a;
			e=e-1;		 }
		int k = e-b;
		if(k<0){
			k=12+e-b;
			f=f-1;	}
		int l = f-c;
		if(l<0){
			return -1;}
		int de = (l*12)*30+k*30+g;
			return de;		
		}
 public LinkedList<T>  MergeSort3(LinkedList<T>  lst){
	int ni = lst.getSize();
	int xi =ni/2;
	if(ni%2!=0){
		xi=xi+1;}
	int o = ni-xi;
	Node<T> s = findSplit(lst);
	LinkedList<T> q = new LinkedList<T>();
	LinkedList<T> w = new LinkedList<T>();
	Node<T> qr = s.next;
	s.next=null;
	q.setHead(lst.getHead());
	q.setTail(s);
	q.setSize(xi);
	w.setHead(qr);
	w.setTail(lst.getTail());
	w.setSize(o);
	//System.out.println(q.getSize());
	
	
	
	if(q.getSize()>1){
	q = MergeSort3(q);}
	if(w.getSize()>1){
	w = MergeSort3(w);}

	LinkedList<T> km = new LinkedList<T>();
	int n = q.getSize();
	int m = w.getSize();
	Node<T>x = q.getHead();
	Node<T>y = w.getHead();
	int ii =0;
	int jj=0;
	//String g = x.toString();
	//System.out.println(g);

						

	while(ii<n && jj<m){
		  ItemNode we = (ItemNode)x.getData();
		 ItemNode me = (ItemNode)y.getData();
		if(we.getStockLeft()>me.getStockLeft()){
				km.add(x.getData());
			ii++;	
			x=x.next;	}
		else if (we.getStockLeft()==me.getStockLeft()){
			if (we.getItemName().compareTo(me.getItemName())>0){
					km.add(x.getData());
					ii++;
					x=x.next;}
			else{
				km.add(y.getData());
				jj++;
				y=y.next;}
			}

			
			
		else {
					km.add(y.getData());
					jj++;
					y=y.next;}
			}

		while (ii<n){
				km.add(x.getData());
				x=x.next;
				ii++;		}
		while(jj<m){
				km.add(y.getData());
				y=y.next;
				jj++;	}
		//System.out.println(km.getSize());

		return km;
//	return null;
  }		
	public LinkedList<T>  MergeSort4(LinkedList<T>  lst) {
    //Recursively Apply MergeSort, by calling function findSplit(..) to find middle node to split
    //Enter your code here
	int ni = lst.getSize();
	int xi =ni/2;
	if(ni%2!=0){
		xi=xi+1;}
	int o = ni-xi;
	Node<T> s = findSplit(lst);
	LinkedList<T> q = new LinkedList<T>();
	LinkedList<T> w = new LinkedList<T>();
	Node<T> qr = s.next;
	s.next=null;
	q.setHead(lst.getHead());
	q.setTail(s);
	q.setSize(xi);
	w.setHead(qr);
	w.setTail(lst.getTail());
	w.setSize(o);
	//System.out.println(q.getSize());
	
	
	
	if(q.getSize()>1){
	q = MergeSort4(q);}
	if(w.getSize()>1){
	w = MergeSort4(w);}

	LinkedList<T> km = new LinkedList<T>();
	int n = q.getSize();
	int m = w.getSize();
	Node<T>x = q.getHead();
	Node<T>y = w.getHead();
	int ii =0;
	int jj=0;
	//String g = x.toString();
	//System.out.println(g);

						

	while(ii<n && jj<m){
		  ItemNode we = (ItemNode)x.getData();
		 ItemNode me = (ItemNode)y.getData();
		if(we.m.getHead().getData().getDate().year>(me.m.getHead().getData().getDate().year)){
				km.add(x.getData());
			ii++;	
			x=x.next;	}
		else if (we.m.getHead().getData().getDate().year==(me.m.getHead().getData().getDate().year)){

			if(we.m.getHead().getData().getDate().month>(me.m.getHead().getData().getDate().month)){
					km.add(x.getData());
					ii++;	
					x=x.next;		}
			else if (we.m.getHead().getData().getDate().month==(me.m.getHead().getData().getDate().month)){
				if(we.m.getHead().getData().getDate().day>(me.m.getHead().getData().getDate().day)){
							km.add(x.getData());
							ii++;	
					x=x.next;			}
			else if (we.m.getHead().getData().getDate().day==(me.m.getHead().getData().getDate().day)){
				if (we.itemName.compareTo(me.itemName)>0){
						km.add(x.getData());
						ii++;
					x=x.next;		}
				else {
					km.add(y.getData());
					jj++;
					y=y.next;}

				}
			else {
					km.add(y.getData());
					jj++;
					y=y.next;}
				}

			else {
					km.add(y.getData());
					jj++;
					y=y.next;}
				}
		else {
					km.add(y.getData());
					jj++;
					y=y.next;}
			}

		while (ii<n){
				km.add(x.getData());
				x=x.next;
				ii++;		}
		while(jj<m){
				km.add(y.getData());
				y=y.next;
				jj++;	}
		//System.out.println(km.getSize());

		return km;
//	return null;
  }


  //DO NOT CALL OR MODIFY THESE METHODS IN YOUR CALL THIS IS FOR USE IN DRIVER CODE
  public LinkedList<T> getGlobalList() {
    return this.globalList;
  }

  public void clearGlobalList(){
    globalList  = new LinkedList<>();
  }

}
