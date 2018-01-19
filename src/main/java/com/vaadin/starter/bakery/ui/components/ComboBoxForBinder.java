package com.vaadin.starter.bakery.ui.components;

import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.shared.Registration;

/**
 * Workaround for date-picker to:
 * 
 * 1.- set the initial value. Might be related with setValue not working when
 * element is not displayed https://github.com/vaadin/flow/issues/3351
 * 
 * 2.- avoid receiving a value-changed event when the value has been changed
 * from server side. This prevents binder marking the bean dirty.
 * https://github.com/vaadin/flow/issues/3350
 */
public class ComboBoxForBinder<T> extends ComboBox<T> implements Focusable<ComboBox<T>> {

	private T lastSetValue;

	@Override
	public void setValue(T value) {
		super.setValue(value);
		this.lastSetValue = value;
		if (value != null) {
			getElement().setAttribute("value", getItemLabelGenerator().apply(value));
		}
	}

	@Override
	public Registration addValueChangeListener(ValueChangeListener<ComboBox<T>, T> listener) {
		return super.addValueChangeListener(e -> {
			if (e.getValue() != null && !e.getValue().equals(lastSetValue)
					|| e.getValue() == null && lastSetValue != null) {
				listener.onComponentEvent(e);
			}
		});
	}
}
