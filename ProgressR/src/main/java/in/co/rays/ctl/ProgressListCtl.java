package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.ProgressBean;
import in.co.rays.model.ProgressModel;

@WebServlet("/ProgressListCtl")
public class ProgressListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProgressModel model = new ProgressModel();
		ProgressBean bean = new ProgressBean();
		try {

			List list = model.serach(bean);
			System.out.println("userlist>> " + list.toString());
			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("ProgressListView.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println("msg>> " + e.getMessage());
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		ProgressBean bean = new ProgressBean();;
		ProgressModel model = new ProgressModel();
		if (op.equals("search")) {
			
			String  DeveloperName = req.getParameter("name");
			
			bean.setDeveloperName(DeveloperName);
		}
		if (op.equals("add")) {

			resp.sendRedirect("ProgressCtl");

		}
		if (op.equals("delete")) {
			
			String[] ids = req.getParameterValues("ids");

			for (String id : ids) {

				try {
					model.delete(Integer.parseInt(id));
					

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} 
		try {
			List list = model.serach(bean);
			System.out.println("list>>>>>> " + list.toString());
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("ProgressListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
