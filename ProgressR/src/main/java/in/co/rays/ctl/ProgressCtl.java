package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.ProgressBean;
import in.co.rays.model.ProgressModel;

@WebServlet("/ProgressCtl")
public class ProgressCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("id = > " + id);
		ProgressBean bean = new ProgressBean();
		ProgressModel model = new ProgressModel();
		if (id != null) {
			try {
				bean = model.findbypk(Integer.parseInt(id));
				request.setAttribute("bean", bean);

			}

			catch (Exception e) {
				e.printStackTrace();

			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("ProgressView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		String id = request.getParameter("id");

		String DeveloperName = request.getParameter("DeveloperName");
		String Work = request.getParameter("Work");
		String Target = request.getParameter("Target");
		String LastWeek = request.getParameter("lastweek");
		String CurrentWeek = request.getParameter("CurrentWeek");
		String Today = request.getParameter("Today");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		ProgressBean bean = new ProgressBean();

		try {
			bean.setDeveloperName(DeveloperName);
			bean.setWork(Work);
			bean.setTarget(Target);
			bean.setLastWeek(LastWeek);
			bean.setCurrentWeek(CurrentWeek);
			bean.setToday(sdf.parse(Today));

		} catch (ParseException e) {

			e.printStackTrace();
		}

		ProgressModel model = new ProgressModel();

		if (op.equals("save")) {
			try {
				model.add(bean);
				request.setAttribute("msg", "User added Successfully..!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (op.equals("Delete")) {
			try {
				model.delete(bean.getId());
				;
				;
				request.setAttribute("msg", "User delete Successfully..!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (op.equalsIgnoreCase("update")) {

			try {
				System.out.println("update>>>>>" + bean.getDeveloperName());
				bean.setId(Integer.parseInt(id));
				model.update(bean);
				bean = model.findbypk(bean.getId());
				request.setAttribute("msg", "USER  UPDATE SUSCCESSFULL..!!! ");
				request.setAttribute("bean", bean);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		RequestDispatcher rd = request.getRequestDispatcher("ProgressView.jsp");
		rd.forward(request, response);

	}

}
