package com.elead.bai.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


import com.elead.bai.anno.Enumration;
import com.elead.bai.anno.Max;
import com.elead.bai.anno.Min;
import com.elead.bai.anno.NotBlank;
import com.elead.bai.dao.UserDao;
import javax.validation.constraints.NotNull;

import org.springframework.util.CollectionUtils;

public class EleadUtil {
	public static boolean isNvlOrBlank(Object obj) {
		if (obj == null || obj.toString().trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	public static int getCollSize(Collection<Long> obj) {
		return obj.size();
	}

	public static String getStr(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString();
	}

	public static void checkRequireParam(String name, Object... strs) {
		for (Object str : strs) {
			if (isNvlOrBlank(str)) {
				throw new RuntimeException(String.format("param %s cannot be empty.", name));
			}
		}
	}

	public static <T> void validate(T obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
				NotBlank blankAnno = field.getAnnotation(NotBlank.class);
				NotNull nullAnno = field.getAnnotation(NotNull.class);
				Enumration enumAnno = field.getAnnotation(Enumration.class);
				Max maxanno=field.getAnnotation(Max.class);
				Min minanno=field.getAnnotation(Min.class);
				// 获取属性值
				field.setAccessible(true);
				Object value = field.get(obj);
				String name = field.getName();
				if (blankAnno != null) {
					checkRequireParam(name, value);
				}
				if (nullAnno != null) {
					if (value == null) {
						throw new RuntimeException(String.format("param %s cannot be null.", name));
					}
				}
				if (enumAnno != null) {
					String[] options = enumAnno.options();
					List<String> list = null;
					if (options == null || options.length == 0) {
						String enumName = enumAnno.value();
						if (!isNvlOrBlank(enumName)) {
							list = UserDao.getEnumList(enumName);
						}
					} else {
						list = Arrays.asList(options);
					}
					if (CollectionUtils.isEmpty(list)) {
						continue;
					}
					String val = getStr(value);
					if (!list.contains(val)) {
						throw new RuntimeException(String.format("param %s value not exists.", name));
					}
				}
				if (maxanno != null) {
					String option = maxanno.options();
					Integer options=Integer.parseInt(option);
					List<String> list = null;
					Integer max=null;
					if (options == null ) {
						String maxName = maxanno.value();
						if (!isNvlOrBlank(maxName)) {
							list = UserDao.getEnumList(maxName);
						}
					} else {
						max = options;
					}
					if (isNvlOrBlank(max)) {
						continue;
					}
					String val = getStr(value);
					if (Integer.parseInt(val) > max) {
						throw new RuntimeException(String.format("param %s value  > max illegal!!.", name));
					}
				}
				if (minanno != null) {
					String option = minanno.options();
					Integer options=Integer.parseInt(option);
					List<String> list = null;
					Integer min=null;
					if (options == null ) {
						String minName = minanno.value();
						if (!isNvlOrBlank(minName)) {
							list = UserDao.getEnumList(minName);
						}
					} else {
						min = options;
					}
					if (isNvlOrBlank(min)) {
						continue;
					}
					String val = getStr(value);
					if (Integer.parseInt(val) < min) {
						throw new RuntimeException(String.format("param %s value  < min illegal!!.", name));
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
