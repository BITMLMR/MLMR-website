/*
 * Created on 2005-11-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package CV.tools;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;



/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DTOPopulator {
	public static List populate(ResultSet rs,Class clazz) throws Exception{
		ResultSetMetaData metaData = rs.getMetaData();
		int colCount = metaData.getColumnCount();
		List ret = new ArrayList();
		Field[] fields = clazz.getDeclaredFields();
		
		while(rs.next()){
			Object newInstance = clazz.newInstance();
			for(int i=1;i<=colCount;i++){
				try{
					Object value = rs.getObject(i);
					for(int j=0;j<fields.length;j++){
						Field f = fields[j];
						if(f.getName().equalsIgnoreCase(metaData.getColumnName(i).replaceAll("_",""))){
							BeanUtils.copyProperty(newInstance,f.getName(),value);
						}
					}
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			ret.add(newInstance);
		}
		return ret;
	}
	public static void main(String[] args) {
//		DTOPopulator p = new DTOPopulator();
//		java.awt.Image image = new BufferedImage(10,20,BufferedImage.TYPE_3BYTE_BGR);
//		Random r = new Random();
//		int i = r.nextInt(1000);
//		System.out.println("i = "+i);
//		image.getGraphics().drawString(""+i,1,1);
		String s ="[abc]abc";
		String string = s.replaceAll("[abc]","");
		System.out.println("string = "+string);
		java.sql.PreparedStatement ps =null;
		
	}
}
