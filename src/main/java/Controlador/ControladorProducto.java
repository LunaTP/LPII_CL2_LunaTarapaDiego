package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassProductoImp;
import model.TblProductocl2;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblProductocl2 producto = new TblProductocl2();
		ClassProductoImp crud = new ClassProductoImp();
		List<TblProductocl2> listadocliente = crud.ListadoProducto();
		
		List<TblProductocl2> listadoproducto = crud.ListadoProducto();
		request.setAttribute("listadoproductos", listadoproducto);
		
		request.getRequestDispatcher("/FormRegistrarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		double precio = Double.parseDouble(request.getParameter("precio"));
		double precioVen = Double.parseDouble(request.getParameter("precioVen"));
		String estado = request.getParameter("estado");
		String descrip = request.getParameter("descrip");
		
		TblProductocl2 producto = new TblProductocl2();
		ClassProductoImp crud = new ClassProductoImp();
		
		producto.setNombrecl2(nombre);
		producto.setPreciocompcl2(precio);
		producto.setPrecioventacl2(precioVen);
		producto.setEstadocl2(estado);
		producto.setDescripcl2(descrip);
		
		crud.RegistrarProducto(producto);
		
		List<TblProductocl2> listadoproducto = crud.ListadoProducto();
		request.setAttribute("listadoproductos", listadoproducto);
		
		request.getRequestDispatcher("/FormListarProducto.jsp").forward(request, response);
	}

}
