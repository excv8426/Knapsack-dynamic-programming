
import java.util.ArrayList;
import java.util.List;

public class Bag {
	public static int objects[][]={{2,6},{2,3},{6,5},{5,4},{4,6}};
	public static Integer bagspace=10;
	private static List<List<Status>> stas=new ArrayList<>();
	private static List<Status> sta=null;
	private static Status s=null;
	public static void main(String[] args){

		for (int i = 0; i < objects.length; i++) {
			sta=new ArrayList<>();			
			//首个物体，有空间则放入。
			if (i==0) {
				for (int j = 0; j < bagspace+1; j++) {
					s=new Status();
					s.space=j;
					s.putobject(i);
					sta.add(s);
				}
			}else {
				for (int j = 0; j < bagspace+1; j++) {
					s=new Status();
					//空间不足，必然不放入。
					if (objects[i][0]>j) {
						s.space=stas.get(i-1).get(j).space;
						s.value=stas.get(i-1).get(j).value;
					} else {
						//物体i可以放入，但（物体i的价值+剩余空间放入前i-1个物体的价值）<所有空间用于放入前i-1个物体的价值，因此不放入物体i。
						if (stas.get(i-1).get(j).value>=(stas.get(i-1).get(j-objects[i][0]).value+objects[i][1])) {
							s.space=stas.get(i-1).get(j).space;
							s.value=stas.get(i-1).get(j).value;
						} else {
							s.space=j;
							s.putobject(i);
							s.space=s.space-stas.get(i-1).get(j-objects[i][0]).space;
							s.value=s.value+stas.get(i-1).get(j-objects[i][0]).value;
						}
					}
					sta.add(s);
				}
			}
			stas.add(sta);
		}		

		int c=stas.get(0).size()-1;
		int output=-1;
		for (int i = objects.length-1; i > -1; i--) {
			output=stas.get(i).get(c).lastput;
			if (output!=-1) {
				System.out.println(output);
				c=c-objects[output][0];
			}
		}
	}

}
