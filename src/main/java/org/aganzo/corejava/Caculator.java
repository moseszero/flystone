package org.aganzo.corejava;

public interface Caculator<T extends Number> {
	T add(T num1, T num2);
	T minus(T num1, T num2);

}
