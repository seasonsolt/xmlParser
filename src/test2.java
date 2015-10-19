import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class test2 {
	 public static void main333(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException{
		 Integer a = 128;
		 String b = new String("128");
		 
		 printTest(Integer.class, a);
		 printTest(String.class, b);
		 
		 test1 test = new test1();
		/* 
		 Field[] fields = test.getClass().getDeclaredFields();
		 for(Field field:fields){
			 System.out.println(field.toString());
		 }
		 
		 Method[] methods = test.getClass().getMethods();
		 for(Method method:methods){
			 System.out.println(method.toString());
		 }*/


//		 System.out.println(test.getName());
		 Method method = test.getClass().getMethod("getName");
		 method.setAccessible(true);
//		 System.out.println(test.getClass().getMethod("getName").invoke(test, null));
	 }

	 /*
	  * 泛型打印
	  */
	private static void printTest(Class C, Object O) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		if(O instanceof String){
			System.out.println(O);
		}
		else if(O instanceof Integer){
			System.out.println(O.toString());
		}

		System.out.println(Class.forName(C.getName()));
		
		Class.forName(C.getName()).newInstance();
	}
	
	/*
	 * 反射转换 
	 */
}

