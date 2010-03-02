package com.koopab.draak

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Host extends HttpServlet {
	DraakApp app;
	
	void service(HttpServletRequest request, HttpServletResponse response) {
		println request
		println app
	}
}
