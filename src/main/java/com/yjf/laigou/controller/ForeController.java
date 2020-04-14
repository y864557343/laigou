package com.yjf.laigou.controller;

import com.github.pagehelper.PageHelper;
import com.yjf.laigou.pojo.*;
import com.yjf.laigou.service.*;
import comparator.*;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 用于处理一系列前端的地址转向和跳转
 */
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService sgsc;
    @Autowired
    ProductService prosc;
    @Autowired
    UserService usc;
    @Autowired
    ProductImageService proisc;
    @Autowired
    PropertyValueService provsc;
    @Autowired
    OrderService orsc;
    @Autowired
    OrderItemService otsc;
    @Autowired
    ReviewService resc;

    /**
     * 首页产品查询
     * @param model
     * @return
     */
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> categoryList= sgsc.list();
        prosc.stuff(categoryList);
        prosc.stuffByRow(categoryList);
         model.addAttribute("cs", categoryList);
        return "fore/home";
    }

    /**
     * 注册
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("foreregister")
    public String register(Model model, User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean flag = usc.isExist(name);
        if(flag){
            model.addAttribute("msg","用户名已经被使用,不能使用");
            return "fore/register";
        }
        usc.add(user);
        return "redirect:registerSuccessPage";
    }

    /**
     * 登录
     * @param name
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = usc.get(name,password);
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }

    /**
     * 产品详细信息
     * @param pid
     * @param model
     * @return
     */
    @RequestMapping("foreproduct")
    public String product(int pid, Model model) {
        Product product = prosc.get(pid);

        List<ProductImage> simgList = proisc.findList(product.getId(), proisc.type_single);
        List<ProductImage> dimgList = proisc.findList(product.getId(), proisc.type_detail);
        product.setProductSingleImages(simgList);
        product.setProductDetailImages(dimgList);

        List<PropertyValue> pvs = provsc.list(product.getId());
        List<Review> reviews = resc.list(product.getId());
        prosc.setInfo(product);

        model.addAttribute("reviews", reviews);
        model.addAttribute("p", product);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }

    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin(HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = usc.get(name,password);

        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }

    /**
     * 分类查询
     * @param cid
     * @param sort
     * @param model
     * @return
     */
    @RequestMapping("forecategory")
    public String category(int cid, String sort, Model model) {
        Category c = sgsc.get(cid);
        prosc.stuff(c);
        prosc.setInfos(c.getProducts());

        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;

                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;

                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;

                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }

        model.addAttribute("c", c);
        return "fore/category";
    }

    /**
     * 搜索
     * @param keyword
     * @param model
     * @return
     */
    @RequestMapping("foresearch")
    public String search(String keyword, Model model){

        PageHelper.offsetPage(0,20);
        List<Product> productList= prosc.findList(keyword);
        prosc.setInfos(productList);
        model.addAttribute("ps",productList);
        return "fore/searchResult";
    }

    /**
     * 购买
     * @param pid
     * @param num
     * @param session
     * @return
     */
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product product = prosc.get(pid);
        int i = 0;

        User user =(User)  session.getAttribute("user");
        boolean flag = false;
        List<OrderItem> orderItemList = otsc.findListByUser(user.getId());
        for (OrderItem orderItem : orderItemList) {
            if(orderItem.getProduct().getId().intValue()==product.getId().intValue()){
                orderItem.setNumber(orderItem.getNumber()+num);
                otsc.update(orderItem);
                flag = true;
                i = orderItem.getId();
                break;
            }
        }

        if(!flag){
            OrderItem orderItem = new OrderItem();
            orderItem.setUid(user.getId());
            orderItem.setNumber(num);
            orderItem.setPid(pid);
            otsc.add(orderItem);
            i = orderItem.getId();
        }
        return "redirect:forebuy?oiid="+i;
    }

    @RequestMapping("forebuy")
    public String buy(Model model, String[] oiid, HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;

        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= otsc.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }

        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }

    /**
     *加入购物车
     * @param pid
     * @param num
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model, HttpSession session) {
        Product product = prosc.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean flag = false;

        List<OrderItem> orderItemList = otsc.findListByUser(user.getId());
        for (OrderItem orderItem : orderItemList) {
            if(orderItem.getProduct().getId().intValue()==product.getId().intValue()){
                orderItem.setNumber(orderItem.getNumber()+num);
                otsc.update(orderItem);
                flag = true;
                break;
            }
        }

        if(!flag){
            OrderItem orderItem = new OrderItem();
            orderItem.setUid(user.getId());
            orderItem.setNumber(num);
            orderItem.setPid(pid);
            otsc.add(orderItem);
        }
        return "success";
    }
    @RequestMapping("forecart")
    public String cart(Model model, HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = otsc.findListByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }

    /**
     * 修改订单项
     * @param model
     * @param session 包含购买人id
     * @param pid 产品id
     * @param number 数量
     * @return
     */
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem(Model model, HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";

        List<OrderItem> orderItemList = otsc.findListByUser(user.getId());
        for (OrderItem orderItem : orderItemList) {
            if(orderItem.getProduct().getId().intValue()==pid){
                orderItem.setNumber(number);
                otsc.update(orderItem);
                break;
            }
        }
        return "success";
    }

    /**
     * 删除订单项
     * @param model
     * @param session 购买人id
     * @param oiid 订单id
     * @return
     */
    @RequestMapping("foredeleteOrderItem")
    @ResponseBody
    public String deleteOrderItem(Model model, HttpSession session, int oiid){
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
        otsc.delete(oiid);
        return "success";
    }

    /**
     * 创建订单
     * @param model
     * @param order 订单信息
     * @param session 包含购买人id
     * @return
     */
    @RequestMapping("forecreateOrder")
    public String createOrder(Model model, Order order, HttpSession session){
        User user =(User)  session.getAttribute("user");
        String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + RandomUtils.nextInt(10000);
        order.setOrderCode(orderCode);
        order.setCreateDate(new Date());
        order.setUid(user.getId());
        order.setStatus(orsc.waitPay);
        List<OrderItem> orderItemList= (List<OrderItem>)  session.getAttribute("ois");

        float i =orsc.add(order,orderItemList);
        return "redirect:forealipay?oid="+order.getId() +"&total="+i;
    }

    /**
     * 支付
     * @param oid 订单id
     * @param total 总额
     * @param model
     * @return
     */
    @RequestMapping("forepayed")
    public String payed(int oid, float total, Model model) {
        Order order = orsc.get(oid);
        order.setStatus(orsc.waitDelivery);
        order.setPayDate(new Date());
        orsc.update(order);
        model.addAttribute("o", order);
        return "fore/payed";
    }

    /**
     * 购买
     * @param model
     * @param session 包含购买人id
     * @return
     */
    @RequestMapping("forebought")
    public String bought(Model model, HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<Order> os= orsc.findList(user.getId(),orsc.delete);
        otsc.stuff(os);
        model.addAttribute("os", os);

        return "fore/bought";
    }

    /**
     * 确认支付
     * @param model
     * @param oid 订单id
     * @return
     */
    @RequestMapping("foreconfirmPay")
    public String confirmPay(Model model, int oid) {
        Order order = orsc.get(oid);
        otsc.stuff(order);
        model.addAttribute("o", order);
        return "fore/confirmPay";
    }

    /**
     * 订单确认
     * @param model
     * @param oid 订单id
     * @return
     */
    @RequestMapping("foreorderConfirmed")
    public String orderConfirmed(Model model, int oid) {
        Order order = orsc.get(oid);
        order.setStatus(orsc.waitReview);
        order.setConfirmDate(new Date());
        orsc.update(order);
        return "fore/orderConfirmed";
    }
    @RequestMapping("foredeleteOrder")
    @ResponseBody
    public String deleteOrder(Model model, int oid){
        Order o = orsc.get(oid);
        o.setStatus(orsc.delete);
        orsc.update(o);
        return "success";
    }
    @RequestMapping("forereview")
    public String review(Model model, int oid) {
        Order o = orsc.get(oid);
        otsc.stuff(o);
        Product p = o.getOrderItems().get(0).getProduct();
        List<Review> reviews = resc.list(p.getId());
        prosc.setInfo(p);
        model.addAttribute("p", p);
        model.addAttribute("o", o);
        model.addAttribute("reviews", reviews);
        return "fore/review";
    }

    /**
     * 评价
     * @param model
     * @param session
     * @param oid
     * @param pid
     * @param content
     * @return
     */
    @RequestMapping("foredoreview")
    public String doreview(Model model, HttpSession session, @RequestParam("oid") int oid, @RequestParam("pid") int pid, String content) {
        Order order = orsc.get(oid);
        order.setStatus(orsc.finish);
        orsc.update(order);

        Product product = prosc.get(pid);
        content = HtmlUtils.htmlEscape(content);

        User user =(User)  session.getAttribute("user");
        Review review = new Review();
        review.setContent(content);
        review.setPid(pid);
        review.setCreateDate(new Date());
        review.setUid(user.getId());
        resc.add(review);

        return "redirect:forereview?oid="+oid+"&showonly=true";
    }
    @RequestMapping("adminlog")
    public String admin(){
        return "fore/adminLogin";
    }

    @RequestMapping("adminlogin")
    public String adminLogin(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {

        name = HtmlUtils.htmlEscape(name);
        if(name.equals("admin")){
            User user = usc.get(name,password);

            if(null==user){
                model.addAttribute("msg", "账号密码错误");
                return "fore/adminLogin";
            }
            session.setAttribute("user", user);
            return "redirect:/admin_category_list";
        }else{
            model.addAttribute("msg", "不是管理员账户");
            return "fore/adminLogin";
        }

    }

}
