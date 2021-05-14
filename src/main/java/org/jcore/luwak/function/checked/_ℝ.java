package org.jcore.luwak.function.checked;

import org.jcore.luwak.function.ℝ;

/**
 * A {@link ℝ} that allows for checked exceptions.
 */
@FunctionalInterface
public interface _ℝ {
	/**
	 * Run this runnable.
	 */
	void run() throws Exception;
}