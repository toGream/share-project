package org.share.topic.impl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class TestReflect {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("org.share.topic.impl.reflect.Person");
		/**
		 * 获取类中所有的属性，方法，构造器
		 */
//		Field[] fields = clazz.getDeclaredFields();
//		for(Field field : fields) {
//			System.out.println(field);
//		}
//		Method[] methods = clazz.getDeclaredMethods();
//		for(Method method : methods) {
//			System.out.println(method);
//		}
//		Constructor[] constructors = clazz.getDeclaredConstructors();
//		for(Constructor constructor : constructors) {
//			System.out.println(constructor);
//		}
		
		/**
		 * 获取类中指定的属性，方法，构造器
		 */
//		Field field = clazz.getDeclaredField("name");
//		System.out.println(field);
//		Method method1 = clazz.getDeclaredMethod("getName", new Class[]{});
//		System.out.println(method1);
//		Method method2 = clazz.getDeclaredMethod("setName", new Class[] {String.class});
//		System.out.println(method2);
//		Constructor constructor1 = clazz.getDeclaredConstructor(new Class[] {});
//		System.out.println(constructor1);
//		Constructor constructor2 = clazz.getDeclaredConstructor(new Class[] {int.class, String.class, String.class});
//		System.out.println(constructor2);
		
		/**
		 * 通过构造器创建对象
		 */
		Constructor constructor1 = clazz.getDeclaredConstructor(new Class[] {});
		Object obj1 = constructor1.newInstance(new Object[] {});
		System.out.println(obj1);
		/**
		 * 调用set方法
		 */
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			//1.方法名称
			String methodName = method.getName();
			//2.是否是set方法
			boolean startsWith = methodName.startsWith("set");
			if(startsWith) {
				//3.截取字段名称
				String fieldName = methodName.substring(3);
				//4.字段名称首字母小写
				fieldName = fieldName.substring(0, 1).toLowerCase()+fieldName.substring(1);
				//5.获取字段对象
				Field field = clazz.getDeclaredField(fieldName);
				//6.获取字段类型
				Type type = field.getType();
				if(type == int.class) {
					method.invoke(obj1, 1);
				}
				if(type == String.class && "name".equals(fieldName)) {
					method.invoke(obj1, "张三");
				}
				if(type == String.class && "address".equals(fieldName)) {
					method.invoke(obj1, "北京");
				}
			}
		}
		System.out.println(obj1);
		
		Constructor constructor2 = clazz.getDeclaredConstructor(new Class[] {int.class, String.class, String.class});
		Object obj2 = constructor2.newInstance(new Object[] {1, "李四", "北京"});
		System.out.println(obj2);
	}
}
