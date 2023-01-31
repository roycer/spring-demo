package pe.gob.contraloria.demo;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import pe.gob.contraloria.demo.presentation.controller.MenuController;
//import pe.gob.contraloria.demo.presentation.exception.ModelNotFoundException;
//
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(MenuController.class)
//class MenuTests {
//
//	@Autowired
//	private MockMvc mockMvc;
//	
//
//	@Test
//	void getTest() throws Exception {
//	
//		MockHttpServletRequestBuilder request = get("/menus")
//			.header("Authorization", "")
//			.accept("application/json;charset=UTF-8");
//		
//		this.mockMvc.perform(request).andExpect(status().isOk());
//		
//    	
//    	
//	}
//	
//}
