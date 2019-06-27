package com.topica.annotation.example3;

import java.lang.reflect.Field;

public class MySession {
	public static void save(Object object) throws IllegalArgumentException, IllegalAccessException {
		Class<?> cls = object.getClass();
		MyTable myTableAnnotation = (MyTable) cls.getAnnotation(MyTable.class);
		String tableName = myTableAnnotation.value();
		Field fields[] = cls.getDeclaredFields();
		String query = "";
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.getDeclaredAnnotation(MyColumn.class) != null) {
				if (field.getType().equals(String.class)) {
					query += "'" + field.get(object) + "', ";
				} else {
					query += field.get(object) + ", ";
				}
			}
		}
		query = "INSERT INTO " + tableName + "(" + query.substring(0, query.length() - 2) + ")";
		System.out.println(query);
	}
	public static void findById(Object object, Long id) throws IllegalArgumentException, IllegalAccessException {
		Class<?> cls = object.getClass();
		MyTable myTableAnnotation = (MyTable) cls.getAnnotation(MyTable.class);
		String tableName = myTableAnnotation.value();
		Field fields[] = cls.getDeclaredFields();
		String query = "";
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.getDeclaredAnnotation(MyId.class) != null) {
				query += "SELECT * FROM " + tableName + " where id = " + id;
				break;
			}
		}
		System.out.println(query);
	}
}
