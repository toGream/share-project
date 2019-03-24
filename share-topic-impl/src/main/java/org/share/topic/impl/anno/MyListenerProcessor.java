package org.share.topic.impl.anno;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class MyListenerProcessor implements BeanPostProcessor{
	private Map<String,ModuleVO> exportBean = new HashMap<String,ModuleVO>();

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
//		if(methods != null) {
//			for(Method method : methods) {
//				System.err.println(method);
//				ExportModule exportModule = AnnotationUtils.findAnnotation(method, ExportModule.class);
//				String moduleName = exportModule.moduleName();
//				System.err.println(moduleName);
//			}
//		}
		Class clazz = bean.getClass();
		ExportModule exportModule = AnnotationUtils.findAnnotation(clazz, ExportModule.class);
		if(null != exportModule) {
			ModuleVO moduleVo = new ModuleVO();
			moduleVo.setType(exportModule.type());
			moduleVo.setModuleName(exportModule.moduleName());
			Field[] fields = clazz.getDeclaredFields();
			List<FieldVO> fieldVOs = new ArrayList<FieldVO>();
			for(Field field : fields) {
				ExportField exportField = field.getAnnotation(ExportField.class);
				if(null != exportField) {
					FieldVO fieldVo = new FieldVO();
					fieldVo.setFieldName(exportField.fieldName());
					fieldVOs.add(fieldVo);
				}
			}
			moduleVo.setFields(fieldVOs);
			exportBean.put(exportModule.type(), moduleVo);
		}
		return bean;
	}

	public Map<String, ModuleVO> getExportBean() {
		return exportBean;
	}
}
