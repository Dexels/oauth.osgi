package com.dexels.oauth.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExternalServlet extends HttpServlet {

	private static final long serialVersionUID = 2214222751511055144L;

	private static final String oauth = "http://localhost:8080/oauth/token_auth";
	public void activate() {
		System.err.println();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// resp.getWriter().write("I am a resource");
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();

		out.println("Request Headers:");
		out.println();
		Enumeration names = req.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			Enumeration values = req.getHeaders(name); // support multiple
														// values
			if (values != null) {
				while (values.hasMoreElements()) {
					String value = (String) values.nextElement();
					out.println(name + ": " + value);
				}
			}
		}
		
		for (Entry<String, String[]>  e : req.getParameterMap().entrySet()) {
			out.println("\nParam: "+e.getKey());
			if(e.getValue()!=null) {
				for (String w : e.getValue()) {
					out.println("element: "+w);
				}
			}
		} 
	}
	
}
