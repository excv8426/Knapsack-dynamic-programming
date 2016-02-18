
import java.util.ArrayList;
import java.util.List;

public class Bag {
	public static int objects[][]={{5,4},{2,3},{6,5},{2,6},{4,6}};
	public static Integer bagspace=10;
	private static List<List<Status>> stas=new ArrayList<>();
	private static List<Status> sta=null;
	private static Status s=null;
	public static void main(String[] args){

		for (int i = 0; i < objects.length; i++) {
			sta=new ArrayList<>();			
			if (i==0) {
				for (int j = 0; j < bagspace+1; j++) {
					s=new Status();
					s.space=j;
					s.putobject(i);
					sta.add(s);
					//System.out.println("ccc");
				}
			}else {
				for (int j = 0; j < bagspace+1; j++) {
					s=new Status();
					s.space=j;
					if (s.putobject(i)==0) {
						s.space=stas.get(i-1).get(j).space;
						s.value=stas.get(i-1).get(j).value;
						s.objectindexes.addAll(stas.get(i-1).get(j).objectindexes);
						//System.out.println("ccc");
					} else {
						s.objectindexes.remove(0);
						if (stas.get(i-1).get(j).value>=(stas.get(i-1).get(j-objects[i][0]).value+objects[i][1])) {
							s.space=stas.get(i-1).get(j).space;
							s.value=stas.get(i-1).get(j).value;
							s.objectindexes.addAll(stas.get(i-1).get(j).objectindexes);
							
						} else {
							s.space=j;
							s.putobject(i);
							for (int j2 = 0; j2 < stas.get(i-1).get(j-objects[i][0]).objectindexes.size(); j2++) {
								
								s.putobject(stas.get(i-1).get(j-objects[i][0]).objectindexes.get(j2));
							}
						}
						
					}
					sta.add(s);
				}
			}
			stas.add(sta);
		}		
		for (int i = 0; i < stas.get(4).get(10).objectindexes.size(); i++) {
			System.out.println(stas.get(4).get(10).objectindexes.get(i));
		}
	}

}
