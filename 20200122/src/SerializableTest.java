import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unit unit = new Unit(1, "��ũ", 1, 10, 10);
		
		System.out.println(unit);
		
		unit.setLevel(2);
		
		System.out.println("���Ͽ� �����ϴ� Ŭ���� �ν��Ͻ� ���� : "+unit);
		String dir = "./text.txt";
		try(
				FileOutputStream fos = new FileOutputStream(dir);
				ObjectOutputStream oos = new ObjectOutputStream(fos);	
				FileInputStream fis = new FileInputStream(dir);
			    ObjectInputStream ois = new ObjectInputStream(fis);
		)
		{
			oos.writeObject(unit);
			
			Unit unit1 = new Unit(2, "����", 1, 10, 10);
			oos.writeObject(unit1);
			
			List<Unit> unit2 = new ArrayList<Unit>();
			
			unit2.add((Unit)(ois.readObject()));
			unit2.add((Unit)(ois.readObject()));
			
			for(Unit temp:unit2)
				System.out.println("���Ͽ��� �о�� Ŭ���� �ν��Ͻ� ���� : "+temp.toString());
			
			System.out.println();
			
			dir = "./text2.txt";
			
			oos.writeObject(unit2);
			
			ArrayList<Unit> unitList = (ArrayList<Unit>)(ois.readObject());
			
			for(Unit u:unitList)
				System.out.println("���Ͽ��� �о�� Ŭ���� �ν��Ͻ� ���� : "+u.toString());
		} catch(Exception e) {
			System.out.println("���� : "+e.getMessage());
		}
	}	

}
