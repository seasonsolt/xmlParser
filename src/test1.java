import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class test1 {  
	/*
    public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {  
        ArrayList<Integer> arrayList3=new ArrayList<Integer>();  
        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer  
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");  
        Integer size = (Integer)arrayList3.getClass().getMethod("size", null).invoke(arrayList3, null);

        String tar = (String)arrayList3.getClass().getMethod("get", int.class).invoke(arrayList3, 1);

        System.out.println("tar="+tar);  
        System.out.println("size="+size);  
        System.out.println("size="+arrayList3.size());  
        for (int i=0;i<arrayList3.size();i++) {  
            System.out.println(arrayList3.get(i));  
        }  
    }  */
	
	
	private String Name = new String("Thin");
	
	private String Sex = new String("Man");

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}
	
	
	
}