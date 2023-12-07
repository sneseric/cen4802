package com.eric.todoapp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

public class ToDoListServletTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher dispatcher;

    private ToDoListServlet servlet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        servlet = new ToDoListServlet();
    }

    @Test
    public void testDoGet() throws Exception {
        when(request.getRequestDispatcher("/todo.jsp")).thenReturn(dispatcher);
        
        servlet.doGet(request, response);

        verify(request, times(1)).getRequestDispatcher("/todo.jsp");
        verify(dispatcher, times(1)).forward(request, response);
    }

    @Test
    public void testDoPostAddAction() throws Exception {
        when(request.getParameter("action")).thenReturn("add");
        when(request.getParameter("task")).thenReturn("New Task");

        servlet.doPost(request, response);

        verify(response, times(1)).sendRedirect("todo.jsp");
        // Add additional verifications or assertions as needed
    }

    // Additional tests for other scenarios like delete action, exceptions, etc.
}
