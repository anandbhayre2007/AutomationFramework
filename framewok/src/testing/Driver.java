package testing;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import utilities.Xls_Reader;

public class Driver {

	public static void main(String[] args)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, ClassNotFoundException, InstantiationException, IOException {
		// TODO Auto-generated method stub

		Xls_Reader xl = new Xls_Reader("D://TestData.xls");
		int rows = xl.getrowcount("Suite");
		for (int r = 2; r <= rows; r++) {
			String testcase = xl.getCellData("Suite", r, "TC_Name");

			if (xl.getCellData("Suite", r, "RunFlag").equals("Y")) {

				Class c = Class.forName("testing." + testcase);
				Object obj = c.newInstance();
				Method m = c.getDeclaredMethod("test");
				m.invoke(obj);
			}
		}

		/*
		 * Field mTC_Name = c.getDeclaredField("mstrTC_Name"); mTC_Name.set(obj,
		 * mstrTestCase);
		 * 
		 * // ---------------Setting TestCase Descriptions Field mTC_Desc =
		 * c.getDeclaredField("mstrTC_Desc"); mTC_Desc.set(scriptClassObj, msrtTC_desc);
		 */
		// ---------------Setting Module Name

	}

}
