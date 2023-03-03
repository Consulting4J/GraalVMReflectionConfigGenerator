package com.consulting4j.graalvm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionConfigGenerator {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while (null != (line = br.readLine())) {
			String className = line.substring(0, line.length() - 5);
			StringBuffer sb = new StringBuffer();
			sb.append("{").append("\n");
			sb.append("  \"name\":\"" + "com.abc.model." + className + "\", ").append("\n");
			sb.append("  \"allDeclaredFields\":true,").append("\n");
			sb.append("  \"allPublicMethods\":true,").append("\n");
			sb.append("\"fields\":[").append("\n");
			Class<?> clazz = Class.forName("com.abc.model." + className);
			Field[] fields = clazz.getDeclaredFields();
			List<Field> real = new ArrayList<>();
			for (int i = 0; i < fields.length; i++) {
				int modifiers = fields[i].getModifiers();
				if ((!Modifier.isStatic(modifiers))) {
					real.add(fields[i]);
				}
			}
			for (int i = 0; i < real.size(); i++) {
				String filedName = real.get(i).getName();
				if (i < real.size() - 1)
					sb.append("{\"name\":\"" + filedName + "\"}, ").append("\n");
				else
					sb.append("{\"name\":\"" + filedName + "\"} ").append("\n");
			}
			sb.append("],").append("\n");

			sb.append("  \"methods\":[{\"name\":\"<init>\",\"parameterTypes\":[] }]").append("\n");
			sb.append("},").append("\n");
			System.out.println(sb.toString());
		}
		br.close();
	}
}
