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
import clases.Persona2;
import clases.PersonasDAO;
import clases.UtilsBD;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("Entrando en doPost");

		String id = request.getParameter("id");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("passwd");
		String tipo = request.getParameter("tipo");

		System.out.println("id = " + id + " nom = " + usuario + password + tipo);

		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "database=dam1;"

				+ "integratedSecurity=true;" + "trustServerCertificate=true;";
	

		Connection conn = UtilsBD.getConnection(connectionUrl);

		if (conn != null) {

			System.out.println("CONECTANDO A BASE DE DATOS");

			String id2 = null;
			String usu = null;
			String pw = null;
			String tip = null;
			String error = null;
			ArrayList<Persona2> personas = new ArrayList<Persona2>();
			RequestDispatcher rd = null;
			Persona2 p2 = null;



			Persona2 p = new Persona2(id, usuario, password, tipo);

			PersonasDAO pd = new PersonasDAO(conn);

			try {
				pd.insertarPersonas2(p);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {


				String query2 = "SELECT id, usuario, passwd, tipo FROM TB_USUARIOS WHERE id = '" + id + "' "
						+ " and usuario = '" + usuario + "' and passwd = '" + password + " ' and tipo = '" + tipo + "'";

				PreparedStatement ps2 = conn.prepareStatement(query2);

				ResultSet rs1 = ps2.executeQuery();
				while (rs1.next()) {
					id2 = rs1.getString("id");
					usu = rs1.getString("usuario");
					pw = rs1.getString("passwd");
					tip = rs1.getString("tipo");
				}

				if (id2 == null || usu == null || pw == null || tipo == null) {

					System.out.println("NO COINCIDE");

					error = "error";

	

					rd = request.getRequestDispatcher("/insUsuario.jsp?error=" + error);
					

				}

				else {

					System.out.println("CORRECTO");

					String query3 = "SELECT id, usuario, passwd, tipo FROM TB_USUARIOS";

					PreparedStatement ps3 = conn.prepareStatement(query3);

					ResultSet rs2 = ps3.executeQuery();
					while (rs2.next()) {
						id2 = rs2.getString("id");
						usu = rs2.getString("usuario");
						pw = rs2.getString("passwd");
						tip = rs2.getString("tipo");

						p2 = new Persona2(id2, usu, pw, tip);

						personas.add(p2);

					}


					rd = request.getRequestDispatcher("/mosUsuario.jsp");

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
