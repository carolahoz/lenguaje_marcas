package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Persona2;
import clases.UtilsBD;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/ServletAct2")
public class ServletAct2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAct2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		System.out.println("Entrando en doPost");

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("passwd");

		System.out.println("Usuario = " + usuario + " contraseña = " + password);

		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "database=dam1;"

				+ "integratedSecurity=true;" + "trustServerCertificate=true;";
	

		Connection conn = UtilsBD.getConnection(connectionUrl);

		if (conn != null) {

			System.out.println("CONECTANDO A BASE DE DATOS");


//			
			String user = null;
			String passwd = null;
			String tipo = null;
			String id2 = null;
			String error = null;
			String admin = null;
			ArrayList<Persona2> personas = new ArrayList<Persona2>();
			Persona2 p2 = null;
			RequestDispatcher rd = null;
			try {


				String query2 = "SELECT usuario, passwd, tipo FROM TB_USUARIOS WHERE passwd = '" + password + "' "
						+ " and usuario = '" + usuario + "'";

				PreparedStatement ps2 = conn.prepareStatement(query2);

				ResultSet rs1 = ps2.executeQuery();
				while (rs1.next()) {
					user = rs1.getString("usuario");
					passwd = rs1.getString("passwd");
					tipo = rs1.getString("tipo");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (user == null || passwd == null) {

				System.out.println("NO COINCIDE");

				error = "error";

				

				rd = request.getRequestDispatcher("/login.jsp?error=" + error);

			}

			else if (tipo.equals("ADMIN")) {

				rd = request.getRequestDispatcher("/menu.jsp?admin=" + admin);

				String query3 = "SELECT id, usuario, passwd, tipo FROM TB_USUARIOS";

				

				ResultSet rs2;
				try {
					PreparedStatement ps3 = conn.prepareStatement(query3);
					rs2 = ps3.executeQuery();
					while (rs2.next()) {
						id2 = rs2.getString("id");
						user = rs2.getString("usuario");
						passwd = rs2.getString("passwd");
						tipo = rs2.getString("tipo");

						p2 = new Persona2(id2, user, passwd, tipo);

						personas.add(p2);

					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			else if (user.equals(usuario) && passwd.equals(password)) {

				System.out.println("COINCIDE");

				rd = request.getRequestDispatcher("/menu.jsp");
				
				

			}

			rd.forward(request, response);
		}

	}

}
