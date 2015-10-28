package demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.businesslogic.AddImportListBL;
import demo.businesslogicservice.AddImportListBLService;
import demo.vo.ImportItemVO;
import demo.vo.SupplierVO;

public class AddImportListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private AddImportListBLService bl;
	
	@Override
	 public void doPost(HttpServletRequest request,HttpServletResponse response){
		String method = request.getParameter("method");
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		
		if(method.equals("init")){
			this.init(response);
		}
		else if(method.equals("addItem")){
			String no = request.getParameter("no");
			int amount = Integer.parseInt(request.getParameter("amount"));
			String note = request.getParameter("note");
			this.addItem(response, no, amount, note);
		}
		else if(method.equals("deleteItem")){
			int index = Integer.parseInt(request.getParameter("index"));
			this.deleteItem(response,index);
		}
		else if(method.equals("submit")){
			int supplierId = Integer.parseInt(request.getParameter("supplier"));
			this.submit(response,supplierId);
		}
	 }

	public void init(HttpServletResponse response){
		bl = new AddImportListBL();
		
		List<SupplierVO> list = bl.getSupplierList();
		String result = "[";
		if(list.size()>0){
			for(int i=0; i< list.size()-1;i++){
				result += "{\"id\":"+ list.get(i).getId() +",\"name\":\"" + list.get(i).getName() + "\"}" +",";
			}
			result+= "{\"id\":"+ list.get(list.size()-1).getId() +",\"name\":\"" + list.get(list.size()-1).getName() + "\"}" + "]";
		}
		System.out.println(result);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(result);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addItem(HttpServletResponse response, String no, int amount, String note) {
		ImportItemVO item = bl.addItem(no, amount, note);
		String result = "";
		if(item!=null){
			result = "{\"status\":1,"
					+"\"total\":"+bl.getTotalPrice()+","
					+"\"no\":\""+item.getNo()+"\","
					+"\"name\":\""+item.getName()+"\","
					+"\"type\":\"" + item.getType()+"\","
					+"\"amount\":"+item.getAmount()+",\"price\":"+item.getPrice()+","
					+"\"totalPrice\":"+item.getTotalPrice()+",\"note\":\""+item.getNote()+"\"}";
		}else{
			result = "{\"status\":0}";
		}
		//System.out.println(result);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(result);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteItem(HttpServletResponse response, int index) {
		boolean b = bl.deleteItem(index);
		String result = "";
		if(b){
			result = "{\"status\":1, \"total\":"+bl.getTotalPrice()+",\"index\":"+index+"}";
		}else{
			result = "{\"status\":0}";
		}
		
		//System.out.println(result);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(result);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void submit(HttpServletResponse response, int supplierId) {
		bl.selectSupplier(new SupplierVO(supplierId,""));
		boolean b = bl.submit();
		
		String result = "";
		if(b){
			result = "{\"status\":1}";
		}else{
			result = "{\"status\":0}";
		}
		System.out.println(result);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(result);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
