package payment.all.bean;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.UserInfoDataDTO;



@Controller
@RequestMapping("/userbilling/*")
public class PaymentBean {
	
	@Autowired
	private SqlMapClientTemplate sqlMap;

	@RequestMapping("/cash.do")
	public String cash(HttpServletRequest request, HttpSession session, UserInfoDataDTO infodto)throws Exception{
		String id = (String)session.getAttribute("loginId");
		request.setCharacterEncoding("UTF-8");
		
		UserInfoDataDTO info = (UserInfoDataDTO)sqlMap.queryForObject("cash.cash_payment_useInfoLoad", id);
		
		request.setAttribute("info", info);
		request.setAttribute("id", id);
		System.out.println(id);
		return "/userbilling/cash";
	}
	
	@RequestMapping("/cashPro.do")
	public String cashPro(HttpServletRequest request, UserBillingHistoryDTO dto, HttpSession session)throws Exception{
		String id = (String)session.getAttribute("loginId");
		request.setCharacterEncoding("UTF-8");
		String pay = request.getParameter("pay");
		String paying_price = request.getParameter("paying_price");
		String payment_type = request.getParameter("payment_type");
		
		request.setAttribute("pay", pay);
		request.setAttribute("id", id);
		request.setAttribute("paying_price", dto.getPaying_price());
		request.setAttribute("payment_type", dto.getPayment_type());
		
		System.out.println("������ �ݾ�" + dto.getPaying_price());
		System.out.println("������ Ÿ��" + dto.getPayment_type());
		return "/userbilling/cashPro";
	}
	
	
	
	@RequestMapping("/ledger.do")
	public String ledger(HttpServletRequest request, UserBillingHistoryDTO dto){
		
		List payment = (List)sqlMap.queryForList("cash.cash_area", dto);
		
		request.setAttribute("payment", payment);
		System.out.println(payment);
		return "/userbilling/ledger";
	}
	
	@RequestMapping("/cashHistory.do")
	public String cashHistory(HttpServletRequest request, UserBillingHistoryDTO dto){
				
		//String getUse_area =  request.getParameter(dto.getUse_area());
		//String check = (String) sqlMap.queryForObject("cash.cash_area", dto);
		
		//List payment = (List)sqlMap.queryForList("cash.cash_area", dto);
		
		//request.setAttribute("payment", payment);
		//System.out.println(getUse_area);
		//System.out.println(dto.getUse_area());
		
		return "/userbilling/cashHistory";		
	}
	
	@RequestMapping("/payment.do")
	public String payment(HttpServletRequest request, HttpSession session, UserInfoDataDTO userinfoDTO, Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");
		String pay = request.getParameter("pay");
		String card = request.getParameter("card");
		String payment_type = request.getParameter("payment_type");
		String buyer_chatid = request.getParameter("buyer_chatid");
		String confirmation = request.getParameter("confirmation");
		String paying_name = request.getParameter("paying_name");
		String id = (String)session.getAttribute("loginId"); 
		
		
		UserInfoDataDTO c = (UserInfoDataDTO)sqlMap.queryForObject("cash.cash_payment_useInfoLoad", id);

		request.setAttribute("c", c);
		System.out.println("���� ���̵� " + c.getAddress());
		System.out.println("���� ���̵� " + id);
		
		System.out.println(pay);
		System.out.println("ī���" + card);
		
		request.setAttribute("id", id);
		request.setAttribute("pay", pay);
		request.setAttribute("card", card);
		request.setAttribute("payment_type", payment_type);
		request.setAttribute("buyer_chatid", buyer_chatid);
		request.setAttribute("confirmation", confirmation);
		request.setAttribute("paying_name", paying_name);
		
		
		System.out.println("���� ����" + c.getAddress());
		System.out.println("���� ����" + c);
		return "/userbilling/payment";	
	}
	
	@RequestMapping("/paymentPro.do")
	public String paymentPro(HttpServletRequest request, UserBillingHistoryDTO dto, HttpSession session)throws Exception{
		String id = (String)session.getAttribute("loginId");
		request.setCharacterEncoding("UTF-8");//�ѱ� ���ڵ�
		
		String paying_price = request.getParameter("pay");
		String payment_type = request.getParameter("payment_type");
		
		System.out.println("Pro������ �ݾ� �� " + dto.getPaying_price());
		System.out.println("Pro������ Ÿ�� �� " + dto.getPayment_type());
		
		sqlMap.insert("cash.cash_input", dto);	
		
		request.setAttribute("paying_price", dto.getPaying_price());
		request.setAttribute("payment_type", dto.getPayment_type());

		
		return "userbilling/paymentPro";
	}
}
