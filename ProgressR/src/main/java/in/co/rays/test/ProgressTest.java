package in.co.rays.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.ProgressBean;
import in.co.rays.model.ProgressModel;

public class ProgressTest {
	public static void main(String[] args) throws Exception {

		// testadd();
		// testsearch();
		// testdelete();
		// testupdate();
		testfindbypk();
	}

	private static void testfindbypk() throws Exception {

		long pk = 1;
		ProgressBean bean = new ProgressBean();
		ProgressModel model = new ProgressModel();

		bean = model.findbypk(pk);
		System.out.println(bean.getId());
		System.out.println(bean.getDeveloperName());
		System.out.println(bean.getWork());
		System.out.println(bean.getTarget());
		System.out.println(bean.getLastWeek());
		System.out.println(bean.getCurrentWeek());
		System.out.println(bean.getToday());
	}

	private static void testupdate() throws Exception {

		ProgressBean bean = new ProgressBean();
		ProgressModel model = new ProgressModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setDeveloperName("jay");
		bean.setWork("bulid");
		bean.setTarget("Project-4");
		bean.setLastWeek("Advance");
		bean.setCurrentWeek("THEROY");
		bean.setToday(sdf.parse("1998-3-5"));
		bean.setId(2);
		model.update(bean);

	}

	private static void testdelete() throws Exception {

		ProgressModel model = new ProgressModel();
		model.delete(6);

	}

	private static void testsearch() throws Exception {

		ProgressModel model = new ProgressModel();
		ProgressBean bean = new ProgressBean();
		List list = new ArrayList();
		list = model.serach(bean);

		Iterator it = list.iterator();
		while (it.hasNext()) {

			bean = (ProgressBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getDeveloperName());
			System.out.println(bean.getWork());
			System.out.println(bean.getTarget());
			System.out.println(bean.getLastWeek());
			System.out.println(bean.getCurrentWeek());
			System.out.println(bean.getToday());

		}

	}

	private static void testadd() throws Exception {

		ProgressBean bean = new ProgressBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setId(7);
		bean.setDeveloperName("ankush");
		bean.setWork("Advance");
		bean.setTarget("Project-04");
		bean.setLastWeek("IO");
		bean.setCurrentWeek("Bulid");
		bean.setToday(sdf.parse("1999-4-3"));

		ProgressModel model = new ProgressModel();
		model.add(bean);

	}

}
