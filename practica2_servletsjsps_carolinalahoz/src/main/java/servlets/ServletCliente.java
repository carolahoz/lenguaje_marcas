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

import clases.Persona;
import clases.PersonasDAO;
import clases.UtilsBD;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id2, nom, apell, sal, error = null;
	ArrayList<Persona> personas = new ArrayList<Persona>();
	RequestDispatcher rd = null;
	Persona p2 = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCliente() {
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

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		int saldo = Integer.parseInt(request.getParameter("saldo"));

		System.out.println("id = " + id + " nom = " + nombre + apellidos + saldo);

		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "database=dam1;"
				+ "integratedSecurity=true;" + "trustServerCertificate=true;";
		

		Connection conn = UtilsBD.getConnection(connectionUrl);

		if (conn != null) {

			System.out.println("CONECTANDO A BASE DE DATOS");

			String id2 = null;
			String nom = null;
			String apell = null;
			int sal = 0;
			String error = null;
			ArrayList<Persona> personas = new ArrayList<Persona>();
			RequestDispatcher rd = null;
			Persona p2 = null;



			Persona p = new Persona(id, nombre, apellidos, saldo);

			PersonasDAO pd = new PersonasDAO(conn);

			try {
				pd.insertarPersonas(p);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {


				String query2 = "SELECT id, nombre, apellidos, saldo FROM TB_CLIENTES WHERE id = '" + id + "' "
						+ " and nombre = '" + nombre + "' and apellidos = '" + apellidos + " ' and saldo = " + saldo;

				PreparedStatement ps2 = conn.prepareStatement(query2);

				ResultSet rs1 = ps2.executeQuery();
				while (rs1.next()) {
					id2 = rs1.getString("id");
					nom = rs1.getString("nombre");
					apell = rs1.getString("apellidos");
					sal = rs1.getInt("saldo");
				}

				if (id2 == null || nom == null || apell == null || sal == 0) {

					System.out.println("NO COINCIDE");

					error = "error";

				

					rd = request.getRequestDispatcher("/insCliente.jsp?error=" + error);

				}

				else {

					System.out.println("CORRECTO");

					String query3 = "SELECT id, nombre, apellidos, saldo FROM TB_CLIENTES";

					PreparedStatement ps3 = conn.prepareStatement(query3);

					ResultSet rs2 = ps3.executeQuery();
					while (rs2.next()) {
						id2 = rs2.getString("id");
						nom = rs2.getString("nombre");
						apell = rs2.getString("apellidos");
						sal = rs2.getInt("saldo");

						p2 = new Persona(id2, nom, apell, sal);

						personas.add(p2);

					}


					rd = request.getRequestDispatcher("/mosCliente.jsp");

					request.setAttribute("personas", personas);

				}

				rd.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
