package com.edad;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
class CalculoEdadApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldGetAge() throws Exception
	{
		this.mockMvc.perform(get("/calcularEdad/11/10/1994"))
				.andDo(print())
				.andExpect(status().is(200))
				.andExpect(content().string(containsString("26")));
	}

	@Test
	void shoudThrowWarning() throws Exception
	{
		this.mockMvc.perform(get("/calcularEdad/11/10/2021"))
				.andDo(print())
				.andExpect(status().is(200))
				.andExpect(content().string(containsString("La fecha ingresada es incorrecta")));
	}

}
