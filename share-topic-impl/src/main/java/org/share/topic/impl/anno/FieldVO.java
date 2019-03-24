package org.share.topic.impl.anno;

public class FieldVO {
	private String fieldName;
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	@Override
	public String toString() {
		return "FieldVO [fieldName=" + fieldName + "]";
	}
}
