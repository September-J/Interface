//线性表
abstract class List{
	private int size; //保存线性表中的数据个数
	List(){
		size = 0;
	}
	public void pushFront(int val){
		insert(0,val);
	}
	public void pushBack(int val){
		insert(size,val);
	}
	//抽象方法，只给出方法签名，没有方法实现
	//方法实现子类来完成
	public abstract void insert(int index,int val);
	protected void incSize(){
		size++;
	}
	public int getSize(){
		return size;
	}
	abstract public void display();
}
//顺序表extends 线性表
class ArrayList extends List{
	private int[] array;
	ArrayList(){
		super();
		array = new int[10];
	}
	//重写
	@Override//可以用来做检查
	public void insert(int index,int val){
		for(int i = getSize();i>index;i--){
			array[i] = array[i-1];
		}
		array[index] = val;
		super.incSize();
	}
	@Override
	public void display(){
		for(int i=0;i<getSize();i++){
			System.out.println(array[i]);
		}
	}
}
//链表
class Node{
	int val;
	Node next = null;
	Node(int val){
		this.val = val;
	}
	Node(int val,Node next){
		this.val = val;
		this.next = next;
	}
}
class LinkedList extends List{
	private Node head = null;
	@Override
	public void insert(int index,int val){
		if(index == 0){
			head = new Node(val,head);
		}else{
			Node prev = head;
			for(int i = 0;i < index -1;i++){
				prev = prev.next;
			}
			//在这个结点后面插入val结点
			prev.next = new Node(val,prev.next);
		}
		incSize();
	}
	@Override
	public void display(){
		for(Node cur = head;cur!=null;cur=cur.next){
			System.out.println(cur.val);
		}
	}
}

public class Course0623{
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		list.pushFront(10);
		list.pushFront(20);
		list.pushFront(30);
		list.insert(3,100);
		list.display();
	}
}
