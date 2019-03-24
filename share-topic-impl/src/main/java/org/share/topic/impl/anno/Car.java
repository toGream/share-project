package org.share.topic.impl.anno;

import org.springframework.stereotype.Component;

@ExportModule(type="car", moduleName="轿车模块")
@Component
public class Car {
	@ExportField(fieldName="type")
	private String type;
	@ExportField(fieldName="color")
	private String color;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
