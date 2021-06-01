package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import ENTITY.Product;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
ArrayList list = (ArrayList) request.getAttribute("listProducts");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/home.css\">\n");
      out.write("        <title>Home</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"/ATBMTT/Home\">\n");
      out.write("                        <img src=\"image/login.svg\" alt=\"logo\" width=\"100px\">\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"search-box\">\n");
      out.write("                    <form method=\"get\" class=\"form-search\" id=\"formSearch\">\n");
      out.write("                        <input class=\"search\" name=\"search\" type=\"text\" placeholder=\"Tìm kiếm\">\n");
      out.write("                        <button type=\"submit\" class=\"btn-search\">\n");
      out.write("                            <img src=\"image/search.png\">\n");
      out.write("                        </button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"infor\">\n");
      out.write("                    <div class=\"avatar\">\n");
      out.write("                        <img src=\"image/user-male.png\" width=\"50px\" class=\"circle\">\n");
      out.write("                        <div class=\"user-management\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"/ATBMTT/Manage\">Quản lý bán hàng</a></li>\n");
      out.write("                                <li><a href=\"/ATBMTT/Logout\">Đăng xuất</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"infor-user\">\n");
      out.write("                        <a href=\"#\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("        ");
if(request.getAttribute("search") != null)
            out.print("a");
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"list-product\">\n");
      out.write("                ");
for (int i = 0; i < list.size(); i++) {
                        Product product = (Product) list.get(i);
                        String name = product.getName();
                        if (name.length() > 80) {
                            name = name.substring(0, 80) + "...";
                        }
                        DecimalFormat formatter = new DecimalFormat("###,###,###");
                        String price = formatter.format(product.getPrice()) + " VNĐ";
                
      out.write("\n");
      out.write("                <div class=\"product\" id=\"product-");
      out.print(product.getId());
      out.write("\">\n");
      out.write("                    <img src=\"image/uploads/");
      out.print(product.getImage());
      out.write("\" class=\"image-product\">\n");
      out.write("                    <span class=\"title-product\">");
      out.print(name);
      out.write("</span>\n");
      out.write("                    <span class=\"price-product\">");
      out.print(price);
      out.write("</span>\n");
      out.write("                </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <footer></footer>\n");
      out.write("    </body>\n");
      out.write("    <script src=\"js/home.js\"></script>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
