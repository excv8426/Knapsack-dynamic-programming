import java.util.ArrayList;
import java.util.List;

public class Status {
	public int space=0;
	public List<Integer> objectindexes=new ArrayList<>();
	public int value=0;
	
	/**
	 * 如果有足够的空间，
	 * 把序号为objectindex的物体放入背包，
	 * 计算背包的价值和剩余空间。*/
	public int putobject(int objectindex){
		if (space>=Bag.objects[objectindex][0]) {
			objectindexes.add(objectindex);
			space=space-Bag.objects[objectindex][0];
			value=value+Bag.objects[objectindex][1];
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 *如果背包有足够的空间，
	 *且置换后总价值增加，
	 *把背包中最后放入的物体换成序号为objectindex的物体。 */
	public int replaceobj(int objectindex){
		int lastobjectindex=objectindexes.size()-1;
		int afterreplacespace=space+Bag.objects[lastobjectindex][0]-Bag.objects[objectindex][0];
		int beforereplacevalue=value;
		int afterreplacevalue=value-Bag.objects[lastobjectindex][1]+Bag.objects[objectindex][1];
		if ((afterreplacespace>=0)&&(afterreplacevalue>beforereplacevalue)) {
			objectindexes.remove(lastobjectindex);
			objectindexes.add(objectindex);
			space=afterreplacespace;
			value=afterreplacevalue;
			return 1;
		} else {
			return 0;
		}
	}
	
	/*public int getvalue(List<Integer> os){
		int v=0;
		for (int i = 0; i < os.size(); i++) {
			v=v+Bag.objects[os.get(i)][1];
		}
		return v;
	}
	
	public int getspace(List<Integer> os){
		int s=Bag.bagspace;
		for (int i = 0; i < os.size(); i++) {
			s=s-Bag.objects[os.get(i)][0];
		}
		return s;
	}*/
}
