package org.share.topic.impl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class CopyObject {
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.setAddress("沈阳");
		person.setName("test");
		person.setId(1);
		Object instance = copyPerson(person);
		System.out.println(instance);
	}
	
	public static Object copyPerson(Object obj) throws Exception {
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Constructor constructor = clazz.getDeclaredConstructor(new Class[] {});
		Object instance = constructor.newInstance(new Object[] {});
		for(Field field : fields) {
			String name = field.getName();
			Type type = field.getType();
			
			String setMethodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
			String getMethodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
			Method getMethod = clazz.getDeclaredMethod(getMethodName, new Class[] {});
			
			Object getResult = getMethod.invoke(obj, new Object[] {});
			Method setMethod = clazz.getDeclaredMethod(setMethodName, new Class[] {type.getClass()});
			setMethod.invoke(instance, getResult);
		}
		return instance;
	}
}
