package com.vti.entity;

public class Car {
	private String name;
	private String type;

	public Car(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String toString() {
		return "Car [name=" + name + ", type=" + type + "]";
	}

	public class Engineer {
		private String engineType;

		public Engineer(String engineType) {
			super();
			this.engineType = engineType;
		}

		@Override
		public String toString() {
			return "Engine [engineType=" + engineType + "]";
		}

		public String getEngineType() {
			return engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}
	}
}
