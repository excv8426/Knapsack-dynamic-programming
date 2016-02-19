

public class Status {
	public int space=0;
	public int value=0;
	public int lastput=-1;
	
	/**
	 * 如果有足够的空间，
	 * 把序号为objectindex的物体放入背包，
	 * 计算背包的价值和剩余空间。*/
	public int putobject(int objectindex){
		if (space>=Bag.objects[objectindex][0]) {
			lastput=objectindex;
			space=space-Bag.objects[objectindex][0];
			value=value+Bag.objects[objectindex][1];
			return 1;
		} else {
			return 0;
		}
	}
	
}
