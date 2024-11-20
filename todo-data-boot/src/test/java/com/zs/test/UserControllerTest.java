package com.zs.test;

import com.zs.entity.User;
import com.zs.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)  // This tells JUnit to use MockitoExtension
class UserControllerTest {

    @Mock
    private UserService userService;  // Mock the UserService

    @InjectMocks
    private com.zs.util.userController userController;  // Inject the mocked service into the UserController

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();  // Initialize MockMvc
    }

    @Test
    void testSaveUser() throws Exception {
        User user = new User(1, "Johnd");

        // Simulate the service call
        doNothing().when(userService).save(user);

        mockMvc.perform(post("/user/save")
                .contentType("application/json")
                .content("{\"id\":1,\"name\":\"John Doe\",\"email\":\"john.doe@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("User saved successfully"));

        verify(userService, times(1)).save(user);  // Verify that the save method was called once
    }

   
}
