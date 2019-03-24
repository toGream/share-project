package org.share.topic.impl.anno;

import java.util.List;

public class ModuleVO {
	private String type;
	private String moduleName;
	private List<FieldVO> fields;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public List<FieldVO> getFields() {
		return fields;
	}
	public void setFields(List<FieldVO> fields) {
		this.fields = fields;
	}
	@Override
	public String toString() {
		return "ModuleVO [type=" + type + ", moduleName=" + moduleName + ", fields=" + fields + "]";
	}
}
