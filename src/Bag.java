
import java.util.ArrayList;
import java.util.List;

public class Bag {
	public static int obj[][]={{2,6},{2,3},{6,5},{5,4},{4,6}};
	public static Integer bagspace=10;
	private static List<List<Status>> stas=new ArrayList<>();
	private static List<Status> sta=null;
	private static Status s=null;
	private static Status pre=null;
	public static void main(String[] args){
		for (int i = 0; i < obj.length; i++) {
			sta=new ArrayList<>();			
			if (i==0) {
				for (int j = 0; j < bagspace; j++) {
					s=new Status();
					s.space=bagspace;
					s.putobject(i);
					sta.add(s);
				}
			}else {
				for (int j = 0; j < bagspace; j++) {
					pre=stas.get(i-1).get(j);
					s=new Status();
					s.space=pre.space;
					s.value=pre.value;
					s.objectindexes.addAll(pre.objectindexes);
					if (s.putobject(i)==0) {
						s.replaceobj(i);
					} else {
						
					}
					sta.add(s);
				}
			}
			stas.add(sta);
		}		
		for (int i = 0; i < stas.get(4).get(9).objectindexes.size(); i++) {
			System.out.println(stas.get(4).get(9).objectindexes.get(i));
		}
	}

}
