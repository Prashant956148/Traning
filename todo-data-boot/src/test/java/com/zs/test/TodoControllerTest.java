package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.zs.entity.TODO;
import com.zs.service.TODOService;
import com.zs.util.TODOController;

public class TodoControllerTest {
	@Mock
	private TODOService service;
	@InjectMocks
	private TODOController todocontoller;

	private TODO todo;

	@BeforeEach
	void setup() {
		todo = new TODO();
		todo.setTid(1);
		todo.setTask("math");
		todo.setPriority("high");
		todo.setStatus("pending");
		todo.setAssigndate(LocalDate.parse("2024-11-19"));
		todo.setFinishdate(LocalDate.parse("2025-12-12"));
	}

	@Test
	void save() {
		doNothing().when(service).save(any(TODO.class), eq(1));
		String response = todocontoller.save(todo, 1);
		assertEquals("todo saved", response);
		verify(service, times(1)).save(any(TODO.class), eq(1));
	}
}