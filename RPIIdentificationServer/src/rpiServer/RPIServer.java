// Author: F. Christoulakis

package rpiServer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RPIServer")
public class RPIServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DevicesList devicesList = new DevicesList();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RPIServer() {
		super();

	}

	// ----------------------------------------------------------------------------------------------
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// PRINT CLIENT IP
		String addr = request.getRemoteAddr();
		System.out.println("got GET request from " + addr);
		PrintWriter out = response.getWriter();

		out.print("<html><body>");

		devicesList.printAsHtmlTable(out);

		out.print("</body></html>");

		// ---

	}

	// ----------------------------------------------------------------------------------------------
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	// ----------------------------------------------------------------------------------------------
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// PRINT CLIENT IP
		String addr = request.getRemoteAddr();
		System.out.println("got PUT request from " + addr);
		// ---
		DeviceEntry deviceEntry = new DeviceEntry(request.getParameter("id"),
				request.getParameter("ip"));
		devicesList.addOrUpdate(deviceEntry);

	}
	// ----------------------------------------------------------------------------------------------
}
