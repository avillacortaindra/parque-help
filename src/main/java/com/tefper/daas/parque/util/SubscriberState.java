package com.tefper.daas.parque.util;

public enum SubscriberState {

	RESERVED("R"),

	COLLECTION_WAS_SUSPENSION("D"),

	PRE_ACTIVATED("P"),

	COLLECTION_WAS_ACTIVE("U"),

	TERMINATED("T"),

	ACTIVE("A"),

	SUSPENDED("S"),

	CANCELLED("C"),

	COLLECION_CANCELLATION("L");

	private String value;

	SubscriberState(String value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(value);
	}

	public static SubscriberState fromValue(String text) {
		for (SubscriberState b : SubscriberState.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
