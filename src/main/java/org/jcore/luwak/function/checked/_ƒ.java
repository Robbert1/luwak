package org.jcore.luwak.function.checked;

import java.util.Objects;

import org.jcore.luwak.function.ƒ;

/**
 * A {@link ƒ} that allows for checked exceptions.
 */
@FunctionalInterface
public interface _ƒ<T, R> {
	/**
	 * Applies this function to the given argument.
	 *
	 * @param t the function argument
	 * @return the function result
	 */
	R apply(T t) throws Exception;

	/**
	 * Returns a composed function that first applies the {@code before}
	 * function to its input, and then applies this function to the result.
	 * If evaluation of either function throws an exception, it is relayed to
	 * the caller of the composed function.
	 *
	 * @param <V>    the type of input to the {@code before} function, and to the composed function
	 * @param before the function to apply before this function is applied
	 * @return a composed function that first applies the {@code before} function and then applies this function
	 * @throws NullPointerException if before is null
	 * @see #andThen(_ƒ)
	 */
	default <V> _ƒ<V, R> compose(_ƒ<? super V, ? extends T> before) {
		Objects.requireNonNull(before);
		return (V v) -> apply(before.apply(v));
	}

	/**
	 * Returns a composed function that first applies this function to
	 * its input, and then applies the {@code after} function to the result.
	 * If evaluation of either function throws an exception, it is relayed to
	 * the caller of the composed function.
	 *
	 * @param <V>   the type of output of the {@code after} function, and of the composed function
	 * @param after the function to apply after this function is applied
	 * @return a composed function that first applies this function and then applies the {@code after} function
	 * @throws NullPointerException if after is null
	 * @see #compose(_ƒ)
	 */
	default <V> _ƒ<T, V> andThen(_ƒ<? super R, ? extends V> after) {
		Objects.requireNonNull(after);
		return (T t) -> after.apply(apply(t));
	}

	/**
	 * Returns a function that always returns its input argument.
	 *
	 * @param <T> the type of the input and output objects to the function
	 * @return a function that always returns its input argument
	 */
	static <T> _ƒ<T, T> identity() {
		return t -> t;
	}
}
